/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.util.Date;

/**
 *
 * @author User
 */
public class Employee {
    
    // Employee Attributes
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private Date birthday;
    private String address;
    private String phoneNumber;
    private String sssNumber;
    private String tinNumber;
    private String pagIbigNumber;
    private String status;
    private String position;
    private String immediateSupervisor;
    
    
    // Employee Constructor when dev needs to create the object
    public Employee(String employeeNumber, String lastName, String firstName, Date birthday, String address, String phoneNumber, 
                    String sssNumber, String tinNumber, String pagIbigNumber, String status, String position, String immediateSupervisor){
    
       this.employeeNumber = employeeNumber;
       this.lastName = lastName;
       this.firstName = firstName;
       this.birthday = birthday;
       this.address = address;
       this.phoneNumber = phoneNumber;
       this.sssNumber = sssNumber;
       this.tinNumber = tinNumber;
       this.pagIbigNumber = pagIbigNumber;
       this.status = status;
       this.position = position;
       this.immediateSupervisor = immediateSupervisor;
    
    }
    
    // Employee Getters
    
    public String getEmployeeNumber(){
        return employeeNumber;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public Date getBirthday(){
        return birthday;
    }
    
    public String getTinNumber(){
        return tinNumber;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public String getSSSNumber(){
        return sssNumber;
    }
    
    public String getPagIbigNumber(){
        return pagIbigNumber;
    }
      
    public String getStatus(){
        return status;
    }
    
    public String getPosition(){
        return position;
    }
    
    public String getImmediateSupervisor(){
        return immediateSupervisor;
    }
    
    
    // Employee Setters
    
    public void setEmployeeNumber(String employeeNumber){
        this.employeeNumber = employeeNumber;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
       
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setTinNumber(String tinNumber){
        this.tinNumber = tinNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public void setSSSNumber(String sssNumber){
        this.sssNumber = sssNumber;
    }
    
    public void setPagIbigNumber(String pagIbigNumber){
        this.pagIbigNumber = pagIbigNumber;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setPosition(String position){
        this.position = position;
    }
    
    public void setImmediateSupervisor(String immediateSupervisor){
        this.immediateSupervisor = immediateSupervisor;
    }
    
}
