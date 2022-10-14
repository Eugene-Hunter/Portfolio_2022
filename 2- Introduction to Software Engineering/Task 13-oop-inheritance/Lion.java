

// main class that is derived from the Animal class
public class Lion extends Animal {
	
	private String lionType; // private variable that makes it visible only to 
							// this class type
	
	// Initializing the lion object
	public Lion(int numTeeth, boolean spots, int weight) {
		super(numTeeth, spots, weight); // Instantiating the super class attributes
		super.setNumTeeth(numTeeth);   // assign a value to the parent attribute 
		super.setSpots(spots); // assign a value to the parent attribute
		super.setWeight(weight); // assign a value to the parent attribute
		this.setLionType(weight); // assign a value to the local attribute
	}
	// method to set the lion type
	public void setLionType(int weight) {
		
		// If statement to determine the lion type
		if (super.getWeight() > 120) {
		this.lionType = "male";
		}
		else if(super.getWeight() >= 80) {
			this.lionType = "female";
			
		}else {
			this.lionType = "cub";
			
		}
	}
	// method to return the lion type
	public String getLionType() {
		// return the attribute lion type attribute
		return this.lionType;
	}
	
	// to String method to format the output string
	public String toString() {
		// variable to store the output 
		String lion = "Lion: The lion is a " + getLionType() + ". ";
		lion += "It's weight is " + super.getWeight() + " kg. ";
		String spotsYesNo;
		// If statement to determine if the animal has spots or not
		if (super.getSpots()== true)
			{spotsYesNo = "spots";}
		else 
			{spotsYesNo = "no spots";}
		
		lion += "It has " + spotsYesNo + " and " + super.getNumTeeth() + " teeth.";		
		
		// return the result
		return lion;
	}
	
	// Main class to instantiate objects of the lion class
	public static void main(String[] args) {
		
		Lion lion1 = new Lion(64, false, 180);
		Lion lion2 = new Lion(60, true, 65);
		Lion lion3 = new Lion(64, false, 110);
		System.out.println(lion1);
		System.out.println(lion2);
		System.out.println(lion3);
	}
}
