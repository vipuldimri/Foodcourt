
package DataBase;

import foodcourt.FoodCourtModel;
import foodcourt.MyLog;
import foodcourt.Settings;
import foodcourt.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import foodcourt.UpdateInfo;

public class FoodCourtMainImplementation implements FoodCourtMainInterface
{
    Connection conn;
    FoodCourtMainImplementation(){
       conn = Connect.getconnection();
    }
    @Override
    public ArrayList<Users> GetUsers(String Name) throws Exception {
        ArrayList<Users> users = new ArrayList<>();
        String Query="select * from "+Name+"_Users ";
        try
        {
                   Statement stmt=conn.createStatement();  
                   ResultSet rs = stmt.executeQuery(Query);
                   while(rs.next())  
                   {
                  Users user  = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                  users.add(user);
                   }
        }
        catch(Exception ex)
        {
            MyLog.getLogger().severe(ex.getMessage());
        }
        return users;
    }
    @Override
    public FoodCourtModel GetFoodCourtDetails(String ID) throws Exception {
     // FoodCourtModel f = new FoodCourtModel(ID, Name, Contact, Address, Owner, ID, ID, SubEnd, Email)
        String query = "select * from FoodCourts where ID = "+ID+"";
        
         FoodCourtModel f = null;
         try
         {
                   Statement stmt=conn.createStatement();  
                   ResultSet rs = stmt.executeQuery(query);
                   while(rs.next())  
                   {
                       f = new FoodCourtModel(rs.getInt(1),rs.getString(2),rs.getString(5),rs.getString(3),rs.getString(4),rs.getDate(8),rs.getString(9));
                   }
         }
         catch(Exception ex)
         {
             MyLog.getLogger().severe(ex.getMessage());
         }
        return f;
         
         
    }
    @Override
    public void updateinfo(FoodCourtModel foodcourt,UpdateInfo update) throws Exception {

     String query = "update Settings set  Time = '"+update.Time+"' , CGST = "+update.CGST+" ,SGST = "+update.SGST+" ,Email = '"+update.Email+"' , ColddrinkQTY = '"+update.ColdDrink+"'  , WaterQTY = '"+update.ColdDrink+"'  where ID = "+foodcourt.getId() ;
     PreparedStatement psmnt = null;
     psmnt = conn.prepareStatement(query);
     psmnt.executeUpdate();  
      
    }

