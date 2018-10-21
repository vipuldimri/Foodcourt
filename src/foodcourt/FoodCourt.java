package foodcourt;
import GUI.Login;
import GUI.Splash;
import javax.swing.JOptionPane;
public class FoodCourt {
    public static void main(String[] args) throws InterruptedException 
    {
        Splash splash = new Splash();
        splash.setVisible(true); 
        ConnectionBackgroundThread connectionBackgroundThread = new ConnectionBackgroundThread();
        connectionBackgroundThread.start();
        
        for(int i=1 ;i<=100 ;i++)
        {
            Thread.sleep(75);
            splash.jLabel2.setText("Loading "+i+" %");
            splash.jProgressBar1.setValue(i);
            if(i == 100)
            {
                splash.setVisible(false);
                if(connectionBackgroundThread.Name.equals("") || connectionBackgroundThread.Id.equals(""))
                {
                      
                }
                if(connectionBackgroundThread.users == null)
                {
                    System.out.println("Users is null");
                    MyLog.getLogger().severe("Users is null exiting from here");
                    System.exit(0);
                    return;
                }
                new Login(connectionBackgroundThread.FoodCourt , connectionBackgroundThread.users , connectionBackgroundThread.settings).setVisible(true);
                break;
                
            }
            
        }
        
    }
    
}
