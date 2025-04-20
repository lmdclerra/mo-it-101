package com.prog1.week9;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;

/**
 * The FileReader and FileWriter classes are essential for character-based file oepration in Java.
 * They simplify reading and writing tasks but require careful handling of exceptions to ensure
 * robust and error-free programs.
 */
public class FileReaderWriterDemo {
    
    public static void main(String[] args) {

        String path = "C:/users/david/eclipse-workspace/mo_it_101/src/com/prog1/week9/";
        
        // Creating Instances and Specifying Files
        try (FileReader reader = new FileReader(path + "input.txt");
             FileWriter writer = new FileWriter(path + "output.txt")) {

            // Read from the file and write to another file
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
        } catch (IOException e) {
            System.err.println("An error occurred: "+ e.getMessage());
        } finally {            
            System.out.println("File reading and writing completed.");
            /***************************************************************** 
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Error closing the file: " + e.getMessage());
                }
            } 
            *****************************************************************/
        }
        // Note: The try-with-resources statement automatically closes the resources (FileReader and FileWriter)        
    }
}
