import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeTest {

    private Coffee regularCoffee;
    private Coffee doubleExtraCoffee;

    @BeforeEach
    public void setUp() {
        regularCoffee = new Coffee("WallStreetBetter", Size.SMALL, false, false);
        doubleExtraCoffee = new Coffee("WallStreetBetter", Size.SMALL, true, true);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("WallStreetBetter", regularCoffee.getName());
        assertEquals(Size.SMALL, regularCoffee.getSize());
    }

    @Test
    public void testCalcPriceNoExtras() {
        double expected = regularCoffee.addSizePrice(); // only size cost
        assertEquals(expected, regularCoffee.calcPrice(), 0.001);
    }

    @Test
    public void testCalcPriceWithExtras() {
        double expected = doubleExtraCoffee.addSizePrice() + Coffee.extraCoffeeStuffCost * 2;
        assertEquals(expected, doubleExtraCoffee.calcPrice(), 0.001);
    }

    @Test
    public void testToString() {
        String result = doubleExtraCoffee.toString();
        assertTrue(result.contains("Coffee"));
        assertTrue(result.contains("WallStreetBetter"));
        assertTrue(result.contains("true")); // both extras
        assertTrue(result.contains(String.format("%.2f", doubleExtraCoffee.calcPrice()).substring(0, 2)));
    }

    @Test
    public void testEqualsSameObject() {
        assertTrue(doubleExtraCoffee.equals(doubleExtraCoffee));
    }

    @Test
    public void testEqualsIdenticalValues() {
        Coffee copy = new Coffee("WallStreetBetter", Size.SMALL, true, true);
        assertTrue(doubleExtraCoffee.equals(copy));
    }

    @Test
    public void testEqualsDifferentExtras() {
        Coffee different = new Coffee("WallStreetBetter", Size.SMALL, true, false);
        assertFalse(doubleExtraCoffee.equals(different));
    }

    @Test
    public void testEqualsNull() {
        assertFalse(regularCoffee.equals(null));
    }

    @Test
    public void testEqualsWrongLogicBug() {
        Coffee bugged = new Coffee("WallStreetBetter", Size.SMALL, true, false);
        // equals() incorrectly checks other.extraSyrup == this.extraCoffee
        assertFalse(regularCoffee.equals(bugged));
    }
}
