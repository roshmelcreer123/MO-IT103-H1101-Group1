
package Jframes;

/**
 *
 * @author User
 */
public class LogInNew extends javax.swing.JFrame {

    /**
     * Creates new form leaveRequestHistory
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
        enterUsernameLabel1 = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        textUser = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        loginButton = new Button.Button();
        forgotPasswordLabel = new javax.swing.JLabel();
        LogInBackground = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userLogInLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        userLogInLabel.setForeground(new java.awt.Color(245, 245, 245));
        userLogInLabel.setText("USER LOGIN");
        getContentPane().add(userLogInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, -1, 30));

        enterUsernameLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        enterUsernameLabel1.setText("Enter Username");
        getContentPane().add(enterUsernameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 180, 130, 30));

        passwordLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        passwordLabel.setText("Password");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 110, 30));

        textUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textUser.setForeground(new java.awt.Color(0, 206, 209));
        textUser.setBorder(null);
        getContentPane().add(textUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 290, 50));

        jPasswordField1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 206, 209));
        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPasswordField1.setCaretColor(new java.awt.Color(0, 206, 209));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 290, 50));

        loginButton.setText("Login");
        loginButton.setToolTipText("");
        loginButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 120, 40));

        forgotPasswordLabel.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        forgotPasswordLabel.setText("Forgot Password?");
        getContentPane().add(forgotPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 430, 120, -1));

        LogInBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogInBackground.png"))); // NOI18N
        LogInBackground.setText("jLabel3");
        getContentPane().add(LogInBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // Create an instance of the Dashboard frame
        HomeDashboard dashboard = new HomeDashboard();
        // Set the visibility of the Dashboard frame to true
        dashboard.setVisible(true);
        // Close the Login frame
        this.dispose(); // Assuming this is the Login frame
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
    private javax.swing.JLabel enterUsernameLabel1;
    private javax.swing.JLabel forgotPasswordLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private Button.Button loginButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField textUser;
    private javax.swing.JLabel userLogInLabel;
    // End of variables declaration//GEN-END:variables
}