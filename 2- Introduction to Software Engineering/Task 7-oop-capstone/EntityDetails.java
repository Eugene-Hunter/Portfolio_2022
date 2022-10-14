import java.time.LocalDate;
public class EntityDetails {

	// initializing the object attributes
	String entityCode;
	String complexName;
	int complexNumber;
	String street;
	String city;
	int postalCode;
	String email;
	String contactNumber;
	LocalDate employStartDate;
	LocalDate employEndDate;
	boolean archiveEntity;
	

	// method to return the customer/contractor/architect code
	public String getEntityCode(){
		return this.entityCode;
	}
	// method to return the complex name
	public String getComplexName(){
		return this.complexName;
	}
	// method to return the complex name
	public int getComplexNumber(){
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
	public int getPostalCode(){
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
	public void setComplexNumber(int complexNumber){
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
	public void setPostalCode(int postalCode){
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
	
	
	public void updateEntity() { //Main Menu Option 3 Sub menu 2
		
	}

	// method to initialize a new object
	public EntityDetails(String entityCode, 
							int complexNumber,
							String complexName,
							String street,
							String city,
							int postalCode,
							String email,
							String contactNumber,
							LocalDate employStartDate){
		this.entityCode = entityCode;
		this.complexNumber = complexNumber;
		this.complexName = complexName;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.email = email;
		this.contactNumber = contactNumber;
		this.employStartDate = employStartDate;
		this.employEndDate = null;
		this.archiveEntity = false;
		
		}
	

	//toString overload to format the information in a specific manner - horizontal format
	public String toString(int table) {
		
		String entityDetails = "\tComplex Number\t: " + complexNumber + "\t\t"
				+ "\tComplex Name\t: " + complexName + "\t\t"
				+ "\tStreet\t\t: " + street + "\r\n"
				+ "\tCity\t\t: " + city + "\t"
				+ "\tPostal Code\t: " + postalCode + "\r\n"
				+ "\tEmail\t\t: " + email + "\t"
				+ "Number\t\t: " + contactNumber + "\r\n"
				+ "\tEmployed Since\t: " + employStartDate + "\t"
				+ "\tTermination Date: " + employEndDate + "\t"
				+ "\tArchived\t: " + archiveEntity + "\r\n";
		
		return entityDetails;
	}
}
