
package Jframes;

import Classes.db;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserAccounts extends javax.swing.JFrame {

    
    private int selectedEmployeeID;
    private String selectedUserID, selectedPassword, selectedLastName,selectedFirstName,
                   selectedPosition, selectedUserType;
  
    
    
    /**
     * Creates new form ViewAllEmployee
     */
    public UserAccounts() {
        initComponents();
        fetchData(); // Calling the fetchData method so whenever a user goes to UserAccounts, there would be data in the table
        addTableListener();
    }
    
    private void fetchData() {
        try {
            // Get the connection from db class
            Connection conn = db.mycon();

            // Check if the connection is successful
            if (conn != null) {
                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query to retrieve data from the employees table
                String query = "SELECT * FROM user_accounts";
                ResultSet rs = stmt.executeQuery(query);

                // Get the table model from jTable2
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.setRowCount(0); // Clear existing data

                // Add rows to the table model
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("userID"),
                        rs.getInt("employeeID"),
                        rs.getString("password"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getString("position"),
                        rs.getString("userType")
                    });
                }

                // Close the connection
                rs.close();
                stmt.close();
                conn.close();
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // This is used to get the row then pass it to the UpdateEmployee
    private void addTableListener() {
        jTable2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTable2.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                
                // Assuming the ID is in the first column
                selectedUserID = model.getValueAt(selectedRow, 0).toString();
                selectedEmployeeID = Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
                selectedPassword = model.getValueAt(selectedRow, 2).toString();
                selectedLastName = model.getValueAt(selectedRow, 3).toString();
                selectedFirstName = model.getValueAt(selectedRow, 4).toString();
                selectedPosition = model.getValueAt(selectedRow, 5).toString();
                selectedUserType = model.getValueAt(selectedRow, 6).toString();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deleteUserAccount = new Button.DarkButton();
        updateUserAccount = new Button.DarkButton();
        createUserAccount = new Button.DarkButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Dashboard = new Button.Button();
        Logout = new Button.Button();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteUserAccount.setText("Delete");
        deleteUserAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserAccountActionPerformed(evt);
            }
        });
        getContentPane().add(deleteUserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 160, -1));

        updateUserAccount.setText("Update");
        updateUserAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserAccountActionPerformed(evt);
            }
        });
        getContentPane().add(updateUserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 160, -1));

        createUserAccount.setText("Create");
        createUserAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserAccountActionPerformed(evt);
            }
        });
        getContentPane().add(createUserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, 160, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Accounts Database");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 40));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jTable2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Employee ID", "Password", "Last Name", "First Name", "Position", "User Type"
            }
        ));
        jTable2.setToolTipText("");
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 940, 390));

        Dashboard.setText("Dashboard");
        Dashboard.setToolTipText("");
        Dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardActionPerformed(evt);
            }
        });
        getContentPane().add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 120, 30));

        Logout.setText("Logout");
        Logout.setToolTipText("");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 120, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/For Other Pages.png"))); // NOI18N
        background.setText("jLabel3");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardActionPerformed
        
        AdminHomeDashboard adminDashboard = new AdminHomeDashboard();
        adminDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashboardActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void createUserAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserAccountActionPerformed
        // Create an instance of the CreateLeaveRequest frame
        CreateUserAccount createUserAccount = new CreateUserAccount();
        // Set the visibility of the CreateLeaveRequest frame to true
        createUserAccount.setVisible(true);
        // Close the leaveRequestDashboard Dashboard frame
        this.dispose(); // Assuming this is the Login frame
    }//GEN-LAST:event_createUserAccountActionPerformed

    private void updateUserAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserAccountActionPerformed
        UpdateUserAccount updateUserAccountForm = new UpdateUserAccount(
                selectedUserID, selectedEmployeeID, selectedPassword, selectedLastName, selectedFirstName, 
                selectedPosition, selectedUserType);
        updateUserAccountForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_updateUserAccountActionPerformed

    private void deleteUserAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserAccountActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user account?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                // Get the connection from db class
                Connection conn = db.mycon();

                // Check if the connection is successful
                if (conn != null) {
                    // Create a statement
                    Statement stmt = conn.createStatement();

                    // Execute a query to delete the selected employee
                    String query = "DELETE FROM user_accounts WHERE userID = " + selectedUserID;
                    int rowsAffected = stmt.executeUpdate(query);

                    // Check if deletion was successful
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Employee deleted successfully");
                        // Refresh the table
                        fetchData();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete employee");
                    }

                    // Close the connection
                    stmt.close();
                    conn.close();
                } else {
                    System.out.println("Failed to make connection!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   
    }//GEN-LAST:event_deleteUserAccountActionPerformed

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
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAccounts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button.Button Dashboard;
    private Button.Button Logout;
    private javax.swing.JLabel background;
    private Button.DarkButton createUserAccount;
    private Button.DarkButton deleteUserAccount;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private Button.DarkButton updateUserAccount;
    // End of variables declaration//GEN-END:variables
}
