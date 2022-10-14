/*This file is used to handle all the capturing of information, writing and saving to file
 * 
 * A client or employee records first needs to be created before their information can be used in any future records
 * 
 * 
 * Capturing of a project consist of a possible 3 stage approach, being the creation of the project object, creating of the project
 * finance object and optionally, creating of an invoice for the project.
 * The user can enter any payments toward a project at any time after the creation of the profile, etc.
 * 
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
	static List<EntityDetails> entitiesDetailsList = new ArrayList<>();
	static List<Receipt> receiptsList = new ArrayList<>();
	static Scanner input = new Scanner(System.in);
	static FileWriter fileIn ;
	static BufferedWriter bufferedWriter;
	static PrintWriter printWriter;
	static FileReader fileReader;
	static BufferedReader nbReader;
	static Scanner scanner;

	/* Method to append new records to the respective files */
	/* Receives the information from the various methods and formats the output for storage purposes */
	private static void saveToFile(String function, Object fileInfo) {
		System.out.println("\t\t ---- Save to file ----");
		String fileName = "";
		String info = "";
		switch(function) {

		case "project": 						
			fileName = "projects.txt";
			ProjectInfo projectFile = (ProjectInfo) fileInfo;
			info = projectFile.toString("saveToFile");
			break;
		case "projectFinance": 						
			fileName = "projectFinances.txt";													
			ProjectFinance financeFile = (ProjectFinance) fileInfo;
			info = financeFile.toString("saveToFile");
			break;
		case "entity":  																		
			Entity entity = (Entity) fileInfo;
			fileName = "entities.txt";
			info = entity.toString("saveToFile");
			break;
		case "entityDetails": 																	
			EntityDetails entityDetails = (EntityDetails) fileInfo;
			fileName = "entityDetails.txt";
			info = entityDetails.toString("saveToFile");
			break;
		case "receipt": 																	
			Receipt receipt = (Receipt) fileInfo;
			fileName = "receipts.txt";
			info = receipt.toString("saveToFile");
			break;
		case "invoice": 																	
			Invoice invoice = (Invoice) fileInfo;
			fileName = "invoices.txt";
			info = invoice.toString("saveToFile");
			break;
		default:
			break;
		}
		try {
			fileIn = new FileWriter(fileName, true);
			bufferedWriter = new BufferedWriter(fileIn);
			printWriter = new PrintWriter(bufferedWriter);
			printWriter.println(info);

			System.out.println("\t\tThe information was saved successfully");
			printWriter.close();
		}catch(IOException saveToFileError) {
			System.out.println("\t\tThe file was not saved.");
			System.out.println("\t\tSaveToFile: " + saveToFileError);
		}		
	}	
	/* Method to retrieve the information from the different files and returning the information to the calling method*/
	private static List<String> readFromFile(String filename) throws IOException{

		List<String> fromFile = new ArrayList<>();	
		System.out.println("\t\tReading from the file :" + filename);
		try {
			fileReader = new FileReader(filename);
			nbReader = new BufferedReader(fileReader);	
			scanner = new Scanner(nbReader);
			while(scanner.hasNextLine()) {
				fromFile.add(scanner.nextLine());
			}
			scanner.close();
			nbReader.close();
			fileReader.close();
		}	
		catch(Exception readFomFileError) {
			System.out.println("\t\tError reading from the file.");
			System.out.println("\t\tReadFromFile: " + readFomFileError);
		}	
		return fromFile;
	}
	/*Method that updates a single record in a file selected by the filename variable*/
	private static void updateRecords(String filename) {

		try {
			fileIn = new FileWriter((filename));
			bufferedWriter = new BufferedWriter(fileIn);
			printWriter = new PrintWriter(bufferedWriter);	
			switch(filename) {
			case "projects.txt": 		
				System.out.println();
				for(int line = 0; line < projectsList.size(); line++) {
					printWriter.println(projectsList.get(line).toString("saveToFile"));
				}
				System.out.println("\t\tFile sucessfully updated.");
				printWriter.close();
				break;
			case "projectFinances.txt": 			
				for(int line = 0; line < projectsFinancesList.size(); line++) {
					printWriter.println(projectsFinancesList.get(line).toString("saveToFile"));	
				}
				System.out.println("\t\tFile sucessfully updated.");
				printWriter.close();
				break;
			case "invoices.txt": 
				for(int line = 0; line < invoicesList.size(); line++) {
					printWriter.println(invoicesList.get(line).toString("saveToFile"));
				}
				System.out.println("\t\tFile sucessfully updated.");
				printWriter.close();
				break;
			case "entities.txt":  				
				for(int line = 0; line < entitiesList.size(); line++) {
					printWriter.println(entitiesList.get(line).toString("saveToFile"));
				}
				System.out.println("\t\tFile sucessfully updated.");
				printWriter.close();
				break;
			case "entityDetails.txt": 
				for(int line = 0; line < entitiesDetailsList.size(); line++) {
					printWriter.println(entitiesDetailsList.get(line).toString("saveToFile"));				
				}
				System.out.println("\t\tFile sucessfully updated.");
				printWriter.close();
				break;
			case "receipts.txt": 
				for(int line = 0; line < receiptsList.size(); line++) {
					printWriter.println(receiptsList.get(line).toString("saveToFile"));				
				}
				System.out.println("\t\tFile sucessfully updated.");
				printWriter.close();
				break;
			default:
				break;
			}

		}		
		catch(IOException updateRecordError) {
			System.out.println("\t\tUpdateRecord: " + updateRecordError);
		}		
	}
	/* Method to retrieve the list of a project's finances */
	public static List<ProjectFinance> getProjectFinances(){
		String splitStr =  "";
		String clientCode = "";
		String projectCode = ""; 
		String projectName = "";
		double projectFee = 0.00d;
		double amountPaid = 0.00d;

		try {
			if(projectsFinancesList != null) {
				projectsFinancesList = new ArrayList<>();
				List<String> fileInfo = readFromFile("projectFinances.txt");

				for(int x = 0; x < fileInfo.size(); x++) {	
					splitStr = fileInfo.get(x);
					String[] splitStrSize = splitStr.split(";");
					projectCode = splitStrSize[0];	
					clientCode = splitStrSize[1];	
					projectName = splitStrSize[2];
					projectFee = Double.parseDouble(splitStrSize[3]);
					amountPaid = Double.parseDouble(splitStrSize[4]);
					ProjectFinance projectFinance = new ProjectFinance(projectCode, projectName, clientCode,  projectFee, amountPaid);
					projectsFinancesList.add(projectFinance);
				}
			}
		}catch(IOException getProjectFinancesError) {

			System.out.println("\t\tGetProjectFinances: " + getProjectFinancesError );
		}

		return  projectsFinancesList;
	}
	/* Method to retrieve the project details  and store the information in a list */
	public static List<ProjectInfo> getProjects() {
		String splitStr =  "";
		String projectCode;
		String projectName;
		String buildingType;
		String projectAddress;
		String erfNumber;
		LocalDate projectStart;
		LocalDate projectDue;
		String architectEntityCode;
		String contractorEntityCode;
		String clientEntityCode;
		boolean projectFinalized;
		boolean archiveProject;
		boolean deleteProject;

		try {
			if(projectsList != null) {
				projectsList = new ArrayList<>();
				List<String> fileInfo = readFromFile("projects.txt");
				for(int x = 0; x < fileInfo.size(); x++) {	
					splitStr = fileInfo.get(x);
					String[] splitStrSize = splitStr.split(";");

					projectCode = splitStrSize[0];
					projectName = splitStrSize[1];
					buildingType = splitStrSize[2];
					projectAddress = splitStrSize[3];
					erfNumber = splitStrSize[4];
					String[] startDate = splitStrSize[5].split("-");
					projectStart = LocalDate.of(Integer.parseInt(startDate[0])
							, Integer.parseInt(startDate[1])
							, Integer.parseInt(startDate[2]));

					String[] dueDate = splitStrSize[6].split("-");
					projectDue = LocalDate.of(Integer.parseInt(dueDate[0])
							, Integer.parseInt(dueDate[1])
							, Integer.parseInt(dueDate[2]));

					architectEntityCode = splitStrSize[7];
					contractorEntityCode = splitStrSize[8];
					clientEntityCode = splitStrSize[9];
					projectFinalized = Boolean.parseBoolean(splitStrSize[10]);
					archiveProject =  Boolean.parseBoolean(splitStrSize[11]);
					deleteProject =  Boolean.parseBoolean(splitStrSize[12]);
					String[] projectData = {projectCode, projectName, buildingType, projectAddress, erfNumber
							, architectEntityCode, contractorEntityCode, clientEntityCode}; 

					ProjectInfo projectInfo = new ProjectInfo(projectStart,  projectDue,  projectFinalized,
							archiveProject,  deleteProject, projectData);
					projectsList.add(projectInfo);
				}
			}	
		}
		catch(IOException getProjectsError) {
			System.out.println("\t\tGetProjects: " + getProjectsError);
		}
		return projectsList;
	}
	/* Method to retrieve the invoice details and store the information in a list */
	public static List<Invoice> getInvoices() {		
		String splitStr;
		LocalDate invoiceDate;
		int invoiceNumber;
		double amountOutstanding;
		double amountPaid;
		boolean cancelInvoice;
		String clientCode;
		String clientName;
		String clientEmailAddress;
		String clientContactNumber;
		String clientAddress;
		String projectCode;
		String projectName;
		String projectErfNumber;
		String projectAddress;
		LocalDate projectDeadline;
		double projectFee;
		try {
			if(invoicesList != null) {
				invoicesList = new ArrayList<>();
				List<String> fileInfo = readFromFile("invoices.txt");
				for(int x = 0; x < fileInfo.size(); x++) {	
					splitStr = fileInfo.get(x);
					String[] splitStrSize = splitStr.split(";");
					invoiceNumber = Integer.parseInt(splitStrSize[0]);
					String[] invDate = splitStrSize[1].split("-");
					invoiceDate = LocalDate.of(Integer.parseInt(invDate[0])
							, Integer.parseInt(invDate[1])
							, Integer.parseInt(invDate[2]));	
					clientCode = splitStrSize[2];
					clientName = splitStrSize[3];
					clientContactNumber = splitStrSize[4];
					clientEmailAddress = splitStrSize[5];
					clientAddress = splitStrSize[6];
					projectCode =  splitStrSize[7];
					projectName = splitStrSize[8];
					projectErfNumber = splitStrSize[9];
					projectAddress = splitStrSize[10];
					String[] projectDue = splitStrSize[11].split("-");
					projectDeadline = LocalDate.of(Integer.parseInt(projectDue[0])
							, Integer.parseInt(projectDue[1])
							, Integer.parseInt(projectDue[2]));
					projectFee = Double.parseDouble(splitStrSize[12]);

					amountOutstanding = Double.parseDouble(splitStrSize[13]);
					amountPaid = Double.parseDouble(splitStrSize[14]);
					cancelInvoice = Boolean.getBoolean(splitStrSize[15]);

					double[] projectFinance = {projectFee, amountPaid, amountOutstanding};

					String[] invoiceData = {clientCode, clientName, clientEmailAddress, clientContactNumber,
							clientAddress, projectCode, projectName, projectErfNumber, clientEmailAddress
							, projectAddress}; 

					Invoice invoiceInfo = new Invoice(invoiceNumber,  invoiceDate,  projectDeadline,
							cancelInvoice,  projectFinance, invoiceData);	

					invoicesList.add(invoiceInfo);
				}
			}	
		}
		catch(IOException getInvoicesError) {

			System.out.println("\t\tGetInvoices: " + getInvoicesError);
		}
		return invoicesList;
	}
	/* Method to retrieve a list of the employees and clients and store the information in a list  */
	public static List<Entity> getEntities() {		

		String entityCode;
		String entityName;
		String entityType;
		String splitStr;
		try {
			if(entitiesList != null) {
				entitiesList = new ArrayList<>();
				List<String> fileInfo = readFromFile("entities.txt");

				for(int x = 0; x < fileInfo.size(); x++) {		
					splitStr = fileInfo.get(x);
					String[] splitStrSize = splitStr.split(";");
					entityCode = splitStrSize[0];	
					entityName = splitStrSize[1];	
					entityType = splitStrSize[2];

					Entity entity = new Entity(entityCode, entityName, entityType);
					entitiesList.add(entity);
				}
			}
		}
		catch(IOException getEntitiesError) {

			System.out.println("\t\tGetEntites: " + getEntitiesError);
		}
		return entitiesList;
	}
	/* Method to retrieve the employee and client details and store the information in a list */
	public static List<EntityDetails> getEntityDetails() {

		String splitStr;
		String entityCode;
		String complexName;
		String complexNumber;
		String street;
		String city;
		String postalCode;
		String email;
		String contactNumber;
		LocalDate employStartDate;
		LocalDate employEndDate;
		boolean archiveEntity;
		try {
			if(entitiesDetailsList != null) {
				entitiesDetailsList = new ArrayList<>();
				List<String> fileInfo = readFromFile("entityDetails.txt");
				for(int x = 0; x < fileInfo.size(); x++) {	
					splitStr = fileInfo.get(x);
					String[] splitStrSize = splitStr.split(";");
					entityCode = splitStrSize[0];
					complexName = splitStrSize[1];
					complexNumber = splitStrSize[2];
					street = splitStrSize[3];
					city = splitStrSize[4];
					postalCode = splitStrSize[5];
					email = splitStrSize[6];
					contactNumber = splitStrSize[7];
					if (splitStrSize[8] == null) {
						String[] employStart = splitStrSize[8].split("-");
						employStartDate = LocalDate.of(Integer.parseInt(employStart[0])
								, Integer.parseInt(employStart[1])
								, Integer.parseInt(employStart[2]));
					}
					else {
						employStartDate = null;
					}
					if (splitStrSize[9] == null) {
						String[] employEnd = splitStrSize[9].split("-");
						employEndDate = LocalDate.of(Integer.parseInt(employEnd[0])
								, Integer.parseInt(employEnd[1])
								, Integer.parseInt(employEnd[2]));
					}
					else {
						employEndDate = null;
					}
					archiveEntity = Boolean.getBoolean(splitStrSize[10]);

					String[] entityData = {entityCode, complexName, complexNumber, street, city, postalCode, email, contactNumber};
					EntityDetails entityInfo = new EntityDetails(employStartDate, employEndDate, archiveEntity, entityData);
					entitiesDetailsList.add(entityInfo);
				}
			}	
		}
		catch(IOException entitiesDetailsListError) {
			System.out.println("\t\tGetEntitiesDetails: " + entitiesDetailsListError);
		}
		return entitiesDetailsList;
	}
	/* Method to view a list of all the receipts*/
	public static List<Receipt> viewReceipts(){

		String splitStr;
		int receiptNumber;
		LocalDate receiptDate = null;
		String clientCode;
		String projectCode;
		double amountPaid;

		try {
			if(receiptsList != null) {
				System.out.println("\t\tGetReceipts: ");
				receiptsList = new ArrayList<>();
				List<String> fileInfo = readFromFile("receipts.txt");
				for(int line = 0; line < fileInfo.size(); line++) {	
					splitStr = fileInfo.get(line);
					String[] splitStrSize = splitStr.split(";");
					receiptNumber = Integer.parseInt(splitStrSize[0]);
					if (splitStrSize[0] != null) {
						String[] recDate = splitStrSize[1].split("-");
						receiptDate = LocalDate.of(Integer.parseInt(recDate[0])
								, Integer.parseInt(recDate[1])
								, Integer.parseInt(recDate[2]));
					}
					else {
						receiptDate = null;
					}
					clientCode = splitStrSize[2];
					projectCode = splitStrSize[3];
					amountPaid = Double.parseDouble(splitStrSize[4]);
					String[] receiptData = {clientCode, projectCode};
					Receipt entityInfo = new Receipt(receiptNumber, receiptDate, amountPaid, receiptData);
					System.out.println(entityInfo.toString());
					receiptsList.add(entityInfo);
				}


				return receiptsList;
			}
		}catch(Exception getReceiptsError) {

			System.out.println("\t\tGetReceipts: " + getReceiptsError);
		}

		return receiptsList;
	}
	/*#############################################################################################################*/
	/* Method to display a list of projects that are still work in progress*/
	public  static void unfinishedProjects() { //Main Menu Option 1
		System.out.println("\t\t ---- 1) Unfinished Projects ----");
		int unfinishedProjectCount = 0;
		try {
			int projectSize = projectsList.size();
			System.out.println("\t\t"+ projectSize);
			for(int x = 0; x < projectSize; x++) {
				if(!projectsList.get(x).getProjectFinalized()
						&& !projectsList.get(x).getDeleteProject()
						&& !projectsList.get(x).getArchiveProject()) {
					System.out.println("\t\t"+ projectsList.get(x).toString("project"));
					System.out.println();
					unfinishedProjectCount++;
				}
			}
			if (unfinishedProjectCount == 0) {

				System.out.println("\t\tThere are no unfinished projects.");
			}
		}catch(Exception unfinishedProjectsError) {
			System.out.println("\t\tError in displaying the project details");
			System.out.println("\t\tUnfinishedProjects: " + unfinishedProjectsError);
		}

	}
	/* Method to display a list of projects that are work in progress after the due date*/
	public  static void pastDueProjects() { //Main Menu Option 2
		System.out.println("\t\t---- 2) Past Due Projects ----");
		int pastDueCount = 0;
		try {
			LocalDate today = LocalDate.now();
			for (ProjectInfo element : projectsList) {
				LocalDate thisProjectDeadline =  element.getProjectDueDate();
				if(today.isAfter(thisProjectDeadline)
						&& !element.getDeleteProject()
						&& !element.getArchiveProject()
						&& !element.getProjectFinalized()) {
					System.out.println("\t\tProject #" + element.getProjectCode()
					+ " is past the due date of " + element.getProjectDueDate() + "\n" );
					pastDueCount++;
				}
			
			}
		if(pastDueCount == 0) {
			System.out.println("\t\tNo overdue projects to show.");
		}
		}catch(Exception pastDueProjectsError) {
			System.out.println("\t\tError in capturing the project details");
			System.out.println("\t\tPastDueProjects: " + pastDueProjectsError);
		}
	}
	/*#############################################################################################################*/
	/* Sub method to create a project finances object that is used to store the financial information about the project*/
	public static void addProjectFinance(String projectCode) {
		
		String projectName = "";
		String clientCode = "";
		double projectFee = 0.0d;
		double depositPaid = 0.0d;	
		try 
		{
			for(int line = 0; line < projectsList.size(); line++) {
				if (projectsList.get(line).getProjectCode().matches(projectCode)) {
					projectName = projectsList.get(line).getProjectName();
					clientCode = projectsList.get(line).getclientCode();

					System.out.print("\t\tTotal project fee\t: R ");
					projectFee = Double.parseDouble(input.nextLine());
					
					ProjectFinance newPF = new ProjectFinance(projectCode, projectName, clientCode, projectFee, depositPaid);
					saveToFile("projectFinance", newPF);
					projectsFinancesList.add(newPF);					
				}
		}
		}catch(Exception addProjectFinanceError) {
			System.out.println("\t\tInput not recognised, please try again");
			System.out.println("\t\tAddProjectFinance: " + addProjectFinanceError);
		}
	}
	/* Method that displays the project options menu from which the user can choose from a number of options */
	public  static void projectOptions() { //Main Menu Option 3

		int subOption = 1;
		do { 
			try {
				System.out.println("\t\t---- 3) Project Options ----");
				System.out.println("\t\t1: New Project");
				System.out.println("\t\t2: Finalize Project");
				System.out.println("\t\t3: Update Project");
				System.out.println("\t\t4: Archive Project");
				System.out.println("\t\t5: Search for a Project");
				System.out.println("\t\t6: Delete a Project");
				System.out.println("\t\t7: Receive Payment");
				System.out.print("\t\t0: Back to Main Menu: ");
				subOption = Integer.parseInt(input.nextLine());
				switch(subOption) {
				case 1: // New Project
					String projectCode = addProject();
					addProjectFinance(projectCode);
					break;
				case 2: // Finalize Project
					finalizeProject();
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
				case 6: // Delete a project
					deleteProject();
					break;
				case 7: // Receive Payment
					addProjectPayment();
					break;
				case 0: // Back to main menu
					break;
				default:
					System.out.println("\t\tInput entered is not recognised, please try again");
				}
			}catch(NumberFormatException projectMenuError) {
				System.out.println("\t\tInput not recognised, please try again");
				System.out.println("\t\tProjectMenu: " + projectMenuError);
			}
		}while(subOption != 0);
	}
	/* Method the allows the user to add multiple new projects, saving it in the current list and appending the record to the file*/
	public  static String addProject(){
		System.out.println("\t\t---- 1) New Project ----");
		String projectCode = "";
		int yesNo = 0;
		do { 
			try { 
				String clientName = ""; 
				projectCode = "PR" + (projectsList.size() + 1);
				System.out.println("\t\tProject Code: " + projectCode);
				System.out.println("\t\tPlease enter the following information:");
				System.out.print("\t\tEnter Client(CL) Code: ");
				String clientCode = input.nextLine();

				for (Entity element : entitiesList) {
					if (clientCode.equalsIgnoreCase(element.entityCode)) {
						System.out.print("\t\t" + element.toString());
						clientName = element.entityName.substring(element.entityName.indexOf(" "));
					}
				}
				System.out.print("\r\n\t\tProject Name: ");
				String projectName = input.nextLine();
				if (projectName.isEmpty()) {
					projectName = clientName + " Building project";
					System.out.println("\t\tProject Name: " + projectName);
				}
				// Building Type
				System.out.print("\t\tBuilding Type: ");
				String buildingType = input.nextLine();
				System.out.print("\t\tProject Address: ");
				String projectAddress = input.nextLine();
				System.out.print("\t\tErf Number: ");
				String erfNumber = input.nextLine();
				System.out.print("\t\tProject Start Date (YYYY-MM-DD) format\n" );
				String newStartDateInput = input.nextLine();
				String[] startDate = newStartDateInput.split("-");
				LocalDate newDate  = LocalDate.of(Integer.valueOf(startDate[0]), Integer.valueOf(startDate[1]), Integer.valueOf(startDate[2]));
				System.out.print("\t\tProject Due Date (YYYY-MM-DD) format\n" );
				String newDeadlineInput = input.nextLine();
				String[] deadline = newDeadlineInput.split("-");
				LocalDate newDeadlineDate  = LocalDate.of(Integer.valueOf(deadline[0]), Integer.valueOf(deadline[1]), Integer.valueOf(deadline[2]));
				System.out.print("\t\tEnter Architect Code");
				String architectCode = input.nextLine();
				System.out.println("\t\tEnter Contractor Code");
				String contractorCode = input.nextLine(); 
				boolean projectFinalized = false;
				boolean archiveProject = false;
				boolean deleteProject = false;

				String[] projectData = {projectCode, projectName, buildingType, projectAddress, erfNumber, architectCode, contractorCode, clientCode};
				ProjectInfo newProject = new ProjectInfo(newDate, newDeadlineDate, projectFinalized, archiveProject, deleteProject, projectData);
				saveToFile("project", newProject);
				projectsList.add(newProject);
				addProjectFinance(projectCode);
				System.out.println("\t\tProject saved successfully.");

				System.out.print("\t\tCreate the invoice? 1) Yes or 0) No: ");
				int createInvoiceYesNo = Integer.parseInt(input.nextLine());
				if(createInvoiceYesNo == 1) {
					addInvoice();
				}
			}catch(Exception addProjectError) {
				System.out.println("\t\tError in capturing the project details");
				System.out.println("\t\tAddProject: " + addProjectError);
				System.out.println("\t\tTry again? 1) Yes, 0) no");
				yesNo = Integer.parseInt(input.nextLine());
			}
		}while(yesNo != 0);
		return projectCode;
	}
	/* Main method that allows the user to update  multiple individual project records*/
	public  static void updateProject() {
		String findRecord = "";

		//###### UPDATE PROJECT DETAILS
		do {
			try { 
				for(int x = 0; x < projectsList.size(); x++) {
					System.out.println("\t\t"+ (x +1) + ") " + projectsList.get(x).toString("updateProject")); 
				}
				System.out.println("\t\tEnter a project code or name name to update");
				findRecord = input.nextLine();
				for(int x = 0; x < projectsList.size(); x++) {
					if (findRecord.equalsIgnoreCase(projectsList.get(x).getProjectCode())) {
						updateProjectDetails(x); 
					}
				}
			}catch(Exception updateProjectError) {
				System.out.println("\t\tThere was a problem, please check that your input is correct.");
				System.out.println("\t\tUpdateProject" + updateProjectError);
			}
		}while(!findRecord.equalsIgnoreCase(""));
	}
	/* Sub method to update the details of the selected project's details */
	private static void updateProjectDetails(int lineNr) {
		System.out.println("\t\t"+ projectsList.get(lineNr).toString("UpdateProjectRecord"));
		int response = 0;
		do {
			try { 
				System.out.println("\t\tProject Code: " + projectsList.get(lineNr).getProjectCode());
				System.out.println("\r\n\t\tSelect what to update:");
				System.out.println("\t\t\t1) Project Name");
				System.out.println("\t\t\t2) Building Type");
				System.out.println("\t\t\t3) Physical Address");
				System.out.println("\t\t\t4) Erf Number");
				System.out.println("\t\t\t5) Start Date");
				System.out.println("\t\t\t6) Due Date");
				System.out.println("\t\t\t7) Architect code");
				System.out.println("\t\t\t8) Contractor code");
				System.out.println("\t\t\t9) Client code");
				System.out.println("\t\t\t10) Finalize project");
				System.out.println("\t\t\t11) Archive project");
				System.out.println("\t\t\t12) Delete project");		
				System.out.print("\t\t\t0) Go Back: ");

				response = Integer.parseInt(input.nextLine()); 
				switch(response) {
				case 1:
					System.out.print("\t\tEnter new project name: ");
					String projectName =  input.nextLine(); 
					projectsList.get(lineNr).setProjectName(projectName);
					break;
				case 2:
					System.out.print("\t\tEnter new building type: " );
					String buildingType = input.nextLine();
					projectsList.get(lineNr).setBuildingType(buildingType);
					break;
				case 3:
					System.out.print("\t\tEnter the project address: " );
					String projectAddress = input.nextLine();
					projectsList.get(lineNr).setProjectAddress(projectAddress);
					break;
				case 4: 
					System.out.print("\t\tEnter the erf number: " );
					String erfNumber = input.nextLine();
					projectsList.get(lineNr).setErfNumber(erfNumber);
					break;
				case 5:
					System.out.print("\t\tEnter the start date: " );
					String startDate = input.nextLine();
					String[] startArr = startDate.split("-");
					projectsList.get(lineNr).setProjectStartDate(LocalDate.of(Integer.valueOf(startArr[0]), Integer.valueOf(startArr[1]), Integer.valueOf(startArr[2])));
					break;
				case 6:
					System.out.print("\t\tEnter the due date: " );
					String due = input.nextLine(); 
					String[] dueArr = due.split("-");
					projectsList.get(lineNr).setProjectStartDate(LocalDate.of(Integer.valueOf(dueArr[0]), Integer.valueOf(dueArr[1]), Integer.valueOf(dueArr[2])));
					break;
				case 7: 
					System.out.print("\t\tEnter acrchitect code: " );
					String architectCode = input.nextLine();
					projectsList.get(lineNr).setArchitectCode(architectCode);
					break;
				case 8: 
					System.out.print("\t\tEnter the contractor code: " );
					String contractCode = input.nextLine();
					projectsList.get(lineNr).setContractorCode(contractCode);
					break;
				case 9:
					System.out.print("\t\tEnter the client code: " );
					String clientCode = input.nextLine();
					projectsList.get(lineNr).setclientCode(clientCode);
					break;
				case 10: // Archived
					projectsList.get(lineNr).setArchiveProject();
					break;
				case 11: 
					projectsList.get(lineNr).setProjectFinalized(false);
					break;
				case 12:
					projectsList.get(lineNr).setDeleteProject();
					break;
				case 0:
					System.out.println();
					break;
				default :
					System.out.println("\t\tPlease try again, input not recognised.");
				}
			}catch(Exception updateEntityError) {
				System.out.println("\t\tError in capturing the entity details, please check your information and try again");
				System.out.println("\t\tUpdateEntity: " + updateEntityError);
			}	
		}while(response != 0);

		updateRecords("projects.txt");		

	}
	/* Method to add a new project payment and deduct the amount from the  amount outstanding, displaying a receipt upon the validation
	 * of the amount */
	public  static void addProjectPayment() {

		System.out.println("\t\t---- 7) Add Project Payment ----");
		int yesNo = 1;
		double payment = 0.0;
		
			try { 
				System.out.print("\t\tEnter project code\t: ");
				String projectCode = input.nextLine().toUpperCase();
				for (int line = 0; line < projectsFinancesList.size(); line++ ) {
					if(projectsFinancesList.get(line).getProjectCode().matches(projectCode)) {
						System.out.println("\t\t"+ projectsFinancesList.get(line).toString());
					if(projectsFinancesList.get(line).getAmountOutstanding() > 0.00) {
						System.out.print("\t\tMake payment? 1) Yes or 0) No?: ");
						yesNo = Integer.parseInt(input.nextLine());
						if(yesNo == 1) {
							payment = checkPaymentAmount(projectsFinancesList.get(line).getAmountOutstanding() );
							projectsFinancesList.get(line).setAmountPaid(payment);
							//Receipt printout
							System.out.println("\t\t - - - - Payment Advice: - - - -");
							System.out.println("\t\tPayment received, thank you.");
							System.out.println();
							System.out.println("\t\tReceipt Number: " + (receiptsList.size() + 1));
							System.out.println("\t\tStatement Date: " + LocalDate.now());
							System.out.println("\t\t________________________________");
							System.out.println("\t\tProject Fee\t: R " + projectsFinancesList.get(line).getProjectFee());
							System.out.println("\t\tPayment received: R " + payment);
							System.out.println("\t\tAmount Paid\t: R " + (projectsFinancesList.get(line).getAmountPaid()));
							System.out.println("\t\t________________________________");
							System.out.println("\t\tTotal Now Due\t: R " + projectsFinancesList.get(line).getAmountOutstanding() );

							updateRecords("projectFinances.txt");
						}
						int receiptNumber = receiptsList.size() + 1;
						LocalDate receiptDate = LocalDate.now();

						System.out.println("\t\t" + projectsFinancesList.get(line).getClientCode());
						String clCode = projectsFinancesList.get(line).getClientCode();
						String prCode = projectsFinancesList.get(line).getProjectCode();
						double amountPaid = payment;
						String[] receiptData = {clCode, prCode};
						Receipt receiptInfo = new Receipt(receiptNumber, receiptDate, amountPaid, receiptData);

						saveToFile("receipt", receiptInfo );
						receiptsList.add(receiptInfo);
						break;
					}
					}
				}
			}catch(Exception addProjectPaymentError) {
				System.out.println("\t\tError in capturing the project details, please check your information and try again.");
				System.out.println("\t\tAddProjectPayment: " + addProjectPaymentError);
			}

	}
	/* Method to mark a project record as deleted*/
	public  static void deleteProject() {

		System.out.println("\t\t---- 6) Delete Project ----");
		for(int x = 0; x < projectsList.size(); x++) {
			System.out.println("\t\t" + (x +1) + ") " + projectsList.get(x).toString("project")); 
		}
		System.out.print("\t\tSelect the project code to delete: ");
		String projectNr = input.nextLine();
		for (ProjectInfo element : projectsList) {
			if (element.getProjectCode().equalsIgnoreCase(projectNr)){
				element.setDeleteProject();
				updateRecords("projects.txt");
				System.out.print("\t\tThe record has been deleted.");		
			}
		}
	}
	/* Method to search for a project record, the user enters the valid project code in order to view the information*/
	private  static void searchProject() {
		int recordFound = 0;
		System.out.println("\t\t---- Option 5) Search for Project ----");
		/* find a project by name or code */
		System.out.print("\t\tEnter the project code or project name to search: ");
		String projectNr = input.nextLine();
		for(int x = 0; x < projectsList.size(); x++) {
			if (projectsList.get(x).getProjectCode().equalsIgnoreCase(projectNr)
					|| projectsList.get(x).getProjectName().equalsIgnoreCase(projectNr)){
				System.out.println("\t\t"+ (x +1) + ") " + projectsList.get(x).toString());
				recordFound++;
				break;
			}
		}
		if (recordFound == 0) {

			System.out.println("\t\tNo such record exists");
		}
	}
	/* Sub method to mark a project as finalized. The use may enter either the project code or the indexed position */
	private static void projectToFinalize(String projectNr) {

		System.out.println("\t\tFinalizing projectNr: " + projectNr);

			for (int line = 0 ; line < projectsList.size(); line++) {
				if (projectsList.get(line).getProjectCode().equalsIgnoreCase(projectNr) ) {
					projectsList.get(line).setProjectFinalized(true);
					updateRecords("projects.txt");
					System.out.println("\t\tProject has been marked as finalised.");
				}
			}
		}
	public static void viewProjectFinances() {
		
		for(int x = 0; x < projectsFinancesList.size(); x++) {
			System.out.println("\t\t" + (x + 1) + ")" + projectsFinancesList.get(x).toString() + "\r\n");
		}
	}
	/* Main method to mark a project as finalized. A list of projects are displayed from which the user may select a project
	 * and mark it as finalized by setting the boolean value to true. */
	public  static void  finalizeProject(){

		System.out.println("\t\t---- 2) Finalize Project ----");
		for(int x = 0; x < projectsList.size(); x++) {
			System.out.println("\t\t" + (x + 1) + ")" + projectsList.get(x).getProjectCode()
					+ "\t" + projectsList.get(x).getclientCode());
		}
		try { 
			System.out.print("\t\tEnter the project code to finalize: ");
			String projectNr = input.nextLine().toUpperCase(); 
			for(int y = 0; y < projectsList.size(); y++) {
				if(projectsList.get(y).getProjectCode().equalsIgnoreCase(projectNr)){
					System.out.print("\t\tAre you sure you want to finalize the project? 1) Yes, 0) No: ");
					int yesNo = Integer.parseInt(input.nextLine()); 
					switch(yesNo) {
					case 1:
						projectToFinalize(projectNr);
						break;
					case 0:
						System.out.println("\t\tThe project has not been finalized.");
						break;
					default:
						System.out.println("\t\tInput is not recognised, please try again.");
					}		
				}
			}
		}catch(Exception finalizeProjectError) {
			System.out.println("\t\tError in capturing the project details, please try again.");
			System.out.println("\t\tFinalizeProject: " + finalizeProjectError);
		}
	}
	/* Method to mark a project as archived. A list of projects are displayed from which the user may select a project and
	 * archive it by setting the boolean value to true*/
	public  static void archiveProject() {
		System.out.println("\t\t---- Option 4) Archive Project ----");
		for(int x = 0; x < projectsList.size(); x++) {
			System.out.println("\t\t" + (x +1) + ") " + projectsList.get(x));
		}
		try {
			System.out.print("\t\tSelect the project code to archive: ");
			String projectNr = input.nextLine();
			for (ProjectInfo element : projectsList) {
				if (element.getProjectCode().equalsIgnoreCase(projectNr)){
					element.setArchiveProject();
					updateRecords("projects.txt");
				}
			}
		}catch(Exception archiveProjectError){
			System.out.println("\t\tError in capturing the project details");
			System.out.println("\t\tArchiveProject: " + archiveProjectError);
		}
	}
	/*#############################################################################################################*/
	/* Method to display the menu that allows the user to change the information of the entities*/
	/* Method to add a new entity , update details of the selected entity and search for an entity by entering the 
	 * relevant entity code */
	public  static void entityOptions(String entityCode){ //Main Menu Option 4,5 and 6
		int subOption = 0;
		int entityMenuOption = 0;
		String newEntityType = "";
		switch(entityCode){
		case "CL":
			newEntityType = "Client";
			entityMenuOption = 6;
			break;
		case "CO":
			newEntityType = "Contractor";
			entityMenuOption = 4;
			break;
		case "AR":
			newEntityType = "Architect";
			entityMenuOption = 5;
			break;
		default:
			System.out.println("\t\tUnknown entity type. ");
			break;
		}
		do { 
			System.out.println("\r\n\t\t ---- " + entityMenuOption + ") " + newEntityType + " Options ----");
			System.out.println("\t\t1: New " + newEntityType);
			System.out.println("\t\t2: Update " + newEntityType + " details");
			System.out.println("\t\t3: See list of " + newEntityType + "s");
			System.out.println("\t\t0: Back to Main Menu: ");
			try {
				subOption = Integer.parseInt(input.nextLine());
				switch(subOption) {
				case 1: // New entity
					addEntity(entityCode); 
					break;
				case 2: // Update entity details
					updateEntityData(entityCode);
					updateRecords("entityDetails.txt");
					break;
				case 3: // Search for an entity
					for (int pos = 0; pos < entitiesList.size(); pos++) {
						if(entitiesList.get(pos).entityCode.contains(entityCode))
							System.out.println("\t\t"+ entitiesList.get(pos).toString());
					}
					break;
				case 0: // Back to main menu
					break;
				default:
					System.out.println("\t\tInput entered is not recognised, please try again");
				}
			}catch(Exception archiveProjectError){
				System.out.println("\t\tError in capturing the project details");
				System.out.println("\t\tArchiveProject: " + archiveProjectError);
				System.out.println("\t\tTry again? 1) Yes, 0) No");
				subOption = Integer.parseInt(input.nextLine());
			}
		}while(subOption != 0);
	}
	/* Method to allow the user to update an entities stored details */
	public  static void updateEntityData(String entity){
		System.out.println("\t\t---- 2) Update Entity Details ----");
		int counter = 1;
		for(int m = 0; m < entitiesList.size(); m++){
			if (entitiesList.get(m).entityCode.contains(entity)) {
				System.out.println("\t\t" + counter +") " + entitiesList.get(m).entityCode + ": " + entitiesList.get(m).entityName);
				counter++;
			}
		}
		do {
			try { 
				System.out.print("\r\n\t\tEnter the client or personnel code, 0 to go back: " );
				entity = input.nextLine().toUpperCase();
				int typeCount = 1;
				for(int y = 0; y < entitiesList.size(); y++) {
					if(entitiesList.get(y).entityCode.equalsIgnoreCase(entity)) {
						System.out.println(typeCount + ") " + entitiesList.get(y).toString() );
						System.out.println(typeCount + ") " + entitiesDetailsList.get(y).toString() );
						typeCount++;
						updateEntity(y);
					}
				}
			}
			catch(Exception entityDataError) {
				System.out.println("\t\tError in capturing the entity details. Kindly check your information and try again.");
				System.out.println("\t\tEntityData: " + entityDataError);
			}
		}while(!entity.equalsIgnoreCase("0"));
	}
	/* Method to count the number of clients/contractors/architects are in the entities list */
	private static int countEntityType(String entityType) {
		int count = 0;
		for (Entity element : entitiesList) {
			if(element.entityCode.contains(entityType)) {
				count ++;
			}
		}
		return count;
	}
	/* Method to add a new client, contractor or architect*/
	private  static void addEntity(String entityType) {

		System.out.println("\t\t---- 1) New Entity ----");
		try { 
			String newEntityType = "";
			int nextEntityNr = 0;
			System.out.print("\t\tEntity Type");
			switch(entityType){
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
			System.out.println("\t\tEntity Type" + newEntityType);
			System.out.println();
			System.out.print("\t\t" + newEntityType + " Code: ");
			String newEntityCode = entityType + (nextEntityNr + 1);
			System.out.print("\t\t" + newEntityCode);
			System.out.println();			
			System.out.print("\t\tFull Name: ");
			String newEntityName = input.nextLine();
			System.out.print("\t\tEnter Complex Number: ");
			String complexNumber = input.nextLine();
			System.out.print("\t\tEnter the Complex Name: " );
			String complexName = input.nextLine();
			System.out.print("\t\tEnter New Street Name: " );
			String street = input.nextLine();
			System.out.print("\t\tEnter New City: " );
			String city = input.nextLine();
			System.out.print("\t\tEnter New Postal Code: " );
			String postal = input.nextLine();
			System.out.print("\t\tEnter New Email Address: " );
			String email = input.nextLine();
			System.out.print("\t\tEnter New Contact Number: " );
			String contact = input.nextLine();
			LocalDate startDate;
			if(entityType.contains("CO") || entityType.contains("AR")) {
				System.out.print("\t\tEnter Employment Start Date (Ex. 2022-01-01): " );
				String start = input.nextLine();
				String[] startArr = start.split("-");
				startDate = LocalDate.of(Integer.parseInt(startArr[0]), Integer.parseInt(startArr[1]), Integer.parseInt(startArr[2]));
			}
			else {
				startDate = null;
			}
			LocalDate endDate = null; 
			boolean archive = false;
			Entity newEntity = new Entity(newEntityCode, newEntityName, newEntityType);
			String[] newEntityDetails = {newEntityCode, complexNumber, complexName, street, city, postal, email, contact};
			EntityDetails newEntityInfo = new EntityDetails(startDate, endDate, archive,  newEntityDetails);
			entitiesList.add(newEntity);
			entitiesDetailsList.add(newEntityInfo);
			saveToFile("entity", newEntity);
			saveToFile("entityDetails", newEntityInfo);
		}catch(NumberFormatException addEntityError) {
			System.out.println("\t\tError in capturing the entity details");
			System.out.println("\t\tAddEntity: " + addEntityError);
		}
	}
	/* Method to update the selected entity's details*/
	private  static void updateEntity(int position) {

		int yesNo = 1;		
		do {
			System.out.println("\t\tSelect what to update:");
			System.out.println("\t\t\t1) Complex Number");
			System.out.println("\t\t\t2) Complex Name");
			System.out.println("\t\t\t3) Street");
			System.out.println("\t\t\t4) City");
			System.out.println("\t\t\t5) Postal Code");
			System.out.println("\t\t\t6) Email");
			System.out.println("\t\t\t7) Contact Number");
			System.out.println("\t\t\t8) Employment Start");
			System.out.println("\t\t\t9) Temination Date");
			System.out.println("\t\t\t10) Archived");
			System.out.print("\t\t\t0) Go Back: ");
			try {
				int response = Integer.parseInt(input.nextLine());
				switch(response) {
				case 1: // Complex Number
					System.out.print("\t\tEnter New Complex Number: ");
					String number = input.nextLine();
					entitiesDetailsList.get(position).setComplexNumber(number);
					break;
				case 2: // Complex Name
					System.out.print("\t\tEnter New Complex Name: " );
					String complexName = input.nextLine(); 
					entitiesDetailsList.get(position).setComplexName(complexName);
					break;
				case 3: // Street
					System.out.print("\t\tEnter New Street Name: " );
					String street = input.nextLine();
					entitiesDetailsList.get(position).setStreet(street);
					break;
				case 4: // City
					System.out.print("\t\tEnter New City: " );
					String city = input.nextLine();
					entitiesDetailsList.get(position).setCity(city);
					break;
				case 5: // Postal Code
					System.out.print("\t\tEnter New Postal Code: " );
					String postal = input.nextLine(); 
					entitiesDetailsList.get(position).setPostalCode(postal);
					break;
				case 6: // Email
					System.out.print("\t\tEnter New Email Address: " );
					String email = input.nextLine();
					entitiesDetailsList.get(position).setEmail(email);
					break;
				case 7: // Contact Number
					System.out.print("\t\tEnter New Contact Number: " );
					String contact = input.nextLine();
					entitiesDetailsList.get(position).setContactNumber(contact);
					break;
				case 8:// Employment Start
					System.out.print("\t\tEnter Employment Start Date (Ex. 2022-01-01): " );
					String start = input.nextLine();
					String[] startArr = start.split("-");
					entitiesDetailsList.get(position).setEmployStartDate(LocalDate.of(Integer.valueOf(startArr[0]), Integer.valueOf(startArr[1]), Integer.valueOf(startArr[2])));
					break;
				case 9: // Termination Date
					System.out.print("\t\tEnter Termination Date (Ex. 2022-01-01): " );
					String termDate = input.nextLine();
					String[] termDateArr = termDate.split("-");
					entitiesDetailsList.get(position).setEmployEndDate(LocalDate.of(Integer.valueOf(termDateArr[0]), Integer.valueOf(termDateArr[1]), Integer.valueOf(termDateArr[2])));
					break;
				case 10: // Archived
					boolean trueFalse = entitiesDetailsList.get(position).getArchiveEntity();
					if (!trueFalse) {
						entitiesDetailsList.get(position).setArchiveEntity(true);
					}
					else
					{
						System.out.print("\t\tRestore the file? 1) Yes or 0) No? : " );
						yesNo = Integer.parseInt(input.nextLine()); 

						if(yesNo == 1) {
							entitiesDetailsList.get(position).setArchiveEntity(false);
						}
						else
						{
							System.out.println("\t\tNo changes were made. " );
						}
					}
					break;
				case 0:
					System.out.println();
					yesNo = 0;
					break;
				default :
					System.out.println("\t\tPlease try again, input not recognised.");
				}
			}catch(Exception updateEntityError) {
				System.out.println("\t\tError in capturing the entity details, pleas check your information and try again.");
				System.out.println("\t\tUpdateEntity: " + updateEntityError);
			}
		}while (yesNo != 0);
	}
	/*#############################################################################################################*/
	/* Method to display the menu that allows the user to add invoices, cancel invoices and search for a particular invoice*/
	public  static void invoiceOptions() { //Main Menu Option 7

		int subOption = 0;
		do {
			System.out.println("\t\t---- 7) Invoice Options ----");
			System.out.println("\t\t\t1) Create Invoice");
			System.out.println("\t\t\t2) Cancel Invoice");
			System.out.println("\t\t\t3) Search for Invoice");
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
			}catch(Exception invoiceOptionsError){
				System.out.println("\t\tError in capturing the project details");
				System.out.println("\t\tError: " + invoiceOptionsError);
				System.out.println("\t\tTry again? 1) Yes, 0) No");
				subOption = Integer.parseInt(input.nextLine()); 
			}
		}while(subOption != 0);
	}
	/* Method to add a new invoice */
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
			try {
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
						clientAddress = entitiesDetailsList.get(x).toString("addInvoice");
						System.out.println("\t\tClient Address: " + clientAddress);
						clientContact = entitiesDetailsList.get(x).getContactNumber();
						System.out.println("\t\tClient Contact Number: " + clientContact);
						clientEmail = entitiesDetailsList.get(x).getEmail();
						System.out.println("\t\tClient e-mail: " + clientEmail);
					}
				}
				System.out.print("\t\tProject Code: ");
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
				LocalDate projectDueDate = projectsList.get(0).getProjectDueDate();
				System.out.println("\t\tProject Due date: " + projectDueDate);
				for (ProjectFinance element : projectsFinancesList) {
					if(element.getProjectCode().equalsIgnoreCase(projectCode)) {
					projectFee = element.getProjectFee();
					System.out.println("\t\tProject Fee: R " + projectFee);
					System.out.print("\t\tDeposit Amount: R ");
					amountPaid = Double.parseDouble(input.nextLine());
					amountOutstanding = projectFee - amountPaid;
					System.out.println("\t\tOutstanding Amount: R " + amountOutstanding);
					}					
				}
				double[] projectFinance = {projectFee, amountPaid, amountOutstanding};
				String[] invoiceData = {clientCode, clientName, clientContact, clientEmail, clientAddress, projectCode, projectName, projectAddress, erfNumber};
				Invoice newInvoice = new Invoice(invoiceNr, invoiceDate, projectDueDate, cancelInvoice, projectFinance,invoiceData);

				saveToFile("invoice", newInvoice);
				invoicesList.add(newInvoice);
				subOption = 0;
			}
			catch(Exception addInvoiceError) {
				System.out.println("\t\tError in capturing the project details");
				System.out.println("\t\taddInvoiceError: " + addInvoiceError);
				System.out.println("\t\tTry again? 1) Yes, 0) No");
				subOption = Integer.parseInt(input.nextLine());
			}
		}while(subOption != 0);
		System.out.println("\t\tA deposit of minimum 25% of the project cost is required to commence the project.");
		System.out.print("\t\tMake the payment now? 1) Yes or 0) No: ");
		int yesNo = Integer.parseInt(input.nextLine());
		
		if (yesNo == 1) {
			addProjectPayment();
		}
	}
	/* Method to mark an invoice as canceled by setting the boolean value to true*/
	private static void cancelInvoice(int invoiceNr) {

		System.out.println("\t\t---- 2) Cancel Invoice ----");
		System.out.println("\t\tThis cannot be undone. Are you sure? 1) Yes, 0) No");
		int yesNo = Integer.parseInt(input.nextLine()); 
		if(yesNo == 1) {
			invoicesList.get(invoiceNr).setCancelInvoice();
			System.out.println("\t\tThe invoice has been cancelled.");
		}
		else if(yesNo == 0){
			System.out.println("\t\tNo changes were made to the invoice.");
		}
		else {
			System.out.println("\t\tInput not recognised. The operation was cancelled ");
		}
	}
	/* Method to search for a particular invoice and display the data on-screen. The user may enter either the exact project 
	 * code or the exact project name*/
	private  static void searchInvoice() {

		System.out.println("\t\t---- 3) Search for Invoice ----");
		System.out.print("\t\tEnter the invoice number: ");
		int invoiceNr =  Integer.parseInt(input.nextLine());
		for(int x = 0; x < invoicesList.size(); x++) {
			if (invoicesList.get(x).getInvoiceNumber() == invoiceNr){
				System.out.println(invoicesList.get(x).toString());
			}
		}
	}
	/* Method to check if the amount entered by the user is greater than zero and less than the total amount outstanding on the
	 * project fee */
	private  static double checkPaymentAmount(double outstandingAmount ) {

		int subOption = 0;
		double paymentAmount = 0d;
		do {
			try {
				System.out.print("\t\tAmount\t: ");
				paymentAmount = Double.parseDouble(input.nextLine());
				if(paymentAmount > outstandingAmount || paymentAmount < 0.00) {
					System.out.println("\t\tThe amount entered is either greater than the outstanding balance or negative."
							+ "\t\tPlease try again" );
				}
			}catch(Exception checkPaymentAmountError) {
				System.out.println("\t\tError in capturing the project details, please check your information and try again.");
				System.out.println("\t\tCheckPaymentAmount: " + checkPaymentAmountError);
				System.out.println("\t\tTry again? 1) Yes, 0) No");
				subOption = Integer.parseInt(input.nextLine());
			}
		}while(paymentAmount > outstandingAmount || paymentAmount < 0.00 || subOption == 1);
		return paymentAmount;
	}
}