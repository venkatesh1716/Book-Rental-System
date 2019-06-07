package com.TrimindTech.BookRental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBBorrowerList {

    public void insertBorrowLIST() {

        Scanner sc = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        String title = null, cond = null;
        int noOfDaysLoan = 0;
        Connection con = null;
        Statement st = null;
        String query = null;
        int count = 0;
        //read inputs
        try {
            sc = new Scanner(System.in);
            if (sc != null) {
                System.out.println("Enter first name::");
                firstName = sc.next();
                firstName = "'" + firstName + "'";
                System.out.println("Enter last name:");
                lastName = sc.next();
                lastName = "'" + lastName + "'";
                System.out.println("Enter Email:");
                email = sc.next();
                email = "'" + email + "'";
                System.out.println("Enter Book Title::");
                title = sc.next();
                title = "'" + title + "'";

                System.out.println("Enter number of days loan:");
                noOfDaysLoan = sc.nextInt();
            }


            /*    SQL driver
             Class.forName("oracle.jdbc.driver.OracleDriver");
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","root");*/

            //mysql driver
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vicky18", "root", "root");
            if (con != null)
                st = con.createStatement();
            query = " INSERT INTO borrowerFile VALUES(" + firstName + "," + lastName + "," + email + "," + title + "," + noOfDaysLoan + ")";


            System.out.println(query);
            if (st != null)
                count = st.executeUpdate(query);

            //process the result
            if (count == 0)
                System.out.println("Record not insertion failed");
            else
                System.out.println("Book is rented successfully");
        }//try
        catch (Exception e) {
            System.out.println("Record not inserted");
            e.printStackTrace();
        } finally {
            //close jdbc objects
            try {
                if (st != null)
                    st.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (sc != null)
                    sc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }//finally
    }

}
