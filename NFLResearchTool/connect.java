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
      
      // Constructor 
      public static Connection getConnection() throws SQLException {
         Connection conn = null;
         try {
             // Enter url path of the included NFL database
             String url = "**********";
             
             // Enter username to SQL Server
             String user = "*******";
             
             // Enter password to SQL Server  
             String password = "********";
             
             conn = DriverManager.getConnection(url, user, password);
             } catch(SQLException e) {
                 JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return conn; 
    }
      
    
}