import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleCalculator {

	private static ArrayList<String> calculations = new ArrayList<>();
	/* Method to add the 2 numbers and display the result and to save the equation the 
	 * calculations array */
	public static void add(int firstValue, int secondValue) {				
		System.out.print("\t+++ Addition +++\r\n\r\n");
	
		try {
			int result = firstValue + secondValue;
			System.out.format("%s %s %s = %s%n", firstValue, "+", secondValue, result);
			String toFile= String.format("%s %s %s = %s", firstValue, "+", secondValue, result);
			saveToFile(toFile);
		}catch(NumberFormatException e) {
			System.out.println("Please enter a valid number.");
		}
	}
	/* Method to divide the 2 numbers and display the result, and to save the equation the 
	 * calculations array */
	public static void division(int firstValue, int secondValue) {			
		System.out.print("\t/// Division ///\r\n\r\n");
		try {
			double result = (double) firstValue / secondValue;

			System.out.format("%s %s %s = %s%n", firstValue, "/", secondValue, result);
			String toFile= String.format("%s %s %s = %s", firstValue, "/", secondValue, result);
			saveToFile(toFile);
		}catch(ArithmeticException e) {
			System.out.println("Zero Division delivered no result");
		}catch(NumberFormatException e) {
			System.out.println("Please enter a valid number.");
		}
	}

	public static void main(String[] args) {		
	
		try (Scanner input = new Scanner(System.in)) {
			int firstValue = 0;
			int secondValue = 0;
			int option = -1;

			do {
				System.out.println("");
				System.out.print("What would you like to do?\r\n"
						+ "1) Addition\r\n"
						+ "2) Subtraction\r\n"
						+ "3) Multiplication\r\n"
						+ "4) Division\n"
						+ "0) Exit: ");

				try {
					option = Integer.parseInt(input.nextLine());

					if(option > 0  && option < 5) {
						System.out.print("Enter 1st number: ");
						firstValue = Integer.parseInt(input.nextLine());
						System.out.print("Enter 2nd number: ");
						secondValue = Integer.parseInt(input.nextLine());
						System.out.println("");
					}
					switch(option) {
					case 1:
						add(firstValue, secondValue);
						break;
					case 2:
						subtract(firstValue, secondValue);
						break;
					case 3:
						product(firstValue, secondValue);
						break;
					case 4:
						division(firstValue, secondValue);
						break;
					case 0:// exit the program 
						System.out.println("Good-bye");
						System.exit(0);
						break;
					default:
						System.out.print("The option enter is not recognised, please try again");
						break;
					}
					System.out.println();
				}catch(NumberFormatException e) {
					System.out.print("The option entered is not recognised, please try again");
				}
			}while(option != 0);
		}
	}
	/* Method to multiply the 2 numbers and display the result and to save the equation the 
	 * calculations array */
	public static void product(int firstValue, int secondValue) {				

		System.out.print("\t*** Multiplication ***\r\n\r\n");
		try { 
			int result = (firstValue * secondValue); 
			System.out.format("%s %s %s = %s%n", firstValue, "x", secondValue, result);
			String toFile= String.format("%s %s %s = %s", firstValue, "*", secondValue, result);
			saveToFile(toFile);
		}catch(NumberFormatException f) {
			System.out.println("Please enter a valid number.");
		}catch(Exception f) {
			System.out.println("The system recovered from the following fatal error:");
			System.out.println(f);
		}
	}
	/* Method to append the calculations to a file */
	private static void saveToFile(String calculation) {

			try (FileWriter fileIn = new FileWriter("calculations.txt", true);
					BufferedWriter bufferedWriter = new BufferedWriter(fileIn);
					PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
					printWriter.println(calculation);
				
				System.out.println("The information was saved successfully");
				
		}catch(IOException e) {
			System.out.println(e + ". The file was not saved.");
		}
	}
	/* Method to subtract the 2 numbers and display the result and to save the equation the 
	 * calculations array */
	public static void subtract(int firstValue, int secondValue) {				
		System.out.println("\t--- Subtraction ---\r\n\r\n");

		try {
			int result = (firstValue - secondValue);
			System.out.format("\t%s - %s = %s%n",firstValue, secondValue, result);
			String toFile= String.format("%s %s %s = %s", firstValue, "-", secondValue, result);
			saveToFile(toFile);
		}catch(NumberFormatException e) {
			System.out.println("Please enter a valid number.");
		}catch(Exception f) {
			System.out.println("The system recovered from the following fatal error:");
			System.out.println(f);

		}

		
	}

}

