package com.prog1.week9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CsvReader {
    public static void main(String[] args) {

        String path = "C:/users/david/eclipse-workspace/mo_it_101/src/com/prog1/week9/";        
        try {
            File csvFile = new File(path + "data.csv");
            Scanner scanner = new Scanner(csvFile);

            /* If the delimiter in the CSV file is not a comma (e.g., semicolon or tab), you can specify it using 
            the split() method or the useDelimiter() method in Scanner. For example (semicolon as delimiter): 

                scanner.useDelimeter(";");  // set semicolon as the delimeter     
            
            Performance Considerations:
            Scanner vs BufferedReader: The Scanner class is user-friendly but not as fast as BufferedReader for large files.
            For large CSV files, consider using BufferedReader for improved performance. */

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // Read the entire line
                String[] values = line.split(","); // Split line into field
                
                /* If the CSV file contains mixed data types (e.g., numbers, strings), parse fields accordingly.
                 * For example, you can convert strings to integers or doubles as needed.
                 * 
                 *      int    intValue    = Integer.parseInt   (values[0]); // Parsing an integer
                 *      double doubleValue = Double .parseDouble(values[1]); // Parsing a double
                 *      String stringValue = values[2]; // String remains unchanged  */

                // Process the values (e.g., print them)
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println(); // Move to the next line
            }

            scanner.close(); // Close the scanner to release resources
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
