/*
 *TODO - Create a new java file called MyFile.java
Write code to read the content of the text file input.txt. For each line in
input.txt, write a new line in the new text file output.txt that computes
the answer to some operation on a list of numbers.
If the input.txt has the following:
Min: 1,2,3,5,6
Max: 1,2,3,5,6
Avg: 1,2,3,5,6
Your program should generate output.txt as follows:
The min [1, 2, 3, 5, 6] is 1.
The max of [1, 2, 3, 5, 6] is 6.
The avg of [1, 2, 3, 5, 6] is 3.4.
Assume that the only operations given in the input file are min, max and
avg and that a list of comma-separated integers always follows the
operation. You should define the functions min, max and avg that take in
a list of integers and return the min, max or avg of the list.
Your program should handle any combination of operations and any
length of input numbers. You can assume that the list of input numbers
are always valid integers and that the list is never empty.
Compile, save and run your file.
 *
 */

import java.util.Scanner;
import java.util.Formatter;
import java.io.File;
import java.util.ArrayList;
public class MyFile {
	

	//method to read from file
	public static ArrayList<String> readFromFile() {

		System.out.println("Reading from file");
		
		ArrayList<String> fromFile = new ArrayList<String>(); //arraylist to store an unknown number of values		

		try { // try clause to catch any fatal errors and display a more friendly message to the user
			File inputTxt = new File("input.txt"); // instantiating a File object
			Scanner fileIn = new Scanner(inputTxt); // instantiating a Scanner objecr
			while(fileIn.hasNext()) { // while loop to determine the end of the file
				String toStr = fileIn.next(); // variable to store a single line of text from the file
				fromFile.add(toStr); // string added to the arraylist
			}

			fileIn.close(); // close the Scanner object
		}
		catch(Exception e){ // Exception catch clause to catch all manner of fatal errors and display a generic
							// generic message
			
			
			System.out.print("Error occured: ");

			System.out.println(e);
		}
		
		return fromFile; // Return to the main method with the result
	}
	
