package Classes;
import java.util.Date;

/**
 * Class for handling leave requests.
 */
public class LeaveRequest {
    
    // Attributes
    private String leaveID;
    private String employeeNumber;
    private Date startDate;
    private Date endDate;
    private String leaveType;
    private String leaveStatus;
    private String approvalDate;
    private String reason;
    private String approverID;

    // Constructor
    public LeaveRequest(String leaveID, String employeeNumber, Date startDate, Date endDate, String leaveType, String leaveStatus, String approvalDate, String reason, String approverID) {
        this.leaveID = leaveID;
        this.employeeNumber = employeeNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.leaveStatus = leaveStatus;
        this.approvalDate = approvalDate;
        this.reason = reason;
        this.approverID = approverID;
    }

    // Getters
    public String getLeaveID() { return leaveID; }
    public String getEmployeeNumber() { return employeeNumber; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public String getLeaveType() { return leaveType; }
    public String getLeaveStatus() { return leaveStatus; }
    public String getApprovalDate() { return approvalDate; }
    public String getReason() { return reason; }
    public String getApproverID() { return approverID; }

    // Setters
    public void setLeaveID(String leaveID) { this.leaveID = leaveID; }
    public void setEmployeeNumber(String employeeNumber) { this.employeeNumber = employeeNumber; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }
    public void setLeaveStatus(String leaveStatus) { this.leaveStatus = leaveStatus; }
    public void setApprovalDate(String approvalDate) { this.approvalDate = approvalDate; }
    public void setReason(String reason) { this.reason = reason; }
    public void setApproverID(String approverID) { this.approverID = approverID; }

    // Business Methods
    public void createLeaveRequest() {
        System.out.println("Creating leave request for employee: " + employeeNumber);
    }

    public void cancelLeaveRequest() {
        System.out.println("Cancelling leave request with ID: " + leaveID);
    }

    public void approveLeaveRequest() {
        this.leaveStatus = "Approved";
        this.approvalDate = new Date().toString();  // Set the approval date to today
        System.out.println("Leave request approved for employee: " + employeeNumber);
    }

    public void rejectLeaveRequest() {
        this.leaveStatus = "Rejected";
        System.out.println("Leave request rejected for employee: " + employeeNumber);
    }

    public void updateLeaveRequest(Date newStartDate, Date newEndDate, String newReason) {
        this.startDate = newStartDate;
        this.endDate = newEndDate;
        this.reason = newReason;
        System.out.println("Leave request updated for employee: " + employeeNumber);
    }

    public void viewLeaveHistory() {
        System.out.println("Viewing leave history for employee: " + employeeNumber);
    }

    public void printLeaveStatus() {
        System.out.println("Current status of leave: " + leaveStatus);
    }

    public void notifyEmployee() {
        System.out.println("Notifying employee: " + employeeNumber + " about leave status: " + leaveStatus);
    }

    
}
