package com.example.RAI;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "StudentSaveToDB", value = "/StudentSaveToDB")
public class StudentSaveToDB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();

        try {
            StudentRegister studentRegister= new StudentRegister();

            response.setContentType("text/html");
            studentRegister.loadDriver(studentRegister.dbdriver);

            Connection con = studentRegister.getConnection();

            String studentNumber = request.getParameter("studentNumber");
            String firstName= request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String birthDate= request.getParameter("birthDate");
            String course = request.getParameter("course");
            String houseNum = request.getParameter("houseNum");
            String street = request.getParameter("street");
            String barangay = request.getParameter("barangay");
            String city = request.getParameter("city");
            String address = houseNum +" "+ street + " "+ barangay+ " "+ city;



            Students students = new Students (studentNumber, firstName, lastName,  birthDate, address, course);

            studentRegister.insert(students);

            PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            out.println("<html><body><table border=1><tr>" +
                    "<td>Student Number</td>" +
                    "<td>First Name</td>" +
                    "<td>Last Name</td>" +
                    "<td>Birthdate</td>" +
                    "<td>Address</td>" +
                    "<td>Course</td></tr>");



            while (rs.next()) {

                out.println("<tr><td>" + rs.getString(1) + "</td><td>"
                        + rs.getString(2) + "</td><td>" + rs.getString(3)
                        + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5)
                        +  "</td><td>" + rs.getString(6) + "</td></tr>");

            }
            out.println("</table></body></html>");

        } catch (Exception e) {

            e.printStackTrace();

            out.println(e);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
