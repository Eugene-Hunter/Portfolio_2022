import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Write a program that will allow a user to:
//Capture the details that are used to create a new project
//object.
//Change the due date of the project.
//Change the total amount of the fee paid to date.
//Update a contractor’s contact details.
//Finalize the project (but don’t worry about saving it to a text
//file yet)

// Main class of the program
public class PoisedEngineering {

	static List<ProjectInfo> projectsList = ConnectToFile.getProjects();
	static List<Invoice> invoicesList = ConnectToFile.getInvoices();
	static List<ProjectFinance> projectsFinancesList = ConnectToFile.getProjectFinances();
	static List<Entity> entitiesList = ConnectToFile.getEntities();
	static List<EntityDetails> entitiesDetailsList =ConnectToFile.getEntityDetails();
	static List<Receipt> receiptsList = ConnectToFile.viewReceipts();

	//private static 

	// Main method of the class
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int menuOption;
		int repeat = 1;
		do {
		try {	
		System.out.println("\t\t\t---- Main Menu ----");
		System.out.println("\t\t1: View all unfinished projects");
		System.out.println("\t\t2: View projects past their due date");
		System.out.println("\t\t3: Project Options");
		System.out.println("\t\t4: Contractor options");
		System.out.println("\t\t5: Architect options");
		System.out.println("\t\t6: Client Options");
		System.out.println("\t\t7: Invoice Options");
		System.out.println("\t\t8: View Receipts");
		System.out.println("\t\t9: View Project Finances");		
		System.out.println("\t\t0: Close the program");
		System.out.print("\r\n\t\tMenu option: ");			

			menuOption = Integer.parseInt(input.nextLine());	// variable to store the user input	

			// switch function that allows the user to select from the different options
			switch(menuOption) {
			
				case 1 : // View all Unfinished Projects
		
					ConnectToFile.unfinishedProjects(); // execute the method to show unfinished projects
					
					break;
					
				case 2: // view Projects past due date
					
					ConnectToFile.pastDueProjects(); // execute the method to show projects that is overdue
					
					break;
				case 3: //See Project Options
					
					ConnectToFile.projectOptions();
					
					break;					
				case 4: //Contractor Options

					ConnectToFile.entityOptions("CO"); // execute the method to update/change the entity's details
					break;
			
				case 5: //See Architect Option
				
					ConnectToFile.entityOptions("AR");  // execute the method to update/change the entity's details
					
					break;			
				case 6: //See Client Options
			
					ConnectToFile.entityOptions("CL");  // execute the method to update/change the entity's details
					break;			
				case 7:	//See Invoice Options
				
					ConnectToFile.invoiceOptions();
					
					break;
					
				case 8: // Receive Payment
					
					ConnectToFile.viewReceipts();
					break;
				case 9:
					ConnectToFile.viewProjectFinances();
					break;
				case 0:	// Exit and close program
					repeat = 0;
					break;
				default:
					System.out.println("Input not recognised, please try again");	
			}			
			
		}catch(NumberFormatException e) {

			System.out.println("Input not recognised, please try again.");
		}
		}while(repeat == 1); 	
		input.close(); // close the Scanner object
		System.out.println("Good-bye!");
		System.exit(0); // Close the program
	}

}

