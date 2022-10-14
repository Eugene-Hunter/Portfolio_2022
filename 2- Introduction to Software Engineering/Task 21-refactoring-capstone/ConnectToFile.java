//This file is used to handle all the capturing of information, writing and saving to file

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectToFile {

	private ConnectToFile() {}

	// Instantiating the lists
	static List<ProjectInfo> projectsList = new ArrayList<>();
	static List<Invoice> invoicesList = new ArrayList<>();
	static List<ProjectFinance> projectsFinancesList = new ArrayList<>();
	static List<Entity> entitiesList = new ArrayList<>();
	static List<EntityDetails> entitiesAddressesList = new ArrayList<>();
	static Scanner input = new Scanner(System.in);

	// method to retrieve the list of projects' finances
	public static List<ProjectFinance> getProjectFinances(){
		// if statement to determine if the projects list is empty and add a record for testing purposes if it is.
		if(projectsFinancesList.isEmpty()) {
			// Instantiate a new project Finance object with attribute values
			ProjectFinance projectFinance1 = new ProjectFinance("PR1", "Hunter Residence", LocalDate.of(2022,07,01), 2600000.00, 800000.00);
			// Instantiate a new project Finance object with attribute values
			ProjectFinance projectFinance2 = new ProjectFinance("PR2", "Animal Farm", LocalDate.of(2022,07,01), 2000000.00, 1000000.00);
			projectsFinancesList.add(projectFinance1); // add the project's finance to the projects finances list
			projectsFinancesList.add(projectFinance2); // add the project's finance to the projects finances list
		}
		return  projectsFinancesList; // return the projects finances list
	}

	// method to retrieve the projects
	public static List<ProjectInfo> getProjects(){
		// if statement to determine if the projects list is empty and add a record for testing purposes if it is.
		if(projectsList.isEmpty()) {
			String[] projectDetails = {"PR1","Hunter Residence", "Private home", "24 Hill Street, George", "D21485", "AC001", "EC001", "C0001" };
			// Instantiate a new project  object
			ProjectInfo newProject1 = new ProjectInfo(LocalDate.of(2021, 04, 01), LocalDate.of(2022, 04, 01), false, false, false, projectDetails);

			projectsList.add(newProject1); // add the project to the projects list
		}
		//Future Feature - retrieve information from the file
		return projectsList; // return the projectList
	}
	// method to retrieve the invoices
	public static List<Invoice> getInvoices(){
		// if statement to determine if the invoices list is empty and add records for testing purposes if it is.
		if(invoicesList.isEmpty()) {
			// arrays to store attribute values create objects
			double[] projectFinance1 = {2600000.00, 800000.00};
			String[] invoiceData1 = { "CL1", "Eugene Hunter", "083 2541 245", "gnyhunter@gmail,com", "16 Lovers Lane, George", "P0001", "Hunter Residence","24 Hill Street, George", "D21485"};
			// Instantiate a new invoice object
			Invoice newInvoice1 = new Invoice(1, LocalDate.of(2022, 02, 20), LocalDate.of(2023, 01, 01), false, projectFinance1, invoiceData1);

			double[] projectFinance2 = {2000000.00, 1000000.00};
			String[] invoiceData2 = {"CL2", "George Orwell", "081 5482 154", "georgeorwell@gmail,com", "George", "P0002", "Animal Farm","13 Equestrian Road, George", "D41010"};
			// Instantiate a new invoice object
			Invoice newInvoice2 = new Invoice(2, LocalDate.of(2022, 06, 01),  LocalDate.of(2022, 07, 01), false, projectFinance2, invoiceData2);

			invoicesList.add(newInvoice1); // add the invoice to the invoices list
			invoicesList.add(newInvoice2); // add the invoice to the invoices list
		}
		//Future Feature - retrieve information from the file
		return invoicesList; // return the invoices list
	}

	// method to retrieve the customers
	public static List<Entity> getEntities(){
		// Instantiate a new customer object
		Entity client1 = new Entity("CL1", "Eugene Hunter", "CLient");
		// add the new record to the list of customers
		entitiesList.add(client1); // add the customer object to the customers list
		// Instantiate a new contractor object
		Entity contractor1 = new Entity("CO1", "Jack Pratt", "Contractor");
		Entity contractor2 = new Entity("CO2", "Harry Porter", "Contractor");
		entitiesList.add(contractor1); // add the contractor object to the contractors' list
		entitiesList.add(contractor2); // add the contractor object to the contractors' list
		// Instantiate a new architect object
		Entity architect1 = new Entity("AR1", "John McKinley", "Architect");
		entitiesList.add(architect1); // add the architect to the architect list
		return entitiesList;
	}

	// method to retrieve the customer details
	public static List<EntityDetails> getEntitiesAddresses(){
		// if statement to determine if the customer addresses list is empty and add a record for testing purposes if it is.
		String[] entityDetails1 = {"CL1", "", "", "21 Mermaid Blvd", "George", "6142", "gnyhunter@gmail.com", "0702357894"};
		// Instantiate a new customer address object
		EntityDetails clientAddress1 = new EntityDetails(null, entityDetails1 );
		entitiesAddressesList.add(clientAddress1); // add the customer address object to the customer address list
		//Future Feature - retrieve information from the file
		// Instantiate a new contractor address
		String[] entityDetails2 = {"CO1", "", "", "Redberry Farm", "George", "6142", "jackp@poised.com", "0614572154"};
		String[] entityDetails3 = {"CO2", "", "", " 15 Jerryatrix Road", "George", "6142", "harryp@poised.com", "0614572154"};
		EntityDetails contractorAddress1 = new EntityDetails( LocalDate.of(2016, 04, 01), entityDetails2);
		EntityDetails contractorAddress2 = new EntityDetails(LocalDate.of(2009, 10, 01), entityDetails3);
		entitiesAddressesList.add(contractorAddress1); // add the architects list
		entitiesAddressesList.add(contractorAddress2); // add the architects list
		//Future Feature - retrieve information from the file
		String[] entityDetails4 = {"AR1", "64", "Sunny-Hill Estate", "Sunny Street", "George", "6142", "johnmk@poised.com", "0752451021"};
		// Instantiate a new project architect address object
		EntityDetails architectAddress1 = new EntityDetails(LocalDate.of(2009, 10, 01), entityDetails4);
		entitiesAddressesList.add(architectAddress1); // add the object to the addresses list
		//Future Feature - retrieve information from the file
		return entitiesAddressesList; // return the contractors list
	}

	public  static void unfinishedProjects() { //Main Menu Option 1
		System.out.println("\t\t ---- 1) Unfinished Projects ----");
		try { // try catch clause to catch fatal exception errors
			int projectSize = projectsList.size(); // variable to store the size of projects in the projects list
			System.out.println(projectSize);
			// for loop to cycle through the records one at a time
			for(int x = 0; x < projectSize; x++) {
				// If statement to display all unfinished projects
				if(!projectsList.get(x).getProjectFinalized()) {
					System.out.println(projectsList.get(x).toString(1));
				}
			}
			// catch clause to catch any exception error and recover successfully from the fatal error
		}catch(Exception unfinishedProjectsError) {

			System.out.println("Error in capturing the project details");
			System.out.println("unfinishedProjectsError: " + unfinishedProjectsError);
		}
	}

	public  static void pastDueProjects() { //Main Menu Option 2
		System.out.println("\t\t---- 2) Past Due Projects ----");
		try { // try catch clause to catch fatal exception errors
			LocalDate today = LocalDate.now(); //variable to store today's date

			// for loop to cycle through the list of projects
			for (ProjectInfo element : projectsList) {
				LocalDate thisProjectDeadline =  element.getProjectDeadline(); //variable to store the record's due date

				// If statement to determine if the project has been finalized before the due date or not
				if(today.isAfter(thisProjectDeadline)) {
					//Display the result for the individual project
					System.out.println("\tProject #" + element.getProjectCode()
					+ " is past the due date of " + element.getProjectDeadline() + "\n" );
				}
				else { // else statement to display that none of the projects are past their due date
					System.out.println("No projects to show\n");
				}
			}
			// catch clause to catch any exception error and recover successfully from the fatal error
		}catch(Exception pastDueProjectsError) {
			System.out.println("Error in capturing the project details");
			System.out.println("pastDueProjectsError: " + pastDueProjectsError);
		}
	}

	public  static void projectOptions() { //Main Menu Option 3

		int subOption = 1;
		do { // do/while loop to give the user the ability to work on multiple projects
			try {  // try catch clause to catch fatal exception errors
				System.out.println("\t\t---- 3) Project Options ----");
				//Create new project
				System.out.println("\t\t1: New Project");
				//Finalize project
				System.out.println("\t\t2: Finalize Project");
				//Amend project
				System.out.println("\t\t3: Update Project");
				//Delete project
				System.out.println("\t\t4: Archive Project");
				//Find a project
				System.out.println("\t\t5: Search for a Project");
				//Delete a project
				System.out.println("\t\t6: Delete a Project");
				//Receive Payment
				System.out.println("\t\t7: Receive Payment");
				//Go back
				System.out.println("\t\t0: Back to Main Menu");
				subOption = Integer.parseInt(input.nextLine()); // variable to store the user input
				// switch function that allows the user to select from the different options
				switch(subOption) {
				case 1: // New Project
					addProject(); // // execute the method to add a project
					break;
				case 2: // Finalize Project
					finalizeProject(); // execute the method to mark a project as finalized
					break;
				case 3: // Update Project
					updateProject();
					break;
				case 4: // Archive Project
					archiveProject();
					break;
				case 5: // Search for a project
					searchProject();
					break;
				case 6: // Search for a project
					deleteProject();
					break;
				case 7: // Receive Payment
					addProjectPayment();
					break;
				case 0: // Back to main menu
					break;
				default:
					System.out.println("Input entered is not recognised, please try again");
				}
				// catch clause to catch NumberFormatException errors and recover successfully from the fatal error
			}catch(NumberFormatException projectMenuError) {

				System.out.println("Input not recognised, please try again");
				System.out.println("projectMenuError: " + projectMenuError);
			}
		}while(subOption != 0);
	}
	// Method to add a new project
	public  static void addProject(){
		System.out.println("\t\t---- 1) New Project ----");
		int yesNo = 1;
		do { //Do/while loop to allow user to enter multiple projects
			try { // try/catch clause to trap exception errors that may occur if the user enters invalid characters
				String clientName = ""; // variable to store the client's surname in order to assign to unnamed projects
				String projectCode = "PR" + (projectsList.size() + 1); // variable to create and store the new project code
				System.out.println("\t\tProject Code: " + projectCode);
				System.out.println("\t\tPlease enter the following information:");
				System.out.print("\t\tEnter Client(CL) Code: ");
				String clientCode = input.nextLine(); // variable to store user input
				// for loop to cycle through the entities list one at a time
				for (Entity element : entitiesList) {
					// if statement to check if the user input matches the current record's attribute value
					if (clientCode.equalsIgnoreCase(element.entityCode)) {
						// Client information
						System.out.print(element.toString()); // Display the client'e information
						// variable to store the surname of the client that is to be used in the naming of the project
						clientName = element.entityName.substring(element.entityName.indexOf(" "));
					}
				}
				System.out.print("\r\n\t\tProject Name: ");
				String projectName = input.nextLine(); //variable to store the user input
				if (projectName.isEmpty()) { // if statement to determine if the project was given a name or
					// if a default name is to be generated and used
					projectName = clientName + " Building project"; // variable to store the generated project name
					System.out.println("\t\tProject Name: " + projectName);
				}
				// Building Type
				System.out.print("\t\tBuilding Type: ");
				String buildingType = input.nextLine();
				// Project Address
				System.out.print("\t\tProject Address: ");
				String projectAddress = input.nextLine(); // set a new attribute value
				// Erf Number
				System.out.print("\t\tErf Number: ");
				String erfNumber = input.nextLine(); // set a new attribute value
				//Project start date
				System.out.print("\t\tProject Start Date (YYYY-MM-DD) format\n" );
				String newStartDateInput = input.nextLine(); // variable to store user input
				String[] startDate = newStartDateInput.split("-"); // split the user input
				// date object to store the project start date
				LocalDate newDate  = LocalDate.of(Integer.valueOf(startDate[0]), Integer.valueOf(startDate[1]), Integer.valueOf(startDate[2]));
				//Project deadline
				System.out.print("\t\tProject Due Date (YYYY-MM-DD) format\n" );
				String newDeadlineInput = input.nextLine();  // variable to store user input
				String[] deadline = newDeadlineInput.split("-"); // split the user input
				// date object to store the project's due date
				LocalDate newDeadlineDate  = LocalDate.of(Integer.valueOf(deadline[0]), Integer.valueOf(deadline[1]), Integer.valueOf(deadline[2]));
				// Architect code
				System.out.print("\t\tEnter Architect Code");
				String architectCode = input.nextLine(); // variable to store user input
				// Contractor code
				System.out.println("\t\tEnter Contractor Code");
				String contractorCode = input.nextLine(); // variable to store user input
				// String array to store all the project data
				String[] projectData = {projectCode, projectName, buildingType, projectAddress, erfNumber, architectCode, contractorCode, clientCode};
				// Instantiate a new project object
				ProjectInfo newProject = new ProjectInfo(newDate, newDeadlineDate, false, false, false, projectData);
				projectsList.add(newProject); // add the new project to the project list
				System.out.println("Project was added successfully.");
				System.out.println("Add another project? 1) Yes, 0) no");
				yesNo = Integer.parseInt(input.nextLine()); // variable to store the user input
				// catch clause to catch NumberFormatException errors and recover successfully from the fatal error
			}catch(Exception addProjectError) {
				System.out.println("Error in capturing the project details");
				System.out.println("addProjectError: " + addProjectError);
				System.out.println("Try again? 1) Yes, 0) no");
				yesNo = Integer.parseInt(input.nextLine()); // variable to store the user input
			}
		}while( yesNo != 0);
	}

	// Method to add a new project payment
	public  static void addProjectPayment() {
		int yesNo = 1;
		System.out.println("\t\t---- 7) Add Project Payment ----");
		do {
			try { // try catch clause to catch fatal exception errors
				System.out.print("\t\tEnter project code\t: ");
				String projectCode = input.nextLine(); // variable to store the user input
				// For loop to display the project's current financial information
				for (ProjectFinance element : projectsFinancesList) {
					if(element.getProjectCode().equalsIgnoreCase(projectCode)) {
						System.out.println("\t\tProject name\t\t: " + element.getProjectName()
						+ "\r\n\t\tProject Fee\t\t: R " + element.getProjectFee()
						+ "\r\n\t\tAmount already Paid\t: R " + element.getAmountPaid()
						+ "\r\n\t\tAmount still Owed\t: R " + element.getAmountOutstanding());
					}
					// If statement to determine if the project's outstanding amount is greater than R0.00
					if(element.getAmountOutstanding() > 0.00) {
						System.out.print("\t\tMake payment? 1) Yes or 0) No?");
						yesNo = Integer.parseInt(input.nextLine()); //variable to store the user input on making a payment or not
						// If statement to check if the user wants to add a payment
						if(yesNo == 1) {
							// variable to store the amount to be received as payment
							double payment = checkPaymentAmount(element.getAmountOutstanding() );
							//Receipt printout
							System.out.println("\t\t - - - - Payment Advice: - - - -");
							element.setAmountPaid(element.getAmountPaid() + payment);
							System.out.println("\t\tPayment received, thank you.");
							System.out.println("\t\tStatement\tDate" + LocalDateTime.now());
							System.out.println("_____________________________________________");
							System.out.println("\t\tProject Fee\t: R " + element.getProjectFee());
							System.out.println("\t\tAmount Paid\t: R " + (element.getAmountPaid() - payment));
							System.out.println("\t\tPayment received: R " + payment);
							System.out.println("_____________________________________________");
							System.out.println("\t\tTotal Now Due\t: R " + element.getAmountOutstanding() );
						}
						System.out.println("Enter another? 1) Yes, 0) no");
						yesNo = Integer.parseInt(input.nextLine()); // variable to store the user input
					}
				}
				// catch clause to catch NumberFormatException errors and recover successfully from the fatal error
			}catch(Exception projectError) {
				System.out.println("Error in capturing the project details");
				System.out.println("Error: " + projectError);
				System.out.println("Try again? 1) Yes, 0) no");
				yesNo = Integer.parseInt(input.nextLine()); // variable to store the user input
			}
		}while(yesNo != 0);
	}

	public  static void updateProject() {
		System.out.println("\t\t---- 3) Update Project Information ----");
		// For loop to cycle through the list of projects
		for(int x = 0; x < projectsList.size(); x++) {
			System.out.println((x +1) + ") " + projectsList.get(x).toString(1)); // Indexing and displaying the records one at a time
		}
		try { // try catch clause to catch fatal exception errors
			System.out.println("Sorry, this option is currently not available. Look out for the next update.");
			// catch clause to catch all exception errors and recover successfully from the fatal error
		}catch(Exception updateProjectError) {
			System.out.println("There was a problem, please check that your input is correct.");
			System.out.println(updateProjectError);
		}
	}

	public  static void deleteProject() {
		System.out.println("\t\t---- 6) Mark Project as Deleted ----");
		// For loop to cycle through the list of projects
		for(int x = 0; x < projectsList.size(); x++) {
			System.out.println((x +1) + ") " + projectsList.get(x).toString(x)); // Indexing and displaying the records one at a time
		}
		System.out.print("\t\tSelect the project code to delete: ");
		String projectNr = input.nextLine(); // Variable to store the user input
		// For loop to cycle through list of projects
		for (ProjectInfo element : projectsList) {
			// If statement to compare the user input with the current project code in the list of projects
			if (element.getProjectCode().equalsIgnoreCase(projectNr)){
				element.setDeleteProject(true); // Set delete attribute to true
				System.out.println("\t\tProject has been deleted");
			}
		}
	}

	// Method to finalize a project
	public  static void  finalizeProject() {

		System.out.println("\t\t---- 2) Finalize Project ----");
		List<ProjectInfo> projects = getProjects(); // variable to store the list of projects
		// For loop to cycle through the list of projects
		for(int x = 0; x < projectsList.size(); x++) {
			System.out.println((x +1) + ") " + projectsList.get(x).toString(1));
			// Indexing and displaying the records one at a time
		}
		System.out.print("\t\tEnter the project to finalize: ");
		String projectNr = input.nextLine(); // variable to store the user input
		try { // try catch clause to catch fatal exception errors
			System.out.print("\t\tAre you sure you want to finalize the project? 1) Yes, 0) No: ");
			int yesNo = Integer.parseInt(input.nextLine()); // variable to store the user input
			String message = ""; // variable to store the message that no such project exist
			// If statement to confirm that user wants to proceed in finalizing the project
			switch(yesNo) {
			case 1:
				// if statement to check if the user entered a position of the object in the list of projects or the project code
				if (projectNr.charAt(0) != 'P') { // checking if the value entered is the actual project code or the index number of the record
					projects.get((Integer.valueOf(projectNr) - 1)).setProjectFinalized(true);
					System.out.println("Project has been marked as finalised.");
				}
				else {
					//else search for the product code in the list of projects
					for(int x = 1 ; x < projects.size(); x++) { // for loop to cycle through all the projects
						// if statement to determine which project the user wants to finalize
						if( projectNr.equalsIgnoreCase(projects.get(x).getProjectCode()) ) {
							projects.get(x).setProjectFinalized(true); // mark project as finalized if found
							System.out.println("Project has been marked as finalised.");
						}
						else { // Else statement to record message if the file was not found

							message = "Sorry, the record does not exist. Please try again.";
						}
					}
				}
				System.out.println(message);  // display message once if the record was not found in the list
				break;
			case 0:// else if statement to determine if the user decided
				// not to change the the project to finalized.
				System.out.println("The project has not been finalized.");
				break;
			default:// else statement if the input is not recognized
				System.out.println("Sorry, your input is not recognised, please try again.");
			}
			// catch clause to catch all exception errors and recover successfully from the fatal error
		}catch(Exception projectError) {
			System.out.println("Error in capturing the project details");
			System.out.println("Error: " + projectError);
		}
	}

	public  static void archiveProject() {
		System.out.println("\t\t---- Option 4) Archive Project ----");
		// for loop to list the projects one at a time
		for(int x = 0; x < projectsList.size(); x++) {
			System.out.println((x +1) + ") " + projectsList.get(x));
		}
		try {// try catch clause to catch fatal exception errors
			System.out.print("\t\tSelect the project code to archive: ");
			String projectNr = input.nextLine(); // variable to store user input
			for (ProjectInfo element : projectsList) { // For loop to cycle through the list of projects
				// if statement to determine if the project exists and assign a value of true to the attribute
				if (element.getProjectCode().equalsIgnoreCase(projectNr)){
					element.setArchiveProject(true); // assign the true value to the attribute
					System.out.println("\t\tProject has been archived");
				}
			}
			// catch clause to catch all exception errors and recover successfully from the fatal error
		}catch(Exception archiveProjectError){
			System.out.println("Error in capturing the project details");
			System.out.println("Error: " + archiveProjectError);
		}
	}

	private  static void searchProject() {
		System.out.println("\t\t---- Option 5) Search for Project ----");
		// find a project by name or code
		System.out.print("\t\tEnter the project code or project name to search: ");
		String projectNr = input.nextLine();
		for(int x = 0; x < projectsList.size(); x++) {
			if (projectsList.get(x).getProjectCode().equalsIgnoreCase(projectNr)
					|| projectsList.get(x).getProjectName().equalsIgnoreCase(projectNr)){
				System.out.println((x +1) + ") " + projectsList.get(x).toString());
			}
		}
	}

	public  static void entityOptions(String entityCode){ //Main Menu Option 4,5 and 6
		int subOption = 0;
		String newEntityType = "";
		switch(entityCode){
		case "CL":
			newEntityType = "Client";
			break;
		case "CO":
			newEntityType = "Contractor";
			break;
		case "AR":
			newEntityType = "Architect";
			break;
		default:
			System.out.println("\t\tUnknown entity type. ");
			break;
		}
		do { // do/while statement to allow user to enter multiple entries
			System.out.println("\r\n\t\t ---- " + newEntityType + " Options ----");
			//Create new entity
			System.out.println("\t\t1: New " + newEntityType);
			//Update entity details
			System.out.println("\t\t2: Update " + newEntityType + " details");
			//Update entity details
			System.out.println("\t\t3: See list of " + newEntityType + ":");
			//Go back
			System.out.println("\t\t0: Back to Main Menu");
			try {
				subOption = Integer.parseInt(input.nextLine()); // variable to store the user input
				// switch function that allows the user to select from the different options
				switch(subOption) {
				case 1: // New Entity
					addEntity(entityCode); // // execute the method to add a project
					break;
				case 2: // Finalize Project
					entityData(entityCode); // execute the method to mark a project as finalized
					break;
				case 3:
					for (Entity element : entitiesList) {
						if(element.entityCode.contains(entityCode)) {
							System.out.println(element.toString());
						}
					}
					break;
				case 0: // Back to main menu
					break;
				default:
					System.out.println("Input entered is not recognised, please try again");
				}		// catch clause to catch all exception errors and recover successfully from the fatal error
			}catch(Exception archiveProjectError){
				System.out.println("Error in capturing the project details");
				System.out.println("Error: " + archiveProjectError);
				System.out.println("Try again? 1) Yes, 0) No");
				subOption = Integer.parseInt(input.nextLine()); // variable to store the user input
			}
		}while(subOption != 0);
	}

	public  static void entityData(String entityCode){
		System.out.println("\t\t---- 2) Update Entity Details ----");

		int counter = 1; // counter variable to display the record count of the number of contractors
		String entity = "";
		// For loop to display the current list of contractors
		for(int m = 0; m < entitiesList.size(); m++){
			// if statement to determine which records to display that starts with a specific character sequence
			if (entitiesList.get(m).entityCode.startsWith(entityCode)) {
				System.out.println("\t\t\t" + counter +") " + entitiesList.get(m).entityCode + ": " + entitiesList.get(m).entityName);
				System.out.println("\t\t\t" + counter +") " + entitiesAddressesList.get(m).getEntityCode() + ": " + entitiesAddressesList.get(m).getContactNumber());
				System.out.println();
				counter++;
			}
		}
		try { // try/catch clause to trap exception errors that may occur
			do { // Do/while loop to allow user to update multiple projects and exit if the user enters 0
				System.out.print("\r\n\t\tEnter the client or personnel code, 0 to go back: " );
				entity = input.nextLine().toUpperCase(); // variable to store the user input
				int typeCount = 1;
				// for loop to cycle through the entities list
				for(int y = 0; y < entitiesList.size(); y++) {
					// If statement to compare the entity code entered against the current record
					if(entitiesList.get(y).entityCode.equalsIgnoreCase(entity)) {
						System.out.println(typeCount + ") " + entitiesList.get(y).toString() );
						System.out.println(typeCount + ") " + entitiesAddressesList.get(y).toString() );
						typeCount++;
						updateEntity(y); // initialize update entity method
					}
				}

			}while(!entity.equalsIgnoreCase("0"));

		}catch(Exception entityDataError) {
			System.out.println("Error in capturing the entity details");
			System.out.println("Error: " + entityDataError);
		}
	}
	// Method to count the number of clients/contractors/architects are in the entities list
	private static int countEntityType(String entityType) {
		int count = 0;
		// for loop to cycle through the entities list
		for (Entity element : entitiesList) {
			// if statement to check if the current record contains the entity type and count if true
			if(element.entityCode.contains(entityType)) {
				count ++;
			}
		}
		return count; // return the count
	}

	// Method to add a new client
	private  static void addEntity(String entityType) {
		System.out.println("\t\t---- 1) New Entity ----");
		try { // try/catch clause to trap exception errors that may occur
			String newEntityType = "";
			int nextEntityNr = 0;
			System.out.print("\t\tEntity Type");
			switch(entityType){ // switch statement to assign the type of entity to the variable
			case "CL":
				newEntityType = "Client";
				nextEntityNr = countEntityType(entityType);
				break;
			case "CO":
				newEntityType = "Contractor";
				nextEntityNr = countEntityType(entityType);
				break;
			case "AR":
				newEntityType = "Architect";
				nextEntityNr = countEntityType(entityType);
				break;
			default:
				System.out.print("\t\tUnknown entity type. ");
				break;
			}
			System.out.print("\t\t" + newEntityType + " Code: ");
			String newEntityCode = entityType + nextEntityNr; // variable to store the new entity code
			System.out.print(newEntityCode);
			System.out.print("\t\tFull Name: ");
			String newEntityName = input.nextLine(); // variable to store the user input
			System.out.print("\t\tEnter Complex Number: ");
			String complexNumber = input.nextLine(); // variable to store the user input
			System.out.print("\t\tEnter the Complex Name: " );
			String complexName = input.nextLine(); // variable to store the user input
			System.out.print("\t\tEnter New Street Name: " );
			String street = input.nextLine(); // variable to store the user input
			System.out.print("\t\tEnter New City: " );
			String city = input.nextLine(); // variable to store the user input
			System.out.print("\t\tEnter New Postal Code: " );
			String postal = input.nextLine(); // variable to store the user input
			System.out.print("\t\tEnter New Email Address: " );
			String email = input.nextLine(); // variable to store the user input
			System.out.print("\t\tEnter New Contact Number: " );
			String contact = input.nextLine(); // variable to store the user input
			LocalDate startDate;
			// If/else statement to check if the entity is a client or employee and allow the user to enter a start date for
			//the new employee, else assign null value to client
			if(entityType.equalsIgnoreCase("CO") || entityType.equalsIgnoreCase("AR")) {
				System.out.print("\t\tEnter Employment Start Date (Ex. 2022-01-01): " );
				String start = input.nextLine();
				String[] startArr = start.split("-");
				startDate = LocalDate.of(Integer.parseInt(startArr[0]), Integer.parseInt(startArr[1]), Integer.parseInt(startArr[2]));
			}
			else {
				startDate = null;
			}
			// Instantiating an entity object with parameter values
			Entity newEntity = new Entity(newEntityCode, newEntityName, newEntityType);
			// String array to store the string values
			String[] newEntityDetails = {newEntityCode, complexNumber, complexName, street, city, postal, email, contact};
			// Instantiate a new customer address object with parameter values
			EntityDetails newEntityInfo = new EntityDetails(startDate, newEntityDetails);
			entitiesList.add(newEntity); // add the new entity object to the entities list
			entitiesAddressesList.add(newEntityInfo); // add the new entity details object to the entities addresses list
		}catch(Exception addEntityError) {
			System.out.println("Error in capturing the entity details");
			System.out.println("Error: " + addEntityError);
		}
	}

	private  static void updateEntity(int entityCode) {

		System.out.println("\r\n\t\tSelect what to update:");
		System.out.println("\t\t\t1) Complex Number\n");
		System.out.println("\t\t\t2) Complex Name\n");
		System.out.println("\t\t\t3) Street\n");
		System.out.println("\t\t\t4) City\n");
		System.out.println("\t\t\t5) Postal Code\n");
		System.out.println("\t\t\t6) Email\n");
		System.out.println("\t\t\t7) Contact Number\n");
		System.out.println("\t\t\t8) Employment Start\n");
		System.out.println("\t\t\t9) Temination Date\n");
		System.out.println("\t\t\t10) Archived\n");
		System.out.println("\t\t\t0) Go Back\n");
		System.out.println(": ");

		try { // try/catch clause to trap exception errors that may occur
			int response = Integer.parseInt(input.nextLine()); // integer to store the user input
			switch(response) {
			case 1: // Complex Number
				System.out.print("\t\tEnter New Complex Number: ");
				String number = input.nextLine();  // variable to store user input
				entitiesAddressesList.get(entityCode).setComplexNumber(number);
				break;
			case 2: // Complex Name
				System.out.print("\t\tEnter New Complex Name: " );
				String complexName = input.nextLine(); // variable to store user input
				entitiesAddressesList.get(entityCode).setComplexName(complexName);
				break;
			case 3: // Street
				System.out.print("\t\tEnter New Street Name: " );
				String street = input.nextLine(); // variable to store user input
				entitiesAddressesList.get(entityCode).setStreet(street);
				break;
			case 4: // City
				System.out.print("\t\tEnter New City: " );
				String city = input.nextLine(); // variable to store user input
				entitiesAddressesList.get(entityCode).setCity(city);
				break;
			case 5: // Postal Code
				System.out.print("\t\tEnter New Postal Code: " );
				String postal = input.nextLine(); // variable to store user input
				entitiesAddressesList.get(entityCode).setPostalCode(postal);
				break;
			case 6: // Email
				System.out.print("\t\tEnter New Email Address: " );
				String email = input.nextLine(); // variable to store user input
				entitiesAddressesList.get(entityCode).setEmail(email);
				break;
			case 7: // Contact Number
				System.out.print("\t\tEnter New Contact Number: " );
				String contact = input.nextLine(); // variable to store user input
				entitiesAddressesList.get(entityCode).setContactNumber(contact);
				break;
			case 8:// Employment Start
				System.out.print("\t\tEnter Employment Start Date (Ex. 2022-01-01): " );
				String start = input.nextLine(); // variable to store user input
				String[] startArr = start.split("-");
				entitiesAddressesList.get(entityCode).setEmployStartDate(LocalDate.of(Integer.valueOf(startArr[0]), Integer.valueOf(startArr[1]), Integer.valueOf(startArr[2])));
				break;
			case 9: // Termination Date
				System.out.print("\t\tEnter  Termination Date (Ex. 2022-01-01): " );
				String termDate = input.nextLine(); // variable to store user input
				String[] termDateArr = termDate.split("-");
				entitiesAddressesList.get(entityCode).setEmployEndDate(LocalDate.of(Integer.valueOf(termDateArr[0]), Integer.valueOf(termDateArr[1]), Integer.valueOf(termDateArr[2])));
				break;
			case 10: // Archived
				boolean trueFalse = entitiesAddressesList.get(entityCode).getArchiveEntity();
				if (!trueFalse) {
					entitiesAddressesList.get(entityCode).setArchiveEntity(true);
				}
				else
				{
					System.out.print("\t\tRestore the file? Yes or No: " );
					int yesNo = Integer.parseInt(input.nextLine());  // variable to store user input

					if(yesNo == 1) {
						entitiesAddressesList.get(entityCode).setArchiveEntity(false);
					}
					else
					{
						System.out.println("\t\tNo changes were made. " );
					}
				}
				break;
			case 0:
				System.out.println();
				break;
			default :
				System.out.println("Please try again, input not recognised.");
			}
		}catch(Exception updateEntityError) {
			System.out.println("Error in capturing the entity details");
			System.out.println("Error: " + updateEntityError);
		}
	}

	public  static void invoiceOptions() { //Main Menu Option 7
		int subOption = 0;
		do {
			System.out.println("\t\t---- 7) Invoice Options ----");
			//Create Invoice
			System.out.println("\t\t\t1) Create Invoice");
			//Cancel Invoice
			System.out.println("\t\t\t2) Cancel Invoice");
			//Find an invoice
			System.out.println("\t\t\t3) Search for Invoice");
			//Go back
			System.out.println("\t\t\t0) Back to Main Menu");
			try {
				subOption = Integer.parseInt(input.nextLine());
				switch(subOption) {
				case  1: // Create Invoice
					addInvoice();
					break;
				case 2: // Cancel Invoice
					System.out.println("\t\t---- 2) Cancel Invoice ----");
					System.out.print("\t\tEnter the invoice number to cancel: ");
					int invoiceNr = Integer.parseInt(input.nextLine());
					if (invoiceNr < invoicesList.size()) {
						cancelInvoice(invoiceNr);
					}
					else
						System.out.println("\t\tThe invoice number does not exist, kindly enter a different invoice number");
					break;
				case 3: // Search Invoice
					searchInvoice();
					break;
				case 0: // Back to main menu
					System.out.println("\t\t - Back to main menu -");
					break;
				default:
					System.out.println("\t\tInput not recognised, please try again.");
				}
				// catch clause to catch all exception errors and recover successfully from the fatal error
			}catch(Exception invoiceOptionsError){
				System.out.println("\t\tError in capturing the project details");
				System.out.println("\t\tError: " + invoiceOptionsError);
				System.out.println("\t\tTry again? 1) Yes, 0) No");
				subOption = Integer.parseInt(input.nextLine()); // variable to store the user input
			}
		}while(subOption != 0);
	}

	// Method to add a new invoice
	public  static void addInvoice(){
		System.out.println("\t\t---- 1) New Invoice ----");
		String clientName = "";
		String clientAddress = "";
		String clientContact = "";
		String clientEmail = "";
		Double projectFee = 0.00d;
		Double amountPaid = 0.00d;
		Double amountOutstanding = 0.00d;
		String projectName = "";
		String erfNumber = "";
		String projectAddress = "";
		int subOption = 0;
		do {
			try { // try/catch clause to trap exception errors that may occur
				int invoiceNr = invoicesList.size() + 1;
				System.out.print("\t\tInvoice number:" + invoiceNr);
				int currentYear = LocalDate.now().getYear();
				int currentMonth = LocalDate.now().getMonthValue();
				int currentDay = LocalDate.now().getDayOfMonth();
				LocalDate invoiceDate = LocalDate.of(currentYear, currentMonth, currentDay);
				System.out.println("\t\tInvoice Date: " + invoiceDate);
				System.out.print("\t\tClient Code: ");
				String clientCode = input.nextLine();
				for (int x = 0; x <entitiesList.size(); x++) {
					if(entitiesList.get(x).entityCode.equalsIgnoreCase(clientCode)){
						clientName = entitiesList.get(x).getEntityName();
						System.out.println("\t\tClient Name: " + clientName);
						clientAddress = entitiesAddressesList.get(x).getSingleLineAddress();
						System.out.println("\t\tClient Address: " + clientAddress);
						clientContact = entitiesAddressesList.get(x).getContactNumber();
						System.out.println("\t\tClient Contact Number: " + clientContact);
						clientEmail = entitiesAddressesList.get(x).getEmail();
						System.out.println("\t\tClient e-mail: " + clientEmail);
					}
				}
				System.out.println("\t\tProject Code: ");
				String projectCode = input.nextLine();
				for (ProjectInfo element : projectsList) {
					if(projectCode.equalsIgnoreCase(element.getProjectCode())) {
						projectName = element.getProjectName();
						System.out.println("\t\tProject Name: " + projectName);
						erfNumber = element.getErfNumber();
						System.out.println("\t\tErf Number: " + erfNumber);
						projectAddress = element.getProjectAddress();
						System.out.println("\t\tProject Address: " + projectAddress);
					}
				}
				boolean cancelInvoice = false;
				System.out.print("\t\tProject Due date: ");
				LocalDate projectDueDate = projectsList.get(0).getProjectDeadline();
				for (ProjectFinance element : projectsFinancesList) {
					projectFee = element.getProjectFee();
					System.out.println("\t\tProject Fee: R " + projectFee);
					System.out.print("\t\tDeposit Amount: R ");
					amountPaid = Double.parseDouble(input.nextLine());
					amountOutstanding = projectFee - amountPaid;
					System.out.println("\t\tOutstanding Amount: R " + amountOutstanding);
				}
				double[] projectFinance = {projectFee, amountPaid, amountOutstanding};
				String[] invoiceData = {clientCode, clientName, clientContact, clientEmail, clientAddress, projectCode, projectName, projectAddress, erfNumber};
				Invoice newInvoice = new Invoice(invoiceNr, invoiceDate, projectDueDate, cancelInvoice, projectFinance,invoiceData);
				invoicesList.add(newInvoice);
			// catch clause to catch all exception errors and recover successfully from the fatal error
			}catch(Exception addInvoiceError) {
				System.out.println("\t\tError in capturing the project details");
				System.out.println("\t\taddInvoiceError: " + addInvoiceError);
				System.out.println("\t\tTry again? 1) Yes, 0) No");
				subOption = Integer.parseInt(input.nextLine()); // variable to store the user input
			}
		}while(subOption != 0);
	}

	private static void cancelInvoice(int invoiceNr) {
		System.out.println("\t\t---- 2) Cancel Invoice ----");

		// User is requested to confirm canceling of the invoice
		System.out.println("\t\tThis cannot be undone. Are you sure? 1) Yes, 0) No");

		int yesNo = Integer.parseInt(input.next());  // variable to store the user input if a number was entered

		// if statement to determine if the user wants to proceed canceling the invoice
		if(yesNo == 1) {
			invoicesList.get(invoiceNr).setCancelInvoice(); // setting the boolean variable to true
			System.out.println("\t\tThe invoice has been cancelled.");
		}
		//else statement if the user decided not to continue with canceling the invoice
		else if(yesNo == 0){
			System.out.print("\t\tNo changes were made to the invoice.");
		}
		else { // else statement if the user did not enter yes, no,1 or 0
			System.out.println("\t\tInput not recognised. The operation was cancelled ");
		}
	}

	private  static void searchInvoice() {
		System.out.println("\t\t---- 3) Search for Invoice ----");
		// find a project by name or code
		System.out.print("\t\tEnter the project code or project name to search: ");
		String invoiceNr =  input.nextLine();
		for(int x = 0; x < projectsList.size(); x++) {
			if (invoicesList.get(x).getProjectCode().equalsIgnoreCase(invoiceNr)
					|| invoicesList.get(x).getProjectName().equalsIgnoreCase(invoiceNr)){
				System.out.println("\t" + (x +1) + ") " + invoicesList.get(x).toString());
			}
		}
	}
	private  static double checkPaymentAmount(double outstandingAmount ) {
		int subOption = 0;
		double paymentAmount = 0d; // variable to store the user
		do { // do/while loop to ensure the user enters the value within range
			try {
				System.out.print("\t\tAmount\t: ");
				paymentAmount = Double.parseDouble(input.nextLine());
				// If statement to determine if the amount entered is greater than the project's balance or less than R0.00
				if(paymentAmount > outstandingAmount || paymentAmount < 0.00) {
					System.out.println("\t\tThe amount entered is either greater than the outstanding balance or negative."
							+ "\t\tPlease try again" );
				}
				// catch clause to catch all exception errors and recover successfully from the fatal error
			}catch(Exception checkPaymentAmountError) {
				System.out.println("Error in capturing the project details");
				System.out.println("Error: " + checkPaymentAmountError);
				System.out.println("Try again? 1) Yes, 0) No");
				subOption = Integer.parseInt(input.nextLine()); // variable to store the user input
			}
			// while loop if the amount paid is greater than the amount outstanding or the payment amount is a negative amount
		}while(paymentAmount > outstandingAmount || paymentAmount < 0.00 || subOption == 1);
		return paymentAmount;

	}

}