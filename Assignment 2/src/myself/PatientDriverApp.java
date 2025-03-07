/*
 * Class: CMSC203
 * Instructor: Ashique Tanveer
 * Description: 
 * Due Date: 2/28/25
 * Platform/compiler: Eclipse IDE for Java Developers - 2024-12
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   
* any source. I have not given my code to any student.
 * Print your Name here: William Keller
*/

package myself;

import java.util.Scanner;

public class PatientDriverApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter Patient Information:");
		System.out.print("First Name: ");
		String firstName = input.nextLine();

		System.out.print("Middle Name: ");
		String middleName = input.nextLine();

		System.out.print("Last Name: ");
		String lastName = input.nextLine();

		System.out.print("Street Address: ");
		String streetAddress = input.nextLine();

		System.out.print("City: ");
		String city = input.nextLine();

		System.out.print("State: ");
		String state = input.nextLine();

		System.out.print("ZIP Code: ");
		String zipCode = input.nextLine();

		System.out.print("Phone Number: ");
		String phoneNumber = input.nextLine();

		System.out.print("Emergency Contact Name: ");
		String emergencyContactName = input.nextLine();

		System.out.print("Emergency Contact Phone: ");
		String emergencyContactPhone = input.nextLine();

		Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zipCode, phoneNumber, emergencyContactName, emergencyContactPhone);
		
		System.out.println("\nEnter Procedure Information:");
		System.out.print("Procedure 1 Name: ");
		String procedure1Name = input.nextLine();

		System.out.print("Procedure 1 Date: ");
		String procedure1Date = input.nextLine();
		
		System.out.print("Practitioner: ");
		String practitioner1 = (input.nextLine());

		double charges1 = 0;
        
		while (charges1 <= 0) {
            System.out.print("Charges: ");
            // Check if the next input is a valid double
            if (input.hasNextDouble()) {
            	charges1 = input.nextDouble();
                input.nextLine();  // Consume the newline character
                
                if (charges1 <= 0) {
                    System.out.println("Please enter a positive number for charges.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();  // Clear the invalid input
            }
        }
        
		
		// NAME DATE ARGS ONLY CONSTRUCT
		Procedure procedure1 = new Procedure(procedure1Name, procedure1Date);
		procedure1.setPractitionerName(practitioner1);
		procedure1.setProcedureCharges(charges1);
		///////////////////////////////////////////////////

		System.out.print("Procedure 2 Name: ");
		String procedure2Name = input.nextLine();

		System.out.print("Procedure 2 Date: ");
		String procedure2Date = input.nextLine();

		System.out.print("Practitioner: ");
		String practitioner2 = input.nextLine();

		double charges2 = 0;
        
		while (charges2 <= 0) {
            System.out.print("Charges: ");
            // Check if the next input is a valid double
            if (input.hasNextDouble()) {
            	charges2 = input.nextDouble();
                input.nextLine();  // Consume the newline character
                
                if (charges2 <= 0) {
                    System.out.println("Please enter a positive number for charges.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();  // Clear the invalid input
            }
        }
        

		// ALL ARGS CONSTRUCT
		Procedure procedure2 = new Procedure(procedure2Name, procedure2Date, practitioner2, charges2);

		System.out.print("Procedure 3 Name: ");
		String procedure3Name = input.nextLine();

		System.out.print("Procedure 3 Date: ");
		String procedure3Date = input.nextLine();

		System.out.print("Practitioner: ");
		String practitioner3 = (input.nextLine());

		double charges3 = 0;
        
		while (charges3 <= 0) {
            System.out.print("Charges: ");
            // Check if the next input is a valid double
            if (input.hasNextDouble()) {
            	charges3 = input.nextDouble();
                input.nextLine();  // Consume the newline character
                
                if (charges3 <= 0) {
                    System.out.println("Please enter a positive number for charges.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();  // Clear the invalid input
            }
        }
        

		//NO ARGS CONSTRUCT
		Procedure procedure3 = new Procedure();
		
		procedure3.setProcedureName(procedure3Name);
		procedure3.setProcedureDate(procedure3Date);
		procedure3.setPractitionerName(practitioner3);
		procedure3.setProcedureCharges(charges3);

		displayPatient(patient);
		displayProcedure(procedure1);
		displayProcedure(procedure2);
		displayProcedure(procedure3);

		System.out.printf("\nTotal Charges: $%.2f\n", calculateTotalCharges(procedure1, procedure2, procedure3));
		input.close();
		
		System.out.println("Student Name: William Keller");
		System.out.println("MC#: M21199343");
		System.out.println("Due Date: 03/07/25");
	}

	public static void displayPatient(Patient patient) {
		System.out.println("\n\n" + patient);
	}

	public static void displayProcedure(Procedure procedure) {
		System.out.println(procedure);
	}

	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
		return p1.getProcedureCharges() + p2.getProcedureCharges() + p3.getProcedureCharges();
	}
}

