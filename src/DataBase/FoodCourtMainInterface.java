/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import foodcourt.FoodCourtModel;
import foodcourt.Users;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dimri
 */
public interface FoodCourtMainInterface {
    
    public ArrayList<Users> GetUsers(String Name)throws Exception;
    
    public FoodCourtModel GetFoodCourtDetails(String ID)throws Exception;
    
    public void updateinfo(int id,FoodCourtModel foodcourt)throws Exception;
    
    public void updatecollection(String Foodcourtname,Float price) throws Exception;
    
    public String GettodayCollection(String Foodcourtname) throws Exception;
    
    public String GetPerticulardateCollection(String Foodcourtname,Date start, Date end) throws Exception;
}
