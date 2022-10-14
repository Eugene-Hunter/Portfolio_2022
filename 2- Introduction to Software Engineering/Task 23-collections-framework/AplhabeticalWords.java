import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Scanner;
import java.util.Formatter;

// Main class
public class AplhabeticalWords{
	
	// main method
	public static void main(String[] args) {
		List<String> fetchList = ReadWriteToFile.readFromFile();	
		System.out.println(fetchList);
	}
}
// Class to read from the file and 
class ReadWriteToFile {
		// Constructor method 
		private ReadWriteToFile() {
			readFromFile(); // initialize the readFromFIle method
		}
		// readFromFile method to retrieve the list of words from a file and sort the words 
		// in alphabetical order
		public static List<String> readFromFile() {
			
			System.out.println("Reading from file");			
			List<String> fromFile = new ArrayList<>(); //arraylist to store an unknown number of values		
			try { // try clause to catch any fatal errors and display a more friendly message to the user
				File randomWordsTxt = new File("randomWords.txt"); // instantiating a File object
				try (Scanner fileData = new Scanner(randomWordsTxt)) {
					while(fileData.hasNext()) { // while loop to determine the end of the file
						String toStr = fileData.nextLine(); // variable to store a single line of text 
															// from the file
						fromFile.add(toStr); // string added to the arraylist
					}
				}
			}
			catch(Exception e){ // Exception catch clause to catch all fatal errors and display a generic
								// generic message	
				System.out.print("Error occured: ");
				System.out.println(e);
			}		
			fromFile.sort(null); // natural sorting of the list of words
			return fromFile; // Return to the main method with the result
		}
		}
