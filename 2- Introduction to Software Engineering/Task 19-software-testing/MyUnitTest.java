import java.util.Scanner;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

public class MyUnitTest {
	
	//  Instantiating myTest object
	private static MyUnitTest myTest;
	
	
	// main method
	public static void main(String[] args) {
		
		myTest = new MyUnitTest(); // Instantiating myUnitTest method
		Scanner input = new Scanner(System.in); // Instantiating the Scanner object
		System.out.print("Enter the year you were born: ");
		int yearB = Integer.parseInt(input.nextLine()); // variable to store the user input
		int answer = myTest.ageCalculator(yearB); // calling the calculator method and storing the result
		Tester.testAge(yearB, answer); // Instantiating the Tester method
		input.close(); // close Scanner object
	
	}
	// Age calculator method
	public int ageCalculator(int yearBorn) {
		
		int result = 2022 - yearBorn;  // variable to store the calculation result
		  // if statement to check if result is within the 1 to 130 number range 
		  if(result < 131) {
			System.out.print("You are " + result + " years old");
			return	(result); // return the result
		}
		return 0; // otherwise return 0 and continue to run testAge method		
	}
	
}
// Tester class
class Tester{
	
	@Test  // Test Annotation to test input value
	public static void testAge(int yearBorn, int age) {
		
		// try catch clause to catch the exception error if the assertion evaluate to false
		try {
		assertTrue(age < 131 & age > 0); 
		}catch(AssertionError e) { // catch clause if the AssertionError is encountered
			System.out.println("The value " + yearBorn + " is not within the range of 1892 to 2021");
		}
			
	}
	
}
