/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import java.sql.*;
import javax.swing.JOptionPane;
import Classes.db;
import java.math.BigDecimal;



/**
 *
 * @author roshmelcreer
 */
public class UpdateEmployee extends javax.swing.JFrame {

    private int employeeID; // declare employeeID as a class-level variable
    private String firstName;
    private String lastName;
    private java.sql.Date birthday;
    private String address;
    private String phoneNumber;
    private String sssNumber;
    private String philhealthNumber;
    private String tinNumber;
    private String pagibigNumber;
    private String status;
    private String position;
    private String immediateSupervisor;
    private BigDecimal basicSalary;
    private BigDecimal riceSubsidy;
    private BigDecimal phoneAllowance;
    private BigDecimal clothingAllowance;
    private BigDecimal grossSemiMonthlyRate;
    private BigDecimal hourlyRate;
    
    
    /// Constructor with parameters
    public UpdateEmployee(int employeeID, String firstName, String lastName, java.sql.Date birthday, String address,
                          String phoneNumber, String sssNumber, String philhealthNumber, String tinNumber,
                          String pagibigNumber, String status, String position, String immediateSupervisor,
                          BigDecimal basicSalary, BigDecimal riceSubsidy, BigDecimal phoneAllowance, 
                          BigDecimal clothingAllowance, BigDecimal grossSemiMonthlyRate, BigDecimal hourlyRate) {
        initComponents();
        
        // Assign the passed parameters to class-level variables
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagibigNumber = pagibigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;


        
        // Set form fields with passed data
        jEmployeeFirstName.setText(firstName);
        jEmployeeLastName.setText(lastName);
        jEmployeeBirthday.setDate(birthday);
        jEmployeeAddress.setText(address);
        jPhoneNumber.setText(phoneNumber);
        jSssNumber.setText(sssNumber);
        jPhilhealthNumber.setText(philhealthNumber);
        jTinNumber.setText(tinNumber);
        jPagibigNumber.setText(pagibigNumber);
        jPosition.setText(position);
        jImmediateSupervisor.setText(immediateSupervisor);
        
        
        // Convert BigDecimal values to String before setting them to text fields
        jBasicSalary.setText(basicSalary.toString());
        jRiceSubsidy.setText(riceSubsidy.toString());
        jPhoneAllowance.setText(phoneAllowance.toString());
        jClothingAllowance.setText(clothingAllowance.toString());
        jGrossSemiMonthlyRate.setText(grossSemiMonthlyRate.toString());
        jHourlyRate.setText(hourlyRate.toString());
        
        
        jStatus.setSelectedItem(status);
    }
    
   

