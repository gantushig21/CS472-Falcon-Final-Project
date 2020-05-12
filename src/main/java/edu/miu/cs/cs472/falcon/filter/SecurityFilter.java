package edu.miu.cs.cs472.falcon.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/*")
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {  }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String cssURI = request.getContextPath() + "/css";
        String jsURI = request.getContextPath() + "/js";
        String imgURI = request.getContextPath() + "/img";
        String libURI = request.getContextPath() + "/lib";
        String staticResourcesURI = request.getContextPath() + "/fragments";
        String loginURI = request.getContextPath() + "/login";
        String homeURI = request.getContextPath() + "/home";
        String registerURI = request.getContextPath() + "/register";
        String aboutURI = request.getContextPath() + "/about-us";
        String searchURI = request.getContextPath() + "/search";

        boolean loggedIn = session != null && session.getAttribute("loggedUser") != null;
        boolean loginRequest = request.getRequestURI().contains(loginURI)
                || request.getRequestURI().contains(registerURI)
                || request.getRequestURI().contains(searchURI)
                || request.getRequestURI().contains(homeURI)
                || request.getRequestURI().contains(cssURI)
                || request.getRequestURI().contains(jsURI)
                || request.getRequestURI().contains(libURI)
                || request.getRequestURI().contains(imgURI)
                || request.getRequestURI().contains(aboutURI)
                || request.getRequestURI().contains(staticResourcesURI);

        if (loggedIn || loginRequest) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(homeURI);
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

    @Override
    public void destroy() {

    }
}