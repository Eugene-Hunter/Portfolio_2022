import java.util.Scanner;
// import the Scanner library to enable user input

// Main class
public class SumElements {
	

		// Main method
		public static void main(String[] args) {
			
			System.out.println("Enter 3 sets with 4 values:");
			
			float[][] numbers = new float[3][4];
			//3 rows
			//4 columns
		Scanner input = new Scanner(System.in);
		// Initialize the Scanner method to allow user input
		
		// Nested For loops to get user to input 4 sets of values at a time 3 times
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter 4 values:");
			for (int j = 0; j < 4; j++) {
				numbers[i][j] = input.nextFloat();
			}
			
		}
		System.out.println("\n");
		System.out.println("----------------------------------------");
		// Nested for loops to display the result in table format
		for (int k = 0; k < 3; k++) {
			String row = "";
			for (int l = 0; l < 4; l++) {
				row += numbers[k][l] + "\t";
			}
			System.out.println("\t" + row);
			
		}		
		String col = "";
		
		System.out.println("----------------------------------------");
		
		// Nested for loops to add up and display the total of each column.
		for (int m = 0; m < 4; m++) {
			float col_total = 0 ;
			for (int n = 0; n < 3; n++) {
				col_total += numbers[n][m];

			}
			// storing the result in a String format
			col += col_total + "\t" ;
			
		}	
		// Display the result
		System.out.println("Totals\t" + col);	
		System.out.println("----------------------------------------");
		// System.out.println(col);
	}
}
