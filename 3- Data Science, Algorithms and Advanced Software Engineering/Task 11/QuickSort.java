import java.util.ArrayList;
/** 
 * @author Eugene Hunter
 * The purpose of this program is to modify the quick sort algorithm and use the median as the pivot point. The median is calculated using
 * the first, middle and last elements of the array. It sorts the elements and swap element values around until all the string elements
 * are sorted numerically according to the hash code.
 * */

/* Exercise 2
 * In this task, the quick sort algorithm selects the first element in the list as
the pivot. Revise it by selecting the median among the first, middle, and
last elements in the list
*/


/** 
 * @param args
 *  */
public class QuickSort {

	private static String[] list = {"right", "subdued", "trick", "crayon", "punishment", "silk", "describe", "royal", "prevent", "slope"};
	private static int[] hashedList = new int[list.length];
	private static int median;
	public static void main(String[] args) {

		int hashedString = 0;
		String hashCode = "";

		System.out.print("QuickSort: ");
		for(int y = 0; y < list.length; y++) {
			System.out.print(list[y]);
			if(y != list.length - 1 ) {
			System.out.print(", ");
			}
		}
		
		int middle = 0;
		System.out.println("\r\nHashing the words:");
		for(int x = 0; x < list.length; x++) {
			for(int y = 1; y < list[x].length(); y++) {
				if(y != (list.length - 1)) {
				hashedString += list[x].charAt(y)* 31;
				}
				else {
					hashedString += list[x].charAt(y);
				}
			}
			System.out.println(list[x] + " -> " + hashedString);
			hashedList[x] = hashedString;
			hashCode = "";
			
		}
		median = getMedian();
		quicksort(hashedList, 0, hashedList.length - 1, median);
		for(int y = 0; y < hashedList.length; y++) {
			System.out.print(list[y] + ", ");
		}

	}
	/** Determines the median value by using either the 2 middle values and dividing by 2  where the elements are an even number,
	 * or the middle value where the elements are an odd number */
	public static int getMedian() {
		median = 0;
		int middle = (hashedList.length - 1) / 2;
		System.out.println("First hash value: " + hashedList[0]);
		System.out.println("Last hash value: " + hashedList[(hashedList.length - 1)]);
		System.out.println("Middle hash value: " + hashedList[middle]);
		if(list.length % 2 == 0) {
		median = (hashedList[middle] + hashedList[(middle + 1)]) / 2 ;
		System.out.println("Median = " + median);
		}
		else {
			median = hashedList[middle];
			System.out.println("Median = " + median);
		}
		return median;
	}
	/** 
	 * Sorts the elements
	 * 
	 * @param list, low, high, median
	 *  */
	public static void quicksort(int[] list, int low, int high, int median) {
		if (low < high) {
			int mid = partition(list,low,high, median);
			quicksort(list, low, mid-1, median);
			quicksort(list, mid+1, high, median); 
		}
	}
	/** Iteration through the list of hash values and swapping the elements around as each value is compared against the 
	 * pivot point
	 * 
	 * @param list, low, high, median
	 * */
	public static int partition(int[] list, int low, int high, int median) {
		int pivot = median;
		int lowPos = list[low];
		// Loop through the array. Move items up or down the array so that they
		// are in the proper spot with regards to the pivot point.
		do {
			// can we find a number smaller than the pivot point? keep
			// moving the ''high'' marker down the array until we find
			// this, or until high=low
			while (low < high && list[high] >= pivot) {
				high--;
			}
			if (low < high) {
				// found a smaller number; swap it into position
				swap(list, low, high);
				// now look for a number larger than the pivot point
				while (low < high && lowPos <= pivot) {
					low++;
				}
				if (low < high) {
					// found one! move it into position
					swap(list, high, low);
				}
			}
		} while (low < high);
		// move the pivot back into the array and return its index
		list[low] = pivot;
		return low;
	}
	
	/** Swaps the values of the hashed list as they are compared to the pivot point 
	 * @param list, low, high, median
	 * */
	public static void swap(int[] hashedList, int firstIndex, int secondIndex) {

		int hashedTemp = hashedList[firstIndex];
		String listTemp = list[firstIndex];
		hashedList[firstIndex] = hashedList[secondIndex];
		hashedList[secondIndex] = hashedTemp;
		list[firstIndex] = list[secondIndex];
		list[secondIndex] = listTemp;
	}
}
