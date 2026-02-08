package com.payroll;

public class Employee {

    // Maximum employees (array size)
    public static final int MAX_EMPLOYEES = 100;

    // Arrays to store employee data temporarily
    public static int[] empIds = new int[MAX_EMPLOYEES];
    public static String[] empNames = new String[MAX_EMPLOYEES];
    public static double[] basicSalaries = new double[MAX_EMPLOYEES];
    public static double[] hras = new double[MAX_EMPLOYEES];
    public static double[] das = new double[MAX_EMPLOYEES];
    public static double[] totalSalaries = new double[MAX_EMPLOYEES];

    // Counter to track number of employees added
    public static int count = 0;
}
