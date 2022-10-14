import java.util.Scanner;
/** 
 * @author Eugene Hunter
 * 
 * The purpose of the program is to hash an object with at least 2 attributes. The program allows the user to create multiple
 * tree objects and viewing it's hash codes that have been generated.
 * */
public class HashingObject {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] hashes = new int[3];
		String name = "";
		String type = "";
		String climate = "";
		
		System.out.print("Tree name: ");
		name = input.nextLine();
		System.out.print("Tree type: ");
		type = input.nextLine();
		System.out.print("Climate: ");
		climate = input.nextLine();
		Tree newTree = new Tree(name, type, climate);
		int newTreeHash = newTree.hashCode();
		hashes[0] = newTree.returnHash("name", name);
		hashes[1] = newTree.returnHash("type", type);
		hashes[2] = newTree.returnHash("climate", climate);

		newTree.toString(hashes);
		System.out.println(newTree.getName() + " Hash: " + newTreeHash);
	}
}


