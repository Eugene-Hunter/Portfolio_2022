import java.time.LocalDate;
import java.util.Scanner;

public class Invoice {
	// initializing invoice attributes
	int invoiceNumber;
	LocalDate invoiceDate;
	String customerEntityCode;
	String customerName;
	String customerEmailAddress;
	String customerPhysicalAddress;
	String projectCode;
	String projectName;
	String projectAddress;
	String erfNumber;
	LocalDate projectDeadline;
	float projectFee;
	float amountPaid;
	float amountOutstanding;
	boolean cancelInvoice;

	// method to return the invoice number
	public int getInvoiceNumber(){
		return this.invoiceNumber;
	}
	// method to return the invoice date
	public LocalDate getInvoiceDate(){
		return this.invoiceDate;
	}
	// method to return the customer code
	public String getCustomerEntityCode(){
		return this.customerEntityCode;
	}
	// method to return the customer
	public String getCustomerName(){
		return this.customerName;
	}
	// method to return the customer email 
	public String getCustomerEmailAddress(){
		return this.customerEmailAddress;
	}

	// method to return the invoice number
	public String getCustomerPhysicalAddress(){
		return this.customerPhysicalAddress;
	}

	// method to return the invoice number
	public String getProjectCode(){
		return this.projectCode;
	}
	// method to return the project name
	public String getProjectName(){
		return this.projectName;
	}

	// method to return the project address
	public String getProjectAddress(){
		return this.projectAddress ;
	}

	// method to return the erf Number
	public String getErfNumber(){
		return this.erfNumber;
	}
	

	// method to return the project deadline date
	public LocalDate getProjectDeadline(){
		return this.projectDeadline;
	}
	// method to return the invoice number
	public float getProjectFee(){
		return this.projectFee;
	}

	// method to return the total amount paid to date
	public float getAmountPaid(){
		return this.amountPaid ;
	}
	// method to return the amount outstanding
	public float getAmountOutstanding(){
		return this.amountOutstanding ;
	}
	// method to return the invoice number
	public boolean getCancelInvoice(){
		return this.cancelInvoice;
	}

	// method to set the invoice number
	public void setInvoiceNumber(int invoiceNumber){
		this.invoiceNumber = invoiceNumber;
	}

	// method to set the invoice date
	public void setInvoiceDate(LocalDate invoiceDate){
		this.invoiceDate = invoiceDate;
		
	}

	// method to set the customer code
	public void setCustomerEntityCode(String customerEntityCode){
		this.customerEntityCode = customerEntityCode;
		
	}

	// method to set the customer name
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}

	// method to return the customer email address
	public void setCustomerEmailAddress(String customerEmailAddress){
		this.customerEmailAddress = customerEmailAddress;
	}
	
	// method to set the customer physical address
	public void setCustomerPhysicalAddress(String customerPhysicalAddress){
		this.customerPhysicalAddress = customerPhysicalAddress;
	}

	// method to set the project code
	public void setProjectCode(String projectCode){
		this.projectCode = projectCode; 
	}

	// method to set the project name
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
	// method to return the project address
	public void setProjectAddress(String projectAddress){
		this.projectAddress = projectAddress;
	}

	// method to set the erf number
	public void setErfNumber(String erfNumber){
		this.erfNumber = erfNumber;
		
	}
	// method to set the project deadline
	public void setProjectDeadline(LocalDate projectDeadline){
		this.projectDeadline = projectDeadline;
	}
	// method to set the project fee
	public void setProjectFee(float projectFee){
		this.projectFee = projectFee;
	}
	// method to set the amount paid
	public void setAmountPaid(float amountPaid){
		this.amountPaid = amountPaid;
	}
	// method to set the amount outstanding
	public void setAmountOutstanding(){
		float amountOutstanding = this.projectFee - this.amountPaid;
		this.amountOutstanding = amountOutstanding;
		
	}
	// method to cancel the invoice number
	public void setCancelInvoice(){
		
		this.cancelInvoice = true; // setting the boolean variable to true

	}
	// toString method to print the details of the object
	public String toString() {
		String invoice = ""
				+ "Invoice Number\t\t: " + invoiceNumber + "\n" 
				+ "Invoice Date\t\t: " + invoiceDate + "\n"
				+ "Customer Code\t\t: " + customerEntityCode + "\n"
				+ "Customer Name\t\t: " + customerName + "\n"
				+ "Customer Email\t\t: " + customerEmailAddress + "\n"
				+ "Customer Address\t: " + customerPhysicalAddress + "\n"
				+ "Project Number\t\t: " + projectCode + "\n"
				+ "Project Name\t\t: " + projectName + "\n"
				+ "Project Address\t\t: " + projectAddress + "\n"
				+ "Erf Number\t\t: " + erfNumber + "\n"
				+ "Due Date\t\t: " + projectDeadline + "\n"
				+ "Project Fee\t\t: " + projectFee + "\n"
				+ "Amount paid\t\t: " + amountPaid + "\n"
				+ "Amount due\t\t: " + amountOutstanding + "\n"
				+ "Invoice Cancelled\t: " + cancelInvoice;
		
		return invoice;
	}
	
	public String toString(int vertical) {
		String invoice = "\tInvoice Number\t\t: " + invoiceNumber + "\t" 
				+ "\tInvoice Date\t\t: " + invoiceDate + "\r\n"
				+ "\tCustomer Code\t\t: " + customerEntityCode + "\t"
				+ "\tCustomer Name\t\t: " + customerName + "\r\n"
				+ "\tProject Number\t\t: " + projectCode + "\t"
				+ "\tProject Name\t\t: " + projectName + "\r\n";
		
		return invoice;
	}
	// method to instantiating an object
	public Invoice(int invoiceNumber, 
			LocalDate invoiceDate, 
			String customerEntityCode, 
			String customerName, 
			String customerEmailAddress, 
			String customerPhysicalAddress, 
			String projectCode, 
			String projectName, 
			String projectAddress, 
			String erfNumber, 
			LocalDate projectDeadline,
			float projectFee,
			float amountPaid,
			float amountOutstanding,
			boolean cancelInvoice){
		
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.customerEntityCode = customerEntityCode;
		this.customerName = customerName;
		this.customerEmailAddress = customerEmailAddress;
		this.customerPhysicalAddress = customerPhysicalAddress;
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.projectAddress = projectAddress;
		this.erfNumber = erfNumber;
		this.projectDeadline = projectDeadline;
		this.projectFee = projectFee;
		this.amountPaid = amountPaid;
		this.amountOutstanding = amountOutstanding;
		this.cancelInvoice = cancelInvoice;
	}
}
