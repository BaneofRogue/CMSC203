 /*  Class: CMSC203 CRN 31338
 Program: Assignment #6
 Instructor: Ashique Tanveer
 Summary of Description: This is the customer class that represents a customer in the beverage shop application.
// It contains the customer's name and age, and provides methods to get and set these attributes.
 Due Date: 05/02/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */
public class Customer {
	private String name;
	private int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Customer(Customer old) {
		this.name = old.name;
		this.age = old.age;
	}
	
	// Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer{name='" + name + "', age=" + age + "}";
    }
    
}
