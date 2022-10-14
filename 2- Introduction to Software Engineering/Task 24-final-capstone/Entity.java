
public class Entity {
	// Create a class that will be used to create person (e.g. architect,
	// building contractor, etc.) objects]
	
	String entityCode;
	String entityName;
	String entityType;

	// method to return the entity code
	public String getEntityCode(){
		return this.entityCode;
	}
	// method to return the entity type
	public String getEntityType(){
		return this.entityType;
	}
	// method to return the name
	public String getEntityName(){
		return this.entityName;
	}
	// method to set the entity code
	public void setEntityCode(String entityCode){
		this.entityType = entityCode;
	}
	// method to set the person type
	public void setEntityType(String entityType){	
		this.entityType = entityType;
	}
	// method to set the name of the person
	public void setEntityName(String entityName){		
		this.entityName = entityName;
	}
	// override toString method
	public String toString() {
		return "\t\tEntity Code\t: " + this.entityCode + "\tName\t: " + this.entityName + "\t\tType\t: " + this.entityType;
		
	}
	//toString method overload
	public String toString(String function) {
		
		if(function.equalsIgnoreCase("saveToFile")) {
		return this.entityCode + ";" + this.entityName + ";" + this.entityType;
		}
		return "Input not recognised, please try again.";

		
	}
	// method to initialize a new entity object	
	public Entity(String entityCode, String entityName, String entityType){
		this.entityCode = entityCode;
		this.entityName = entityName;
		this.entityType = entityType;
	}
}
