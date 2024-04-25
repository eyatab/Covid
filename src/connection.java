/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandemieprojet;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class connection {   
    public Connection c;
public connection() throws ClassNotFoundException {
       try {    
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/pandemie?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            String username = "root";
            String password = "13021458";
            c =  DriverManager.getConnection(url,username,password);
            System.out.println("sucess");
        } catch (SQLException ex) {
            System.out.println("fail");
            System.out.println(ex.getMessage());
        }

}
}
         