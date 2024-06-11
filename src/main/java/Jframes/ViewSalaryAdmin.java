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
public class ViewSalaryAdmin extends javax.swing.JFrame {

    private int selectedEmployeeID;
    private String selectedFirstName, selectedLastName, selectedAddress, selectedPhoneNumber, 
                   selectedSSSNumber, selectedPhilhealthNumber, selectedTINNumber, 
                   selectedPagibigNumber, selectedStatus, selectedPosition, selectedImmediateSupervisor;
    private java.sql.Date selectedBirthday;  // Changed to java.sql.Date
    
    public ViewSalaryAdmin() {
        initComponents();
        fetchData();
        addTableListener();
        //addActionListeners();
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
    /*private void updateEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
    } */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDashboard = new Button.Button();
        btnLogout = new Button.Button();
        Label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        viewSalary = new Button.DarkButton();
        deleteSalary = new Button.DarkButton();
        updateSalary = new Button.DarkButton();
        createSalary = new Button.DarkButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDashboard.setText("Dashboard");
        btnDashboard.setToolTipText("");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 30));

        btnLogout.setText("Logout");
        btnLogout.setToolTipText("");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 120, 30));

        Label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Label.setForeground(new java.awt.Color(255, 255, 255));
        Label.setText("Salary Database");
        getContentPane().add(Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 940, 390));

        viewSalary.setText("View");
        viewSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(viewSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 160, -1));

        deleteSalary.setText("Delete");
        deleteSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(deleteSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 160, -1));

        updateSalary.setText("Update");
        updateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(updateSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 160, -1));

        createSalary.setText("Create");
        createSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(createSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/For Other Pages.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // Redirects to Admin Dashboard
        new AdminHomeDashboard().setVisible(true); dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // Create an instance of LoginNew and display it
        new LogInNew().setVisible(true); dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void createSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSalaryActionPerformed
        new CreateSalary().setVisible(true); dispose();
    }//GEN-LAST:event_createSalaryActionPerformed

    private void deleteSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSalaryActionPerformed

    }//GEN-LAST:event_deleteSalaryActionPerformed

    private void viewSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSalaryActionPerformed
        
    }//GEN-LAST:event_viewSalaryActionPerformed

    private void updateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateSalaryActionPerformed

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
            java.util.logging.Logger.getLogger(ViewSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSalaryAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Label;
    private Button.Button btnDashboard;
    private Button.Button btnLogout;
    private Button.DarkButton createSalary;
    private Button.DarkButton deleteSalary;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private Button.DarkButton updateSalary;
    private Button.DarkButton viewSalary;
    // End of variables declaration//GEN-END:variables
}
