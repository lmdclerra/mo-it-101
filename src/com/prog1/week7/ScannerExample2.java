package com.prog1.week7;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class ScannerExample2 {

	public static void main(String[] args) {

		// creates an object of Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a big integer: ");

		// reads the big integer
		BigInteger value1 = input.nextBigInteger();
		System.out.println("Using nextBigInteger(): " + value1);

		System.out.print("Enter a big decimal: ");

		// reads the big decimal
		BigDecimal value2 = input.nextBigDecimal(); // -10^(-999999999) to 10^(999999999)
		System.out.println("Using nextBigDecimal(): " + value2);

		input.close();
	}
}