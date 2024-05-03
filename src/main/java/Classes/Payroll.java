/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author martin
 */

import java.util.Date;

public class Payroll {
    
    // Payroll Attributes
    private String payrollSystemID;
    private Date lastProcessedMonth;
    
    // Constructor
    public Payroll(String payrollSystemID, Date lastProcessedMonth) {
        this.payrollSystemID = payrollSystemID;
        this.lastProcessedMonth = lastProcessedMonth;
        
    // Payroll Getters
    }
    
    public String getPayrollSystemID() {
        return payrollSystemID;
    }
    
    public Date getLastProcessedMonth() {
        return lastProcessedMonth;
    
        
    // Payroll Setters
    }

    public void setPayrollSystemID(String payrollSystemID) {
        this.payrollSystemID = payrollSystemID;
    }
    
    public void setLastProcessedMonth(Date lastProcessedMonth) {
        this.lastProcessedMonth = lastProcessedMonth;
    }
    
    
    // Empty methods
    public void updateSalary() {}
    public void processEndOfMonth() {}
    public void viewPayrollReports() {}
    public void calculateDeductions() {}
    public void issuePayslips() {}
    public void manageEmployeeBenefits() {}
    
    
    }
