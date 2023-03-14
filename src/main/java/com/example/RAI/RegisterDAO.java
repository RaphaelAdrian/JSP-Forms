package com.example.RAI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterDAO {

    private String dbURL = "jdbc:mysql://localhost:3306/daaf_db";
    private String dbuname = "root";
    private String dbpassword = "";
    private String dbdriver = "com.mysql.cj.jdbc.Driver";

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

    public String insert(Member member) {

        loadDriver(dbdriver);
        Connection con = getConnection();
        String result = "Data entered successfully!";
        String sql = "insert into members values(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, member.getUname());
            ps.setString(2, member.getPassword());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getPhone());ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            result = "Data not entered!";
        }
        return result;

    }

}
