package Classes;
/**
 *
 * @author Oliver
 * Last Updated: May 05, 2024
 */
public class Deduction {
    
    //  Deduction Attributes
    
    private double philhealthLowerSalaryCap;
    private double upperSalaryCap;
    private double philhealthMinimumPremium;
    private double philhealthMaximumPremium;
    private double pagibigLowerRate;
    private double pagibigUpperRate;
    private double pagibigLowerSalaryCap;
    private double pagibigMaximumContribution;
    private double taxBrackets;
    private double taxBase;
    private double taxRates;
    
    
    //  Deduction Constructors
    
    public Deduction(double philhealthLowerSalaryCap, double upperSalaryCap, double philhealthMinimumPremium, double philhealthMaximumPremium, double pagibigLowerRate, double pagibigUpperRate, double pagibigLowerSalaryCap, double pagibigMaximumContribution, double taxBrackets, double taxBase, double taxRates) {
        this.philhealthLowerSalaryCap = philhealthLowerSalaryCap;
        this.upperSalaryCap = upperSalaryCap;
        this.philhealthMinimumPremium = philhealthMinimumPremium;
        this.philhealthMaximumPremium = philhealthMaximumPremium;
        this.pagibigLowerRate = pagibigLowerRate;
        this.pagibigUpperRate = pagibigUpperRate;
        this.pagibigLowerSalaryCap = pagibigLowerSalaryCap;
        this.pagibigMaximumContribution = pagibigMaximumContribution;
        this.taxBrackets = taxBrackets;
        this.taxBase = taxBase;
        this.taxRates = taxRates;
    }
    
    //  Deduction Getters
    
    public double getPhilhealthLowerSalaryCap() {
        return philhealthLowerSalaryCap;
    }

    public double getUpperSalaryCap() {
        return upperSalaryCap;
    }

    public double getPhilhealthMinimumPremium() {
        return philhealthMinimumPremium;
    }

    public double getPhilhealthMaximumPremium() {
        return philhealthMaximumPremium;
    }

    public double getPagibigLowerRate() {
        return pagibigLowerRate;
    }

    public double getPagibigUpperRate() {
        return pagibigUpperRate;
    }

    public double getPagibigLowerSalaryCap() {
        return pagibigLowerSalaryCap;
    }

    public double getPagibigMaximumContribution() {
        return pagibigMaximumContribution;
    }

    public double getTaxBrackets() {
        return taxBrackets;
    }

    public double getTaxBase() {
        return taxBase;
    }

    public double getTaxRates() {
        return taxRates;
    }
    
    
    // Deduction Setters
    
    public void setPhilhealthLowerSalaryCap(double philhealthLowerSalaryCap) {
        this.philhealthLowerSalaryCap = philhealthLowerSalaryCap;
    }

    public void setUpperSalaryCap(double upperSalaryCap) {
        this.upperSalaryCap = upperSalaryCap;
    }

    public void setPhilhealthMinimumPremium(double philhealthMinimumPremium) {
        this.philhealthMinimumPremium = philhealthMinimumPremium;
    }

    public void setPhilhealthMaximumPremium(double philhealthMaximumPremium) {
        this.philhealthMaximumPremium = philhealthMaximumPremium;
    }

    public void setPagibigLowerRate(double pagibigLowerRate) {
        this.pagibigLowerRate = pagibigLowerRate;
    }

    public void setPagibigUpperRate(double pagibigUpperRate) {
        this.pagibigUpperRate = pagibigUpperRate;
    }

    public void setPagibigLowerSalaryCap(double pagibigLowerSalaryCap) {
        this.pagibigLowerSalaryCap = pagibigLowerSalaryCap;
    }

    public void setPagibigMaximumContribution(double pagibigMaximumContribution) {
        this.pagibigMaximumContribution = pagibigMaximumContribution;
    }

    public void setTaxBrackets(double taxBrackets) {
        this.taxBrackets = taxBrackets;
    }

    public void setTaxBase(double taxBase) {
        this.taxBase = taxBase;
    }

    public void setTaxRates(double taxRates) {
        this.taxRates = taxRates;
    }
    
              
}
