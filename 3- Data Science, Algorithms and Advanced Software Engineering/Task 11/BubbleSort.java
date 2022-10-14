import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * The purpose of this program is to make use of the bubble sort algorithm to sort a list of words according to 
 * hash code values in an Arraylist.
 * Exercise Instructions
 * Implement the Bubble sort algorithm on the following ArrayList:
 * ["right", "subdued", "trick", "crayon", "punishment", "silk", "describe",
 * "royal", "prevent", "slope"]
 * @author Eugene Hunter
 * 
 * 
 */
public class BubbleSort {

	private static ArrayList<String> list = new ArrayList<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {	

		list.add("right");
		list.add("subdued");
		list.add("trick");
		list.add("crayon");
		list.add("punishment");
		list.add("silk");
		list.add("describe");
		list.add("royal");
		list.add("prevent");
		list.add("slope");
		System.out.println(list.toString());
		ArrayList<Integer> hashes = new ArrayList<>();
		int hashTotal = 0;
		for(int x = 0; x < list.size(); x++) {
			int hashedString = 0;
			for(int y = 0; y < list.get(x).length(); y++) {
				hashedString += list.get(x).charAt(y) * 31^(list.get(x).length());

			}
			System.out.println("hashCode = " + list.get(x) + " = " + hashedString);
			hashes.add(hashedString);
		}


		bubbleSort(hashes);

		for(int y = 0; y < list.size(); y++) {

		}


	}
/** Sorts the hash codes */
	public static List<Integer> bubbleSort(List<Integer> arr) {
		try {
			for(int i = (arr.size()); i >= 0 ; i--) {

				for(int j = 1; j < i ; j++) {
					if(arr.get(j - 1) > arr.get(j)) {			
						//					System.out.println(arr.get(j - 1) + " <" + (j - 1) + " > " + j + "> " + arr.get(j));
						//					System.out.println(list.get(j - 1) + " <" + (j - 1) + " > " + j + "> " + list.get(j));
						int temp = arr.get(j);
						String temp2 = list.get(j);
						arr.remove(j);
						list.remove(j);
						arr.add(j - 1, temp);
						list.add(j - 1, temp2);
						//					System.out.println(arr.get(j - 1) + " <" + (j - 1) + " <> " + j + "> " + arr.get(j));
						//					System.out.println(list.get(j - 1) + " <" + (j - 1) + " <> " + j + "> " + list.get(j));

					}
					else {
						//					System.out.println(arr.get(j - 1) + " <" + (j - 1) + " < " + j + "> " + arr.get(j));
						//					System.out.println(list.get(j - 1) + " <" + (j - 1) + " < " + j + "> " + list.get(j));

					}

				}
			}	
			System.out.println(list.toString());
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}



		return arr;
	}

}
