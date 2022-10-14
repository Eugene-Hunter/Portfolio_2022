
import java.util.Scanner;

// Main class of the program
public class PoisedEngineering {
	
	// Main method of the class
	public static void main(String[] args) {
		String more = "yes";
		//Scanner input;	// Initializing the scanner object	


		ConnectToFile allProjects = new ConnectToFile();		

		Scanner input;	// Initializing the scanner object

		// Do/while loop to allow the user to complete multiple tasks
		do {
			String menuOption = "";
			input = null;	
			input = new Scanner(System.in);
			more = "yes";
		//Start menu with sub menus and options for the user to choose from		
		
		// Display the list of menu options on the screen
		System.out.print("\t\t\t ---- Main Menu ----" + "\r\n\r\n"
		+ "\t\t1: View all unfinished projects" + "\r\n"
		+ "\t\t2: View projects past their due date" + "\r\n"	
		+ "\t\t3: Contractor options" + "\r\n"
		+ "\t\t4: Architect options" + "\r\n"
		+ "\t\t5: Client Options" + "\r\n"
		+ "\t\t6: Project Options" + "\r\n"
		+ "\t\t7: Invoice Options" + "\r\n"
		+ "\t\t8: Receive Payment" + "\r\n"
		+ "\t\t0: Close the program   : ");
	
		menuOption = input.nextLine();	// variable to store the user input	
		
			// switch function that allows the user to select from the different options
			switch(menuOption) {
			
				case "1" : // View all Unfinished Projects
		
					allProjects.unfinishedProjects(); // execute the method to show unfinished projects
					
					break;
					
				case "2": // view Projects past due date
					
					allProjects.pastDueProjects(); // execute the method to show projects that is overdue
					
					break;
					
				case "3": //Contractor Options
					
					allProjects.contractorOptions(); // execute the method to show contractor options
			
				case "4": //See Architect Option

					allProjects.architectOptions(); // execute the method to show architect options
					
					break;
				
				case "5": //See Client Options
					
					allProjects.clientOptions(); // execute the method to show client options

					break;
					
				case "6": //See Project Options
					
					allProjects.projectOptions();  // execute the method to show project options
										
					break;
			
				case "7":	//See Invoice Options
				
					allProjects.invoiceOptions();  // execute the method to show invoice options
					
					break;
					
				case "8": // Receive Payment
					
					allProjects.addProjectPayment();  // execute the method to add a project payment
					
					break;
				
				case "0":	// option to exit the program

					more = "no";
								
			}	
			
			menuOption = "";
		}while(more == "yes" || more == "y" || more == "1");	
		
		input.close(); // close the Scanner object
		System.out.println("Good-bye!");

		System.exit(0); // Close the program
	
	}

}

