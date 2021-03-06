package GUI;
import DataBase.MenuFactory;
import DataBase.MenuInterface;
import foodcourt.Menu_Items;
import foodcourt.MyLog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class MenuItems extends javax.swing.JDialog 
{
    String cateName;
    String FoodCourtName;
    ArrayList<Menu_Items> Items;
    public MenuItems(java.awt.Frame parent, boolean modal , String FoodCourtName , String cateName) 
    {
        
        super(parent, modal);
        this.FoodCourtName =FoodCourtName;
        this.cateName = cateName;
        
        System.out.println(this.FoodCourtName +"  "+ this.cateName);
        initComponents();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        
        setLocation(x, y); 
        GetCatItems();
       
        
        FillingTable();
        this.getRootPane().setDefaultButton(jButton1);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        ItemsTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        ItemsTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        ItemsTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        if(cateName.equals("Cold Drinks") ||  cateName.equals("Water")){
               QTY.setEnabled(true);
               
        }else{
               QTY.setEnabled(false);
               QTY.setVisible(false);
              jLabel4.setVisible(false);
               ItemsTable.removeColumn(ItemsTable.getColumnModel().getColumn(2));
        }
        
     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemsTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        itemprice = new javax.swing.JTextField();
        itemname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        QTY = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADD / UPDATE  ITEMS");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ItemsTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price","QTY"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}

    );
    ItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ItemsTableMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(ItemsTable);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
    );

    getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

    jPanel2.setBackground(new java.awt.Color(102, 102, 255));
    jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
    jPanel2.setForeground(new java.awt.Color(102, 102, 102));
    jPanel2.setPreferredSize(new java.awt.Dimension(911, 200));

    jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("Item Name:");

    jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("Item Price:");

    itemprice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

    itemname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

    jButton1.setText("ADD");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("ADD / UPDATE ITEMS");

    jButton2.setText("Delete");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jButton3.setText("Update");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("QTY");

    QTY.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addComponent(jLabel2)
                    .addGap(3, 3, 3)
                    .addComponent(itemprice, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(108, 108, 108)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(382, 382, 382)
                            .addComponent(jLabel3))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(330, 330, 330)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(QTY, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addComponent(jLabel3)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemprice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                    .addComponent(jButton3)))
            .addGap(12, 12, 12)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jButton2)
                    .addGap(24, 24, 24))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QTY, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(19, Short.MAX_VALUE))
    );

    getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // code for adding new item 
        if("".equals(itemname.getText())  || "".equals(itemprice .getText()))
        {
                     JOptionPane.showMessageDialog(jPanel1,
                     "Please Fill both Details",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
            
        }
        
        if(cateName.equals("Cold Drinks") ||  cateName.equals("Water")){
        
                if("".equals(QTY.getText()) )
                  {
                     JOptionPane.showMessageDialog(jPanel1,
                     "Invalid Quantity",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
            
                  }
                     try{
            int sad = Integer.parseInt(QTY .getText());
      }catch(Exception ex)
      {
          JOptionPane.showMessageDialog(jPanel1,
                     "Invalid Quantity",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
      }
        }
        
        for(Menu_Items item : Items)
        {
                  if(item.getName().equalsIgnoreCase(itemname.getText().trim()))
                 {
                    JOptionPane.showMessageDialog(jPanel1,
                     "Item already Exits",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
                    }
        }
        
      try{
            int price = Integer.parseInt(itemprice .getText());
      }catch(Exception ex)
      {
          JOptionPane.showMessageDialog(jPanel1,
                     "Invalid Price",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
      }
        boolean firstitem = false;
        Menu_Items item  = null;
        if(Items.size() != 0)
        {
                   firstitem = false;
                   item = new Menu_Items(Items.get(Items.size()-1).getId()+1, itemname.getText().trim(), itemprice .getText().trim(), cateName,"0");

            
        }

             item = new Menu_Items(1, itemname.getText().trim(), itemprice .getText().trim(), cateName,"0");

        MenuInterface Dao = MenuFactory.GetInstance();
        try
        {
            System.out.println("Adding item");
            
             
        if(cateName.equals("Cold Drinks") ||  cateName.equals("Water")){
             Dao.AddItem(FoodCourtName, itemname.getText().trim(), itemprice .getText().trim(), cateName , QTY.getText().trim());
        }else{
             Dao.AddItem(FoodCourtName, itemname.getText().trim(), itemprice .getText().trim(), cateName);
        }
            
            
           
        } catch (Exception ex) 
        {
            System.out.println("Failed"+ex);
            return;
        }
        
         Items.add(item);
         FillingTable();
         itemname.setText("");
         itemprice.setText("");
         QTY.setText("");
         this.itemname.requestFocusInWindow();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ItemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemsTableMouseClicked
        // TODO add your handling code here:
         
        int row = ItemsTable.getSelectedRow();
        String Name = ItemsTable.getModel().getValueAt(row, 0).toString();
        String Price = ItemsTable.getModel().getValueAt(row, 1).toString();
        itemname.setText(Name);
        itemprice.setText(Price);
        
         String QTY1 = null;
        try{
         QTY1 = ItemsTable.getModel().getValueAt(row, 2).toString();
        }catch(Exception e){}
       
        if(QTY1 != null){
               QTY.setText(QTY1);
        }
    }//GEN-LAST:event_ItemsTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // code for update 
        if(itemname.getText().trim().length() == 0 || itemprice.getText().trim().length() == 0 )
        {
                     JOptionPane.showMessageDialog(jPanel1,
                     "First Select item for updation",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
            
        }
             try{
            int price = Integer.parseInt(itemprice .getText());
      }catch(Exception ex)
      {
          JOptionPane.showMessageDialog(jPanel1,
                     "Invalid Price",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
      }
        
        String ItemName = itemname.getText().trim();
        String Categoryitem = cateName;
        String QTY6 = "-1";
        
        for(Menu_Items item : Items)
        {
                 if(item.getName().equalsIgnoreCase(itemname.getText().trim()))
                 {
                      
                         if(cateName.equals("Cold Drinks") ||  cateName.equals("Water"))
                         {
                                                  try{
                                                    int sad = Integer.parseInt(QTY .getText());
                                              }catch(Exception ex)
                                              {
                                                  JOptionPane.showMessageDialog(jPanel1,
                                                             "Invalid Quantity",
                                                             "Inane error",
                                                              JOptionPane.ERROR_MESSAGE);
                                                              return ;
                                              }
                                                  QTY6 = QTY.getText().trim();
                             
                         }else{
                             if(item.getPrice().equalsIgnoreCase(itemprice.getText().trim()))
                             {
                                    JOptionPane.showMessageDialog(jPanel1,
                                     "Change item price if you want to update ",
                                    "Inane error",
                                     JOptionPane.ERROR_MESSAGE);
                                     return ;
                              }
                         }
                     
                     
                               MenuInterface Dao = MenuFactory.GetInstance();
                               try
                               {
                                   System.out.println("updating item");
                                   Dao.UpdateItem(FoodCourtName, itemname.getText().trim(), itemprice .getText().trim(), cateName ,QTY6.trim());
                                   item.setPrice(itemprice.getText().trim());
                                   item.setQTY(QTY6);
                                   FillingTable();
                                   itemname.setText("");
                                    itemprice.setText("");
                                    QTY.setText("");
                                   return;
                                   
                               } catch (Exception ex) 
                               {
                                     JOptionPane.showMessageDialog(jPanel1,
                                     "Updating failed please check internet connection",
                                    "Inane error",
                                     JOptionPane.ERROR_MESSAGE);
                                     return ;
                                   
                               }
                 }
        }
                     JOptionPane.showMessageDialog(jPanel1,
                     "No item found for update",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // code for delete
               if(itemname.getText().trim().length() == 0 || itemprice.getText().trim().length() == 0 )
        {
                     JOptionPane.showMessageDialog(jPanel1,
                     "First Select item to be  deleted",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
            
        }
             try{
            int price = Integer.parseInt(itemprice .getText());
      }catch(Exception ex)
      {
          JOptionPane.showMessageDialog(jPanel1,
                     "Invalid Price",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
      }
        
        int position = -1 ;
        boolean deletesuccess = false;
        for(int i = 0 ; i < Items.size() ; i ++)
        {
                 Menu_Items item = Items.get(i);
                 if(item.getName().equalsIgnoreCase(itemname.getText().trim()))
                 {
                     
                               MenuInterface Dao = MenuFactory.GetInstance();
                               try
                               {
                                   System.out.println("deleting item");
                                   Dao.DeleteItem(FoodCourtName, itemname.getText().trim(), itemprice .getText().trim(), cateName);
                                   position = i;
                                   deletesuccess = true;
                                
                                   
                                   
                               } catch (Exception ex) 
                               {
                                     JOptionPane.showMessageDialog(jPanel1,
                                     "Updating failed please check internet connection",
                                    "Inane error",
                                     JOptionPane.ERROR_MESSAGE);
                                     return ;
                                   
                               }
                 }
        }
        
        if(deletesuccess)
        {
               Items.remove(position);
               FillingTable();
               itemname.setText("");
               itemprice.setText("");
               return;
        }
        
                     JOptionPane.showMessageDialog(jPanel1,
                     "No item found for delete",
                     "Inane error",
                      JOptionPane.ERROR_MESSAGE);
                      return ;
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemsTable;
    private javax.swing.JTextField QTY;
    private javax.swing.JTextField itemname;
    private javax.swing.JTextField itemprice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void GetCatItems()
    {
              
        MenuInterface Dao   = MenuFactory.GetInstance();
        try
        {
            MyLog.getLogger().info("Foodcourtname:"+this.FoodCourtName);
            Items =   Dao.GetCatItems(FoodCourtName,cateName);
        }catch(Exception ex)
        {
            System.out.println("Unable to get categories items from database "+ex);
            
        }
        

    }

    private void FillingTable() 
    {

                        
       DefaultTableModel m = (DefaultTableModel) ItemsTable.getModel();
       m.setRowCount(0);
       for(Menu_Items item : Items)
       {
        DefaultTableModel  model = (DefaultTableModel) ItemsTable.getModel();
        Object row[] = new Object[3];
      
            row[0] = item.getName();
            row[1] = item.getPrice();
               row[2] = item.getQTY();
            model.addRow(row);
            
        
       }
    }
}
