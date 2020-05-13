package edu.miu.cs.cs472.falcon.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.miu.cs.cs472.falcon.service.JobService;
import edu.miu.cs.cs472.falcon.service.LocationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StatesServlet", urlPatterns = {"/cities"})
public class CitiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");

        List<String> list = LocationService.getCities(search);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        Gson gson = new Gson();
        JsonObject myObj = new JsonObject();

        JsonElement cities = gson.toJsonTree(list);
        myObj.addProperty("success", true);
        myObj.add("cities", cities);

        out.println(myObj.toString());
        out.close();
    }
}

