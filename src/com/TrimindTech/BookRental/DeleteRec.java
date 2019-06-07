package com.TrimindTech.BookRental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DeleteRec {
    public void DeleteRec(){
        Scanner sc=null;
        String authNames=null;
        Connection con=null;
        Statement st=null;
        String query=null;
        int count=0;
        String cond=null;
        //read inputs
        try{
            sc=new Scanner(System.in);
            if(sc!=null){
                System.out.println("Enter Author Name::");
                authNames=sc.next();
            }
            cond="('"+authNames+"')";
            System.out.println(cond);


            //SQL driver

            /* Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","root");*/

            //mysql driver

            Class.forName("org.gjt.mm.mysql.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vicky18","root","root");            if(con!=null)
                st=con.createStatement();
            //prepare query
            query="DELETE FROM BOOKRENTAL WHERE AUTHNAME ="+cond;
            System.out.println(query);
            //send and execute SQL Query
            if(st!=null)
                count=st.executeUpdate(query);
            //process the result
            if(count==0)
                System.out.println("Record not found for deletion");
            else
                System.out.println(count+" no.of Records are found  and deleted");
        }//try
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(ClassNotFoundException cnf){
            cnf.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            //close jdbc objs
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

            try{
                if(sc!=null)
                    sc.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }//finally

    }//main
}//class

