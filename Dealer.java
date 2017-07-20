package myPackage;

public class Dealer extends Gambler{
	
	int highestValue = 15;
	
	public Dealer(String name){
		super(name);
	}
	
	/*
	 When a dealer checks his hand, he checks the current total.
	 If the total is less than the permitted "highest value", the dealer draws another card. 
	 If the total is higher than the dealers permitted "highest value", the dealer stays with his/her two cards.
	 */
	public void checkHand(){
		
		int currentTotal = 0;
		while(currentTotal <= highestValue){
			drawCard();
			currentTotal = this.hand.getHandTotal();
		}
	}
	
	public int getHandTotal(){
		return this.hand.getHandTotal();
	}
	
}
