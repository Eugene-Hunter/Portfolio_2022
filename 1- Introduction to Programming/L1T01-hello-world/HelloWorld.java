import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {

		System.out.print("Say what you need to say here ->: ");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		System.out.print(userInput);
		input.close();
	}

}