package com.TrimindTech.BookRental;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertionData {
    public  void insertTest() {
        Scanner sc = null;
        String Authname = null, title = null, academic = null;
        int sid = 0, ISBN = 0, totalCount = 0;
        Connection con = null;
        Statement st = null;
        String query = null;
        int count = 0;
        //read inputs
        try {
            sc = new Scanner(System.in);
            if (sc != null) {
                System.out.println("Enter author name::");
                Authname = sc.next();
                Authname = "'" + Authname + "'";
                System.out.println("Enter book title::");
                title = sc.next();
                title = "'" + title + "'";
                System.out.println("Enter book ISBN::");
                ISBN = sc.nextInt();
                System.out.println("Enter FALSE for NonAcademic & TRUE for Academic::");
                academic = sc.next();
                academic = "'" + academic + "'";
                System.out.println("Enter book stock::");
                totalCount = sc.nextInt();
            }


            //SQL driver
            /* Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","root");*/

            //mysql driver
            Class.forName("org.gjt.mm.mysql.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vicky18","root","root");
            if (con != null)
                st = con.createStatement();
            query = " INSERT INTO BookRental VALUES(" + Authname + "," + title + "," + ISBN + "," + academic + "," + totalCount + ")";
            System.out.println(query);
            if (st != null)
                count = st.executeUpdate(query);

            //process the result
            if (count == 0)
                System.out.println("Record not inserted");
            else
                System.out.println("Record inserted");
        }//try
        catch (SQLException se) {
            se.printStackTrace();
            System.out.println("Record not inserted");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        } catch (Exception e) {
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

