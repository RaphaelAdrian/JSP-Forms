package com.example.RAI;

import java.io.IOException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentRegistration", value = "/StudentRegistration")
public class StudentRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        String productCode = request.getParameter("productCode");
        String description= request.getParameter("description");
        String price = request.getParameter("price");
        String classification= request.getParameter("classification");
        String[] avail = request.getParameterValues("availability");
        String supplier = request.getParameter("supplier");
        out.print("\nProduct Code: "+ productCode+
                "\nDescription: " + description +
                "\nPrice: " + price +
                "\nClassification: " + classification +
                "\nAvailability: " );

        String available = "";
        for(String availability: avail)
        {
            available += availability + " ";
            out.print(availability + " ");
        }
        out.print("\nSupplier: " + supplier +"\n");

        Student student = new Student (productCode, description, price ,classification, supplier, available);
        RegisterStudent registerStudent= new RegisterStudent();
        String result = registerStudent.insert(student);
        response.getWriter().println(result);



    }
}
