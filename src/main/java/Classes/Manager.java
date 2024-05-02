/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author User
 */
public class Manager {
    
    // Manager Attributes
    private String teamID;
    private int teamSize;
    private String reportingTo;
    
    // Constructor
    
    public Manager(String teamID, int teamSize, String reportingTo){
        this.teamID = teamID;
        this.teamSize = teamSize;
        this.reportingTo = reportingTo;
    }
    
    // Getters
    public String getTeamID(){
        return teamID;
    }
    
    public int getTeamSize(){
        return teamSize;
    }
    
    public String getReportingTo(){
        return reportingTo;
    }
 
    // Setters
    public void setTeamID(String teamID){
        this.teamID = teamID;
    }
    
    public void setTeamSize(int teamSize){
        this.teamSize = teamSize;
    }
    
    public void setReportingTo(String reportingTo){
        this.reportingTo = reportingTo;
    }
    
    // Empty Methods
    
    public void approveLeaveRequest(){}
    public void rejectLeaveRequest(){}
    public void viewTeamLeaveRequest(){}
    public void approveOvertimeRequests(){}
    public void rejectOvertimeRequests(){}
    public void assignTasks(){}
    public void viewTeamPerformance(){}
    
}
