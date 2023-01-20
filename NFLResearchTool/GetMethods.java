import java.sql.*;
import java.util.*;

/**
 * Write a description of class Methods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GetMethods
{
    public static String capitalize(final String line)
    {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
     
    // Gets Top 50 Receiving leaders
    public static void getRecLeaders()
    {
       String query = "{call getRecLeaders()}";
       ResultSet rs;
       
       try (Connection conn = connect.getConnection(); // Creates a Connection
               CallableStatement stmt = conn.prepareCall(query)) // Define Statement 
        {
            rs = stmt.executeQuery(); // Executes Statement
            while(rs.next())
            {
                System.out.println(String.format("%s. %s (%s) - %s Yards, %s Yards Per Game, %s TDs", 
                rs.getString("RK")
                , rs.getString("PlayerName") 
                , rs.getString("Team")
                , rs.getInt("Yds")
                , rs.getString("YdsGame")
                , rs.getString("TD")));
                
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
           
    }    
    
    // Gets Top 50 Rushing leaders
    public static void getRushLeaders()
    {
       String query = "{call getRushLeaders()}";
       ResultSet rs;
       
       try (Connection conn = connect.getConnection(); // Creates a Connection
               CallableStatement stmt = conn.prepareCall(query)) // Define Statement 
        {
            rs = stmt.executeQuery(); // Executes Statement
            while(rs.next())
            {
                System.out.println(String.format("%s. %s (%s) - %s Yards, %s Yards Per Game, %s TDs", 
                rs.getString("RK")
                , rs.getString("PlayerName")  
                , rs.getString("Team")
                , rs.getString("Yds")
                , rs.getString("YdsGame")
                , rs.getString("TD")));
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
           
    }    
    
    // Gets the Top Players with the most passing yards
    public static void getPassLeaders()
    {
       String query = "{call getPassLeaders()}";
       ResultSet rs;
       
       try (Connection conn = connect.getConnection(); // Creates a Connection
               CallableStatement stmt = conn.prepareCall(query)) // Define Statement 
        {
            rs = stmt.executeQuery(); // Executes Statement
            while(rs.next())
            {
                System.out.println(String.format("%s. %s (%s) - %s Yards, %s Yards Per Game, %s TDs",
                rs.getString("RK")
                , rs.getString("PlayerName")  
                , rs.getString("Team")
                , rs.getInt("Yds")
                , rs.getString("YdsGame")
                , rs.getString("TD")));
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
           
    }    
    
    // Pass Defense 
    public static void getPassDefense()
    {
       String query = "{call getPassDefense()}";
       ResultSet rs;
       
       try (Connection conn = connect.getConnection(); // Creates a Connection
               CallableStatement stmt = conn.prepareCall(query)) // Define Statement 
        {
            rs = stmt.executeQuery(); // Executes Statement
            while(rs.next())
            {
                System.out.println(String.format("%s. %s - %s Yards, %s TDs Allowed, %s Interceptions, %s Sacks", 
                rs.getString("RK") 
                , rs.getString("Team")
                , rs.getString("Yds")
                , rs.getString("TD")
                , rs.getString("Interceptions")
                , rs.getString("Sk")
                ));
                
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
           
    }    
    
    // Rush Defense
    public static void getRushDefense()
    {
       String query = "{call getRushDefense()}";
       ResultSet rs;
       
       try (Connection conn = connect.getConnection(); // Creates a Connection
               CallableStatement stmt = conn.prepareCall(query)) // Define Statement 
        {
            rs = stmt.executeQuery(); // Executes Statement
            while(rs.next())
            {
                System.out.println(String.format("%s. %s - %s Yards, %s Attempts, %s Yards Per Attempt, %s TDs Allowed", 
                rs.getString("RK") 
                , rs.getString("Team")
                , rs.getString("Yds")
                , rs.getString("Att")
                , rs.getString("YdsAttempt")
                , rs.getString("TD")
                ));
                
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
           
    }    
    
    // Team Defense
    public static void getTeamDefense()
    {
       String query = "{call getTeamDefRankings()}";
       ResultSet rs;
       
       try (Connection conn = connect.getConnection(); // Creates a Connection
               CallableStatement stmt = conn.prepareCall(query)) // Define Statement 
        {
            rs = stmt.executeQuery(); // Executes Statement
            while(rs.next())
            {
                System.out.println(String.format("%s. %s - %s Total Yards, %s Points Allowed, %s Takeaways ", 
                rs.getString("RK") 
                , rs.getString("Team")
                , rs.getString("TotalYds")
                , rs.getString("PA")
                , rs.getString("Takeaways")
                ));
                
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
           
    }   
    
    
    
    
}
