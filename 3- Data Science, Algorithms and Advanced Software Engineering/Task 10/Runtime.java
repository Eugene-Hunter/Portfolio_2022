import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Eugene Hunter
 * 
 *         The purpose of the program is to allow the user to enter a string of
 *         characters and the program should then create additional string
 *         combinations and saving it to a list which is displayed as soon as
 *         all the possible combinations have been added to the list.
 * 
 *         Please note that the stack size have to be increased on searches
 *         containing more than 7 characters as the method used becomes resource
 *         intensive on searches that exceed 5040 results.
 */
public class Runtime {
	private static Scanner input = new Scanner(System.in);
	private static int maxResults = 5040;
	private static String string;
	private static List<String> list1 = new ArrayList<>();

	/** Initialize the program */
	public static void main(String[] args) {
		System.out.println(
				"Results are limited to 5040, which would be approximately 7 characters. Change the value at you own risk.");

		do {
			changeStackSize();
			System.out.print("\r\nEnter a word: ");
			string = input.nextLine();
			System.out.println("...Busy setting up the list....................");
			initialize();
		} while (!string.isEmpty());
	}

	/**
	 * This method was included to allow the user to increase the size of the return
	 * list. The user should first change the stack size of their JVM to the
	 * appropriate size before changing the size of this list.
	 */
	public static void changeStackSize() {
		String tryAgain = "0";
		do {
			try {
				System.out.print("Enter a greater size or press enter to continue: ");
				String increaseResults = "";
				increaseResults = input.nextLine();
				if (!increaseResults.isEmpty()) {

					maxResults = Integer.parseInt(increaseResults);
					tryAgain = "";
				} else if (increaseResults.isEmpty()) {
					break;
				}
			} catch (NumberFormatException e) {

				System.out.println("The input entered is not recognized, please try again. ");

			}
		} while (!tryAgain.isEmpty());
	}

	/** Initializes the program */
	public static void initialize() {
		int count = 0;
		if (list1.isEmpty()) {
			addString(string);
		}

		do {
			newString(string);
			count++;
		} while (count < list1.size());

		for (int x = 0; x < list1.size(); x++) {
			System.out.println(list1.get(x));
		}
		System.out.println("Total number of possible combinations: " + list1.size());
		list1.clear();

	}

	/*
	 * Swapping characters around in order to create new string combinations from
	 * which more string combinations are created
	 */
	public static String swap(String string, int count, int insertSpot) {

		List<String> str = new ArrayList<>(string.length());
		String char1 = "";
		String swapStr = "";
		int strSize = string.length();
		for (int x = 0; x < string.length(); x++) {
			str.add(String.valueOf(string.charAt(x)));
		}
		char1 = str.get(strSize - (strSize - count));
		str.remove(strSize - (strSize - count));
		str.add(insertSpot, char1);
		swapStr = str.toString();
		swapStr = swapStr.replace("[", "").replace(",", "").replace("]", "").replace(" ", "");

		return swapStr;
	}

	/* creating and sending the new string to the addString method */
	public static void newString(String lastStr) {

		int count = 0;
		do {
			String newStr = swap(lastStr, count, (lastStr.length() - 1));
			if (!newStr.isBlank() && !newStr.isEmpty()) {
				addString(newStr);
			}

			count++;
		} while (count < lastStr.length());

	}

	/*
	 * Checks if the string combination already exist in the list and adds it if the
	 * string combination is not present, sorting the list on-the-fly.
	 */
	public static void addString(String addString) {
		int count = 0;
		for (int x = 0; x < list1.size(); x++) {
			if (!addString.equals(list1.get(x))) {
				count = 0;
			} else {
				count = 1;
				break;
			}
		}
		if (count == 0 && list1.size() < maxResults) {
			list1.add(addString);
			list1.sort(null);
			newString(addString);

		}
	}
}
