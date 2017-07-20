package myPackage;

public class Card {
	
	private String suit;
	private int value;
	private String specialValue;
	private boolean specialCard;
	
	public Card(String suit, int value, boolean specialCard, String specialValue){
		this.suit = suit;
		this.value = value;
		this.specialCard = specialCard;
		this.specialValue = (specialCard == true) ?  specialValue : "";
	}
	
	/*:::Return the card's suit and number value:::*/
	public String getCardValue(){
		
		String cardValue;
		
		if(this.specialCard){
			cardValue = this.specialValue + " of " + this.suit;
		}else{
			cardValue = this.value + " of " + this.suit;
		}
		
		return cardValue;
	}
	
	/*:::Get the number value of the card:::*/
	public int getCardNumberValue(){
		return this.value;
	}
	
	/*:::Get the value of the special(Face or Ace) card:::*/
	public String getSpecialValue(){
		return this.specialValue;
	}
	
	/*:::Get the special(Face or Ace) card:::*/
	public boolean getSpecialCard(){
		return this.specialCard;
	}
	
}
