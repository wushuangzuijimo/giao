package com.woniuxy.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {


    public static void main(String[] args) {


        Connection conn =null;


        long starttiem = System.currentTimeMillis();


        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userx";
            String username = "root";
            String password="zxczxc";

            conn= DriverManager.getConnection(url,username,password);


            System.out.println(conn);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        long endtime = System.currentTimeMillis();


        System.out.println(endtime-starttiem);


    }
}
