package Classes;
import java.util.Date;
import java.sql.Time;

/**
 * Class for handling overtime requests.
 */
public class OvertimeRequest {

    // Attributes
    private String overtimeID;
    private String employeeNumber;
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
    private double hoursRequested;
    private String reason;
    private String status;
    private String approverID;

    // Constructor
    public OvertimeRequest(String overtimeID, String employeeNumber, Date startDate, Date endDate, Time startTime, Time endTime, double hoursRequested, String reason, String status, String approverID) {
        this.overtimeID = overtimeID;
        this.employeeNumber = employeeNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hoursRequested = hoursRequested;
        this.reason = reason;
        this.status = status;
        this.approverID = approverID;
    }

    // Getters
    public String getOvertimeID() { return overtimeID; }
    public String getEmployeeNumber() { return employeeNumber; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public Time getStartTime() { return startTime; }
    public Time getEndTime() { return endTime; }
    public double getHoursRequested() { return hoursRequested; }
    public String getReason() { return reason; }
    public String getStatus() { return status; }
    public String getApproverID() { return approverID; }

    // Setters
    public void setOvertimeID(String overtimeID) { this.overtimeID = overtimeID; }
    public void setEmployeeNumber(String employeeNumber) { this.employeeNumber = employeeNumber; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public void setStartTime(Time startTime) { this.startTime = startTime; }
    public void setEndTime(Time endTime) { this.endTime = endTime; }
    public void setHoursRequested(double hoursRequested) { this.hoursRequested = hoursRequested; }
    public void setReason(String reason) { this.reason = reason; }
    public void setStatus(String status) { this.status = status; }
    public void setApproverID(String approverID) { this.approverID = approverID; }

    // Business Methods
    public void createOvertimeRequest() {
        System.out.println("Creating overtime request for employee: " + employeeNumber);
    }

    public void cancelOvertimeRequest() {
        System.out.println("Cancelling overtime request with ID: " + overtimeID);
    }

    public void approveOvertimeRequest() {
        this.status = "Approved";
        System.out.println("Overtime request approved for employee: " + employeeNumber);
    }

    public void rejectOvertimeRequest() {
        this.status = "Rejected";
        System.out.println("Overtime request rejected for employee: " + employeeNumber);
    }

    public void updateOvertimeRequest(Time newStartTime, Time newEndTime, double newHoursRequested) {
        this.startTime = newStartTime;
        this.endTime = newEndTime;
        this.hoursRequested = newHoursRequested;
        System.out.println("Overtime request updated for employee: " + employeeNumber);
    }

    public void viewOvertimeHistory() {
        System.out.println("Viewing overtime history for employee: " + employeeNumber);
    }

    public void getOvertimeStatus() {
        System.out.println("Current status of overtime: " + status);
    }

    public void notifyEmployee() {
        System.out.println("Notifying employee: " + employeeNumber + " about overtime status: " + status);
    }
}
