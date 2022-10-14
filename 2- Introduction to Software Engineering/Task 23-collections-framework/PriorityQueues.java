import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/*

The purpose of this program is to take 2 arrays and find their union, difference, and intersection.

 */
public class PriorityQueues{

	private static String[] queueStr1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"} ;
	private static String[] queueStr2 = {"George","Katie", "Kevin", "Michelle", "Ryan"};
	 
	public static void main(String[] args) {
		PriorityQueue<String> queue1 = new PriorityQueue<>(queueStr1.length);
		PriorityQueue<String> queue2 = new PriorityQueue<>(queueStr2.length);
		
		for( int x = 0; x < queueStr1.length; x++) {
			queue1.offer(queueStr1[x]);
		}	
		for( int x = 0; x < queueStr2.length; x++) {
			queue2.offer(queueStr2[x]);
		}			

		findUnion(queue1,queue2);
		findDifference(queue1,queue2);
		findIntersection(queue1,queue2);
	}
	/* Method to display the union between the 2 arrays*/
	public static void findUnion(PriorityQueue<String> queue1, PriorityQueue<String> queue2) {
		PriorityQueue<String> newQ1 = new PriorityQueue<>(queue1);

		System.out.println("Union");
		newQ1.addAll(queue2);
		System.out.println(newQ1);	
	}
	/* Method to display the difference between the 2 arrays*/
	public static void findDifference(PriorityQueue<String> queue1, PriorityQueue<String> queue2) {
		PriorityQueue<String> newQ1 = new PriorityQueue<>(queue1);
		PriorityQueue<String> newQ2 = new PriorityQueue<>(queue2);

		System.out.println("Find Difference");
		newQ1.removeAll(queue2);
		newQ2.removeAll(queue1);
		newQ1.addAll(newQ2);
		System.out.println(newQ1);
	}
	/* Method to display the intersection between the 2 arrays*/
	public static void findIntersection(PriorityQueue<String> queue1, PriorityQueue<String> queue2) {
		PriorityQueue<String> newQ1 = new PriorityQueue<>(queue1);

		System.out.println("find Intersection");
		newQ1.retainAll(queue2);
		System.out.println(newQ1);
	}
}