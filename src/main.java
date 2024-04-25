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
public class main {
    public static void main(String[] args){
 
 
       Statement cmd; 
      connection con;
        ResultSet res;

        try {            
            con = new connection();
      cmd = con.c.createStatement();
                       res = cmd.executeQuery("SELECT * FROM tunisie;");

                               System.out.println("ci bonnn");
          System.out.println( res.getString("gouvernement"));
        } catch (ClassNotFoundException ex) {
            System.out.println("faiiiiiiiiil");
        }
     catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    

        } 
}
