/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import Classes.db;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author STUDY MODE
 */
public class AdminHomeDashboard extends javax.swing.JFrame {

    private int selectedEmployeeID;
    private String selectedFirstName, selectedLastName, selectedAddress, selectedPhoneNumber, 
                   selectedSSSNumber, selectedPhilhealthNumber, selectedTINNumber, 
                   selectedPagibigNumber, selectedStatus, selectedPosition, selectedImmediateSupervisor;
    private java.sql.Date selectedBirthday;  // Changed to java.sql.Date
    
    public AdminHomeDashboard() {
        initComponents();
        fetchData();
        addTableListener();
        addActionListeners();
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
    
    private void addTableListener() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTable1.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                
                // Assuming the ID is in the first column
                selectedEmployeeID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                selectedLastName = model.getValueAt(selectedRow, 1).toString();
                selectedFirstName = model.getValueAt(selectedRow, 2).toString();
                selectedBirthday = new java.sql.Date(((java.util.Date) model.getValueAt(selectedRow, 3)).getTime());
                selectedAddress = model.getValueAt(selectedRow, 4).toString();
                selectedPhoneNumber = model.getValueAt(selectedRow, 5).toString();
                selectedSSSNumber = model.getValueAt(selectedRow, 6).toString();
                selectedPhilhealthNumber = model.getValueAt(selectedRow, 7).toString();
                selectedTINNumber = model.getValueAt(selectedRow, 8).toString();
                selectedPagibigNumber = model.getValueAt(selectedRow, 9).toString();
                selectedStatus = model.getValueAt(selectedRow, 10).toString();
                selectedPosition = model.getValueAt(selectedRow, 11).toString();
                selectedImmediateSupervisor = model.getValueAt(selectedRow, 12).toString();
            }
        });
    }
    private void updateEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        UpdateEmployee updateEmployeeForm = new UpdateEmployee(
                selectedEmployeeID, selectedFirstName, selectedLastName, selectedBirthday, selectedAddress,
                selectedPhoneNumber, selectedSSSNumber, selectedPhilhealthNumber, selectedTINNumber,
                selectedPagibigNumber, selectedStatus, selectedPosition, selectedImmediateSupervisor);
        updateEmployeeForm.setVisible(true);
        this.dispose();
    }
    
    private void addActionListeners() {
        updateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmployeeButtonActionPerformed(evt);
            }
        });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deleteEmployee1 = new Button.Button();
        deleteEmployee = new Button.Button();
        updateEmployee = new Button.Button();
        createEmployee = new Button.Button();
        leaveRequestButton = new Button.Button();
        overtimeRequestButton = new Button.Button();
        userAccountsButton = new Button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteEmployee1.setText("View");
        getContentPane().add(deleteEmployee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 480, 160, -1));

        deleteEmployee.setText("Delete");
        getContentPane().add(deleteEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 160, -1));

        updateEmployee.setText("Update");
        getContentPane().add(updateEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 160, -1));

        createEmployee.setText("Create");
        getContentPane().add(createEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 160, -1));

        leaveRequestButton.setText("Leave Request");
        getContentPane().add(leaveRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 170, -1));

        overtimeRequestButton.setText("Overtime Request");
        getContentPane().add(overtimeRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 170, -1));

        userAccountsButton.setText("User Accounts");
        getContentPane().add(userAccountsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 170, -1));

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
        updateEmployeeButtonActionPerformed(evt);
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
    private Button.Button createEmployee;
    private Button.Button deleteEmployee;
    private Button.Button deleteEmployee1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private Button.Button leaveRequestButton;
    private Button.Button overtimeRequestButton;
    private Button.Button updateEmployee;
    private Button.Button userAccountsButton;
    // End of variables declaration//GEN-END:variables

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
