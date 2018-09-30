package GUI;
import DataBase.MenuFactory;
import DataBase.MenuInterface;
import foodcourt.Category;
import foodcourt.ClockThread;
import foodcourt.FoodCourtModel;
import foodcourt.Menu_Items;
import foodcourt.Users;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MainScreen extends javax.swing.JFrame 
{
    
         
    String MessageString = "";
    ArrayList<Category> Categories;
    FoodCourtModel foodcourt;
    Users CurrentUser;
    Login loginscreen;
    JPanel container;
    public MainScreen()
    {
        
    }
    public MainScreen(FoodCourtModel foodcourt ,   Users CurrentUser ,Login loginscreen) 
    {
        
        
        initComponents();
        
        
        ClockThread c = new ClockThread(Clock);
        c.start();
   
        setExtendedState(MainScreen.MAXIMIZED_BOTH); 
        jPanel6.removeAll();
        jPanel6.add(Reports);
        jPanel6.repaint();
        jPanel6.revalidate();
         
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        
        this.foodcourt = foodcourt;
        this.CurrentUser = CurrentUser;
        this.loginscreen = loginscreen;
        //Getting Menu From the Database 
        MenuInterface Dao   = MenuFactory.GetInstance();
        try
        {
            Categories =   Dao.GetCategory(foodcourt.getName());
             
        }catch(Exception ex)
        {
            System.out.println("Unable to get categories from database "+ex);        
        }
     
        for (int i = 0; i < Categories.size(); i++) 
        {
             String name = Categories.get(i).getName();
             JButton  Button = new javax.swing.JButton();
             
            
             Button.addActionListener((ae) ->
             {    
             MenuItems menuItems = new MenuItems(this, rootPaneCheckingEnabled,foodcourt.getName(),Button.getText());
             menuItems.setVisible(rootPaneCheckingEnabled);
                
             }); 
             Button.setText(name);
             JLabel  Labe = new javax.swing.JLabel();
             Labe.setIcon(new javax.swing.ImageIcon("C://Foodcourt/Images/"+Categories.get(i).getID()+".jpg")); // NOI18N
             JPanel PP  = new javax.swing.JPanel(); 
             PP.setVisible(true);
             PP.setMaximumSize(new java.awt.Dimension(100, 100));
             PP.setMinimumSize(new java.awt.Dimension(100, 100));
             PP.setSize(200, 200);
             PP.setBackground(new java.awt.Color(255, 255, 255));
             javax.swing.GroupLayout PPLayout = new javax.swing.GroupLayout(PP);
             PP.setLayout(PPLayout);   
             PPLayout.setHorizontalGroup(
             PPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(PPLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Labe)
                .addContainerGap(23, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button)
                .addGap(46, 46, 46))
             );
             
             
             
             
             PPLayout.setVerticalGroup(
             PPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(PPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Labe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );
             
        

   
             Menu.add(PP);

            
        }
        
                 CheckATUbutton.setForeground(Color.RED);
                MenuInterface Dao2 = MenuFactory.GetInstance();
                try
                {
                   ArrayList<Menu_Items> list  =  Dao2.GetCatItemsQTY(foodcourt.getName());
                    for (int j = 0; j < list.size(); j++) {
                        
                        if(list.get(j).getCategory().equals("Cold Drinks")){
                            
                            if(Integer.parseInt(list.get(j).getQTY()) <=  Integer.parseInt(foodcourt.getColddrinkQTY())){
                                MessageString =  MessageString + list.get(j).getName() +" Low QTY ("+list.get(j).getQTY()+") ,";
                            }
                            
                        }else{
                         //Water  
                            if(Integer.parseInt(list.get(j).getQTY()) <=  Integer.parseInt(foodcourt.getWaterQTY())){
                                MessageString =  MessageString + list.get(j).getName() +" Low QTY ("+list.get(j).getQTY()+") ,";
                            }
                        }
                    }
                }
                catch (Exception ex) 
                {
                    System.out.println("Failed loading items"+ex);
                    return;
                }
        
    }

    public void message(String msg)
    {
        JOptionPane.showMessageDialog(this,
            msg,
            "Recharge",
            JOptionPane.INFORMATION_MESSAGE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Dashboardsidepanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        menusidepanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        menusidepanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Clock = new javax.swing.JLabel();
        CheckATUbutton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        Reports = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Menu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        vbut = new javax.swing.JButton();
        blab = new javax.swing.JLabel();
        Drinks = new javax.swing.JPanel();
        Add = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(968, 653));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(100, 32767));
        jPanel4.setPreferredSize(new java.awt.Dimension(180, 610));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Welcome");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, -1));

        Dashboardsidepanel.setBackground(new java.awt.Color(255, 255, 255));
        Dashboardsidepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardsidepanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardsidepanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardsidepanelMouseExited(evt);
            }
        });

        jLabel1.setText("DashBoard");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout DashboardsidepanelLayout = new javax.swing.GroupLayout(Dashboardsidepanel);
        Dashboardsidepanel.setLayout(DashboardsidepanelLayout);
        DashboardsidepanelLayout.setHorizontalGroup(
            DashboardsidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardsidepanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(51, 51, 51))
        );
        DashboardsidepanelLayout.setVerticalGroup(
            DashboardsidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardsidepanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(DashboardsidepanelLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.add(Dashboardsidepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, -1));

        menusidepanel.setBackground(new java.awt.Color(255, 255, 255));
        menusidepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menusidepanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menusidepanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menusidepanelMouseExited(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/menu.png"))); // NOI18N

        jLabel21.setText("Menu");

        javax.swing.GroupLayout menusidepanelLayout = new javax.swing.GroupLayout(menusidepanel);
        menusidepanel.setLayout(menusidepanelLayout);
        menusidepanelLayout.setHorizontalGroup(
            menusidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusidepanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        menusidepanelLayout.setVerticalGroup(
            menusidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusidepanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menusidepanelLayout.createSequentialGroup()
                .addComponent(jLabel20)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel4.add(menusidepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, 70));

        menusidepanel1.setBackground(new java.awt.Color(255, 255, 255));
        menusidepanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menusidepanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menusidepanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menusidepanel1MouseExited(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/drinks.png"))); // NOI18N

        jLabel23.setText("Drinks");

        javax.swing.GroupLayout menusidepanel1Layout = new javax.swing.GroupLayout(menusidepanel1);
        menusidepanel1.setLayout(menusidepanel1Layout);
        menusidepanel1Layout.setHorizontalGroup(
            menusidepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusidepanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        menusidepanel1Layout.setVerticalGroup(
            menusidepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusidepanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menusidepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(menusidepanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel23)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(menusidepanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, 70));

        jPanel1.add(jPanel4, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(300, 32767));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/StarkLogo.jpg"))); // NOI18N

        Clock.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        Clock.setForeground(new java.awt.Color(255, 255, 0));

        CheckATUbutton.setText("check QTY");
        CheckATUbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckATUbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1256, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(Clock, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(CheckATUbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Clock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckATUbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.CardLayout());

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel33.setText("Take Order");

        jButton10.setText("Take Order");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Order.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel41)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jButton10))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel41)
                .addGap(29, 29, 29)
                .addComponent(jButton10)
                .addGap(37, 37, 37))
        );

        Reports.add(jPanel22);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel32.setText("Today Collection");

        jButton8.setText("Today Collection");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/if_shop-14_730803.png"))); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(jLabel40)
                    .addContainerGap(86, Short.MAX_VALUE)))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(37, 37, 37))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(jLabel40)
                    .addContainerGap(86, Short.MAX_VALUE)))
        );

        Reports.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel34.setText("Employee Details");

        jButton9.setText("Employee");

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Employee.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel35)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(92, 92, 92))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(27, 27, 27)
                .addComponent(jButton9)
                .addGap(37, 37, 37))
        );

        Reports.add(jPanel21);

        jPanel6.add(Reports, "card2");

        jScrollPane1.setToolTipText("");
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(500, 500));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 500));

        Menu.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        vbut.setText("Add New Category");
        vbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vbutActionPerformed(evt);
            }
        });

        blab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Card.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(vbut))
                    .addComponent(blab))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(blab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vbut)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        Menu.add(jPanel3);

        jScrollPane1.setViewportView(Menu);

        jPanel6.add(jScrollPane1, "card4");

        Add.setBackground(new java.awt.Color(255, 255, 255));
        Add.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel36.setText("Cold Drinks");

        jButton11.setText("Add");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cold drink.png"))); // NOI18N

        javax.swing.GroupLayout AddLayout = new javax.swing.GroupLayout(Add);
        Add.setLayout(AddLayout);
        AddLayout.setHorizontalGroup(
            AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addGap(112, 112, 112))
            .addGroup(AddLayout.createSequentialGroup()
                .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel42)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        AddLayout.setVerticalGroup(
            AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel36)
                .addGap(35, 35, 35)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addGap(37, 37, 37))
        );

        Drinks.add(Add);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel37.setText("Water bottle");

        jButton12.setText("Add");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/water.png"))); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12)
                .addGap(113, 113, 113))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(48, 48, 48))
        );

        Drinks.add(jPanel24);

        jPanel6.add(Drinks, "card4");

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New Order");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Settings");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Email");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem3.setText("Sign Out");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:NEw order
        
        NewOrder neworder = new NewOrder(foodcourt,this);
        neworder.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:Setting 
        Settings setting = new Settings(this, rootPaneCheckingEnabled,foodcourt);
        setting.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:email
        
        Email email = new Email(this, rootPaneCheckingEnabled,foodcourt);
        email.setVisible(true);
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menusidepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusidepanelMouseClicked
        // TODO add your handling code here:Side bar Menu click event 
     jPanel6.removeAll();
     //jPanel6.add(Menu);
     //jPanel6.add(container);
     jPanel6.add(jScrollPane1);
     jPanel6.repaint();
     jPanel6.revalidate();
       
    }//GEN-LAST:event_menusidepanelMouseClicked

    private void DashboardsidepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardsidepanelMouseClicked
     jPanel6.removeAll();
     jPanel6.add(Reports);
     jPanel6.repaint();
     jPanel6.revalidate();
 
    }//GEN-LAST:event_DashboardsidepanelMouseClicked

    private void DashboardsidepanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardsidepanelMouseEntered
        // TODO add your handling code here:
        Dashboardsidepanel.setBackground(Color.YELLOW);
       
    }//GEN-LAST:event_DashboardsidepanelMouseEntered

    private void DashboardsidepanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardsidepanelMouseExited
        // TODO add your handling code here:
         Dashboardsidepanel.setBackground(Color.white);
 
    }//GEN-LAST:event_DashboardsidepanelMouseExited

    private void menusidepanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusidepanelMouseEntered
        // TODO add your handling code here:
        menusidepanel.setBackground(Color.YELLOW);
      
    }//GEN-LAST:event_menusidepanelMouseEntered

    private void menusidepanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusidepanelMouseExited
        // TODO add your handling code here:
          menusidepanel.setBackground(Color.WHITE);
   
    }//GEN-LAST:event_menusidepanelMouseExited

    private void vbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vbutActionPerformed
        // TODO add your handling code here:
       
     
        AddCategory addCategory = new AddCategory(this, rootPaneCheckingEnabled,Categories,foodcourt);
        addCategory.setVisible(rootPaneCheckingEnabled);
        
    }//GEN-LAST:event_vbutActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        TodayCollection todaycollection = new  TodayCollection(this, rootPaneCheckingEnabled,foodcourt);
        todaycollection.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
               
        NewOrder neworder = new NewOrder(foodcourt,this);
        neworder.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        
        loginscreen.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menusidepanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusidepanel1MouseClicked
        // TODO add your handling code here
             jPanel6.removeAll();
     //jPanel6.add(Menu);
     //jPanel6.add(container);
     jPanel6.add(Drinks);
     jPanel6.repaint();
     jPanel6.revalidate();
    }//GEN-LAST:event_menusidepanel1MouseClicked

    private void menusidepanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusidepanel1MouseEntered
        // TODO add your handling code here:
               menusidepanel1.setBackground(Color.YELLOW);
    }//GEN-LAST:event_menusidepanel1MouseEntered

    private void menusidepanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusidepanel1MouseExited
        // TODO add your handling code here:
               menusidepanel1.setBackground(Color.WHITE);
    }//GEN-LAST:event_menusidepanel1MouseExited

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
              MenuItems menuItems = new MenuItems(this, rootPaneCheckingEnabled,foodcourt.getName(),"Cold Drinks");
             menuItems.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
  MenuItems menuItems = new MenuItems(this, rootPaneCheckingEnabled,foodcourt.getName(),"Water");
             menuItems.setVisible(rootPaneCheckingEnabled);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void CheckATUbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckATUbuttonActionPerformed
        // TODO add your handling code here:
             MenuInterface Dao2 = MenuFactory.GetInstance();
                try
                {
                   ArrayList<Menu_Items> list  =  Dao2.GetCatItemsQTY(foodcourt.getName());
                    for (int j = 0; j < list.size(); j++) {
                        
                        if(list.get(j).getCategory().equals("Cold Drinks")){
                            
                            if(Integer.parseInt(list.get(j).getQTY()) <=  Integer.parseInt(foodcourt.getColddrinkQTY())){
                                MessageString =  MessageString + list.get(j).getName() +" Low QTY ("+list.get(j).getQTY()+") ,";
                            }
                            
                        }else{
                         //Water  
                            if(Integer.parseInt(list.get(j).getQTY()) <=  Integer.parseInt(foodcourt.getWaterQTY())){
                                MessageString =  MessageString + list.get(j).getName() +" Low QTY ("+list.get(j).getQTY()+") ,";
                            }
                        }
                    }
                }
                catch (Exception ex) 
                {
                    System.out.println("Failed loading items"+ex);
                    return;
                }
        JOptionPane.showMessageDialog(this,
                     this.MessageString,
                     "",
                      JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_CheckATUbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Add;
    private javax.swing.JButton CheckATUbutton;
    private javax.swing.JLabel Clock;
    private javax.swing.JPanel Dashboardsidepanel;
    private javax.swing.JPanel Drinks;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Reports;
    private javax.swing.JLabel blab;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menusidepanel;
    private javax.swing.JPanel menusidepanel1;
    private javax.swing.JButton vbut;
    // End of variables declaration//GEN-END:variables
}
