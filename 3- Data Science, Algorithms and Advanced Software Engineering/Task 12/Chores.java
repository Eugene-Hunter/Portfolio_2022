import java.util.*;

/**
 * @author Eugene Hunter

 * The purpose of this program is to take a list of names and chores and shuffle them, and then display the 
 * random names with each a random chore assigned to them. The program includes a few 
 */
public class Chores {

	private static List<String> names = new ArrayList<>();
	private static List<String> chores = new ArrayList<>();
	private static Random randomName  = new Random();
	private static Random randomChore = new Random();
	private static Scanner input = new Scanner(System.in);
	
	/** Initializes the arraylists with values and allows the user to enter additional names and chores 
	 * @param args*/
	public static void main(String[] args) {

	/**	This section is for ease of testing the program without having to type in any additional
	 * information. Feel free to use these examples.*/
		/*
	  	names.add("Henry");
		names.add("Jack");
		names.add("Phil");
		names.add("Kent");
		names.add("Barry");
		names.add("Simon");

		chores.add("Wash the car");
		chores.add("Feed the dogs");
		chores.add("Water the plants");
		chores.add("Mow the lawn");
		chores.add("Clean the pool");
		chores.add("Stroke the cat");		
		*/

		String nextName = "";
		String nextChore = "";
		int nameCount = 0; 
		int choreCount = 0; 
		System.out.println("Enter more names, leave blank to continue.");
		do {
			System.out.print("Name " + (nameCount + 1) + ": ");
			nextName = input.nextLine();
			if(!nextName.isEmpty()) {
				names.add(nextName);
				nameCount++;
			}
		}while(!nextName.isEmpty());
		
		if(nameCount > 0) {
		System.out.println("Enter new chores equal to the number of names entered");
		do {
			System.out.print("Chore " + (choreCount + 1) + " of " + nameCount + ": ");
			nextChore = input.nextLine();
			if(!nextChore.isEmpty()) {
				chores.add(nextChore);
				choreCount++;
			}
		}while(!nextChore.isEmpty() && choreCount != nameCount);
		}

		// Shuffle the names list and the chores list and display it on the screen
		Collections.shuffle(names, randomName);
		Collections.shuffle(chores, randomChore);

		System.out.println("Randomizing the list of names and chores: ");
		for(int x = 0; x < names.size(); x++) {
		System.out.println(names.get(x) + " " + chores.get(x));
		}
		}
				
		 
		

	}
	
	