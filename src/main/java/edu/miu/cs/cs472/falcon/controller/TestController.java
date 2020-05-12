package edu.miu.cs.cs472.falcon.controller;

import edu.miu.cs.cs472.falcon.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestController", urlPatterns = {"/users"})
public class TestController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", UserRepository.getUsers());
        request.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(request,response);
    }
}
