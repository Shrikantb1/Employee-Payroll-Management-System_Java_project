package com.payroll;

public class PayrollService {

    // Calculate HRA (e.g., 20% of basic salary)
    public double calculateHRA(double basicSalary) {
        return basicSalary * 0.20;
    }

    // Calculate DA (e.g., 10% of basic salary)
    public double calculateDA(double basicSalary) {
        return basicSalary * 0.10;
    }

    // Calculate Total Salary
    public double calculateTotalSalary(double basicSalary) {
        double hra = calculateHRA(basicSalary);
        double da = calculateDA(basicSalary);
        return basicSalary + hra + da;
    }
}
