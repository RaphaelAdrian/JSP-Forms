package com.example.RAI;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "FetchRecords", value = "/FetchRecords")
public class FetchRecords extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();

        try {
            RegisterProduct registerProduct= new RegisterProduct();

            response.setContentType("text/html");
            registerProduct.loadDriver(registerProduct.dbdriver);

            Connection con = registerProduct.getConnection();

            String productCode = request.getParameter("productCode");
            String description= request.getParameter("description");
            String price = request.getParameter("price");
            String classification= request.getParameter("classification");
            String[] avail = request.getParameterValues("availability");
            String supplier = request.getParameter("supplier");
            out.print("NEW INPUT = Product Code: "+ productCode+
                    " Description: " + description +
                    " Price: " + price +
                    " Classification: " + classification +
                    " Availability: " );

            String available = "";

            for(String availability: avail)
            {
                available += availability + " ";
                out.print(availability + " ");
            }

            out.print("\nSupplier: " + supplier +"\n");

            Product product = new Product (productCode, description, price ,classification, supplier, available);

            registerProduct.insert(product);

            PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            out.println("<html><body><table border=1><tr>" +
                    "<td>Product Code</td>" +
                    "<td>Description</td>" +
                    "<td>Price</td>" +
                    "<td>Classification</td>" +
                    "<td>Supplier</td>" +
                    "<td>Availability</td></tr>");



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
}
