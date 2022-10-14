

// Main class
public class NoDups {

	// Main method
	public static void main(String[] args){
		
		// Initialize an int array with variables

		int[] numList = {20,100,10,80,70,1,0,-1,2,10,15,300,7,6,2,18,19,21,9,0};
		
		int listSize = numList.length;

		System.out.print ("List of numbers before removal of duplicates: ");
		
		// display the array before sorting and removing duplicates
		for (int i = 0; i < listSize; i++) {
		System.out.print(numList[i] + " ");
		}

		System.out.println();
		System.out.println();
		listSize = removeDuplicates(numList, listSize);

		System.out.print ("List of numbers after removal of duplicates: ");		
		//For loop to print the list out 
		for (int x = 0; x < listSize ; x ++) {
			System.out.print(numList[x] + " ");
		}
	}
	
	//method to remove duplicate values 
	static int removeDuplicates(int[] list, int listLength) {
		
		
		// scan first n-1 positions in the array where n=intArray.length
		// call maxFirst() to place largest element from the unsorted
		// tail of the list into position i
		// for loop to add each variable individually to the sort method
		for (int i = 0; i < list.length-1; i++) {
			sort(list, i);
		}

		int[] temp = new int[listLength]; // array variable to store the list of numbers
		int newLength = 0;
		//For loop to create a new temporary list of all the numbers of which all 
		// duplicates have been removed
		for(int k = 0; k < listLength-1; k++) {
			if (list[k] != list[k + 1]) {
				temp[newLength++] = list[k];
				
			}
		}
		temp[newLength++] = list[listLength - 1];
		
		// For loop to assign the shortened list back to the list variable
		for (int z = 0; z < newLength; z++) {
			list[z] = temp[z];
		}
		return newLength;
	}
	public static void sort(int[] numArr, int startIndex) {
		// Initializing the starting point which is the
		// current element at the startIndex
		int minIndex = startIndex;
		int minValue = numArr[startIndex];
		int firstMin = minValue; // Assign the first variable to the minValue variable as a
		//starting point for the loop 
		//For loop to iterate through the list of values in order to sort the array of numbers 
		// for smallest to largest
		for (int currentIndex = startIndex + 1; currentIndex < numArr.length;
				currentIndex++) {
				if (numArr[currentIndex] < minValue) {
				minValue = numArr[currentIndex];
				minIndex = currentIndex;
				}
				}
				// Swapping the value at the index start with new the minimum value
				numArr[startIndex] = numArr[minIndex];
				numArr[minIndex] = firstMin;
				}

}
