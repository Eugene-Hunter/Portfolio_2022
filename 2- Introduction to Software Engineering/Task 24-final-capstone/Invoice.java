import java.time.LocalDate;

public class Invoice {
	// initializing invoice attributes
	private LocalDate invoiceDate;
	private int invoiceNumber;
	private double amountOutstanding;
	private double amountPaid;
	private boolean cancelInvoice;
	private String clientCode;
	private String clientName;
	private String clientEmailAddress;
	private String clientContactNumber;
	private String clientAddress;
	private String projectCode;
	private String projectName;
	private String projectErfNumber;
	private String projectAddress;
	private LocalDate projectDeadline;
	private double projectFee;

	// method to instantiating an object
	public Invoice(int invoiceNumber, LocalDate invoiceDate, LocalDate projectDeadline, boolean cancelInvoice,
			double[] projectFinance, String[] invoiceData){

		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.clientCode = invoiceData[0];
		this.clientName = invoiceData[1];
		this.clientContactNumber = invoiceData[2];
		this.clientEmailAddress = invoiceData[3];
		this.clientAddress = invoiceData[4];
		this.projectCode = invoiceData[5];
		this.projectName = invoiceData[6];
		this.projectAddress = invoiceData[7];
		this.projectErfNumber = invoiceData[8];
		this.projectDeadline = projectDeadline;
		this.projectFee = projectFinance[0];
		this.amountPaid = projectFinance[1];
		this.amountOutstanding = projectFinance[0] - projectFinance[1];
		this.cancelInvoice = cancelInvoice;
	}
	// method to return the amount outstanding
	public double getAmountOutstanding(){
		return this.amountOutstanding ;
	}
	// method to return the total amount paid to date
	public double getAmountPaid(){
		return this.amountPaid ;
	}
	// method to return the invoice number
	public boolean getCancelInvoice(){
		return this.cancelInvoice;
	}
	// method to return the customer email
	public String getCustomerEmailAddress(){
		return this.clientEmailAddress;
	}
	// method to return the customer code
	public String getCustomerEntityCode(){
		return this.clientCode;
	}
	// method to return the customer
	public String getCustomerName(){
		return this.clientName;
	}
	// method to return the invoice number
	public String getCustomerPhysicalAddress(){
		return this.clientAddress;
	}
	// method to return the erf Number
	public String getErfNumber(){
		return this.projectErfNumber;
	}
	// method to return the invoice date
	public LocalDate getInvoiceDate(){
		return this.invoiceDate;
	}
	// method to return the invoice number
	public int getInvoiceNumber(){
		return this.invoiceNumber;
	}
	// method to return the project address
	public String getProjectAddress(){
		return this.projectAddress ;
	}
	// method to return the invoice number
	public String getProjectCode(){
		return this.projectCode;
	}
	// method to return the project deadline date
	public LocalDate getProjectDeadline(){
		return this.projectDeadline;
	}
	// method to return the invoice number
	public double getProjectFee(){
		return this.projectFee;
	}
	// method to return the project name
	public String getProjectName(){
		return this.projectName;
	}
	public String getClientContactNumber() {
		return clientContactNumber;
	}
	public void setClientContactNumber(String clientContactNumber) {
		this.clientContactNumber = clientContactNumber;
	}
	// method to set the amount outstanding
	public void setAmountOutstanding(){
		this.amountOutstanding = this.projectFee - this.amountPaid;
	}
	// method to set the amount paid
	public void setAmountPaid(double amountPaid){
		this.amountPaid = amountPaid;
	}
	// method to cancel the invoice number
	public void setCancelInvoice(){
		this.cancelInvoice = true;
	}
	// method to return the customer email address
	public void setCustomerEmailAddress(String customerEmailAddress){
		this.clientEmailAddress = customerEmailAddress;
	}
	// method to set the customer code
	public void setCustomerEntityCode(String customerEntityCode){
		this.clientCode = customerEntityCode;
	}
	// method to set the customer name
	public void setCustomerName(String customerName){
		this.clientName = customerName;
	}
	// method to set the customer physical address
	public void setCustomerPhysicalAddress(String customerPhysicalAddress){
		this.clientAddress = customerPhysicalAddress;
	}
	// method to set the erf number
	public void setErfNumber(String erfNumber){
		this.projectErfNumber = erfNumber;
	}
	// method to set the invoice date
	public void setInvoiceDate(LocalDate invoiceDate){
		this.invoiceDate = invoiceDate;
	}
	// method to set the invoice number
	public void setInvoiceNumber(int invoiceNumber){
		this.invoiceNumber = invoiceNumber;
	}
	// method to return the project address
	public void setProjectAddress(String projectAddress){
		this.projectAddress = projectAddress;
	}
	// method to set the project code
	public void setProjectCode(String projectCode){
		this.projectCode = projectCode;
	}
	// method to set the project deadline
	public void setProjectDeadline(LocalDate projectDeadline){
		this.projectDeadline = projectDeadline;
	}
	// method to set the project fee
	public void setProjectFee(double projectFee){
		this.projectFee = projectFee;
	}
	// method to set the project name
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
	// toString method to print the details of the object
	public String toString() {
		return "\t\tInvoice Number\t\t: " + this.invoiceNumber + "\tInvoice Date\t: " + this.invoiceDate + "\r\n"
				+ "\t\tClient Code\t\t: " + this.clientCode	+ "\t\tClient Name\t\t: " + this.clientName + "\r\n"
				+ "\t\tClient Contact Nr\t\t: " + this.clientContactNumber + "\r\n"				
				+ "\t\tClient Email\t\t: " + this.clientEmailAddress + "\r\n"
				+ "\t\tCustomer Address\t: " + this.clientAddress + "\r\n"
				+ "\t\tProject Number\t\t: " + this.projectCode + "\t\t"
				+ "\t\tProject Name\t\t: " + this.projectName + "\t\t"
				+ "\t\tProject Address\t\t: " + this.projectAddress + "\r\n"
				+ "\t\tErf Number\t\t: " + this.projectErfNumber + "\r\n"
				+ "\t\tDue Date\t\t: " + this.projectDeadline + "\r\n"
				+ "\t\tProject Fee\t\t: " + this.projectFee + "\r\n"
				+ "\t\tAmount paid\t\t: " + this.amountPaid + "\r\n"
				+ "\t\tAmount due\t\t: " + this.amountOutstanding + "\r\n"
				+ "\t\tInvoice Cancelled\t: " + this.cancelInvoice;

	
	}
	public String toString(String function) {
		
		if(function.equalsIgnoreCase("saveToFile")) {
		return invoiceNumber + ";" + this.invoiceDate + ";" + this.clientCode + ";" + this.clientName + ";" + this.clientContactNumber
				+ ";" + this.clientEmailAddress + ";" + this.clientAddress + ";" + this.projectCode + ";" + this.projectName
				+ ";" + this.projectAddress + ";" + this.projectErfNumber + ";" + this.projectDeadline + ";" + this.projectFee
				+ ";" + this.amountPaid + ";" + this.amountOutstanding + ";" + this.cancelInvoice;
		}

			return "The input is not recognised, please try again.";
		
	
	}
}
