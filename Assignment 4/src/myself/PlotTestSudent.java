/*  Class: CMSC203 CRN 31338
 Program: Assignment #4
 Instructor: Ashique Tanveer
 Summary of Description: This test is for the Plot class. It tests the overlaps, encompasses, and equals methods. There's also the edge cases and negatives.
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


public class PlotTestSudent {

    private Plot plot1, plot2, plot3, plot4, plot5;

    @Before
    public void setUp() throws Exception {
        // Initialize various plot instances
        plot1 = new Plot(2, 2, 6, 6); // A plot at (2, 2) with width 6 and depth 6
        plot2 = new Plot(3, 3, 4, 4); // A plot inside plot1
        plot3 = new Plot(10, 10, 4, 4); // A plot far from plot1
        plot4 = new Plot(1, 1, 8, 8); // A plot that fully encompasses plot1
        plot5 = new Plot(3, 4, 4, 3); // A plot partially inside plot1 (should overlap)
    }

    @After
    public void tearDown() throws Exception {
        plot1 = plot2 = plot3 = plot4 = plot5 = null;
    }

    @Test
    public void testOverlaps() {
        // Test for plots that overlap
        assertTrue("Plot1 and Plot5 should overlap", plot1.overlaps(plot5)); // Partial overlap
        assertFalse("Plot1 and Plot3 should not overlap", plot1.overlaps(plot3)); // No overlap
        assertTrue("Plot1 and Plot2 should overlap", plot1.overlaps(plot2)); // Fully inside plot1
    }

    @Test
    public void testEncompasses() {
        // Test for plot1 encompassing other plots
        assertTrue("Plot1 should encompass Plot2", plot1.encompasses(plot2)); // Plot1 contains Plot2
        assertFalse("Plot1 should not encompass Plot3", plot1.encompasses(plot3)); // Plot3 is outside plot1
        assertTrue("Plot4 should encompass Plot1", plot4.encompasses(plot1)); // Plot4 fully contains plot1
    }

    @Test
    public void testToString() {
        // Test the string representation of plots
        assertEquals("3,4,4,3", plot5.toString()); // Expected output: 3,4,4,3
        assertEquals("2,2,6,6", plot1.toString()); // Expected output: 2,2,6,6
    }

    @Test
    public void testEdgeCases() {
        // Testing edge cases where plots are very close or identical
        Plot identicalPlot = new Plot(2, 2, 6, 6); // Same as plot1
        assertTrue("Identical plots should overlap", plot1.overlaps(identicalPlot)); // Identical plots should overlap
        
        Plot touchingPlot = new Plot(8, 2, 2, 6); // Touches plot1 on the right side
        assertFalse("Plot1 should not overlap touching plot", plot1.overlaps(touchingPlot)); // No overlap, just touching
        
        Plot barelyNotOverlapping = new Plot(10, 10, 1, 1); // Just outside plot1
        assertFalse("Plot1 should not overlap barely not overlapping plot", plot1.overlaps(barelyNotOverlapping)); // No overlap
    }

    @Test
    public void testNegativeDimensions() {
        // Handling negative dimensions
        Plot invalidPlot = new Plot(0, 0, -5, -5);
        assertFalse("Plot with negative dimensions should not overlap or encompass", plot1.overlaps(invalidPlot)); // Invalid plot dimensions
        assertFalse("Plot with negative dimensions should not encompass", plot1.encompasses(invalidPlot)); // Invalid plot dimensions
    }

    @Test
    public void testEdgeTouchingPlots() {
        // Test where plots just touch each other but do not overlap
        Plot edgeTouchPlot = new Plot(8, 2, 2, 6); // Just touching plot1
        assertFalse("Plot1 should not overlap edge-touching plot", plot1.overlaps(edgeTouchPlot));
        assertFalse("Plot1 should not encompass edge-touching plot", plot1.encompasses(edgeTouchPlot));
    }

}