package com.example.RAI;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet {

    private String dbURL = "jdbc:mysql://localhost:3306/daaf_db";
    private String dbuname = "root";
    private String dbpass = "";
    private String dbdriver = "com.mysql.cj.jdbc.Driver";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String dbUsername = "", dbPassword = "";
        Connection con = null;
        PrintWriter out = response.getWriter();

        try {
            response.setContentType("text/html");
            getClass().forName(dbdriver);
            con = DriverManager.getConnection(dbURL, dbuname, dbpass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM members where uname='"+ username +"'");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                dbUsername = rs.getString(1).toString();
                dbPassword = rs.getString(2).toString();
            }

            out.println(password);
            if (dbUsername.equals(username) && dbPassword.equals(password))
                response.sendRedirect("memberRegister.jsp");
            else
                response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            out.println(e);
        }
    }
}
