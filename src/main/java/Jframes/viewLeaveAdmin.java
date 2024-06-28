/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import Classes.db; // Import the db class
import java.sql.*;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;


public class viewLeaveAdmin extends javax.swing.JFrame {
    
    private String userID;

    /**
     * Creates new form leaveRequestHistory
     */
    public viewLeaveAdmin(String userID) {
        this.userID = userID;
        initComponents();
        fetchData(); // Calling the fetchData method so whenever a user goes to View All Employees, there would be data in the table
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
                String query = "SELECT * FROM leave_requests";
                ResultSet rs = stmt.executeQuery(query);

                // Get the table model from jTable2
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.setRowCount(0); // Clear existing data

                // Add rows to the table model
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("employeeID"),
                        rs.getString("employeeName"),
                        rs.getString("leaveType"),
                        rs.getString("manager"),
                        rs.getString("reason"),
                        rs.getString("startDate"),
                        rs.getString("endDate"),
                        rs.getString("status"),
                        rs.getString("dateRequested"),
                        rs.getString("dateApproved")
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Logout = new Button.Button();
        Dashboard = new Button.Button();
        jComboBox1 = new javax.swing.JComboBox<>();
        darkButton1 = new Button.DarkButton();
        darkButton3 = new Button.DarkButton();
        button1 = new Button.Button();
        button2 = new Button.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        background = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Leave Request");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 85, -1, -1));

        Logout.setText("Logout");
        Logout.setToolTipText("");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 120, 30));

        Dashboard.setText("Dashboard");
        Dashboard.setToolTipText("");
        Dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardActionPerformed(evt);
            }
        });
        getContentPane().add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 120, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Approved", "Declined", " " }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        darkButton1.setText("Request Leave");
        darkButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(darkButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, -1, -1));

        darkButton3.setText("Filter Requests");
        darkButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(darkButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 150, -1));

        button1.setText("Accept");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        button2.setText("Decline");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Employee Name", "Leave Type", "Manager", "Reason for Leave", "Start Date of Leave", "End Date of Leave", "Status", "Date Requested", "Date Approved"
            }
        ));
        jTable2.setToolTipText("");
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 940, 390));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/For Other Pages.png"))); // NOI18N
        background.setText("jLabel3");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void darkButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkButton1ActionPerformed
        // Create an instance of the CreateLeaveRequest frame
        RequestLeaveAdmin requestLeaveAdmin = new RequestLeaveAdmin(userID);
        // Set the visibility of the CreateLeaveRequest frame to true
        requestLeaveAdmin.setVisible(true);
        // Close the leaveRequestDashboard Dashboard frame
        this.dispose(); // Assuming this is the Login frame
    }//GEN-LAST:event_darkButton1ActionPerformed

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardActionPerformed
        // Create an instance of the Dashboard frame
        AdminHomeDashboard dashboard = new AdminHomeDashboard(userID);
        // Set the visibility of the Dashboard frame to true
        dashboard.setVisible(true);
        // Close the leaveRequest Dashboard frame
        this.dispose(); // Assuming this is the Login frame
    }//GEN-LAST:event_DashboardActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void darkButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_darkButton3ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // Get the selected row index
    int selectedRow = jTable2.getSelectedRow();
    
    // Check if a row is selected
    if (selectedRow != -1) {
        // Get the current status of the selected row
        String currentStatus = (String) jTable2.getValueAt(selectedRow, 7); // Assuming the 8th column is "Status"
        
        // Check if the current status is "Pending"
        if ("Pending".equals(currentStatus)) {
            // Update the status to "Approved" in the table model
            jTable2.setValueAt("Approved", selectedRow, 7);
            
            // Get the employeeID of the selected row (assuming the 1st column is "employeeID")
            String employeeID = (String) jTable2.getValueAt(selectedRow, 0);
            
            // Update the status in the database
            try {
                // Get the connection from db class
                Connection conn = db.mycon();
                
                // Check if the connection is successful
                if (conn != null) {
                    // Create a prepared statement to update the status
                    String query = "UPDATE leave_requests SET status = ?, dateApproved = ? WHERE employeeID = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, "Approved");
                    pstmt.setDate(2, new java.sql.Date(System.currentTimeMillis())); // Assuming you want to set the current date
                    pstmt.setString(3, employeeID);
                    
                    // Execute the update
                    pstmt.executeUpdate();
                    
                    // Close the connection
                    pstmt.close();
                    conn.close();
                    
                    // Optionally, show a message dialog to indicate success
                    javax.swing.JOptionPane.showMessageDialog(this, "Leave request approved successfully!");
                } else {
                    System.out.println("Failed to make connection!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Optionally, show a message dialog if the status is not "Pending"
            javax.swing.JOptionPane.showMessageDialog(this, "Selected leave request is not in Pending status!");
        }
    } else {
        // Optionally, show a message dialog if no row is selected
        javax.swing.JOptionPane.showMessageDialog(this, "No row selected!");
    }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
          // Get the selected row index
    int selectedRow = jTable2.getSelectedRow();
    
    // Check if a row is selected
    if (selectedRow != -1) {
        // Get the current status of the selected row
        String currentStatus = (String) jTable2.getValueAt(selectedRow, 7); // Assuming the 8th column is "Status"
        
        // Check if the current status is "Pending"
        if ("Pending".equals(currentStatus)) {
            // Update the status to "Declined" in the table model
            jTable2.setValueAt("Declined", selectedRow, 7);
            
            // Get the employeeID of the selected row (assuming the 1st column is "employeeID")
            String employeeID = (String) jTable2.getValueAt(selectedRow, 0);
            
            // Update the status in the database
            try {
                // Get the connection from db class
                Connection conn = db.mycon();
                
                // Check if the connection is successful
                if (conn != null) {
                    // Create a prepared statement to update the status
                    String query = "UPDATE leave_requests SET status = ? WHERE employeeID = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, "Declined");
                    pstmt.setString(2, employeeID);
                    
                    // Execute the update
                    pstmt.executeUpdate();
                    
                    // Close the connection
                    pstmt.close();
                    conn.close();
                    
                    // Optionally, show a message dialog to indicate success
                    javax.swing.JOptionPane.showMessageDialog(this, "Leave request declined successfully!");
                } else {
                    System.out.println("Failed to make connection!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Optionally, show a message dialog if the status is not "Pending"
            javax.swing.JOptionPane.showMessageDialog(this, "Selected leave request is not in Pending status!");
        }
    } else {
        // Optionally, show a message dialog if no row is selected
        javax.swing.JOptionPane.showMessageDialog(this, "No row selected!");
    }
    }//GEN-LAST:event_button2ActionPerformed

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
            java.util.logging.Logger.getLogger(viewLeaveAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewLeaveAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewLeaveAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewLeaveAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button.Button Dashboard;
    private Button.Button Logout;
    private javax.swing.JLabel background;
    private Button.Button button1;
    private Button.Button button2;
    private Button.DarkButton darkButton1;
    private Button.DarkButton darkButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
