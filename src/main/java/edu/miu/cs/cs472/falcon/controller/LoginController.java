package edu.miu.cs.cs472.falcon.controller;

import edu.miu.cs.cs472.falcon.model.User;
import edu.miu.cs.cs472.falcon.service.LoginService;
import edu.miu.cs.cs472.falcon.utils.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        LoginService loginService = new LoginService();
        HttpSession session = request.getSession();

        if (loginService.authenticateUser(userName, password)) {
            User user = loginService.getUserByUserName(userName);
            System.out.println(user.getRole());
            AppUtils.storeLoggedUser(session, user);
            response.sendRedirect("home");
        } else {
            String errorMessage = "<span style='color:red;font-size:1em'> Invalid UserName/Password !!!</span>";
            request.setAttribute("errMsg", errorMessage);
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }


}
