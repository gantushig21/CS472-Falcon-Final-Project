package edu.miu.cs.cs472.falcon.filter;

import edu.miu.cs.cs472.falcon.model.User;
import edu.miu.cs.cs472.falcon.util.AppUtils;
import edu.miu.cs.cs472.falcon.util.SecurityUtils;
import edu.miu.cs.cs472.falcon.util.UserRoleRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/*")
public class SecurityFilter implements Filter {



    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        // User information stored in the Session. (After successful login).
        User loggedUser = AppUtils.getLoggedUser(request.getSession());
        if (servletPath.equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        HttpServletRequest wrapRequest = request;

        if (loggedUser != null) {
            String userName = loggedUser.getUsername();
            // Roles
            String role = loggedUser.getRole();

            // Wrap old request by a new Request with userName and Roles information.
            wrapRequest = new UserRoleRequestWrapper(userName, role, request);
        }
        // Pages must be signed in.
        if (SecurityUtils.isSecurityPage(request)) {

            // If the user is not logged in, Redirect to the login page.
            if (loggedUser == null) {
                String requestUri = request.getRequestURI();

                // Store the current page to redirect to after successful login.
                int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);

                response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }

            // Check if the user has a valid role?
            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {

                RequestDispatcher dispatcher //
                        = request.getServletContext().getRequestDispatcher("login");

                dispatcher.forward(request, response);
                return;
            }
        }

        filterChain.doFilter(wrapRequest, response);
    }


    public void destroy() {

    }
}