package com.prog1.week7;

import java.util.Scanner;

public class ScannerExample1 {
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter name, age and salary:");

		// String input
		String name = scanner.nextLine();

		// Numerical input
		int age = scanner.nextInt();
		double salary = scanner.nextDouble();
		
		scanner.close();

		// Output input by user
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Salary: " + salary);
	}
}