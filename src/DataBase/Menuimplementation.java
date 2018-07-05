
package DataBase;
import java.awt.image.DataBufferByte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Menuimplementation implements MenuInterface
{
    Connection conn;
    Menuimplementation()
    {
        conn = Connect.getconnection();
    }
    
    @Override
    public ArrayList<String> GetCategory(String FoodCourtName) throws Exception 
    {
       ArrayList<String> categories = new ArrayList<>();
       final String Query = "select * from Demo_Category;";
       
        Statement stmt=conn.createStatement();  
        ResultSet rs = stmt.executeQuery(Query);
        while(rs.next())  
        {
         int id = rs.getInt(1);
         String Name = rs.getString(2);
         categories.add(Name);
         
        }
        
        return categories;
       
       
    }

//    @Override
//    public Boolean AddCategory(String FoodCourtID,String Name , DataBufferByte data) throws Exception
//    {
//           System.out.println("Idhar a ");
//            PreparedStatement psmnt = null;
//        
//            psmnt = conn.prepareStatement(" insert into Demo_Category(Name,Image) values (?,?);");
//                
//            psmnt.setString(1, Name.trim());
//            byte[] extractBytes = data.getData();
//            psmnt.setBytes(2, extractBytes); 
//            int s = psmnt.executeUpdate();
//            
//            if(s > 0)
//            {
//                return true;
//            }else{
//                return false;
//            }
//            
//    }
//    

    @Override
    public Boolean AddCategory() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
 