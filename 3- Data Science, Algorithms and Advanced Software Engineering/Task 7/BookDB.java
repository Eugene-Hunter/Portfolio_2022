import java.sql.*;
import java.util.Scanner;

public class BookDB {
	private static Scanner input = new Scanner(System.in);
	/* Method to add new book records to the database*/
	public static void addAction(int newID, String newTitle, String newAuthor, int newQty) throws SQLException, NullPointerException  {
		//Add record to the database

		try(
				Connection connect = connectToDB();
				Statement statement = connect.createStatement();){
			int rowsAffected;
			rowsAffected = statement.executeUpdate(
					"INSERT INTO books VALUES(" + newID + ", \'" + newTitle + "\', \'" + newAuthor + "\', " + newQty + ");"
					);
			System.out.println("Query complete, " + rowsAffected + " rows added.");

		}catch(NullPointerException e) {
			System.out.println("addAction: " + e);
		}
	}	

	/* Method to update existing book records in the database*/
	public static void  updateAction(String column, String newValue, int bookId)  throws SQLException, NullPointerException {
		//Update record in the database
		try (Connection connect = connectToDB();
				Statement statement = connect.createStatement();
				){
			int rowsAffected;
			rowsAffected = statement.executeUpdate(
					"UPDATE books SET " + column + " = \'" + newValue + "\' WHERE id  = \'" + bookId + "\';");

			System.out.println("Query complete, " + rowsAffected + " rows updated.");

			searchAction(String.valueOf(bookId));


		}catch(NullPointerException | SQLException updateAction) {
			System.out.println("Update Action: " + updateAction);		
		}

	}

	/* Method to delete a selected book record from the database*/
	public static void deleteAction(int findId) throws SQLException, NullPointerException  {
		int delYesNo = 0;
		try (Connection connect = connectToDB();
				// Create a direct line to the database for running our queries
				Statement statement = connect.createStatement();){
			int rowsAffected;
			searchAction(String.valueOf(findId));

			System.out.print(" Are you sure? 1) Yes or 0) No: ");
			delYesNo = Integer.parseInt(input.nextLine());
			if (delYesNo == 1) {
				rowsAffected = statement.executeUpdate(
						"DELETE FROM books WHERE id = " + findId + ";"
						);            
				System.out.println("Query complete, " + rowsAffected + " rows removed.");
				toString(statement);
			}
			else {
				System.out.println("Deleting file aborted");
			}
		} catch(NullPointerException | SQLException deleteAction) {
			System.out.println("Delete Action: " + deleteAction);		
		}
	}

	/* Method to search for book records in the database that contain a specific substring of text. The method will return all 
	 * records that match the string of text.*/
	public static int searchAction(String findText) throws SQLException, NullPointerException {
		int result = 0;
		int count = 0;
		int again = 0;
		do {	
			try 
			//Search for a record
			(Connection connect = connectToDB();
					Statement statement = connect.createStatement() ;
					ResultSet results  = statement.executeQuery("SELECT * FROM books " 
							+ "WHERE id LIKE \'" + findText
							+ "\' OR title LIKE \'" + findText
							+ "\' OR author LIKE \'" + findText
							+"\';");
					){
				// Loop over the results, printing them all.
				while (results.next()) {
					count++;
					System.out.print(count + ": " );
					System.out.println( "Book ID: " + results.getInt("id")
					+"\tTitle: " + results.getString("title")
					+ "\r\n   Author: " + results.getString("author")
					+ "\r\n   Quantity\t: " + results.getInt("qty"));
					System.out.println();
					result = 1;
				}
				again = 0;
			}catch(NullPointerException | SQLException searchAction) {
				System.out.println("Search Action: " + searchAction);
				System.out.print("Try again. Non-alphanumerical character must be preceded by a \'\\\' sign. : ");
				findText = input.nextLine();
				again = 1;
			}
		} while(again == 1);
		return result;
	}
	
	/** Method to initialize a connection object with the database. If successful and the database could be located,
	 * the connection is then returned to the function that requested the connection.
	 * **/
	public static Connection connectToDB() throws SQLException, NullPointerException { 
		//
		Connection connect = null;
		try
		{connect = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/theBookStore?useSSL=false",
				"otheruser",
				"swordfish"
				);

		} catch (SQLException e) {
			System.out.println("connectToDB: " + e);
		}

		return connect;
	}
	/*@Override toString method */
	public static void toString(Statement printInfo) throws SQLException, NullPointerException {

		ResultSet results = printInfo.executeQuery("SELECT * FROM books;");
		while (results.next()) {
			System.out.println(
					results.getInt("id") + ", "
							+ results.getString("title") + ", "
							+ results.getString("author") + ", "        
							+ results.getInt("qty")
					);

		}
	}
}