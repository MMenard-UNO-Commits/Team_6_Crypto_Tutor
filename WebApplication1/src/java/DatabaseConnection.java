import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
  
// This class can be used to initialize the database connection
public class DatabaseConnection {
    protected static Connection initializeDatabase()
        throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "104.131.172.9";
        // Database name to access
        String dbName = "ctutordb";
        String dbUsername = "cpack";
        String dbPassword = "ctutoR123!";// hard coded so we know how to format the connection to the url
  
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection("jdbc:mysql://104.131.172.9/ctutordb","cpack","ctutoR123!");// can use the variables if we format the end string to be like the one used here
        return con;
    }
}