 /*  Class: CMSC203 CRN 31338
 Program: Assignment #6
 Instructor: Ashique Tanveer
 Summary of Description: This is the Alcohol class that extends the Beverage class.
 It calculates the price of an alcoholic beverage based on its size and whether it is a weekend.
 Due Date: 05/02/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */

public class Alcohol extends Beverage {

    private boolean isWeekend;
    
    public static final double WEEKEND_COST = 0.60;
    
    public Alcohol(String name, Size size, boolean isWeekend) {
        super(name, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double cost = addSizePrice();
        if (isWeekend) {
            cost += WEEKEND_COST;
        }
        return cost;
    }

    @Override
    public String toString() {
        return "Alcohol" + "name='" + getName() + ", size=" + getSize() + ", isWeekend=" + isWeekend +", price=" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Alcohol)) {
            return false;
        }

        Alcohol other = (Alcohol) obj;
        return this.isWeekend == other.isWeekend &&
                this.calcPrice() == other.calcPrice() &&
                super.equals(obj);
    }

    // Getters and Setters
    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
}
