/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import Classes.db;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewAllEmployee extends javax.swing.JFrame {
    
    private String userID;

    
    private int selectedEmployeeID;
    private String selectedFirstName, selectedLastName, selectedAddress, selectedPhoneNumber, 
                   selectedSSSNumber, selectedPhilhealthNumber, selectedTINNumber, 
                   selectedPagibigNumber, selectedStatus, selectedPosition, selectedImmediateSupervisor;
    
    private BigDecimal selectedBasicSalary, selectedRiceSubsidy, selectedPhoneAllowance,
                   selectedClothingAllowance, selectedGrossSemiMonthlyRate, selectedHourlyRate;
    private java.sql.Date selectedBirthday;  // Changed to java.sql.Date
    
    
    /**
     * Creates new form ViewAllEmployee
     */
    public ViewAllEmployee(String userID) {
        this.userID = userID;
        initComponents();
        fetchData(); // Calling the fetchData method so whenever a user goes to View All Employees, there would be data in the table
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
                String query = "SELECT * FROM employees";
                ResultSet rs = stmt.executeQuery(query);

                // Get the table model from jTable2
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
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
                        rs.getString("immediateSupervisor"),
                        rs.getString("basicSalary"),
                        rs.getString("riceSubsidy"),
                        rs.getString("phoneAllowance"),
                        rs.getString("clothingAllowance"),
                        rs.getString("grossSemiMonthlyRate"),
                        rs.getString("hourlyRate"),
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
                selectedBasicSalary = new BigDecimal(model.getValueAt(selectedRow, 13).toString());
                selectedRiceSubsidy = new BigDecimal(model.getValueAt(selectedRow, 14).toString());
                selectedPhoneAllowance = new BigDecimal(model.getValueAt(selectedRow, 15).toString());
                selectedClothingAllowance = new BigDecimal(model.getValueAt(selectedRow, 16).toString());
                selectedGrossSemiMonthlyRate = new BigDecimal(model.getValueAt(selectedRow, 17).toString());
                selectedHourlyRate = new BigDecimal(model.getValueAt(selectedRow, 18).toString());
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

        viewSingleEmployee = new Button.DarkButton();
        deleteEmployee = new Button.DarkButton();
        updateEmployee = new Button.DarkButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Dashboard = new Button.Button();
        Logout = new Button.Button();
        createEmployee = new Button.DarkButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewSingleEmployee.setText("View");
        viewSingleEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSingleEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(viewSingleEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 160, -1));

        deleteEmployee.setText("Delete");
        deleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(deleteEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 160, -1));

        updateEmployee.setText("Update");
        updateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(updateEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 160, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee Database");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 85, -1, -1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jTable2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Birthday", "Address", "Phone Number", "SSS Number", "Philhealth Number", "Tin Number", "Pagibig Number", "Status", "Position", "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate"
            }
        ));
        jTable2.setToolTipText("");
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
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

        createEmployee.setText("Create");
        createEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(createEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, 160, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/For Other Pages.png"))); // NOI18N
        background.setText("jLabel3");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardActionPerformed
        
        AdminHomeDashboard adminDashboard = new AdminHomeDashboard(userID);
        adminDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashboardActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void createEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEmployeeActionPerformed
        // Create an instance of the CreateLeaveRequest frame
        CreateEmployee createEmployee = new CreateEmployee(userID);
        // Set the visibility of the CreateLeaveRequest frame to true
        createEmployee.setVisible(true);
        // Close the leaveRequestDashboard Dashboard frame
        this.dispose(); // Assuming this is the Login frame
    }//GEN-LAST:event_createEmployeeActionPerformed

    private void updateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEmployeeActionPerformed
        UpdateEmployee updateEmployeeForm = new UpdateEmployee(
                selectedEmployeeID, selectedFirstName, selectedLastName, selectedBirthday, selectedAddress,
                selectedPhoneNumber, selectedSSSNumber, selectedPhilhealthNumber, selectedTINNumber,
                selectedPagibigNumber, selectedStatus, selectedPosition, selectedImmediateSupervisor,
                selectedBasicSalary, selectedRiceSubsidy, selectedPhoneAllowance, selectedClothingAllowance,
                selectedGrossSemiMonthlyRate, selectedHourlyRate, userID);
        updateEmployeeForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_updateEmployeeActionPerformed

    private void deleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployeeActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                // Get the connection from db class
                Connection conn = db.mycon();

                // Check if the connection is successful
                if (conn != null) {
                    // Create a statement
                    Statement stmt = conn.createStatement();

                    // Execute a query to delete the selected employee
                    String query = "DELETE FROM employees WHERE employeeID = " + selectedEmployeeID;
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
    }//GEN-LAST:event_deleteEmployeeActionPerformed

    private void viewSingleEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSingleEmployeeActionPerformed
         // Create an instance of ViewSingleEmployee and pass the selected employee's data
            ViewSingleEmployee viewSingleEmployeeForm = new ViewSingleEmployee(userID,
            selectedEmployeeID, selectedLastName, selectedFirstName, selectedBirthday, selectedAddress,
            selectedPhoneNumber, selectedSSSNumber, selectedPhilhealthNumber, selectedTINNumber,
            selectedPagibigNumber, selectedStatus, selectedPosition, selectedImmediateSupervisor,
            selectedBasicSalary, selectedRiceSubsidy, selectedPhoneAllowance, selectedClothingAllowance,
            selectedGrossSemiMonthlyRate, selectedHourlyRate);
    
            // Set the visibility of ViewSingleEmployee form to true
            viewSingleEmployeeForm.setVisible(true);
            // Close the current form
            this.dispose();
    }//GEN-LAST:event_viewSingleEmployeeActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAllEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private Button.DarkButton createEmployee;
    private Button.DarkButton deleteEmployee;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private Button.DarkButton updateEmployee;
    private Button.DarkButton viewSingleEmployee;
    // End of variables declaration//GEN-END:variables
}
