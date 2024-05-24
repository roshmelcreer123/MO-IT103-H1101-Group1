/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class db {
    
    public static Connection mycon(){
        
         String jdbcURL = "jdbc:mysql://localhost:3306/motorph";
         String username = "root";
         String password = "";
           
         
         try{
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to the database");
            return con;
            
         } catch(SQLException ex){
             ex.printStackTrace();
             return null; // Return null if connection fails
         }

    }
    
}
