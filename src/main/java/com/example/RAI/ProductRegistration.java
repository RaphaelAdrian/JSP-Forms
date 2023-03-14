package com.example.RAI;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductRegistration", value = "/ProductRegistration")
public class ProductRegistration extends HttpServlet {
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

        Product product = new Product (productCode, description, price ,classification, supplier, available);
        RegisterProduct registerProduct= new RegisterProduct();
        String result = registerProduct.insert(product);
        response.getWriter().println(result);



    }
}
