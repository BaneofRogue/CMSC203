import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("JarOfPeanuts", 30);
    }

    @Test
    public void testConstructor() {
        assertEquals("JarOfPeanuts", customer.getName());
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testCopyConstructor() {
        Customer copy = new Customer(customer);
        assertEquals("JarOfPeanuts", copy.getName());
        assertEquals(30, copy.getAge());
        assertNotSame(copy, customer); // ensure it's a different object
    }

    @Test
    public void testGetName() {
        assertEquals("JarOfPeanuts", customer.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testSetName() {
        customer.setName("Bob");
        assertEquals("Bob", customer.getName());
    }

    @Test
    public void testSetAge() {
        customer.setAge(25);
        assertEquals(25, customer.getAge());
    }

    @Test
    public void testToString() {
        String expected = "Customer{name='JarOfPeanuts', age=30}";
        assertEquals(expected, customer.toString());
    }
}
