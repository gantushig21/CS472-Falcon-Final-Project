package edu.miu.cs.cs472.falcon.controller;

import edu.miu.cs.cs472.falcon.model.User;
import edu.miu.cs.cs472.falcon.service.LoginService;
import edu.miu.cs.cs472.falcon.service.UserService;
import edu.miu.cs.cs472.falcon.util.AppUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/login")
public class LoginController extends HttpServlet {
    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        if (loginService.authenticateUser(userName, password)) {
            User user = loginService.getUserByUserName(userName);
            AppUtils.storeLoggedUser(session, user);
            response.sendRedirect("login");

        } else {
            String errorMessage = "<span style='color:red;font-size:1em'> Invalid UserName/Password !!!</span>";
            request.setAttribute("errMsg", errorMessage);
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    // Get the user information stored in the session.
    public static User getLoggedUser(HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        return loggedUser;
    }
}
