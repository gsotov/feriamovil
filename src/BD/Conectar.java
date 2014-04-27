/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class Conectar {
    private static String db = "final";
    private static String user = "root";
    private static String pass = "";
    private static String url="jdbc:mysql://localhost:3306/final?zeroDateTimeBehavior=convertToNull";
    private static Connection Conn;
    
        public static Connection getConnection(){
        try{
         Class.forName("com.mysql.jdbc.Driver");
            Conn = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null,"Conectada");
            
        }catch(Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error  base de dato " + e.getMessage());
        }
    return Conn;
    }
}
