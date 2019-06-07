package com.TrimindTech.BookRental;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
public class ConnTest {
    public static void main(String args[])throws Exception
    {
        oracle.jdbc.driver.OracleDriver driver=new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(driver);
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","ROOT");
        if(con==null)
        {
            System.out.println("Connection is not established");
        }else{
            System.out.println("connection established");
        }
    }
    }
