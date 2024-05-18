
package Jframes;

import Archived.SalaryDashboard;


public class HomeDashboard extends javax.swing.JFrame {

   
    public HomeDashboard() {
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
        employeeProfilePicture = new javax.swing.JLabel();
        employeeNameLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        leaveCreditsLabel = new javax.swing.JLabel();
        leaveCreditsLabel1 = new javax.swing.JLabel();
        leaveCreditsLabel2 = new javax.swing.JLabel();
        leavesAvailableTxtField = new javax.swing.JTextField();
        taskCompletedTxtField = new javax.swing.JTextField();
        totalWorkedHoursTxtField = new javax.swing.JTextField();
        clockLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        timeInLabel = new javax.swing.JLabel();
        timeOutLabel = new javax.swing.JLabel();
        clockInStatusLabel = new javax.swing.JLabel();
        timeInDataTextField = new javax.swing.JTextField();
        dateInDataTextField = new javax.swing.JTextField();
        timeInDataTextField1 = new javax.swing.JTextField();
        dateInDataTextField1 = new javax.swing.JTextField();
        pendingTasksLabel = new javax.swing.JLabel();
        task1CheckBox = new javax.swing.JCheckBox();
        task2CheckBox = new javax.swing.JCheckBox();
        task3CheckBox = new javax.swing.JCheckBox();
        profileButton = new Button.Button();
        salaryButton = new Button.Button();
        attendanceButton1 = new Button.Button();
        leaveButton = new Button.Button();
        overtimeButton = new Button.Button();
        inButton = new Button.Button();
        outButton = new Button.Button();
        button1 = new Button.Button();
        button2 = new Button.Button();
        backgroundPicture = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Persona150x150.png"))); // NOI18N
        getContentPane().add(employeeProfilePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        employeeNameLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        employeeNameLabel.setForeground(new java.awt.Color(54, 117, 136));
        employeeNameLabel.setText("Ging Lee");
        employeeNameLabel.setToolTipText("");
        getContentPane().add(employeeNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        positionLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        positionLabel.setForeground(new java.awt.Color(54, 117, 136));
        positionLabel.setText(" Sales Associate");
        positionLabel.setToolTipText("");
        getContentPane().add(positionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 100, 20));

        leaveCreditsLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        leaveCreditsLabel.setForeground(new java.awt.Color(54, 117, 136));
        leaveCreditsLabel.setText("Total Worked Hours");
        getContentPane().add(leaveCreditsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        leaveCreditsLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        leaveCreditsLabel1.setForeground(new java.awt.Color(54, 117, 136));
        leaveCreditsLabel1.setText("Leaves Available");
        leaveCreditsLabel1.setToolTipText("");
        getContentPane().add(leaveCreditsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        leaveCreditsLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        leaveCreditsLabel2.setForeground(new java.awt.Color(54, 117, 136));
        leaveCreditsLabel2.setText("Tasks Completed");
        getContentPane().add(leaveCreditsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, -1, -1));

        leavesAvailableTxtField.setBackground(new java.awt.Color(245, 245, 245));
        leavesAvailableTxtField.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        leavesAvailableTxtField.setForeground(new java.awt.Color(54, 117, 136));
        leavesAvailableTxtField.setText("15");
        leavesAvailableTxtField.setToolTipText("");
        leavesAvailableTxtField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        leavesAvailableTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leavesAvailableTxtFieldActionPerformed(evt);
            }
        });
        getContentPane().add(leavesAvailableTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 60, 80));

        taskCompletedTxtField.setBackground(new java.awt.Color(245, 245, 245));
        taskCompletedTxtField.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        taskCompletedTxtField.setForeground(new java.awt.Color(54, 117, 136));
        taskCompletedTxtField.setText("100");
        taskCompletedTxtField.setToolTipText("");
        taskCompletedTxtField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        taskCompletedTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskCompletedTxtFieldActionPerformed(evt);
            }
        });
        getContentPane().add(taskCompletedTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 70, 80));

        totalWorkedHoursTxtField.setBackground(new java.awt.Color(245, 245, 245));
        totalWorkedHoursTxtField.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        totalWorkedHoursTxtField.setForeground(new java.awt.Color(54, 117, 136));
        totalWorkedHoursTxtField.setText("40");
        totalWorkedHoursTxtField.setToolTipText("");
        totalWorkedHoursTxtField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        totalWorkedHoursTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalWorkedHoursTxtFieldActionPerformed(evt);
            }
        });
        getContentPane().add(totalWorkedHoursTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 100, 60, 80));

        clockLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        clockLabel.setForeground(new java.awt.Color(54, 117, 136));
        clockLabel.setText("08:30:01");
        clockLabel.setToolTipText("");
        getContentPane().add(clockLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 150, 70));

        dateLabel.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(54, 117, 136));
        dateLabel.setText(" 12 DEC 2022");
        dateLabel.setToolTipText("");
        getContentPane().add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 140, 40));

        timeInLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        timeInLabel.setForeground(new java.awt.Color(54, 117, 136));
        timeInLabel.setText("TIME IN:");
        getContentPane().add(timeInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 70, 20));

        timeOutLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        timeOutLabel.setForeground(new java.awt.Color(54, 117, 136));
        timeOutLabel.setText(" TIME OUT:");
        getContentPane().add(timeOutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, -1, 20));

        clockInStatusLabel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        clockInStatusLabel.setForeground(new java.awt.Color(0, 206, 209));
        clockInStatusLabel.setText("ON-TIME");
        getContentPane().add(clockInStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        timeInDataTextField.setBackground(new java.awt.Color(245, 245, 245));
        timeInDataTextField.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        timeInDataTextField.setForeground(new java.awt.Color(56, 117, 136));
        timeInDataTextField.setText("08:00:00");
        timeInDataTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        timeInDataTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeInDataTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(timeInDataTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 70, 40));

        dateInDataTextField.setBackground(new java.awt.Color(245, 245, 245));
        dateInDataTextField.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        dateInDataTextField.setForeground(new java.awt.Color(56, 117, 136));
        dateInDataTextField.setText("12 DEC 2022");
        dateInDataTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateInDataTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateInDataTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(dateInDataTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 100, 40));

        timeInDataTextField1.setBackground(new java.awt.Color(245, 245, 245));
        timeInDataTextField1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        timeInDataTextField1.setForeground(new java.awt.Color(56, 117, 136));
        timeInDataTextField1.setText("--:--:--");
        timeInDataTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        timeInDataTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeInDataTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(timeInDataTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 70, 40));

        dateInDataTextField1.setBackground(new java.awt.Color(245, 245, 245));
        dateInDataTextField1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        dateInDataTextField1.setForeground(new java.awt.Color(56, 117, 136));
        dateInDataTextField1.setText("-- --- ----");
        dateInDataTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateInDataTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateInDataTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(dateInDataTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 100, 40));

        pendingTasksLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        pendingTasksLabel.setForeground(new java.awt.Color(245, 245, 245));
        pendingTasksLabel.setText("Pending Tasks");
        pendingTasksLabel.setToolTipText("");
        getContentPane().add(pendingTasksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 180, 40));

        task1CheckBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        task1CheckBox.setForeground(new java.awt.Color(54, 117, 136));
        task1CheckBox.setSelected(true);
        task1CheckBox.setText("Follow up Sales Invoice | 12 DEC 2022");
        task1CheckBox.setToolTipText("");
        task1CheckBox.setIconTextGap(10);
        task1CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task1CheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(task1CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 320, -1));

        task2CheckBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        task2CheckBox.setForeground(new java.awt.Color(54, 117, 136));
        task2CheckBox.setText("Email Head of Marketing | 12 DEC 2022");
        task2CheckBox.setToolTipText("");
        task2CheckBox.setIconTextGap(10);
        task2CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task2CheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(task2CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, 320, -1));

        task3CheckBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        task3CheckBox.setForeground(new java.awt.Color(54, 117, 136));
        task3CheckBox.setText("Revise New Sales Pitch | 12 DEC 2022");
        task3CheckBox.setToolTipText("");
        task3CheckBox.setIconTextGap(10);
        task3CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task3CheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(task3CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 320, -1));

        profileButton.setText("Profile");
        profileButton.setToolTipText("");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });
        getContentPane().add(profileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 180, 40));

        salaryButton.setText("Salary");
        salaryButton.setToolTipText("");
        salaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(salaryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 180, 40));

        attendanceButton1.setText("Attendance");
        attendanceButton1.setToolTipText("");
        attendanceButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(attendanceButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 180, 40));

        leaveButton.setText("Leave");
        leaveButton.setToolTipText("");
        leaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(leaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 180, 40));

        overtimeButton.setText("Overtime");
        overtimeButton.setToolTipText("");
        overtimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overtimeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(overtimeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 180, 40));

        inButton.setText("IN");
        inButton.setToolTipText("");
        inButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inButtonActionPerformed(evt);
            }
        });
        getContentPane().add(inButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 120, 30));

        outButton.setText("OUT");
        outButton.setToolTipText("");
        outButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outButtonActionPerformed(evt);
            }
        });
        getContentPane().add(outButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 120, 30));

        button1.setText("Logout");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, 30));

        button2.setText("Dashboard");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        backgroundPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DashboardNoButtons.png"))); // NOI18N
        backgroundPicture.setText("jLabel3");
        getContentPane().add(backgroundPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        // Create an instance of ProfilePage and display it
    ProfilePage profilePage = new ProfilePage();
    profilePage.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_profileButtonActionPerformed

    private void outButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outButtonActionPerformed

    private void salaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryButtonActionPerformed
        // Create an instance of SalaryPage and display it
    SalaryPage salaryPage = new SalaryPage();
    salaryPage.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_salaryButtonActionPerformed

    private void attendanceButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceButton1ActionPerformed
        // Create an instance of AttendanceDashboard and display it
    AttendanceDashboard attendanceDashboard = new AttendanceDashboard();
    attendanceDashboard.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_attendanceButton1ActionPerformed

    private void leaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveButtonActionPerformed
        // Create an instance of leaveRequestDashboard and display it
    leaveRequestDashboard leaveRequestDashboard = new leaveRequestDashboard();
    leaveRequestDashboard.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_leaveButtonActionPerformed

    private void overtimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overtimeButtonActionPerformed
        // Create an instance of overtimeRequestHistoryDashboard and display it
    OvertimeRequestHistory overtimeRequestHistory = new OvertimeRequestHistory();
    overtimeRequestHistory.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_overtimeButtonActionPerformed

    private void inButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inButtonActionPerformed

    private void taskCompletedTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskCompletedTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskCompletedTxtFieldActionPerformed

    private void leavesAvailableTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leavesAvailableTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leavesAvailableTxtFieldActionPerformed

    private void totalWorkedHoursTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalWorkedHoursTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalWorkedHoursTxtFieldActionPerformed

    private void task1CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task1CheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_task1CheckBoxActionPerformed

    private void task3CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task3CheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_task3CheckBoxActionPerformed

    private void task2CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task2CheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_task2CheckBoxActionPerformed

    private void dateInDataTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateInDataTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateInDataTextFieldActionPerformed

    private void timeInDataTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeInDataTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeInDataTextFieldActionPerformed

    private void timeInDataTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeInDataTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeInDataTextField1ActionPerformed

    private void dateInDataTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateInDataTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateInDataTextField1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

    }//GEN-LAST:event_button2ActionPerformed

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
            java.util.logging.Logger.getLogger(HomeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button.Button attendanceButton1;
    private javax.swing.JLabel backgroundPicture;
    private Button.Button button1;
    private Button.Button button2;
    private javax.swing.JLabel clockInStatusLabel;
    private javax.swing.JLabel clockLabel;
    private javax.swing.JTextField dateInDataTextField;
    private javax.swing.JTextField dateInDataTextField1;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel employeeNameLabel;
    private javax.swing.JLabel employeeProfilePicture;
    private Button.Button inButton;
    private javax.swing.JLabel jLabel1;
    private Button.Button leaveButton;
    private javax.swing.JLabel leaveCreditsLabel;
    private javax.swing.JLabel leaveCreditsLabel1;
    private javax.swing.JLabel leaveCreditsLabel2;
    private javax.swing.JTextField leavesAvailableTxtField;
    private Button.Button outButton;
    private Button.Button overtimeButton;
    private javax.swing.JLabel pendingTasksLabel;
    private javax.swing.JLabel positionLabel;
    private Button.Button profileButton;
    private Button.Button salaryButton;
    private javax.swing.JCheckBox task1CheckBox;
    private javax.swing.JCheckBox task2CheckBox;
    private javax.swing.JCheckBox task3CheckBox;
    private javax.swing.JTextField taskCompletedTxtField;
    private javax.swing.JTextField timeInDataTextField;
    private javax.swing.JTextField timeInDataTextField1;
    private javax.swing.JLabel timeInLabel;
    private javax.swing.JLabel timeOutLabel;
    private javax.swing.JTextField totalWorkedHoursTxtField;
    // End of variables declaration//GEN-END:variables
}
