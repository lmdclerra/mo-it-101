package com.prog1.week9;

import java.io.File;
import java.io.IOException;
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

    public static void main(String[] args) {
    
        File csvFile = new File("./resources/EmployeeDetails.csv"); // specify the path to your text file
        boolean header = true; // flag to skip the header line

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
                double netWage = calculateNetWage(grossWage); // placeholder for actual calculation method

                System.out.printf("Employee %5d: %-21s Net Wage: P%,.2f%n", employeeNum, fullName, netWage);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static double calculateNetWage(double grossWage) {
        // implement your net wage calculation logic here
        return grossWage; // placeholder for actual net wage calculation logic
    }
}
