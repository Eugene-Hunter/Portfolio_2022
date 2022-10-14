/*
- Makes use of at least one static field which needs to have a static
setter and getter.
- Contains a constructor.
- Contains a toString() method.
- Has an array as one of its fields.
- Create an application class. Within the main method, create a Cheetah
object and print it out the details that describe this object.
- Compile, save and run your file.

*/
public class Cheetah extends Animal{
	private static int speed = 120;
	private int[] numberCubs = {1,2,3};
	
	// Constructor
	public Cheetah(int numTeeth, boolean spots, int weight) {
		super(numTeeth, spots, weight); // Instantiating the super class attributes
		super.setNumTeeth(numTeeth); // assign a value to the attribute
		super.setSpots(spots); // assign a value to the attribute
		super.setWeight(weight); // assign a value to the attribute
	}
	
	// method to set a new speed
	public static void setSpeed(int newSpeed) {
		speed = newSpeed; // assign a value to the local attribute
		
	}
	// method to return the speed
	public static int getSpeed() {
		
		return speed; // return the attribute value
		
	}
	//method to return the array of the number of cubs
	public int[] getNumberCubs() {
		return this.numberCubs; // 
	}
	// to String method to format the output as required
	public String toString() {
		// variable to store the string output
		String cheetah = "Cheetah: The cheetah can run at speeds exceeding " + speed +  " km/h.\n";
		cheetah += "The cheetah's average weight is " + super.getWeight() + " kg, ";
		cheetah += " and the females generally give birth to " + getNumberCubs()[0] + " or " + getNumberCubs()[1]
				+ " cubs per year,\nand at rare occasions, when the hunting season has been successful, "
				+ " she can give birth to up to " + getNumberCubs()[2] + " cubs.\n";
		String spotsYesNo; // variable to determine if the spots attribute is set to true or false and 
						  //and return a corresponding string
		// If statement to determine if the animal has spots or not
		if (super.getSpots()== true)
			{spotsYesNo = "spots";}
		else 
			{spotsYesNo = "no spots";}
		
		cheetah += "It has " + spotsYesNo + " and " + super.getNumTeeth() + " teeth.\n";		
		
		// return the result
		return cheetah;
	}
	

}