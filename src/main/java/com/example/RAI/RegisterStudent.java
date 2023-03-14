package com.example.RAI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterStudent {

    public String dbURL = "jdbc:mysql://localhost:3306/daaf_db";
    public String dbuname = "root";
    public String dbpassword = "";
    public String dbdriver = "com.mysql.cj.jdbc.Driver";

    public void loadDriver(String dbdriver) {

        try {

            getClass().forName(dbdriver);

        } catch (ClassNotFoundException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }
    }

    public Connection getConnection() {

        Connection con = null;
        try {
            con = DriverManager.getConnection(dbURL, dbuname, dbpassword);

        } catch (SQLException e) {

// TODO Auto-generated catch block

            e.printStackTrace();
        }
        return con;
    }

    public String insert(Student student ) {

        loadDriver(dbdriver);
        Connection con = getConnection();
        String result = "Data entered successfully!";
        String sql = "insert into students values (?,?,?,?,?,?)";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getProductCode());
            ps.setString(2, student.getDescription());
            ps.setString(3, student.getPrice());
            ps.setString(4, student.getClassification());
            ps.setString(5, student.getSupplier());
            ps.setString(6, student.getAvailability());

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            result = "Data not entered!";
        }
        return result;

    }

}


