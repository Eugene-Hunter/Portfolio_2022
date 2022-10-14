import java.util.Scanner;

// main class
public class Recursion {

		// static attributes of the class
		static String reversed = "";
		static String fibonacci = "";
		static String[] fib;
	
	// main method	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // instantiating a new Scanner object
		
		System.out.print("Enter a sentence to see it in reverse :");
		String sentence = input.nextLine(); // variable to store the user's input
		
		int strLength = sentence.length(); // variable to store the length of the sentence i.t.o characters
		
		reverseString(sentence, strLength); // initializing the reverseString method
		
		System.out.println(reversed); // display the result of the reversed string
		
		System.out.print("Enter a number");
		int numCount = input.nextInt();  // variable to store the user's input
		

		fib = new String[numCount]; // instantiating the attributes and assign starting values
		fib[0] = "0";
		fib[1] = "1";
		fibonacci  = "\r\n" + fib[0]  + "\r\n" + fib[1];
		fibonacci = fibonacci(2);

		System.out.println(fibonacci); // display the final result
		
		input.close(); // close the scanner object
	}

	
	public static String reverseString(String oldString, int position) { // method overload for recursion of strings 

		// if statement to determine if the current position in greater than 0 and if so, assign the next character
		// to the string
		if(position > 0) {
		reversed += (String.valueOf(oldString.charAt(position - 1)));
		
		return reverseString(oldString, position - 1); // return the result back to the method
		}
		else
		{
			return reversed; // return the string to the main method
		}
	}
	
	// method to create the fibonacci list of numbers
	public static String fibonacci(int position ) {

			// If statement to determine if the current position is less than the  array length
			// and to calculate the next fibonacci number in the list
			if(position < fib.length) {

				fib[position] = String.valueOf(Integer.parseInt(fib[position - 2]) + Integer.parseInt(fib[position - 1]));
				
				fibonacci +=  "\r\n" + fib[position] ; // Add the new value to the string								
							
				position++; // increment the position variable by 1
				
				return fibonacci(Integer.valueOf(position)); // return the result back to the method
			}
			else
			{
				return fibonacci; // Return the string to the main method
			}

	}
}
