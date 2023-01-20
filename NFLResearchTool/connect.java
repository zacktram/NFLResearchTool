import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
import javax.swing.*;
public class connect
{
      private Connection conn;  
      private Statement st;
      private ResultSet rs;
      
      //Constructor 
      public static Connection getConnection() throws SQLException {
         Connection conn = null;
         try {
             String url = "jdbc:mysql://127.0.0.1:3306/finalproject_cs286";
             String user = "root";
             String password = "Zz!135790123";
             
             conn = DriverManager.getConnection(url, user, password);
             } catch(SQLException e) {
                 JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return conn; 
    }
      
    
}