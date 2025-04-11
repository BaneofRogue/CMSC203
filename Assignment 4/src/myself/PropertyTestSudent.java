/*  Class: CMSC203 CRN 31338
 Program: Assignment #4
 Instructor: Ashique Tanveer
 Summary of Description: This test is for the Property class. It tests the constructors, getters, and toString method of the Property class.
 Due Date: 04/11/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */

package myself;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestSudent {
	Property propertyOne, propertyTwo, propertyThree;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("PropABC", "HiemerDong", 2450.00, "WingoDingo");
		propertyTwo = new Property("PropertyWallstreet", "Chiwiwi", 3500.00, "BingoDunno");
		propertyThree = new Property("yuuurrrrProperties", "ExpensiveHouses", 2950.00, "DepartmentOfAnabolicSteroids", 5, 5, 10, 10);
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = propertyTwo = propertyThree = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("PropABC", propertyOne.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2450.00, propertyOne.getRentAmount());
	}

	@Test
	void testGetCity() {
		assertEquals("HiemerDong", propertyOne.getCity());
	}

	@Test
	void testGetOwner() {
		assertEquals("WingoDingo", propertyOne.getOwner());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("PropABC,HiemerDong,WingoDingo,2450.0", propertyOne.toString());
	}

	@Test
	void testParameterizedConstructor() {
		assertEquals("PropertyWallstreet", propertyTwo.getPropertyName());
		assertEquals("Chiwiwi", propertyTwo.getCity());
		assertEquals(3500.00, propertyTwo.getRentAmount());
		assertEquals("BingoDunno", propertyTwo.getOwner());
		assertEquals(0, propertyTwo.getPlot().getX());
		assertEquals(0, propertyTwo.getPlot().getY());
		assertEquals(1, propertyTwo.getPlot().getWidth());
		assertEquals(1, propertyTwo.getPlot().getDepth());
	}

	@Test
	void testParameterizedConstructorWithPlot() {
		assertEquals("yuuurrrrProperties", propertyThree.getPropertyName());
		assertEquals("ExpensiveHouses", propertyThree.getCity());
		assertEquals(2950.00, propertyThree.getRentAmount());
		assertEquals("DepartmentOfAnabolicSteroids", propertyThree.getOwner());
		assertEquals(5, propertyThree.getPlot().getX());
		assertEquals(5, propertyThree.getPlot().getY());
		assertEquals(10, propertyThree.getPlot().getWidth());
		assertEquals(10, propertyThree.getPlot().getDepth());
	}

	@Test
	void testCopyConstructor() {
		Property propertyCopy = new Property(propertyOne);
		assertEquals(propertyOne.getPropertyName(), propertyCopy.getPropertyName());
		assertEquals(propertyOne.getCity(), propertyCopy.getCity());
		assertEquals(propertyOne.getRentAmount(), propertyCopy.getRentAmount());
		assertEquals(propertyOne.getOwner(), propertyCopy.getOwner());
		assertEquals(propertyOne.getPlot().getX(), propertyCopy.getPlot().getX());
		assertEquals(propertyOne.getPlot().getY(), propertyCopy.getPlot().getY());
		assertEquals(propertyOne.getPlot().getWidth(), propertyCopy.getPlot().getWidth());
		assertEquals(propertyOne.getPlot().getDepth(), propertyCopy.getPlot().getDepth());
	}

}