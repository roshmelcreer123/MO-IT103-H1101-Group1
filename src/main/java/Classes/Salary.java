package Classes;
/**
 * @author Oliver
 * Last Updated: May 5, 2024 | 17:08
 */
public class Salary {
    
    // Salary Attributes
    
    private String employeeNumber;
    private double basicSalary;
    private double netSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;
    
    // Salary Constructors
    
    public Salary(String employeeNumber, double basicSalary, double netSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.basicSalary = basicSalary;
        this.netSalary = netSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }
    
    //  Salary Getters
    
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public double getGrossSemiMonthlyRate() {
        return grossSemiMonthlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
    
    //  Salary Setters
    
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public void setRiceSubsidy(double riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
    }

    public void setPhoneAllowance(double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public void setClothingAllowance(double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    public void setGrossSemiMonthlyRate(double grossSemiMonthlyRate) {
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    // Empty Methods based on Diagram
    
    public void createDeductions(){}
    public void updateDeductions(){}
    public void readDeductions(){}
    public void deleteDeductions(){}
    public void calculatePhilhealthDeduction(){}
    public void calculatePagibigContribution(){}
    public void calculateTotalDeductions(){}
    public void readPhilhealthRates(){}
    public void readPagibigRates(){}
    public void readTaxBrackets(){}
    
}
