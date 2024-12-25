import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DatabaseAccess 
{
	public String[] connectDB(String city, String country)
    {
		
		String[] coordinates = new String[2];
		try
        (
	        // create a database connection
	        Connection connection = DriverManager.getConnection("jdbc:sqlite::resource:"+ getClass().getResource("/" + "worldcities.db").toString(), "", "");
	        Statement statement = connection.createStatement();
        )
        {
	        statement.setQueryTimeout(30);  // set timeout to 30 sec.
	
	        ResultSet rs = statement.executeQuery(STR."select lat, lng from cities WHERE city='\{city}' AND country='\{country}'");
	
	        while(rs.next())
	        {
	            // read the result set
		        coordinates[0] = rs.getString("lat");
		        coordinates[1] = rs.getString("lng");
	        }
	                
	        connection.close();
	        statement.close();
        }
        catch(SQLException e)
        {
	        //e.printStackTrace(System.err);
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
      
        return coordinates;
    }
}
