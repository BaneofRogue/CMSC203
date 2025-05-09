 /*  Class: CMSC203 CRN 31338
 Program: Assignment #6
 Instructor: Ashique Tanveer
 Summary of Description: This is the Coffee class that extends the Beverage class.
 It calculates the price of a coffee beverage based on its size and whether it has extra coffee or syrup.
 Due Date: 05/02/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */
public class Coffee extends Beverage {
	
	private boolean extraCoffee;
	private boolean extraSyrup;
	
	public static final double extraCoffeeStuffCost = 0.5;
	
	public Coffee(String name, Size size, boolean extraCoffee, boolean extraSyrup) {
		super(name, Type.COFFEE, size);
		this.extraCoffee = extraCoffee;
		this.extraSyrup = extraSyrup;
	}

	public double calcPrice() {
		double cost = addSizePrice();
		if(extraCoffee) {
			cost += extraCoffeeStuffCost;
		}
		if(extraSyrup) {
			cost += extraCoffeeStuffCost;
		}
		return cost;
	}
	
	@Override
    public String toString() {
        return "Coffee" +"name='" + getName() + ", size=" + getSize() + ", extraCoffee=" + extraCoffee + ", extraSyrup=" + extraSyrup + ", price=" + calcPrice();
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if(obj == null) {
        	return false;
        }
        
        Coffee other = (Coffee) obj;
        
        if((other.extraCoffee == this.extraCoffee) && (other.extraSyrup == this.extraCoffee) && 
        		(other.calcPrice() == this.calcPrice())) {
        	return true;
        }
        
        return false;
    }
}
