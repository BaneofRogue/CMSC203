package myself;

import java.util.Scanner;

public class MovieDriver_Task2 {
		public static void main(String[] args) {
	        // Create a Scanner obj to read from keyboard
	        Scanner scanner = new Scanner(System.in);

	        // Loop to handle multiple movie entries
	        String continueInput = "y";

	        while (continueInput.equalsIgnoreCase("y")) {
	            // Create a new movie obj
	            Movie movie = new Movie();

	            // Prompt the user to enter the title of a movie
	            System.out.println("Enter the name of a movie");
	            // Read in the line that the user types
	            String title = scanner.nextLine();
	            // Set the title in the movie obj
	            movie.setTitle(title);

	            // Prompt the user to enter the movie rating
	            System.out.println("Enter the rating of the movie");
	            // Read line that the user inputs
	            String rating = scanner.nextLine();
	            movie.setRating(rating);

	            // Prompt the user to enter the number of tickets sold
	            System.out.println("Enter the number of tickets sold");
	            // Read in the int that the user inputs
	            int ticketsSold = scanner.nextInt();
	            scanner.nextLine(); // To consume the newline character
	            movie.setSoldTickets(ticketsSold);
	            
	            System.out.println(movie.toString());

	            // Ask the user if they want to enter another movie
	            System.out.println("Do you want to enter another? (y or n): ");
	            continueInput = scanner.nextLine();
	        }

	        // Print Goodbye message when the loop ends
	        System.out.println("Goodbye");

	        // Close the scanner
	        scanner.close();
	    }
}