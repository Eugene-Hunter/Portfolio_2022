import java.util.Scanner; // import the Scanner object

// main class
public class GCDRecursion {

	// main method
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // instantiate a new Scanner object
		
		System.out.print("Enter the first number: ");
		int num1 = Integer.parseInt(input.nextLine()); // variable to store the user input

		System.out.print("Enter the second number: ");
		int num2 = Integer.parseInt(input.nextLine()); // variable to store the user input
		int pos = 1;
		int highest = 0;
		int gcd = gcdRecursion(num1, num2, pos, highest);
		
		System.out.print("The greatest common denominator: "+ gcd);
		
		input.close(); // close the Scanner object
	}
	
	// recursive method to return the greatest common denominator
	public static int gcdRecursion(int num1, int num2, int pos, int highest) {
	
		// if statement to determine if the current position is less than the 2 variables
		if(pos < num1 & pos < num2) {
			int num_1 = num1 % pos; // variable to store the first result 
			int num_2 = num2 % pos; // variable to store the second result
			System.out.println(num_1 + " : " + num_2);
			if (num_1 == 0 & num_2 == 0) { // if statement to determine if both values are equal to 0
										  // and assign the current position to the highest variable
				highest = pos;
				
			}
			pos++; // increase the position by 1
			
			return gcdRecursion(num1, num2, pos, highest); 

		}
		else {
			return highest;
		}
	}
	//  System.out.println();
}
