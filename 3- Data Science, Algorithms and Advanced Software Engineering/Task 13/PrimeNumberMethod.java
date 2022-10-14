

/**
 * @author Eugene Hunter
 *
 *A prime number is a positive integer greater than 1 with no positive
divisors besides 1 and itself
Create a method called isPrime that determines whether a given number
is prime.
Write a test class to test the method isPrime.

 */
public class PrimeNumberMethod {
	private int userInput;
	public PrimeNumberMethod(int userIn) {
		this.setUserInput(userIn);
	}
	
	
	public int getUserInput() {
		return userInput;
	}


	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}


	public static int isPrime(int userIn) {

		int primeYesNo = 0;
		int score = 0;
		int divisor = 2;
		try {
		if(userIn > 0) {
			primeYesNo = recursion(userIn,divisor, score);
				System.out.print(userIn);
				if(primeYesNo == 0) {
					System.out.println(" is a prime number.");
				}
				else if(primeYesNo > 0) {

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


