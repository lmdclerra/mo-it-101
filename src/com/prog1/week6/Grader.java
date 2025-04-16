package com.prog1.week6;

// Java Unit Testing with JUnit - Tutorial - How to Create And Use Unit Tests 
// >> https://youtu.be/vZm0lHciFsQ
public class Grader {

	public char determineLetterGrade(int numberGrade) {
		if (numberGrade < 0) throw new IllegalArgumentException("Number grade cannot be negative."); 
		if (numberGrade < 60) { return 'F'; }
		if (numberGrade < 70) { return 'D'; }
		if (numberGrade < 80) { return 'C'; }
		if (numberGrade < 90) { return 'B'; }
		return 'A'; 
	}
}
