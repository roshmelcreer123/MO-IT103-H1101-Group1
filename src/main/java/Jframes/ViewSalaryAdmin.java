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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author STUDY MODE
 */
public class ViewSalaryAdmin extends javax.swing.JFrame {

    private int selectedSalaryID;
    
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
  
    
    public ViewSalaryAdmin() {
        initComponents();
        fetchData();
        addTableListener();
        //addActionListeners();
    }
    
    private void fetchData() {
        // Call the parameterized method with default values (e.g., current month and year)
        LocalDate currentDate = LocalDate.now();
        fetchData(currentDate.getMonthValue(), currentDate.getYear());
    }

   private void generateSalaries() {
    try {
        // Get the connection from db class
        Connection conn = db.mycon();

        // Check if the connection is successful
        if (conn != null) {
            // Create a statement with scrollable result set
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Fetch all employees
            String fetchEmployeesQuery = "SELECT employeeID FROM employees";
            ResultSet employeesRS = stmt.executeQuery(fetchEmployeesQuery);

            // Store employee IDs in a list
            List<Integer> employeeIDs = new ArrayList<>();
            while (employeesRS.next()) {
                employeeIDs.add(employeesRS.getInt("employeeID"));
            }
            employeesRS.close(); // Close the ResultSet for employees

            // Get the current month and year
            LocalDate currentDate = LocalDate.now();
            int currentYear = currentDate.getYear();
            int currentMonth = currentDate.getMonthValue();

            // Loop over each year from 2022 to the current year
            for (int year = 2022; year <= currentYear; year++) {
                // Loop over each month
                for (int month = 1; month <= 12; month++) {
                    if (year == currentYear && month > currentMonth) {
                        break; // Stop if the month is greater than the current month in the current year
                    }
                    // Process each employee for the given year and month
                    for (int employeeID : employeeIDs) {
                        // Check if a salary record already exists for the given employee, year, and month
                        String checkSalaryQuery = "SELECT salaryID FROM salary WHERE employeeID = ? AND year = ? AND month = ?";
                        PreparedStatement checkStmt = conn.prepareStatement(checkSalaryQuery);
                        checkStmt.setInt(1, employeeID);
                        checkStmt.setInt(2, year);
                        checkStmt.setInt(3, month);
                        ResultSet salaryRS = checkStmt.executeQuery();

                        // If a record exists, delete it
                        if (salaryRS.next()) {
                            int existingSalaryID = salaryRS.getInt("salaryID");
                            String deleteSalaryQuery = "DELETE FROM salary WHERE salaryID = ?";
                            PreparedStatement deleteStmt = conn.prepareStatement(deleteSalaryQuery);
                            deleteStmt.setInt(1, existingSalaryID);
                            deleteStmt.executeUpdate();
                            deleteStmt.close();
                        }
                        salaryRS.close();
                        checkStmt.close();

                        // Fetch total hours worked and total late hours for the employee for the given year and month
                        long totalHoursWorked = calculateTotalHoursWorkedForMonth(year, month, String.valueOf(employeeID));
                        double totalLateHours = calculateTotalLateHoursForMonth(year, month, String.valueOf(employeeID));

                        if (totalHoursWorked > 0.1) {
                            // Fetch employee details for allowances and hourly rate
                            String fetchEmployeeDetailsQuery = "SELECT hourlyRate, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate FROM employees WHERE employeeID = " + employeeID;
                            ResultSet employeeDetailsRS = stmt.executeQuery(fetchEmployeeDetailsQuery);

                            if (employeeDetailsRS.next()) {
                                BigDecimal hourlyRate = employeeDetailsRS.getBigDecimal("hourlyRate");
                                BigDecimal riceSubsidy = employeeDetailsRS.getBigDecimal("riceSubsidy");
                                BigDecimal phoneAllowance = employeeDetailsRS.getBigDecimal("phoneAllowance");
                                BigDecimal clothingAllowance = employeeDetailsRS.getBigDecimal("clothingAllowance");

                                // Calculate total allowances
                                BigDecimal totalAllowance = riceSubsidy.add(phoneAllowance).add(clothingAllowance);

                                // Calculate prorated salary (total hours worked * hourly rate)
                                BigDecimal proratedSalary = hourlyRate.multiply(BigDecimal.valueOf(totalHoursWorked));

                                // Calculate gross salary (prorated salary + total allowances)
                                BigDecimal grossSalary = proratedSalary.add(totalAllowance);

                                // Calculate deductions
                                double basicSalary = employeeDetailsRS.getBigDecimal("grossSemiMonthlyRate").multiply(BigDecimal.valueOf(2)).doubleValue();
                                double philhealthDeduction = calculatePhilhealthDeduction(basicSalary);
                                double sssDeduction = calculateSssDeduction(grossSalary.doubleValue());
                                double pagibigDeduction = calculatePagibigDeduction(basicSalary);
                                double taxDeduction = calculateTaxDeduction(grossSalary.doubleValue());

                                // Calculate total deductions
                                double totalDeductions = philhealthDeduction + sssDeduction + pagibigDeduction + taxDeduction;

                                // Calculate net salary
                                BigDecimal netSalary = grossSalary.subtract(BigDecimal.valueOf(totalDeductions));

                                // Insert salary record into database
                                String insertSalaryQuery = "INSERT INTO salary (employeeID, year, month, totalHoursWorked, totalLateHours, grossSalary, riceSubsidy, phoneAllowance, clothingAllowance, totalAllowance, philhealthDeduction, sssDeduction, pagibigDeduction, taxDeduction, totalDeductions, netSalary) "
                                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                                PreparedStatement pstmt = conn.prepareStatement(insertSalaryQuery);
                                pstmt.setInt(1, employeeID);
                                pstmt.setInt(2, year);
                                pstmt.setInt(3, month);
                                pstmt.setBigDecimal(4, BigDecimal.valueOf(totalHoursWorked));
                                pstmt.setBigDecimal(5, BigDecimal.valueOf(totalLateHours));
                                pstmt.setBigDecimal(6, grossSalary);
                                pstmt.setBigDecimal(7, riceSubsidy);
                                pstmt.setBigDecimal(8, phoneAllowance);
                                pstmt.setBigDecimal(9, clothingAllowance);
                                pstmt.setBigDecimal(10, totalAllowance);
                                pstmt.setBigDecimal(11, BigDecimal.valueOf(philhealthDeduction));
                                pstmt.setBigDecimal(12, BigDecimal.valueOf(sssDeduction));
                                pstmt.setBigDecimal(13, BigDecimal.valueOf(pagibigDeduction));
                                pstmt.setBigDecimal(14, BigDecimal.valueOf(taxDeduction));
                                pstmt.setBigDecimal(15, BigDecimal.valueOf(totalDeductions));
                                pstmt.setBigDecimal(16, netSalary);
                                pstmt.executeUpdate();
                                pstmt.close();
                            }
                            employeeDetailsRS.close();
                        }
                    }
                }
            }

            stmt.close();
            conn.close();

            // Refresh the table
            fetchData(LocalDate.now().getMonthValue(), LocalDate.now().getYear()); // Adjusted to call the parameterized method
            JOptionPane.showMessageDialog(this, "Salaries generated successfully!");
        } else {
            System.out.println("Failed to make connection!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}




        // Methods for deductions and calculations
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

    public double calculateLateWorkHours(Time timeIn) throws java.text.ParseException {
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

    public double calculateTotalLateHoursForMonth(int year, int month, String employeeID) {
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

    public long calculateTotalHoursWorkedForMonth(int year, int month, String employeeID) {
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
    
    
    private void fetchData(int month, int year) {
        try {
            // Get the connection from db class
            Connection conn = db.mycon();

            // Check if the connection is successful
            if (conn != null) {
                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query to retrieve data from the salary table based on the selected month and year
                String query = "SELECT * FROM salary WHERE month = " + month + " AND year = " + year;
                ResultSet rs = stmt.executeQuery(query);

                // Get the table model from jTable1
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0); // Clear existing data

                // Add rows to the table model
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("salaryID"),
                        rs.getInt("employeeID"),
                        rs.getInt("year"),
                        rs.getInt("month"),
                        rs.getBigDecimal("totalHoursWorked"),
                        rs.getBigDecimal("totalLateHours"),
                        rs.getBigDecimal("totalAllowance"),
                        rs.getBigDecimal("grossSalary"),
                        rs.getBigDecimal("totalDeductions"),
                        rs.getBigDecimal("netSalary")
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



    private void addTableListener() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTable1.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                // Assuming the ID is in the first column
                selectedSalaryID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
            }
        });
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFilter = new Button.DarkButton();
        jLabel7 = new javax.swing.JLabel();
        jMonthComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jYearComboBox = new javax.swing.JComboBox<>();
        calculateSalary = new Button.DarkButton();
        btnDashboard = new Button.Button();
        btnLogout = new Button.Button();
        Label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        viewSalary = new Button.DarkButton();
        deleteSalary = new Button.DarkButton();
        updateSalary = new Button.DarkButton();
        createSalary = new Button.DarkButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jFilter.setText("Filter");
        jFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFilterActionPerformed(evt);
            }
        });
        getContentPane().add(jFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 160, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Month:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, 20));

        jMonthComboBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMonthComboBox.setForeground(new java.awt.Color(51, 51, 51));
        jMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        getContentPane().add(jMonthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 140, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Year:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, 20));

        jYearComboBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jYearComboBox.setForeground(new java.awt.Color(51, 51, 51));
        jYearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010" }));
        jYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jYearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(jYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 80, -1));

