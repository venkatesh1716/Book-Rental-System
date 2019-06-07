package com.TrimindTech.BookRental;

import java.sql.*;
import java.util.Scanner;

public class DisplayBorrowList {

        public void DisplayBList() {

                    Connection con=null;
                    Statement st=null;
                    ResultSet rs=null;
                    Boolean flag=false;
                    Scanner sc = null;
                    String firstName = null;
                    String lastName = null;
                    String email = null;
                    String title = null, cond = null;
                    int noOfDaysLoan = 0;
                    String query = null;
            int count = 0;
            cond = "('" + title + "')";
            System.out.println(cond);

            try{
                        Class.forName("org.gjt.mm.mysql.Driver");
                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vicky18","root","root");
                      //  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","dcme");

                        if(con!=null)
                            st=con.createStatement();
                        rs=st.executeQuery("select firstName,lastName,email,title,noOfDaysLoan from borrowerFile where title="+cond);
                        if(rs!=null){
                            while(rs.next()){
                                System.out.println(rs.getString(1)+" "+rs.getString(2)+" " +rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
                                flag=true;
                            }
                        }
                        if(!flag){
                            System.out.println("records not found");
                        }
                    }// try close
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    finally{
                        try{
                            if(rs!=null)
                                rs.close();
                        }
                        catch(SQLException se){
                            se.printStackTrace();
                        }
                        try{

                            if(st!=null)
                                st.close();
                        }
                        catch(SQLException se){
                            se.printStackTrace();
                        }
                        try{

                            if(con!=null)
                                con.close();
                        }
                        catch(SQLException se){
                            se.printStackTrace();
                        }
                    }

                }
            }




