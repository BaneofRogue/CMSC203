 /*  Class: CMSC203 CRN 31338
 Program: Assignment #4
 Instructor: Ashique Tanveer
 Summary of Description: This is the property class responsible for creating a property object and has functions to get and set the attributes of the property object.
 It also has getters and setters for the fields inside.
 Due Date: 04/11/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */

package myself;

public class Property {

	// Attributes
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    /*
    Default Constructor
    Initializes the property with default values.
    The default values are empty strings for propertyName, city, and owner,
    0.0 for rentalAmount, and a default plot with coordinates (0, 0) and size (1, 1).
    The plot params are x, y, width, and depth respectively.
    */
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot(0, 0, 1, 1);
    }

    /* 
    Parameterized Constructor
    Initializes the property with the given name, city, rental amount, and owner.
    Also initializes the plot with default values (0, 0, 1, 1).
    The plot params are x, y, width, and depth respectively.
    */
    public Property(String propertyName, String city, double rentalAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentalAmount;
        this.owner = owner;
        this.plot = new Plot(0, 0, 1, 1); // Default plot
    }

    
    /*
    Parameterized Constructor with Plot
    Initializes the property with the given name, city, rental amount, owner, and plot dimensions.

     */
    public Property(String propertyName, String city, double rentalAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentalAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    /*
    Copy Constructor
    Initializes the property with the values from another Property object.
     */
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot.getX(), otherProperty.plot.getY(), otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
    }

    /*
    Getters and Setters
    This part is so much copy paste haha
    The getters and setters are used to access and modify the private attributes of the Property class.
    */

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentalAmount) {
        this.rentAmount = rentalAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    // toString method to return a formatted string representation of the Property
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
    
}
