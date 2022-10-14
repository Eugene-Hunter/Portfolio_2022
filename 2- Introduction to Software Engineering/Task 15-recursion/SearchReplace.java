/*Create a file called searchReplace.java. In here, create a program that
implements a search and replace function recursively. Your program
should allow a user to enter a string, a substring they wish to find and
another string with which they wish to replace the found substring.
The output of your program should be similar to the output given below:
Please enter a string: Hello world
Please enter the substring you wish to find: llo
Please enter a string to replace the given substring: @@
Your new string is: he@@ world*/
import java.util.Scanner;

public class SearchReplace {

	static String sentence;
	static String subString;
	static String replacement;

	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);  // instantiate a Scanner object
	System.out.print("Please enter a word or a sentence: ");
	sentence = input.nextLine();
	System.out.print("Please enter the string you wish to find: ");
	subString = input.nextLine();
	System.out.print("Please enter the string to replace the given substring: ");
	replacement = input.nextLine();
	
	String newStr = searchReplace("", 0);
    
	
	// Print the result
	if (newStr.length() > 0) {
        System.out.println(newStr); 
		input.close();
		return;
	// Display a message if there is no result to display
	}
	else {
		System.out.println("No results to display.");
	}
	input.close();
	}
	/// Function to search and replace substring characters from a word or sentence
	public static String searchReplace(String newStr, int pos) {
		
		// If statement to determine if the current search position smaller
        // than the length of the string
    	if(pos < sentence.length()) {	
	        // If statement to check if the substring matches the characters
	        // at the current search index
	        // if (string.substring(pos, pos + substr.length()) == substr) {
            if(sentence.contains(subString)) {
	        		
	            // Include the replacement characters if the substring characters
	            // were found in the string to the new string
	        	int index = sentence.indexOf(subString);
	                 
	            newStr = sentence.replace(subString, replacement);
	            pos += index ;
	            // Return statement searching recursively through the string
	            //return searchReplace(string, substr, replaceWith, newStr, pos);
	            return searchReplace(newStr, pos);
	        }else
	        {
	        	pos++; // move the index one position forward
	        }
         
          	
    	}  
    	else {
        	// Else statement to return the final result
        	return newStr;
        }
          
            
        return newStr;
        
	}
}