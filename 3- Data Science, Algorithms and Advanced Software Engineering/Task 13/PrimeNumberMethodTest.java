
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class PrimeNumberMethodTest {

	@Test
	void test() {
		assertTrue(PrimeNumberMethod.isPrime(11) == isPrime());
				
	}
	public int isPrime() {
		int done = 1;
		int primeYesNo = 0;
		int score = 0;
		int divisor = 2;
		try {
		System.out.print("Enter the number to check if it is a prime number or 0 to exit: ");
		Scanner input = new Scanner(System.in); 
		int number = Integer.parseInt(input.nextLine());
		if(number > 0) {
			primeYesNo = recursion(number,divisor, score);
				System.out.print(number);
				if(primeYesNo == 0) {
					System.out.println(" is a prime number.");
				}
				else if(primeYesNo != 0) {

					System.out.println(" is not a prime number.");
			}
		}
			}catch(NumberFormatException e) {

				System.out.println("Input is not recognised, please try again.");
			}
			return primeYesNo;
	}
	public static int recursion(int number, int divisor, int score) {
		
		if(number % divisor == 0  && divisor < number) {
			score += 1;
			return recursion(number,divisor + 1 , score);

		}
		else if(number % divisor == 1 && divisor <= number) {
			return recursion(number,divisor + 1 , score);
		}
		return score;
	}
}
