
package DataBase;
import DataStructures.Trie;
import foodcourt.Category;
import foodcourt.Menu_Items;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import static java.lang.System.in;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;

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
       final String Query = "select * from Demo_Category;";
       
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
           System.out.println("Idhar a ");
            PreparedStatement psmnt = null;
        
            psmnt = conn.prepareStatement(" insert into Demo_Category(Name,Image) values (?,?);");
                
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
            psmnt = conn.prepareStatement(" insert into Demo_Items(Name,price,Category) values (?,?,?);");
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
        final String Query = "select * from Demo_Items ";
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
        final String Query = "select * from Demo_Items where Category = '"+cat+"';";
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
            psmnt = conn.prepareStatement(" update Demo_Items set Price = "+Price+" where  Category = '"+Category+"' and Name = '"+Name+"'");
            psmnt.executeUpdate();
            return true;    
    }

    @Override
    public Boolean DeleteItem(String FoodCourtID, String Name, String Price, String Category) throws Exception {
        
           System.out.println("delete  Demo_Items where  Name = '"+Name+"' and Category='"+Category+"'" );
            PreparedStatement psmnt = null;
            psmnt = conn.prepareStatement("delete from Demo_Items where  Name = '"+Name+"' and Category='"+Category+"'");
            psmnt.executeUpdate();
            return true;    
    }
    

   
}
 