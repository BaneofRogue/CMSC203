/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: ESPGame is a guessing game. Very simple but success will demonstrate comprehension of the first few chapters.
 * Due: 02/17/2025
 * Platform/compiler: Eclipse IDE for Java Developers - 2024-12
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: William Keller
*/

package myself; // necessary to have a package to create a working class file.
import java.util.Random; // used for random number generation
import java.util.Scanner; // used for user inputs
import java.io.*; // used for file handling

public class ESPGame {
	public static void main(String[] args) throws FileNotFoundException {
		// Define and init a new scanner object to handle inputs.
		Scanner scanner = new Scanner(System.in);
		Random random = new Random(); // create "random" object for random nums later.
		
		boolean quit = false; // this is just so that it will take the quit path.
		
		String name = "", sentence = "", due = ""; // data which will be used at the end of the program
		int roundNum = 0, roundWon = 0; // data to track round data.
		
		
		// constants who's names are self explanatory and used for matching switch later on.
		final String COLOR_BLACK = "Black",
	             COLOR_WHITE = "White",
	             COLOR_GRAY = "Gray",
	             COLOR_SILVER = "Silver",
	             COLOR_MAROON = "Maroon",
	             COLOR_RED = "Red",
	             COLOR_PURPLE = "Purple",
	             COLOR_FUCHSIA = "Fuchsia",
	             COLOR_GREEN = "Green",
	             COLOR_LIME = "Lime",
	             COLOR_OLIVE = "Olive",
	             COLOR_YELLOW = "Yellow",
	             COLOR_NAVY = "Navy",
	             COLOR_BLUE = "Blue",
	             COLOR_TEAL = "Teal",
	             COLOR_AQUA = "Aqua";
		
		//Introduction
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		System.out.println("Welcome to ESP - extrasensory perception!");
		
		do {
			// open color.txt and leave the handle open for later usage
			Scanner fileReader = new Scanner(new FileReader("colors.txt"));
			
			//define and init variables for further usage
			int option = 0,
				firstNums = 0; // value which will show how many items to print	
			
			String guess = "", botGuess = ""; // empty guess for later
			
			System.out.println("Would you please choose one of the 4 options from the menu:\n");
			
			System.out.println("1- read and display on the screen first 16 names of colors from a file colors.txt, so the player can select one of them names of colors.\n"
					+ "2- read and display on the screen first 10 names of colors from a file colors.txt, so the player can select one of them names of colors.\n"
					+ "3- read and display on the screen first 5 names of colors from a file colors.txt, so the player can select one of them names of colors.\n"
					+ "4- Exit form the program\n"); 
			/* THERE ARE TYPOS!! ***HOWEVER*** the assignment description states: 
			  "The program should display the following menu", which I did.
			*/
			
			do {
				System.out.printf("Enter the option: ");
				
				option = scanner.nextInt(); // gather int for option.
				scanner.nextLine(); // after using nextInt, consume the new line.
				
				// Print a response according to option(handle value of option).
				switch(option) {
					case 1:
						firstNums = 16;
						System.out.println("There are sixteen colors from a file:\n");
						break;
						
					case 2:
						firstNums = 10;
						System.out.println("There are ten colors from a file:\n");
						break;
						
					case 3:
						firstNums = 5;
						System.out.println("There are five colors from a file:\n");
						break;
						
					case 4:
						quit = true;
						break;
						
					default:
						
						System.out.println("The input must be within 1-4\n"); // error message
						break;
				}
			} while (option < 1 || option > 4);
			
			if(!quit) {
				// List the colors according to the firstNums variable
				for(int index = 0; index < firstNums; index++) {
					System.out.printf("%d %s\n"
							,(index+1)
							,fileReader.nextLine());
					} // index+1 is used since index starts at 0.
				// iterating through the "list" in the text.
				
				while(roundNum < 3) {	 // make sure it is not going on more than 3 rounds.
					
					roundNum++; 
					System.out.printf("\nRound %d\n", roundNum); // Round info
					
					System.out.println("I am thinking of a color.");
					System.out.println("Is it one of list of colors above?");
					System.out.println("Enter your guess:");
	
					guess = scanner.nextLine(); // Now read the actual guess
					
					//generate a guess
					int botGuessIndex = random.nextInt(firstNums) + 1;
		            switch (botGuessIndex) {
		                case 1: botGuess = COLOR_BLACK; break;
		                case 2: botGuess = COLOR_WHITE; break;
		                case 3: botGuess = COLOR_GRAY; break;
		                case 4: botGuess = COLOR_SILVER; break;
		                case 5: botGuess = COLOR_MAROON; break;
		                case 6: botGuess = COLOR_RED; break;
		                case 7: botGuess = COLOR_PURPLE; break;
		                case 8: botGuess = COLOR_FUCHSIA; break;
		                case 9: botGuess = COLOR_GREEN; break;
		                case 10: botGuess = COLOR_LIME; break;
		                case 11: botGuess = COLOR_OLIVE; break;
		                case 12: botGuess = COLOR_YELLOW; break;
		                case 13: botGuess = COLOR_NAVY; break;
		                case 14: botGuess = COLOR_BLUE; break;
		                case 15: botGuess = COLOR_TEAL; break;
		                case 16: botGuess = COLOR_AQUA; break;
		            }
		            System.out.printf("I was thinking of %s.\n", botGuess);
		            if(botGuess.equalsIgnoreCase(guess)) { // ignore case "blaCK" == "black" == "BLACK"
		            	roundWon++; // because they guessed it correctly.
		            }
				}
				System.out.println("Game Over\n");
				System.out.println("You guessed " + roundWon + " out of 3 colors correctly.\n");
				roundNum = 0; // reset after round
				
				do {
					System.out.println("Would you like to continue a Game? Type Yes/No");
					
				    String input = scanner.nextLine().toLowerCase(); // to match

				    if (input.equals("yes")) {
				        quit = false;
				        break;
				    } else if (input.equals("no")) {
				        quit = true;
				        break;
				    } else {
				    	// error message
				        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
				    }
				} while (true); // loop until killed
				
			}
			
		} while (quit == false);
		
		// Print and handle the end credits
		
		// create file/make sure file exists
		// create a writer handle
		File outputFile = new File("EspGameResults.txt");
		PrintWriter writer = new PrintWriter(outputFile);
		
		System.out.printf("\nEnter your name: ");
		
		name = scanner.nextLine();
		
		System.out.printf("Describe yourself: ");
		sentence = scanner.nextLine();
		
		System.out.printf("Due Date: ");
		due = scanner.nextLine();
		
		// print data to text file
		writer.println("Game Over");
		writer.printf("You guessed %d out of 3 colors correctly.\n", roundWon);
		writer.println("Due Date: " + due);
		writer.println("Username: " + name);
		writer.println("User Description: " + sentence);
		writer.println("Date: 2/17/25"); // the assignment states to only ask for the due date.
		
		System.out.printf("You guessed %d out of 3 colors correctly.\n", roundWon);
		System.out.println("Due Date: " + due);
		System.out.println("Username: " + name);
		System.out.println("User Description: " + sentence);
		System.out.println("Date: 2/17/25");
		
		System.out.printf("You won %d of 3 rounds.\n", roundWon);
		
		// clean up after itself by closing the files.
		writer.close();
		scanner.close();
		
		// its in the rubric
		System.out.println("PROGRAMMER: William Keller");
	}
}
