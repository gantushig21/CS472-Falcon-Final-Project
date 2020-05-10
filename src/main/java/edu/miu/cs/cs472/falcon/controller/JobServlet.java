package edu.miu.cs.cs472.falcon.controller;

import edu.miu.cs.cs472.falcon.model.Job;
import edu.miu.cs.cs472.falcon.service.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "JobServlet", urlPatterns = {"/job"})
public class JobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> jobs = JobService.getJobs();
        for (Job job: jobs) {
            response.getWriter().print(job.getCompany());
        }
    }
}
