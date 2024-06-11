/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import Classes.db;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AttendanceDashboardAdmin extends javax.swing.JFrame {
    
    /**
     * Creates new form AttendanceDashboard
     */
    public AttendanceDashboardAdmin() {
        initComponents();
    }

    private void fetchDataAttendance(int year, int month) {
        try {
            // Get the connection from db class
            Connection conn = db.mycon();

            // Check if the connection is successful
            if (conn != null) {
                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query to retrieve data from the employees table
                String query = "SELECT * FROM attendance_records WHERE YEAR(date) = " + year + " AND MONTH(date) = " + month + " LIMIT 30";
                ResultSet rs = stmt.executeQuery(query);

                // Get the table model from jTable2
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.setRowCount(0); // Clear existing data

                // Add rows to the table model
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("attendanceID"),
                        rs.getInt("employeeID"),
                        rs.getDate("date"),
                        rs.getTime("timeIn"),
                        rs.getTime("timeOut")
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
    
    private void fetchDataAttendanceHoursWorked(int year, int month) {
       
        try {
            // Get the connection from db class
            Connection conn = db.mycon();

            // Check if the connection is successful
            if (conn != null) {
                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query to retrieve data from the employees table
                String query = "SELECT * FROM attendance_records WHERE YEAR(date) = " + year + " AND MONTH(date) = " + month + " LIMIT 30";
                ResultSet rs = stmt.executeQuery(query);

                // Get the table model from jTable2
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0); // Clear existing data

                // Add rows to the table model
                while (rs.next()) {
                    int attendanceID = rs.getInt("attendanceID");
                    int employeeID = rs.getInt("employeeID");
                    Date date = rs.getDate("date");
                    Time timeIn = rs.getTime("timeIn");
                    Time timeOut = rs.getTime("timeOut");
                    
                    
                    // Calculate the total hours worked
                    long totalHoursWorked = 0;
                    long totalMinutesWorked = 0;
        

                    if (timeIn != null && timeOut != null) {
                        Duration duration = Duration.between(timeIn.toLocalTime(), timeOut.toLocalTime());
                        totalHoursWorked = duration.toHours();
                        totalMinutesWorked = duration.minusHours(totalHoursWorked).toMinutes();
                        
                        // Subtract 1 hour for lunch break if total working hours are more than 4 hours
                        if (totalHoursWorked > 4) {
                            duration = duration.minusHours(1);
                            totalHoursWorked = duration.toHours();
                            totalMinutesWorked = duration.minusHours(totalHoursWorked).toMinutes();
                        }
                        
                        // Check if the hours worked fall within the range of 7 hours and 45 minutes to 8 hours
                        long totalMinutesWorkedForRounding = totalHoursWorked * 60 + totalMinutesWorked;
                        if (totalMinutesWorkedForRounding >= 465 && totalMinutesWorkedForRounding <= 480) { // 465 minutes is 7 hours and 45 minutes
                            totalHoursWorked = 8;
                            totalMinutesWorked = 0;
                        }
                    }

                    String formattedTotalWorkedTime = totalHoursWorked + "h " + totalMinutesWorked + "m";

                    // Add the row to the table model
                    model.addRow(new Object[]{
                        attendanceID,
                        employeeID,
                        date,
                        timeIn,
                        timeOut,
                        formattedTotalWorkedTime
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
    
    
    private long calculateTotalHoursWorkedForMonth(int year, int month) {
        long totalHoursWorkedForMonth = 0;

        try {
            // Get the connection from db class
            Connection conn = db.mycon();

            // Check if the connection is successful
            if (conn != null) {
                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query to retrieve data from the attendance_records table
                String query = "SELECT * FROM attendance_records WHERE YEAR(date) = " + year + " AND MONTH(date) = " + month;
                ResultSet rs = stmt.executeQuery(query);

                // Iterate through the result set and calculate the total hours worked
                while (rs.next()) {
                    Time timeIn = rs.getTime("timeIn");
                    Time timeOut = rs.getTime("timeOut");

                    if (timeIn != null && timeOut != null) {
                        Duration duration = Duration.between(timeIn.toLocalTime(), timeOut.toLocalTime());
                        long hours = duration.toHours();

                        // Subtract 1 hour for lunch break if total working hours are more than 4 hours
                        if (hours > 4) {
                            duration = duration.minusHours(1);
                            hours = duration.toHours();
                        }

                        totalHoursWorkedForMonth += hours;
                    }
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

        return totalHoursWorkedForMonth;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jHoursWorked = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jChooseYear = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jChooseMonth = new javax.swing.JComboBox<>();
        viewHoursWorked = new Button.Button();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        button2 = new Button.Button();
        button3 = new Button.Button();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        button4 = new Button.Button();
        button5 = new Button.Button();
        button6 = new Button.Button();
        button7 = new Button.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Attendance Dashboard");
        setBackground(new java.awt.Color(245, 245, 245));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jHoursWorked.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jHoursWorked.setForeground(new java.awt.Color(51, 51, 51));
        jHoursWorked.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jHoursWorked.setText("Hours Worked");
        getContentPane().add(jHoursWorked, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 210, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Persona150x150.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Total Hours Worked:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, 30));

        jChooseYear.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jChooseYear.setForeground(new java.awt.Color(51, 51, 51));
        jChooseYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2016", "2015", "2014", "2013", "2012", "2011", "2010" }));
        getContentPane().add(jChooseYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 90, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Choose Month:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, 20));

        jChooseMonth.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jChooseMonth.setForeground(new java.awt.Color(51, 51, 51));
        jChooseMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        getContentPane().add(jChooseMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 90, -1));

        viewHoursWorked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/working-time.png"))); // NOI18N
        viewHoursWorked.setText("View");
        viewHoursWorked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHoursWorkedActionPerformed(evt);
            }
        });
        getContentPane().add(viewHoursWorked, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 190, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Choose Year:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, 20));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Attendance ID", "Employee ID", "Date", "Time-In", "Time-Out", "Total Worked Hours"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(54, 117, 136));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 530, 120));

        jTable2.setBackground(new java.awt.Color(204, 204, 204));
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "AttendanceID", "EmployeeID", "Date", "Time-In", "Time-Out"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(54, 117, 136));
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 340, 140));

        button2.setText("Time-Out");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, 140, -1));

        button3.setText("Time-In");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        getContentPane().add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, 140, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("08:30:01");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(54, 117, 136));
        jLabel7.setText("(GMT +8)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(54, 117, 136));
        jLabel8.setText("12/12/2022");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, -1, -1));

        button4.setText("View Overtime Request History");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        getContentPane().add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, -1, -1));

        button5.setText("Request Overtime");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        getContentPane().add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, -1, -1));

        button6.setText("Dashboard");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        getContentPane().add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 30));

        button7.setText("Logout");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        getContentPane().add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AttendanceBackground.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewHoursWorkedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewHoursWorkedActionPerformed
        // Get selected year and month from the combo boxes
        String yearStr = (String) jChooseYear.getSelectedItem();
        String monthStr = (String) jChooseMonth.getSelectedItem();

        if (!yearStr.equals("----") && !monthStr.equals("----")) {
            int year = Integer.parseInt(yearStr);
            int month = jChooseMonth.getSelectedIndex(); // 1-based index

            // Fetch data with the selected year and month
            fetchDataAttendance(year, month);
            fetchDataAttendanceHoursWorked(year, month);
            
            // Calculate total hours worked for the month
            long totalHoursWorked = calculateTotalHoursWorkedForMonth(year, month);
            
            // Display the total hours worked in the jHoursWorked JLabel
            jHoursWorked.setText(" " + totalHoursWorked );
            
        } else {
            JOptionPane.showMessageDialog(this, "Please select both year and month.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_viewHoursWorkedActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        
        
    }//GEN-LAST:event_button5ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed

    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        
        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button7ActionPerformed

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
            java.util.logging.Logger.getLogger(AttendanceDashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceDashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceDashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceDashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button.Button button2;
    private Button.Button button3;
    private Button.Button button4;
    private Button.Button button5;
    private Button.Button button6;
    private Button.Button button7;
    private javax.swing.JComboBox<String> jChooseMonth;
    private javax.swing.JComboBox<String> jChooseYear;
    private javax.swing.JLabel jHoursWorked;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private Button.Button viewHoursWorked;
    // End of variables declaration//GEN-END:variables
}
