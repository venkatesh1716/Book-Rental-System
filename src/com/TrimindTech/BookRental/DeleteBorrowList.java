package com.TrimindTech.BookRental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteBorrowList {

    public void deleteBorrowLists() {
        Scanner sc = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        String title = null, cond = null;
        int noOfDaysLoan = 0;
        Connection con = null;
        Statement st = null;
        String query1 = null;
        int count = 0;
        //read inputs
        try {
            sc = new Scanner(System.in);
            if (sc != null) {
                System.out.println("Enter Book Title::");
                title = sc.next();
                title = "'" + title + "'";
            }
            cond = "('" + title + "')";
            System.out.println(cond);


            /*    SQL driver
             Class.forName("oracle.jdbc.driver.OracleDriver");
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","root");*/

            //mysql driver
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vicky18", "root", "root");
            if (con != null)
                st = con.createStatement();
            query1 = " DELETE FROM borrowerFile WHERE TITLE=" + cond;

            System.out.println(query1);
            if (st != null)
                count = st.executeUpdate(query1);

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
