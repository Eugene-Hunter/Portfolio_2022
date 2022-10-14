import java.util.Scanner;
// Import the Scanner library

// Main class
public class Grades {
		
		// main method
		public static void main(String[] args) {
			System.out.println(" Enter your 5 grade marks to get your average");
			float avg = 0; // Variable to store the average value of the marks
			int total = 0; // Variable to store the sum of the marks
			// Initialize the Scanner method
			Scanner input = new Scanner(System.in);
			
			// Initialize array with place for 5 values
			int[] myTestResults = new int[5];
			
			// for loop to allow user to insert the 5 marks
			for (int x = 0; x < myTestResults.length; x++) {
				System.out.println("Mark " + (x + 1) + ": ");
				// User enters new mark
				myTestResults[x] = input.nextInt();	
				total += myTestResults[x];
			}
			input.close();
			// Close the Scanner method
			
			// Variable to store the average mark
			avg = total / myTestResults.length;
			
			// if/else statements to assign a symbol to the average vlaue
			if (avg < 50) {
				System.out.println("F average");
				
			}
			else if(avg < 60) {
				System.out.println("D average");}
			else if(avg < 70) {
				System.out.println("C average");
				
			}
			else if(avg < 80) {
				System.out.println("B average");
				
			}
			else {
				System.out.println("A average");
				}

		}
		
}
