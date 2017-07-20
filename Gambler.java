package myPackage;

import java.util.ArrayList;

public abstract class Gambler implements Person { 
	
	protected String name;
	protected Hand hand;
	
	public Gambler(String name){
		setName(name);
		this.hand = new Hand();
	}
	
	/*:::Set the player's name:::*/
	public void setName(String name){
		this.name = name;
	}
	
	/*:::Return the player's name:::*/
	public String getName(){
		return this.name;
	}

	public abstract void checkHand();
	
	/*:::Draw card from deck and add it to players hand:::*/
	public void drawCard(){
		Card card = Deck.getInstance().getCardFromDeck();
		this.hand.addCard(card);
	}
	
	/*:::Player shows their hand:::*/
	public void showHand(){
		
		ArrayList<Card> myCards = this.hand.getMyCards();	
		System.out.println(getName());
		myCards.forEach(card -> System.out.println(card.getCardValue())); 
		System.out.println("Total is: " + this.hand.getHandTotal() + "\n");
		
	}
	
}
