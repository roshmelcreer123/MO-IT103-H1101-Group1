/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.util.Date;
import java.sql.Time;



/**
 *
 * @author User
 */
public class Attendance {
    
    // Attendance Attributes
    
    private String employeeNumber;
    private Date date;
    private Time timeIn;
    private Time timeOut;
    
    // Attendance Constructor
    
    public Attendance(String employeeNumber, Date date, Time timeIn, Time timeOut){
        
        this.employeeNumber = employeeNumber;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    
    }
    
    // Attendance Getter
    
    public String getEmployeeNumber(){
        return employeeNumber;
    }
    
    public Date getDate(){
        return date;
    }
    
    public Time getTimeIn(){
        return timeIn;
    }
    
    public Time getTimeOut(){
        return timeOut;
    }
    
    // Attendance Setters
    
    public void setEmployeeNumber(String employeeNumber){
        this.employeeNumber = employeeNumber;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public void setTimeIn(Time timeIn){
        this.timeIn = timeIn;
    }
    
    public void setTimeOut(Time timeOut){
        this.timeOut = timeOut;
    }
   
    // Empty Methods based on class diagram
    public void createAttendance(){}
    public void updateAttendance(){}
    public void displayAttendance(){}
    public void deleteAttendance(){}
    public void calculateOvertime(){}
    public void calculateLate(){}
    public void viewAttendanceReport(){}
    
    
}
