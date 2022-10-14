import java.time.LocalDate;

public class ProjectInfo {
// Create a class that will be used to create a project object.
	
	private String projectCode;
	private String projectName;
	private String buildingType;
	private String projectAddress;
	private String erfNumber;
	private LocalDate projectStartDate;
	private LocalDate projectDeadline;
	private String architectEntityCode;
	private String contractorEntityCode;
	private String customerEntityCode;
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
	public LocalDate getProjectDeadline(){
		return this.projectDeadline;	
	}
	public String getArchtectEntityCode(){
		return this.architectEntityCode;	
	}
	public String getContractorEntityCode(){
		return this.contractorEntityCode;	
	}
	public String getCustomerEntityCode(){
		return this.customerEntityCode;
	}
	public boolean getProjectFinalized() {
		return this.projectFinalized;
	}
	public boolean getArchiveProject() {
		return this.archiveProject;
	}
	public void setProjectCode(String projectCode){
		//attribute to store the user input 
		this.projectCode = projectCode ;
	}
	public void setProjectName(String projectName){
		//attribute to store the user input 
		this.projectName = projectName ;
	}
	public void setBuildingType(String buildingType){
		//attribute to store the user input 
		this.buildingType = buildingType ;
	}
	public void setProjectAddress(String projectAddress){
		//attribute to store the user input 
		this.projectAddress = projectAddress ;
	}
	public void setErfNumber(String erfNumber){
		// attribute to store the user input 
		this.erfNumber = erfNumber ;
	}
	public void setProjectStartDate(LocalDate startDate){
		// 
		this.projectStartDate = startDate;
		
	}
	public void setNewProjectDeadline(LocalDate newProjectDeadline){
		//
		this.projectDeadline =  newProjectDeadline;
			}		
	
	public void setArchitectEntityCode(String architectEntityCode){
		//attribute to store the user input 
		
		this.architectEntityCode = architectEntityCode;
	}
	public void setContractorEntityCode(String contractorEntityCode){
		//attribute to store the user input 
		this.contractorEntityCode = contractorEntityCode ;

	}
	public void setCustomerEntityCode(String customerEntityCode){
		//attribute to store the user input 
		this.customerEntityCode = customerEntityCode ;
	}
	public void setProjectFinalized(boolean setFinalized) {
		this.projectFinalized = setFinalized;
	}
	public void setArchiveProject(boolean archiveProject){
		this.archiveProject = archiveProject;
	}
	public void setDeleteProject(boolean deleteProject){
		this.deleteProject = deleteProject;
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
		this.projectDeadline = projectDue;
		this.architectEntityCode = projectData[5];
		this.contractorEntityCode = projectData[6];
		this.customerEntityCode = projectData[7];
		this.projectFinalized = finalizeProject;
		this.archiveProject = projectArchived;
		this.deleteProject = projectDelete;
	}
	
	// toString method to display the object in a vertical format
	public String toString() {
	return  "\tProject Code\t\t: " + projectCode + "\n" 
			+ "\tProject Name\t\t: " + projectName + "\n"
			+ "\tBuilding Type\t\t: " + buildingType + "\n"
			+ "\tPhysical Address\t: " + projectAddress + "\n"
			+ "\tErf Number\t\t: " + erfNumber + "\n"
			+ "\tStart Date\t\t: " + projectStartDate + "\n"
			+ "\tDue Date\t\t: " + projectDeadline + "\n"
			+ "\tArchitect code\t\t: " + architectEntityCode + "\n"
			+ "\tContractor code\t\t: " + contractorEntityCode + "\n"
			+ "\tCustomer code\t\t: " + customerEntityCode + "\n"
			+ "\tFinalized\t\t: " + projectFinalized + "\n"
			+ "\tArchived\t\t: " + archiveProject + "\n"
			+ "\tProject Deleted\t\t: " + deleteProject;

	}	
	// toString method overload to display the object in a horizontal format.

	public String toString(int horizontal) {		
			
		return "\tProject Code\t: " + projectCode + " \t\tProject Name\t: " + projectName + "\n"
				+ "\tBuilding Type\t: " + buildingType + "\tPhysical Address: " + projectAddress + "\n"
				+ "\tErf Number\t: " + erfNumber + "\tStart Date\t: " + projectStartDate + "\tDue Date\t: " + projectDeadline + "\n"
				+ "\tArchitect code\t: " + architectEntityCode + " \tContractor code\t: " + contractorEntityCode + " \tCustomer code\t: " + customerEntityCode + "\n"
				+ "\tFinalized\t: " + projectFinalized + "\t\tArchived\t: " + archiveProject + " \tProject Deleted\t: " + deleteProject  + "\n";
		
	}
	

}
