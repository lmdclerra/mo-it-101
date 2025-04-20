package com.prog1.week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The BufferedReader and BufferedWriter classes, part of the java.io package, add a buffering layer to 
 * FileReader and FileWriter. This buffering significantly improves efficiency during file operations by 
 * minimizing the number of read/write calls to the underlying file system.
 * 
 * Advantages of BufferedReader and BufferedWriter:
 * 
 * - Improved Performance: 
 *      Instead of reading/writing a single character at a time (as in FileReader and FileWriter), 
 *      these classes use an internal buffer to handle data in chunks, reducing system overhead.
 * 
 * - Additional Methods for Convenience: 
 *      They offer powerful utility methods (e.g., readLine() in BufferedReader) for handling files more effectively.
 * 
 * - More Suitable for Large Files: 
 *      They are better suited for processing large files as fewer I/O operations occur, leading to better performance.
 * 
 * Using BufferedReader and BufferedWriter allows for more efficient and convenient file operations, especially for 
 * larger files or when processing line-by-line. With the addition of buffering and utility methods, 
 * these classes streamline file handling in Java programs.
 */
public class BufferedReaderWriterDemo {

    public static void main(String[] args) {

        String path = "C:/users/david/eclipse-workspace/mo_it_101/src/com/prog1/week9/";
        // you can wrap a FileReader and FileWriter with BufferedReader and BufferedWriter respectively
        // to take advantage of the buffering capabilities. The same constructors for FileReader and 
        // FileWriter (e.g., specifying file name or File object) are used within buffered counterparts.                 
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "input.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "output.txt"))) {
            String line;
            /* 
            Methods in BufferedReader:
            -   read(): Reads a single character (same as FileReader but buffered).
            -   readLine(): Reads an entire line of text, returning it as a String, or null at the end of the file. 
            Methods in BufferedWriter:
            -   write(String s): Writes a string to the file.
            -   newLine(): Writes a platform-specific line separator (e.g., \n or \r\n).
            -   flush(): Ensures all data is written to the file before closing. 
            */
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