    @Override
    public void updatecollection(String Foodcourtname, Float price,String time) throws Exception 
    {
        int ResetTime = Integer.parseInt(time);
        int presentHR = -1;
        presentHR = LocalDateTime.now().getHour();
        String data = "";
     
       
        
        if( presentHR < ResetTime )
        {
             data ="select  Collect from  "+Foodcourtname+"_collection where  date  = curdate() - INTERVAL 1 DAY";
       
        }else{
             data ="select  Collect from  "+Foodcourtname+"_collection where  date = curdate()"; 
        }
          
 
       float old =0;
       boolean newday = true;
       Statement stmt=conn.createStatement();  
       ResultSet rs = stmt.executeQuery(data);
        while(rs.next())  
        {
            old = Float.parseFloat(rs.getString(1));
            newday = false;
        }
                
        if(newday)
        {
                if( presentHR < ResetTime )
                {
                   old = old + price;
                   String query = "insert into "+Foodcourtname+"_collection(Collect,date) values ('"+price+"',curdate() - INTERVAL 1 DAY)";
                   PreparedStatement psmnt = null;
                   psmnt = conn.prepareStatement(query);
                   psmnt.executeUpdate();
                   
                   
                   // To reset token count 
                   String queryt = "update  "+Foodcourtname+"_TokenCount set  Token = 0";
                   PreparedStatement psmntt = null;
                   psmntt = conn.prepareStatement(queryt);
                   psmntt.executeUpdate();
                   
                }else{
                   old = old + price;
                   String query = "insert into "+Foodcourtname+"_collection(Collect,date) values ('"+price+"',curdate())";
                   PreparedStatement psmnt = null;
                   psmnt = conn.prepareStatement(query);
                   psmnt.executeUpdate();
                   
                   
                   // To reset token count 
                   String queryt = "update  "+Foodcourtname+"_TokenCount set  Token = 0";
                   PreparedStatement psmntt = null;
                   psmntt = conn.prepareStatement(queryt);
                   psmntt.executeUpdate();
                }
        }else  {
             if( presentHR < ResetTime )
                {  
                old = old + price;
                String query = "update  "+Foodcourtname+"_collection set  Collect = '"+old+"' where date  = curdate() - INTERVAL 1 DAY";
                PreparedStatement psmnt = null;
                psmnt = conn.prepareStatement(query);
                psmnt.executeUpdate();
                }else
             {
        old = old + price;
        String query = "update  "+Foodcourtname+"_collection set  Collect = '"+old+"' where date = curdate()";
        PreparedStatement psmnt = null;
        psmnt = conn.prepareStatement(query);
        psmnt.executeUpdate();
                }
             
        
        }
    }
    @Override
    public String GettodayCollection(String Foodcourtname,String time) throws Exception {        
        int ResetTime = Integer.parseInt(time);
        int presentHR = LocalDateTime.now().getHour();
        String data = "";
        if( presentHR < ResetTime )
        {
             data ="select  Collect from  "+Foodcourtname+"_collection where  date  = curdate() - INTERVAL 1 DAY";
        }else{
             data ="select  Collect from  "+Foodcourtname+"_collection where  date = curdate()"; 
        }
 
       // String data ="select  Collect from  "+Foodcourtname+"_collection where  date = curdate()"; 
       float old =0;
       boolean newday = true;
       Statement stmt=conn.createStatement();  
       ResultSet rs = stmt.executeQuery(data);
       while(rs.next())  
                   {
                       old = Float.parseFloat(rs.getString(1));
                       newday = false;
                   }
       
       if(newday){   
            return "0";      
       }
                   return old+"";
    }
    @Override
    public String GetPerticulardateCollection(String Foodcourtname, Date start, Date end) throws Exception 
    {
       java.sql.Date sdate = new java.sql.Date(start.getTime());
       java.sql.Date edate = new java.sql.Date(end.getTime()); 
       String Query="select  Collect from  "+Foodcourtname+"_collection  WHERE Date >= '"+sdate+"' AND Date <= '"+edate+"';";    
       float old =0;
       boolean newday = true;
       Statement stmt=conn.createStatement();  
       ResultSet rs = stmt.executeQuery(Query);
       while(rs.next())  
                   {
                       old = old+  Float.parseFloat(rs.getString(1));
                       newday = false;
                   }
       if(newday){
             
                 
                   return "0";
       }
                   return old+"";
    }
    @Override
    public int GetToken(String Foodcourtname) throws Exception 
    {
                  
                   int currenttoken = -1;
                   String tokenquery = "select max(Token) from "+Foodcourtname+"_TokenCount;";
                   Statement stmt=conn.createStatement();  
                   ResultSet rs = stmt.executeQuery(tokenquery);
                   while(rs.next())  
                   {
                       currenttoken = rs.getInt(1);
                   }
                   int t = currenttoken + 1;
                   String query = "update  "+Foodcourtname+"_TokenCount set  Token = "+t;
                   PreparedStatement psmnt = null;
                   psmnt = conn.prepareStatement(query);
                   psmnt.executeUpdate();  
                   return currenttoken + 1;
    }

    @Override
    public Settings GetSettings(String ID) throws Exception
    {
                   String tokenquery = "select * from Settings where ID = "+ID;
                   Statement stmt=conn.createStatement();  
                   ResultSet rs = stmt.executeQuery(tokenquery);
                   while(rs.next())  
                   {
                       return new Settings(rs.getDouble(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                   }
        
        return null;
    }
}
