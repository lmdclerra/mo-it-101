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
        
        try (BufferedReader br = new BufferedReader(
            new FileReader("C:\\Users\\Lerra\\Desktop\\MyCamu\\mo-it-101\\src\\com\\prog1\\week9\\data.csv"))
            ) {
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

/*
values[0] = "10001"
values[1] = "Garcia"
values[2] = "Manuel III"
values[3] = "06/03/2024"
values[4] = "8:59"  
values[5] = "18:31"
*/