 /*  Class: CMSC203 CRN 31338
 Program: Assignment #6
 Instructor: Ashique Tanveer
 Summary of Description: This class handles the operations for the beverage shop, and is used in the driver class.
 It manages the orders, beverages, and customer information.
 Due Date: 05/02/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */
import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	
	private int alcoholicDrinkCount;
    private Order currentOrder;
	private ArrayList<Order> orders;
	
	public BevShop() {
        this.orders = new ArrayList<>();
        this.alcoholicDrinkCount = 0;
    }

	@Override
	public boolean isValidTime(int time) {
		return time >= 8 && time <= 23;
	}

	@Override
	public int getMaxNumOfFruits() {
		return 5;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return 21;
	}

	@Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > getMaxNumOfFruits();
    }

	@Override
	public int getMaxOrderForAlcohol() {
		return 3;
	}

	@Override
    public boolean isEligibleForMore() {
        return alcoholicDrinkCount < getMaxOrderForAlcohol();
    }

	@Override
    public int getNumOfAlcoholDrink() {
        return alcoholicDrinkCount;
    }

	@Override
	public boolean isValidAge(int age) {
		return age >= 21;
	}

	@Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        currentOrder = new Order(time, day, customer);
        alcoholicDrinkCount = 0;
        orders.add(currentOrder);
    }

	@Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

	@Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (isValidAge(currentOrder.getCustomer().getAge()) && isEligibleForMore()) {
            currentOrder.addNewBeverage(bevName, size);
            alcoholicDrinkCount++;
        }
    }

	@Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

	@Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNo) return i;
        }
        return -1;
    }


	@Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0;
    }

	@Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

	@Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return currentOrder;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    @Override
    public void sortOrders() {
        for (int index = 0; index < orders.size() - 1; index++) {
            int minIndex = index;
            for (int jindex = index + 1; jindex < orders.size(); jindex++) {
                if (orders.get(jindex).getOrderNumber() < orders.get(minIndex).getOrderNumber()) {
                    minIndex = jindex;
                }
            }
            if (minIndex != index) {
                Order temp = orders.get(index);
                orders.set(index, orders.get(minIndex));
                orders.set(minIndex, temp);
            }
        }
    }
}
