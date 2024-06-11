/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;


import Jframes.AttendanceDashboardAdmin;
import Classes.db;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.*;
import java.time.Duration;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CreateSalary extends javax.swing.JFrame {
    
    /**
     * Creates new form CreateSalary
     */
    public CreateSalary() {
        initComponents(); 
        fillEmployeeIDs(); // Populate employee IDs in the combo box
    }
    
    private void fillEmployeeIDs() {
        try {
            // Get the connection from db class
            Connection conn = db.mycon();

            // Check if the connection is successful
            if (conn != null) {
                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query to retrieve employee IDs from the employee table
                String query = "SELECT employeeID FROM employees";
                ResultSet rs = stmt.executeQuery(query);

                // Populate employee IDs in the combo box
                while (rs.next()) {
                    jEmployeeID.addItem(String.valueOf(rs.getInt("employeeID")));
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
    
    
    // Method to fetch and set employee details in JLabels based on selected employee ID
    private void setEmployeeDetails(String employeeID) {
        try {
            // Get the connection from db class
            Connection conn = db.mycon();

            // Check if the connection is successful
            if (conn != null) {
                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query to retrieve employee details based on employee ID
                String query = "SELECT hourlyRate, riceSubsidy, phoneAllowance, clothingAllowance FROM employees WHERE employeeID = '" + employeeID + "'";
                ResultSet rs = stmt.executeQuery(query);

                // Check if the result set has data
                if (rs.next()) {
                    // Set the values to the corresponding JLabels
                    jHourlyRate.setText(rs.getString("hourlyRate"));
                    jRiceSubsidy.setText(rs.getString("riceSubsidy"));
                    jPhoneAllowance.setText(rs.getString("phoneAllowance"));
                    jClothingAllowance.setText(rs.getString("clothingAllowance"));
                } else {
                    // If no data found for the employee ID, clear the JLabels
                    jHourlyRate.setText("");
                    jRiceSubsidy.setText("");
                    jPhoneAllowance.setText("");
                    jClothingAllowance.setText("");
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
    
    private long calculateTotalHoursWorkedForMonth(int year, int month, String employeeID) {
        long totalMinutesWorkedForMonth = 0;

        try {
            // Get the connection from db class
            Connection conn = db.mycon();

            // Check if the connection is successful
            if (conn != null) {
                // Create a statement
                Statement stmt = conn.createStatement();

                // Prepare and execute the query
                String query = "SELECT * FROM attendance_records WHERE YEAR(date) = " + year + " AND MONTH(date) = " + month + " AND employeeID = " + employeeID;
                System.out.println("Executing query: " + query); // Debug output
                ResultSet rs = stmt.executeQuery(query);

                // Iterate through the result set and calculate the total hours worked
                while (rs.next()) {
                    Time timeIn = rs.getTime("timeIn");
                    Time timeOut = rs.getTime("timeOut");

                    if (timeIn != null && timeOut != null) {
                        // Calculate the duration between timeIn and timeOut
                        Duration duration = Duration.between(timeIn.toLocalTime(), timeOut.toLocalTime());
                        long minutes = duration.toMinutes();

                        // Subtract 1 hour for lunch break if total working hours are more than 4 hours
                        if (duration.toHours() > 4) {
                            minutes -= 60;
                        }

                        totalMinutesWorkedForMonth += minutes;
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

        long totalHoursWorkedForMonth = totalMinutesWorkedForMonth / 60;
        long remainingMinutes = totalMinutesWorkedForMonth % 60;

        // Adjust the remaining minutes to hours if they meet the rounding criteria (7h 45m to 8h)
        if (remainingMinutes >= 45) {
            totalHoursWorkedForMonth++;
            remainingMinutes = 0;
        }

        System.out.println("Total hours worked for month: " + totalHoursWorkedForMonth + "h " + remainingMinutes + "m"); // Debug output

        return totalHoursWorkedForMonth;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jGoBack = new Button.Button();
        jLabel23 = new javax.swing.JLabel();
        jTotalHoursWorked = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jEmployeeID = new javax.swing.JComboBox<>();
        jTax = new javax.swing.JLabel();
        jGrossSalary = new javax.swing.JLabel();
        jNetSalary = new javax.swing.JLabel();
        jTotalDeductions = new javax.swing.JLabel();
        jPhilhealthDeductions = new javax.swing.JLabel();
        jClothingAllowance = new javax.swing.JLabel();
        jTotalAllowance = new javax.swing.JLabel();
        jPhoneAllowance = new javax.swing.JLabel();
        jRiceSubsidy = new javax.swing.JLabel();
        jPagibigDeductions = new javax.swing.JLabel();
        jSssDeductions = new javax.swing.JLabel();
        jMonthlyRate = new javax.swing.JLabel();
        jHourlyRate = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jYear = new javax.swing.JComboBox<>();
        jMonth = new javax.swing.JComboBox<>();
        CalculateSalary = new Button.Button();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        button2 = new Button.Button();
        button4 = new Button.Button();
        jLabel21 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jGoBack.setText("Go Back");
        jGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(jGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, -1, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Total Hours Worked:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, -1, 20));

        jTotalHoursWorked.setText("15, 650");
        getContentPane().add(jTotalHoursWorked, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 240, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Employee ID: ");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, 20));

        jEmployeeID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jEmployeeID.setForeground(new java.awt.Color(51, 51, 51));
        jEmployeeID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        getContentPane().add(jEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 230, -1));

        jTax.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jTax.setText("15, 650");
        getContentPane().add(jTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 240, -1));

        jGrossSalary.setText("15, 650");
        getContentPane().add(jGrossSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 240, -1));

        jNetSalary.setText("15, 650");
        getContentPane().add(jNetSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 240, -1));

        jTotalDeductions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTotalDeductions.setText("15, 650");
        getContentPane().add(jTotalDeductions, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 90, -1));

        jPhilhealthDeductions.setText("15, 650");
        getContentPane().add(jPhilhealthDeductions, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 240, -1));

        jClothingAllowance.setText("15, 650");
        getContentPane().add(jClothingAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, 240, -1));

        jTotalAllowance.setText("15, 650");
        getContentPane().add(jTotalAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 240, -1));

        jPhoneAllowance.setText("15, 650");
        getContentPane().add(jPhoneAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 240, -1));

        jRiceSubsidy.setText("15, 650");
        getContentPane().add(jRiceSubsidy, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 240, -1));

        jPagibigDeductions.setText("15, 650");
        getContentPane().add(jPagibigDeductions, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 240, -1));

        jSssDeductions.setText("15, 650");
        getContentPane().add(jSssDeductions, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 240, -1));

        jMonthlyRate.setText("15, 650");
        getContentPane().add(jMonthlyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 240, -1));

        jHourlyRate.setText("543.12");
        getContentPane().add(jHourlyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 240, -1));
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Allowance");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Salary Information");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Withholding Tax:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, -1, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Year:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Net Salary:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, 20));

        jYear.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jYear.setForeground(new java.awt.Color(51, 51, 51));
        jYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010" }));
        jYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jYearActionPerformed(evt);
            }
        });
        getContentPane().add(jYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 80, -1));

        jMonth.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMonth.setForeground(new java.awt.Color(51, 51, 51));
        jMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        getContentPane().add(jMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 140, -1));

        CalculateSalary.setText("Calculate Salary");
        CalculateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(CalculateSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 510, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Month:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("PhilHealth Deductions:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Monthly Rate:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Gross Salary:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, 20));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Hourly Rate:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Total Allowance:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, -1, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Pag-IBIG Deductions:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, 20));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Deductions");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, 20));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Total Deductions:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("SSS Deductions:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Rice Subsidy:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, -1, 20));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Phone Allowance:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, -1, 20));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Clothing Allowance:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, -1, 20));

        button2.setText("Dashboard");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        button4.setText("Logout");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        getContentPane().add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, 30));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SalaryBackground.png"))); // NOI18N
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jYearActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        AdminHomeDashboard adminDashboard = new AdminHomeDashboard();
        adminDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button2ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button4ActionPerformed

    private void CalculateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateSalaryActionPerformed
        // Call the setEmployeeDetails method when a new employee ID is selected
        String selectedEmployeeID = (String) jEmployeeID.getSelectedItem();
        setEmployeeDetails(selectedEmployeeID);

        // Get the selected month and year
        int selectedMonth = jMonth.getSelectedIndex() + 1; // Correct the month index
        int selectedYear = Integer.parseInt((String) jYear.getSelectedItem());

        // Call the calculateTotalHoursWorkedForMonth method to calculate total hours worked
        long totalHoursWorked = calculateTotalHoursWorkedForMonth(selectedYear, selectedMonth, selectedEmployeeID);

        // Display the total hours worked in the JLabel
        jTotalHoursWorked.setText(String.valueOf(totalHoursWorked));
    }//GEN-LAST:event_CalculateSalaryActionPerformed

    private void jGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGoBackActionPerformed
        new ViewSalaryAdmin().setVisible(true); dispose();
    }//GEN-LAST:event_jGoBackActionPerformed

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
            java.util.logging.Logger.getLogger(CreateSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private Button.Button CalculateSalary;
    private Button.Button button2;
    private Button.Button button4;
    private javax.swing.JLabel jClothingAllowance;
    private javax.swing.JComboBox<String> jEmployeeID;
    private Button.Button jGoBack;
    private javax.swing.JLabel jGrossSalary;
    private javax.swing.JLabel jHourlyRate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jMonth;
    private javax.swing.JLabel jMonthlyRate;
    private javax.swing.JLabel jNetSalary;
    private javax.swing.JLabel jPagibigDeductions;
    private javax.swing.JLabel jPhilhealthDeductions;
    private javax.swing.JLabel jPhoneAllowance;
    private javax.swing.JLabel jRiceSubsidy;
    private javax.swing.JLabel jSssDeductions;
    private javax.swing.JLabel jTax;
    private javax.swing.JLabel jTotalAllowance;
    private javax.swing.JLabel jTotalDeductions;
    private javax.swing.JLabel jTotalHoursWorked;
    private javax.swing.JComboBox<String> jYear;
    // End of variables declaration//GEN-END:variables
}
