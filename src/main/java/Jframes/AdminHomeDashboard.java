/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

public class AdminHomeDashboard extends javax.swing.JFrame {
    
    public AdminHomeDashboard() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leaveRequestButton = new Button.Button();
        overtimeRequestButton = new Button.Button();
        btnViewEmployeeDatabase = new Button.Button();
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

        leaveRequestButton.setText("Leave Request");
        leaveRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveRequestButtonActionPerformed(evt);
            }
        });
        getContentPane().add(leaveRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 170, 40));

        overtimeRequestButton.setText("Overtime Request");
        getContentPane().add(overtimeRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 170, 40));

        btnViewEmployeeDatabase.setText("Employees Data");
        btnViewEmployeeDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEmployeeDatabaseActionPerformed(evt);
            }
        });
        getContentPane().add(btnViewEmployeeDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 170, 40));

        userAccountsButton.setText("User Accounts");
        userAccountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccountsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(userAccountsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 170, 40));

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
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AdminDashboardBackground.png"))); // NOI18N
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
        new viewLeaveAdmin().setVisible(true); dispose();
    }//GEN-LAST:event_leaveRequestButtonActionPerformed

    private void btnViewEmployeeDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEmployeeDatabaseActionPerformed
        // Redirects to Employee Database Page
        new ViewAllEmployee().setVisible(true); dispose();
    }//GEN-LAST:event_btnViewEmployeeDatabaseActionPerformed

    private void userAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAccountsButtonActionPerformed
        // Redirects to User Accounts Database Page
        new UserAccounts().setVisible(true); dispose();
    }//GEN-LAST:event_userAccountsButtonActionPerformed
	
	
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
    private com.toedter.calendar.JCalendar Calendar;
    private javax.swing.JLabel background;
    private Button.Button btnLogout;
    private Button.Button btnViewEmployeeDatabase;
    private javax.swing.JCheckBox checkboxAdminTask1;
    private javax.swing.JCheckBox checkboxAdminTask2;
    private javax.swing.JCheckBox checkboxAdminTask3;
    private javax.swing.JCheckBox checkboxAdminTask4;
    private Button.Button leaveRequestButton;
    private Button.Button overtimeRequestButton;
    private Button.Button userAccountsButton;
    // End of variables declaration//GEN-END:variables

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
