/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import foodcourt.FoodCourtModel;
import foodcourt.Users;
import java.util.ArrayList;

/**
 *
 * @author dimri
 */
public interface FoodCourtMainInterface {
    
    public ArrayList<Users> GetUsers(String Name)throws Exception;
    
    public FoodCourtModel GetFoodCourtDetails(int ID)throws Exception;
    
    public void updateinfo(int id,FoodCourtModel foodcourt)throws Exception;
    
}