/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;

import DataBase.Connect;


public class ConnectionBackgroundThread extends Thread
{
    
    @Override
    public void run()
    {
        
        try 
        {
            Connect connection = new Connect();
        } catch (Exception ex) 
        {
            System.out.println("Error in Connection with database : "+ex);
            System.exit(0);
        }
    
    
    }
    
    
}
