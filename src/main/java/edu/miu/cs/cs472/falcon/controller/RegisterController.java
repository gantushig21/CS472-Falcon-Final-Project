package edu.miu.cs.cs472.falcon.controller;

import edu.miu.cs.cs472.falcon.model.User;
import edu.miu.cs.cs472.falcon.repository.UserRepository;
import edu.miu.cs.cs472.falcon.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        UserService userService = new UserService();
        //try{
            User user = new User(firstName, lastName, email, username, password, gender);
            userService.registerUser(user);
            System.out.println(UserRepository.getUsers());
            response.sendRedirect("login");
       // }catch (Exception e){
       //     e.printStackTrace();
       // }
    }
}
