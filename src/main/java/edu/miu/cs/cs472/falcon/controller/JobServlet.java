package edu.miu.cs.cs472.falcon.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.miu.cs.cs472.falcon.model.Contact;
import edu.miu.cs.cs472.falcon.model.Job;
import edu.miu.cs.cs472.falcon.model.User;
import edu.miu.cs.cs472.falcon.service.JobService;
import edu.miu.cs.cs472.falcon.service.LocationService;
import edu.miu.cs.cs472.falcon.utils.FactoryMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "JobServlet", urlPatterns = {"/jobs"})
public class JobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (FactoryMethod.isEmpty(action))
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);

        switch (action) {
            case "list":
                String q = request.getParameter("q");
                String location = request.getParameter("location");
                String pageString = request.getParameter("page");
                String limitString = request.getParameter("limit");
                if (q == null || location == null || !FactoryMethod.isNumeric(limitString) || !FactoryMethod.isNumeric(pageString))
                    request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);

                List<Job> jobs = JobService.getJobs(q.toLowerCase(), location.toLowerCase());

                request.setAttribute("q", q);
                request.setAttribute("location", location);

                int page = Integer.parseInt(pageString);
                int limit = Integer.parseInt(limitString);
                int totalPage = jobs.size() % limit != 0 ? jobs.size() / limit + 1 : jobs.size() / limit;
                System.out.println("total page: "+totalPage);
                request.setAttribute("activePage", page);
                request.setAttribute("page", totalPage);
                request.setAttribute("limit", limit);
                request.setAttribute("jobs", jobs.stream().skip((page - 1) * limit).limit(limit).collect(Collectors.toList()));

                int begin = page - 5 > 1 ? page - 5 : 1;
                int end = page + 5 > totalPage ? totalPage : page + 5;

                request.setAttribute("begin", begin);
                request.setAttribute("end", end);

                request.getRequestDispatcher("/WEB-INF/views/job.jsp").forward(request, response);
                break;
            case "search":
                request.getRequestDispatcher("/WEB-INF/views/search-job.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }
    }
}
