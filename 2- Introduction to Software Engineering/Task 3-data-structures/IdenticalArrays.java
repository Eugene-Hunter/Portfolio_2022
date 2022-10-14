import java.util.ArrayList;
import java.util.Scanner;
// import the scanner library to enable user input
// import the ArrayList library to use with arrays of undetermined size

// Main class
public class IdenticalArrays {
		
		// Main method
		public static void main(String[] args) {

			ArrayList<Integer> num_array1, num_array2 = new ArrayList<Integer>(); // arrays to store user input
						
			// Initialize an array to store the list of variables
			num_array1 = numArray();
			num_array2 = numArray();
			
			// variable to store the outcome of the comparison
			boolean result = (num_array1.equals(num_array2));

			// Display output
			System.out.println("\nArray 1: " + num_array1);
			System.out.println("Array 2: " + num_array2);
			
			if (result == true) {
				System.out.println("\nThe arrays are identical.");
				
			}
			else {
				System.out.println("\nThe arrays are not identical.");
			}
			

		}
		
	public static ArrayList<Integer> numArray() {
		
		int number = 0;
		int count = 0;
		ArrayList<Integer> num_array = new ArrayList<Integer>(); // array to store user input
		Scanner input = new Scanner(System.in);
		// Initialize Scanner method 
		System.out.println("Enter a list of numbers: ");
		// Do/While loop statement to check if the integer value entered is greater than 0
		do {

			number = input.nextInt(); // local variable storing the individual integers
			
			// If statement to determine if the user entered 0 to exit
			if (number != 0) { 

				num_array.add(number); // Saving a list of all the integers
				count += 1;	// increment the counter by 1
			}
			else { // else statement to run if user entered 0

				break;
			}

		}while(number != 0); 

		return num_array;
	}
}
