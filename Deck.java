package myPackage;
import java.util.*;
import java.util.stream.IntStream;

public class Deck implements DeckRules{
	
	int cardValue;
	private static Deck instance = null;
	private static ArrayList<Card> cards = new ArrayList<Card>();
	String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	int[] specialValues = {1,11,12,13}; /*:::Values for => Ace, Jack, Queen and King:::*/
	
	private Deck(){
		loadDeck();
	}
	
	public static Deck getInstance(){
        if(instance == null){
            instance = new Deck();
        }
        return instance;
    }
	
	public void loadDeck(){
		
		boolean contains;
		String specialValue = "";
		
		/*:::Loop through every suit and load 13 cards of each type to the deck:::*/
		
		for(String suit : this.suits){
			
			for(int i = 0; i < MAX_NUMBER_OF_CARDS_PER_SUIT; i++){
				
				/*:::Check if the number value matches a special card:::*/
				cardValue = i + 1;
				contains = IntStream.of(this.specialValues).anyMatch(x -> x == cardValue);
				
				if(contains){
					
					switch(cardValue){
					
						case 1:
							cardValue = 1;
							specialValue = "Ace";
							break;
						case 11:
							cardValue = 10;
							specialValue = "Jack";
							break;
						case 12:
							cardValue = 10;
							specialValue = "Queen";
							break;
						case 13:
							cardValue = 10;
							specialValue = "King";
							break;
						default:
							cardValue = 0;
							specialValue = "";
							break;
					}
				
				}
				
				Card card = new Card(suit,cardValue,contains,specialValue);
				addCard(card);
				
			}
			
		}
		
	}
	
	/*:::Shuffle the cards in the deck:::*/
	public void shuffleDeck(){
		Collections.shuffle(getCards());
	}
	
	/*:::Get a card from the deck:::*/
	public Card getCardFromDeck(){
		ArrayList<Card> cards = getCards();
		Card topCard = cards.get(0);
		cards.remove(0);
		setCards(cards);
		return topCard;
	}
	
	/*:::Get all the card in the deck:::*/
	public static ArrayList<Card> getCards() {
		return Deck.cards;
	}
	
	/*:::Add a card to the deck:::*/
	private static void addCard(Card card){
		ArrayList<Card> cards = getCards();
		cards.add(card);
		Deck.cards = cards;
	}
	
	/*:::Set the cards in the deck:::*/
	public static void setCards(ArrayList<Card> cards) {
		Deck.cards = cards;
	}
	
	/*:::Get the number of cards in the deck:::*/
	public int getSizeOfDeck(){
		return Deck.cards.size();
	}
	
}
