/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package advanced.java.course.project.program;

    import java.sql.Connection;
    import java.sql.Statement;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.ResultSetMetaData;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;

/**
 *
 * @author pierr
 */
public class MenuJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MenuJFrame
     */
    
    private static final String DB_URL = "jdbc:derby://localhost:1527/projectdb";
    
    public MenuJFrame() {
        initComponents();
        
        try
        {
            Connection conn = DriverManager.getConnection(DB_URL, "username", "password");
            Statement stmt = conn.createStatement();
            
            //Uncomment drop statements to reset tables in database.
            /*
            stmt.execute("DROP TABLE Sale");
            stmt.execute("DROP TABLE Customer");
            stmt.execute("DROP TABLE Inventory");
            */
            stmt.execute("CREATE TABLE Customer "
                       + "(ID CHAR(5) NOT NULL PRIMARY KEY,"
                       + "Name VARCHAR(30), Address VARCHAR(50),"
                       + "CreditLimit DOUBLE)");
            
            stmt.execute("CREATE TABLE Inventory "
                       + "(ID CHAR(3) NOT NULL PRIMARY KEY,"
                       + "Description VARCHAR(20), Price DOUBLE,"
                       + "AmountInStock INT, YearNum INT, Color VARCHAR(20))");
            
            stmt.execute("CREATE TABLE Sale "
                       + "(ID CHAR(5) NOT NULL PRIMARY KEY,"
                       + "CustID CHAR(5) NOT NULL REFERENCES Customer(ID),"
                       + "InventoryID CHAR(3) NOT NULL REFERENCES Inventory(ID),"
                       + "SaleDate VARCHAR(10))");
            
            //SAMPLE RECORDS FOR CUSTOMER TABLE
            
            stmt.executeUpdate("INSERT INTO Customer "
                             + "(ID, Name, Address, CreditLimit)"
                             + "VALUES "
                             + "('15865', 'Bob Smith', '101 North Street', 30000)");
            stmt.executeUpdate("INSERT INTO Customer "
                             + "(ID, Name, Address, CreditLimit)"
                             + "VALUES "
                             + "('98431', 'John Jones', '130 South Street', 50000)");
            stmt.executeUpdate("INSERT INTO Customer "
                             + "(ID, Name, Address, CreditLimit)"
                             + "VALUES "
                             + "('65124', 'George Patterson', '524 Westview Lane', 30000)");
            stmt.executeUpdate("INSERT INTO Customer "
                             + "(ID, Name, Address, CreditLimit)"
                             + "VALUES "
                             + "('78452', 'Tina Anderson', '159 East Street', 75000)");
            stmt.executeUpdate("INSERT INTO Customer "
                             + "(ID, Name, Address, CreditLimit)"
                             + "VALUES "
                             + "('95456', 'Jane Doe', '404 Error Lane', 100000)");
            
            //SAMPLE RECORDS FOR INVENTORY TABLE
            
            stmt.executeUpdate("INSERT INTO Inventory "
                             + "(ID, Description, Price, AmountInStock, YearNum, Color)"
                             + "VALUES "
                             + "('542', 'Toyota Camry', 20395, 7, 2015, 'Grey')");
            stmt.executeUpdate("INSERT INTO Inventory "
                             + "(ID, Description, Price, AmountInStock, YearNum, Color)"
                             + "VALUES "
                             + "('846', 'Honda CRV', 26400, 15, 2020, 'Blue')");
            stmt.executeUpdate("INSERT INTO Inventory "
                             + "(ID, Description, Price, AmountInStock, YearNum, Color)"
                             + "VALUES "
                             + "('462', 'Mazda CX-30', 22200, 5, 2018, 'White')");
            stmt.executeUpdate("INSERT INTO Inventory "
                             + "(ID, Description, Price, AmountInStock, YearNum, Color)"
                             + "VALUES "
                             + "('134', 'Ford Shelby GT500', 76555, 3, 2021, 'Black')");
            stmt.executeUpdate("INSERT INTO Inventory "
                             + "(ID, Description, Price, AmountInStock, YearNum, Color)"
                             + "VALUES "
                             + "('913', 'Chevy Silverado HD', 38500, 9, 2019, 'Red')");
            
            //SAMPLE RECORDS FOR SALE TABLE
            
            stmt.executeUpdate("INSERT INTO Sale "
                             + "(ID, CustID, InventoryID, SaleDate)"
                             + "VALUES "
                             + "('16448', '15865', '846', '05/22/2020')");
            stmt.executeUpdate("INSERT INTO Sale "
                             + "(ID, CustID, InventoryID, SaleDate)"
                             + "VALUES "
                             + "('02486', '95456', '134', '10/30/2020')");
            stmt.executeUpdate("INSERT INTO Sale "
                             + "(ID, CustID, InventoryID, SaleDate)"
                             + "VALUES "
                             + "('94513', '65124', '846', '06/14/2022')");
            stmt.executeUpdate("INSERT INTO Sale "
                             + "(ID, CustID, InventoryID, SaleDate)"
                             + "VALUES "
                             + "('75631', '98431', '913', '01/25/2019')");
            stmt.executeUpdate("INSERT INTO Sale "
                             + "(ID, CustID, InventoryID, SaleDate)"
                             + "VALUES "
                             + "('22349', '78452', '542', '04/19/2016')");
            
            conn.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(this, "There was an error loading the database:\n" + ex.getMessage(),
                                          "SQL Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            System.exit(0); 
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "There was an error loading the database:\n" + ex.getMessage(),
                                          "SQL Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            System.exit(0);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpMenu = new javax.swing.JTabbedPane();
        pnlSearch = new javax.swing.JPanel();
        btnAllItems = new javax.swing.JButton();
        btnCustName = new javax.swing.JButton();
        btnCustID = new javax.swing.JButton();
        btnSearchOrders = new javax.swing.JButton();
        btnLowStock = new javax.swing.JButton();
        pnlNew = new javax.swing.JPanel();
        btnNewCust = new javax.swing.JButton();
        btnNewItem = new javax.swing.JButton();
        mnubMenu = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuiExit = new javax.swing.JMenuItem();
        mnuAdd = new javax.swing.JMenu();
        mnuiNewCust = new javax.swing.JMenuItem();
        mnuiNewItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);

        tbpMenu.setPreferredSize(new java.awt.Dimension(400, 300));

        btnAllItems.setText("See All Items in Inventory");
        btnAllItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllItemsActionPerformed(evt);
            }
        });

        btnCustName.setText("Search Customers by Name");
        btnCustName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustNameActionPerformed(evt);
            }
        });

        btnCustID.setText("Search Customer by ID");
        btnCustID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustIDActionPerformed(evt);
            }
        });

        btnSearchOrders.setText("See All Orders By a Customer");
        btnSearchOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchOrdersActionPerformed(evt);
            }
        });

        btnLowStock.setText("See All Low Stock Items");
        btnLowStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLowStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLowStock, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllItems, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnAllItems)
                .addGap(18, 18, 18)
                .addComponent(btnCustName)
                .addGap(18, 18, 18)
                .addComponent(btnCustID)
                .addGap(18, 18, 18)
                .addComponent(btnSearchOrders)
                .addGap(18, 18, 18)
                .addComponent(btnLowStock)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        tbpMenu.addTab("Search", pnlSearch);

        btnNewCust.setText("Enter a New Customer");
        btnNewCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCustActionPerformed(evt);
            }
        });

        btnNewItem.setText("Enter a New Item Into Inventory");
        btnNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNewLayout = new javax.swing.GroupLayout(pnlNew);
        pnlNew.setLayout(pnlNewLayout);
        pnlNewLayout.setHorizontalGroup(
            pnlNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(pnlNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewCust, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        pnlNewLayout.setVerticalGroup(
            pnlNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnNewCust)
                .addGap(18, 18, 18)
                .addComponent(btnNewItem)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        tbpMenu.addTab("New", pnlNew);

        mnuFile.setText("File");

        mnuiExit.setText("Exit");
        mnuiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuiExit);

        mnubMenu.add(mnuFile);

        mnuAdd.setText("Add");

        mnuiNewCust.setText("New Customer");
        mnuiNewCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiNewCustActionPerformed(evt);
            }
        });
        mnuAdd.add(mnuiNewCust);

        mnuiNewItem.setText("New Inventory Item");
        mnuiNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiNewItemActionPerformed(evt);
            }
        });
        mnuAdd.add(mnuiNewItem);

        mnubMenu.add(mnuAdd);

        setJMenuBar(mnubMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiExitActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_mnuiExitActionPerformed

    private void btnNewCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCustActionPerformed
        NewCustJFrame newCust = new NewCustJFrame();
        newCust.setVisible(true);
    }//GEN-LAST:event_btnNewCustActionPerformed

    private void mnuiNewCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiNewCustActionPerformed
        NewCustJFrame newCust = new NewCustJFrame();
        newCust.setVisible(true);
    }//GEN-LAST:event_mnuiNewCustActionPerformed

    private void btnCustNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustNameActionPerformed
        SearchNameJFrame searchName = new SearchNameJFrame();
        searchName.setVisible(true);
    }//GEN-LAST:event_btnCustNameActionPerformed

    private void btnNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewItemActionPerformed
        NewItemJFrame newItem = new NewItemJFrame();
        newItem.setVisible(true);
    }//GEN-LAST:event_btnNewItemActionPerformed

    private void mnuiNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiNewItemActionPerformed
        NewItemJFrame newItem = new NewItemJFrame();
        newItem.setVisible(true);
    }//GEN-LAST:event_mnuiNewItemActionPerformed

    private void btnAllItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllItemsActionPerformed
        InventoryJFrame seeInventory = new InventoryJFrame();
        seeInventory.setVisible(true);
    }//GEN-LAST:event_btnAllItemsActionPerformed

    private void btnCustIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustIDActionPerformed
        SearchIDJFrame searchID = new SearchIDJFrame();
        searchID.setVisible(true);
    }//GEN-LAST:event_btnCustIDActionPerformed

    private void btnLowStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLowStockActionPerformed
        LowStockJFrame lowStock = new LowStockJFrame();
        lowStock.setVisible(true);
    }//GEN-LAST:event_btnLowStockActionPerformed

    private void btnSearchOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchOrdersActionPerformed
        SearchOrdersJFrame searchOrders = new SearchOrdersJFrame();
        searchOrders.setVisible(true);
    }//GEN-LAST:event_btnSearchOrdersActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllItems;
    private javax.swing.JButton btnCustID;
    private javax.swing.JButton btnCustName;
    private javax.swing.JButton btnLowStock;
    private javax.swing.JButton btnNewCust;
    private javax.swing.JButton btnNewItem;
    private javax.swing.JButton btnSearchOrders;
    private javax.swing.JMenu mnuAdd;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuBar mnubMenu;
    private javax.swing.JMenuItem mnuiExit;
    private javax.swing.JMenuItem mnuiNewCust;
    private javax.swing.JMenuItem mnuiNewItem;
    private javax.swing.JPanel pnlNew;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JTabbedPane tbpMenu;
    // End of variables declaration//GEN-END:variables
}
