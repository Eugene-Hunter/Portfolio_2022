
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Enumerate the suits
enum Suits {
  SPADES,
  HEARTS,
  CLUBS,
  DIAMONDS
}

// Card class
class Cards {
	
	// instantiating attributes for the class
	private static Cards cardWriter;
	private static Suits suit;
	private static int number;
	
	// method to create an instance of the Cards class
	public static Cards getInstance() {
		
		// IF statement to determine if the class does not already already exists
		if(cardWriter == null) {
			
			cardWriter = new Cards(suit, number); // attribute used to store a new instance of the class 
		}
		return cardWriter; // return the attribute
	}
	
	// Cards constructor method that is set to private to limit access to the Cards object only.
	private Cards(Suits s, int n) {

	// For loop to cycle through the list of suits
	  for (int x = 0; x < 4; x++) {
	    suit = s; // attribute used to store the attribute value
	    for(int y = 2; y < 15; y++) {
	    	
		    if((n < 2) || (n > 14)) { // if statement to determine if the int variable is within the range 2 to 14
		      throw new IllegalArgumentException( ); //
		    }
	    number = n; // assign the integer n  the number attribute
	    print(number, suit); // Display the results
	    }
	  }
	  
  }
	// method to print the individual card values 
  public void print(int n, Suits s ) {

	 // Display the card and suit values
    switch(number) {
      case 11:
        System.out.print("Jack");
        break;
      case 12:
        System.out.print("Queen");
        break;
      case 13:
        System.out.print("King");
        break;
      case 14:
        System.out.print("Ace");
        break;
      default:
        System.out.print(number);
        break;
    }
    System.out.print(" of ");
    switch(suit) {
      case SPADES:
        System.out.println("spades.");
        break;
      case HEARTS:
        System.out.println("hearts.");
        break;
      case CLUBS:
        System.out.println("clubs.");
        break;
      case DIAMONDS:
        System.out.println("diamonds.");
        break;
    }
  }

}

// Deck class
class Decks {
	// instantiating attributes for the class
	private List<Card> cards;
	private static Decks deckWriter;

	// method to create in instance of the Decks class
	public static Decks getInstance() {
		
		// if statement to determine if an object of the class has been instantiated 
		if(deckWriter == null) {
			
			deckWriter = new Decks(); // instantiate an object if one does not exist yet
		}
		
		return deckWriter; // return the Decks object
	}
	// Decks constructor method that is set to private to limit access to the Decks object only.
	private  Decks() {

	    cards = new ArrayList<Card>(); // instantiating a new cards list
	

	    // build the deck
	    Suit[] suits = {Suit.SPADES, Suit.HEARTS, Suit.CLUBS, Suit.DIAMONDS}; // assigning the suit values to the array 
	    
	    for(Suit suit: suits) { // for loop to cycle through the list of cards values
	    	
	      for(int i = 2; i <= 14; i++) { // nested for loop to cycle through the card number range
	    	  
	        cards.add(new Card(suit, i)); // assign the result to the cards list
	        
	      }
	    }
    
    // shuffle it!
    Collections.shuffle(cards, new Random( ));
	}

	// method to print out the cards range
	public void print() {

    for(Card card: cards) { // for loop to cycle through the cards
      card.print(); // display the cards
    }
  }

}

// Main class
public class Singleton {
	// Instantiating class attributes
	private static Decks deck;

	// main method
	public static void main(String args[]) {

		deck = Decks.getInstance(); // Instantiating an instance of the deck class
		deck.print(); // Display the shuffled deck
		
  }

	}

