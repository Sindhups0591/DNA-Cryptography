/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnafinal;

import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HITSPL
 */
public class DataBase {
    public static Connection con ;
    
    public static Connection getConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
       con = DriverManager.getConnection("jdbc:derby://localhost:1527/dna");
       
        return con;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
     
    }
    public static int checkLogin(String username, String password)
    {
        try
        {
            getConnection();
             Statement st = con.createStatement();
      ResultSet res = st.executeQuery("select * from reg where username='"+username+"' and password='"+password+"'");
      while(res.next()){
          Login.name1=res.getString("name");
          Login.id1=res.getString("id");
         Login.uname1=res.getString("username");
         return 1;
        }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
             return 0;
        }
        return 0;
    }
    public static int insertIntoRegister(String name, String gender,String phone, String location,String username,String pass )
    {
        try
        {
            getConnection();
             Statement  stmt = con.createStatement();
                    
                    String sql = "INSERT INTO Reg(name,gender,phonenumber,location,username,password) Values('"+name+"','"+gender+"','"+phone+"','"+location+"','"+username+"','"+pass+"') ";
                    int check=stmt.executeUpdate(sql);
                    return check;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }
    public static ResultSet getUserProfile(String uname)
    {
        try
        {
              getConnection();
        PreparedStatement pst =  con.prepareStatement("select * from userdetails where receiver='"+uname+"' ");  
       ResultSet rs =  pst.executeQuery();
       return rs;
        }
        catch(Exception ex)
        {
            return null;
        }
      
    }
    public static ResultSet getMessage(String uname)
            
    {
        try
        {
            getConnection();
            PreparedStatement pst = con.prepareStatement("select * from userdetails where sender='"+uname+"' ");  
      ResultSet rs = pst.executeQuery();  
      return rs;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
      public static int insertIntoUserDetails(String send, String rec,String dt1,String subject, String time,String msg,String id )
    {
        try
        {
            getConnection();
               Statement  stmt = con.createStatement();
                    
                    String sql = "INSERT INTO userdetails(sender,receiver,subject,senddate,sendtime,message,r_id) Values('"+send+"','"+rec+"','"+subject+"','"+dt1+"','"+time+"','"+msg+"','"+id+"') ";
                 int check=stmt.executeUpdate(sql);
                    return check;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }
      
       public static int checkIfEmail(String username)
    {
        try
        {
            getConnection();
             Statement st = con.createStatement();
      ResultSet res = st.executeQuery("select * from reg where username='"+username+"' ");
      while(res.next()){
         
         return 1;
        }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
             return 0;
        }
        return 0;
    }
}
