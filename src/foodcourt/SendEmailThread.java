/*
Class to send email in background thread 
*/
package foodcourt;

import DataBase.FoodCourtFactory;
import DataBase.FoodCourtMainInterface;
import static com.oracle.jrockit.jfr.Transition.To;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SendEmailThread extends Thread
{
  
    FoodCourtModel foodcourt;
    String Comment;
    foodcourt.Settings settings;
    public SendEmailThread(FoodCourtModel foodcourt,String Comment,foodcourt.Settings settings)
    {
        this.Comment = Comment;
        this.foodcourt = foodcourt;
        this.settings = settings;
    }
    @Override
    public void run()
    {
        String from = "starktechnologies2018@gmail.com";
        String password = "sample@123";       
        String sub = "Password";
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
           Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           @Override
           protected PasswordAuthentication getPasswordAuthentication()
           {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
  
          try 
          {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(foodcourt.getEmail()));    
          
           message.setSubject(sub);
        String collection = "Error Getting it , Contect Developers";
        try
        {
            FoodCourtMainInterface dao = FoodCourtFactory.GetInstance();
            collection = dao.GettodayCollection(foodcourt.getName(),settings.getTime());

        }catch(Exception e)
        {
        }
           if(Comment.length() ==0){
               Comment ="None";
           }
           String mss = "Dear "+foodcourt.getOwner()+" Today Collection for your FoodCourt "+foodcourt.getName()+" is "+collection+ ""+System.lineSeparator() + "Comment :- "+Comment+""+System.lineSeparator()+"Regards starktechnologies";   
           message.setText(mss);    
           Transport.send(message);    
          } 
          catch (MessagingException e)
          {
              System.out.println(e);
          }    
          
          
          
    }
    
}
