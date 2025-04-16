package test.com.prog1.week6;

import static org.junit.Assert.*;
import com.prog1.week6.Grader;
import org.junit.Test;

// Java Unit Testing with JUnit - Tutorial - How to Create And Use Unit Tests 
// >> https://youtu.be/vZm0lHciFsQ
public class GraderTest {

	@Test
	public void fiftyNineShouldReturnF() {
		var grader = new Grader();
		assertEquals('F', grader.determineLetterGrade(59));
	}

	@Test
	public void sixtyNineShouldReturnD() {
		var grader = new Grader();
		assertEquals('D', grader.determineLetterGrade(69));
	}

	@Test
	public void seventyNineShouldReturnC() {
		var grader = new Grader();
		assertEquals('C', grader.determineLetterGrade(79));
	}

	@Test
	public void eightyNineShouldReturnB() {
		var grader = new Grader();
		assertEquals('B', grader.determineLetterGrade(89));
	}

	@Test
	public void ninetyNineShouldReturnA() {
		var grader = new Grader();
		assertEquals('A', grader.determineLetterGrade(99));
	}

	@Test
	public void ninetyShouldReturnA() {
		var grader = new Grader();
		assertEquals('A', grader.determineLetterGrade(90));
	}

	@Test
	public void eightyShouldReturnB() {
		var grader = new Grader();
		assertEquals('B', grader.determineLetterGrade(80));
	}

	@Test
	public void seventyShouldReturnC() {
		var grader = new Grader();
		assertEquals('C', grader.determineLetterGrade(70));
	}

	@Test
	public void sixtyShouldReturnD() {
		var grader = new Grader();
		assertEquals('D', grader.determineLetterGrade(60));
	}

	@Test
	public void fiftyShouldReturnF() {
		var grader = new Grader();
		assertEquals('F', grader.determineLetterGrade(50));
	}

	@Test
	public void zeroShouldReturnF() {
		var grader = new Grader();
		assertEquals('F', grader.determineLetterGrade(0));
	}

	@Test
	public void nevativeOneShouldReturnIllegalArgumentException() {
		var grader = new Grader();
		assertThrows(IllegalArgumentException.class, () -> { 
			grader.determineLetterGrade(-1); 
		});
	}

}
