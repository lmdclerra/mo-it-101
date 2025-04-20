package com.prog1.week9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* 
Using BufferedReader:

A faster alternative to Scanner, particularly for large files. You can read line by line and 
split the data using String.split() or a library like Apache Commons CSV 
*/
public class CsvBufferedReader {
    public static void main(String[] args) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Split the line into fields
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
