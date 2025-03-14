/*
 * Class: CMSC203
 * Instructor: Ashique Tanveer
 * Description: GradebookTester class that tests the GradeBook class with JUnit Test Cases.
 * Due Date: 3/14/25
 * Platform/compiler: Eclipse IDE for Java Developers - 2024-12
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   
* any source. I have not given my code to any student.
 * Print your Name here: William Keller
*/

package myself;

import junit.framework.TestCase;

public class GradebookTester extends TestCase {
	
	GradeBook gradebook1 = new GradeBook(5);
	GradeBook gradebook2 = new GradeBook(5);

	protected void setUp() throws Exception {
		super.setUp();
		
		gradebook1.addScore(3);
		gradebook1.addScore(2);
		
		gradebook2.addScore(1);
		gradebook2.addScore(2);
		gradebook2.addScore(3);
		gradebook2.addScore(4);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		
		gradebook1 = null;
		gradebook2 = null;
	}

	public void testAddScore() {
        assertTrue(gradebook1.addScore(4));  // Should return true if added successfully
        assertEquals(3.0, gradebook1.getScoreSize());  // scoreSize should be 3
    }

	public void testSum() {
        // Test if the sum method returns the correct sum
        assertEquals(5.0, gradebook1.sum());
        assertEquals(10.0, gradebook2.sum());
    }

	public void testMinimum() {
        // Test if the minimum method returns the correct minimum
        assertEquals(2.0, gradebook1.minimum());  // min score is 2
        assertEquals(1.0, gradebook2.minimum());  // min score is 1
    }

	public void testFinalScore() {
        // Test if the finalScore method correctly drops the lowest score and sums the rest
        assertEquals(3.0, gradebook1.finalScore());
        assertEquals(9.0, gradebook2.finalScore());
    }

}
