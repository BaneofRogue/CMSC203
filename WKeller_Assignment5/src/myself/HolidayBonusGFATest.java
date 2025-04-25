 /*  Class: CMSC203 CRN 31338
 Program: Assignment #5
 Instructor: Ashique Tanveer
 Summary of Description: 
 Due Date: 04/25/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */
package myself;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a HolidayBonus object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 * 
 */
public class HolidayBonusGFATest {

	private double[][] dataSet1 = { 
		    { 1000, 2000, 1200 },
		    { 3300, 3000 },
		    { 5000, 4000, 3000 }
		};


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
			assertEquals(1000.0, result[0], .001);
			assertEquals(5000.0, result[1], .001);
			assertEquals(5000.0, result[2], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(11000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
	}

}
