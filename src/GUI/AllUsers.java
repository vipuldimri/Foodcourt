package GUI;
import DataBase.FoodCourtFactory;
import DataBase.FoodCourtMainInterface;
import foodcourt.FoodCourtModel;
import foodcourt.Users;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class AllUsers extends javax.swing.JDialog {
    ArrayList<Users> AllUsers;
    FoodCourtModel foodcourt;
    public AllUsers(java.awt.Frame parent, boolean modal , FoodCourtModel foodcourt)
    {
        super(parent, modal);
        initComponents();
        
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        
        setLocation(x, y); 
        
        
        this.foodcourt = foodcourt;
        FoodCourtMainInterface Dao = FoodCourtFactory.GetInstance();
        try {
             AllUsers = Dao.GetUsers(foodcourt.getName());
        } catch (Exception e) {
        }
        
        FillTable();
    }   
    private void FillTable(){
       DefaultTableModel m = (DefaultTableModel) Employeetable.getModel();
       m.setRowCount(0);
       for(Users item : AllUsers)
       {
        DefaultTableModel  model = (DefaultTableModel) Employeetable.getModel();
        Object row[] = new Object[5];
      
            row[0] = item.getName();
            row[1] = item.getUserName();
            row[2] = item.getAddress();
            row[3] = item.getPhone();
            row[4] = item.getEmail();
            model.addRow(row);
            
        
       }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Employeetable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Management");
        setMaximumSize(new java.awt.Dimension(979, 527));
        setMinimumSize(new java.awt.Dimension(979, 527));
        setPreferredSize(new java.awt.Dimension(979, 527));
        setResizable(false);
        getContentPane().setLayout(null);

        Employeetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "User Name", "Address", "Contact", "Email"
            }
        ));
        jScrollPane1.setViewportView(Employeetable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 980, 380);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user.png"))); // NOI18N
        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(170, 400, 150, 60);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/deleteuser.png"))); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(650, 400, 150, 60);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edituser.png"))); // NOI18N
        jButton6.setText("EDIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(430, 400, 150, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        AddUserDialoge adduser = new AddUserDialoge(this, rootPaneCheckingEnabled, this.foodcourt,this);
        adduser.setVisible(rootPaneCheckingEnabled);
        
    }//GEN-LAST:event_jButton4ActionPerformed
   public  void reload(){
           FoodCourtMainInterface Dao = FoodCourtFactory.GetInstance();
        try {
             AllUsers = Dao.GetUsers(foodcourt.getName());
        } catch (Exception e) {
        }
       FillTable();
   }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = Employeetable.getSelectedRow();
        System.out.println(row);
        if(row == -1){
                     JOptionPane.showMessageDialog(this,
                     "Select Employee First",
                     "Error",
                     JOptionPane.ERROR_MESSAGE);
                     return;
        }
        JOptionPane.showMessageDialog(this,
                     "Function not implemented yet",
                     "Message",
                      JOptionPane.ERROR_MESSAGE);
       // String value = Employeetable.getModel().getValueAt(row, column).toString();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(AllUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Employeetable;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
