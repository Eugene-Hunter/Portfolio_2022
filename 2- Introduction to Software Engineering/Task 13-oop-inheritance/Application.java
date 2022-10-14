
public class Application {
	// Main class to instantiate objects of the lion class
	public static void main(String[] args) {
		
		// Instantiating the Cheetah class
		Cheetah cheetah1 = new Cheetah(58, true, 75);
		// Display the output
		System.out.println(cheetah1);
		Cheetah.setSpeed(132); // update the speed attribute 
		// Display the output
		System.out.println(cheetah1);
		
	}
}
