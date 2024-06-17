/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import java.sql.*;
import javax.swing.JOptionPane;
import Classes.db;
import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalDateTime;


public class RequestLeave extends javax.swing.JFrame {
    private String userID;

    /**
     * Creates new form requestLeave
     */
    public RequestLeave(String userID) {
        this.userID = userID;
        initComponents();
        fetchEmployeeDetails(); // Fetch and set employee details based on userID
    }
    
    private void fetchEmployeeDetails() {
        try {
            // Get the connection from db class
            Connection conn = db.mycon();

            // Check if the connection is successful
            if (conn != null) {
                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query to retrieve employee details based on userID
                String query = "SELECT employeeID, CONCAT(firstName, ' ', lastName) as employeeName FROM user_accounts WHERE userID = '" + userID + "'";
                ResultSet rs = stmt.executeQuery(query);

                // Set the employee ID and name in the text fields
                if (rs.next()) {
                    jEmployeeID.setText(rs.getString("employeeID"));
                    jEmployeeName.setText(rs.getString("employeeName"));
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


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jEmployeeID = new javax.swing.JLabel();
        jEmployeeName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLeaveType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jManager = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jReason = new javax.swing.JTextArea();
        jRequestDate = new com.toedter.calendar.JCalendar();
        jLabel3 = new javax.swing.JLabel();
        jStartDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jEndDate = new com.toedter.calendar.JDateChooser();
        saveRequestButton = new Button.DarkButton();
        clearFieldButton = new Button.Button();
        jLabel1 = new javax.swing.JLabel();
        darkButton2 = new Button.DarkButton();
        button4 = new Button.Button();
        button7 = new Button.Button();
        jLabel2 = new javax.swing.JLabel();
        backgroundPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jEmployeeID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jEmployeeID.setText("Employee Number:");
        getContentPane().add(jEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, -1));

        jEmployeeName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jEmployeeName.setText("Employee Name:");
        getContentPane().add(jEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Employee Name:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Leave Type:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        jLeaveType.setForeground(new java.awt.Color(153, 153, 153));
        jLeaveType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sick", "Vacation", "Personal", "Maternity/Paternity", "Bereavement" }));
        getContentPane().add(jLeaveType, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 240, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Manager:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        jManager.setForeground(new java.awt.Color(153, 153, 153));
        jManager.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sarah Johnson", "David Rodriguez", "Emily Chen", "Michael Patel", "Jennifer Smith" }));
        getContentPane().add(jManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 240, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Reason for Leave:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        jReason.setColumns(20);
        jReason.setForeground(new java.awt.Color(153, 153, 153));
        jReason.setRows(5);
        jReason.setText("Enter reason for leave here");
        jScrollPane1.setViewportView(jReason);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 240, -1));

        jRequestDate.setBackground(new java.awt.Color(255, 255, 255));
        jRequestDate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jRequestDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 410, 220));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Start Date of Leave:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, -1, -1));

        jStartDate.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 70, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("End Date of Leave:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, -1, -1));

        jEndDate.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 70, -1));

        saveRequestButton.setText("Save Request");
        saveRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRequestButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, -1, -1));

        clearFieldButton.setText("Clear Field");
        clearFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFieldButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearFieldButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Request a Leave");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 85, -1, -1));

        darkButton2.setText("Go Back");
        darkButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(darkButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, -1, -1));

        button4.setText("Dashboard");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        getContentPane().add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        button7.setText("Logout");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        getContentPane().add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Employee Number:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        backgroundPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/For Other Pages.png"))); // NOI18N
        getContentPane().add(backgroundPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void darkButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkButton2ActionPerformed
        
        // Create an instance of the Dashboard frame
        leaveRequestDashboard leaveDashboard = new leaveRequestDashboard(userID);
        // Set the visibility of the Dashboard frame to true
        leaveDashboard.setVisible(true);
        // Close the leaveRequest Dashboard frame
        this.dispose(); 

    }//GEN-LAST:event_darkButton2ActionPerformed

    private void clearFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldButtonActionPerformed
        // Clear input fields so user wont need to manually remove each one after inserting data into Database
        jLeaveType.setSelectedIndex(-1);
        jManager.setSelectedIndex(-1);
        jReason.setText("");
        jStartDate.setDate(null); // Clear the date
        jEndDate.setDate(null); // Clear the date
    }//GEN-LAST:event_clearFieldButtonActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // Create an instance of the Dashboard frame
        HomeDashboard dashboard = new HomeDashboard(userID);
        // Set the visibility of the Dashboard frame to true
        dashboard.setVisible(true);
        // Close the Request Leave frame
        this.dispose(); // Assuming this is the Login frame
    }//GEN-LAST:event_button4ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed

        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button7ActionPerformed

    private void saveRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRequestButtonActionPerformed
        // Getting the data from the form fields
        String employeeID = jEmployeeID.getText();
        String employeeName = jEmployeeName.getText();
        String leaveType = (String) jLeaveType.getSelectedItem();
        String manager = (String) jManager.getSelectedItem();
        String reason = jReason.getText();
        java.util.Date utilStartDate = jStartDate.getDate(); // Get date from jdatepicker
        Date startDate = new Date(utilStartDate.getTime()); // Only using date, not exact time in seconds, to insert to SQL DB
        java.util.Date utilEndDate = jEndDate.getDate(); // Get date from jdatepicker
        Date endDate = new Date(utilEndDate.getTime()); // Only using date, not exact time in seconds, to insert to SQL DB
        LocalDate currentDate = LocalDate.now(); // Get current date
        Timestamp sqlCurrentTimestamp = Timestamp.valueOf(LocalDateTime.now()); // Get current timestamp
        
        // SQL Query to insert data into MYSQL Database
        try{
            
            Statement s = db.mycon().createStatement();
            s.executeUpdate("INSERT INTO leave_requests (employeeID,employeeName,leaveType,manager,reason,startDate,endDate,status,dateRequested,dateApproved) "
            + "VALUES('"+employeeID+"','"+employeeName+"','"+leaveType+"','"+manager+"', '"+reason+"',"
                    + "'"+startDate+"','"+endDate+"','Pending', '" + sqlCurrentTimestamp + "', NULL)");
            
            // Dialogue Box to inform user that the employee has been created, this can be changed to something better (Please suggest - Roshmel)
            JOptionPane.showMessageDialog(rootPane, "You have succesfully requested for a leave.");
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        // Clear input fields so user wont need to manually remove each one after inserting data into Database
        jLeaveType.setSelectedIndex(-1);
        jManager.setSelectedIndex(-1);
        jReason.setText("");
        jStartDate.setDate(null); // Clear the date
        jEndDate.setDate(null); // Clear the date

       
    }//GEN-LAST:event_saveRequestButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RequestLeave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestLeave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestLeave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestLeave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundPicture;
    private Button.Button button4;
    private Button.Button button7;
    private Button.Button clearFieldButton;
    private Button.DarkButton darkButton2;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jEmployeeID;
    private javax.swing.JLabel jEmployeeName;
    private com.toedter.calendar.JDateChooser jEndDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> jLeaveType;
    private javax.swing.JComboBox<String> jManager;
    private javax.swing.JTextArea jReason;
    private com.toedter.calendar.JCalendar jRequestDate;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jStartDate;
    private Button.DarkButton saveRequestButton;
    // End of variables declaration//GEN-END:variables
}