	// method to save the information to a file
	public static void writeToFile(ArrayList<String> toFile) {
		try { // try clause to catch any fatal errors and display a more friendly message to the user
			Formatter F = new Formatter("output.txt"); // instantiate a Formatter object to save the information 
													   // to file
			// for loop to cycle through the arraylist
			for(int x = 0; x < toFile.size(); x++) {
				F.format("%s", ("" + toFile.get(x) + "\r\n"));// saving the string to file
			
			
			}
			F.close(); // close the Formatter object
		}
		catch(Exception e) {// Exception catch clause to catch all manner of fatal errors and display a generic
			// generic message
			System.out.print("Error occured: ");

			System.out.println(e);
		}
		
	}
	// method to retrieve and display the smallest number
	public static String getMin(String minValue) {

		System.out.println("getMin: ");
		minValue = minValue.substring(4); // variable to store only the array of numbers in the string
		String[] min = minValue.split(","); // split the string into single numbers
		int lowest = Integer.valueOf(min[0]); // initialize the variable with the first number in the array
		//for loop to cycle through the array starting from the number thats second in the list
		for(int x = 1; x < min.length; x++) {
			// if statement to determine if the current number is smaller than the number stored in the
			//least variable to the current number if so
			if (Integer.valueOf(min[x]) < Integer.valueOf(lowest)) { 
				lowest = Integer.valueOf(min[x]);
			}
		}
		
		System.out.println("The minimum value of [" + minValue.toString() + "] is " + lowest);
		
		// Saving the final result in a formatted string
		String toFile = "The minimum value of [" + minValue.toString() + "] is " + lowest;
		
		return toFile; // Return to the main method with the result
	}
	public static String getMax(String maxValue) {

		System.out.println("getMax: ");

		maxValue = maxValue.substring(4); // variable to store only the array of numbers in the string
		String[] max = maxValue.split(",");// split the string into single numbers
		int most = Integer.valueOf(max[0]); // initialize the variable with the first number in the array
		//for loop to cycle through the array starting from the number thats second in the list
		for(int x = 1; x < max.length; x++) {
			// if statement to determine if the current number is larger than the number stored in the
			//most variable to the current number if so
			if (Integer.valueOf(max[x]) > Integer.valueOf(most)) {
				most = Integer.valueOf(max[x]);
			}
		}
		//Display the result on-screen
		System.out.println("The maximum value of [" + maxValue.toString() + "] is " + most);
		
		// Saving the final result in a formatted string
		String toFile = "The maximum value of [" + maxValue.toString() + "] is " + most;
		
		return toFile; // Return to the main method with the result
	}
	public static String getSum(String sumValue) {

		System.out.println("getSum: ");

		sumValue = sumValue.substring(4); // variable to store only the array of numbers in the string
		
		String[] max = sumValue.split(",");// split the string into single numbers
		
		int total = Integer.valueOf(max[0]); // initialize the variable with the first number in the array
		
		//for loop to cycle through the array starting from the number thats second in the list
		for(int x = 1; x < max.length; x++) {
			
			// if statement to determine if the current number is larger than the number stored in the
			//most variable to the current number if so
			if (Integer.valueOf(max[x]) > Integer.valueOf(total)) {
				
				total = Integer.valueOf(max[x]);
			}
		}
		//Display the result on-screen
		System.out.println("The maximum value of [" + sumValue.toString() + "] is " + total);
		
		// Saving the final result in a formatted string		
		String toFile = "The maximum value of [" + sumValue.toString() + "] is " + total;
		
		return toFile; // Return to the main method with the result
	}
	public static String getAvg(String avgValue) {

		System.out.println("getAvg: "); 
		
		avgValue = avgValue.substring(4); // variable to store only the array of numbers in the string
		
		String[] avgVal = avgValue.split(","); // split the string into single numbers
		int avg = 0;
		//for loop to cycle through the array of numbers
		for(int x = 0; x < avgVal.length; x++) {
			avg += Integer.valueOf(avgVal[x]); // adding all the numbers together
			}
		avg = avg / 2; // Divide the number by 2 to get the average

		//Display the result on-screen
		System.out.println("The average value of [" + avgValue.toString() + "] is " + avg);
		
		// Saving the final result in a formatted string
		String toFile = "The average value of [" + avgValue.toString() + "] is " + avg;
		
		return toFile; // Return to the main method with the result
	}
	public static String getPercentile(String values, String percentage) {
		// The 90th percentile of [1,2,3,4,5,6,7,8,9,10] is 9.

		System.out.println("getPercentile: ");
		values = values.substring(4);   // variable to store only the array of numbers in the string
		String[] prcntVal = values.split(","); // split the string into single numbers
		int numlength = prcntVal.length; // variable to save the length of the string 

		// variable to store the result
		int prcntg =  Math.round((numlength * Integer.valueOf(percentage)) / 100f);
		
		//Display the result on-screen
		System.out.println("The " + percentage + "th percentile value of [" + values.toString() + "] is " + prcntg);
		
		// Saving the final result in a formatted string		
		String toFile = "The " + percentage + "th percentile value of [" + values.toString() + "] is " + prcntg;
		
		return toFile; // Return to the main method with the result
	}


	public static void main(String[] args) {
	
		// Instantiate Arraylist objects that store an unknown number of records
		ArrayList<String> fileContent = new ArrayList<String>();
		ArrayList<String> sendToFile = new ArrayList<String>();
		fileContent = readFromFile(); // calling the readFromFile method
		System.out.println();
		
		// For loop to cycle through the arrayList containing all the results
		for (int x = 0; x < fileContent.size(); x++) {
			System.out.println();
			// if statement to determine if the string contains "min"
			if(fileContent.get(x).contains("min:")) { 
				
				// calling the getMin() method and adding the result to the Arraylist
				sendToFile.add(getMin(fileContent.get(x)));
			}
			 // else if statement to determine if the string contains "max"
			else if(fileContent.get(x).contains("max:")) {
				// calling the getMax() method and adding the result to the Arraylist
				sendToFile.add(getMax(fileContent.get(x)));
			}
			// else if statement to determine if the string contains "avg"
			else if(fileContent.get(x).contains("avg:")) { 
				// calling the getAvg() method and adding the result to the Arraylist
				sendToFile.add(getAvg(fileContent.get(x)));
			}
			// else if statement to determine if the string contains "sum"
			else if(fileContent.get(x).contains("sum:")) { 
				// calling the getSum method and adding the result to the Arraylist
				sendToFile.add(getSum(fileContent.get(x)));
			}
			// else if statement to determine if the string contains "p"
			else if(fileContent.get(x).contains("p")) { 
				// calling the getPercentile()  method and adding the result to the Arraylist
				String sub = fileContent.get(x).substring(1, 3);
				sendToFile.add(getPercentile(fileContent.get(x), sub));
			}
			
			
		}


	writeToFile(sendToFile); // send the Arraylist to the writeToFile method
	}
}
