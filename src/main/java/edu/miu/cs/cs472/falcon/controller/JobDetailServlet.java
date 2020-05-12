package edu.miu.cs.cs472.falcon.controller;

import edu.miu.cs.cs472.falcon.model.Job;
import edu.miu.cs.cs472.falcon.service.JobService;
import edu.miu.cs.cs472.falcon.utils.FactoryMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JobDetailsServlet", urlPatterns = {"/jobs/detail"})
public class JobDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (FactoryMethod.isEmpty(id))
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);

        Job job = JobService.getJobById(id);

        request.setAttribute("job", job);
        request.getRequestDispatcher("/WEB-INF/views/job-detail.jsp").forward(request, response);
    }
}

