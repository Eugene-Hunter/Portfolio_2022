import java.sql.SQLException;
import java.util.Scanner;

/*
 * This program can be used by a bookstore clerk to keep inventory of the books and their quantities.
 * The program should allow the clerk to:
 *1. enter new books into the database
 *2. update book information
 *3. delete books from the database
 *4. search the database to find a specific book.
 * The program should present the user with the following menu:
 *1. Enter book
 *2. Update book
 *3. Delete book
 *4. Search books
 *0. Exit
 * The program should perform the function that the user selects and display the results on-screen.
 */
public class TheBookStore {

	private static Scanner input = null;
	
	/** Main method displaying the menu options.
	 * **/
	public static void main(String[] args) throws NullPointerException, SQLException  {
		int quit = 1;
		input = new Scanner(System.in);
		do {
			try {
				System.out.println("Menu:\r\n"
						+ "1. Enter book\r\n"
						+ "2. Update book\r\n"
						+ "3. Delete book\r\n"
						+ "4. Search books\r\n"
						+ "0. Exit ");
				int menuOption = Integer.parseInt(input.nextLine());

				switch (menuOption) {

				case 1:	//Enter book
					menuOption1();
					break;
				case 2: //Update book
					menuOption2();
					break;
				case 3: //Delete book
					menuOption3();
					break;
				case 4: //Search books
					menuOption4();
					break;
				case 0: //Exit
					System.out.println("Good-bye.");
					quit = 0;
					break;
				default:
					break;
				}

			}catch(Exception e) {
				System.out.println(e);
			}
		}while(quit != 0);
	}
	/** 
	 * Method to allow user to add a book entry. The user is requested to enter the book's ID, title, author and quantity.
	 * If the user enters an ID or book title that has already been used, the original entry is displayed and  the user is requested to
	 * enter a different value. The system recognizes any differences in the text as a different book altogether except for case-
	 * sensitivity. The author and quantity fields are not unique.
	 * **/
	public static void menuOption1() throws NullPointerException, SQLException {//Enter book
		int idExist = 0;
		int newID = 0;
		String newTitle = "";
		do {
			System.out.print("Enter the book ID: ");
			newID = Integer.parseInt(input.nextLine());
			idExist = BookDB.searchAction(String.valueOf(newID));
			if (idExist == 1) {
				System.out.println("The book ID already exist");
			}
			else {
				idExist = 0;
			}
			
		}while(idExist == 1);
		do {
			try {
			System.out.print("Enter the book title: ");
			newTitle = (String) input.nextLine();
			idExist = BookDB.searchAction(newTitle);
			if (idExist == 1) {
				System.out.print("The book title already exist. Do you still want to use it? 1) Yes, 0) No: ");
				int yesNo = Integer.parseInt(input.nextLine());
				if (yesNo == 1) {
					idExist = 0;
				}
				else if(yesNo == 0) {
					idExist = 1;					
				}
				else {
					System.out.println("Input was not recognized, please try again.");
					idExist = 1;					
				}
			}
			else 
			{
				idExist = 0;
			}
			}catch(Exception e) {
				idExist = 1;
			}
		}while(idExist != 0);
		System.out.print("Enter the author: ");
		String newAuthor = input.nextLine();
		System.out.print("Enter the Quantity: ");
		int newQty = Integer.parseInt(input.nextLine());

		BookDB.addAction(newID, newTitle, newAuthor, newQty);

	}
	/* Method that allows the user to update a record. The user is requested to select which book's details to update and can 
	 * update the title, author and quantity fields individually.*/
	public static void menuOption2() throws NullPointerException, SQLException {//Update book
		int option = 0;
		System.out.println("Enter the book ID: ");
		int id = Integer.parseInt(input.nextLine());
		BookDB.searchAction(String.valueOf(id));

		do {
			System.out.print("1) Update book title\r\n"
					+ "2) Update author\r\n"
					+ "3) Update quantity\r\n"
					+ "0) Exit: ");

			option = Integer.parseInt(input.nextLine());
			switch(option) {

			case 1:
				System.out.print("Enter  new book title: ");
				String newTitle = input.nextLine();
				BookDB.updateAction("title", newTitle, id);
				break;
			case 2:
				System.out.println("Enter the author: ");
				String newAuthor = input.nextLine();
				BookDB.updateAction("author", newAuthor, id);
				break;
			case 3:
				System.out.println("Enter the Quantity: ");
				int newQty = Integer.parseInt(input.nextLine());
				BookDB.updateAction("qty", String.valueOf(newQty), id);

				break;
			case 0:
				break;
			default:
				System.out.println("Please enter a menu option ");
				break;

			}
		}while(option != 0);

	}
	
	/** 
	 * Method to allow user to delete a book record. The user is requested to enter the book's ID that needs to be deleted.
	 * **/
	public static void menuOption3() throws NullPointerException, SQLException {//Delete book

		System.out.println("Enter the book ID: ");
		int newID = Integer.parseInt(input.nextLine());
		BookDB.deleteAction(newID);
	}
	/** 
	 * Method to allow user to search for a book records that contains the text entered. The search is not case-sensitive and the
	 * text entered is compared to the data in the id, title and author columns.
	 * 
	 * **/
	public static void menuOption4()  throws NullPointerException, SQLException {//Search books
		int exit = 1;

		do {
			try {
				System.out.println("Enter the text to find (may return more than 1 result) or \'%\' to see all: ");
				String textToFind = input.nextLine();
				BookDB.searchAction(textToFind);
				exit = 0;
			}catch(Exception e) {
				e.printStackTrace();
				exit = 1;
			}
		}while(exit != 0);

	}

}
