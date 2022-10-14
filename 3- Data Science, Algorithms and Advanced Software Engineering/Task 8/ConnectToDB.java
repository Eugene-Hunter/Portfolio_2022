/** 
 * @author Eugene Hunter
@version 1*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectToDB {

	private ConnectToDB() {}

	private static Scanner input = new Scanner(System.in);
	/* Order of Tags

Include tags in the following order:
@param (methods and constructors only)
@return (methods only)
@exception NullPointerException, SQLException
@see
@since
@serial (or @serialField or @serialData)
@deprecated (see How and When To Deprecate APIs)*/

	public static String createViews() {
		String stringProj = "create view viewProjects as Select * from project;";
		String stringPojInfo = "create view viewProjectInfo as Select * from projectInfo;";
		String countClients = "select max(entityCode) from entity where entityCode like 'CO%'";
		// count how many of a position is in DB and add first letter of the employee type assign next value
		String createEmployeeCode = "create view viewProjects as Select * from project;";
		return "";
	}

	/** Handles all the SQL DB queries for the various other methods and displays the information returned from the database
	 * according to the query received from the various functions.. 

	@param view, info
	@exception SQLException
	@see
	 */
	public static void displayViews(String view, String info) throws SQLException {
		try
		(Connection connection = ConnectToDB.connectToDB();
				Statement statement = connection.createStatement();
				ResultSet results = statement.executeQuery(info);
				){
			int count = 0;
			switch(view) {
			case "projectlist":
				System.out.println("\r\n");
				while (results.next()) {
					count++;
					System.out.print("\t\t" + count + ") " );
					System.out.print("Project#: " + results.getString("projectCode"));
					System.out.println(" | Project Name : " + results.getString("projectName"));
				}
				System.out.println("\r\n");
				break;
			case "project":
				while (results.next()) {
					System.out.print("Project#: " + results.getString("projectCode"));
					System.out.println(" | Project Name : " + results.getString("projectName"));
					System.out.print("\t\t   Client# : " + results.getString("clientCode"));
					System.out.print(" | Architect# : " + results.getString("architectCode"));
					System.out.print(" | Contractor# : " + results.getString("contractorCode"));
					System.out.print(" | Manager# : " + results.getString("managerCode"));
					System.out.println("\r\n");
					count++;
				}
				break;
			case "projectInfo":
				while (results.next()) {
					System.out.println("\r\n\tProject#: " + results.getString("projectCode"));
					System.out.println("\t\tErf Number\t\t: " + results.getString("erfNumber"));
					System.out.println("\t\tProject address\t\t: " + results.getString("projectAddress"));
					System.out.println("\t\tPostal Code\t\t: " + results.getInt("postalCode"));
					System.out.println("\t\tType Building\t\t: " + results.getString("buildingType"));
					System.out.println("\t\tCommence Date\t\t: " + results.getString("projectStartDate"));
					System.out.println("\t\tDue Date\t\t: " + results.getString("projectDueDate"));
					if(results.getString("projectFinalized") == null) {
						System.out.println("\t\tDate Finalized\t\t: No");
					}
					else {
						System.out.println("\t\tDate Finalized\t\t: " + results.getString("projectFinalized"));
					}
					if(results.getInt("archiveProject") == 0) {
						System.out.println("\t\tProject Archived\t: No");
					}
					else {
						System.out.println("\t\tProject Archived\t: Yes");
					}
				}
				break;
			case "projectFinances":

				while (results.next()) {
					System.out.println("\t\tProject Fee\t\t: R " + results.getFloat("projectFee"));
				}
				System.out.println();
				break;
			case "receipt":
				System.out.println("\r\n");
				while (results.next()) {
					System.out.println("\t\tReceipt#\t: " + results.getString("receiptNumber"));
					System.out.println("\t\tDate\t\t: " + results.getString("receiptDate"));
					System.out.println("\t\tInvoice#\t: " + results.getString("invoiceNumber"));
					System.out.println("\t\tAmount\t\t: " + results.getFloat("receiptAmount"));
					System.out.println("\t\tDescription\t: " + results.getString("receiptDescription"));
					System.out.println("\t\tPayment method\t: " + results.getString("paymentMethod"));
					if(!(results.getString("cancelReason").isBlank())){
						System.out.println("\t\tCancel Reason\t: " + results.getString("cancelReason"));
					}
				}
				break;
			case "viewProjectFinances":
				while (results.next()) {
					System.out.println("\t\tProject#\t\t: " + results.getInt("projectCode"));
					System.out.println("\t\tProject Fee\t\t: R " + results.getFloat("projectFee"));
					System.out.println("\t\tAmount paid\t\t: R " + results.getFloat("amountPaid"));
				}
				break;
			case "employeeInfo":
				while (results.next()) {
					//System.out.println("\t\tRecord:#\t: " + results.getString("employeeCode"));
					System.out.println("\t\tDOB/ID\t\t: " + results.getString("DOB_ID"));
					System.out.println("\t\tEmployment Date\t: " + results.getString("employStartDate"));
					System.out.println("\t\tTermination Date\t: " + results.getString("employEndDate"));
					System.out.println("\t\tSalary\t\t: " + results.getString("salary"));
					System.out.println();
				}
				break;
			case "entity":
				while(results.next()) {
					System.out.println("\t\tRecord:#\t: " + results.getString("entityCode"));
					System.out.println("\t\tName\t: " + results.getString("entityName"));
					System.out.println("\t\tComplex\t\t: " + results.getString("complexDetails"));
					System.out.println("\t\tStreet\t\t: " + results.getString("streetAddress"));
					System.out.println("\t\tPostal Code\t: " + results.getInt("postalCode"));
					System.out.println("\t\tEmail\t\t: " + results.getString("email"));
					System.out.println("\t\tContact#\t: " + results.getString("contactNumber"));
					if(results.getInt("archiveEntity") == 0) {
						System.out.println("\t\tArchived\t: No");
					}
					else {
						System.out.println("\t\tArchived\t: Yes");
					}
					System.out.println("\t\tDate Added\t: " + results.getString("recordDate"));
				}
				break;
			case "employeeInformation":
				while(results.next()) {
					System.out.println("\t\tEmployee#\t\t: " + results.getString("employeeCode"));
					System.out.println("\t\tEmployment Date\t\t: " + results.getString("employStartDate"));
					System.out.println("\t\tResignation Date\t\t: " + results.getString("employEndDate"));
					System.out.println("\t\tDOB/ID#\t\t: " + results.getString("DOB_ID"));
					System.out.println("\t\tSalary\t\t: " + results.getFloat("Salary"));
					System.out.println("\t\tPosition\t\t: " + results.getString("Position"));
				}
				break;
			case "projectFinance":
				while(results.next()) {
					System.out.println("\t\tProject#\t\t: " + results.getInt("projectCode"));
					System.out.println("\t\tProject Fee\t\t: " + results.getFloat("projectFee"));
					System.out.println("\t\tOutstanding Balancet\t\t: " + results.getFloat("amountPaid")
							);
				}
				break;
			case "invoice":
				while(results.next()) {
					System.out.println("\t\tInvoice#\t\t: " + results.getInt("invoiceNumber"));
					System.out.println("\t\tDate\t\t: " + results.getFloat("invoiceDate"));
					System.out.println("\t\tProject Code\t\t: " + results.getString("projectCode"));
					System.out.println("\t\tInvoice Canceled? 0) No = 1) Yes\t\t: " + results.getInt("cancelInvoice"));
					System.out.println("\t\tCancel Reason\t\t: " + results.getString("cancelReason"));

				}
				break;
			case "postalDetails":
				while(results.next()) {
					System.out.println("\t\tCity\t\t: " + results.getString("city"));
					System.out.println("\t\tPostal Code\t\t: " + results.getInt("postalCode"));
					System.out.println("\t\tProvince\t\t: " + results.getString("province"));
					System.out.println("\t\tCountry\t\t: " + results.getString("country"));
				}
				break;
			case "postalDetailsTable":
				System.out.println( "Postal Code\t| City \t| Province \t| Country \t|");
				while (results.next()) {
					count++;
					System.out.println("\t| " + results.getString("postalCode") + " | "
							+ "\t| " + results.getString("city") + " | "
							+ "\t| " + results.getString("province") + " | "
							+ "\t| " + results.getString("country") + " | "
							);
					System.out.println();
				}
				break;
			case "employeeView":
				while(results.next()) {
					System.out.println("\t\tEmployee Code\t: " + results.getString("employeeCode"));
					System.out.println("\t\tName\t\t: " + results.getString("entityName"));
					System.out.println("\t\tComplex\t\t: " + results.getString("complexDetails"));
					System.out.println("\t\tStreet\t\t: " + results.getString("streetAddress"));
					System.out.println("\t\tPostal Code\t: " + results.getInt("postalCode"));
					System.out.println("\t\tEmail\t\t: " + results.getString("email"));
					System.out.println("\t\tContact#\t: " + results.getString("contactNumber"));
					System.out.println("\t\tEmployment Date\t: " + results.getString("employStartDate"));
					System.out.println("\t\tTermination Date\t: " + results.getString("employEndDate"));
					System.out.println("\t\tDOB/ID\t\t: " + results.getString("DOB_ID"));
					System.out.println("\t\tSalary\t\t: R" + results.getString("salary"));
					if(results.getInt("archiveEntity") == 0) {
						System.out.println("\t\tArchived\t: No");
					}
					else {
						System.out.println("\t\tArchived\t: Yes");
					}
					System.out.println("\t\tDate Added\t: " + results.getString("recordDate"));

				}
				break;

			default:
				break;

			}
		}catch(SQLException updateProjectError) {
			updateProjectError.printStackTrace();
			System.out.println();
			System.out.println("Information was not saved due to an error, please try again.");
			System.out.println();
		}
	}
	/** Handles all the SQL DB statements in relation to the adding, updating and deletion of records
	 * to the database
	 * 
	 * Include tags in the following order:
	@param infoString
	@exception NullPointerException, SQLException
	@see
	 */
	public static void addUpdateDeleteRecord(String infoString) throws SQLException {

		try(Connection connection = ConnectToDB.connectToDB();
				Statement statement = connection.createStatement();
				){
			statement.executeUpdate(infoString);

		}catch(SQLException e)
		{
			System.out.print("connectToDB: ");
			e.printStackTrace();
			System.out.println();
		}
	}
	/** Initializes a connection object with the database. If successful and the database could be located,
	 * the connection is then returned to the calling function.
	 * Include tags in the following order:
	@return connection
	@exception SQLException
	@see
	 */
	public static Connection connectToDB() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/poisepms?allowPublicKeyRetrieval=true&useSSL=false",
					"otheruser",
					"swordfish"
					);
		}catch(SQLException e) {
			System.out.print("connectToDB: ");
			e.printStackTrace();
			System.out.println();
		}
		return connection;
	}
	/** Verifies the accuracy of the postal code 
	 * Include tags in the following order:
	@return postalCode
	@exception NullPointerException, SQLException
	@see
	 */
	private static String verifyPostalCode() throws NullPointerException, SQLException {
		int yesNo = 0;
		String postalCode = "";
		do {
			postalCode = input.nextLine();
			String selectCode = "SELECT * FROM postalDetails WHERE postalCode = '" + postalCode + "';";
			displayViews("postalDetails", selectCode);
			System.out.print("Is this correct? 1) Yes or 0) No: ");
			yesNo = Integer.parseInt(input.nextLine());
			if(yesNo == 1) {
				break;
			}
			else if (yesNo != 1) {
				System.out.print("Enter a different postal code: ");
				postalCode = input.nextLine();
				yesNo = 0;
			}
		}while(yesNo != 1);
		return postalCode;
	}
	/** Retrieves the last recorded project code in order to provide the result to the calling function
	 * Include tags in the following order:
	@param table, abbrType
	@return newID
	@exception NullPointerException, SQLException
	@see
	 */
	public static String getLastRecordID(String table, String abbrType) throws NullPointerException, SQLException{
		String id = "" ;
		String query = "";
		String newID = "";
		if( table.equalsIgnoreCase("project")) {
			query = "SELECT max(projectCode) FROM project;";
		}
		else if( table.equalsIgnoreCase("employeeInfo")) {
			query = "SELECT max(employeeCode) FROM employeeInfo WHERE employeeCode LIKE '" + abbrType + "%';";
		}
		else if(table.equalsIgnoreCase("entity")){
			query = "SELECT max(entityCode) FROM entity WHERE entityCode LIKE '" + abbrType + "%';";
		}
		try
		(Connection connect = connectToDB();
				Statement statement = connect.createStatement() ;
				ResultSet results  = statement.executeQuery(query);
				){
			while(results.next()) {
				id = results.getString(1);
				int idPlus1 =  Integer.parseInt(id.substring(2))+1;
				newID = id.substring(0,2) + idPlus1;
			}
		}catch(NullPointerException getLastRecordID) {
			System.out.println("getLastRecordID: " + getLastRecordID);
		}
		return newID;
	}
	/** Adds a new project record to the SQL DB 
	 * Include tags in the following order:
	@exception NullPointerException, SQLException
	@see
	 */
	public static void addProject() throws NullPointerException, SQLException {

		int yesNo = 0;
		do {
			try {
				System.out.print("Project Name\t: ");
				String projectName = input.nextLine();
				//Display a list of client codes and names
				System.out.print("Client Code\t: ");
				String clientCode = input.nextLine();
				System.out.print("Architect Code\t: ");
				String architectCode = input.nextLine();
				System.out.print("Contractor Code\t: ");
				String contractorCode = input.nextLine();
				System.out.print("Manager Code\t: ");
				String managerCode = input.nextLine();
				System.out.print("Erf Number\t: ");
				String erfNumber = input.nextLine();
				System.out.print("Project Address\t: ");
				String projectAddress  = input.nextLine();
				System.out.print("Postal Code\t: ");
				String postalCode  = verifyPostalCode();
				System.out.print("Buidling Type\t: ");
				String buildingType  = input.nextLine();
				System.out.print("Start Date\t: ");
				String projectStartDate  = input.nextLine();
				System.out.print("Due Date\t: ");
				String projectDueDate  = input.nextLine();
				String projectFinalized = "NULL";
				int archiveProject  = 0;
				System.out.print("Project Fee\t: ");
				float projectFee = Float.parseFloat(input.nextLine());
				float amountPaid = 0.00f;
				String proj = getLastRecordID("project", "");
				String saveProject = "INSERT INTO projectInfo VALUES("
						+ proj+ ", "
						+ projectName + ", "
						+ clientCode + ", "
						+ architectCode + ", "
						+ contractorCode + ", "
						+ managerCode + ");";
				addUpdateDeleteRecord(saveProject);
				String saveProjectInfo = "INSERT INTO projectInfo VALUES("
						+ proj+ ", "
						+ erfNumber + ", "
						+ projectAddress + ", "
						+ postalCode + ", "
						+ buildingType + ", "
						+ projectStartDate + ", "
						+ projectDueDate + ", "
						+ projectFinalized + ", "
						+ archiveProject + ");";
				String saveProjectFinances = "INSERT INTO projectFinances VALUES("
						+ proj+ ", "
						+ projectFee + ", "
						+ amountPaid + ");";
				addUpdateDeleteRecord(saveProjectInfo);
				addUpdateDeleteRecord(saveProjectFinances);
				System.out.print("Enter another project? 1) Yes or 0) No: ");
				yesNo = Integer.parseInt(input.nextLine());
			}catch (SQLException addProjectError) {
				System.out.print("addProject: ");
				addProjectError.printStackTrace();
				System.out.println();
				System.out.println("Information was not saved due to an error, please try again.");
				System.out.println();
				yesNo = 1;
			}
		}while(yesNo != 0);
	}
	/** Displays a list all the project codes and names
	 * The is asked to enter a valid project code or name.
	 * The user enters the project code or name, and a menu of options of each of the project's current information are displayed:
	 * The user enters the number corresponding to the field that is to be updated, whereby the user then enter the new information
	 * The record in the database is updated immediately and the system responds back whether the record had been successfully updated
	 * or not.
	 *    user will then be asked to enter a valid project code or name.
	 * @throws SQLException
	 */
	public static void updateProject() throws SQLException {

		//###### UPDATE PROJECT DETAILS
		int yesNo = 1;
		int projNum = 0;
		String updateRecord = "";
		do {
			String queryAll = "select * from viewProjects;";
			displayViews("project", queryAll);
			System.out.print("\r\n\t\tEnter Project#: ");
			projNum = Integer.parseInt(input.nextLine());
			String queryViewProjects = "SELECT * FROM project WHERE projectCode = '" + projNum + "';";
			String queryProjectInfo = "SELECT * FROM ProjectInfo WHERE projectCode = '" + projNum + "';";
			String queryProjectFinances = "SELECT projectFee FROM projectFinances WHERE projectCode = '" + projNum + "';";
			displayViews("project", queryViewProjects);
			displayViews("projectInfo", queryProjectInfo);
			displayViews("projectFinances", queryProjectFinances);
			System.out.println("\t\tProject Code: " + projNum);
			System.out.println("\r\n\t\tSelect what to update:");
			System.out.println("\t\t\t1) Project Name");
			System.out.println("\t\t\t2) Client code");
			System.out.println("\t\t\t3) Architect code");
			System.out.println("\t\t\t4) Contractor code");
			System.out.println("\t\t\t5) Manager code");
			System.out.println("\t\t\t6) Erf Number");
			System.out.println("\t\t\t7) Project Address");
			System.out.println("\t\t\t8) Postal Code");
			System.out.println("\t\t\t9) Building Type");
			System.out.println("\t\t\t10) Start Date");
			System.out.println("\t\t\t11) Due Date");
			System.out.println("\t\t\t12) Finalize project");
			System.out.println("\t\t\t13) Archive project");
			System.out.println("\t\t\t14) Update project fee");
			System.out.print("\t\t\t0) Go Back: ");
			yesNo = Integer.parseInt(input.nextLine());
			switch(yesNo) {
			case 1:
				System.out.print("\t\tEnter new project name: ");
				String projName =  input.nextLine();
				projName = projName.replace("'", "\\'");
				System.out.print(projName);
				updateRecord = "UPDATE Project SET projectName = '" + projName + "' WHERE projectCode = " + projNum + ";";
				addUpdateDeleteRecord(updateRecord);
				break;
			case 2:
				yesNo = 1;
				String clientCode = "";
				do {
					System.out.print("\t\tEnter the Client code: " );
					clientCode = input.nextLine().toUpperCase();

				}while (yesNo == 0);

				updateRecord = "UPDATE Project SET clientCode = '" + clientCode + "' WHERE projectCode = " + projNum + ";";
				addUpdateDeleteRecord(updateRecord);
				break;
			case 3:
				System.out.print("\t\tEnter Architect code: " );
				String architectCode = input.nextLine().toUpperCase();
				updateRecord = "UPDATE Project SET architectCode = '" + architectCode + "' WHERE projectCode = " + projNum + ";";
				addUpdateDeleteRecord(updateRecord);
				break;
			case 4:
				System.out.print("\t\tEnter the Contractor code: " );
				String contractorCode = input.nextLine().toUpperCase();
				updateRecord = "UPDATE Project SET contractorCode = '" + contractorCode + "' WHERE projectCode = " + projNum + ";";
				break;
			case 5:
				System.out.print("\t\tEnter the Manager code: " );
				String managerCode = input.nextLine().toUpperCase();
				updateRecord = "UPDATE Project SET managerCode = '" + managerCode + "' WHERE projectCode = " + projNum + ";";
				break;
			case 6:
				System.out.print("\t\tEnter the erf number: " );
				String erfNumber = input.nextLine().toUpperCase();
				updateRecord = "UPDATE ProjectInfo SET erfNumber = '" + erfNumber + "' WHERE projectCode = " + projNum + ";";
				break;
			case 7:
				System.out.print("\t\tEnter the project address: " );
				String projectAddress = input.nextLine();
				updateRecord = "UPDATE ProjectInfo SET architectCode = '" + projectAddress + "' WHERE projectCode = " + projNum + ";";
				break;
			case 8:
				System.out.print("\t\tEnter the project postal code: " );
				String postalCode = verifyPostalCode();
				updateRecord = "UPDATE ProjectInfo SET postalCode = '" + postalCode + "' WHERE projectCode = '" + projNum + "';";
				break;
			case 9:
				System.out.print("\t\tEnter new building type: " );
				String buildingType = input.nextLine();
				updateRecord = "UPDATE ProjectInfo SET buildingType = '" + buildingType + "' WHERE projectCode = " + projNum + ";";
				break;
			case 10:
				System.out.print("\t\tEnter the start date (YYY-MM-DD): " );
				String startDate = input.nextLine();
				projName = startDate.replace("/", "-");
				updateRecord = "UPDATE ProjectInfo SET projectStartDate = '" + startDate + "' WHERE projectCode = " + projNum + ";";
				break;
			case 11:
				System.out.print("\t\tEnter the due date (YYYY-MM-DD): " );
				String dueDate = input.nextLine();
				projName = dueDate.replace("/", "-");
				updateRecord = "UPDATE ProjectInfo SET projectDueDate = '" + dueDate + "' WHERE projectCode = " + projNum + ";";
				break;

			case 12: // Finalize project
				System.out.print("\t\tMark the project as finalized? 1) Yes or 0) No: " );
				yesNo = Integer.parseInt(input.nextLine());
				if (yesNo == 1) {
					System.out.print("\t\tDate Finalized: " + LocalDate.now());
					String finalDate = String.valueOf(LocalDate.now());
					updateRecord = "UPDATE ProjectInfo SET projectFinalized = '" + finalDate + "' WHERE projectCode = " + projNum + ";";
				}
				break;
			case 13: // Archive Project
				System.out.print("\t\tArchive the project? 1) Yes or 0) No: " );
				yesNo = Integer.parseInt(input.nextLine());
				if (yesNo == 1) {
					int archiveYesNo = 1;
					updateRecord = "UPDATE ProjectInfo SET archiveProject = '" + archiveYesNo + "' WHERE projectCode = " + projNum + ";";
				}
				break;
			case 14: // Update Project fee
				System.out.print("\t\tAre you sure you want to change the project fee? 1) Yes or 0) No: " );
				yesNo = Integer.parseInt(input.nextLine());
				if (yesNo == 1) {
					System.out.print("\t\tEnter the new amount: R" );
					float newProjectFee = Float.parseFloat(input.nextLine());
					updateRecord = "UPDATE ProjectFinances SET projectFee = '" + newProjectFee + "' WHERE projectCode = " + projNum + ";";
				}
				break;
			case 0:
				System.out.println();
				break;
			default :
				System.out.println("\t\tPlease try again, input not recognised.");
			}
			addUpdateDeleteRecord(updateRecord);
			System.out.println("\r\n");

		}while(yesNo != 0);
	}
	/** Marks a project as finalized and create an invoice 
	 * Include tags in the following order:
    @exception NullPointerException, SQLException
	@see
	 */
	public static void finalizeProject() throws NullPointerException, SQLException {
		int yesNo = 0;
		int projNum = 0;
		String updateRecord = "";

		String viewProject = "SELECT * FROM projectInfo WHERE projectFinalized IS NULL;";
		displayViews("projectInfo", viewProject);
		System.out.print("\r\n\t\tEnter Project#: ");
		projNum = Integer.parseInt(input.nextLine());
		System.out.print("\r\n\t\tAre you sure? 1) Yes or 0) No? ");
		yesNo = Integer.parseInt(input.nextLine());
		if (yesNo == 1) {
			updateRecord = "UPDATE ProjectInfo SET projectFinalized = '" + LocalDate.now() + "' WHERE projectCode = " + projNum + ";";
			addUpdateDeleteRecord(updateRecord);

			//TODO : CREATE INVOICE.
		}
		else if (yesNo == 0) {
			System.out.print("\r\n\t\tUpate was canceled.");
		}
		else
		{
			System.out.print("\r\n\t\tInput not recognised, please try again.");
		}
	}
	/** Adds client and employee records
	 * Include tags in the following order:
	@param entityType
	@exception NullPointerException, SQLException
	@see
	 */
	public static void addEntity(String entityType) throws NullPointerException, SQLException {

		String entity = "";
		String newClient = "";
		if ("E".equals(entityType)) {
			entity = "Employee";
		}
		else
		{
			entity = "Client";
		}
		System.out.println("\t\t----New " + entity);
		int yesNo = 0;
		do {
			try {
				System.out.print(entity + " Name\t: ");
				String entityName = input.nextLine();
				System.out.print("Complex Details\t: ");
				String complexAddress = input.nextLine();
				System.out.print("Street Address\t: ");
				String streetAddress = input.nextLine();
				System.out.print("Postal Code\t: ");
				String postalCode = verifyPostalCode();
				System.out.print(entity + " Email\t: ");
				String email = input.nextLine();
				System.out.print(entity + " Contact\t: ");
				String contact = input.nextLine();
				int archiveEntity  = 0;
				String recordDate = String.valueOf(LocalDate.now());
				String[] newEmployee;
				if(entityType.equalsIgnoreCase("E")) {
					newEmployee = addEmployee();
					String saveEntity = "INSERT INTO entity VALUES('"
							+ newEmployee[0] + "', '"
							+ entityName + "', '"
							+ complexAddress + "', '"
							+ streetAddress + "', '"
							+ postalCode + "', '"
							+ email + "', '"
							+ contact + "', '"
							+ archiveEntity + "', '"
							+ recordDate + "', '"
							+ entityType + "');";
					addUpdateDeleteRecord(saveEntity);
					System.out.println(newEmployee[0] + "," +
							newEmployee[1] + "," + newEmployee[2] + "," +
							newEmployee[3] + "," + newEmployee[4] + "," + newEmployee[5]) ;
					//for(int x = 0; x < newEmployee.length(); x++) {
					String employeeInfo ="'" + newEmployee[0]  + "', '"
							+ newEmployee[1] + "', "
							+ newEmployee[2] + ", '"
							+ newEmployee[3] + "', '"
							+ newEmployee[4] + "', '"
							+ newEmployee[5] + "'";
					//}
					String saveEmployeeInfo = "INSERT INTO employeeInfo VALUES(" + employeeInfo + ");";
					addUpdateDeleteRecord(saveEmployeeInfo);
				}
				else {
					newClient = getLastRecordID("entity","CL");
					//String[] newEntity = {newClient, entityName, complexAddress, streetAddress, String.valueOf(postalCode),
					//		email, contact, String.valueOf(archiveEntity), recordDate, entityType};
					String saveClientInfo = "INSERT INTO entity VALUES('"
							+ newClient + "', '"
							+ entityName + "', '"
							+ complexAddress + "', '"
							+ streetAddress + "', '"
							+ postalCode + "', '"
							+ email + "', '"
							+ contact + "', '"
							+ archiveEntity + "', '"
							+ recordDate + "', '"
							+ entityType + "');";
					addUpdateDeleteRecord(saveClientInfo);
				}
				System.out.print("Enter another " + entity + " record? 1) Yes or 0) No: ");
				yesNo = Integer.parseInt(input.nextLine());
			}catch (SQLException addClientError) {
				System.out.print("AddClient: ");
				addClientError.printStackTrace();
				System.out.println();
				System.out.println("Information was not saved due to an error, please try again.");
				System.out.println();
				yesNo = 1;
			}
		}while(yesNo != 0);

	}
	/** Selects the position of the new employee
	 * Include tags in the following order:
	@return positions
	@see
	 * */
	private static String positionSelect() {
		System.out.println("=== Select the position: === mark 1"	);
		// retrieve the list of positions from the database
		int colIndex = 1;
		int selectPos = 0;
		ArrayList<String> positions = new ArrayList<>();
		try (Connection connect = connectToDB();
				Statement statement = connect.createStatement();
				ResultSet results = statement.executeQuery("SELECT * FROM Positions ;");
				){
			System.out.println("\t\tSelect the position:"	);
			while(results.next()) {
				System.out.println("\t\t" + colIndex + ") " +  results.getString("description"));
				positions.add(results.getString("abbreviate"));
				colIndex++;
			}
			System.out.println("\t\t Position 0: " + positions.get(0));
			selectPos = Integer.parseInt(input.nextLine());
			return positions.get(selectPos - 1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	/** Completes the employee information that does not pertain to the clients
	 * Include tags in the following order:
	@return employeeInfo
	@exception NullPointerException, SQLException
	@see
	 * */
	public static String[] addEmployee() throws NullPointerException, SQLException {
		String[] employeeInfo = new String[6];
		try {
			//IF employeeType = "Contractor" then search the database for the highest contractor employee number
			//and assign the next value along with the character
			System.out.print("\t\tEmployment Date\t: ");
			String employDate = input.nextLine();
			employeeInfo[1] = employDate;
			String exitDate = "NULL";
			employeeInfo[2] = exitDate;
			System.out.print("\t\tDOB/ID Number\t: ");
			String dob = input.nextLine();
			employeeInfo[3] = dob;
			System.out.print("\t\tSelect Position\t: ");
			String position = positionSelect();
			employeeInfo[4] = position;
			String entityCode = getLastRecordID("employeeInfo", position);
			employeeInfo[0] = entityCode;
			System.out.print("Salary\t: R ");
			String salary = input.nextLine();
			employeeInfo[5] = salary;
			return employeeInfo;
		}catch (SQLException addClientError) {
			System.out.print("AddClient: ");
			addClientError.printStackTrace();
			System.out.println();
			System.out.println("Information was not saved due to an error, please try again.");
			System.out.println();
		}
		return employeeInfo;
	}
	/** Marks a project as archived Include tags in the following order:
	@exception SQLException
	@see
	 */
	public static void archiveProject() throws SQLException {
		int yesNo = 0;
		int projNum = 0;
		String updateRecord = "";

		String viewProject = "SELECT * FROM projectInfo WHERE projectFinalized IS NOT NULL;";
		displayViews("projectInfo", viewProject);
		System.out.print("\r\n\t\tEnter Project#: ");
		projNum = Integer.parseInt(input.nextLine());
		System.out.print("\r\n\t\tAre you sure? 1) Yes or 0) No? ");
		yesNo = Integer.parseInt(input.nextLine());
		if (yesNo == 1) {
			updateRecord = "UPDATE ProjectInfo SET archiveProject = " + 1  +" WHERE projectCode = " + projNum + ";";
			addUpdateDeleteRecord(updateRecord);
		}
		else if (yesNo == 0) {
			System.out.print("\r\n\t\tUpate was canceled.");
		}
		else
		{
			System.out.print("\r\n\t\tInput not recognised, please try again.");
		}

	}
	/** Searches for a project by entering either the project code of the project name. 
	 * Include tags in the following order:
	@exception SQLException
	@see
	 */
	public static void searchProject() throws SQLException {
		String searchCriteria = "";

		String viewProject = "SELECT projectCode, projectName FROM project ;";
		displayViews("projectlist", viewProject);
		System.out.print("\t\tEnter cearch criteria: ");
		searchCriteria = input.nextLine();
		viewProject = "SELECT * FROM project WHERE projectCode LIKE '%" + searchCriteria
				+ "%' OR projectName LIKE '%" + searchCriteria + "%' ;";
		displayViews("project", viewProject);
	}
	/** Deletes a project from the database
	 * Include tags in the following order:
	@exception SQLException
	@see
	 */
	public  static void deleteProject() throws SQLException {
		System.out.println("\t\t---- 6) Delete Project ----");
		int yesNo = 0;
		String searchCriteria = "";
		String projectSelect ;
		String viewProject = "SELECT * FROM project ;";
		displayViews("projectlist", viewProject);
		System.out.print("\t\tSelect project to delete: ");
		searchCriteria = input.nextLine();
		//@TODO: SEARCH FOR PAYMENTS MADE TO THE PROJECT AND PROHIBIT DELETION OF PROJECT

		System.out.print("\t\tAre you sure? 1) Yes or 0) No? ");
		yesNo = Integer.parseInt(input.nextLine());
		if (yesNo == 1) {
			projectSelect = "DELETE FROM Project WHERE projectCode = '" + searchCriteria + "' ;";
			addUpdateDeleteRecord(projectSelect);
		}
	}
	/** Displays the invoice options menu
	 * Include tags in the following order:
	@see
	 * */
	public  static void invoiceOptions() { //Main Menu Option 4

		int subOption = 0;
		do {
			System.out.println("\t\t---- 4) Invoice Options ----");
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
					cancelInvoice();
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
	/** Adds an invoice to the database
	 * Include tags in the following order:
	@exception SQLException
	@see
	 * */
	public  static void addInvoice() throws SQLException{
		int yesNo = 0;
		System.out.println("\t\t---- 1) New Invoice ----");
		int subOption = 0;
		String getProject;
		String getProjectFinances;
		do {
			try {
				System.out.println("\t\tInvoice Date: " + LocalDate.now());
				do {
					System.out.print("\t\tEnter the Project Code: ");
					int projectCode = Integer.parseInt(input.nextLine());
					getProject = "SELECT * FROM project where projectCode = '" + projectCode + "';";
					displayViews("projectlist", getProject);
					getProjectFinances = "SELECT * FROM projectFinances where projectCode = '" + projectCode + "';";
					displayViews("projectFinances", getProjectFinances);
					System.out.print("\t\tIs this correct? 1) Yes or 0) No: ");
					yesNo = Integer.parseInt(input.nextLine());
					if(yesNo == 1) {
						displayViews("project", getProject);
						displayViews("projectFinances", getProjectFinances);

					}
				}while(yesNo != 1);
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
		yesNo = Integer.parseInt(input.nextLine());

		if (yesNo == 1) {
			addProjectPayment();
		}
	}
	/** Marks an invoice as canceled by setting the boolean value to true
	 * 
	 * Include tags in the following order:
	@exception SQLException
	@see
	 */
	private static void cancelInvoice() throws SQLException {

		System.out.println("\t\t---- 2) Cancel Invoice ----");

		int yesNo = 0;
		do {
			System.out.print("\t\tEnter the invoice number to cancel or 0 to go back: ");
			int invoiceNr = Integer.parseInt(input.nextLine());
			if(invoiceNr != 0) {
				String searchInvoice = "SELECT * FROM invoice WHERE invoiceNumber = '" + invoiceNr + "';";
				displayViews("invoice", searchInvoice);
				int maxInvoices = Integer.parseInt(getLastRecordID("invoice", "invoiceNumber"));
				System.out.print("\t\t: ");
				if (invoiceNr < maxInvoices & invoiceNr > 0) {
					System.out.println("\t\tThis cannot be undone. Are you sure? 1) Yes, 0) No");
					yesNo = Integer.parseInt(input.nextLine());
					if(yesNo == 1) {
						String cancelInvoice = "UPDATE invoice SET cancelInvoice = 1 WHERE invoiceNumber = '" + invoiceNr + "';";
						addUpdateDeleteRecord(cancelInvoice);
					}
					else if(yesNo == 0){
						System.out.println("\t\tNo changes were made to the invoice.");
					}
					else {
						System.out.println("\t\tInput not recognised. The operation was cancelled ");
					}
				}
				else
					System.out.println("\t\tThe invoice number does not exist, kindly enter a different invoice number");
				yesNo = 1;
			}
		} while(yesNo != 0);
	}
	/** Displays the receipts options menu
	 */
	public  static void receiptOptions() { //Main Menu Option 4

		int subOption = 0;
		int invoiceNr = 0;
		do {
			System.out.println("\t\t---- 5) Receipt Options ----");
			System.out.println("\t\t\t1) Add Receipt");
			System.out.println("\t\t\t2) Cancel Receipt");
			System.out.println("\t\t\t3) View all receipts");
			System.out.println("\t\t\t0) Back to Main Menu");
			try {
				subOption = Integer.parseInt(input.nextLine());
				switch(subOption) {
				case  1: // Create Receipt
					System.out.print("\t\tEnter the invoice number to cancel or press enter to go back: ");
					invoiceNr = Integer.parseInt(input.nextLine());
					System.out.print("\t\tEnter the amount to be paid");
					float receiptAmount = Float.parseFloat(input.nextLine());
					addReceipt(invoiceNr, receiptAmount);
					break;
				case 2: // Cancel Receipt
					System.out.println("\t\t---- 2) Cancel Receipt ----");
					int yesNo = 0;
					do {
						System.out.print("\t\tEnter the receipt number to cancel or enter 0 to go back: ");
						int receiptNr = Integer.parseInt(input.nextLine());
						if(receiptNr != 0) {
							String searchReceipt = "SELECT * FROM receipt WHERE receiptNumber = " + receiptNr + ";";
							displayViews("receipt", searchReceipt);

							cancelReceipt(receiptNr);

						}
						else {
							System.out.println("\t\tThe receipt number does not exist, kindly enter a different invoice number");
							yesNo = 1;
						}

					} while(yesNo != 0);
					break;
				case 3: // View all receipts
					viewReceipts();
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
	/** Marks a receipt as canceled by setting the boolean value to true. The project's "amount paid" field is updated and the
	 * amount that was captured on the the receipt is deducted from the amount. Once a receipt has been marked as canceled is it not
	 * possible to change the value to 0 again.
	 * Include tags in the following order:
	@param receiptNr
	@exception SQLException
	@see
	 * */
	public static void cancelReceipt(int receiptNr) throws SQLException {
		System.out.println();
		String reason = "";
		System.out.println("\t\tThis cannot be undone. Are you sure? 1) Yes, 0) No");
		int yesNo = Integer.parseInt(input.nextLine());
		if(yesNo == 1) {
			System.out.print("\t\tEnter a reason for the cancellation of the receipt: ");
			reason = input.nextLine();
			String cancelReceipt = "UPDATE receipt SET cancelReceipt = 1, cancelReason = '" + reason + "' "
					+ "WHERE receiptNumber = " + receiptNr + " AND cancelReceipt = 0;";
			addUpdateDeleteRecord(cancelReceipt);
			//find the receipt amount from the canceled receipt
			int invNr = 0;
			float amount = 0.00f;
			int projectCode = 0;
			try(
					Connection connection = ConnectToDB.connectToDB();
					Statement statement1 = connection.createStatement();
					Statement statement2 = connection.createStatement();
					){

				String receiptAmount = "SELECT invoiceNumber, receiptAmount FROM receipt WHERE receiptNumber = " + receiptNr + ";";

				ResultSet results1 = statement1.executeQuery(receiptAmount);
				while(results1.next()) {	
					invNr = results1.getInt("invoiceNumber");
					amount = results1.getFloat("receiptAmount");
				}			
				String getProjectCode = "SELECT projectCode FROM invoice WHERE invoiceNumber = " + invNr + ";" ;  
				ResultSet results2 = statement1.executeQuery(getProjectCode);
				while(results2.next() ) {		
					projectCode = results2.getInt("projectCode");
				}
				// Update the project finances and deduct the receipt amount from the amountPaid
				String updateAmountPaid = "UPDATE projectFinances SET amountPaid = (amountPaid - " + amount + ") where projectCode = " + projectCode + ";";
				addUpdateDeleteRecord(updateAmountPaid);

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		else if(yesNo == 0){
			System.out.println("\t\tNo changes were made to the invoice.");
		}
		else {
			System.out.println("\t\tInput not recognised. The operation was cancelled ");
		}
	}
	/** Searches for an invoice that has not been canceled
	 * Include tags in the following order:
	@exception SQLException
	@see
	 * */
	public static void searchInvoice() throws SQLException {
		String searchCriteria = "";

		System.out.print("\t\tCurrent Invoices: ");
		String viewInvoice = "SELECT invoiceNumber, projectCode FROM project WHERE cancelInvoice = 0;";
		displayViews("invoicelist", viewInvoice);
		System.out.print("\t\tEnter cearch criteria: ");
		searchCriteria = input.nextLine();
		viewInvoice = "SELECT * FROM project WHERE projectCode LIKE '%" + searchCriteria
				+ "%' OR projectName LIKE '%" + searchCriteria + "%' ;";
		displayViews("invoice", viewInvoice);
		System.out.print("\r\n\t\tEnter cearch criteria: ");
	}
	/** Displays all the receipts, canceled receipts included 
	 * Include tags in the following order:
	@exception NullPointerException, SQLException
	@see
	 */
	public static void viewReceipts() throws SQLException {
		String viewProject = "SELECT * FROM receipt ;";
		displayViews("receipt", viewProject);
	}
	/** Displays the selected project's finances information 
	 * Include tags in the following order:
	@exception NullPointerException, SQLException
	@see
	 */
	public static void viewProjectFinances() throws SQLException {
		String viewProject = "SELECT * FROM projectFinances;";
		displayViews("viewProjectFinances", viewProject);
	}
	/** Displays the project options 
	 * Include tags in the following order:
	@exception NullPointerException, SQLException
	@see
	 */
	public  static void projectOptions() throws NullPointerException, SQLException { //Main Menu Option 3
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
					addProject();
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
	/** Adds a project payment 
	 * Include tags in the following order:
	@exception SQLException
	@see
	 */
	public  static void addProjectPayment() throws SQLException {

		System.out.println("\t\t---- 7) Add Project Payment ----");
		int yesNo = 1;
		float payment = 0.00f;
		String searchCriteria = "";
		String updateAmountPaid = "";
		String viewProject = "SELECT projectCode, projectName FROM project ;";
		displayViews("projectlist", viewProject);
		try {
			System.out.print("\t\tEnter project code\t: ");
			int projectCode = Integer.parseInt(input.nextLine());
			viewProject = "SELECT projectCode, projectName FROM project WHERE projectCode = '" + projectCode+ "';";
			displayViews("projectlist", viewProject);
			viewProject = "SELECT * FROM projectFinances WHERE projectCode = '" + projectCode+ "';";
			displayViews("viewProjectFinances", viewProject);
			System.out.print("\t\tMake payment now? 1) Yes or 0) No?: ");
			yesNo = Integer.parseInt(input.nextLine());
			if(yesNo == 1) {
				String getReceiptNumber = "SELECT max(receiptNumber) FROM receipt";
				payment = checkPaymentAmount(projectCode);
				updateAmountPaid = "UPDATE projectFinances SET amountPaid = '" + payment + "' WHERE projectCode = '" + projectCode + "';";
				addUpdateDeleteRecord(updateAmountPaid);
				//addReceipt(int invoiceNumber, float receiptAmount)
				int receiptNumber = addReceipt(1, payment);
				//Update amount paid
				//	projectsFinancesList.get(line).setAmountPaid(payment);
				//Receipt printout
				System.out.println("\t\t - - - - Payment Advice: - - - -");
				System.out.println("\t\tPayment received, thank you.");
				System.out.println();
				System.out.println("\t\tReceipt Number: " + "");
				System.out.println("\t\tStatement Date: " + LocalDate.now());
				System.out.println("\t\t________________________________");
				System.out.println("\t\tProject Fee\t: R " + "");
				System.out.println("\t\tPayment received: R " + payment);
				System.out.println("\t\tAmount Paid\t: R " + "");
				System.out.println("\t\t________________________________");
				System.out.println("\t\tTotal Now Due\t: R " + "" );


			}

		}catch(Exception addProjectPaymentError) {
			System.out.println("\t\tError in capturing the project details, please check your information and try again.");
			System.out.println("\t\tAddProjectPayment: " + addProjectPaymentError);
		}

	}
	/** Adds a receipt the user enters the invoice number and a receipt is generated that confirm the receipt of money 
	 * linked to the project on which the invoice is based
	 * Include tags in the following order:
	@param invoiceNumber, receiptAmount
	@return receiptNr
	@exception SQLException
	@see
	 * */
	private static int addReceipt(int invoiceNumber, float receiptAmount) throws SQLException {

		System.out.println("\t\t----Receipt----");
		System.out.print("\t\t Date: " + LocalDate.now());
		String receiptDate = String.valueOf(LocalDate.now());
		System.out.print("\t\t Invoice Number: " + invoiceNumber);
		System.out.print("\t\t Amount Received: R " + receiptAmount);
		System.out.print("\t\t Notes: ");
		String receiptDescription = input.nextLine();
		System.out.print("\t\t Payment method: ");
		String paymentMethod = input.nextLine();
		int cancelReceipt = 0;
		String cancelReason = "NULL";


		String saveReceipt = "INSERT INTO receipt VALUES('NULL', '" + receiptDate + "', '" + invoiceNumber + "', '" + receiptAmount + "',"
				+ "'" + receiptDescription + "','" + paymentMethod + "','" + cancelReceipt + "','" + cancelReason + "'  );";

		addUpdateDeleteRecord(saveReceipt);
		int receiptNr = Integer.parseInt(getLastRecordID("receipt","receiptNumber"));

		return receiptNr;
	}
	/** Checks if the amount entered is a valid amount by limiting the maximum amount allowed typed in 
	 * be limited to the outstanding balance of the project
	 * Include tags in the following order:
	@param projectCode
	@return paymentAmount
	@exception NullPointerException, SQLException
	@see
	 */
	private static float checkPaymentAmount(int projectCode) {

		String fromDB = "SELECT projectFee, amountPaid from projectFinances WHERE projectCode = '" + projectCode + "';";
		float projectFee = 0.00f;
		float amountPaid = 0.00f;
		float outstandingAmount = 0.00f;
		try
		(Connection connection = ConnectToDB.connectToDB();
				Statement statement = connection.createStatement();
				ResultSet results = statement.executeQuery(fromDB);
				){
			while (results.next()) {
				projectFee = results.getFloat("projectFee");
				amountPaid = results.getFloat("amountPaid");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		outstandingAmount = projectFee - amountPaid;
		float paymentAmount = 0.00f;
		do {
			System.out.print("\t\tAmount\t: R ");
			paymentAmount = Float.parseFloat(input.nextLine());
			if(paymentAmount > outstandingAmount || paymentAmount < 0.00) {
				System.out.println("\t\tThe amount entered is either greater than the outstanding balance or negative."
						+ "\t\tPlease try again" );
			}
		}while(paymentAmount > outstandingAmount || paymentAmount < 0.00);
		return paymentAmount;
	}
	/** Updates individual information fields for a selected project
	 * Include tags in the following order:
	@param entity
	@exception NullPointerException, SQLException
	@see
	 * */
	public static void updateEntity(String entity) throws SQLException {

		//###### UPDATE PROJECT DETAILS
		int menuOption = 1;
		String entityCode = "";
		String updateRecord = "";
		do {
			System.out.print("\r\n\t\tEnter " + entity + " code: ");
			entityCode = input.nextLine();
			String entityInfo = "SELECT * FROM entity WHERE entityCode = '" + entityCode + "';";
			displayViews("entity", entityInfo);
			if (entity.equalsIgnoreCase("employee")) {
				String employeeInfo = "SELECT * FROM employeeInfo WHERE employeeCode = '" + entityCode + "';";
				displayViews("employeeInfo", employeeInfo);
			}

			System.out.println("\r\n\t\tSelect what to update:");
			System.out.println("\t\t\t1) " + entity + " Name");
			System.out.println("\t\t\t2) " + entity + " Complex Address");
			System.out.println("\t\t\t3) " + entity + " Street Address");
			System.out.println("\t\t\t4) Postal Code");
			System.out.println("\t\t\t5) Email");
			System.out.println("\t\t\t6) Contact Number");
			System.out.println("\t\t\t7) Archive " + entity);
			if(entity.equalsIgnoreCase("Employee")) {
				System.out.println("\t\t\t8) Employment Date");
				System.out.println("\t\t\t9) Termination Date");
				System.out.println("\t\t\t10) DOB/ID");
				System.out.println("\t\t\t11) Salary");
				System.out.println("\t\t\t12) Position");
			}
			System.out.print("\t\t\t0) Go Back: ");
			menuOption = Integer.parseInt(input.nextLine());
			switch(menuOption) {
			case 1:
				System.out.print("\t\tEnter new name: ");
				String entityName =  input.nextLine();
				entityName = entityName.replace("'", "\\'");
				System.out.print(entityName);
				updateRecord = "UPDATE entity SET entityName = '" + entityName + "' WHERE entityCode = " + entityCode + ";";
				addUpdateDeleteRecord(updateRecord);
				break;
			case 2:
				System.out.print("\t\tEnter the complex address: " );
				String complex = input.nextLine().toUpperCase();
				updateRecord = "UPDATE entity SET complexDetails = '" + complex + "' WHERE entityCode = " + entityCode + ";";
				addUpdateDeleteRecord(updateRecord);
				break;
			case 3:
				System.out.print("\t\tEnter street address: " );
				String street = input.nextLine().toUpperCase();
				updateRecord = "UPDATE entity SET streetAddress = '" + street + "' WHERE entityCode = " + entityCode + ";";
				addUpdateDeleteRecord(updateRecord);
				break;
			case 4:
				System.out.print("\t\tEnter the postal code: " );
				String postal = verifyPostalCode();
				updateRecord = "UPDATE entity SET postalCode = '" + postal + "' WHERE entityCode = " + entityCode + ";";
				break;
			case 5:
				System.out.print("\t\tEnter the email address: " );
				String managerCode = input.nextLine().toUpperCase();
				updateRecord = "UPDATE entity SET email = '" + managerCode + "' WHERE entityCode = " + entityCode + ";";
				break;
			case 6:
				System.out.print("\t\tEnter the contact number: " );
				String erfNumber = input.nextLine().toUpperCase();
				updateRecord = "UPDATE entity SET contactNumber = '" + erfNumber + "' WHERE entityCode = " + entityCode + ";";
				break;
			case 7:
				System.out.print("\t\tArchive the " + entity + "?: " );
				int yesNo = Integer.parseInt(input.nextLine());
				if (yesNo == 1) {
					int archiveYesNo = 1;
					updateRecord = "UPDATE entity SET archiveEntity = " + archiveYesNo + " WHERE entityCode = " + entityCode + ";";
				}
				break;
			case 0:
				System.out.println();
				break;
			default :
				break;
			}
			if(entity.equalsIgnoreCase("Employee")) {
				switch(menuOption) {
				case 8:
					System.out.print("\t\tEnter the employment date (YYY-MM-DD): " );
					String employDate = input.nextLine();
					employDate = employDate.replace("/", "-");
					updateRecord = "UPDATE employeeInfo SET postalCode = '" + employDate + "' WHERE employeeCode = " + entityCode + ";";
					break;
				case 9:
					System.out.print("\t\tEnter the termination date (YYY-MM-DD): " );
					String termDate = input.nextLine();
					termDate = termDate.replace("/", "-");
					updateRecord = "UPDATE employeeInfo SET buildingType = '" + termDate + "' WHERE employeeCode = " + entityCode + ";";
					break;
				case 10:
					System.out.print("\t\tEnter the ID Number of Date of Birth: " );
					String id = input.nextLine();
					updateRecord = "UPDATE employeeInfo SET dob_id = '" + id + "' WHERE employeeCode = " + entityCode + ";";
					break;
				case 11:
					System.out.print("\t\tEnter the salary: R " );
					float salary = Float.parseFloat(input.nextLine());
					updateRecord = "UPDATE employeeInfo SET salary = " + salary + " WHERE employeeCode = " + entityCode + ";";
					break;
				default:
					break;
				}
			}
			if( menuOption > 0 && menuOption < 12) {
				addUpdateDeleteRecord(updateRecord);
				System.out.println("\r\n");
			}
		}while(menuOption != 0);
	}
	/** Archives client and employee profiles
	 *  Include tags in the following order:
	@param entity
	@exception NullPointerException, SQLException
	@see
	 * */
	public static void archiveEntity(String entityType) throws SQLException {
		int yesNo = 0;
		String entityCode = "";
		String updateRecord = "";

		System.out.print("\r\n\t\tEnter " + entityType + "to archive: ");
		entityCode = input.nextLine();
		System.out.print("\r\n\t\tAre you sure? 1) Yes or 0) No? ");
		yesNo = Integer.parseInt(input.nextLine());
		if (yesNo == 1) {
			updateRecord = "UPDATE ProjectInfo SET archiveEntity = " + 1  +" WHERE entityCode = " + entityCode + ";";
			addUpdateDeleteRecord(updateRecord);
		}
		else if (yesNo == 0) {
			System.out.print("\r\n\t\tUpate was canceled.");
		}
		else
		{
			System.out.print("\r\n\t\tInput not recognised, please try again.");
		}

	}
	/** Displays the employee details
	 * 
	 * 
	Include tags in the following order:
	@param entity
	@exception NullPointerException, SQLException
	@see
	 */
	public static void viewEmployees(String entity) throws SQLException {
		String employees = "";
		if(entity.equalsIgnoreCase("Employee")) {
			employees = "Select entity.*, employeeInfo.* from entity INNER JOIN employeeInfo on entity.entityCode = employeeInfo.employeeCode;";
			displayViews("employeeView", employees);
		}
	}
}
