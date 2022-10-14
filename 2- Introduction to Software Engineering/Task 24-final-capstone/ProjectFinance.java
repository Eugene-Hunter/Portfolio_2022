import java.time.LocalDate;

public class ProjectFinance{

	// Initializing the object attributes
	private String projectCode;
	private String projectName;
	private String clientCode;
	private double projectFee;
	private double amountPaid;	
	private double amountOutstanding;
	
	// Method to instantiate a new object
	public ProjectFinance(String projectCode, String projectName, String clientCode,double projectFee, double amountPaid) {
		this.projectCode = projectCode;
		this.projectName =  projectName;
		this.clientCode = clientCode;
		this.projectFee = projectFee;
		this.amountPaid = amountPaid;
		this.amountOutstanding = this.projectFee - this.amountPaid;} 

	// method to return the project code
	public String getProjectCode() {
		return this.projectCode;
	}
	// method to return the project name
	public String getProjectName() {
		return this.projectName;
	}
	// method to return the project fee amount
	public double getProjectFee() {
		return this.projectFee;
	}
	// method to return the amount paid
	public String getClientCode() {
		return this.clientCode;
	}
	// method to return the amount paid
	public double getAmountPaid() {
		return this.amountPaid;
	}
	// method to return the project deadline date
	public double getAmountOutstanding() {
		return this.amountOutstanding;
	}
	// method to set the project code
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;		
	}
	// method to set the project project name
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	// method to set the project fee
	public void setProjectFee(double projectFee) {
		this.projectFee = projectFee;
	}
	// method to set 
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	// method to set the amount paid
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = this.amountPaid + amountPaid;
		setAmountOutstanding();
	}

	// method to set the amount outstanding
	public void setAmountOutstanding() {
		this.amountOutstanding = this.projectFee - this.amountPaid;
	}

	public String toString() {
		return "\tProject Code\t: " + this.projectCode + "\t"
				+ "Client Code\t: " + this.clientCode + "\t"
				+ "Project Name\t: " + this.projectName + "\r\n"
				+ "\t\tProject Fee\t: " + this.projectFee + "\t"
				+ "Amount paid\t: " + this.amountPaid + "\t"
				+ "Amount due\t: " + this.amountOutstanding;
	}	
	public String toString(String function) {
		
			if (function.equalsIgnoreCase("saveToFile")){
				return this.projectCode + ";" + this.clientCode + ";" + this.projectName + ";"
						+ this.projectFee + ";" + this.amountPaid;						
			}
				return "The input is not recognised, please try again";	
	}
}

