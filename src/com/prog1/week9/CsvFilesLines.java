package com.prog1.week9;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

/* 
Using Files.lines():

For modern Java applications, use Files.lines() with streams for reading and processing CSV files efficiently. 

Performance Considerations:
- Avoid Large Lines in Memory: If the file contains extremely long lines, 
  use streaming methods (Files.lines() or third-party libraries) for efficiency.  
- Library Overheads: Third-party libraries like OpenCSV and Apache Commons CSV (see example below) 
  may add dependencies, but they simplify complex parsing and improve maintainability.
- Buffered I/O: Use buffered streams like BufferedReader for large files to avoid performance bottlenecks.
*/
public class CsvFilesLines {
    public static void main(String[] args) {
        try {
            Files.lines(Path.of("data.csv"))
                 .map(line -> line.split(",")) // Split each line into fields
                 .forEach(values -> {
                     for (String value : values) {
                         System.out.print(value + " ");
                     }
                     System.out.println();
                 });
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/******************************************************************************

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenCSVExample {
    public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("data.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                for (String value : nextLine) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
 
******************************************************************************

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;

public class ApacheCSVExample {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("data.csv")) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(fileReader);
            for (CSVRecord record : records) {
                for (String value : record) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

******************************************************************************/