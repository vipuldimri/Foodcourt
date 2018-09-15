/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;

/*
 Author: Vasant Dacha
 This File creates all necessary objects 
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import GUI.MainScreen;

import javax.swing.JOptionPane;

public class FactoryClass 
{
    FactoryClass()
    {
        zigbeeCommObj = null;
        cardRechargerCommObj = null;
        zigbeePort = "";
        cardRechargerPort = "";
    }

    public static SerialCommunication zigbeeCommObj,cardRechargerCommObj;
    private static MainScreen MainGui; 
    private static String zigbeePort;
    private static String cardRechargerPort;
       
    public static void createObjects() throws ClassNotFoundException
    {
		MainGui = new MainScreen();
		getPortsFromConfig();
    }
    // Returns zigbee object
    public static SerialCommunication getZigbeeCommObj()
    {
        return zigbeeCommObj;
    }
    // Returns Recharge module object      
    public static SerialCommunication getCardRechargerCommObj()
    {
        return cardRechargerCommObj;
    } 
    // Returns MainPage object
    public static MainScreen getMainPageObj()
    {
        return MainGui;
    }
    
    // Retrieves ports from config file 
    public static void getPortsFromConfig()
    {
		Properties prop = new Properties();
		InputStream input = null;

		try 
		{
			prop.load(new FileInputStream("c://stark//config.properties"));
			//zigbeePort = prop.getProperty("zigbeeport");
			cardRechargerPort = prop.getProperty("cardrechargerport");
			//MyLog.getLogger().info("zigbeeport:"+zigbeePort);
			MyLog.getLogger().info("rechargerport:"+cardRechargerPort);
			// zigbee port
			//zigbeeCommObj = new SerialCommunication(zigbeePort);
			//card recharger port
			//cardRechargerCommObj = new SerialCommunication(cardRechargerPort);
		}
		catch(Exception e)
		{
			MyLog.getLogger().severe(e.getMessage());
		}        
    }
      
}
