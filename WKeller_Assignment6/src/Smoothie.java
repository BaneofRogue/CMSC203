 /*  Class: CMSC203 CRN 31338
 Program: Assignment #6
 Instructor: Ashique Tanveer
 Summary of Description: This is the Smoothie class that extends the Beverage class.
 It calculates the price of a smoothie beverage based on its size and whether it has extra protein or fruits.
 Due Date: 05/02/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */

public class Smoothie extends Beverage {
	
	private int numFruits;
	private boolean extraProtein;
	
	public static final double extraProteinPrice = 1.5;
	public static final double extraFruitPrice = 0.5;
	
	public Smoothie(String name, Size size, int numFruits, boolean extraProtein) {
		super(name, Type.SMOOTHIE, size);
		this.extraProtein = extraProtein;
		this.numFruits = numFruits;
	}
	
	public double calcPrice() {
        double cost = addSizePrice();
        if (extraProtein) {
            cost += extraProteinPrice;
        }
        cost += numFruits * extraFruitPrice;
        return cost;
    }
	
	@Override
    public String toString() {
        return "Smoothie{" +
                "name='" + getName() + ", size=" + getSize() +", proteinAdded=" + extraProtein +", numFruits=" + numFruits +", price=" + calcPrice();
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        
        Smoothie other = (Smoothie) obj;
        
        return other.numFruits == this.numFruits &&
                other.extraProtein == this.extraProtein &&
                other.calcPrice() == this.calcPrice() &&
                super.equals(obj);
    }
	
	// Getters and Setters
    public int getNumFruits() {
        return numFruits;
    }

    public void setNumFruits(int numFruits) {
        this.numFruits = numFruits;
    }

    public boolean isProteinExtra() {
        return extraProtein;
    }

    public void setProteinExtra(boolean proteinAdded) {
        this.extraProtein = proteinAdded;
    }

}
