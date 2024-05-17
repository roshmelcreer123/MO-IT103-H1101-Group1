/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

/**
 *
 * @author User
 */
public class ProfilePage extends javax.swing.JFrame {

    /**
     * Creates new form leaveRequestHistory
     */
    public ProfilePage() {
        initComponents();
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
        logoutButton = new javax.swing.JButton();
        dashboardButton = new javax.swing.JButton();
        employeeProfilePicture = new javax.swing.JLabel();
        employeeDetailsPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editButton = new Button.Button();
        govtBenefitsPanel = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        regularLabel = new javax.swing.JLabel();
        tenureLabel = new javax.swing.JLabel();
        employeeIDLabel = new javax.swing.JLabel();
        employeeIDLabel1 = new javax.swing.JLabel();
        employeeIDLabel2 = new javax.swing.JLabel();
        regularLabel1 = new javax.swing.JLabel();
        regularLabel2 = new javax.swing.JLabel();
        regularLabel3 = new javax.swing.JLabel();
        employeeProfileBackground = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutButton.setBackground(new java.awt.Color(204, 204, 204));
        logoutButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtondashboardButton(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 100, -1));

        dashboardButton.setBackground(new java.awt.Color(204, 204, 204));
        dashboardButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dashboardButton.setText("Dashboard");
        dashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardButton(evt);
            }
        });
        getContentPane().add(dashboardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        employeeProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Persona210x210.png"))); // NOI18N
        getContentPane().add(employeeProfilePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 210, 210));

        employeeDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("First Name:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Birthdate:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Phone Number:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Address:");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(54, 117, 136));
        jLabel19.setText("Lee");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(54, 117, 136));
        jLabel20.setText("Ging");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(54, 117, 136));
        jLabel21.setText("Jan-01-1990");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(54, 117, 136));
        jLabel22.setText("09123456789");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(54, 117, 136));
        jLabel23.setText("123 Luzon, Philippines");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Last Name:");

        javax.swing.GroupLayout employeeDetailsPanelLayout = new javax.swing.GroupLayout(employeeDetailsPanel);
        employeeDetailsPanel.setLayout(employeeDetailsPanelLayout);
        employeeDetailsPanelLayout.setHorizontalGroup(
            employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(33, 33, 33)
                .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                        .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel21))
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                        .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        employeeDetailsPanelLayout.setVerticalGroup(
            employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel23))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(employeeDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));

        editButton.setText("Edit");
        editButton.setToolTipText("");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 190, 70, 30));

        govtBenefitsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(54, 117, 136));
        jLabel27.setText("123-456-789-000");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("SSS Number:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Pagibig Number:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Philhealth Number:");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("TIN Number:");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(54, 117, 136));
        jLabel24.setText("00-1234567-8");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(54, 117, 136));
        jLabel25.setText("987654321000");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(54, 117, 136));
        jLabel26.setText("000123456789");

        javax.swing.GroupLayout govtBenefitsPanelLayout = new javax.swing.GroupLayout(govtBenefitsPanel);
        govtBenefitsPanel.setLayout(govtBenefitsPanelLayout);
        govtBenefitsPanelLayout.setHorizontalGroup(
            govtBenefitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(govtBenefitsPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(govtBenefitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(govtBenefitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        govtBenefitsPanelLayout.setVerticalGroup(
            govtBenefitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(govtBenefitsPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(govtBenefitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel24))
                .addGap(4, 4, 4)
                .addGroup(govtBenefitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(govtBenefitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(govtBenefitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel27))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(govtBenefitsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, -1, 130));

        regularLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        regularLabel.setForeground(new java.awt.Color(54, 117, 136));
        regularLabel.setText("Supervisor");
        getContentPane().add(regularLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, -1, 20));

        tenureLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tenureLabel.setText("Tenure:");
        getContentPane().add(tenureLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 60, 20));

        employeeIDLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        employeeIDLabel.setText("Allan Smith");
        getContentPane().add(employeeIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 130, 20));

        employeeIDLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        employeeIDLabel1.setText("10001");
        getContentPane().add(employeeIDLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 60, 20));

        employeeIDLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        employeeIDLabel2.setText("Sales Associate");
        getContentPane().add(employeeIDLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 130, 20));

        regularLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        regularLabel1.setForeground(new java.awt.Color(54, 117, 136));
        regularLabel1.setText("Regular");
        getContentPane().add(regularLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, -1, 20));

        regularLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        regularLabel2.setForeground(new java.awt.Color(54, 117, 136));
        regularLabel2.setText("Employee ID");
        getContentPane().add(regularLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, 20));

        regularLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        regularLabel3.setForeground(new java.awt.Color(54, 117, 136));
        regularLabel3.setText("Position/Role");
        getContentPane().add(regularLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, 20));

        employeeProfileBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EmployeeProfileBackground.png"))); // NOI18N
        employeeProfileBackground.setText("jLabel3");
        getContentPane().add(employeeProfileBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButton
        
        // Create an instance of the Dashboard frame
        HomeDashboard dashboard = new HomeDashboard();
        // Set the visibility of the Dashboard frame to true
        dashboard.setVisible(true);
        // Close the leaveRequest Dashboard frame
        this.dispose(); // Assuming this is the Login frame
        
    }//GEN-LAST:event_dashboardButton

    private void logoutButtondashboardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtondashboardButton
        // Create an instance of LoginNew and display it
    LogInNew loginNew = new LogInNew();
    loginNew.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_logoutButtondashboardButton

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfilePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dashboardButton;
    private Button.Button editButton;
    private javax.swing.JPanel employeeDetailsPanel;
    private javax.swing.JLabel employeeIDLabel;
    private javax.swing.JLabel employeeIDLabel1;
    private javax.swing.JLabel employeeIDLabel2;
    private javax.swing.JLabel employeeProfileBackground;
    private javax.swing.JLabel employeeProfilePicture;
    private javax.swing.JPanel govtBenefitsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel regularLabel;
    private javax.swing.JLabel regularLabel1;
    private javax.swing.JLabel regularLabel2;
    private javax.swing.JLabel regularLabel3;
    private javax.swing.JLabel tenureLabel;
    // End of variables declaration//GEN-END:variables
}