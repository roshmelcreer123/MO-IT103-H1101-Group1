
package Jframes;


import java.sql.*;
import javax.swing.JOptionPane;
import Classes.db;


public class CreateUserAccount extends javax.swing.JFrame {

    /**
     * Creates new form CreateUserAccount
     */
    public CreateUserAccount() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPosition = new javax.swing.JTextField();
        jEmployeeFirstName = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jUserID = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jEmployeeID = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPassword = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        button4 = new Button.Button();
        jEnterDetailsLabel = new javax.swing.JLabel();
        button7 = new Button.Button();
        darkButton2 = new Button.DarkButton();
        clearButton = new Button.Button();
        jLabel16 = new javax.swing.JLabel();
        jUserType = new javax.swing.JTextField();
        jCreateUserAccount = new Button.DarkButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jEmployeeLastName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        backgroundPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPositionActionPerformed(evt);
            }
        });
        getContentPane().add(jPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 150, -1));

        jEmployeeFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmployeeFirstNameActionPerformed(evt);
            }
        });
        getContentPane().add(jEmployeeFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 150, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("User ID:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

        jUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserIDActionPerformed(evt);
            }
        });
        getContentPane().add(jUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 150, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Employee ID:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        jEmployeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmployeeIDActionPerformed(evt);
            }
        });
        getContentPane().add(jEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 150, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Password:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));

        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 150, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Position:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, -1, -1));

        button4.setText("Dashboard");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        getContentPane().add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        jEnterDetailsLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jEnterDetailsLabel.setText("Input User Account Details");
        getContentPane().add(jEnterDetailsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        button7.setText("Logout");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        getContentPane().add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, 30));

        darkButton2.setText("View User Accounts");
        darkButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(darkButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, -1, -1));

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 160, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("User Type:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, -1, -1));

        jUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserTypeActionPerformed(evt);
            }
        });
        getContentPane().add(jUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 150, -1));

        jCreateUserAccount.setText("Create User Account");
        jCreateUserAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateUserAccountActionPerformed(evt);
            }
        });
        getContentPane().add(jCreateUserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Create a User Account");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Last Name:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));

        jEmployeeLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmployeeLastNameActionPerformed(evt);
            }
        });
        getContentPane().add(jEmployeeLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 150, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("First Name:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, -1));

        backgroundPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/For Other Pages.png"))); // NOI18N
        getContentPane().add(backgroundPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        
        AdminHomeDashboard adminDashboard = new AdminHomeDashboard();
        adminDashboard.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_button4ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed

        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button7ActionPerformed

    private void darkButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkButton2ActionPerformed

         // Redirects to View All Employees Admin Page
        ViewAllEmployee viewAllEmployee = new ViewAllEmployee();
        viewAllEmployee.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_darkButton2ActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        jUserID.setText("");
        jEmployeeID.setText("");
        jPassword.setText("");
        jEmployeeLastName.setText("");
        jEmployeeFirstName.setText("");
        jPosition.setText("");
        jUserType.setText("");

    }//GEN-LAST:event_clearButtonActionPerformed

    private void jCreateUserAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateUserAccountActionPerformed
        
        // Getting the data from the form fields
        String userID = jUserID.getText();
        int employeeID = Integer.parseInt(jEmployeeID.getText()); // Convert the text to an int
        String password = jPassword.getText();
        String lastName = jEmployeeLastName.getText();
        String firstName = jEmployeeFirstName.getText();
        String position = jPosition.getText();
        String userType = jUserType.getText();
        
        // SQL Query to insert data into MYSQL Database
        String sql = "INSERT INTO user_accounts (userID, employeeID, password, lastName, firstName, position, userType) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        // Using prepared statements to prevent SQL injections.
        try (Connection con = db.mycon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, userID);
            ps.setInt(2, employeeID);
            ps.setString(3, password);
            ps.setString(4, lastName);
            ps.setString(5, firstName);
            ps.setString(6, position);
            ps.setString(7, userType);

            ps.executeUpdate();

            // Dialogue Box to inform user that the user account has been created
            JOptionPane.showMessageDialog(rootPane, "You have successfully created a user account");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Clear input fields so user won't need to manually remove each one after inserting data into Database
        jUserID.setText("");
        jEmployeeID.setText("");
        jPassword.setText("");
        jEmployeeLastName.setText("");
        jEmployeeFirstName.setText("");
        jPosition.setText("");
        jUserType.setText("");
    }//GEN-LAST:event_jCreateUserAccountActionPerformed

    private void jEmployeeLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmployeeLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmployeeLastNameActionPerformed

    private void jEmployeeFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmployeeFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmployeeFirstNameActionPerformed

    private void jPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPositionActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserIDActionPerformed

    private void jUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserTypeActionPerformed

    private void jEmployeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmployeeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmployeeIDActionPerformed

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
            java.util.logging.Logger.getLogger(CreateUserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUserAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundPicture;
    private Button.Button button4;
    private Button.Button button7;
    private Button.Button clearButton;
    private Button.DarkButton darkButton2;
    private Button.DarkButton jCreateUserAccount;
    private javax.swing.JTextField jEmployeeFirstName;
    private javax.swing.JTextField jEmployeeID;
    private javax.swing.JTextField jEmployeeLastName;
    private javax.swing.JLabel jEnterDetailsLabel;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jPassword;
    private javax.swing.JTextField jPosition;
    private javax.swing.JTextField jUserID;
    private javax.swing.JTextField jUserType;
    // End of variables declaration//GEN-END:variables
}
