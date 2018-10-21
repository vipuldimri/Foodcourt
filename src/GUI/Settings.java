/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataBase.FoodCourtFactory;
import DataBase.FoodCourtMainInterface;
import foodcourt.FoodCourtModel;
import foodcourt.UpdateInfo;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author u20o90
 */
public class Settings extends javax.swing.JDialog {
    FoodCourtModel foodcourt;
    public foodcourt.Settings settings;
    
    public Settings(java.awt.Frame parent, boolean modal,FoodCourtModel foodcourt, foodcourt.Settings settings) {
    super(parent, modal);
    initComponents();
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
    setLocation(x, y);
    this.foodcourt = foodcourt;
    this.settings = settings;
    sgst.setText(settings.getGGST()+"");
    cgst.setText(settings.getCGST()+"");
    email.setText(settings.getEmail());
    colddrinkqty.setText(this.settings.getColddrinkQTY());
    waterqty.setText(this.settings.getWaterQTY());
    timeComboBox.setSelectedItem(settings.getTime());
    
    if(timeComboBox.getSelectedIndex() < 12)
      {
          this.amPmLabel.setText("AM");
      }
      else if( timeComboBox.getSelectedIndex() > 12)
      {
          this.amPmLabel.setText("PM");
      }
    new timeAmPm().start(); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        cgst = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        sgst = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        timeComboBox = new javax.swing.JComboBox<>();
        amPmLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        waterqty = new javax.swing.JTextField();
        colddrinkqty = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("CGST");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        cgst.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        email.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        sgst.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("SGST");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Reset Time");

        timeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Water ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Cold Drinks");

        waterqty.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        colddrinkqty.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3))
                            .addComponent(jLabel8))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(colddrinkqty)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(waterqty)
                                .addGap(39, 39, 39))
                            .addComponent(email)
                            .addComponent(sgst)
                            .addComponent(cgst)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(amPmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 262, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(sgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(colddrinkqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(waterqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(amPmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
          
      String  SGST =     sgst.getText().trim();
      String CGST =   cgst.getText().trim();
      String newEmail = email.getText().trim();
      String timereset = timeComboBox.getSelectedItem().toString();
      if(Integer.parseInt(timereset) < 12)
      {
          this.amPmLabel.setText("AM");
      }
      else if( Integer.parseInt(timereset) > 12)
      {
          this.amPmLabel.setText("PM");
      }
      
      int drink = 0;
      int water = 0;
     try{
         
         drink = Integer.parseInt(colddrinkqty.getText());
         water = Integer.parseInt(waterqty.getText());
         
     }catch(Exception e){
                JOptionPane.showMessageDialog(this,
                            "Quantity value not correct",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);
     }
      
      UpdateInfo update = new UpdateInfo();
      update.SGST = SGST;
      update.CGST = CGST;
      update.Email = newEmail;
      update.Time = timereset;
      update.ColdDrink = drink+"";
      update.Water = water+"";
        
          FoodCourtMainInterface Dao = FoodCourtFactory.GetInstance();
         try{
             Dao.updateinfo(foodcourt,update);
             settings.setTime(update.Time);
             settings.setEmail(update.Email);
             settings.setCGST(Double.parseDouble(update.CGST));
             settings.setGGST(Double.parseDouble(update.SGST));
             settings.setColddrinkQTY(update.ColdDrink);
             settings.setWaterQTY(update.Water);
             
             
             sgst.setText(settings.getGGST()+"");
             cgst.setText(settings.getCGST()+"");
             email.setText(settings.getEmail());
                  
             
                 timeComboBox.setSelectedItem(settings.getTime());
             
                  JOptionPane.showMessageDialog(this,
                     "Settings Updated successfully",
                     "Success",
                      JOptionPane.PLAIN_MESSAGE);
                  
               
             
         }catch(Exception e){
                  JOptionPane.showMessageDialog(this,
                     "Error updating Settings",
                     "Error",
                      JOptionPane.ERROR_MESSAGE);
                  
                 
         }
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
       
            }
        });
    }
    
    class timeAmPm extends Thread {

        public void run() {
            while (true) {
                try {
                    if(timeComboBox.getSelectedIndex() < 12)
                    {
                        amPmLabel.setText("AM");
                    }
                    else if( timeComboBox.getSelectedIndex() > 12)
                    {
                        amPmLabel.setText("PM");
                    }
                    Thread.sleep(80);
                } catch (InterruptedException ex) {
                    //Logger.getLogger(mainscreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amPmLabel;
    private javax.swing.JTextField cgst;
    private javax.swing.JTextField colddrinkqty;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField sgst;
    private javax.swing.JComboBox<String> timeComboBox;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField waterqty;
    // End of variables declaration//GEN-END:variables
}
