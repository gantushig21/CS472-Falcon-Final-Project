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

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String staticResourcesURI = request.getContextPath() + "/fragments";
        String loginURI = request.getContextPath() + "/login";
        String homeURI = request.getContextPath() + "/home";
        String registerURI = request.getContextPath() + "/register";
        String searchURI = request.getContextPath() + "/search";

        boolean loggedIn = session != null && session.getAttribute("loggedUser") != null;
        boolean loginRequest = request.getRequestURI().contains(loginURI)
                || request.getRequestURI().contains(registerURI)
                || request.getRequestURI().contains(searchURI)
                || request.getRequestURI().contains(homeURI)
                || request.getRequestURI().contains(staticResourcesURI);

        if (loggedIn || loginRequest) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(homeURI);
        }

    }

    @Override
    public void destroy() {

    }
}