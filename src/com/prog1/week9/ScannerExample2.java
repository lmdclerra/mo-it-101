package com.prog1.week9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerExample2 {
    public static void main(String[] args) {

        String path = "C:/users/david/eclipse-workspace/mo_it_101/src/com/prog1/week9/";

        try {
            /* The Scanner class can read files by wrapping a File object as its input source. This allows you 
            to parse and process the file's content line by line, word by word, or token by token. */
            File file = new File(path + "data.txt");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(","); // Set a custom delimiter (comma in this case)

            /**********************************************************************************************************
            Different Methods for File Input:
            
            The Scanner class offers a variety of methods for reading different types of data:            
            * Line-Based Reading:
                - hasNextLine(): Checks if there is another line of input.
                - nextLine(): Reads the next line as a String.

            * Token-Based Reading:
                - hasNext(): Checks if there is another token.
                - next(): Reads the next token as a String.
            
            * Reading Primitive Data:
                - nextInt(), nextDouble(), nextLong(), etc.: Parse the next token as a specific type of primitive data.
                - hasNextInt(), hasNextDouble(), etc.: Check if the next token can be parsed into the specific type. 

            The Scanner class allows you to specify custom delimiters for reading tokens and process a variety of data types.
            
            Custom Delimiters:
                Use the useDelimiter() method to define a custom delimiter pattern.
            
            Parsing Mixed Data:
                You can combine methods to handle files with mixed data types, ensuring you correctly process strings, 
                numbers, or other formats.
            **********************************************************************************************************/
            while (scanner.hasNext()) {
                String token = scanner.next();
                System.out.println("Token: " + token);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
