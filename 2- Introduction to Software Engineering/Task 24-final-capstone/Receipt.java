import java.time.LocalDate;

public class Receipt {
	
	private int receiptNumber;
	private LocalDate receiptDate;
	private String clientCode;
	private String projectCode;
	private double amountPaid;
	
	public Receipt(int recNumber, LocalDate recDate, double recAmount, String[] receiptDetails) {
		this.receiptNumber = recNumber;
		this.receiptDate = recDate;
		this.clientCode = receiptDetails[0];
		this.projectCode = receiptDetails[1];
		this.amountPaid = recAmount;
	}
	public double getAmountPaid() {
		return this.amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getProjectCode() {
		return this.projectCode;
	}
	public void setProjectCode(String projectNumber) {
		this.projectCode = projectNumber;
	}
	public String getClientCode() {
		return this.clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public int getReceiptNumber() {
		return this.receiptNumber;
	}
	public void setReceiptNumber(int receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public LocalDate getReceiptDate() {
		return this.receiptDate;
	}
	public void setReceiptDate(LocalDate receiptDate) {
		this.receiptDate = receiptDate;
	}
	public String toString() {
		return "\t\tReceipt Nr#\t: " + this.receiptNumber + "\r\n"
				+ "\t\tDate\t\t: " + this.receiptDate + "\r\n"
				+ "\t\tClient Code\t: " + this.clientCode + "\r\n"
				+ "\t\tProject Code\t: " + this.projectCode + "\r\n"
				+ "\t\tAmount received\t: " + this.amountPaid; 
	}
	public String toString(String function) {
		
		if(function.equalsIgnoreCase("saveToFile")) {
		return this.receiptNumber + ";" + this.receiptDate + ";" + this.clientCode + ";" + this.projectCode + ";" + this.amountPaid; 
		
		}
		else {
			return "Input not recognized, try again";
		}
	}
}
