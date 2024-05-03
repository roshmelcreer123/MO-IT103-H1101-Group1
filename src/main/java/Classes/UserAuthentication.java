package Classes;
import java.util.Date;

/**
*
* @author Mae
*/
public class UserAuthentication {

    // User Authentication Attributes
    
    private String email;
    private String userID;
    private String password; // It's common to keep the password attribute private to enforce encapsulation
    private String loginStatus;
    private Date registerDate;
    private String userRole;
    
    // User Authentication Constructor
    
    public UserAuthentication(String email, String userID, String password,
                              String loginStatus, Date registerDate, String userRole) {
        
        this.email = email;
        this.userID = userID;
        this.password = password;
        this.loginStatus = loginStatus;
        this.registerDate = registerDate;
        this.userRole = userRole;
    
    }
    
    // User Authentication Getters
    
    public String getEmail() {
        return email;
    }
    
    public String getUserID() {
        return userID;
    }
    
    public String getLoginStatus() {
        return loginStatus;
    }
    
    public Date getRegisterDate() {
        return registerDate;
    }
    
    public String getUserRole() {
        return userRole;
    }
    
    // User Authentication Setters
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
    
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
   
    // User Authentication Empty Methods
    
    public void createUser() {} 
    public void readUser() {} 
    public void updateUser() {}
    public void deleteUser() {}
    public void loginUser() {}
    public void changePassword() {}
    public void resetPassword() {}
    public void verifyEmail() {}
    public void generateUsername() {}  
    public void checkAvailability() {}
    public void retrieveForgottenUsername() {} 
    public void printUserRole() {}
    public void updateProfile() {}
    public void logInAsEmployee() {}
    public void logInAsAdmin(){}
    public void logout() {}

    // Additional class needed for return type 'User' (not provided)
    // Here are placeholder classes to avoid compilation errors

class User {
// User attributes and methods here
}
}
