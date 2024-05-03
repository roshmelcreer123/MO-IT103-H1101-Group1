package Classes;
import java.util.Date;

/**
 * @author Oliver
 * Last Updated: May 05, 2024 | 16:45
 */

public class Task {
       
    // Task Attributes
    
    private int taskId;
    private String title;
    private String description;
    private String status;
    private String assignedTo;
    private Date dueDate;
    
    //  Task Constructors

    public Task(int taskId, String title, String description, String status, String assignedTo, Date dueDate) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
    }
    
    //  Task Getters
    
    public int getTaskId(){
        return taskId;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getStatus(){
        return status;
    }
    
    public String getAssignedTo(){
        return assignedTo;
    }
    
    public Date getDueDate(){
        return dueDate;
    }
    
    //  Task Setters
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setAssignedTo(String assignedTo){
        this.assignedTo = assignedTo;
    }
    
    public void setDate(Date dueDate){
        this.dueDate = dueDate;
    }
    
}
