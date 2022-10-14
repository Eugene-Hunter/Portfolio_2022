import java.time.LocalDate;

public class EntityDetails {

	// initializing the object attributes
	private String entityCode;
	private String complexName;
	private String complexNumber;
	private String street;
	private String city;
	private String postalCode;
	private String email;
	private String contactNumber;
	private LocalDate employStartDate;
	private LocalDate employEndDate;
	private boolean archiveEntity;
	
	// method to return the customer/contractor/architect code
	public String getEntityCode(){
		return this.entityCode;
	}
	// method to return the complex name
	public String getComplexName(){
		return this.complexName;
	}
	// method to return the complex name
	public String getComplexNumber(){
		return this.complexNumber;
	}
	// method to return the street name
	public String getStreet(){
		return this.street;
	}
	// method to return the city
	public String getCity(){
		return this.city;
	}
	// method to return the postal code
	public String getPostalCode(){
		return this.postalCode;
	}
	// method to return the email address
	public String getEmail(){
		return this.email;
	}
	// method to return the contact number
	public String getContactNumber(){
		return this.contactNumber;
	}
	// method to return the employee start date
	public LocalDate getemployStartDate(){
		return this.employStartDate;
	}
	// method to return the termination date
	public LocalDate getEmployEndDate(){
		return this.employEndDate;
	}
	// method to return the archive status of the entity
	public boolean getArchiveEntity() {
		return this.archiveEntity;		
	}
	// method to set the customer/contractor/architect code
	public void setEntityCode(String entityCode){
		this.entityCode = entityCode;
	}
	// method to set the complex name
	public void setComplexName(String complexName){
		this.complexName = complexName;		
	}
	// method to set the complex number
	public void setComplexNumber(String complexNumber){
		this.complexNumber = complexNumber;
	}
	// method to set the street address
	public void setStreet(String street){
		this.street = street;
	}
	// method to set the city
	public void setCity(String city){
		this.city = city;
	}
	// method to set the postal code
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	// method to set the email address
	public void setEmail(String email){
		this.email = email;
	}
	// method to set the contact number
	public void setContactNumber(String contactNumber){
		this.contactNumber = contactNumber;
	}
	// method to set the employee start date
	public void setEmployStartDate(LocalDate employStartDate){
		this.employStartDate = employStartDate;
	}
	// method to set the employee termination date
	public void setEmployEndDate(LocalDate employEndDate){
		this.employEndDate = employEndDate;
	}
	// method to set a new archive status
	public void setArchiveEntity(boolean archiveEntity ) {
		this.archiveEntity = archiveEntity;	
	}
	/*Constructor method to instantiate a new object*/
	public EntityDetails(LocalDate employStartDate, LocalDate employEndDate, boolean archiveEntity, String[] entity){
		this.entityCode = entity[0];
		this.complexNumber = entity[1];
		this.complexName = entity[2];
		this.street = entity[3];
		this.city = entity[4];
		this.postalCode = entity[5];
		this.email = entity[6];
		this.contactNumber = entity[7];
		this.employStartDate = employStartDate;
		this.employEndDate = employEndDate;
		this.archiveEntity = archiveEntity;
		
		}
	
	public String toString(String function){
		
		if(function.equalsIgnoreCase("addInvoice")) {
			return this.complexNumber + ", " + this.complexName + ", " + this.street + ", " + this.city + ", " + this.postalCode;
		}
		else if (function.equalsIgnoreCase("saveToFile")){
			return this.entityCode + ";" + this.complexNumber + ";" + this.complexName + ";" + this.street + ";" + this.city
					+ ";" + this.postalCode + ";" + this.email + ";" + this.contactNumber + ";" + this.employStartDate
					+ ";" + this.employEndDate + ";" + this.archiveEntity;
		}
		return "\t\tInput not recognised, please try again";
	}
			
	//toString overload to format the information in a specific manner - horizontal format
	public String toString() {
		
		return "\tComplex Number\t: " + this.complexNumber + "\t\t"
				+ "\tComplex Name\t: " + this.complexName + "\t\t"
				+ "\tStreet\t\t: " + this.street + "\r\n"
				+ "\tCity\t\t: " + this.city + "\t"
				+ "\tPostal Code\t: " + this.postalCode + "\r\n"
				+ "\tEmail\t\t: " + this.email + "\t"
				+ "Number\t\t: " + this.contactNumber + "\r\n"
				+ "\tEmployed Since\t: " + this.employStartDate + "\t"
				+ "\tTermination Date: " + this.employEndDate + "\t"
				+ "\tArchived\t: " + this.archiveEntity + "\r\n";
		

	}
}
