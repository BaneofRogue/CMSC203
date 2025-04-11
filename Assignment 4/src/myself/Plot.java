 /*  Class: CMSC203 CRN 31338
 Program: Assignment #4
 Instructor: Ashique Tanveer
 Summary of Description: This is the plot class responsible for creating a plot object and has functions to check if overlaps or encompasses another plot object.
It also contains the getters and setters for the attributes of the plot object.
 Due Date: 04/11/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */

package myself;

public class Plot {
    // Attributes for x and y coordinates of the upper left corner, depth, and width
    private int x;
    private int y;
    private int width;
    private int depth;
    
    // Constructor to initialize the Plot
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Getter for x
    public int getX() {
        return x;
    }
    
    // Setter for x
    public void setX(int x) {
        this.x = x;
    }

    // Getter for y
    public int getY() {
        return y;
    }

    // Setter for y
    public void setY(int y) {
        this.y = y;
    }

    // Getter for width
    public int getWidth() {
        return width;
    }

    // Setter for width
    public void setWidth(int width) {
        this.width = width;
    }

    // Getter for depth
    public int getDepth() {
        return depth;
    }

    // Setter for depth
    public void setDepth(int depth) {
        this.depth = depth;
    }


    /* 
    Check if this plot overlaps with the given *other* plot
    Pseudo:
    if this x + this width is <= differentPlot x... OR... this x is >= differentPlot x + differentPlot width
    OR... this y + this depth is <= differentPlot y... OR... this y is >= differentPlot y + differentPlot depth
    Depending on the result of the above, return the opposite.
    */
    public boolean overlaps(Plot differentPlot) {
        return !(this.x + this.width <= differentPlot.x || this.x >= differentPlot.x + differentPlot.width || 
                 this.y + this.depth <= differentPlot.y || this.y >= differentPlot.y + differentPlot.depth);
    }

    /*
    Check if the current plot *encompasses* or contains the "different plot"
    Pseudo:
    if this x is <= differentPlot x... AND... this y is <= differentPlot y
    AND... this x + this width is >= differentPlot x + differentPlot width
    AND... this y + this depth is >= differentPlot y + differentPlot depth
    if all that is true, then return true.
    Else, return false.
    */

    public boolean encompasses(Plot differentPlot) {
        return this.x <= differentPlot.x && this.y <= differentPlot.y &&
               this.x + this.width >= differentPlot.x + differentPlot.width &&
               this.y + this.depth >= differentPlot.y + differentPlot.depth;
    }

    /*
    Method to return a string representation of the Plot instance
    Format: [x],[y],[width],[depth] 
     */
    @Override
    public String toString() {
        return this.x + "," + this.y + "," + this.width + "," + this.depth;
    }

}
