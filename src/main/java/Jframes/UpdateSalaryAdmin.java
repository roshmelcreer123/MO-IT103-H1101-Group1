/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;


import Jframes.AttendanceDashboardAdmin;
import Classes.db;
import com.google.protobuf.TextFormat.ParseException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UpdateSalaryAdmin extends javax.swing.JFrame {
    
    private String userID;
    
    //instance variable
    private int salaryID;
    
    /* Deduction Constants */
    
    // Philhealth constants
    private static final double PHILHEALTH_LOWER_SALARY_CAP = 10000.00;
    private static final double PHILHEALTH_UPPER_SALARY_CAP = 60000.00;
    private static final double PHILHEALTH_MINIMUM_PREMIUM = 300.00;
    private static final double PHILHEALTH_MAXIMUM_PREMIUM = 1800.00;

    // Pag-ibig constants
    private static final double PAGIBIG_LOWER_RATE = 0.01;
    private static final double PAGIBIG_UPPER_RATE = 0.02;
    private static final double PAGIBIG_LOWER_SALARY_CAP = 1500.00;
    private static final double PAGIBIG_MAXIMUM_CONTRIBUTION = 100.00;

    // Tax brackets as provided in the table
    private static final double[] TAX_BRACKETS = {20833, 33333, 66667, 166667, 666667};
    private static final double[] TAX_BASE = {0, 2500, 10833, 40833.33, 200833.33};
    private static final double[] TAX_RATES = {0.2, 0.25, 0.3, 0.32, 0.35};
  
    
    /**
     * Creates new form CreateSalary
     */
    public UpdateSalaryAdmin(String userID, int salaryID, int employeeID, int year, int month, BigDecimal totalHoursWorked, BigDecimal totalLateHours, BigDecimal totalAllowance, BigDecimal grossSalary, BigDecimal totalDeductions, BigDecimal netSalary) {
        this.salaryID = salaryID;
        this.userID = userID;
        initComponents();
        fillEmployeeIDs();
        populateFields(employeeID, year, month, totalHoursWorked, totalLateHours, totalAllowance, grossSalary, totalDeductions, netSalary);
    }
    
    private void populateFields(int employeeID, int year, int month, BigDecimal totalHoursWorked, BigDecimal totalLateHours, BigDecimal totalAllowance, BigDecimal grossSalary, BigDecimal totalDeductions, BigDecimal netSalary) {
        
        jEmployeeID.setSelectedItem(String.valueOf(employeeID));
        jYear.setSelectedItem(String.valueOf(year));
        jMonth.setSelectedIndex(month - 1);
        jTotalHoursWorked.setText(totalHoursWorked.toString());
        jLateHours.setText(totalLateHours.toString());
        jGrossSalary.setText(grossSalary.toString());
        jTotalAllowance.setText(totalAllowance.toString());
        jTotalDeductions.setText(totalDeductions.toString());
        jNetSalary.setText(netSalary.toString());
        
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
                String query = "SELECT hourlyRate, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate FROM employees WHERE employeeID = '" + employeeID + "'";
                ResultSet rs = stmt.executeQuery(query);

                // Check if the result set has data
                if (rs.next()) {
                    // Set the values to the corresponding JLabels
                    jHourlyRate.setText(rs.getString("hourlyRate"));
                    jRiceSubsidy.setText(rs.getString("riceSubsidy"));
                    jPhoneAllowance.setText(rs.getString("phoneAllowance"));
                    jClothingAllowance.setText(rs.getString("clothingAllowance"));
                    
                    // Calculate the monthly rate by doubling the gross semi-monthly rate
                    BigDecimal grossSemiMonthlyRate = rs.getBigDecimal("grossSemiMonthlyRate");
                    BigDecimal monthlyRate = grossSemiMonthlyRate.multiply(BigDecimal.valueOf(2));
                    jMonthlyRate.setText(monthlyRate.toString());
                    
                    
                } else {
                    // If no data found for the employee ID, clear the JLabels
                    jHourlyRate.setText("");
                    jRiceSubsidy.setText("");
                    jPhoneAllowance.setText("");
                    jClothingAllowance.setText("");
                    jMonthlyRate.setText("");
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
    
    // Calculate gross salary
    private BigDecimal calculateGrossSalary(String employeeID, int year, int month) {
        // Fetch employee details
        setEmployeeDetails(employeeID);

        // Get hourly rate and allowances from UI
        BigDecimal hourlyRate = new BigDecimal(jHourlyRate.getText());
        BigDecimal riceSubsidy = new BigDecimal(jRiceSubsidy.getText());
        BigDecimal phoneAllowance = new BigDecimal(jPhoneAllowance.getText());
        BigDecimal clothingAllowance = new BigDecimal(jClothingAllowance.getText());

        // Calculate total allowances
        BigDecimal totalAllowance = riceSubsidy.add(phoneAllowance).add(clothingAllowance);

        // Calculate total hours worked
        long totalHoursWorked = calculateTotalHoursWorkedForMonth(year, month, employeeID);

        // Calculate prorated salary (total hours worked * hourly rate)
        BigDecimal proratedSalary = hourlyRate.multiply(BigDecimal.valueOf(totalHoursWorked));

        // Calculate gross salary (prorated salary + total allowances)
        BigDecimal grossSalary = proratedSalary.add(totalAllowance);

        System.out.println("Gross salary: " + grossSalary.toString()); // Debug output

        return grossSalary;
    }
    
    
    public static double calculatePhilhealthDeduction(double basicSalary) {
        double philhealhthContribution;

        if (basicSalary <= PHILHEALTH_LOWER_SALARY_CAP) {
            philhealhthContribution = PHILHEALTH_MINIMUM_PREMIUM / 2;
        } else if (basicSalary > PHILHEALTH_LOWER_SALARY_CAP && basicSalary < PHILHEALTH_UPPER_SALARY_CAP) {
            double totalPremium = (basicSalary * 0.03);
            philhealhthContribution = totalPremium / 2;
            philhealhthContribution = Math.max(philhealhthContribution, PHILHEALTH_MINIMUM_PREMIUM / 2);
            philhealhthContribution = Math.min(philhealhthContribution, PHILHEALTH_MAXIMUM_PREMIUM / 2);
        } else {
            philhealhthContribution = PHILHEALTH_MAXIMUM_PREMIUM / 2;
        }

        return philhealhthContribution;
    }

    public static double calculateSssDeduction(double grossSalary) {
        double roundedSalary = Math.round(grossSalary / 500.0) * 500;
        double sssContribution = Math.min(Math.max(roundedSalary * 0.045, 135), 1125);
        return sssContribution;
    }

    public static double calculatePagibigDeduction(double basicSalary) {
        double contributionRate = basicSalary > PAGIBIG_LOWER_SALARY_CAP ? PAGIBIG_UPPER_RATE : PAGIBIG_LOWER_RATE;
        double pabibigContribution = basicSalary * contributionRate;
        pabibigContribution = Math.min(pabibigContribution, PAGIBIG_MAXIMUM_CONTRIBUTION);
        return pabibigContribution;
    }
    
    public static double calculateTaxDeduction(double taxableIncome) {
        double taxDue = 0;

        for (int i = 0; i < TAX_BRACKETS.length; i++) {
            if (taxableIncome > TAX_BRACKETS[i]) {
                if (i + 1 < TAX_BRACKETS.length && taxableIncome >= TAX_BRACKETS[i + 1]) {
                    // If taxable income is greater than the current bracket but less than the next bracket
                    // Continue to next iteration to find the correct bracket
                    continue;
                }

                // Calculate tax for the bracket the taxable income falls into
                taxDue = TAX_BASE[i] + ((taxableIncome - TAX_BRACKETS[i]) * TAX_RATES[i]);
                break;
            }
        }

        return taxDue;
    }
    
        private double calculateLateWorkHours(Time timeIn) throws java.text.ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            java.util.Date expectedTimeIn = sdf.parse("08:00:00");
            java.util.Date actualTimeIn = sdf.parse(timeIn.toString());

            // Create a calendar instance to handle time calculations
            Calendar cal = Calendar.getInstance();
            cal.setTime(expectedTimeIn);

            // Add 10 minutes to the expected time in to set the late threshold
            cal.add(Calendar.MINUTE, 10);
            java.util.Date lateThreshold = cal.getTime();

            // Check if the employee is late by comparing the actual time in with the late threshold
            if (actualTimeIn.after(expectedTimeIn)) {
                // If actual time in is after expected time in, but before the late threshold, consider it not late
                if (actualTimeIn.before(lateThreshold)) {
                    return 0; // Not late if between 08:00 and 08:10
                }

                // If actual time in is after the late threshold, calculate the late hours
                long differenceInMilliseconds = actualTimeIn.getTime() - expectedTimeIn.getTime();
                // Convert milliseconds to hours and round to the second decimal place
                double differenceInHours = ((double) differenceInMilliseconds / (1000 * 60 * 60));
                differenceInHours = Math.round(differenceInHours * 100.0) / 100.0; // Rounding to two decimal places

                // Check if differenceInHours falls within the specified range (0.17 to 0)
                if (differenceInHours > 0 && differenceInHours <= 0.17) {
                    return 0; // Not late if the difference is within the specified range
                }

                return differenceInHours;
            }

            return 0; // Return 0 if not late
        }

    private double calculateTotalLateHoursForMonth(int year, int month, String employeeID) {
        double totalLateHours = 0;

        try {
            // Get the connection from db class
            Connection conn = db.mycon();

            // Check if the connection is successful
            if (conn != null) {
                // Create a statement
                Statement stmt = conn.createStatement();

                // Prepare and execute the query
                String query = "SELECT timeIn FROM attendance_records WHERE YEAR(date) = " + year + " AND MONTH(date) = " + month + " AND employeeID = " + employeeID;
                ResultSet rs = stmt.executeQuery(query);

                // Iterate through the result set and calculate the total late hours
                while (rs.next()) {
                    Time timeIn = rs.getTime("timeIn");

                    if (timeIn != null) {
                        // Calculate late hours for the day
                        double lateHours = calculateLateWorkHours(timeIn);
                        totalLateHours += lateHours;
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

        return totalLateHours;
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        updateSalary = new Button.Button();
        jLabel24 = new javax.swing.JLabel();
        jLateHours = new javax.swing.JLabel();
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

        updateSalary.setText("Update Salary");
        updateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(updateSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 510, -1, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Total Late Hours:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, -1, 20));

        jLateHours.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLateHours.setText("15, 650");
        getContentPane().add(jLateHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, 240, -1));

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
        getContentPane().add(jTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 240, -1));

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
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, -1, 20));

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
        getContentPane().add(CalculateSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, -1, -1));

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
        AdminHomeDashboard adminDashboard = new AdminHomeDashboard(userID);
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
         // Get the selected employee ID
         String selectedEmployeeID = (String) jEmployeeID.getSelectedItem();

         // Get the selected month and year
         int selectedMonth = jMonth.getSelectedIndex() + 1; // Correct the month index
         int selectedYear = Integer.parseInt((String) jYear.getSelectedItem());

         // Fetch and display employee details
         setEmployeeDetails(selectedEmployeeID);

         // Calculate total hours worked for the selected month and year
         long totalHoursWorked = calculateTotalHoursWorkedForMonth(selectedYear, selectedMonth, selectedEmployeeID);

         // Display the total hours worked in the JLabel
         jTotalHoursWorked.setText(totalHoursWorked + " hours");

         // Calculate total late hours for the selected month and year
         double totalLateHours = calculateTotalLateHoursForMonth(selectedYear, selectedMonth, selectedEmployeeID);

         // Display the total late hours in the JLabel
         jLateHours.setText(String.format("%.2f", totalLateHours) + " hours");

         // Fetch hourly rate and allowances from the JLabels (these values are set in setEmployeeDetails method)
         BigDecimal hourlyRate = new BigDecimal(jHourlyRate.getText());
         BigDecimal riceSubsidy = new BigDecimal(jRiceSubsidy.getText());
         BigDecimal phoneAllowance = new BigDecimal(jPhoneAllowance.getText());
         BigDecimal clothingAllowance = new BigDecimal(jClothingAllowance.getText());

         // Calculate total allowances
         BigDecimal totalAllowance = riceSubsidy.add(phoneAllowance).add(clothingAllowance);

         // Calculate prorated salary (total hours worked * hourly rate)
         BigDecimal proratedSalary = hourlyRate.multiply(BigDecimal.valueOf(totalHoursWorked));

         // Calculate gross salary (prorated salary + total allowances)
         BigDecimal grossSalary = proratedSalary.add(totalAllowance);

         // Calculate deductions
         double basicSalary = new BigDecimal(jMonthlyRate.getText()).doubleValue(); // Assuming jMonthlyRate holds the basic salary
         double philhealthDeduction = calculatePhilhealthDeduction(basicSalary);
         double sssDeduction = calculateSssDeduction(grossSalary.doubleValue());
         double pagibigDeduction = calculatePagibigDeduction(basicSalary);
         double taxDeduction = calculateTaxDeduction(grossSalary.doubleValue());

         // Calculate total deductions
         double totalDeductions = philhealthDeduction + sssDeduction + pagibigDeduction + taxDeduction;

         // Calculate net salary
         BigDecimal netSalary = grossSalary.subtract(BigDecimal.valueOf(totalDeductions));

         // Display Deductions
         jPhilhealthDeductions.setText(String.format("%.2f", philhealthDeduction));
         jSssDeductions.setText(String.format("%.2f", sssDeduction));
         jPagibigDeductions.setText(String.format("%.2f", pagibigDeduction));
         jTax.setText(String.format("%.2f", taxDeduction));

         // Display the gross salary, total allowance, and net salary in the JLabels
         jGrossSalary.setText(grossSalary.toString());
         jTotalAllowance.setText(totalAllowance.toString());
         jTotalDeductions.setText(String.format("%.2f", totalDeductions));
         jNetSalary.setText(netSalary.toString());
    }//GEN-LAST:event_CalculateSalaryActionPerformed

    private void jGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGoBackActionPerformed
        new ViewSalaryAdmin(userID).setVisible(true); dispose();
    }//GEN-LAST:event_jGoBackActionPerformed

    private void updateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSalaryActionPerformed
        try {
            Connection conn = db.mycon();
            if (conn != null) {
                String query = "UPDATE salary SET employeeID = ?, year = ?, month = ?, totalHoursWorked = ?, totalLateHours = ?, grossSalary = ?, riceSubsidy = ?, phoneAllowance = ?, clothingAllowance = ?, totalAllowance = ?, philhealthDeduction = ?, sssDeduction = ?, pagibigDeduction = ?, taxDeduction = ?, totalDeductions = ?, netSalary = ? WHERE salaryID = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, Integer.parseInt((String) jEmployeeID.getSelectedItem()));
                pstmt.setInt(2, Integer.parseInt((String) jYear.getSelectedItem()));
                pstmt.setInt(3, jMonth.getSelectedIndex() + 1);
                pstmt.setBigDecimal(4, new BigDecimal(jTotalHoursWorked.getText().split(" ")[0]));
                pstmt.setBigDecimal(5, new BigDecimal(jLateHours.getText().split(" ")[0]));
                pstmt.setBigDecimal(6, new BigDecimal(jGrossSalary.getText()));
                pstmt.setBigDecimal(7, new BigDecimal(jRiceSubsidy.getText()));
                pstmt.setBigDecimal(8, new BigDecimal(jPhoneAllowance.getText()));
                pstmt.setBigDecimal(9, new BigDecimal(jClothingAllowance.getText()));
                pstmt.setBigDecimal(10, new BigDecimal(jTotalAllowance.getText()));
                pstmt.setBigDecimal(11, new BigDecimal(jPhilhealthDeductions.getText()));
                pstmt.setBigDecimal(12, new BigDecimal(jSssDeductions.getText()));
                pstmt.setBigDecimal(13, new BigDecimal(jPagibigDeductions.getText()));
                pstmt.setBigDecimal(14, new BigDecimal(jTax.getText()));
                pstmt.setBigDecimal(15, new BigDecimal(jTotalDeductions.getText()));
                pstmt.setBigDecimal(16, new BigDecimal(jNetSalary.getText()));
                pstmt.setInt(17, this.salaryID); // Use the instance variable salaryID
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
             JOptionPane.showMessageDialog(this, "Salary record updated successfully!");
         } else {
             System.out.println("Failed to make connection!");
         }
     } catch (Exception e) {
         e.printStackTrace();
         JOptionPane.showMessageDialog(this, "Failed to update salary record.");
     }
    
        // Clear input fields so user wont need to manually remove each one after updating data in the Database
        jEmployeeID.setSelectedIndex(0);
        jYear.setSelectedIndex(0);
        jMonth.setSelectedIndex(0);
        jTotalHoursWorked.setText("0");
        jLateHours.setText("0");
        jGrossSalary.setText("0");
        jRiceSubsidy.setText("0");
        jPhoneAllowance.setText("0");
        jClothingAllowance.setText("0");
        jTotalAllowance.setText("0");
        jPhilhealthDeductions.setText("0");
        jSssDeductions.setText("0");
        jPagibigDeductions.setText("0");
        jTax.setText("0");
        jTotalDeductions.setText("0");
        jNetSalary.setText("0");
    }//GEN-LAST:event_updateSalaryActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLateHours;
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
    private Button.Button updateSalary;
    // End of variables declaration//GEN-END:variables
}
