import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The audience of this program are the employees of the company otherwise known as the code reviewers of HD. 
 * The purpose of this program is to keep track of the projects that Poise is working on, as well as keeping track
 * of the invoices for these projects and payments received towards the individual projects. The user can add, edit and
 * delete or cancel the following records: project details and projects' financial information, client information, employee information,
 * invoices and receipts. The user can also view  a list of projects that are overdue and projects that are not yet finalized. 
 *  
 * */
public class PoiseEngineering {

	private static Scanner input = new Scanner(System.in);

	/** Displays the main menu as the starting point to the functions of the program. The user enters a selection and the
	 * program respond with additional menus that relate to option that the user chose.
	 * */
	public static void main(String[] args) throws NullPointerException, SQLException {
		int menuOption = 0;
		int repeat = 1;
		do {
		System.out.println("\t\t\t---- Main Menu ----");
		System.out.println("\t\t1: View all unfinished projects");
		System.out.println("\t\t2: View projects past their due date");
		System.out.println("\t\t3: Project Options");
		System.out.println("\t\t4: Invoice Options");
		System.out.println("\t\t5: View Receipt Options");
		System.out.println("\t\t6: View Project Finances");
		System.out.println("\t\t7: HR Resources");		
		System.out.println("\t\t8: Cancel Receipts");		
		System.out.println("\t\t0: Close the program");
		System.out.print("\r\n\t\tMenu option: ");			
		try {			
			menuOption = Integer.parseInt(input.nextLine());

			switch(menuOption) {
			
				case 1 : // View all Unfinished Projects
					menuOption1();
					break;
				case 2: // view Projects past due date
					menuOption2();
					break;
				case 3: //See Project Options					
					menuOption3();					
					break;			
				case 4:	//See Invoice Options
					menuOption4();				
					break;					
				case 5: // Receive Payment
					menuOption5();
					break;
				case 6: // View project finances
					menuOption6();
					break;
				case 7: // HR Resources
					menuOption7();
					break;	
				case 0:	// Exit and close program
					input.close();
					break;
				default:
					System.out.println("Input not recognised, please try again");	
			}						
		}catch(NumberFormatException e) {
			System.out.println("Input not recognised, please try again.");
		}
		}while(menuOption != 0); 	
		input.close();
		System.out.println("Good-bye!");
		System.exit(0); // Close the program
	}
	/** Displays a list of projects that have not yet been finalized*/
	public static void menuOption1() {
		try {
		ConnectToDB.displayViews("projectInfo", "SELECT * FROM projectInfo WHERE projectFinalized IS NULL;") ;
		}catch(SQLException menuOption1) {
			menuOption1.printStackTrace();
		}
	}
	/** Displays a list of projects that are still active but past their deadline date*/
	public static void menuOption2() {
		LocalDate today = LocalDate.now();

		System.out.println("\t\tToday's Date: " + today);
		try {
		/* Connect to database and return all projects that are active and past their due dates*/
			ConnectToDB.displayViews("projectInfo", "SELECT * FROM projectInfo WHERE projectFinalized IS NULL AND projectDueDate < '" + LocalDate.now() + "';") ;			
		}catch(SQLException menuOption2) {
			menuOption2.printStackTrace();
		}
	}
	/** Displays a menu of project related options*/
	public static void menuOption3() throws SQLException { 
		ConnectToDB.projectOptions();
	}
	/** Displays a menu of invoice related options*/
	public static void menuOption4() throws SQLException {
		ConnectToDB.invoiceOptions();
	}
	/** Displays a menu of receipt related options*/
	public static void menuOption5() throws SQLException {
		ConnectToDB.receiptOptions();
	}
	/** Displays a menu of project finance related options*/
	public static void menuOption6() throws SQLException {
		ConnectToDB.viewProjectFinances();
	}
	/** Displays a menu of HR related options*/
	public static void menuOption7() throws SQLException {
		int option = 1;
		do {
		System.out.println("\t\t\t----7) HR Menu ----");
		System.out.println("\t\t1: Client Options");
		System.out.println("\t\t2: Employee Options");	
		System.out.println("\t\t0: Go Back");
		System.out.print("\r\n\t\tMenu option: ");	
		
		option = Integer.parseInt(input.nextLine());
		
		switch (option) {
			case 1: //Client Options
				clientMenu();
			break;
			case 2: //Contractor Options
				employeeMenu();
			break;
			case 0:
				option = 0;
				break;
			default:
				System.out.println("\r\n\t\tThe option entered is not recognised, please try again");
				return;
		}
		}while(option != 0);
	}

