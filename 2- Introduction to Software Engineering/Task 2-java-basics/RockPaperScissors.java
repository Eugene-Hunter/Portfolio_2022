import java.util.Scanner;
//import Scanner util to allow user input


public class RockPaperScissors{
// initializing the class
	
	public static void main(String[] args10) {
		// initializing the main method
		
		System.out.println("Best out of 5 - Rock, Paper, Scissors! ");
		int best_of_5 = 1;
		int user_score = 0;
		int computer_score = 0;
		int tie = 0;
		do {
			System.out.println(best_of_5 + ") Enter the following : 0 = Rock, 1 = Paper, 2 = Scissors: ");
		// Request user to enter either 0, 1 or 2 as option
		
			Scanner input = new Scanner(System.in);
			// Initializing the Scanner object
			
			int choice = input.nextInt();
			// Variable to save user input;
				
			int computer = (int)(Math.random() * 10);
			//Variable to store the random value
				
			// do/while loop retrieve a random value between 0 and 2
			do {
				// if function to determine if the random number is between 0 and 2
				if (computer > 2) {
					
					// random number is generated
					computer = (int)(Math.random() * 10);					
				}
				// else if the number is between 0 and 2
				else{
					// Display the value of the computer variable
					System.out.println("Computer: " + computer);
					// Display the computer input
					break;					
					}
				}while (computer >= 0);

		// Switch statement to switch between the user input response and compare it to the 
		// the possible computer responses 
		switch(choice) {
			
			case 0: //Rock
				if(computer == 2) { 
					System.out.println("You win, rock beats scissors ");
					user_score += 1;
				}
				else if (computer == 1) {
					System.out.println("Sorry, you lose, paper beats rock");
					computer_score += 1;
				}
				else {
					System.out.println("Rock vs Rock : It's a tie");
					tie += 1;
				}
			
				break;
				
			case 1: // Paper
				if(computer == 0) {
					System.out.println("You win, paper beats rock ");
					user_score += 1;
				}
				else if (computer == 2) {
					System.out.println("Sorry, you lose, scissors beats paper");
					computer_score += 1;
				}
				else {
					System.out.println("Paper vs Paper : It's a tie");
					tie += 1;
				}
			
				break;
			case 2: // Scissors
				if(computer == 1) {
					System.out.println("You win, scissors beats paper ");
					user_score += 1;
				}
				else if (computer == 0) {
					System.out.println("Sorry, you lose, rock beats scissors");
					computer_score += 1;
				}
				else {
					System.out.println("Scissors vs Scissors : It's a tie");
					tie += 1;
				}
				
				break;
			default: // Incorrect input
				System.out.println("Please select either 0, 1 or 2");
				best_of_5 -= 1;				
			}
		
		// Display the final results
		System.out.println("\nThe final scores:\n");
		System.out.println("You: " + user_score);
		System.out.println("Computer: " + computer_score);
		System.out.println("Ties: " + tie);
		best_of_5 += 1;
				

	}while(best_of_5 <= 5);
	// do/while loop to play multiple rounds
	System.out.println("\n");
	
	System.out.println("Thanks for playing. Good-bye.");
		
		//System.out.println(computer);
		// Display the user input
		

	}
	
	
	
}

