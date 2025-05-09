 /*  Class: CMSC203 CRN 31338
 Program: Assignment #6
 Instructor: Ashique Tanveer
 Summary of Description: 
 Due Date: 05/02/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface {
	// Instance variables
    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;
    
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNumber = generateOrderNumber();  // Generate a random order number
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = customer;
        this.beverages = new ArrayList<>();
    }
    
    public int getTotalItems() {
    	return this.beverages.size();
    }
    
    private int generateOrderNumber() {
        Random rand = new Random();
        return rand.nextInt(90000 - 10000 + 1) + 10000; // Random number between 10000 and 90000
    }
    
    public void addNewBeverage(Beverage beverage) {
        beverages.add(beverage);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber)
          .append("\nOrder Time: ").append(orderTime)
          .append("\nOrder Day: ").append(orderDay)
          .append("\nCustomer: ").append(customer.toString())
          .append("\nBeverages:\n");

        for (Beverage beverage : beverages) {
            sb.append(beverage.toString()).append("\n");
        }

        return sb.toString();
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(Day orderDay) {
        this.orderDay = orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // Return a deep copy of the customer
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(ArrayList<Beverage> beverages) {
        this.beverages = beverages;
    }

	@Override
	public boolean isWeekend() {
		switch(orderDay) {
			case Day.SATURDAY:
				return true;
			case Day.SUNDAY:
				return true;
		default:
			return false;
		}
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		Beverage bev = this.beverages.get(itemNo);
		return bev;
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Beverage bev = new Coffee(bevName, size, extraShot, extraSyrup);
		addNewBeverage(bev);
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		Beverage bev = new Alcohol(bevName, size, isWeekend());
		addNewBeverage(bev);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Beverage bev = new Smoothie(bevName, size, numOfFruits, addProtein);
		addNewBeverage(bev);
	}

	@Override
	public double calcOrderTotal() {
		double totalPrice = 0;
		
		for(int index = 0; index < this.beverages.size(); index++) {
			totalPrice += this.beverages.get(index).calcPrice();
		}
		
		return totalPrice;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int amount = 0;
		for(int index = 0; index < this.beverages.size(); index++) {
			if(this.beverages.get(index).getType() == type) {
				amount++;
			}
		}
		return amount;
	}
}
