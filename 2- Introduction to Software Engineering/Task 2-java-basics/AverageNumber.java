import java.util.Scanner;
import java.util.ArrayList;


public class AverageNumber {

	public static void main(String[] args){
	// Main method
		Scanner input = new Scanner(System.in);
		// Initializing the scanner variable to accept user input
		
		int count = 1; // Variable to store the current count the number of integers
					   // in the array
		int total = 0; // variable to store the sum of the number
		
		System.out.println("Enter any number of integers and 0 to stop: ");
		// Display the request for the number of integers

		ArrayList<Integer> num_array = new ArrayList<Integer>();
		// Initialize an array to store the list of variables
		
		int number = 0;
		
		// Do/While loop statement to check if the integer value entered is greater than 0
		do {

			number = input.nextInt(); // local variable storing the individual integers
			
			// If statement to determine if the user entered 0 to exit
			if (number != 0) { 
				total += number; // adding up all the integers as they entered
				num_array.add(number); // Saving a list of all the integers
				count += 1;	// increment the counter by 1
			}else { // else statement to run if user entered 0
				break;
			}
		
		}while(number != 0); 
		
		int avg = total / ((int)num_array.size());
		// Calculating the average of the numbers entered.
		
		// Display output
		System.out.println("\nThe list of numbers are " + num_array);			
		System.out.println("\nThe total is " + total);			
		System.out.println("\nThe average is " + avg);
	}
}
