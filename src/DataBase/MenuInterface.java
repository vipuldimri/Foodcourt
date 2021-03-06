
package DataBase;


import DataStructures.Trie;
import foodcourt.Category;
import foodcourt.Menu_Items;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public interface MenuInterface 
{
    
    public ArrayList<Category> GetCategory(String FoodCourtID) throws Exception;
  
    public Boolean AddCategory(String FoodCourtID,String Name , File data) throws Exception;
    public Boolean DeleteCategory(String FoodCourtID,String CategoryID,String CategoryName) throws Exception;

    public Boolean AddItem (String FoodCourtID, String Name , String Price ,String Category )throws Exception;
    
    
    public Boolean AddItem (String FoodCourtID, String Name , String Price ,String Category , String QTY )throws Exception;
    
    public Boolean UpdateItem (String FoodCourtID, String Name , String Price ,String Category ,String QTY)throws Exception;
    
    public Boolean DeleteItem (String FoodCourtID, String Name , String Price ,String Category )throws Exception;


    public String  UpdateDrinksQTY(String FoodCourtID, HashMap<String,Integer> map) throws Exception;
   
    public ArrayList<Menu_Items> GetItems(String FoodCourtName,Trie trie)throws Exception;
    
    
    public ArrayList<Menu_Items> GetCatItems(String FoodCourtName,String cat)throws Exception;;

 public ArrayList<Menu_Items> GetCatItemsQTY(String FoodCourtName) throws Exception ;
       

}
