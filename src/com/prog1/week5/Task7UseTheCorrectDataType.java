package com.prog1.week5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/*
Task 7: Use the Correct Data Type

1.  If you haven’t, create your MotorPH Netbeans project.
2.  Create the applicable method according to this week’s required task in your project plan. 
3.  Use the variables and data types you identified with your team on week 4.
4.  Write code that:
    4.1 captures static data from Motor PH’s employee database. Use available information as test data.
    4.2 displays employee information in the Netbeans console using println once run. 
        If you need a refresher on how to do this, review the references in the Java Variables section.
    4.3 displays employee information based on the design in your team’s wireframes.
5.  Add comments, as necessary
*/
public class Task7UseTheCorrectDataType {

    // Static data to simulate employee records from the database
    private static Employee[] employees = {

            new Employee(10001, "Garcia", "Manuel III", LocalDate.of(1983, 10, 11),
                    "Valero Carpark Building Valero Street 1227, Makati City", "966-860-270",
                    "44-4506057-3", "820126853951", "442-605-657-000", "691295330870",
                    "Regular", "Chief Executive Officer", "N/A", 90000.00, 1500.00, 2000.00,
                    1000.00, 45000.00, 535.71),

            new Employee(10002, "Lim", "Antonio", LocalDate.of(1988, 6, 19),
                    "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite", "171-867-411",
                    "52-2061274-9", "331735646338", "683-102-776-000", "663904995411",
                    "Regular", "Chief Operating Officer", "Garcia, Manuel III", 60000.00,
                    1500.00, 2000.00, 1000.00, 30000.00, 357.14),

            new Employee(10003, "Aquino", "Bianca Sofia", LocalDate.parse("08/04/1989", 
                    DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                    "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City", "966-889-370",
                    "30-8870406-2", "177451189665", "971-711-280-000", "171519773969",
                    "Regular", "Chief Finance Officer", "Garcia, Manuel III", 60000.00,
                    1500.00, 2000.00, 1000.00, 30000.00, 357.14),

            // Additional employees can be added here as needed
    };

    // Main method to execute the program
    public static void main(String[] args) {
        displayEmployeeInformation();
    }

    // Method to display employee information
    private static void displayEmployeeInformation() {
        // Employee.printHeading();            
        // Arrays.stream(employees).forEach(emp -> {System.out.println(emp.printData());});
        System.out.println("Motor PH Employee Database");
        Arrays.stream(employees).forEach(System.out::println);
    }
}
