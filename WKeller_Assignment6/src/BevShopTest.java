import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BevShopTest {

    private BevShop shop;

    @BeforeEach
    public void setUp() {
        shop = new BevShop();
    }

    @Test
    public void testIsValidTime() {
        assertTrue(shop.isValidTime(8));
        assertTrue(shop.isValidTime(23));
        assertFalse(shop.isValidTime(7));
        assertFalse(shop.isValidTime(24));
    }

    @Test
    public void testGetMaxNumOfFruits() {
        assertEquals(5, shop.getMaxNumOfFruits());
    }

    @Test
    public void testGetMinAgeForAlcohol() {
        assertEquals(21, shop.getMinAgeForAlcohol());
    }

    @Test
    public void testIsMaxFruit() {
        assertTrue(shop.isMaxFruit(6));
        assertFalse(shop.isMaxFruit(4));
    }

    @Test
    public void testIsEligibleForMore() {
        assertTrue(shop.isEligibleForMore());
    }

    @Test
    public void testIsValidAge() {
        assertTrue(shop.isValidAge(21));
        assertFalse(shop.isValidAge(20));
    }

    @Test
    public void testStartNewOrder() {
        shop.startNewOrder(10, Day.MONDAY, "Heffly", 25);
        assertNotNull(shop.getCurrentOrder());
        assertEquals("Heffly", shop.getCurrentOrder().getCustomer().getName());
        assertEquals(1, shop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testProcessCoffeeOrder() {
        shop.startNewOrder(10, Day.MONDAY, "Heffly", 25);
        shop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        assertEquals(1, shop.getCurrentOrder().getBeverages().size());
    }

    @Test
    public void testProcessAlcoholOrder() {
        shop.startNewOrder(10, Day.MONDAY, "Heffly", 25);
        shop.processAlcoholOrder("Beer", Size.SMALL);
        assertEquals(1, shop.getCurrentOrder().getBeverages().size());
        assertEquals(1, shop.getNumOfAlcoholDrink());
    }

    @Test
    public void testProcessAlcohol_Underage() {
        shop.startNewOrder(10, Day.MONDAY, "Heffly", 20);
        shop.processAlcoholOrder("Wine", Size.SMALL);
        assertEquals(0, shop.getCurrentOrder().getBeverages().size());
    }

    @Test
    public void testProcessSmoothieOrder() {
        shop.startNewOrder(10, Day.MONDAY, "Heffly", 25);
        shop.processSmoothieOrder("Banana Blast", Size.LARGE, 2, true);
        assertEquals(1, shop.getCurrentOrder().getBeverages().size());
    }

    @Test
    public void testFindOrder() {
        shop.startNewOrder(10, Day.MONDAY, "Heffly", 25);
        int orderNo = shop.getCurrentOrder().getOrderNumber();
        assertEquals(0, shop.findOrder(orderNo));
        assertEquals(-1, shop.findOrder(orderNo + 1));
    }

    @Test
    public void testTotalOrderPrice() {
        shop.startNewOrder(10, Day.MONDAY, "Heffly", 25);
        int orderNo = shop.getCurrentOrder().getOrderNumber();
        shop.processCoffeeOrder("Latte", Size.SMALL, false, false);
        double price = shop.totalOrderPrice(orderNo);
        assertTrue(price > 0);
    }

    @Test
    public void testTotalMonthlySale() {
        shop.startNewOrder(10, Day.MONDAY, "Heffly", 25);
        shop.processCoffeeOrder("Latte", Size.SMALL, false, false);
        assertTrue(shop.totalMonthlySale() > 0);
    }

    @Test
    public void testTotalNumOfMonthlyOrders() {
        shop.startNewOrder(10, Day.MONDAY, "Heffly", 25);
        shop.startNewOrder(11, Day.TUESDAY, "Bingobomg", 22);
        assertEquals(2, shop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testGetOrderAtIndex() {
        shop.startNewOrder(10, Day.MONDAY, "Heffly", 25);
        Order order = shop.getOrderAtIndex(0);
        assertEquals("Heffly", order.getCustomer().getName());
    }

}
