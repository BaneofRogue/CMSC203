import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlcoholTest {

    private Alcohol weekdayAlcohol;
    private Alcohol weekendAlcohol;

    @BeforeEach
    public void setUp() {
        weekdayAlcohol = new Alcohol("Whiskey", Size.MEDIUM, false);
        weekendAlcohol = new Alcohol("Whiskey", Size.MEDIUM, true);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Whiskey", weekdayAlcohol.getName());
        assertEquals(Size.MEDIUM, weekdayAlcohol.getSize());
        assertFalse(weekdayAlcohol.isWeekend());

        assertTrue(weekendAlcohol.isWeekend());
    }

    @Test
    public void testSetWeekend() {
        weekdayAlcohol.setWeekend(true);
        assertTrue(weekdayAlcohol.isWeekend());

        weekendAlcohol.setWeekend(false);
        assertFalse(weekendAlcohol.isWeekend());
    }

    @Test
    public void testCalcPriceWithoutWeekend() {
        double expected = weekdayAlcohol.addSizePrice();
        assertEquals(expected, weekdayAlcohol.calcPrice(), 0.001);
    }

    @Test
    public void testCalcPriceWithWeekend() {
        double expected = weekendAlcohol.addSizePrice() + Alcohol.WEEKEND_COST;
        assertEquals(expected, weekendAlcohol.calcPrice(), 0.001);
    }

    @Test
    public void testToString() {
        String result = weekendAlcohol.toString();
        assertTrue(result.contains("Alcohol"));
        assertTrue(result.contains("Whiskey"));
        assertTrue(result.contains("MEDIUM"));
        assertTrue(result.contains("true"));
        assertTrue(result.contains(String.format("%.2f", weekendAlcohol.calcPrice()).substring(0, 2))); // rough price match
    }

    @Test
    public void testEqualsSameObject() {
        assertTrue(weekendAlcohol.equals(weekendAlcohol));
    }

    @Test
    public void testEqualsDiffObjectSameData() {
        Alcohol another = new Alcohol("Whiskey", Size.MEDIUM, true);
        assertTrue(weekendAlcohol.equals(another));
    }

    @Test
    public void testEqualsDiffWeekendFlag() {
        assertFalse(weekendAlcohol.equals(weekdayAlcohol));
    }

    @Test
    public void testEqualsDiffName() {
        Alcohol Diff = new Alcohol("Varcar", Size.MEDIUM, true);
        assertFalse(weekendAlcohol.equals(Diff));
    }

    @Test
    public void testEqualsNull() {
        assertFalse(weekendAlcohol.equals(null));
    }

    @Test
    public void testEqualsDiffType() {
        assertFalse(weekendAlcohol.equals("Not an Alcohol object"));
    }
}