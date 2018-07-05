
package DataBase;

import java.awt.image.DataBufferByte;
import java.util.ArrayList;

public interface MenuInterface 
{
    
    public ArrayList<String >GetCategory(String FoodCourtID) throws Exception;
  
  //  public Boolean AddCategory(String FoodCourtID,String Name , DataBufferByte data) throws Exception;

    
     public Boolean AddCategory() throws Exception;
}
