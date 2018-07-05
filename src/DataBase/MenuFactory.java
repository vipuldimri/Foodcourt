
package DataBase;

public class MenuFactory 
{
    
    public static MenuInterface GetInstance()
    {
         return new Menuimplementation();
    
    }
    
    
}
