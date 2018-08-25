package foodcourt;
import DataBase.Connect;
import DataBase.FoodCourtFactory;
import DataBase.FoodCourtMainInterface;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ConnectionBackgroundThread extends Thread
{
    
    public String Id="";
    public String Name="";
    public ArrayList<Users> users;
    public FoodCourtModel FoodCourt;
    
    @Override
    public void run()
    {
        
        try 
        {
            MyLog.setup();
            FactoryClass.createObjects();
            Connect connection = new Connect();
            Properties prop2 = new Properties();
	   // prop2.load(new FileInputStream("C://stark//FoodCourt//config.properties"));
            prop2.load(new FileInputStream("C://Foodcourt//config.properties"));
            Id = prop2.getProperty("ID");       
            Name = prop2.getProperty("Name");
            
        } catch (Exception ex) 
        {
            System.out.println("Error Unable to connect to server "+ex);
            System.exit(0);
        }
        try
        {
            FoodCourtMainInterface Dao = FoodCourtFactory.GetInstance();
            FoodCourt = Dao.GetFoodCourtDetails(Id);
            users = Dao.GetUsers(Name);        
        }catch(Exception e)
        {
            System.out.println("Error getting data :: "+e);
        }
    
    
    }
    
    
}
