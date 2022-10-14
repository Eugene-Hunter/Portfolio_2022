import java.time.LocalDate;


public class ProjectInfo {
// Create a class that will be used to create a project object.
	
	String projectCode;
	String projectName;
	String buildingType;
	String projectAddress;
	String erfNumber;
	LocalDate projectStartDate;
	LocalDate projectDeadline;
	String architectEntityCode;
	String contractorEntityCode;
	String customerEntityCode;
	String dueDateChangeComment;
	boolean projectFinalized;
	boolean deleteProject;
	
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
	public boolean getDeleteProject() {
		return this.deleteProject;
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
	public void setProjectDeadline(LocalDate newProjectDeadline){
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
	public void setClientEntityCode(String customerEntityCode){
		//attribute to store the user input 
		this.customerEntityCode = customerEntityCode ;
	}
	public void setProjectFinalized(boolean setFinalized) {
		this.projectFinalized = setFinalized;
	}
	
	public void setDeleteProject(boolean deleteProject){
		this.deleteProject = deleteProject;

	}
	
	public void newProject() {
		
		
		
	}
	// method to instantiate a ProjectInfo object
	public ProjectInfo(String projectCode, 
			String projectName, 
			String buildingType, 
			String projectAddress, 
			String erfNumber, 
			LocalDate projectStartDate, 
			LocalDate projectDeadline, 
			String architectEntityCode, 
			String contractorEntityCode, 
			String customerEntityCode,
			boolean projectFinalized,
			boolean deleteProject){
		
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.projectAddress = projectAddress;
		this.erfNumber = erfNumber;
		this.projectStartDate = projectStartDate;
		this.projectDeadline = projectDeadline;
		this.architectEntityCode = architectEntityCode;
		this.contractorEntityCode = contractorEntityCode;
		this.customerEntityCode = customerEntityCode;
		this.projectFinalized = false;
		this.deleteProject = false;
	}
	
	// toString method to display the object in a vertical format
	public String toString() {
	String project = "\tProject Code\t\t: " + projectCode + "\n" 
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
			+ "\tProject Deleted\t\t: " + deleteProject;
	return project;
	}	
	// toString method overload to display the object in a horizontal format.
	public String toString(int horizontal) {
			
			
		String projectTable = "\tProject Code\t: " + projectCode + "\t\tProject Name\t: " + projectName + "\n"
				+ "\tBuilding Type\t: " + buildingType + "\tPhysical Address: " + projectAddress + "\n"
				+ "\tErf Number\t: " + erfNumber + "\tStart Date\t: " + projectStartDate + "\tDue Date\t: " + projectDeadline + "\n"
				+ "\tArchitect code\t: " + architectEntityCode + " \tContractor code\t: " + contractorEntityCode + " \tCustomer code\t: " + customerEntityCode + "\n"
				+ "\tFinalized\t: " + projectFinalized + " \tProject Deleted\t: " + deleteProject  + "\n";
		
		return projectTable;
	}
	

}
