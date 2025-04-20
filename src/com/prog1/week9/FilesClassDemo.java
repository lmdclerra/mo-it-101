package com.prog1.week9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * The Files class in Java, part of the java.nio.file package, provides a rich set of static methods for 
 * performing file and directory operations in a modern, efficient, and flexible way. It works closely with 
 * the Path class, which represents file and directory paths. Here's a breakdown:
 * 
 * 1.   Purpose of the Files Class:
 * 
 *      The Files class is designed to:
 * 
 *      - Simplify file I/O operations: 
 *          Read, write, copy, move, and delete files and directories easily.
 * 
 *      - Enhance file manipulation: 
 *          Work with file attributes, check file existence, and manage directories.
 * 
 *      - Enable directory traversal: 
 *          Traverse files and directories with utility methods and streams.
 */
public class FilesClassDemo {
    
    public static void main(String[] args) {

        String path = "C:/users/david/eclipse-workspace/mo_it_101/src/com/prog1/week9/";
        
        // Using the Files class for Reading or Writing files:        
        Path inputPath = Paths.get(path + "input.txt");
        try {
            // Reading a File: The Files.readAllLines() method reads all lines of a file into a List<String>.
            List<String> lines = Files.readAllLines(inputPath); 
            lines.forEach(System.out::println); // Print each line to the console

            // Alternatively, Files.readString() reads the enter file content as a single String
            String content = Files.readString(inputPath);
            System.out.printf("\n\nFile content as a single string: [%s]\n", content);

            // Writing to a File: The Files.write() method writes a list of strings to a file.
            Path outputPath = Paths.get(path + "output.txt");
            Files.write(outputPath, Arrays.asList("Line 1", "Line 2")); // Writing list of strings

            // Writing to a File: The Files.writeString() method writes a string to a file.
            String newContent = "This is a new line of text.\n";
            Files.writeString(outputPath, newContent); // Write the new content to the file

            /* Methods for File Manipulation and Traversal: File Manipulation:
            - Files.copy(Path source, Path target): Copies a file or directory.
            - Files.move(Path source, Path target): Moves/renames a file or directory.
            - Files.delete(Path path): Deletes a file or directory.
            - Files.exists(Path path): Checks if a file or directory exists.
            - Files.createFile(Path path): Creates a new empty file.
            - Files.createDirectory(Path path): Creates a new directory. */
            Path source = Paths.get(path + "source.txt");
            Path target = Paths.get(path + "target.txt");
            Files.copy(source, target); // make sure the target is not already exist

            /* Directory Traversal:
            - Files.list(Path dir): Returns a stream of entries in a directory.
            - Files.walk(Path dir): Returns a stream of file paths in a directory tree.
            - Files.find(Path dir, int depth, BiPredicate<Path, BasicFileAttributes>): Searches files based on criteria. */
            System.out.println("walk method():");
            Files.walk(Paths.get( path ))
                 .filter(Files::isRegularFile)
                 .forEach(System.out::println);

            /* 
            Performance: 
                While convenient, operations like Files.readAllLines() and Files.readString() load entire files into memory. 
                Use streaming methods (Files.lines() or Files.newBufferedReader()) for large files.
            Atomic Operations: 
                Use methods like Files.move() for atomic moves, ensuring consistency when renaming files or directories.
            Resource Management: 
                Ensure files and streams are closed properly, either manually or via try-with-resources.
            File Permissions: 
                Be aware of system-level file permissions when performing operations on files and directories. 
            */
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
