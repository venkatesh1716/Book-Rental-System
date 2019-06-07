package com.TrimindTech.BookRental;

import java.sql.*;

public class DisplayRecords {
    public void displayRecords() {
        Connection con = null;
        Statement st = null;
        String query = null;
        ResultSet rs = null;
        try {

            //SQL driver
            /* Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","root");*/

            //mysql driver
            Class.forName("org.gjt.mm.mysql.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vicky18","root","root");
            if (con != null)
                st = con.createStatement();
            //prpeare SQL Query
            query = "select * from bookrental";
            //send and execute SQL Query in Db s/w
            if (st != null)
                rs = st.executeQuery(query);
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
