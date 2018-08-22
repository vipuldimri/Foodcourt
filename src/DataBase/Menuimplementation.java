
package DataBase;
import DataStructures.Trie;
import foodcourt.Category;
import foodcourt.Menu_Items;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
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
    public ArrayList<Category> GetCategory(String FoodCourtName) throws Exception 
    {
       ArrayList<Category> categories = new ArrayList<>();
       final String Query = "select * from "+FoodCourtName+"_Category;";
       
        Statement stmt=conn.createStatement();  
        ResultSet rs = stmt.executeQuery(Query);
        while(rs.next())  
        {
         int id = rs.getInt(1);
         String Name = rs.getString(2);
         Blob is = rs.getBlob(3); 
         
            FileOutputStream fout = new FileOutputStream("C://Foodcourt//Images/"+id+".jpg");
         
            int len = (int) is.length();
            byte[] buf = is.getBytes(1, len);
            fout.write(buf,0,len);
         Category cat = new Category(id, Name, null);
         categories.add(cat);
         
        }
        
        return categories;
       
       
    }

    @Override
    public Boolean AddCategory(String FoodCourtID,String Name , File data) throws Exception
    {
  
            PreparedStatement psmnt = null;
        
            psmnt = conn.prepareStatement(" insert into "+FoodCourtID+"_Category (Name,Image) values (?,?);");
                
            psmnt.setString(1, Name.trim());
            
            FileInputStream f =  new FileInputStream(data);

            psmnt.setBinaryStream(2,(InputStream) f, (int)(data.length())); 
            int s = psmnt.executeUpdate();
            
            if(s > 0)
            {
                return true;
            }else{
                return false;
            }
            
    }

    @Override
    public Boolean AddItem(String FoodCourtID, String Name, String Price, String Category) throws Exception 
    {
        
           System.out.println(Category + " " + Name + " "+Price );
            PreparedStatement psmnt = null;
            psmnt = conn.prepareStatement(" insert into "+FoodCourtID+"_Items(Name,price,Category) values (?,?,?);");
            psmnt.setString(1, Name.trim());
            psmnt.setString(2, Price.trim());
            psmnt.setString(3, Category.trim()); 
            int ans = psmnt.executeUpdate();
            return true;         
    }

    @Override
    public ArrayList<Menu_Items> GetItems(String FoodCourtName,Trie trie) throws Exception 
    {
        
        ArrayList<Menu_Items> Items = new ArrayList<>();
        final String Query = "select * from "+FoodCourtName+"_Items ";
        Statement stmt=conn.createStatement();  
        ResultSet rs = stmt.executeQuery(Query);
        while(rs.next())  
        {
         int id = rs.getInt(1);
         String Name = rs.getString(2);
         String Price = rs.getString(3);
         String Cat = rs.getString(4);
         Menu_Items item = new Menu_Items(id, Name, Price, Cat);
         Items.add(item);
         
        }
        System.out.println(Items.size());
        return Items;
       
       
        
        
    }

    @Override
    public ArrayList<Menu_Items> GetCatItems(String FoodCourtName,String cat) throws Exception {
       
        ArrayList<Menu_Items> Items = new ArrayList<>();
        final String Query = "select * from "+FoodCourtName+"_Items where Category = '"+cat+"';";
        System.out.println(Query);
        Statement stmt=conn.createStatement();  
        ResultSet rs = stmt.executeQuery(Query);
        while(rs.next())  
        {
         int id = rs.getInt(1);
         String Name = rs.getString(2);
         String Price = rs.getString(3);
         String Cat = rs.getString(4);
         
         Menu_Items item = new Menu_Items(id, Name, Price, Cat);
         Items.add(item);
         
        }
        
        return Items;
    }

    @Override
    public Boolean UpdateItem(String FoodCourtID, String Name, String Price, String Category) throws Exception {
        
              
            System.out.println(Category + " " + Name + " "+Price );
            PreparedStatement psmnt = null;
            psmnt = conn.prepareStatement(" update "+FoodCourtID+"_Items set Price = "+Price+" where  Category = '"+Category+"' and Name = '"+Name+"'");
            psmnt.executeUpdate();
            return true;    
    }

    @Override
    public Boolean DeleteItem(String FoodCourtID, String Name, String Price, String Category) throws Exception {
        
            System.out.println("delete  "+FoodCourtID+"_Items where  Name = '"+Name+"' and Category='"+Category+"'" );
            PreparedStatement psmnt = null;
            psmnt = conn.prepareStatement("delete from "+FoodCourtID+"_Items where  Name = '"+Name+"' and Category='"+Category+"'");
            psmnt.executeUpdate();
            return true;    
    }

    @Override
    public Boolean DeleteCategory(String FoodCourtID,String CategoryID,String CategoryName) throws Exception {
        
            System.out.println("delete  "+FoodCourtID+"_Category where  ID = '"+CategoryID);
            PreparedStatement psmnt = null;
            psmnt = conn.prepareStatement("delete from  "+FoodCourtID+"_Category  where ID = "+CategoryID);
            psmnt.executeUpdate();
            
            
            psmnt = null;
            psmnt = conn.prepareStatement("delete from "+FoodCourtID+"_Items where  Category='"+CategoryName+"'");
            psmnt.executeUpdate();
            return true;
    }
    
}
 