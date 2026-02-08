package com.payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtility {

    // Database connection method
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load MySQL driver (optional for JDBC 8+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/payroll_db", // database URL
                    "root",                                   // DB username
                    "1234");                              // DB password

            System.out.println("✅ Connected to database successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
        return conn;
    }

    // Method to insert employee details into the database
    public static void insertEmployee(int id, String name, double basic, double hra, double da, double total) {
        String sql = "INSERT INTO employee_payroll(emp_id, emp_name, basic_salary, hra, da, total_salary) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, basic);
            ps.setDouble(4, hra);
            ps.setDouble(5, da);
            ps.setDouble(6, total);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Employee saved to database successfully!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error saving employee to database!");
            e.printStackTrace();
        }
    }

    // Method to fetch employee salary by ID
    public static void fetchEmployeeById(int id) {
        String sql = "SELECT * FROM employee_payroll WHERE emp_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("\n--- Employee Salary Details (DB) ---");
                System.out.println("ID: " + rs.getInt("emp_id"));
                System.out.println("Name: " + rs.getString("emp_name"));
                System.out.println("Basic Salary: " + rs.getDouble("basic_salary"));
                System.out.println("HRA: " + rs.getDouble("hra"));
                System.out.println("DA: " + rs.getDouble("da"));
                System.out.println("Total Salary: " + rs.getDouble("total_salary"));
            } else {
                System.out.println("Employee not found in database!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching employee from database!");
            e.printStackTrace();
        }
    }

    // Optional: main method to test connection
    public static void main(String[] args) {
        getConnection();
    }
}
