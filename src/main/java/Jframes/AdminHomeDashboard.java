/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import Classes.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author STUDY MODE
 */
public class AdminHomeDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminHomeDashboard
     */
    public AdminHomeDashboard() {
        initComponents();
        fetchData();
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
                String query = "SELECT * FROM employees";
                ResultSet rs = stmt.executeQuery(query);

                // Get the table model from jTable2
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0); // Clear existing data

                // Add rows to the table model
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("employeeID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("birthday"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        rs.getString("sssNumber"),
                        rs.getString("philhealthNumber"),
                        rs.getString("tinNumber"),
                        rs.getString("pagibigNumber"),
                        rs.getString("status"),
                        rs.getString("position"),
                        rs.getString("immediateSupervisor")
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button7 = new Button.Button();
        btnUserAccounts = new Button.Button();
        btnLeaveRequest = new Button.Button();
        btnOvertimeRequest = new Button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnViewDashboard = new Button.Button();
        btnCreateDashboard = new Button.Button();
        btnUpdateDashboard = new Button.Button();
        btnDeleteDashboard = new Button.Button();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button7.setText("Logout");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        getContentPane().add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, 30));

        btnUserAccounts.setText("User Accounts");
        getContentPane().add(btnUserAccounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 170, 50));

        btnLeaveRequest.setText("Leave Request");
        btnLeaveRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveRequestActionPerformed(evt);
            }
        });
        getContentPane().add(btnLeaveRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 170, 50));

        btnOvertimeRequest.setText("Overtime Request");
        getContentPane().add(btnOvertimeRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Last Name", "First Name", "Birthday", "Address", "Phone Number", "SSS #", "PhilHealth #", "TIN #", "Pag-ibig #", "Status", "Position", "ImmediateSupervisor", "Basic Salary", "Rice Subsidy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(11).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(12).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(13).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 720, 280));

        btnViewDashboard.setText("View");
        btnViewDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btnViewDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, 170, 40));

        btnCreateDashboard.setText("Create");
        btnCreateDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateDashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 170, 40));

        btnUpdateDashboard.setText("Update");
        btnUpdateDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, 170, 40));

        btnDeleteDashboard.setText("Delete");
        getContentPane().add(btnDeleteDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 170, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AdminDashboardBackground.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed

        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button7ActionPerformed

    private void btnCreateDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateDashboardActionPerformed
        // TODO add your handling code here:
        CreateEmployee create = new CreateEmployee();
        create.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCreateDashboardActionPerformed

    private void btnViewDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDashboardActionPerformed
        // TODO add your handling code here:
        ViewAllEmployee view = new ViewAllEmployee();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewDashboardActionPerformed

    private void btnUpdateDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDashboardActionPerformed
        // TODO add your handling code here:
        UpdateEmployee update = new UpdateEmployee();
        update.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUpdateDashboardActionPerformed

    private void btnLeaveRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveRequestActionPerformed
        // TODO add your handling code here:
        viewLeaveAdmin viewLeaveAdmin = new viewLeaveAdmin();
        viewLeaveAdmin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLeaveRequestActionPerformed

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
            java.util.logging.Logger.getLogger(AdminHomeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHomeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHomeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHomeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHomeDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private Button.Button btnCreateDashboard;
    private Button.Button btnDeleteDashboard;
    private Button.Button btnLeaveRequest;
    private Button.Button btnOvertimeRequest;
    private Button.Button btnUpdateDashboard;
    private Button.Button btnUserAccounts;
    private Button.Button btnViewDashboard;
    private Button.Button button7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
