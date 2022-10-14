import java.util.Scanner;


public class Factorial {
	
	public static void main(String[] args) {
		//Get user input save to variable
		System.out.println("Enter any positive whole number:");
		Scanner user_input = new Scanner(System.in);
		int response = user_input.nextInt();
		int count = 1; // Variable to store the counter 
		int result = 1; // variable to store the result of each recursion
		String factorial_list = " " + (count);
		
		// while loop to check if the counter has not reached the end
		while (count != response) {
			count += 1;
			
			result = (recursion(result, count)); // Recursion of the numbers
			factorial_list += " * " + (count); // string to display list of numbers used in the recursion
		}

		// Display output
		System.out.println("Factorial numbers: " + factorial_list + " = " + result);
		
		
	}
	public static int recursion(int result, int next_value) {
	// Recursion function to determine the product of the list of values
		return result * next_value ;
		
	}
}
