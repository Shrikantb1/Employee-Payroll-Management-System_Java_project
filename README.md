# Employee-Payroll-Management-System_Java_project
Console-based Employee Payroll Management System using Core Java, JDBC, and MySQL

# Employee Payroll Management System

A console-based Employee Payroll Management System developed using Core Java and JDBC.
The application allows users to add employee payroll details, calculate salary components,
store data in a database, and retrieve employee salary information.

---

## Technologies Used
- Core Java (JDK 21)
- JDBC
- MySQL Database
- Console-Based Application
- IntelliJ IDEA

---

## Core Java Concepts Used
- Arrays (temporary data storage)
- Loops (menu handling and data processing)
- Methods (salary calculation and validation)
- Conditional Statements
- Exception Handling
- Scanner Class
- JDBC Connectivity

---

## Database Details
- Database: MySQL
- Table Name: `employee_payroll`

### Table Structure
| Column Name     | Description |
|-----------------|-------------|
| emp_id          | Employee ID |
| emp_name        | Employee Name |
| basic_salary    | Basic Salary |
| hra             | House Rent Allowance |
| da              | Dearness Allowance |
| total_salary    | Total Salary |

---
## Project Structure
src/
└── com/payroll/
├── MainApp.java
├── Employee.java
├── PayrollService.java
└── DatabaseUtility.java

## Project Flow
1. Application starts and displays menu options.
2. User enters employee ID, name, and basic salary.
3. HRA and DA are calculated using separate methods.
4. Employee data is stored temporarily in arrays.
5. Payroll data is saved permanently in the database using JDBC.
6. User can retrieve employee salary details using employee ID.
7. The application continues running until the user chooses to exit.

---

## Functional Requirements Implemented
- Add employee payroll details
- Salary calculation using separate methods
- Temporary storage using arrays
- Permanent storage using JDBC and MySQL
- Retrieve employee salary using employee ID
- Input validation and exception handling
- Continuous execution until exit

  ## Conclusion
This project provides practical exposure to Core Java programming with JDBC connectivity.
It enhances understanding of arrays, loops, methods, and database operations.
The application demonstrates how Java logic and database systems work together in
real-time applications using JDK 21.
