import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmoothieTest {

    @Test
    public void testCalcPriceVariants() {
        assertEquals(new Smoothie("Straw", Size.SMALL, 0, false).addSizePrice(),
                     new Smoothie("Straw", Size.SMALL, 0, false).calcPrice(), 0.01);

        double expected = new Smoothie("Banana", Size.MEDIUM, 0, true).addSizePrice() + 1.5;
        assertEquals(expected, new Smoothie("Banana", Size.MEDIUM, 0, true).calcPrice(), 0.01);

        double total = new Smoothie("Mango", Size.LARGE, 3, true).addSizePrice() + 1.5 + 1.5;
        assertEquals(total, new Smoothie("Mango", Size.LARGE, 3, true).calcPrice(), 0.01);
    }

    @Test
    public void testEqualsAndToString() {
        Smoothie a = new Smoothie("Mango", Size.LARGE, 3, true);
        Smoothie b = new Smoothie("Mango", Size.LARGE, 3, true);
        Smoothie c = new Smoothie("Mango", Size.LARGE, 2, true);
        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
        assertTrue(a.toString().contains("Mango"));
        assertTrue(a.toString().contains(String.valueOf(a.calcPrice())));
    }

    @Test
    public void testGettersSetters() {
        Smoothie s = new Smoothie("Test", Size.SMALL, 1, false);
        s.setNumFruits(4); s.setProteinExtra(true);
        assertEquals(4, s.getNumFruits());
        assertTrue(s.isProteinExtra());
    }
}