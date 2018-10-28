/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataBase.FoodCourtFactory;
import DataBase.FoodCourtMainInterface;
import foodcourt.FoodCourtModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author dimri
 */
public class AddUserDialoge extends javax.swing.JDialog {

    /**
     * Creates new form AddUserDialoge
     */
    FoodCourtModel foodcourt;
    AllUsers pre;
    public AddUserDialoge(java.awt.Dialog parent, boolean modal,FoodCourtModel foodcourt,AllUsers pre) {
        super(parent, modal);
        initComponents();
        this.foodcourt = foodcourt;
        this.pre = pre;
        
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        
        setLocation(x, y); 
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Address = new javax.swing.JTextArea();
        Email = new javax.swing.JTextField();
        Username = new javax.swing.JTextField();
        Contact = new javax.swing.JTextField();
        Password = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1011, 494));
        setMinimumSize(new java.awt.Dimension(1011, 494));
        setPreferredSize(new java.awt.Dimension(1011, 494));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 20, 71, 46);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Address");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(520, 20, 71, 46);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Email");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 130, 71, 46);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("UserName");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(520, 170, 134, 46);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Contact");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 250, 71, 46);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(520, 270, 172, 46);
        getContentPane().add(Name);
        Name.setBounds(80, 70, 340, 49);

        Address.setColumns(20);
        Address.setRows(5);
        jScrollPane1.setViewportView(Address);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(520, 70, 378, 96);
        getContentPane().add(Email);
        Email.setBounds(80, 180, 340, 49);
        getContentPane().add(Username);
        Username.setBounds(520, 210, 380, 49);
        getContentPane().add(Contact);
        Contact.setBounds(80, 300, 340, 49);
        getContentPane().add(Password);
        Password.setBounds(520, 320, 380, 49);

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(430, 390, 139, 48);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        foodcourt.Users user = new foodcourt.Users();
        user.setName(Name.getText());
        user.setAddress(Address.getText());
        user.setUserName(Username.getText());
        user.setPhone(Contact.getText());
        user.setPassword(Password.getText());
        user.setEmail(Email.getText());

        try
        {
            FoodCourtMainInterface dao = FoodCourtFactory.GetInstance();
            dao.AddUser(foodcourt.getName() , user);
            JOptionPane.showMessageDialog(this,
            "Employee Added",
            "Success",
            JOptionPane.PLAIN_MESSAGE);
          
            this.pre.reload();
            this.dispose();
            
        }catch(Exception e)
        {
                      JOptionPane.showMessageDialog(this,
                      "Error : "+e,
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);  
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddUserDialoge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUserDialoge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUserDialoge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUserDialoge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Address;
    private javax.swing.JTextField Contact;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
