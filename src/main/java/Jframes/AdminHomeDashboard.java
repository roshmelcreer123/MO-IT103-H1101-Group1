
package Jframes;

import Classes.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import Archived.SalaryDashboard;
import javax.swing.JOptionPane;

public class AdminHomeDashboard extends javax.swing.JFrame {
    
    private String userID;
    
    public AdminHomeDashboard(String userID) {
        this.userID = userID;
        initComponents();
        loadUserData(userID);
    }
    
    private void loadUserData(String userID) {
        try {
            Connection conn = db.mycon();
            String query = "SELECT * FROM `user_accounts` WHERE `userID`=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, userID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String position = rs.getString("position");
                String profilePicturePath = rs.getString("profilePicturePath");

                employeeNameLabel.setText(firstName + " " + lastName);
                positionLabel.setText(position);
                if (profilePicturePath != null && !profilePicturePath.isEmpty()) {
                    employeeProfilePicture.setIcon(new ImageIcon(profilePicturePath));
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        employeeProfilePicture = new javax.swing.JLabel();
        employeeNameLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        salaryButton = new Button.Button();
        leaveRequestButton = new Button.Button();
        overtimeRequestButton = new Button.Button();
        btnViewEmployeeDatabase = new Button.Button();
        attendanceSalaryButton = new Button.Button();
        userAccountsButton = new Button.Button();
        btnLogout = new Button.Button();
        Calendar = new com.toedter.calendar.JCalendar();
        checkboxAdminTask1 = new javax.swing.JCheckBox();
        checkboxAdminTask2 = new javax.swing.JCheckBox();
        checkboxAdminTask3 = new javax.swing.JCheckBox();
        checkboxAdminTask4 = new javax.swing.JCheckBox();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adminProfilePicture.png"))); // NOI18N
        getContentPane().add(employeeProfilePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        employeeNameLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        employeeNameLabel.setForeground(new java.awt.Color(54, 117, 136));
        employeeNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        employeeNameLabel.setText("Employee Name");
        employeeNameLabel.setToolTipText("");
        getContentPane().add(employeeNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 240, 210, -1));

        positionLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        positionLabel.setForeground(new java.awt.Color(54, 117, 136));
        positionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        positionLabel.setText("Position");
        positionLabel.setToolTipText("");
        getContentPane().add(positionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 210, 20));

        salaryButton.setText("Salary");
        salaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(salaryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 170, 40));

        leaveRequestButton.setText("Leave Request");
        leaveRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveRequestButtonActionPerformed(evt);
            }
        });
        getContentPane().add(leaveRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 435, 170, 40));

        overtimeRequestButton.setText("Overtime Request");
        overtimeRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overtimeRequestButtonActionPerformed(evt);
            }
        });
        getContentPane().add(overtimeRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 170, 40));

        btnViewEmployeeDatabase.setText("Employees Data");
        btnViewEmployeeDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEmployeeDatabaseActionPerformed(evt);
            }
        });
        getContentPane().add(btnViewEmployeeDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 170, 40));

        attendanceSalaryButton.setText("Attendance");
        attendanceSalaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceSalaryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(attendanceSalaryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 345, 170, 40));

        userAccountsButton.setText("User Accounts");
        userAccountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccountsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(userAccountsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 525, 170, 40));

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 10, 100, 30));

        Calendar.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 370, 220, 180));

        checkboxAdminTask1.setBackground(new java.awt.Color(255, 255, 255));
        checkboxAdminTask1.setForeground(new java.awt.Color(0, 153, 153));
        getContentPane().add(checkboxAdminTask1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, -1));

        checkboxAdminTask2.setBackground(new java.awt.Color(255, 255, 255));
        checkboxAdminTask2.setForeground(new java.awt.Color(0, 153, 153));
        getContentPane().add(checkboxAdminTask2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, -1, -1));

        checkboxAdminTask3.setBackground(new java.awt.Color(255, 255, 255));
        checkboxAdminTask3.setForeground(new java.awt.Color(0, 153, 153));
        getContentPane().add(checkboxAdminTask3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, -1, -1));

        checkboxAdminTask4.setBackground(new java.awt.Color(255, 255, 255));
        checkboxAdminTask4.setForeground(new java.awt.Color(0, 153, 153));
        getContentPane().add(checkboxAdminTask4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, -1, -1));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(0, 153, 153));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Admin Dashboard Background New.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // Redirects to Login Dashboard Page
        new LogInNew().setVisible(true); dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void leaveRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveRequestButtonActionPerformed
        // Redirects to Admin Leave Request Page
        new viewLeaveAdmin(userID).setVisible(true); dispose();
    }//GEN-LAST:event_leaveRequestButtonActionPerformed

    private void btnViewEmployeeDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEmployeeDatabaseActionPerformed
        // Redirects to Employee Database Page
        new ViewAllEmployee(userID).setVisible(true); dispose();
    }//GEN-LAST:event_btnViewEmployeeDatabaseActionPerformed

    private void attendanceSalaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceSalaryButtonActionPerformed
        // Redirects to User Accounts Database Page
        new AttendanceDashboardAdmin(userID).setVisible(true); dispose();
    }//GEN-LAST:event_attendanceSalaryButtonActionPerformed

    private void userAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAccountsButtonActionPerformed
        new UserAccounts(userID).setVisible(true); dispose();
    }//GEN-LAST:event_userAccountsButtonActionPerformed

    private void salaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryButtonActionPerformed
        new ViewSalaryAdmin(userID).setVisible(true); dispose();
    }//GEN-LAST:event_salaryButtonActionPerformed

    private void overtimeRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overtimeRequestButtonActionPerformed
        // TODO add your handling code here:
        new OvertimeRequestAdmin(userID).setVisible(true); dispose();
    }//GEN-LAST:event_overtimeRequestButtonActionPerformed
	
	
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
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar Calendar;
    private Button.Button attendanceSalaryButton;
    private javax.swing.JLabel background;
    private Button.Button btnLogout;
    private Button.Button btnViewEmployeeDatabase;
    private javax.swing.JCheckBox checkboxAdminTask1;
    private javax.swing.JCheckBox checkboxAdminTask2;
    private javax.swing.JCheckBox checkboxAdminTask3;
    private javax.swing.JCheckBox checkboxAdminTask4;
    private javax.swing.JLabel employeeNameLabel;
    private javax.swing.JLabel employeeProfilePicture;
    private Button.Button leaveRequestButton;
    private Button.Button overtimeRequestButton;
    private javax.swing.JLabel positionLabel;
    private Button.Button salaryButton;
    private Button.Button userAccountsButton;
    // End of variables declaration//GEN-END:variables

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
