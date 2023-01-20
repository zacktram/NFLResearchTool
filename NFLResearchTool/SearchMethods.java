import java.sql.*;
import java.util.*;
/**
 * Write a description of class SearchMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SearchMethods
{
    static int count = 0;
    // Gets players on a given team
    // @param team - the abbreviation of the desired team. Ex) NE for New England
    public static void searchTeamRoster(String team)
    {
       String query = "{call searchTeamRoster(?)}";
       ResultSet rs;
       
       try (Connection conn = connect.getConnection(); // Creates a Connection
               CallableStatement stmt = conn.prepareCall(query)) // Define Statement 
        {
            stmt.setString(1, team); 
            rs = stmt.executeQuery(); // Executes Statement
            System.out.println("Players on " + team);
            System.out.println();
            while(rs.next())
            {
                System.out.println(String.format("%s - %s", 
                rs.getString("PlayerName"),
                rs.getString("Pos")));
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
       System.out.println("");    
    } 
    
    public static void searchPlayer(String name)
    {
       String query = "{call searchPlayerName(?)}";
       ResultSet rs;   
       try (Connection conn = connect.getConnection(); // Creates a Connection
               CallableStatement stmt = conn.prepareCall(query)) // Define Statement 
        {
            stmt.setString(1, name); 
            rs = stmt.executeQuery(); // Executes Statement
            System.out.println("Players with " + GetMethods.capitalize(name) + " in their name");
            System.out.println();
           
            while(rs.next())
            {
                   ++count; 
                   System.out.println(String.format(count + ". %s (%s) - %s", 
                   rs.getString("PlayerName")
                   , rs.getString("Team")
                   , rs.getString("Pos")));  
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("");
        System.out.println("Numbers of Players Found: " + count);
    } 
    
    public static void searchPlayerStats(String playerName)
    {
       String query = "{ call searchPlayerStats(?) }";
       ResultSet rs;
       try (Connection conn = connect.getConnection(); // Creates a Connection
               CallableStatement stmt = conn.prepareCall(query)) // Define Statement 
        {
            stmt.setString(1, playerName);
            rs = stmt.executeQuery(); // Executes Statement
            while(rs.next())
            {
                System.out.println(String.format("%s - %s Total Yards, %s Yards Per Game, %s Total Touchdowns", 
                rs.getString("PlayerName") + " "
                , rs.getString("Total_Yards")
                , rs.getString("Yards_Per_Game")
                , rs.getString("Total_TDs")));
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
       System.out.println("");    
    }   
}
