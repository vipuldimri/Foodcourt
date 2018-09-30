/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;

import DataBase.Connect;
import DataBase.FoodCourtFactory;
import DataBase.FoodCourtMainInterface;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import static javafx.util.Duration.hours;
import javax.swing.JLabel;

/**
 *
 * @author dimri
 */
public class ClockThread extends Thread{
 
    JLabel l;
    public ClockThread(JLabel l){
        this.l = l;
    }
    
       @Override
    public void run()
    {
        
        try 
        {
            
            while (true) {  
             int hours=0, minutes=0, seconds=0;  
                String timeString = "";  
            Calendar cal = Calendar.getInstance();  
            hours = cal.get( Calendar.HOUR_OF_DAY );  
            if ( hours > 12 ) hours -= 12;  
            minutes = cal.get( Calendar.MINUTE );  
            seconds = cal.get( Calendar.SECOND );  
  
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");  
            Date date = cal.getTime();  
            timeString = formatter.format( date );  
  
            l.setText(timeString);
            sleep( 1000 );  // interval given in milliseconds  
         }  
        } catch (Exception ex) 
        {}
    }
         

    
    
}
