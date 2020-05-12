package edu.miu.cs.cs472.falcon.controller;

import com.google.gson.JsonObject;
import edu.miu.cs.cs472.falcon.model.Contact;
import edu.miu.cs.cs472.falcon.model.Job;
import edu.miu.cs.cs472.falcon.model.User;
import edu.miu.cs.cs472.falcon.service.JobService;
import edu.miu.cs.cs472.falcon.service.LocationService;
import edu.miu.cs.cs472.falcon.utils.AppUtils;
import edu.miu.cs.cs472.falcon.utils.FactoryMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "PostServlet", urlPatterns = {"/posts"})
public class PostServlet extends HttpServlet {
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
        User user = AppUtils.getLoggedUser(request.getSession());

        Contact contact = new Contact(user.getFirstName() + " " + user.getLastName(), user.getPhone(), user.getEmail());
        request.setAttribute("contact", contact);
        request.getRequestDispatcher("/WEB-INF/views/add-job.jsp").forward(request, response);
    }
}
