package com.TrimindTech.BookRental;

import java.sql.*;

public class DisplayRecords {
    public void displayRecords() {
        Connection con = null;
        Statement st = null;
        String query = null;
        ResultSet rs = null;
        try {
            //register jdbc driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //establish the connection
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
            //create STatement object
            if (con != null)
                st = con.createStatement();
            //prpeare SQL Query
            query = "SELECT * FROM BOOKRental";
            //send and execute SQL Query in Db s/w
            if (st != null)
                rs = st.executeQuery(query);
            //process the ResultSet
            if (rs != null) {
                rs.next();
                System.out.println("Author name=" + rs.getString(1) + "  " + "book title=" + rs.getString(2) + "  " + "ISBN=" + rs.getInt(3) + " " + "IsACAdemic=" + rs.getString(4) + " " + "stock=" + rs.getInt(5));
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        } finally {
            //closing objects
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

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
        }
    }
}
