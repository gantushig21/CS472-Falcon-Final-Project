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
        String company = request.getParameter("company-name");
        String title = request.getParameter("title");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String skills = request.getParameter("skills");
        String status = request.getParameter("job-status");
        String description = request.getParameter("job-description");

        String recruiterName = request.getParameter("recruiter-name");
        String recruiterPhoneNumber = request.getParameter("recruiter-phone");
        String recruiterEmail = request.getParameter("recruiter-email");

        JsonObject myObj = new JsonObject();
        if (FactoryMethod.isEmpty(company) || FactoryMethod.isEmpty(title) || FactoryMethod.isEmpty(state) || FactoryMethod.isEmpty(city) ||
            FactoryMethod.isEmpty(skills) || FactoryMethod.isEmpty(status) || FactoryMethod.isEmpty(description) || FactoryMethod.isEmpty(recruiterName) ||
            FactoryMethod.isEmpty(recruiterPhoneNumber) || FactoryMethod.isEmpty(recruiterEmail)) {
            myObj.addProperty("success", false);
        } else {

//        System.out.println(company + " " + title + " " + state + " " + city + " " + skills + " " + status + " " + description + " " + recruiterName + " " + recruiterPhoneNumber + " " + recruiterEmail);

            Job newJob = new Job(
                    company.trim(),
                    status.trim(),
                    description.trim(),
                    (city + ", " + LocationService.getShortState(state)).trim(),
                    title.trim(),
                    new Date(), "",
                    skills.trim(),
                    new Contact(recruiterName, recruiterPhoneNumber, recruiterEmail));

            JobService.addJob(newJob);
            System.out.println(newJob);
            myObj.addProperty("success", true);
        }
        PrintWriter out = response.getWriter();

        out.println(myObj.toString());
        out.close();
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
            case "add":
                Contact contact = new Contact("Tony Stark", "(202) 555-1234", "stark@gmail.com");
                request.setAttribute("contact", contact);
                request.getRequestDispatcher("/WEB-INF/views/add-job.jsp").forward(request, response);
                break;
            case "search":
                request.getRequestDispatcher("/WEB-INF/views/search-job.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }
    }
}
