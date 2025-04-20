package com.prog1.week9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The FileInputStream and FileOutputStream classes in Java, part of the java.io package, are designed for 
 * byte-oriented file I/O operations, primarily for reading and writing binary data. 
 * 
 * Here's an in-depth explanation: 
 * 
 * 1.   Purpose of FileInputStream and FileOutputStream:
 * 
 *      FileInputStream: Used to read raw byte data from a file. It is ideal for binary files like images, 
 *      audio files, or other non-text data.
 * 
 *      FileOutputStream: Used to write raw byte data to a file. It is suitable for creating or modifying binary files.
 * 
 * These classes operate on files at the byte level, making them distinct from character-based I/O classes 
 * like FileReader and FileWriter.
 */
public class FileInputStreamDemo {
    
    public static void main(String[] args) {
        
        // Specify the file path
        String path = "C:/users/david/eclipse-workspace/mo_it_101/src/com/prog1/week9/";
        
        // You can create an instance by passing the file name (as a String) or a File object to the constructor.
        try (FileInputStream fis = new FileInputStream(path + "input.dat");
            // FileOutputStream fos = new FileOutputStream(new File(path + "output.dat"));
            FileOutputStream fos = new FileOutputStream(path + "output.dat")) {
            int byteData;

            /* FileInputStream Methods:
            - int read(): Reads a single byte of data and returns it as an integer (returns -1 at the end of the stream).
            - int read(byte[] b): Reads multiple bytes into an array and returns the number of bytes read.
            - close(): Closes the stream and releases resources. */
            
            // Read bytes until the end of the file
            while ((byteData = fis.read()) != -1) {

                /* FileOutputStream Methods:
                - void write(int b): Writes a single byte to the file.
                - void write(byte[] b): Writes an array of bytes to the file.
                - close(): Closes the stream and releases resources. */

                // Write the byte to the output file                
                fos.write( byteData ); // copy content byte by byte
            }

            // Close the streams
            // fis.close();
            // fos.close();
            
            // The try-with-resources statement automatically closes the streams when done.
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
