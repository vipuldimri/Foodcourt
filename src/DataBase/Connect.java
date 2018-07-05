package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Connect 
{
    public static Connection conn ;
    public Connect()throws Exception
    {
        
         conn = null;
	 String url =  "jdbc:mysql://foodcourt.cw0b5ff1vv8q.us-east-2.rds.amazonaws.com:3306/FoodCourt";
	 Class.forName("com.mysql.jdbc.Driver");
	 conn = DriverManager.getConnection (url,"vasant","foodcourt");
	 System.out.println ("Database connection established");

    }
    public static Connection getconnection()
    {
        return conn;
    }  
 
}
