/*  Class: CMSC203 CRN 31338
 Program: Assignment #4
 Instructor: Ashique Tanveer
 Summary of Description: The test for management company class. It tests the addProperty, getters, and the return values of adding different types of properties.
 Due Date: 04/11/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */

package myself;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagmentCompanyTestSudent {
	Property sampleProperty;
	ManagementCompany mangementCo ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo = new ManagementCompany("Railey", "555555555", 6);
	}

	@After
	public void tearDown() throws Exception {
		mangementCo = null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 2, 5, 2, 2);		 
		assertEquals(mangementCo.addProperty(sampleProperty), 0);	//property has been successfully added to index 0
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 2, 5, 2, 2);		 
		assertEquals(mangementCo.addProperty(sampleProperty), 0);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}

	@Test
	public void testToString() {
		sampleProperty = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 2, 5, 2, 2);
		assertEquals(mangementCo.addProperty(sampleProperty), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for Railey, taxID: 555555555\n"
				+ "______________________________________________________\n"
				+ "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
				+ "______________________________________________________\n"
				+ "\n"
				+ " total management Fee: 156.78";
		assertEquals(expectedString, mangementCo.toString());
	}

	@Test
	public void testAddPropertyWhenFull() {
		// Add the maximum allowed properties (5 in this case)
		for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
			sampleProperty = new Property("Property " + (i + 1), "City " + (i + 1), 1000 + (i * 100), "Owner " + (i + 1), (1+i), (1+i), 1, 1);
			mangementCo.addProperty(sampleProperty);
		}
		// Try to add a property when the array is full
		sampleProperty = new Property("New Property", "New City", 5000, "New Owner", 0, 0, 1, 1);
		assertEquals(mangementCo.addProperty(sampleProperty), -1);	// Should return -1 because the array is full
	}

	@Test
	public void testAddPropertyNull() {
		// Try adding a null property
		assertEquals(mangementCo.addProperty((Property) null), -2);	// Should return -2 because the property is null
	}

	@Test
	public void testInvalidPlotEncompassment() {
		// Add a property that doesn't fit within the management company's plot
		sampleProperty = new Property("Property", "City", 1000, "Owner", 100, 100, 2, 2);
		assertEquals(mangementCo.addProperty(sampleProperty), -3);	// Should return -3 because the plot is out of bounds
	}

	@Test
	public void testPropertyOverlap() {
		// Add a property first
		sampleProperty = new Property("Property 1", "City", 1000, "Owner 1", 2, 5, 2, 2);
		mangementCo.addProperty(sampleProperty);
		
		// Add another property that overlaps with the first property
		Property overlappingProperty = new Property("Property 2", "City", 1200, "Owner 2", 2, 5, 2, 2);
		assertEquals(mangementCo.addProperty(overlappingProperty), -4);	// Should return -4 because the properties overlap
	}

	@Test
	public void testIsManagementFeeValid() {
		// Test a valid management fee
		mangementCo = new ManagementCompany("Railey", "555555555", 6); // Fee is 6%
		assertTrue(mangementCo.isMangementFeeValid()); // Fee is valid
		
		// Test an invalid management fee
		mangementCo = new ManagementCompany("Railey", "555555555", -5); // Fee is negative
		assertFalse(mangementCo.isMangementFeeValid()); // Fee is invalid
		
		// Test an invalid management fee
		mangementCo = new ManagementCompany("Railey", "555555555", 105); // Fee exceeds 100
		assertFalse(mangementCo.isMangementFeeValid()); // Fee is invalid
	}

	@Test
	public void testGetHighestRentProperty() {
	    // Create two Property objects
	    Property property1 = new Property("Property 1", "City", 1000, "Owner 1", 2, 5, 2, 2);
	    Property property2 = new Property("Property 2", "City", 5000, "Owner 2", 5, 7, 2, 2);

	    mangementCo.addProperty(property1);
	    mangementCo.addProperty(property2);
	    
	    Property highestRentProperty = mangementCo.getHighestRentProperty();

	    assertEquals(property2.toString(), highestRentProperty.toString());
	}



	@Test
	public void testGetTotalRent() {
		// Add multiple properties
		sampleProperty = new Property("Property 1", "City", 1000, "Owner 1", 2, 5, 2, 2);
		mangementCo.addProperty(sampleProperty);
		Property property2 = new Property("Property 2", "City", 2000, "Owner 2", 5, 5, 2, 2);
		mangementCo.addProperty(property2);

		// Verify the total rent is correct
		assertEquals(mangementCo.getTotalRent(), 3000.0, 0.01);
	}

	@Test
	public void testRemoveLastProperty() {
		// Add a property
		sampleProperty = new Property("Property", "City", 1000, "Owner", 2, 5, 2, 2);
		mangementCo.addProperty(sampleProperty);

		// Verify the property count is 1
		assertEquals(mangementCo.getPropertiesCount(), 1);

		// Remove the last property
		mangementCo.removeLastProperty();

		// Verify the property count is 0
		assertEquals(mangementCo.getPropertiesCount(), 0);
	}
}