	/** Displays a menu of client related options*/
	private static void clientMenu() throws NullPointerException, SQLException {
		int yesNo = 1;
		do {
		System.out.println("\t\t\t----1) Client Menu ----");
		System.out.println("\t\t1) Add Client");
		System.out.println("\t\t2) Update Client Details");	
		System.out.println("\t\t3) Archive Client");	
		System.out.println("\t\t4) See Active Projects for Clients");	
		System.out.println("\t\t0) Go Back");
		System.out.print("\r\n\t\tMenu option: ");	
		
		int option = Integer.parseInt(input.nextLine());
		
		switch (option) {
			case 1: // Add Client
				ConnectToDB.addEntity("C");
			
			break;
			case 2: // Update Client Details

				ConnectToDB.updateEntity("Client");
			break;
			case 3: // Archive Clients
				ConnectToDB.archiveEntity("Client");
			break;
			case 4: // See Active Projects
				viewActiveProjects();
				
			break;
			case 0:
				yesNo = 0;
			default:
			break;
		}
		}while(yesNo != 0);
	}

	/** Displays a list of projects that have not yet been finalized. It shows extensive information regarding the employee and
	 * client information.
	 * */
	private static void viewActiveProjects() {
		try 
		(Connection connection = ConnectToDB.connectToDB();
				Statement statement1 = connection.createStatement();
				Statement statement2 = connection.createStatement();
				Statement statement3 = connection.createStatement();
				Statement statement4 = connection.createStatement();
				Statement statement5 = connection.createStatement();
				){
		String activeProjects = "SELECT project.projectCode, project.projectName , projectInfo.projectAddress, project.clientCode "
				+ "FROM project LEFT JOIN projectInfo ON project.projectCode = projectInfo.projectCode "
				+ "ORDER BY project.clientCode;"	;
		String clientNames = "SELECT entity.entityName FROM entity "
				+ "INNER JOIN project ON entity.entityCode = project.clientCode "
				+ "AND entity.entityCode = project.clientCode "
				+ ";";		
		//retrieve the client's name (that is located in the entity table)
		// that matches the client code on the project record 
		String architectNames = "SELECT entity.entityName FROM entity INNER JOIN employeeInfo INNER JOIN project "
		+ "ON entity.entityCode = employeeInfo.employeeCode "
		+ "AND employeeInfo.employeeCode = project.architectCode;";

		String contractorNames = "SELECT entity.entityName FROM entity INNER JOIN employeeInfo INNER JOIN project "
		+ "ON entity.entityCode = employeeInfo.employeeCode "
		+ "AND employeeInfo.employeeCode = project.contractorCode;";
			
		String managerNames = "SELECT entity.entityName FROM entity INNER JOIN employeeInfo INNER JOIN project "
		+ "ON entity.entityCode = employeeInfo.employeeCode "
		+ "AND employeeInfo.employeeCode = project.managerCode ;";
		
		ResultSet results1 = statement1.executeQuery(activeProjects);
		ResultSet results2 = statement2.executeQuery(clientNames);
		ResultSet results3 = statement3.executeQuery(architectNames);
		ResultSet results4 = statement4.executeQuery(contractorNames);
		ResultSet results5 = statement5.executeQuery(managerNames);

		while(results1.next() && results2.next() && results3.next() && results4.next() && results5.next()) {
			System.out.println("\r\n\t\tProject#\t: " + results1.getString("projectCode"));
			System.out.println("\t\tClient\t\t: " + results2.getString("entityName"));
			System.out.println("\t\tArchitect\t: " + results3.getString("entityName"));
			System.out.println("\t\tContractor\t: " + results4.getString("entityName"));
			System.out.println("\t\tManager\t\t: " + results5.getString("entityName"));
			System.out.println("\t\tProject Name\t: " + results1.getString("projectName"));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	/** Displays a menu of employee related options*/
	private static void employeeMenu() throws NullPointerException, SQLException {
		int option = 1;
		do {
		System.out.println("\t\t\t----2) Employee Menu ----");
		System.out.println("\t\t1: Add Employee");
		System.out.println("\t\t2: Update Employees");	
		System.out.println("\t\t3: Archive Employees");	
		System.out.println("\t\t4: View Employees");	
		System.out.println("\t\t0: Go Back");
		System.out.print("\r\n\t\tMenu option: ");	
		
		option = Integer.parseInt(input.nextLine());
		
		switch (option) {
			case 1: //Client Options
				ConnectToDB.addEntity("E");
 	
				//ConnectToFile.entityOptions("CL");
			break;
			case 2: // Update Employee
				ConnectToDB.updateEntity("Employee");
				//ConnectToFile.entityOptions("CO");
			break;
			case 3: //Archive Employee
				ConnectToDB.archiveEntity("Employee");
			break;
			case 4: //View all Employees
				System.out.println("\t\t4: View Employees");
				ConnectToDB.viewEmployees("Employee");
			break;
			case 0:
				option = 0;
			default:
			break;
		}
		}while(option != 0);
	}
	
}

