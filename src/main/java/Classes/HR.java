/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author martin
 */
public class HR {
    
    // HR Attributes
    private int teamSize;
    
    // Constructor
    public HR(int teamSize) {
        this.teamSize = teamSize;
    }
    
    // Getter
     public int getTeamSize() {
        return teamSize;
    }
    
    // Setter
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    
    // Empty methods
    public void approveLeaveRequest() {}
    public void rejectLeaveRequest() {}
    public void viewAllLeaveRequests() {}
    public void generateReports() {}
    public void conductPerformanceReview() {}
    
    
    
  
}
