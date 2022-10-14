import java.time.LocalDate;
import java.util.Scanner;

public class ProjectInfo {
// Create a class that will be used to create a project object.
	
	private String projectCode;
	private String projectName;
	private String buildingType;
	private String projectAddress;
	private String erfNumber;
	private LocalDate projectStartDate;
	private LocalDate projectDueDate;
	private String architectCode;
	private String contractorCode;
	private String clientCode;
	private boolean projectFinalized;
	private boolean archiveProject;
	private boolean deleteProject;

	
	public String getProjectCode(){
		return this.projectCode;	
	}
	public String getProjectName(){
		return this.projectName;	
	}
	public String getBuildingType(){
		return this.buildingType;	
	}
	public String getProjectAddress(){
		return this.projectAddress;	
	}
	public String getErfNumber(){
		return this.erfNumber;	
	}
	public LocalDate getProjectStartDate(){
		return this.projectStartDate;	
	}
	public LocalDate getProjectDueDate(){
		return this.projectDueDate;	
	}
	public String getArchtectCode(){
		return this.architectCode;	
	}
	public String getContractorCode(){
		return this.contractorCode;	
	}
	public String getclientCode(){
		return this.clientCode;
	}
	public boolean getProjectFinalized() {
		return this.projectFinalized;
	}
	public boolean getArchiveProject() {
		return this.archiveProject;
	}	
	public boolean getDeleteProject(){
		return this.deleteProject;
	}
	public void setProjectCode(String projectCode){
		this.projectCode = projectCode ;
	}
	public void setProjectName(String projectName){
		this.projectName = projectName ;
	}
	public void setBuildingType(String buildingType){
		this.buildingType = buildingType ;
	}
	public void setProjectAddress(String projectAddress){
		this.projectAddress = projectAddress ;
	}
	public void setErfNumber(String erfNumber){
		this.erfNumber = erfNumber ;
	}
	public void setProjectStartDate(LocalDate startDate){
		this.projectStartDate = startDate;
	}
	public void setNewProjectDueDate(LocalDate newProjectDeadline){
		this.projectDueDate =  newProjectDeadline;
			}		
	public void setArchitectCode(String architectCode){
		this.architectCode = architectCode;
	}
	public void setContractorCode(String contractorCode){
		this.contractorCode = contractorCode ;
	}
	public void setclientCode(String clientCode){
		this.clientCode = clientCode ;
	}
	public void setProjectFinalized(boolean trueFalse) {	
			this.projectFinalized = trueFalse;
			System.out.println("\t\tProjectInfo.java - The project has been finalized. " );
	}
	public void setArchiveProject(){
		Scanner option = new Scanner(System.in);
		if (!this.archiveProject) {
			this.archiveProject = true;
			System.out.println("\t\tThe record has been archived " );
		}
		else
		{
			System.out.print("\t\tRestore the file? Yes or No: " );
			int yesNo = Integer.parseInt(option.nextLine()); 
			if(yesNo == 1) {
				this.archiveProject = true;
				System.out.println("\t\tThe record has been restored " );
			}
			else
			{
				System.out.println("\t\tNo changes were made. " );
			}
		}
		option.close();
	}
	public void setDeleteProject(){
			this.deleteProject = true;
	}
	
	// method to instantiate a ProjectInfo object
	public ProjectInfo(LocalDate projectStart, LocalDate projectDue, boolean finalizeProject,
			boolean projectArchived, boolean projectDelete, String[] projectData) { 

		this.projectCode = projectData[0];
		this.projectName = projectData[1];
		this.buildingType = projectData[2];
		this.projectAddress = projectData[3];
		this.erfNumber = projectData[4];
		this.projectStartDate = projectStart;
		this.projectDueDate = projectDue;
		this.architectCode = projectData[5];
		this.contractorCode = projectData[6];
		this.clientCode = projectData[7];
		this.projectFinalized = finalizeProject;
		this.archiveProject = projectArchived;
		this.deleteProject = projectDelete;
	}
	
	// toString method to display the object in a vertical format
	public String toString() {
	return  "\tProject Code\t\t: " + this.projectCode + "\n" 
			+ "\tProject Name\t\t: " + this.projectName + "\n"
			+ "\tBuilding Type\t\t: " + this.buildingType + "\n"
			+ "\tPhysical Address\t: " + this.projectAddress + "\n"
			+ "\tErf Number\t\t: " + this.erfNumber + "\n"
			+ "\tStart Date\t\t: " + this.projectStartDate + "\n"
			+ "\tDue Date\t\t: " + this.projectDueDate + "\n"
			+ "\tArchitect code\t\t: " + this.architectCode + "\n"
			+ "\tContractor code\t\t: " + this.contractorCode + "\n"
			+ "\tCustomer code\t\t: " + this.clientCode + "\n"
			+ "\tFinalized\t\t: " + this.projectFinalized + "\n"
			+ "\tArchived\t\t: " + this.archiveProject + "\n"
			+ "\tProject Deleted\t\t: " + this.deleteProject;

	}	
	// toString method overload to display the object in a horizontal format.
	public String toString(String function) {		
		if(function.equalsIgnoreCase("project")) {
			return "\tProject Code\t: " + this.projectCode + " \t\tProject Name\t: " + this.projectName + "\r\n"
				+ "\tBuilding Type\t: " + this.buildingType + "\tPhysical Address: " + this.projectAddress + "\r\n"
				+ "\tErf Number\t: " + this.erfNumber + "\tStart Date\t: " + this.projectStartDate
				+ "\tDue Date\t: " + this.projectDueDate + "\r\n" + "\tArchitect code\t: " + this.architectCode 
				+ "\t\tContractor code\t: " + this.contractorCode + " \t\tClient code\t: " + this.clientCode + "\r\n"
				+ "\tFinalized\t: " + this.projectFinalized + "\t\tArchived\t: " + this.archiveProject
				+ "\t\tProject Deleted\t: " + this.deleteProject;
		}
		else if(function.equalsIgnoreCase("saveToFile")) {
			return projectCode + ";" + this.projectName + ";" + this.buildingType + ";" + this.projectAddress + ";" + this.erfNumber 
				+ ";" + this.projectStartDate + ";" + this.projectDueDate + ";" + this.architectCode + ";"
					+ this.contractorCode + ";" + this.clientCode + ";" + this.projectFinalized
				+ ";" + this.archiveProject + ";" + this.deleteProject;
			}
	
		return "The input is not recognised, please try again";
	
	}
	

}
