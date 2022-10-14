import java.time.LocalDate;

public class ProjectFinance {

	// Initializing the object attributes
	String projectCode;
	String projectName;
	LocalDate paymentDate;
	float projectFee;
	float amountPaid;
	
	float amountOutstanding;
	
	// TODO - if invoice cancelled, reverse amount from total paid and set new amount outstanding
	// OR
	// keep list of invoices for customer and do calculations on only the invoices that has not been cancelled
	
	// Method to instantiate a new object
	public ProjectFinance(String projectCode, String projectName, LocalDate paymentDate, float projectFee, float amountPaid) {
		this.projectCode = projectCode;
		this.projectName =  projectName;
		this.paymentDate = paymentDate;
		this.projectFee = projectFee;
		this.amountPaid = amountPaid;
		this.amountOutstanding = this.projectFee - this.amountPaid;
		
	} 

	// method to return the project code
	public String getProjectCode() {
		return this.projectCode;
	}

	// method to return the project name
	public String getProjectName() {
		return this.projectName;
		}
	public LocalDate getPaymentDate() {
		return this.paymentDate;
	}
	// method to return the project fee amount
	public float getProjectFee() {
		return this.projectFee;
		}

	// method to return the amount paid
	public float getAmountPaid() {
		return this.amountPaid;
		}
	// method to return the project deadline date
	public float getAmountOutstanding() {
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
	public void setProjectFee(float projectFee) {
		this.projectFee = projectFee;
	}
	// method to set 
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	// method to set the amount paid
	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	// method to set the amount outstanding
	public void setAmountOutstanding() {
		this.amountOutstanding = this.projectFee - this.amountPaid;
	}

}
