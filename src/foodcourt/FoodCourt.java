/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;

import GUI.Login;
import GUI.Splash;

/**
 *
 * @author u20o90
 */
public class FoodCourt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException 
    {
        Splash splash = new Splash();
        splash.setVisible(true);
        
        ConnectionBackgroundThread connectionBackgroundThread = new ConnectionBackgroundThread();
        connectionBackgroundThread.start();
        
        for(int i=1 ;i<=100 ;i++)
        {
            Thread.sleep(45);
            splash.jLabel2.setText("Loading "+i+" %");
            splash.jProgressBar1.setValue(i);
            if(i == 100)
            {
                splash.setVisible(false);
                new Login().setVisible(true);
                break;
                
            }
            
        }
        
    }
    
}
