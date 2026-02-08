package com.payroll;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PayrollService payrollService = new PayrollService();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Employee Payroll Management System ===");
            System.out.println("1. Add Employee Payroll Details");
            System.out.println("2. View Employee Salary");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer
            } catch (Exception e) {
                System.out.println("❌ Please enter a valid number!");
                sc.nextLine(); // clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    addEmployee(sc, payrollService);
                    break;
                case 2:
                    viewEmployee(sc);
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }

    // ================= ADD EMPLOYEE =================
    private static void addEmployee(Scanner sc, PayrollService payrollService) {

        if (Employee.count >= Employee.MAX_EMPLOYEES) {
            System.out.println("❌ Employee limit reached!");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int id;
        try {
            id = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("❌ Invalid ID!");
            sc.nextLine();
            return;
        }

        if (isDuplicateId(id)) {
            System.out.println("❌ Employee ID already exists!");
            return;
        }

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        if (name.trim().isEmpty()) {
            System.out.println("❌ Employee name cannot be empty!");
            return;
        }

        System.out.print("Enter Basic Salary: ");
        double basic;
        try {
            basic = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("❌ Invalid salary input!");
            sc.nextLine();
            return;
        }

        if (basic <= 0) {
            System.out.println("❌ Basic salary must be greater than 0!");
            return;
        }

        // Calculate salary
        double hra = payrollService.calculateHRA(basic);
        double da = payrollService.calculateDA(basic);
        double total = payrollService.calculateTotalSalary(basic);

        // Store in arrays (temporary)
        int index = Employee.count;
        Employee.empIds[index] = id;
        Employee.empNames[index] = name;
        Employee.basicSalaries[index] = basic;
        Employee.hras[index] = hra;
        Employee.das[index] = da;
        Employee.totalSalaries[index] = total;
        Employee.count++;

        System.out.println("✅ Employee added in memory!");

        // Store in database
        DatabaseUtility.insertEmployee(id, name, basic, hra, da, total);
    }

    // ================= VIEW EMPLOYEE =================
    private static void viewEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to view: ");
        int id;
        try {
            id = sc.nextInt();
        } catch (Exception e) {
            System.out.println("❌ Invalid ID!");
            sc.nextLine();
            return;
        }

        DatabaseUtility.fetchEmployeeById(id);
    }

    // ================= DUPLICATE CHECK =================
    private static boolean isDuplicateId(int id) {
        for (int i = 0; i < Employee.count; i++) {
            if (Employee.empIds[i] == id) {
                return true;
            }
        }
        return false;
    }
}
