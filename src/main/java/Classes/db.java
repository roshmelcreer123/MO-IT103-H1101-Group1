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
    
    
    // Used to connect to local database, do not touch unless you know what you're doing. This will affect EVERYONE
    public static Connection mycon(){
        
         String jdbcURL = "jdbc:mysql://localhost:3306/motorph"; //pointing to localhost and sql dataabse called "motorph"
         String username = "root"; // default username for apache server, please inform Roshmel if you've changed  it
         String password = ""; // default password for apache server
           
         // Try and catch method to connect to Local Host
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
