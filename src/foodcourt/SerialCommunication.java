/*
 Authour: Vasant Dacha
 This File handles Serial Communication
 Date: 28/7/2018
 */
package foodcourt;
import com.fazecast.jSerialComm.*; 
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import foodcourt.MyLog;
import javax.swing.JOptionPane;

public class SerialCommunication {
    
	static String commPort = "";
    SerialPort port=null;
    String data="";
    boolean isSuccess = false;	
	// Constructor
    public SerialCommunication(String commPort)
    {
        this.commPort = commPort;
        initialise();
    }

    // This function initialises and opens serial port
    // for communication with the hardware module	
    public void initialise()
    {
        SerialPort serialPort[] = SerialPort.getCommPorts();
        for(int index = 0;index < serialPort.length;index++)
        {
            if( (serialPort[index].getSystemPortName()).equals(commPort) )
            {
                port = serialPort[index];
                break;
            }
        }
		// Checks if the port is not assigned
        if( port == null)
        {
            MyLog.getLogger().severe("Could not find COM port");
            JOptionPane.showMessageDialog(null, "Could not find COM port");
        }
		// Checks if assigned port is already open
        if( port.isOpen() )
        {
            MyLog.getLogger().severe("port is already open");
            JOptionPane.showMessageDialog(null,"port is already open");
            return;
        }
		// Returns error if cannot open the port
        if(!port.openPort())
        {
            MyLog.getLogger().severe("cannot open port!");
            JOptionPane.showMessageDialog(null,"cannot open port!");
            return;
        }
        else
        {
			// If every thing is fine, listen for the events
            InputStream in = port.getInputStream();
            port.setBaudRate(9600);
            port.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 1000, 0);
            port.addDataListener(new SerialPortDataListener() {
   
            public int getListeningEvents() 
            { 
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE; 
            }
            
            public void serialEvent(SerialPortEvent event)
            {
                if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
                {  
                      byte[] readbuffer = new byte[10240];
                      int numbytes = port.readBytes(readbuffer, readbuffer.length);
                    
                        for(int i=0; i<numbytes; i++)
                        {  
                            if( String.valueOf((char)readbuffer[i]).equals("\n") )
                            {
                                MyLog.getLogger().info("call processData:"+data);
                                processData(data);
                                data="";
                                break;
                            }
                            data += String.valueOf((char)readbuffer[i]);
                        }         
                }
            }
            });
            
        }
    }
        
    
	// This function process the incoming data
    public void processData( String temp )
    {
        
        try
        {
            Scanner scanner = new Scanner(temp);
            
            if( scanner.hasNext("SUCCESS"))
            {   
                isSuccess = true;
                synchronized(this)
                {
                this.notify();
                }
                FactoryClass.getMainPageObj().message(temp);
            }
            else if( scanner.hasNext("ERROR"))
            {
                isSuccess = false;
                synchronized(this)
                {
                this.notify();
                }
                FactoryClass.getMainPageObj().message(temp);
            }
        }
        catch (Exception e) 
        {
            MyLog.getLogger().severe(e.toString());
        }
    }
    
    public boolean getStatus()
    {
        return isSuccess;
    }
    
    // Send the data from application to the hardware module
    public void sendData(String amount) throws IOException
	{
            synchronized(this)
            {
		byte[] arr = amount.getBytes();
		port.writeBytes(arr, arr.length);   
                try {
                    wait();
                } catch (InterruptedException ex) {
                    MyLog.getLogger().info("Synchronized exception:"+ex.getMessage());
                }
            }
	}    
    
    // Close open ports	
    public synchronized void close() 
    {
            if (port != null) 
            {
                    port.closePort();
                    port.removeDataListener();
            }
    }
}
