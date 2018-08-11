/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import foodcourt.FoodCourtModel;
import foodcourt.Users;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dimri
 */
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
        
                   Statement stmt=conn.createStatement();  
                   ResultSet rs = stmt.executeQuery(Query);
                   while(rs.next())  
                   {
                 Users user  = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                  users.add(user);
                   }
        return users;
    }

    @Override
    public FoodCourtModel GetFoodCourtDetails(int ID) throws Exception {
     // FoodCourtModel f = new FoodCourtModel(ID, Name, Contact, Address, Owner, ID, ID, SubEnd, Email)
        String query = "select * from FoodCourts where ID = "+ID+"";
        
         FoodCourtModel f = null;
                   Statement stmt=conn.createStatement();  
                   ResultSet rs = stmt.executeQuery(query);
                   while(rs.next())  
                   {
                  f = new FoodCourtModel(rs.getInt(1),rs.getString(2),rs.getString(5),rs.getString(3),rs.getString(4),rs.getDouble(6),rs.getDouble(7),rs.getDate(8),rs.getString(9));
                
                    
                    
                   }
        
        return f;
    }

    @Override
    public void updateinfo(int id,FoodCourtModel foodcourt) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}