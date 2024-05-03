package Classes;

/**
*
* @author Mae
*/
public class Admin {

	// Admin Attributes
	private String adminName;
	private String adminID;
	private boolean isAdmin;

	// Admin Constructor
	public Admin(String adminName, String adminID, boolean isAdmin) {
	this.adminName = adminName;
	this.adminID = adminID;
	this.isAdmin = isAdmin;
	}

	// Admin Getters
	public String getAdminName() {
	return adminName;
	}

	public String getAdminID() {
	return adminID;
	}

	public boolean isAdmin() {
	return isAdmin;
	}

	// Admin Setters
	public void setAdminName(String adminName) {
	this.adminName = adminName;
	}

	public void setAdminID(String adminID) {
	this.adminID = adminID;
	}

	public void setAdmin(boolean isAdmin) {
	this.isAdmin = isAdmin;
	}

	// Admin Empty Methods
	public void updateUser() {}
	public void deleteUser() {}
	public void updateDeduction() {}
	public void createDeduction() {}
	public void deleteDeduction() {}
	public void updateAttendanceRecord() {}
	public void deleteAttendanceRecord() {}
	public void createAttendanceRecord() {}
	public void updateNetSalary() {}
	public void updateGrossSalary() {}
	public void createUser() {}
	public void readUser() {}
	public void createEmployee() {}
	public void readEmployee() {}
	public void deleteEmployee() {}
	public void updateEmployee() {}

	// Additional classes needed for return types 'User' and 'Employee' (not provided)
	// Here are placeholder classes to avoid compilation errors

	class User {
	// User attributes and methods here
	}

	class Employee {
	// Employee attributes and methods here
	}
	
}