        calculateSalary.setText("Generate Salary");
        calculateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(calculateSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 160, -1));

        btnDashboard.setText("Dashboard");
        btnDashboard.setToolTipText("");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 30));

        btnLogout.setText("Logout");
        btnLogout.setToolTipText("");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 120, 30));

        Label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Label.setForeground(new java.awt.Color(255, 255, 255));
        Label.setText("Salary Database");
        getContentPane().add(Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setColumnHeaderView(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Salary ID", "Employee ID", "Year", "Month", "Total Hours Worked", "Total Late Hours", "Total Allowance", "Gross Salary", "Total Deductions", "Net Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 940, 330));

        viewSalary.setText("View");
        viewSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(viewSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 160, -1));

        deleteSalary.setText("Delete");
        deleteSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(deleteSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 160, -1));

        updateSalary.setText("Update");
        updateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(updateSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 160, -1));

        createSalary.setText("Create");
        createSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(createSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 160, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/For Other Pages.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // Redirects to Admin Dashboard
        new AdminHomeDashboard().setVisible(true); dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // Create an instance of LoginNew and display it
        new LogInNew().setVisible(true); dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void createSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSalaryActionPerformed
        new CreateSalary().setVisible(true); dispose();
    }//GEN-LAST:event_createSalaryActionPerformed

    private void deleteSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSalaryActionPerformed
        if (selectedSalaryID != 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this salary record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    // Get the connection from db class
                    Connection conn = db.mycon();

                    // Check if the connection is successful
                    if (conn != null) {
                        // Prepare a delete statement
                        String query = "DELETE FROM salary WHERE salaryID = ?";
                        PreparedStatement pstmt = conn.prepareStatement(query);
                        pstmt.setInt(1, selectedSalaryID);
                        pstmt.executeUpdate();

                        // Close the connection
                        pstmt.close();
                        conn.close();

                        // Refresh the table
                        fetchData();
                        JOptionPane.showMessageDialog(this, "Salary record deleted successfully!");
                    } else {
                        System.out.println("Failed to make connection!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to delete salary record.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No salary record selected.");
        }
    }//GEN-LAST:event_deleteSalaryActionPerformed

    private void viewSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSalaryActionPerformed
        if (selectedSalaryID != 0) {
            int selectedRow = jTable1.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            int salaryID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
            int employeeID = Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
            int year = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());
            int month = Integer.parseInt(model.getValueAt(selectedRow, 3).toString());
            BigDecimal totalHoursWorked = new BigDecimal(model.getValueAt(selectedRow, 4).toString());
            BigDecimal totalLateHours = new BigDecimal(model.getValueAt(selectedRow, 5).toString());
            BigDecimal totalAllowance = new BigDecimal(model.getValueAt(selectedRow, 6).toString());
            BigDecimal grossSalary = new BigDecimal(model.getValueAt(selectedRow, 7).toString());
            BigDecimal totalDeductions = new BigDecimal(model.getValueAt(selectedRow, 8).toString());
            BigDecimal netSalary = new BigDecimal(model.getValueAt(selectedRow, 9).toString());

            ViewOneSalaryAdmin viewOneSalaryAdmin = new ViewOneSalaryAdmin();
            viewOneSalaryAdmin.setSalaryData(salaryID, employeeID, year, month, totalHoursWorked, totalLateHours, totalAllowance, grossSalary, totalDeductions, netSalary);
            viewOneSalaryAdmin.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No salary record selected.");
        }
    }//GEN-LAST:event_viewSalaryActionPerformed

    private void updateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSalaryActionPerformed
        if (selectedSalaryID != 0) {
            int selectedRow = jTable1.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            int employeeID = Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
            int year = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());
            int month = Integer.parseInt(model.getValueAt(selectedRow, 3).toString());
            BigDecimal totalHoursWorked = new BigDecimal(model.getValueAt(selectedRow, 4).toString());
            BigDecimal totalLateHours = new BigDecimal(model.getValueAt(selectedRow, 5).toString());
            BigDecimal totalAllowance = new BigDecimal(model.getValueAt(selectedRow, 6).toString());
            BigDecimal grossSalary = new BigDecimal(model.getValueAt(selectedRow, 7).toString());
            BigDecimal totalDeductions = new BigDecimal(model.getValueAt(selectedRow, 8).toString());
            BigDecimal netSalary = new BigDecimal(model.getValueAt(selectedRow, 9).toString());

            new UpdateSalaryAdmin(selectedSalaryID, employeeID, year, month, totalHoursWorked, totalLateHours, totalAllowance, grossSalary, totalDeductions, netSalary).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No salary record selected.");
        }
    }//GEN-LAST:event_updateSalaryActionPerformed

    private void calculateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateSalaryActionPerformed
        generateSalaries();
    }//GEN-LAST:event_calculateSalaryActionPerformed

    private void jYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jYearComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jYearComboBoxActionPerformed

    private void jFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFilterActionPerformed
        int month = jMonthComboBox.getSelectedIndex() + 1; // Assuming January is at index 0
        int year = Integer.parseInt(jYearComboBox.getSelectedItem().toString());

        fetchData(month, year);
    }//GEN-LAST:event_jFilterActionPerformed

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
            java.util.logging.Logger.getLogger(ViewSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSalaryAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSalaryAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Label;
    private Button.Button btnDashboard;
    private Button.Button btnLogout;
    private Button.DarkButton calculateSalary;
    private Button.DarkButton createSalary;
    private Button.DarkButton deleteSalary;
    private Button.DarkButton jFilter;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> jMonthComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jYearComboBox;
    private Button.DarkButton updateSalary;
    private Button.DarkButton viewSalary;
    // End of variables declaration//GEN-END:variables
}
