
package Jframes;

import Classes.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class LogInNew extends javax.swing.JFrame {

    /**
     * Creates new form LogInPage
     */
    public LogInNew() {
        initComponents();
        
        textUser.setBackground(new java.awt.Color(0,0,0,1));
        jPasswordField1.setBackground(new java.awt.Color(0,0,0,1));
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
        userLogInLabel = new javax.swing.JLabel();
        enterUserIDLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        selectUserTypeLabel = new javax.swing.JLabel();
        userTypeComboBox = new javax.swing.JComboBox<>();
        textUser = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        loginButton = new Button.Button();
        forgotPasswordLabel1 = new javax.swing.JLabel();
        LogInBackground = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userLogInLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        userLogInLabel.setForeground(new java.awt.Color(245, 245, 245));
        userLogInLabel.setText("USER LOGIN");
        getContentPane().add(userLogInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, -1, 30));

        enterUserIDLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        enterUserIDLabel.setText("Enter User ID");
        getContentPane().add(enterUserIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 130, 30));

        passwordLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        passwordLabel.setText("Password");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 110, 20));

        selectUserTypeLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        selectUserTypeLabel.setText("Select User Type");
        getContentPane().add(selectUserTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 140, 20));

        userTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "Admin", "IT" }));
        getContentPane().add(userTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, -1, -1));

        textUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textUser.setForeground(new java.awt.Color(0, 206, 209));
        textUser.setBorder(null);
        textUser.setCaretColor(new java.awt.Color(0, 206, 209));
        getContentPane().add(textUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 290, 40));

        jPasswordField1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 206, 209));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPasswordField1.setCaretColor(new java.awt.Color(0, 206, 209));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 290, 40));

        loginButton.setText("Login");
        loginButton.setToolTipText("");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 100, 30));

        forgotPasswordLabel1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        forgotPasswordLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotPasswordLabel1.setText("Forgot Password?");
        getContentPane().add(forgotPasswordLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 120, -1));

        LogInBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LoginBackgroundNew.png"))); // NOI18N
        LogInBackground.setText("jLabel3");
        getContentPane().add(LogInBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String userID = textUser.getText();
        String password = new String(jPasswordField1.getPassword());
        String userType = userTypeComboBox.getSelectedItem().toString();

        try {
            Connection conn = db.mycon();
            String query = "SELECT * FROM `user_accounts` WHERE `userID`=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, userID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                query = "SELECT * FROM `user_accounts` WHERE `userID`=? AND `password`=? AND `userType`=?";
                pst = conn.prepareStatement(query);
                pst.setString(1, userID);
                pst.setString(2, password);
                pst.setString(3, userType);
                rs = pst.executeQuery();

                if (rs.next()) {
                    if (userType.equals("Admin")) {
                        AdminHomeDashboard adminDashboard = new AdminHomeDashboard();
                        adminDashboard.setVisible(true);
                    } else if (userType.equals("IT")) {
                        AdminHomeDashboard itDashboard = new AdminHomeDashboard();
                        itDashboard.setVisible(true);
                    } else {
                        HomeDashboard dashboard = new HomeDashboard(userID);  // Pass userID to HomeDashboard
                        dashboard.setVisible(true);
                    }
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "User ID and password do not match");
                }
            } else {
                JOptionPane.showMessageDialog(this, "You entered an invalid User ID");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_loginButtonActionPerformed
            
    
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
            java.util.logging.Logger.getLogger(LogInNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogInBackground;
    private javax.swing.JLabel enterUserIDLabel;
    private javax.swing.JLabel forgotPasswordLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private Button.Button loginButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel selectUserTypeLabel;
    private javax.swing.JTextField textUser;
    private javax.swing.JLabel userLogInLabel;
    private javax.swing.JComboBox<String> userTypeComboBox;
    // End of variables declaration//GEN-END:variables
}
