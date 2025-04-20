package com.prog1.week9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/* 
Regular Expression for Splitting Fields: 

The regex ,(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$) ensures splitting occurs only on commas outside of quoted values. 
It uses lookahead assertions to identify valid split points.

Handling Quotes: After splitting the line into fields, the replaceAll("^\"|\"$", "") method removes 
leading and trailing double quotes from each value. 

Best Practices:

Use Libraries for Complex Files: For CSV files with intricate structures (e.g., quoted fields, multiline records), 
consider libraries like OpenCSV or Apache Commons CSV. They handle these edge cases automatically.

Validate Data: Check for malformed rows (e.g., unbalanced quotes) to avoid unexpected behavior.
*/
public class CsvScannerExample {
    public static void main(String[] args) {
        try {
            File csvFile = new File("data.csv");
            Scanner scanner = new Scanner(csvFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // Read the line

                // Regular expression to split fields while preserving quoted values
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                for (String value : values) {
                    // Remove the surrounding quotes, if present
                    value = value.replaceAll("^\"|\"$", "");
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
