package com.prog1.week9;

import java.io.File;
import java.io.IOException;
// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;
// import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Task 10: Read Input from a Text File
 * 
 * Go through the following links to review additional references to help you 
 * better understand the concept of file handling in Java:
 * 
 * 1.   Use a text file as your input for an employee's name and gross wage.
 * 
 * 2.   Determine the specific input that needs to be included in the text file 
 *      based on your existing code structure.
 * 
 * 3.   Update your code to save the contents of the text file in appropriate variables.
 * 
 * 4.   Calculate the net wage using the existing methods you have created.
 * 
 * 5.   Add comments as necessary, especially in defining the fields that should be present in 
 *      the text file to be read. Practice unit testing. */
public class Task10ReadInputFromTextFile {

    static Map<Integer, Double> employeeSalaries;

    public static void main(String[] args) {
    
        File csvFile = new File("./resources/EmployeeDetails.csv"); // specify the path to your text file
        boolean header = true; // flag to skip the header line
        employeeSalaries = new HashMap<>();

        try (Scanner scanner = new Scanner(csvFile)) {

            while (scanner.hasNextLine()) {
                
                String line = scanner.nextLine();   // read each line from the file
                // split by comma, but ignore commas inside quotes
                String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); 
                
                if (header == true) {
                    header = false; // Skip the header line
                    continue;
                }

                // remove the surrounding quotes, if present
                for (int i = 0; i < columns.length; ++i) {
                    columns[i] = columns[i].replaceAll("^\"|\"$", "").trim();
                }                

                int employeeNum = Integer.parseInt(columns[0]); // employee ID
                String fullName = columns[2] + " " + columns[1]; // employee's full name
                double grossWage = Double.parseDouble(columns[13].replace(",","")); // employee's basic salary
                employeeSalaries.put(employeeNum, grossWage); // store the employee's net wage in a map or list
                /* double netWage = calculateNetWage(grossWage); // placeholder for actual calculation method
                System.out.printf("Employee %5d: %-21s Net Wage: P%,.2f%n", employeeNum, fullName, netWage);*/
            }

            applyGovernmentDeductions();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static double calculateNetWage(double grossWage) {
        // implement your net wage calculation logic here
        // grossWage minus deductions, taxes, etc.        
        return grossWage; // placeholder for actual net wage calculation logic
    }

    // apply deductions for each (e.i., 3) employee with 7 days of attendance
    private static void applyGovernmentDeductions() {
        double sssDeduction         = 0.0; // total SSS deduction
        double philHealthDeduction  = 0.0; // total PhilHealth deduction
        double pagIbigDeduction     = 0.0; // total Pag-IBIG deduction
        double withholdingTax       = 0.0; // total tax deduction
        double totalDeduction       = 0.0; // total tax deduction
        
        // iterate through the employeeSalaries map to calculate deductions for each employee
        System.out.printf("| Employee ID | %-10s | %-10s | %-10s | %-10s |%n", "SSS", "PhilHealth", "Pag-IBIG", "Tax");        
        System.out.println("+-------------+--------- Government Deductions ------+------------+");
        for (Entry<Integer, Double> employee : employeeSalaries.entrySet()) {
            int employeeNumber    = employee.getKey(); // get the employee number
            double basicSalary    = employee.getValue(); // get the salary of the employee
            sssDeduction          = calculateSssDeduction(basicSalary); // done here
            philHealthDeduction   = calculatePhilHealthDeduction(basicSalary); 
            pagIbigDeduction      = calculatePagIbigDeduction(basicSalary); 
            withholdingTax        = calculateWitholdingTaxDeduction(basicSalary);
            System.out.printf("| %11d | %,10.2f | %,10.2f | %,10.2f | %,10.2f | --> ",             
            employeeNumber  , sssDeduction , philHealthDeduction , pagIbigDeduction , withholdingTax);
            
            double deductions = sssDeduction + philHealthDeduction + pagIbigDeduction + withholdingTax;
            double netWage = basicSalary -  deductions; // update gross wage
            
            System.out.printf("| %11d | gross: %,10.2f - deductions: %,10.2f | NetWage: %,10.2f%n", 
                employeeNumber  , basicSalary, deductions, netWage);
                
            totalDeduction += sssDeduction + philHealthDeduction + pagIbigDeduction + withholdingTax;
        }
                
        System.out.printf("Total Government Deductions: %,.2f%n", totalDeduction);        
    }

    // basic salary as monthly rate
    private static double calculateWitholdingTaxDeduction(double monthlyRate) {
        double tax = 0.0; 
               if (monthlyRate <= 20_832) { tax = /* .......... No withholding tax ......... */ 0.00; 
        } else if (monthlyRate <  33_333) { tax =              (monthlyRate -  20_833) * 0.20; //                 20% in excess of  20,833
        } else if (monthlyRate <  66_667) { tax =   2_500.00 + (monthlyRate -  33_333) * 0.25; //   2,500.00 plus 25% in excess of  33,333
        } else if (monthlyRate < 166_667) { tax =  10_833.00 + (monthlyRate -  66_667) * 0.30; //  10,833.00 plus 30% in excess of  66,667
        } else if (monthlyRate < 666_667) { tax =  40_833.33 + (monthlyRate - 166_667) * 0.32; //  40,833.33 plus 32% in excess of 166,667
        } else /* (666,667 and above...*/ { tax = 200_833.33 + (monthlyRate - 666_667) * 0.35; // 200,833.33 plus 35% in excess of 666,667
        }
        return tax; // return the calculated tax
    }

    private static double calculatePagIbigDeduction(double monthlyBasicSalary) {
        final double maxContribution = 100.0; // pag-ibig contribution        
        double minSalary = 1000; // minimum salary for Pag-ibig contribution
        double maxSalary = 1500; // maximum salary for Pag-ibig contribution
        double contributionAmount = 0.0; // contribution amount

        // tes if the monthly basic salary is within the range of minimum and maximum salary
        if (monthlyBasicSalary >= minSalary && monthlyBasicSalary <= maxSalary) {
            contributionAmount = monthlyBasicSalary * (0.01 + 0.02); // employee and employer contribution            
        } else {
            contributionAmount = monthlyBasicSalary * (0.02 + 0.02); // employee and employer contribution            
        }        

        // contribution amount is at most 100.00
        return contributionAmount > maxContribution ? 100.0 : contributionAmount; 
    }

    private static double calculatePhilHealthDeduction(double monthlyBasicSalary) {
        double premiumRate = 0.03; // 3% of the basic salary
        double minSalary = 10000; // minimum salary for PhilHealth contribution
        double maxSalary = 60000; // maximum salary for PhilHealth contribution
        double monthlyPremium = 0.0; // monthly premium contribution        

        if (monthlyBasicSalary <= minSalary) {
            // 10,000.00 and below
            monthlyPremium = minSalary * premiumRate; // minimum contribution
        } 
        else 
        if (monthlyBasicSalary >= maxSalary) {
            // 60,000.00 and above
            monthlyPremium = maxSalary * premiumRate; // maximum contribution
        } 
        else {            
            // 10,000.01 to 59,999.99
            monthlyPremium = monthlyBasicSalary * premiumRate; // regular contribution
        }

        return monthlyPremium * 0.50; // contribution equally shared by employer and employee
    }

    // synonymous of compensation are remuneration, salary, wages, pay, and earnings
    private static double calculateSssDeduction(double monthlyBasicSalary) {
        // define a 2D array for compensation ranges and contributions
        double[][] compensationContributionTable = {
            {3250, 135.00},
            {3750, 157.50},
            {4250, 180.00},
            {4750, 202.50},
            {5250, 225.00},
            {5750, 247.50},
            {6250, 270.00},
            {6750, 292.50},
            {7250, 315.00},
            {7750, 337.50},
            {8250, 360.00},
            {8750, 382.50},
            {9250, 405.00},
            {9750, 427.50},
            {10250, 450.00},
            {10750, 472.50},
            {11250, 495.00},
            {11750, 517.50},
            {12250, 540.00},
            {12750, 562.50},
            {13250, 585.00},
            {13750, 607.50},
            {14250, 630.00},
            {14750, 652.50},
            {15250, 675.00},
            {15750, 697.50},
            {16250, 720.00},
            {16750, 742.50},
            {17250, 765.00},
            {17750, 787.50},
            {18250, 810.00},
            {18750, 832.50},
            {19250, 855.00},
            {19750, 877.50},
            {20250, 900.00},
            {20750, 922.50},
            {21250, 945.00},
            {21750, 967.50},
            {22250, 990.00},
            {22750, 1012.50},
            {23250, 1035.00},
            {23750, 1057.50},
            {24250, 1080.00},
            {24750, 1102.50}            
        };

        // iterate through the 2D array to find the corresponding contribution
        for (double[] range : compensationContributionTable) {
            double compensationUpperLimit = range[0]; // compensation upper limit
            double sssContribution = range[1]; // contribution for the range of salary
            if (monthlyBasicSalary <= compensationUpperLimit) {
                return sssContribution; // return the contribution for the range
            }
        }
        
        return 1125.00; // default contribution for compensation above the highest range
    }

    /*
    private static void processingAttendanceLogs() {
        
        // split the attendance data into rows
        String[] rowsOfData = attendanceData.split("\r\n");
        double[] totalHoursWorkedById = new double[rowsOfData.length]; // Array to store total hours worked for each employee

        for (int i = 0; i < totalHoursWorkedById.length; i++) {
            totalHoursWorkedById[i] = 0; // Initialize each employee's total hours worked to 0
        }

        // Process each row of attendance data
        for (String row : rowsOfData) {
            String[]    columns         = row.split(","); // split the rows into columns
        
            // Check if the row has the correct number of columns
            if (columns.length != 6) {
                System.out.println("Invalid data format: " + row);
                continue; // skip invalid rows
            }

            String strLogIn  = String.format("%02d:%02d", Integer.parseInt(columns[4].split(":")[0]), Integer.parseInt(columns[4].split(":")[1]));
            String strLogOut = String.format("%02d:%02d", Integer.parseInt(columns[5].split(":")[0]), Integer.parseInt(columns[5].split(":")[1]));

            int         employeeNumber  = Integer.parseInt(columns[0]);
            String      lastName        = columns[1];
            String      firstName       = columns[2];
            LocalDate   date            = LocalDate.parse(columns[3], DateTimeFormatter.ofPattern("MM/dd/yyyy"));            
            LocalTime   logInTime       = LocalTime.parse(strLogIn);
            LocalTime   logOutTime      = LocalTime.parse(strLogOut);
            
            // Create an Attendance object and calculate hours worked
            Attendance attendance = new Attendance(employeeNumber, lastName, firstName, date, logInTime, logOutTime);
            double hoursWorked = attendance.calculateHoursWorked();

            // Display the calculated hours worked
            System.out.printf("Employee [%-12s %-12s] worked %5.2f hours on %s%n", 
                firstName, lastName, hoursWorked, date.format(DateTimeFormatter.ofPattern("MMMM/dd/yyyy"))
            );

            int empIdx = attendance.getEmployeeNumber() - 10001; // Calculate the index for the employee in the array
            totalHoursWorkedById[empIdx] += hoursWorked; // accumulate the total hours worked for each employee
        }                
        
        // Display the total hours worked by each employee over the week
        for (int i = 0; i < totalHoursWorkedById.length; i++) {
            if (totalHoursWorkedById[i] == 0) continue; // Skip if no hours worked
            System.out.printf("Total hours worked by %s in 7 days: %.2f hours%n",
                (i + 10001), totalHoursWorkedById[i]);
        }
    }

    private static void calculateSalaryBasedOnHoursWorked() {
        
        // Split the attendance data into rows
        String[] rowsOfData = attendanceData.split("\r\n");
        double[] totalHoursWorkedById = new double[rowsOfData.length]; // Array to store total hours worked for each employee

        for (int i = 0; i < totalHoursWorkedById.length; i++) {
            totalHoursWorkedById[i] = 0; // Initialize each employee's total hours worked to 0
        }

        // Process each row of attendance data
        for (String row : rowsOfData) {
            String[]    columns         = row.split(","); // split the rows into columns
        
            // Check if the row has the correct number of columns
            if (columns.length != 6) {
                System.out.println("Invalid data format: " + row);
                continue; // skip invalid rows
            }

            String strLogIn  = String.format("%02d:%02d", Integer.parseInt(columns[4].split(":")[0]), Integer.parseInt(columns[4].split(":")[1]));
            String strLogOut = String.format("%02d:%02d", Integer.parseInt(columns[5].split(":")[0]), Integer.parseInt(columns[5].split(":")[1]));

            int         employeeNumber  = Integer.parseInt(columns[0]);
            String      lastName        = columns[1];
            String      firstName       = columns[2];
            LocalDate   date            = LocalDate.parse(columns[3], DateTimeFormatter.ofPattern("MM/dd/yyyy"));            
            LocalTime   logInTime       = LocalTime.parse(strLogIn);
            LocalTime   logOutTime      = LocalTime.parse(strLogOut);
            
            // Create an Attendance object and calculate hours worked
            Attendance attendance = new Attendance(employeeNumber, lastName, firstName, date, logInTime, logOutTime);
            double hoursWorked = attendance.calculateHoursWorked();

            // Display the calculated hours worked
            System.out.printf("Employee [%-12s %-12s] worked %5.2f hours on %s%n", 
                firstName, lastName, hoursWorked, date.format(DateTimeFormatter.ofPattern("MMMM/dd/yyyy"))
            );

            int empIdx = attendance.getEmployeeNumber() - 10001; // Calculate the index for the employee in the array
            totalHoursWorkedById[empIdx] += hoursWorked; // accumulate the total hours worked for each employee
        }                
        
        // Display the total hours worked by each employee over the week
        for (int i = 0; i < totalHoursWorkedById.length; i++) {
            if (totalHoursWorkedById[i] == 0) continue; // Skip if no hours worked
            System.out.printf("Total hours worked by %s in 7 days: %.2f hours%n",
                (i + 10001), totalHoursWorkedById[i]);
        }

        // Calculate and display the salary for each employee based on hours worked
        employeeSalaries = new HashMap<>(); // Initialize the map to store employee salaries
        Arrays.stream(employees).forEach(
            emp -> {
                int empIdx = emp.getEmployeeNumber() - 10001; // Calculate the index for the employee in the array
                double totalHoursWorked = Math.round(totalHoursWorkedById[empIdx] * 100.0) / 100.0; // Round to 2 decimal places
                double hourlyRate = emp.getHourlyRate();
                double oneWeekSalary =  totalHoursWorked * hourlyRate;
                System.out.printf("%d: One week salary of [%-12s %-6s] for %5.2f hours of worked x %.2f/hour: Php%,.2f%n", 
                    emp.getEmployeeNumber(), emp.getFirstName(), emp.getLastName(), totalHoursWorked, hourlyRate, oneWeekSalary
                );    
                // add to collection of employee salary for later's computation of government deductions
                employeeSalaries.put(emp.getEmployeeNumber(), oneWeekSalary); // Store the salary in the map                
            }
        );
    }

    // Method to display employee information
    private static void displayEmployeeInformation() {
        // Employee.printHeading();            
        // Arrays.stream(employees).forEach(emp -> {System.out.println(emp.printData());});
        System.out.println("Motor PH Employee Database");
        Arrays.stream(employees).forEach(System.out::println);
    }
    */
}
