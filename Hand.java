package myPackage;
import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> myCards = new ArrayList<Card>();
	private int total = 0;
	
	public Hand(){
		/*:::Do nothing:::*/
	}
	
	/*:::Add a card to the players hand:::*/
	public void addCard(Card card){
		
		/*
		 As the hand total is set, check if the cardValue being added is an Ace.
		 If it is, then check if the current total is 10 or less. This will set the Ace to 11.
		 If the current total is 11 or above the Ace should be set to 1.
		 */

		String specialValue = card.getSpecialValue();
		
		if(specialValue == "Ace"){
			
			int currentTotal = getHandTotal();
			if(currentTotal <= 10){
				/*:::Ace is 11:::*/
				this.myCards.add(card);
				int cardValue = 11;
				setHandTotal(cardValue);
			}else{
				/*:::Ace is 1:::*/
				this.myCards.add(card);
				int cardValue = 11;
				setHandTotal(cardValue);
			}
			
		}else{
			
			this.myCards.add(card);
			int cardValue = card.getCardNumberValue();
			setHandTotal(cardValue);
			
		}
		
	}
	
	/*:::Get a players cards in his/her current hand:::*/
	public ArrayList<Card> getMyCards(){
		return this.myCards;
	}
	
	/*:::Get the total for the cards in a players hand:::*/
	public int getHandTotal(){
		return this.total;
	}
	
	/*:::Set the total for the cards in a players hand:::*/
	public void setHandTotal(int cardValue){
		this.total += cardValue;
	}
	
	/*:::Get the number of cards in a players hand:::*/
	public int getNumberOfCards(){
		return this.myCards.size();
	}
	
}
