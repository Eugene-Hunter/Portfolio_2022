import java.util.Scanner;


// Main class
public class WhatDoesThisAppDo {
	
	// Main method
	public static void main(String[] args) {
		
		// static variable use to limit the number of questions
		final int NUMBER = 5;
		
		// Variables to store the numbers and start time
		int correct = 0; int count = 0; long startTime = System.currentTimeMillis();
		String question = " "; 
		Scanner input = new Scanner(System.in);
		
		// while loop to randomize the numbers and sort the numbers in descending order 
		// count the number of iterations within the scope of the loop
		while (count < NUMBER) {
			int number1 = (int)(Math.random() * 10);
			int number2 = (int)(Math.random() * 10);
			if (number1 < number2) {
				int temp = number1; number1 = number2; number2 = temp;
		}
		// Display the deduction question
		System.out.print("What is " + number1 + " - " + number2 + "? ");
		int answer = input.nextInt();
		input.close();
		// if loop to determine if the input that the users entered is correct
		if (number1 - number2 == answer) { 
			System.out.println("You are correct!");
			correct++; // Increase the correct answer count variable by 1
			}
		else
			System.out.println("Your answer is wrong.\n" + number1
					+ " - " + number2 + " should be " + (number1 - number2));
		
			count++; // increase the counter variable by 1
			
			question += "\n" + number1 + "-" + number2 + "=" + answer +
					((number1 - number2 == answer) ? " correct" : " wrong");
					// variable storing the result of the short-hand if/else statement
					
		}
		// Variable to store the end time of the 5 deduction questions
		long endTime = System.currentTimeMillis();
		
		// Variable to store the total time taken to complete the 5 questions
		long testTime = endTime - startTime;
		
		//Display the result
		System.out.println("Correct count is " + correct +
		"\nTest time is " + testTime / 1000 + " seconds\n" + question);
	}
}