    // Method to clear input fields
    private void clearFields() {
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
        jBasicSalary.setText("");
        jRiceSubsidy.setText("");
        jPhoneAllowance.setText("");
        jClothingAllowance.setText("");
        jGrossSemiMonthlyRate.setText("");
        jHourlyRate.setText("");
        jStatus.setSelectedIndex(-1);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEmployeeAddress = new javax.swing.JTextArea();
        jPhoneNumber = new javax.swing.JTextField();
        jEmployeeBirthday = new com.toedter.calendar.JDateChooser();
        jEmployeeFirstName = new javax.swing.JTextField();
        jEmployeeLastName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jImmediateSupervisor = new javax.swing.JTextField();
        jPosition = new javax.swing.JTextField();
        jStatus = new javax.swing.JComboBox<>();
        jPagibigNumber = new javax.swing.JTextField();
        jTinNumber = new javax.swing.JTextField();
        jPhilhealthNumber = new javax.swing.JTextField();
        jSssNumber = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jHourlyRate = new javax.swing.JTextField();
        jGrossSemiMonthlyRate = new javax.swing.JTextField();
        jClothingAllowance = new javax.swing.JTextField();
        jPhoneAllowance = new javax.swing.JTextField();
        jRiceSubsidy = new javax.swing.JTextField();
        jBasicSalary = new javax.swing.JTextField();
        button4 = new Button.Button();
        jLabel1 = new javax.swing.JLabel();
        button7 = new Button.Button();
        darkButton2 = new Button.DarkButton();
        jUpdateEmployee = new Button.DarkButton();
        button1 = new Button.Button();
        backgroundPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Last Name:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("First Name:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Birthday");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Phone Number");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Address");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jEmployeeAddress.setColumns(20);
        jEmployeeAddress.setForeground(new java.awt.Color(153, 153, 153));
        jEmployeeAddress.setRows(5);
        jEmployeeAddress.setText("Enter address here");
        jEmployeeAddress.setToolTipText("");
        jScrollPane2.setViewportView(jEmployeeAddress);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 150, -1));

        jPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPhoneNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 150, -1));

        jEmployeeBirthday.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jEmployeeBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 150, -1));

        jEmployeeFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmployeeFirstNameActionPerformed(evt);
            }
        });
        getContentPane().add(jEmployeeFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 150, -1));

        jEmployeeLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmployeeLastNameActionPerformed(evt);
            }
        });
        getContentPane().add(jEmployeeLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 150, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("SSS Number:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Philhealth Number:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Tin Number:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("PagIbig Number: ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Status:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Position:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Immediate Supervisor:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, -1, -1));

        jImmediateSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jImmediateSupervisorActionPerformed(evt);
            }
        });
        getContentPane().add(jImmediateSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 150, -1));

        jPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPositionActionPerformed(evt);
            }
        });
        getContentPane().add(jPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 150, -1));

        jStatus.setForeground(new java.awt.Color(153, 153, 153));
        jStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employed", "Unemployed" }));
        getContentPane().add(jStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 150, -1));

        jPagibigNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPagibigNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jPagibigNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 150, -1));

        jTinNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTinNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jTinNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 150, -1));

        jPhilhealthNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPhilhealthNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jPhilhealthNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 150, -1));

        jSssNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSssNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jSssNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 150, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Basic Salary:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Rice Subsidy:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, -1, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Phone Allowance:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Clothing Allowance:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Gross Semi Monthly Rate:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, -1, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Hourly Rate");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, -1, -1));

        jHourlyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHourlyRateActionPerformed(evt);
            }
        });
        getContentPane().add(jHourlyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 150, -1));

        jGrossSemiMonthlyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGrossSemiMonthlyRateActionPerformed(evt);
            }
        });
        getContentPane().add(jGrossSemiMonthlyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, 150, -1));

        jClothingAllowance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClothingAllowanceActionPerformed(evt);
            }
        });
        getContentPane().add(jClothingAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 310, 150, -1));

        jPhoneAllowance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPhoneAllowanceActionPerformed(evt);
            }
        });
        getContentPane().add(jPhoneAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 150, -1));

        jRiceSubsidy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRiceSubsidyActionPerformed(evt);
            }
        });
        getContentPane().add(jRiceSubsidy, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, 150, -1));

        jBasicSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBasicSalaryActionPerformed(evt);
            }
        });
        getContentPane().add(jBasicSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, 150, -1));

        button4.setText("Dashboard");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        getContentPane().add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update an Employee");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        button7.setText("Logout");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        getContentPane().add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, 30));

        darkButton2.setText("Go Back");
        darkButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(darkButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, -1, -1));

        jUpdateEmployee.setText("Update Employee");
        jUpdateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(jUpdateEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, -1, -1));

        button1.setText("Clear");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 160, -1));

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
        ViewAllEmployee viewEmployees = new ViewAllEmployee();
        viewEmployees.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_darkButton2ActionPerformed

    private void jUpdateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateEmployeeActionPerformed
        // Getting the updated data from the form fields
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

        // SQL Query to update data in MYSQL Database
        try{
            Statement s = db.mycon().createStatement();
            s.executeUpdate("UPDATE employees SET lastName='"+lastName+"', firstName='"+firstName+"', birthday='"+birthday+"', address='"+address+"', phoneNumber='"+phoneNumber+"', sssNumber='"+sssNumber+"', philhealthNumber='"+philhealthNumber+"', tinNumber='"+tinNumber+"', pagibigNumber='"+pagibigNumber+"', status='"+status+"', position='"+position+"', immediateSupervisor='"+immediateSupervisor+"' WHERE employeeID="+this.employeeID);

            // Dialogue Box to inform user that the employee has been updated
            JOptionPane.showMessageDialog(rootPane, "Employee details have been updated successfully");

        }
        catch(Exception e){
            e.printStackTrace();
        }

        // Redirects to View All Employees Admin Page
        AdminHomeDashboard adminDashboard = new AdminHomeDashboard();
        adminDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jUpdateEmployeeActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
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
        jBasicSalary.setText("");
        jRiceSubsidy.setText("");
        jPhoneAllowance.setText("");
        jClothingAllowance.setText("");
        jGrossSemiMonthlyRate.setText("");
        jHourlyRate.setText("");
        jStatus.setSelectedIndex(-1);
    }//GEN-LAST:event_button1ActionPerformed

    private void jPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPhoneNumberActionPerformed

    private void jEmployeeFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmployeeFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmployeeFirstNameActionPerformed

    private void jEmployeeLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmployeeLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmployeeLastNameActionPerformed

    private void jImmediateSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jImmediateSupervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jImmediateSupervisorActionPerformed

    private void jPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPositionActionPerformed

    private void jPagibigNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPagibigNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPagibigNumberActionPerformed

    private void jTinNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTinNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTinNumberActionPerformed

    private void jPhilhealthNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPhilhealthNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPhilhealthNumberActionPerformed

    private void jSssNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSssNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSssNumberActionPerformed

    private void jHourlyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHourlyRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jHourlyRateActionPerformed

    private void jGrossSemiMonthlyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGrossSemiMonthlyRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jGrossSemiMonthlyRateActionPerformed

    private void jClothingAllowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClothingAllowanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jClothingAllowanceActionPerformed

    private void jPhoneAllowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPhoneAllowanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPhoneAllowanceActionPerformed

    private void jRiceSubsidyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRiceSubsidyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRiceSubsidyActionPerformed

    private void jBasicSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBasicSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBasicSalaryActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundPicture;
    private Button.Button button1;
    private Button.Button button4;
    private Button.Button button7;
    private Button.DarkButton darkButton2;
    private javax.swing.JTextField jBasicSalary;
    private javax.swing.JTextField jClothingAllowance;
    private javax.swing.JTextArea jEmployeeAddress;
    private com.toedter.calendar.JDateChooser jEmployeeBirthday;
    private javax.swing.JTextField jEmployeeFirstName;
    private javax.swing.JTextField jEmployeeLastName;
    private javax.swing.JTextField jGrossSemiMonthlyRate;
    private javax.swing.JTextField jHourlyRate;
    private javax.swing.JTextField jImmediateSupervisor;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jPagibigNumber;
    private javax.swing.JTextField jPhilhealthNumber;
    private javax.swing.JTextField jPhoneAllowance;
    private javax.swing.JTextField jPhoneNumber;
    private javax.swing.JTextField jPosition;
    private javax.swing.JTextField jRiceSubsidy;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jSssNumber;
    private javax.swing.JComboBox<String> jStatus;
    private javax.swing.JTextField jTinNumber;
    private Button.DarkButton jUpdateEmployee;
    // End of variables declaration//GEN-END:variables
}
