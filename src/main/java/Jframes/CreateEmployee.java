/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;


import java.sql.*;
import javax.swing.JOptionPane;
import Classes.db;


public class CreateEmployee extends javax.swing.JFrame {

    /**
     * Creates new form CreateEmployee
     */
    public CreateEmployee() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jImmediateSupervisor = new javax.swing.JTextField();
        jPosition = new javax.swing.JTextField();
        jStatus = new javax.swing.JComboBox<>();
        jPagibigNumber = new javax.swing.JTextField();
        jTinNumber = new javax.swing.JTextField();
        jPhilhealthNumber = new javax.swing.JTextField();
        jSssNumber = new javax.swing.JTextField();
        jPhoneNumber = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEmployeeAddress = new javax.swing.JTextArea();
        jEmployeeBirthday = new com.toedter.calendar.JDateChooser();
        jEmployeeFirstName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        button4 = new Button.Button();
        jLabel1 = new javax.swing.JLabel();
        button7 = new Button.Button();
        darkButton2 = new Button.DarkButton();
        button1 = new Button.Button();
        jCreateEmployee = new Button.DarkButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jEmployeeLastName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        backgroundPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jImmediateSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jImmediateSupervisorActionPerformed(evt);
            }
        });
        getContentPane().add(jImmediateSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, 240, -1));

        jPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPositionActionPerformed(evt);
            }
        });
        getContentPane().add(jPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 240, -1));

        jStatus.setForeground(new java.awt.Color(153, 153, 153));
        jStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employed", "Unemployed" }));
        getContentPane().add(jStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 240, -1));

        jPagibigNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPagibigNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jPagibigNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 240, -1));

        jTinNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTinNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jTinNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 240, -1));

        jPhilhealthNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPhilhealthNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jPhilhealthNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 240, -1));

        jSssNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSssNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jSssNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 240, -1));

        jPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPhoneNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 240, -1));

        jEmployeeAddress.setColumns(20);
        jEmployeeAddress.setForeground(new java.awt.Color(153, 153, 153));
        jEmployeeAddress.setRows(5);
        jEmployeeAddress.setText("Enter address here");
        jEmployeeAddress.setToolTipText("");
        jScrollPane2.setViewportView(jEmployeeAddress);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 240, -1));

        jEmployeeBirthday.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jEmployeeBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 240, -1));

        jEmployeeFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmployeeFirstNameActionPerformed(evt);
            }
        });
        getContentPane().add(jEmployeeFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 240, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Immediate Supervisor:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Position:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Status:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("PagIbig Number: ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Tin Number:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Philhealth Number:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("SSS Number:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Phone Number");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        button4.setText("Dashboard");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        getContentPane().add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create an Employee");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 85, -1, -1));

        button7.setText("Logout");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        getContentPane().add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, 30));

        darkButton2.setText("View Employee");
        darkButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(darkButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, -1, -1));

        button1.setText("Clear");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 160, -1));

        jCreateEmployee.setText("Create Employee");
        jCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(jCreateEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Address");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Birthday");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Last Name:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jEmployeeLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmployeeLastNameActionPerformed(evt);
            }
        });
        getContentPane().add(jEmployeeLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 240, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("First Name:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

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

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void jCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateEmployeeActionPerformed
        
        // Getting the data from the form fields
        String lastName = jEmployeeLastName.getText();
        String firstName = jEmployeeFirstName.getText();
        java.util.Date utilDate = jEmployeeBirthday.getDate(); // Get date from jdatepicker
        Date birthday = new Date(utilDate.getTime()); // Only using date, not exact time in seconds, to insert to SQL DB
        String address = jEmployeeAddress.getText();
        String phoneNumber = jPhoneNumber.getText();
        String sssNumber = jSssNumber.getText();
        String philhealthNumber = jPhilhealthNumber.getText();
        String tinNumber = jTinNumber.getText();
        String pagibigNumber = jPagibigNumber.getText();
        String status = (String) jStatus.getSelectedItem();
        String position = jPosition.getText();
        String immediateSupervisor = jImmediateSupervisor.getText();
        
        // SQL Query to insert data into MYSQL Database
        try{
            
            Statement s = db.mycon().createStatement();
            s.executeUpdate("INSERT INTO employees (lastName,firstName,birthday,address,phoneNumber,sssNumber,philhealthNumber,tinNumber,pagibigNumber,status,position,immediateSupervisor) "
            + "VALUES('"+lastName+"','"+firstName+"','"+birthday+"','"+address+"', '"+phoneNumber+"','"+sssNumber+"',"
                    + "'"+philhealthNumber+"','"+tinNumber+"','"+pagibigNumber+"','"+status+"','"+position+"' ,'"+immediateSupervisor+"')");
            
            // Dialogue Box to inform user that the employee has been created, this can be changed to something better (Please suggest - Roshmel)
            JOptionPane.showMessageDialog(rootPane, "You have succesfully created an employee");
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        // Clear input fields so user wont need to manually remove each one after inserting data into Database
        jEmployeeLastName.setText("");
        jEmployeeFirstName.setText("");
        jEmployeeBirthday.setDate(null); // Clear the date
        jEmployeeAddress.setText("");
        jPhoneNumber.setText("");
        jSssNumber.setText("");
        jPhilhealthNumber.setText("");
        jTinNumber.setText("");
        jPagibigNumber.setText("");
        jPosition.setText("");
        jImmediateSupervisor.setText("");
        jStatus.setSelectedIndex(-1);
    }//GEN-LAST:event_jCreateEmployeeActionPerformed

    private void jEmployeeLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmployeeLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmployeeLastNameActionPerformed

    private void jEmployeeFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmployeeFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmployeeFirstNameActionPerformed

    private void jSssNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSssNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSssNumberActionPerformed

    private void jPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPhoneNumberActionPerformed

    private void jPhilhealthNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPhilhealthNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPhilhealthNumberActionPerformed

    private void jTinNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTinNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTinNumberActionPerformed

    private void jPagibigNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPagibigNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPagibigNumberActionPerformed

    private void jPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPositionActionPerformed

    private void jImmediateSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jImmediateSupervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jImmediateSupervisorActionPerformed

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
            java.util.logging.Logger.getLogger(CreateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundPicture;
    private Button.Button button1;
    private Button.Button button4;
    private Button.Button button7;
    private Button.DarkButton darkButton2;
    private Button.DarkButton jCreateEmployee;
    private javax.swing.JTextArea jEmployeeAddress;
    private com.toedter.calendar.JDateChooser jEmployeeBirthday;
    private javax.swing.JTextField jEmployeeFirstName;
    private javax.swing.JTextField jEmployeeLastName;
    private javax.swing.JTextField jImmediateSupervisor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jPagibigNumber;
    private javax.swing.JTextField jPhilhealthNumber;
    private javax.swing.JTextField jPhoneNumber;
    private javax.swing.JTextField jPosition;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jSssNumber;
    private javax.swing.JComboBox<String> jStatus;
    private javax.swing.JTextField jTinNumber;
    // End of variables declaration//GEN-END:variables
}
