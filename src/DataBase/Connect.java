package DataBase;
import foodcourt.MyLog;
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
        try
        {
         conn = null;
	 //String url =  "jdbc:mysql://foodcourt.cw0b5ff1vv8q.us-east-2.rds.amazonaws.com:3306/FoodCourt";
	 String url =  "jdbc:mysql://localhost:3306/FoodCourt";
         Class.forName("com.mysql.jdbc.Driver");
	 //conn = DriverManager.getConnection (url,"vasant","foodcourt");
         conn = DriverManager.getConnection (url,"root","vasant");
	 System.out.println ("Database connection established");
        }
        catch(Exception ex)
        {
            MyLog.getLogger().severe(ex.getMessage());
        }

    }
    public static Connection getconnection()
    {
        return conn;
    }  
 
}
