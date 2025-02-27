/*
 * Class: CMSC203
 * Instructor: Ashique Tanveer
 * Description: MovieDriver is a simple driver utilizing the Movie class. It takes in user-input and demonstrates knowledge of loops and method calling.
 * Due: 02/28/2025
 * Platform/compiler: Eclipse IDE for Java Developers - 2024-12
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: William Keller
*/

import java.util.Scanner;

public class MovieDriverTask1 {
    public static void main(String[] args) {
        // Create a Scanner obj to read from keyboard
        Scanner scanner = new Scanner(System.in);
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

        // Print out the information using the movie’s toString method
        // haha sorry man, I am NOT printing "Goodbye" as described in the outline.
        // I am following the pseudo code requirements.
        System.out.println(movie.toString());

        scanner.close();
    }
}
