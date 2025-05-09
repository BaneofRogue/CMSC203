 /*  Class: CMSC203 CRN 31338
 Program: Assignment #6
 Instructor: Ashique Tanveer
 Summary of Description: This is the Beverage abstract class that serves as a base for different types of beverages.
 It contains methods to calculate the price based on size and type of beverage.
It also includes getters and setters for the beverage attributes.
 Due Date: 05/02/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */
public abstract class Beverage {
	private String name;
	private Type type;
	private Size size;
	
	
	public static final double basePrice = 2.0;
	public static final double sizePrice = 0.5;
	
	public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }
	
	public double addSizePrice() {
        // If the size is small, there's no additional cost
        if (size == Size.SMALL) {
            return basePrice;
        }
        // For medium and large, add the size price
        else {
            return basePrice + sizePrice * (size.ordinal()); // ordinal() gives 0 for SMALL, 1 for MEDIUM, 2 for LARGE
        }
    }
	
	// Abstract method to calculate the final price (to be implemented by subclasses)
    public abstract double calcPrice();
    
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    // Overridden toString method to return a string representation of the beverage
    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", size=" + size +
                '}';
    }

    // Overridden equals method to compare beverages based on name, type, and size
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if (obj == null) {
        	return false;
        }
        Beverage beverage = (Beverage) obj;
        return name.equals(beverage.name) && type == beverage.type && size == beverage.size;
    }
	
}
