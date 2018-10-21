/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import foodcourt.FoodCourtModel;
import foodcourt.Users;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author u20o90
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public ArrayList<Users> users;
    public FoodCourtModel FoodCourt;
    public foodcourt.Settings settings;
    public Login(FoodCourtModel FoodCourt ,  ArrayList<Users> users,foodcourt.Settings settings)
    {
        initComponents();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        this.FoodCourt = FoodCourt;
        this.users = users;
        this.settings = settings;
        this.getRootPane().setDefaultButton(loginbutton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Password = new javax.swing.JPasswordField();
        UserName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        loginbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(36, 47, 65));
        setMinimumSize(new java.awt.Dimension(556, 617));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/StarkLogo.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 70, 140, 70);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(120, 320, 74, 22);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(120, 270, 331, 10);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(120, 380, 331, 17);

        Password.setBackground(new java.awt.Color(36, 47, 65));
        Password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setBorder(null);
        Password.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(Password);
        Password.setBounds(120, 340, 331, 40);

        UserName.setBackground(new java.awt.Color(36, 47, 65));
        UserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UserName.setForeground(new java.awt.Color(255, 255, 255));
        UserName.setBorder(null);
        UserName.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(UserName);
        UserName.setBounds(120, 230, 331, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(120, 210, 86, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sign In");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(170, 100, 57, 26);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/showpassword.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel6MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(460, 340, 60, 30);

        loginbutton.setText("Sign In");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(loginbutton);
        loginbutton.setBounds(120, 400, 110, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 560, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        // TODO add your handling code here:show password mouse enter
        Password.setEchoChar((char) 0);
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased
        // TODO add your handling code here:show password mouse released
        Password.setEchoChar('*');
    }//GEN-LAST:event_jLabel6MouseReleased

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        // TODO add your handling code here:
          if(UserName.getText().length() == 0 || Password.getPassword().length == 0)
        {
                    JOptionPane.showMessageDialog(jPanel1,
                     "Both Fields Are Mandatory",
                     "Login error",
                      JOptionPane.ERROR_MESSAGE);
                  
                    return ;
        }
        
        String username = UserName.getText();
        char[] password = Password.getPassword();
        String pass ="";
        for(int i = 0 ; i <password.length ; i ++)
        {
            pass = pass + password[i];
        }

        
        for( Users u : users)
        {
            if(u.getUserName().equalsIgnoreCase(username) && u.getPassword().equals(pass))
            {
                UserName.setText("");
                Password.setText("");
                MainScreen main = new MainScreen(FoodCourt,u,this,this.settings);
                main.setVisible(rootPaneCheckingEnabled);
                this.setVisible(false);
                return;
            }
        }
                   
                     JOptionPane.showMessageDialog(jPanel1,
                     "Please check Username and password",
                     "Login error",
                      JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_loginbuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField UserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loginbutton;
    // End of variables declaration//GEN-END:variables
}
