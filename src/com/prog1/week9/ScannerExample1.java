package com.prog1.week9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerExample1 {
    public static void main(String[] args) {

        String path = "C:/users/david/eclipse-workspace/mo_it_101/src/com/prog1/week9/";

        try {
            /* The Scanner class can read files by wrapping a File object as its input source. This allows you 
            to parse and process the file's content line by line, word by word, or token by token. */
            File file = new File(path + "input.txt");
            Scanner scanner = new Scanner(file);

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
            **********************************************************************************************************/
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
