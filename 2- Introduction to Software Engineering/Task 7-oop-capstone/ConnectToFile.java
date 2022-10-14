//This file is used to handle all the capturing of information, writing and saving to file
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class ConnectToFile {
	ArrayList<ProjectInfo> projectsList= new ArrayList<ProjectInfo>();
	ArrayList<Invoice> invoicesList= new ArrayList<Invoice>();
	ArrayList<ProjectFinance> projectsFinancesList= new ArrayList<ProjectFinance>();
	EntityDetails entityDetails;
	CustomerArchitectContractor entityInfo;

	ArrayList<CustomerArchitectContractor> entitiesList= new ArrayList<CustomerArchitectContractor>();
	ArrayList<EntityDetails> entitiesAddressesList= new ArrayList<EntityDetails>();
	
	// method to retrieve the list of projects' finances
	public ArrayList<ProjectFinance> getProjectFinances(){
		
		// if statement to determine if the projects list is empty and add a record for testing purposes if it is.
		if(projectsFinancesList.isEmpty()) {
		// Instantiate a new project Finance object
		ProjectFinance projectFinance1 = new ProjectFinance("PR1", "Hunter Residence", LocalDate.of(2022,07,01), (float)2500000.00, (float) 1000000.00);
		
		// Instantiate a new project Finance object
		ProjectFinance projectFinance2 = new ProjectFinance("PR2", "Animal Farm", LocalDate.of(2022,07,01), (float)2000000.00, (float)1000000.00);
		this.projectsFinancesList.add(projectFinance1); // add the project's finance to the projects finances list
		this.projectsFinancesList.add(projectFinance2); // add the project's finance to the projects finances list
		
		}

		return  this.projectsFinancesList; // return the projects finances list
	}
	//______________________________________________________________________________________________________________________________
	// method to retrieve the projects
	public ArrayList<ProjectInfo> getProjects(){
		
		// if statement to determine if the projects list is empty and add a record for testing purposes if it is.
		if(this.projectsList.isEmpty()) {
		// Instantiate a new project  object
		ProjectInfo newProject1 = new ProjectInfo("PR1","Hunter Residence", "Private home", "24 Hill Street, George", "D21485", LocalDate.of(2021, 04, 01), LocalDate.of(2022, 04, 01), "AC001", "EC001", "C0001", false, false);
		
		this.projectsList.add(newProject1); // add the project to the projects list
		}
		//Future Feature - retrieve information from the file

		return this.projectsList; // return the projectList
	}
	//______________________________________________________________________________________________________________________________
	// method to retrieve the invoices
	public ArrayList<Invoice> getInvoices(){
		
		// if statement to determine if the invoices list is empty and add records for testing purposes if it is.
		if(this.invoicesList.isEmpty()) {
			// Instantiate a new invoice object
			Invoice newInvoice1 = new Invoice(1, LocalDate.of(2022, 02, 20), "CU1", "Eugene Hunter", "gnyhunter@gmail,com", "16 Lovers Lane, George", "P0001", "Hunter Residence","24 Hill Street, George", "D21485", LocalDate.of(2023, 01, 01), (float)2600000.00, (float)800000.00, (float)1000000.00, false);

			// Instantiate a new invoice object
			Invoice newInvoice2 = new Invoice(2, LocalDate.of(2022, 06, 01), "CU2", "George Orwell", "georgeorwell@gmail,com", "George", "P0002", "Animal Farm","13 Equestrian Road, George", "D41010", LocalDate.of(2022, 07, 01), (float)2000000.00, (float)1000000.00, (float)1000000.00, false);
	
			
			this.invoicesList.add(newInvoice1); // add the invoice to the invoices list
			this.invoicesList.add(newInvoice2); // add the invoice to the invoices list
		}

		//Future Feature - retrieve information from the file
		
		return this.invoicesList; // return the invoices list

	}
	//______________________________________________________________________________________________________________________________	
	// method to retrieve the customers
	public ArrayList<CustomerArchitectContractor> getEntities(){


			// Instantiate a new customer object
		CustomerArchitectContractor customer1 = new CustomerArchitectContractor("CU1", "Eugene Hunter", "Customer");
			
			// add the new record to the list of customers
		this.entitiesList.add(customer1); // add the customer object to the customers list
		

		// Instantiate a new contractor object
		CustomerArchitectContractor contractor1 = new CustomerArchitectContractor("CO1", "Jack Pratt", "Contractor");
		CustomerArchitectContractor contractor2 = new CustomerArchitectContractor("CO2", "Harry Porter", "Contractor");

		
		this.entitiesList.add(contractor1); // add the contractor object to the contractors' list
		
		this.entitiesList.add(contractor2); // add the contractor object to the contractors' list
	

		// Instantiate a new architect object
		CustomerArchitectContractor architect1 = new CustomerArchitectContractor("AR1", "John McKinley", "Architect");
			
		this.entitiesList.add(architect1); // add the architect to the architect list

		return entitiesList;
	}
	//______________________________________________________________________________________________________________________________	
	// method to retrieve the customer details
	public ArrayList<EntityDetails> getEntitiesAddresses(){

		// if statement to determine if the customer addresses list is empty and add a record for testing purposes if it is.

		// Instantiate a new customer address object
		EntityDetails customerAddress1 = new EntityDetails("CU1", 0, "", "21 Mermaid Blvd", "George", 6142, "gnyhunter@gmail.com", "0702357894", null);
		
		this.entitiesAddressesList.add(customerAddress1); // add the customer address object to the customer address list

		//Future Feature - retrieve information from the file


		// Instantiate a new contractor address
		EntityDetails contractorAddress1 = new EntityDetails("CO1", 0, "", "Redberry Farm", "George", 6142, "jackp@poised.com", "0614572154", LocalDate.of(2016, 04, 01));
		EntityDetails contractorAddress2 = new EntityDetails("CO2", 0, "", " 15 Jerryatrix Road", "George", 6142, "harryp@poised.com", "0614572154", LocalDate.of(2009, 10, 01));


		this.entitiesAddressesList.add(contractorAddress1); // add the architects list
		
		this.entitiesAddressesList.add(contractorAddress2); // add the architects list
		//Future Feature - retrieve information from the file
		

		// Instantiate a new project architect address object
		EntityDetails architectAddress1 = new EntityDetails("AR1", 64, "Sunny-Hill Estate", "Sunny Street", "George", 6142, "johnmk@poised.com", "0752451021", LocalDate.of(2009, 10, 01));
		
		this.entitiesAddressesList.add(architectAddress1); // add the object to the addresses list
		

		//Future Feature - retrieve information from the file
		
		return this.entitiesAddressesList; // return the contractors list
		
	}
	//______________________________________________________________________________________________________________________________	
	// Method to add a new project
	public void addProject(){ 

		System.out.println("\t\t ---- New Project ----");
		ProjectInfo newProject = new ProjectInfo("", "", "", "", "", null, null, "", "", "", false, false);
		
		Scanner input = new Scanner(System.in); //  initialize the scanner object to allow user input
		// Request user to enter all the relevant information

		System.out.println("\t\tPlease enter the following information:");		
		
		// Project name
		System.out.print("\t\tProject Name: ");
		String info = input.nextLine();
		int userInput = info.length();
		if (userInput > 0) { // else if(userInput > 0) {
			//TODO while loop to allow user to try multiple times to enter the project name
				// Call up the array list of stored projects
				// Call up the array list of stored customers
				// Compare the name entered to the stored projects
				// If statement to determine if the name already exists
				// If true, request user to input different name,
				// Else if false, store new value and break from loop
			newProject.setProjectName(info);
		}
		else {

			System.out.println("The project name is blank");
		}
		info = ""; // clearing the input variable of stored information					
		
		 
		//Project start date
				
		System.out.print("\t\tProject Start Date (2022-01-01): " );
		
		String newStartDateInput = input.nextLine(); // variable to the user input
		
		String[] startDate = newStartDateInput.split("-"); // convert the string into an string array

		LocalDate newDate  = LocalDate.of(Integer.valueOf(startDate[0]), Integer.valueOf(startDate[1]), Integer.valueOf(startDate[2]));
		
		newProject.setProjectStartDate(newDate); // assign the value to the object attribute
		
		
		//Project deadline
		
		System.out.print("\t\tProject Due Date (YYYY-MM-DD) format\n" );
		
		String newDeadlineInput = input.nextLine(); // variable to the user input
		
		String[] deadline = newDeadlineInput.split("-"); // convert the string into an string array

		LocalDate newDeadlineDate  = LocalDate.of(Integer.valueOf(deadline[0]), Integer.valueOf(deadline[1]), Integer.valueOf(deadline[2]));
		
		newProject.setProjectDeadline(newDeadlineDate); // assign the value to the object attribute
		
		// Architect code
		
		System.out.print("\t\tEnter Architect Code");					
		newProject.setArchitectEntityCode(input.nextLine()); // assign the value to the object attribute
		
		// Contractor code

		System.out.println("\t\tEnter Contractor Code");

		newProject.setContractorEntityCode(input.nextLine()); // assign the value to the object attribute
		
		//Customer code

		System.out.print("\t\tEnter Customer Code");
		newProject.setClientEntityCode(input.nextLine());   // assign the value to the object attribute
		

		
		this.projectsList.add(newProject);
		System.out.println("Project was added successfully.");
		return;
	}
	//______________________________________________________________________________________________________________________________	
	// Method to add a new project payment
	public void addProjectPayment() {
		
		System.out.print("\t\tEnter project code\t: ");
		Scanner input = new Scanner(System.in); // initialize the Scanner object to allow user input
		String projectCode = input.nextLine().toUpperCase(); // variable to store the user input
		
		// For loop to display the project's current financial information
		for(int z = 0; z < projectsFinancesList.size(); z++) {
			if(projectsFinancesList.get(z).projectCode.equalsIgnoreCase(projectCode)) {
				System.out.println("\t\tProject name\t\t: " + projectsFinancesList.get(z).projectName
									+ "\r\n\t\tProject Fee\t\t: R " + projectsFinancesList.get(z).projectFee
									+ "\r\n\t\tAmount already Paid\t: R " + projectsFinancesList.get(z).amountPaid
									+ "\r\n\t\tAmount still Owed\t: R " + projectsFinancesList.get(z).amountOutstanding);
			}
		
			// If statement to determine if the project's outstanding amount is greater than R0.00
			if(projectsFinancesList.get(z).amountOutstanding > 0.00) {
				
				System.out.print("\t\tMake payment? 1. Yes or 0. No?");
				
				String yesNo = input.nextLine(); //variable to store the user input on making a payment or not
				
				// If statement to check if the user wants to add a payment
				if(yesNo.equalsIgnoreCase("1") || yesNo == "yes" || yesNo == "y") {
						float payment; // variable to store the amount to be received as payment
						do { // do/while loop to ensure the user enters the value within range
							System.out.print("\t\tAmount\t: ");
							payment = input.nextFloat();
							
							// If statement to determine if the amount entered is greater than the project's balance or less than R0.00
							if(payment > projectsFinancesList.get(z).amountOutstanding || payment < 0.00) {
								System.out.println("\t\tThe amount entered is either greater than the outstanding balance or negative."
										+ "\t\tPlease try again" );
								
							}
							// while loop if the amount paid is greater than the amount outstanding or the payment amount is a negative amount
						}while(payment > projectsFinancesList.get(z).amountOutstanding || payment < 0.00);
						
						//Receipt
						System.out.println("\t\t - - - - Payment Advice: - - - -");
						
						projectsFinancesList.get(z).amountPaid += payment;
						projectsFinancesList.get(z).amountOutstanding -= payment;
						System.out.println("\t\tPayment received, thank you.");
						
						System.out.println("\t\tStatement\tDate" + LocalDateTime.now());
						System.out.println("_____________________________________________");
						System.out.println("\t\tProject Fee\t: R " + projectsFinancesList.get(z).projectFee);
						System.out.println("\t\tAmount Paid\t: R " + (projectsFinancesList.get(z).amountPaid - payment));
						System.out.println("\t\tPayment received: R " + payment);
						System.out.println("_____________________________________________");
						System.out.println("\t\tTotal Now Due\t: R " + projectsFinancesList.get(z).amountOutstanding );
						
						
						}	
				}
			}
	
		return;
		}
	//______________________________________________________________________________________________________________________________	
	// Method to update the project details
	public void updateProject() { //update Project

		Scanner input = new Scanner(System.in);
		String response;
		String projectCode;
		String message = "";
		int typeCount = 0;
		int counter = 1; // counter variable to display the record count of the number of client
		System.out.println();			
			//for loop to cycle through the list of clients
			for(int m = 0; m < projectsList.size(); m++){
	
				// if statement to determine which records to display that starts with a specific character sequence
				if (projectsList.get(m).projectCode.startsWith("PR")) {
				System.out.println("\t\t\t" + counter +") " + projectsList.get(m).projectCode + ": " + projectsList.get(m).projectName + "\n"
								 + "\t\t\t   " + projectsList.get(m).projectAddress);
	
				counter++;
				System.out.println();
				}
			}
				
				// For loop to cycle through the list of variables in the list
				System.out.print("\r\n\t\tEnter the project, 0 to go back: " );
				
				projectCode = input.nextLine().toUpperCase();				

				while(projectCode.equalsIgnoreCase("0") == false ) {
					for(int x = 0; x < projectsList.size(); x++) {
						// If statement to compare the entity code entered against the current record
						if(projectsList.get(x).projectCode.equalsIgnoreCase(projectCode)) {
							
							System.out.print(projectsList.get(x).toString()); // display the results  

							System.out.println();
							System.out.print("\r\n\t\tSelect what to update:\n"
									 + "\t\t\t1) Project Name\n"
									 + "\t\t\t2) Building Type\n"
									 + "\t\t\t3) Project Address\n"
									 + "\t\t\t4) Erf Number\n"
									 + "\t\t\t5) Customer Code\n"
									 + "\t\t\t6) Contractor Code\n"
									 + "\t\t\t7) Architect Code\n"
									 + "\t\t\t8) Project Start Date\n"
									 + "\t\t\t9) Project Due Date\n"
									 + "\t\t\t10) Archived\n"
									 + "\t\t\t11) Delete Project\n"
									 + "\t\t\t0) Go Back\n"
									 + ": ");
								response = input.nextLine();

								switch(response) {
									case "1": // Project Name
										System.out.print("\t\tEnter Project Name: " );
										
										projectsList.get(typeCount).setProjectName(input.nextLine());
										
										break;
									
									case "2": // Building Type
										System.out.print("\t\tEnter the Building Type: " );

										projectsList.get(typeCount).setBuildingType(input.nextLine());
										
										break;
									
									case "3": // Project Address
										System.out.print("\t\tEnter Project Address: " );

										projectsList.get(typeCount).setProjectAddress(input.nextLine());
										
										break;
									
									case "4": // Erf Number
										System.out.print("\t\tErf Number: " );

										projectsList.get(typeCount).setErfNumber(input.nextLine());
										
										break;
	
									case "5": // Customer Code
										System.out.print("\t\tEnter Client Code: " );

										projectsList.get(typeCount).setClientEntityCode(input.nextLine());
										
										break;
										
									case "6": // Contractor Code
										System.out.print("\t\tEnter Contractor Code: " );
										
										projectsList.get(typeCount).setContractorEntityCode(input.nextLine());
										
										break;
										
									case "7": // Architect Code
										System.out.print("\t\tEnter Architect code: " );
										
										projectsList.get(typeCount).setArchitectEntityCode(input.nextLine());
										
										break;
										
									case "8":// Project Start Date
					
										System.out.print("\t\tEnter Project Start Date (Ex. 2022-01-01): " );
										
										String start = input.nextLine();
										
										String[] startArr = start.split("-");
										
										projectsList.get(typeCount).setProjectStartDate(LocalDate.of(Integer.valueOf(startArr[0]), Integer.valueOf(startArr[1]), Integer.valueOf(startArr[2])));
										
										break;
										
									case "9": // Project Due Date
					
										System.out.print("\t\tEnter Project Due Date (Ex. 2022-01-01): " );
										
										String dueDate = input.nextLine();
										String[] dueDateArr = dueDate.split("-");
										projectsList.get(typeCount).setProjectDeadline(LocalDate.of(Integer.valueOf(dueDateArr[0]), Integer.valueOf(dueDateArr[1]), Integer.valueOf(dueDateArr[2])));
										
										break;
										
									case "10": // Project Finalize
					
										if (projectsList.get(typeCount).getProjectFinalized() == false) {
											projectsList.get(typeCount).setProjectFinalized(true);
												
											}
										
										break;
									case "11": // Project Delete
										
										if (projectsList.get(typeCount).getDeleteProject() == false) {
											
											projectsList.get(typeCount).setDeleteProject(true);
											
											System.out.println("\t\tThe project was deleted." );
											
											break;	
											}
										
										else if (projectsList.get(typeCount).getDeleteProject() == true){
											
												System.out.print("\t\tRestore the file? Yes or No: " );
												String yesNo = input.nextLine();
												
												if(yesNo == "1" || yesNo == "yes" || yesNo == "y") {
													projectsList.get(typeCount).setDeleteProject(false);
													
													System.out.print("\t\tThe project has been restored." );
													break;	
												}
										}
										else {
					
											System.out.println("\t\tNo changes were made. " );
										}
									
											
										break;
									case "0": // Go back to the main menu
										System.out.println("Exiting... " );
										projectCode = "0";
										
										//return contractor = "true";
										break;

								default :
									System.out.println("Input not recognised, Please try again.");
								
								
							}
					}		
					else {
							message = "The record could not be found, please try again";
					}	
					System.out.println(message);
					}
				}
				
				
	}
	//______________________________________________________________________________________________________________________________
	// Method to finalize a project
	public void  finalizeProject(String projectNumber) {


		System.out.print("\t\tAre you sure you want to finalize the project?\n"
					+ "\t\t1: Yes\n"
					+ "\t\t0: Return to menu"
					+ ": ");
		Scanner input = new Scanner(System.in); // Initialize the Scanner object to allow user input
		String yesNo = input.nextLine().toLowerCase();
		
		// If statement to confirm that user wants to proceed in finalizing the project 
		if (yesNo.equalsIgnoreCase(Integer.toString(1))  || yesNo == "yes" || yesNo == "y") {			
			
			//ArrayList<ProjectInfo> projects = getProjects(); // variable to store the list of projects
				
			String message = "Input is not recognised"; // variable to store the message that no such project exist
			

				
			// if statement to check if the user entered a position of the object in the list of projects or the project code
			if (projectNumber.charAt(0) != 'P') { // checking if the value entered is the actual project code or the index number of the record
				projectsList.get((Integer.valueOf(projectNumber) - 1)).setProjectFinalized(true);
				System.out.println("Project has been marked as finalised.");
				return;			
			}
			else {

				System.out.println(projectNumber);
				//else search for the product code in the list of projects
				for(int x = 1 ; x < projectsList.size(); x++) { // for loop to cycle through all the projects
					
					// if statement to determine which project the user wants to finalize
					if( projectNumber.equalsIgnoreCase(projectsList.get(x).projectCode) ) {
						projectsList.get(x).setProjectFinalized(true); // mark project as finalized if found

						System.out.println("Project has been marked as finalised.");
						return;							
						
						}
					else { // Else statement to record message if the file was not found

						message = "Sorry, the record does not exist. Please try again.";										
					}
				}								
			}
			System.out.println(message);  // display message once if the record was not found in the list				
			return;
		}
		else if(yesNo == "0" || yesNo == "no" || yesNo == "n") { // else if statement to determine if the user decided 
																// not to change the the project to finalized.
			System.out.println("The project has not been finalized.");				
		}		
		else { // else statement if the input is not recognized
			System.out.println("Sorry, your input is not recognised, please try again.");
		}	
	}
	//______________________________________________________________________________________________________________________________	
	public void unfinishedProjects() { //Main Menu Option 1
	
	System.out.println("\t\t1 ---- : Unfinished Projects ----");
	int projectSize = projectsList.size();
	// for loop to cycle through the records
	for(int x = 0; x < projectSize; x++) {
		// If statement to display all unfinished projects
		if(projectsList.get(x).projectFinalized == false) {
			System.out.println(projectsList.get(x).toString(1));
		};
	}

	}
	//______________________________________________________________________________________________________________________________	
	public void pastDueProjects() {//Main Menu Option 2
		
		System.out.println("\t\t2: ---- Past Due Projects ----");

		LocalDate today = LocalDate.now(); //variable to store today's date 
		
		// for loop to cycle through the list of projects
		for(int x = 0; x < projectsList.size(); x++) {
			 LocalDate thisProjectDeadline =  projectsList.get(x).getProjectDeadline(); //variable to store the record's due date
			
			 // If statement to determine if the project has been finalized before the due date or not						
			 if(today.isAfter(thisProjectDeadline)) { 
				 //Display the result for the individual project
				System.out.println("\tProject #" + projectsList.get(x).projectCode
						+ " is past the due date of " + projectsList.get(x).getProjectDeadline() + "\n" );
			}
			else { // else statement to display that none of the projects are past their due date
				System.out.println("No projects to show\n");
				
			}

		}

	}
	//______________________________________________________________________________________________________________________________	
	public String updateEntityOptions(String entityType){ //Main Menu Option 3, 4 and 5
		

		Scanner input = new Scanner(System.in);
		//String message = "The input is not recognised";
		String response = "y";
		String contractor;
		int entityCode;
		
			// Enter contractor code to find contractor 

				
				// For loop to cycle through the list of variables in the list
				System.out.print("\r\n\t\tEnter the client or personnel code, 0 to go back: " );
				
				contractor = input.nextLine().toUpperCase();
				
				
					while(contractor.equalsIgnoreCase("0") == false) {
	
						
						for(int x = 0; x < entitiesList.size(); x++) {
							// If statement to compare the entity code entered against the current record
							if(entitiesList.get(x).entityCode.contains(contractor)) {
								//System.out.print(x + ") " + entitiesList.get(x).toString() );
								//System.out.print(x + ") " + entitiesAddressesList.get(x).toString(1) ); 
						
								entitiesAddressesList.get(x).updateEntity();
								entityCode = x;
								}	
							else { 
								continue;
							}
							}
						
						
						int typeCount = 1;
						entityCode = 1;
						for(int y = 0; y < entitiesList.size(); y++) {
					
						
							// If statement to compare the entity code entered against the current record
							if(entitiesList.get(y).entityCode.equalsIgnoreCase(contractor) == true) {
								System.out.print(typeCount + ") " + entitiesList.get(y).toString() );
								System.out.print(typeCount + ") " + entitiesAddressesList.get(y).toString(1) ); 
								typeCount++;
								entitiesAddressesList.get(y).updateEntity();
								entityCode = y;
							}
			
						}
												
						
							System.out.println("\r\n\t\tSelect what to update:");
							System.out.print("\t\t\t1) Complex Number\n"
									 + "\t\t\t2) Complex Name\n"
									 + "\t\t\t3) Street\n"
									 + "\t\t\t4) City\n"
									 + "\t\t\t5) Postal Code\n"
									 + "\t\t\t6) Email\n"
									 + "\t\t\t7) Contact Number\n"
									 + "\t\t\t8) Employment Start\n"
									 + "\t\t\t9) Temination Date\n"
									 + "\t\t\t10) Archived\n"
									 + "\t\t\t0) Go Back\n"
									 + ": ");
								response = input.nextLine();
								
								switch(response) {
								case "1": // Complex Number
									System.out.print("\t\tEnter New Complex Number: " );
									int number = Integer.parseInt(input.nextLine());
									entitiesAddressesList.get(entityCode).setComplexNumber(number);
									break;
									
								case "2": // Complex Name
									System.out.print("\t\tEnter the Complex Name: " );
									String complexName = input.nextLine();
									entitiesAddressesList.get(entityCode).setComplexName(complexName);
									break;
									
								case "3": // Street
									System.out.print("\t\tEnter New Street Name: " );
									String street = input.nextLine();
									entitiesAddressesList.get(entityCode).setStreet(street);
									break;
								
								case "4": // City
									System.out.print("\t\tEnter New City: " );
									String city = input.nextLine();
									entitiesAddressesList.get(entityCode).setCity(city);
									break;

								case "5": // Postal Code
									System.out.print("\t\tEnter New Postal Code: " );
									int postal = Integer.parseInt(input.nextLine());
									entitiesAddressesList.get(entityCode).setPostalCode(postal);
									break;
									
								case "6": // Email
									System.out.print("\t\tEnter New Email Address: " );
									String email = input.nextLine();
									entitiesAddressesList.get(entityCode).setEmail(email);
									break;
									
								case"7 ": // Contact Number
									System.out.print("\t\tEnter New Contact Number: " );
									String contact = input.nextLine();
									entitiesAddressesList.get(entityCode).setContactNumber(contact);
									break;
									
								case "8":// Employment Start
				
									System.out.print("\t\tEnter Employment Start Date (Ex. 2022-01-01): " );
									String start = input.nextLine();
									String[] startArr = start.split("-");
									
									entitiesAddressesList.get(entityCode).setEmployStartDate(LocalDate.of(Integer.valueOf(startArr[0]), Integer.valueOf(startArr[1]), Integer.valueOf(startArr[2])));
									break;
									
								case "9": // Termination Date
				
									System.out.print("\t\tEnter  Termination Date (Ex. 2022-01-01): " );
									
									String termDate = input.nextLine();
									String[] termDateArr = termDate.split("-");
									entitiesAddressesList.get(entityCode).setEmployEndDate(LocalDate.of(Integer.valueOf(termDateArr[0]), Integer.valueOf(termDateArr[1]), Integer.valueOf(termDateArr[2])));
									break;
									
								case "10": // Archived
				
									if (entitiesAddressesList.get(entityCode).getArchiveEntity() == false) {
										entitiesAddressesList.get(entityCode).setArchiveEntity(true);
											
										}
									
									else if (entitiesAddressesList.get(entityCode).getArchiveEntity() == true){
										
											System.out.print("\t\tRestore the file? Yes or No: " );
											String yesNo = input.nextLine();
											
											if(yesNo == "1" || yesNo == "yes" || yesNo == "y") {
												entitiesAddressesList.get(entityCode).setArchiveEntity(false);
												
											}
											}
									else {
				
												System.out.println("\t\tNo changes were made. " );
											}
									
										
									break;
								case "0":
									System.out.println("Exiting... " );
									contractor = "0";
									
									//return contractor = "true";
									break;

								default :
									System.out.println("Please try again, input not recognised.");
								
								
							}
					}
	
			return contractor = "true";
	}
	//______________________________________________________________________________________________________________________________
	//______________________________________________________________________________________________________________________________	
	public void projectOptions() { //Main Menu Option 6
		System.out.println("\t\t6: ---- Project Options ----");
		
		//Create new project		
		System.out.println("\t\t1: New Project");
		
		//Finalize project
		System.out.println("\t\t2: Finalize Project");
		
		//Update project
		System.out.println("\t\t3: Update Project");
		
		//Find a project
		System.out.println("\t\t4: Search for Project");
		

		System.out.println("\t\t5: Receive Payment");
		
		//Go back		
		System.out.println("\t\t0: Back to Main Menu");

		Scanner input = new Scanner(System.in); // Initialize the Scanner object to allow user input
		
		String subOption = input.nextLine(); // variable to store the user input
		
		// switch function that allows the user to select from the different options
		switch(subOption) {
		
		case "1": // New Project							
				addProject(); // // execute the method to add a project
				
				break;
		
		case "2": // Finalize Project

			// For loop to cycle through the list of projects
			for(int x = 0; x < projectsList.size(); x++) {
				System.out.println((x +1) + ") " + projectsList.get(x).toString(1)); // Indexing and displaying the records one at a time
			}

			System.out.print("\t\tEnter the project to finalize: ");
			
			String projectNr = input.nextLine().toUpperCase(); // variable to store the user input
			
			finalizeProject(projectNr); // execute the method to mark a project as finalized
			
			break;
		
		case "3": // Update Project

			System.out.println("\t\t ---- Option 3: Update Project Information ----");
			updateProject();
			
			break;
			
		case "4": // Search Project
			System.out.println("\t\t ---- Option 4: Search for Project ----");
			// find a project by name or code
			System.out.print("\t\tEnter the project code or project name to search: ");

			
			projectNr = input.nextLine().toUpperCase(); // variable to store the user input
			
			// For loop to cycle through the list of project records one at a time
			for(int x = 0; x < projectsList.size(); x++) {
				if(projectsList.get(x).projectCode.equalsIgnoreCase(projectNr) || projectsList.get(x).projectName.equalsIgnoreCase(projectNr)){
					
					System.out.println((x +1) + ") " + projectsList.get(x));
				
				} 
			}
			break;
		
		case "5": // Receive Payment
			System.out.println("\t\t ---- Option 5 ----");
			addProjectPayment();
			break;
		
		case "0": // Back to main menu
			System.out.println("\t\t ---- Option 0 ----");
			//return;
		}
		}
	//______________________________________________________________________________________________________________________________
	//______________________________________________________________________________________________________________________________		
	public void addEntity(String entityType) {

		Scanner input = new Scanner(System.in); // Initialize the Scanner object to allow user input
		
		System.out.print("\t\tEnter new entity code:");
		String entityCode = input.nextLine(); // variable to store the user input	
		
		System.out.print("\t\tEnter name and Surname:");
		String entityName = input.nextLine(); // variable to store the user input
		
		System.out.print("\t\tEnter Entity Type:");
		String typeEntity = input.nextLine(); // variable to store the user input
		
		System.out.print("\t\tEnter Complex Number:");
		int complexNumber = input.nextInt(); // variable to store the user input

		System.out.print("\t\tEnterComplex Name:");
		String complexName = input.nextLine(); // variable to store the user input
		
		System.out.print("\t\tEnter Street name:");
		String streetName = input.nextLine(); // variable to store the user input
		
		System.out.print("\t\tEnter City:");
		String city = input.nextLine(); // variable to store the user input
		
		System.out.print("\t\tEnter Postal Code:");
		int postalCode = input.nextInt(); // variable to store the user input
		
		System.out.print("\t\tEnter Email Address:");
		String email = input.nextLine(); // variable to store the user input
		
		System.out.print("\t\tEnter Contact Number:");
		String contactNumber = input.nextLine(); // variable to store the user input	
		
		System.out.print("\t\tEnter Employee Start Date:");
		LocalDate employStartDate = LocalDate.now(); // variable to store the user input
		
		entityInfo = new CustomerArchitectContractor(entityCode, entityName, typeEntity);		
		entityDetails = new EntityDetails(entityCode, complexNumber, complexName, streetName, city, postalCode, email, contactNumber, employStartDate);
		
		entitiesList.add(entityInfo);
		entitiesAddressesList.add(entityDetails);
		
		
	}
	//______________________________________________________________________________________________________________________________
		
	//______________________________________________________________________________________________________________________________	
	public void invoiceOptions() { //Main Menu Option 7

		System.out.println("\t\t7: Invoice Options");
		
		//Create Invoice
		System.out.println("\t\t\t1: Create Invoice");
		
		//Cancel Invoice
		System.out.println("\t\t\t2: Cancel Invoice");
		
		//Find an invoice
		System.out.println("\t\t\t3: Search for Invoice");
		
		//Go back
		System.out.println("\t\t\t4: Back to Main Menu");
		

		Scanner input = new Scanner(System.in);	// Initializing the scanner object
		int subOption = Integer.parseInt(input.nextLine());

		
		if (subOption == 1) { // Create Invoice
			System.out.println("Create Invoice");
			newInvoice();
		}
		
		else if (subOption == 2) { // Cancel Invoice
			System.out.println("\t\t- - - - Cancel Invoice - - - -");
			

			System.out.print("Enter invoice number to cancel: P");
			int invoiceNr = input.nextInt();
			
			setCancelInvoice(invoiceNr);
			
		}
		else if (subOption == 3) { // Search Invoice
			System.out.println("Search Invoice");
			searchInvoice();
		}
		else if (subOption == 4) { // Back to main menu
			System.out.println("Back to main menu");
			
		}

	}
	//______________________________________________________________________________________________________________________________
	
	//______________________________________________________________________________________________________________________________		
	public void newInvoice() {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Invoice number: ");
		int invoiceNumber = (invoicesList.size() +1 );
		System.out.println(invoiceNumber);		
		System.out.println();		
		
		System.out.print("Invoice Date: ");
		LocalDate invoiceDate = LocalDate.now();
		System.out.println(invoiceDate);		
		System.out.println();		

		System.out.print("Enter Client Code: ");
		String customerEntityCode = input.nextLine().toUpperCase();
		System.out.println();		

		System.out.print("Enter Client Name: ");
		String customerName = input.nextLine();
		System.out.println();		

		System.out.print("Enter Email Address: ");
		String customerEmailAddress = input.nextLine();
		System.out.println();		

		System.out.print("Enter Client Address: ");
		String customerPhysicalAddress = input.nextLine();
		System.out.println();		

		System.out.print("Enter Project Code: ");
		String projectCode = input.nextLine();
		System.out.println();		

		System.out.print("Project Name: ");
		String projectName = input.nextLine();
		System.out.println();		

		System.out.print("Project Address: ");
		String projectAddress = input.nextLine(); 
		System.out.println();		

		System.out.print("Erf Number: ");
		String erfNumber = input.nextLine(); 
		System.out.println();		

		System.out.print("Project Due Date (example(2022-02-02)): ");
		String invDate = input.nextLine();
		String[] dueDate = invDate.split("-");
		LocalDate projectDeadline  = LocalDate.of(Integer.valueOf(dueDate[0]), 
												  Integer.valueOf(dueDate[1]), 
												  Integer.valueOf(dueDate[2]));
		System.out.println();		
		
		System.out.print("Project Fee: R ");
		float projectFee  = Float.parseFloat(input.nextLine());
		System.out.println();		

		System.out.print("Deposit Paid: R ");
		float amountPaid  = Float.parseFloat(input.nextLine());
		System.out.println();		

		System.out.print("Amount Outstanding: R ");
		float amountOutstanding  = projectFee - amountPaid;
		System.out.println(amountOutstanding);
		System.out.println();			

		boolean cancelInvoice = false;
		
		Invoice newInvoice = new Invoice(invoiceNumber, invoiceDate, 
				customerEntityCode, 
				customerName, 
				customerEmailAddress, 
				customerPhysicalAddress, 
				projectCode, 
				projectName, 
				projectAddress, 
				erfNumber, 
				projectDeadline,
				projectFee,
				amountPaid,
				amountOutstanding,
				cancelInvoice);
		
		invoicesList.add(newInvoice);
	}
	//______________________________________________________________________________________________________________________________
	
	//______________________________________________________________________________________________________________________________		
	public void setCancelInvoice(int invoiceNumber){
		// Search the invoice database for the invoice that the user wants to cancel.
		

		// User is requested to confirm canceling of the invoice
		
		System.out.println("Are you sure? ");
		Scanner input = new Scanner(System.in); // Scanner object is initialized to allow user input
		String yesNo = input.nextLine().toLowerCase();
		String nextInvoice = "y";
		
		do {  // do while statement to determine if the user has chosen to cancel the invoice.
			
			// if statement to determine if the user wants to proceed canceling the invoice
			if(yesNo == Integer.toString(1) || yesNo == "yes" || yesNo == "y") {

				invoicesList.get(invoiceNumber).setCancelInvoice(); // setting the boolean variable to true
				System.out.println("The invoice has been cancelled.");
				break;
			}
			//else statement if the user decided not to continue with canceling the invoice
			else if((yesNo == Integer.toString(0) || yesNo == "no" || yesNo == "n")){

				System.out.print("No changes were made to the invoice.\n Cancel a different invoice?"
						+ "1. Yes"
						+ "2. No");
				nextInvoice = input.nextLine();
				// if statement to determine if the user wants to cancel a different invoice or exit
				if(nextInvoice == Integer.toString(1) || nextInvoice == "yes" || nextInvoice == "y") {
					continue;
					
				} // else statement if the user does not want to cancel the invoice
				else if(nextInvoice == Integer.toString(0) || nextInvoice == "no" || nextInvoice == "n") {
					break;
				}				
			}
			else { // else statement if the user did not enter yes, no,1 or 0

				System.out.println("Input not correct. The operation was canceled ");
				break;
			}
		//do while statement to determine if the user wants to create another invoice or not.
		}while(nextInvoice != Integer.toString(0) || nextInvoice != "no" || nextInvoice != "n");
		
	}
	//______________________________________________________________________________________________________________________________
	
	//______________________________________________________________________________________________________________________________		
	public void searchInvoice() {
		Scanner input = new Scanner(System.in);
		// For loop to cycle through the list of projects
		for(int x = 0; x < invoicesList.size(); x++) {
			System.out.println((x +1) + ") " + invoicesList.get(x).toString(1)); // Indexing and displaying the records one at a time
		
		}
		System.out.print("Enter invoice number to view: ");
		String selectInvoice = input.nextLine();
		System.out.println();
		System.out.println(invoicesList.get(Integer.parseInt(selectInvoice) - 1).toString(1));
		System.out.println();
	}
	//______________________________________________________________________________________________________________________________
	
	//______________________________________________________________________________________________________________________________	
	public void clientOptions() {
		int counter = 1; // counter variable to display the record count of the number of client
		
		//for loop to cycle through the list of clients
		for(int m = 0; m < entitiesList.size(); m++){

			// if statement to determine which records to display that starts with a specific character sequence
			if (entitiesList.get(m).entityCode.startsWith("CU")) {
			System.out.println("\t\t\t" + counter +") " + entitiesList.get(m).entityCode + ": " + entitiesList.get(m).entityName);
			System.out.println("\t\t\t" + counter +") " + entitiesAddressesList.get(m).entityCode + ": " + entitiesAddressesList.get(m).contactNumber);
			System.out.println();
			counter++;
			}
		}

		System.out.println("\t\t5: ---- Client Options ----");
		
		//Create new project		
		System.out.println("\t\t1: New Client");
		
		//Finalize project
		System.out.println("\t\t2: Update Client Details");
		
		//Update project
		System.out.println("\t\t3: Search for Client");
		
		//Find a project
		System.out.println("\t\t4: Archive the CLient");

		
		System.out.println("\t\t0: Back to Main Menu");

		Scanner input = new Scanner(System.in); // Initialize the Scanner object to allow user input
		
		String subOption = input.nextLine(); // variable to store the user input
		
		// switch function that allows the user to select from the different options
		switch(subOption) {
		
			case "1": // New Client	
				
				addEntity("CU"); // execute the method to add a project
				
				break;
			
			case "2": // Update Client Details
	
				// For loop to cycle through the list of projects
				for(int x = 0; x < entitiesList.size(); x++) {
					System.out.println((x +1) + ") " + entitiesList.get(x).toString()); // Indexing and displaying the records one at a time
				}
	
				updateEntityOptions("CU");
				
				break;
		
			case "3": // Search for Client
						
				// find a project by name or code
				System.out.print("\t\tEnter the client code or client name to search: ");
	
				
				String entityCode = input.nextLine().toUpperCase(); // variable to store the user input
				
				// For loop to cycle through the list of project records one at a time
				for(int x = 0; x < entitiesList.size(); x++) {
					if(entitiesList.get(x).entityCode.equalsIgnoreCase(entityCode) || entitiesList.get(x).entityName.equalsIgnoreCase(entityCode)){
						
						System.out.println((x + 1) + ") " + entitiesList.get(x));				
					} 
				}
				break;
				
			case "4": // Archive Client
				// find a project by name or code
				System.out.print("\t\tEnter the client code or client name to archive: ");
	
				
				entityCode = input.nextLine().toUpperCase(); // variable to store the user input
				
				// For loop to cycle through the list of project records one at a time
				for(int x = 0; x < entitiesList.size(); x++) {
					if(entitiesList.get(x).entityCode.equalsIgnoreCase(entityCode) || entitiesList.get(x).entityName.equalsIgnoreCase(entityCode)){
						
						System.out.println((x + 1) + ") " + entitiesList.get(x));	
						
						System.out.println("Are you sure? 1 - Yes or 0 - new");
						String yesNo = input.nextLine().toLowerCase();
						
						if(yesNo == "1" || yesNo == "yes" || yesNo == "y") {
							
							entitiesAddressesList.get(x).setArchiveEntity(true);
						}
					} 
				}
					
				break;
			
			case "0": // Back to main menu
				System.out.println("\t\t ---- Option 0 ----");
				//return;
			}
	
	}
	//______________________________________________________________________________________________________________________________
	
	//______________________________________________________________________________________________________________________________
	public void architectOptions() {
		 int counter = 1;  // counter variable to display the record count of the number of architects

		// for loop to cycle through the list of architects
		for(int m = 0; m < entitiesList.size(); m++){

			// if statement to determine which records to display that starts with a specific character sequence
			if (entitiesList.get(m).entityCode.startsWith("AR")) {
			System.out.println("\t\t\t" + counter +") " + entitiesList.get(m).entityCode + ": " + entitiesList.get(m).entityName);
			System.out.println("\t\t\t" + counter +") " + entitiesAddressesList.get(m).entityCode + ": " + entitiesAddressesList.get(m).contactNumber);
			System.out.println();						
			}
		}
	
		System.out.println("\t\t3: ---- Architect Options ----");
		
		//Create new project		
		System.out.println("\t\t1: New Architect");
		
		//Update project
		System.out.println("\t\t2: Update Architect Details");
		
		//Find a project
		System.out.println("\t\t3: Search for Architect");
		

		System.out.println("\t\t4: Archive Architect");
		
		//Go back		
		System.out.println("\t\t0: Back to Main Menu");

		 Scanner input = new Scanner(System.in); // Initialize the Scanner object to allow user input
		
		String subOption = input.nextLine(); // variable to store the user input
	
		// switch function that allows the user to select from the different options
		switch(subOption) {
		
			case "1": // Add new architect
				addEntity("CO");
				
				break;
				
			case "2": // Update the architect details
				updateEntityOptions("AR");  // execute the method to update/change the entity's details
				
				break;

			case "3": // Search for an architect
				// find a project by name or code
				System.out.print("\t\tEnter the architect code or architect name to search: ");
	
				
				String entityCode = input.nextLine().toUpperCase(); // variable to store the user input
				
				// For loop to cycle through the list of project records one at a time
				for(int x = 0; x < entitiesList.size(); x++) {
					if(entitiesList.get(x).entityCode.equalsIgnoreCase(entityCode) || entitiesList.get(x).entityName.equalsIgnoreCase(entityCode)){
						
						System.out.println((x + 1) + ") " + entitiesList.get(x));				
					} 
				}
				break;
				
			case "4": // Archive architect
				// find an architect by name or code
				System.out.print("\t\tEnter the architect code or architect name to archive: ");
	
				
				entityCode = input.nextLine().toUpperCase(); // variable to store the user input
				
				// For loop to cycle through the list of project records one at a time
				for(int x = 0; x < entitiesList.size(); x++) {
					if(entitiesList.get(x).entityCode.equalsIgnoreCase(entityCode) || entitiesList.get(x).entityName.equalsIgnoreCase(entityCode)){
						
						System.out.println((x + 1) + ") " + entitiesList.get(x));	
						
						System.out.println("Are you sure? 1 - Yes or 0 - new");
						String yesNo = input.nextLine().toLowerCase();
						
						if(yesNo == "1" || yesNo == "yes" || yesNo == "y") {
							
							entitiesAddressesList.get(x).setArchiveEntity(true);
						}
					} 
				}
				break;
				
			case "0":
				
				break;
			
		}
	}
	//______________________________________________________________________________________________________________________________
	//______________________________________________________________________________________________________________________________
		
	public void contractorOptions() {
		int counter = 1; // counter variable to display the record count of the number of contractors
		System.out.println();		
		// For loop to display the current list of contractors
		for(int m = 0; m < entitiesList.size(); m++){
			
			// if statement to determine which records to display that starts with a specific character sequence
			if (entitiesList.get(m).entityCode.startsWith("CO")) {
			System.out.println("\t\t\t" + counter +") " + entitiesList.get(m).entityCode + ": " + entitiesList.get(m).entityName);
			System.out.println("\t\t\t" + counter +") " + entitiesAddressesList.get(m).entityCode + ": " + entitiesAddressesList.get(m).contactNumber);
			System.out.println();
			counter++;
			}
		}
		System.out.println("\t\t3: ---- Contractor Options ----");
		System.out.println();		
		//Create new project		
		System.out.println("\t\t\t1: New Contractor");
		
		//Update project
		System.out.println("\t\t\t2: Update Contractor Details");
		
		//Find a project
		System.out.println("\t\t\t3: Search for Contractor");
		
	
		System.out.println("\t\t\t4: Archive Contractor");
		
		//Go back		
		System.out.println("\t\t\t0: Back to Main Menu");
	
		Scanner input = new Scanner(System.in); // Initialize the Scanner object to allow user input
		
		String subOption = input.nextLine(); // variable to store the user input
	
		// switch function that allows the user to select from the different options
		switch(subOption) {
		
			case "1": // Add new contractor
				
				addEntity("CO");
				
				break;
				
			case "2": // Update the contractor details
				
				updateEntityOptions("CO"); // execute the method to update/change the entity's details
				
				break;
	
			case "3": // Search for a contractor
				
				// find a project by name or code
				System.out.print("\t\tEnter the contractor code or contrator name to search: ");
	
				
				String entityCode = input.nextLine().toUpperCase(); // variable to store the user input
				
				// For loop to cycle through the list of project records one at a time
				for(int x = 0; x < entitiesList.size(); x++) {
					if(entitiesList.get(x).entityCode.equalsIgnoreCase(entityCode) || entitiesList.get(x).entityName.equalsIgnoreCase(entityCode)){
						
						System.out.println((x + 1) + ") " + entitiesList.get(x));				
					} 
				}
				
				break;
				
			case "4": // Archive contractor
				
				// find a project by name or code
				System.out.print("\t\tEnter the contractor code or contractor name to archive: ");
	
				
				entityCode = input.nextLine().toUpperCase(); // variable to store the user input
				
				// For loop to cycle through the list of project records one at a time
				for(int x = 0; x < entitiesList.size(); x++) {
					if(entitiesList.get(x).entityCode.equalsIgnoreCase(entityCode) || entitiesList.get(x).entityName.equalsIgnoreCase(entityCode)){
						
						System.out.println((x + 1) + ") " + entitiesList.get(x));	
						
						System.out.println("Are you sure? 1 - Yes or 0 - new");
						
						String yesNo = input.nextLine().toLowerCase();
						
						if(yesNo == "1" || yesNo == "yes" || yesNo == "y") {
							
							entitiesAddressesList.get(x).setArchiveEntity(true);
						}
					} 
				}
				break;
				
			case "0":
				
				break;
		}	
	}
}