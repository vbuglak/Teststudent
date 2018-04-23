package example2;

import java.sql.*;
import java.util.Properties;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CooL
 */
public class bdconnect {
   
 
    private Connection myConnection;
    
    
    public bdconnect() {

    }

    public void init(){
    
       try{
        Properties connInfo = new Properties();
        connInfo.put("user", "cool");
        connInfo.put("password","asddsa1122");
        connInfo.put("charSet", "UTF-8");
        Class.forName("com.mysql.jdbc.Driver");
        String db="jdbc:mysql://95.73.79.163/student";
        myConnection = DriverManager.getConnection(db,connInfo);
        /*Class.forName("com.mysql.jdbc.Driver");
        myConnection=DriverManager.getConnection(
                "jdbc:mysql://95.73.79.163/student","cool", "asddsa1122"
                );*/
        }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }
    
    
    public Connection getMyConnection(){
        return myConnection;
    }
    
    
    public void close(ResultSet rs){
        
        if(rs !=null){
            try{
               rs.close();
            }
            catch(Exception e){}
        
        }
    }
    
     public void close(java.sql.Statement stmt){
        
        if(stmt !=null){
            try{
               stmt.close();
            }
            catch(Exception e){}
        
        }
    }
     
  public void destroy(){
  
    if(myConnection !=null){
    
         try{
               myConnection.close();
            }
            catch(Exception e){}
         
    }
  }
}


