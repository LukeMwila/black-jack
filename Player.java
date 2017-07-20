package myPackage;
import java.util.Scanner;

public class Player extends Gambler{
	
	public Player(String name){
		super(name);
		firstDraw();
	}
	
	/*:::Player check his/her hand Game:::*/
	public void checkHand(){
		
		System.out.println("\n\nYour turn " + getName());
		boolean keepHitting = true;
		int currentHand = this.hand.getHandTotal();
		
		while(keepHitting){
			
			if(currentHand <= 21){
				
				System.out.println("Your current hand is:");
				showHand();
				System.out.println("\nWould you like to take a hit or stand? (Enter 'H' for a hit and 'S' for a stand)");
				Scanner input = new Scanner(System.in);
				String choice = input.nextLine();

				/*:::Player has to make a choice to take a hit or stay:::*/
				if(choice.equalsIgnoreCase("H")){
					/*:::Hit:::*/
					drawCard();
				}else{
					/*:::Stay:::*/
					System.out.println(getName() + " has decided to stay.");
					keepHitting = false;
					break;
				}
				
			}else{
				/*:::Player has gone over 21:::*/
				System.out.println("Sorry but you busted. Your current hand is:");
				showHand();	
				break;
				
			}
			
			currentHand = this.hand.getHandTotal();
			
		}
		
	}
	
	/*:::Player draws 2 cards:::*/
	public void firstDraw(){
		
		for(int x = 0; x < 2; x++){
			Card card = Deck.getInstance().getCardFromDeck();
			this.hand.addCard(card);
		}
	}
	
	/*:::Check if player beat the dealer:::*/
	public String getPlayerScore(int dealersScore){
		
		String scoreCard;
		
		int playersTotal = this.hand.getHandTotal();
		int playersNumberOfCards = this.hand.getNumberOfCards();
		
		if(playersNumberOfCards == 5 && playersTotal < 21){
			scoreCard = getName() + " beats the dealer.";
		}else if(playersTotal == 21){
			scoreCard = getName() + " beats the dealer.";
		}else if(playersTotal > dealersScore && playersTotal <= 21){
			scoreCard = getName() + " beats the dealer.";
		}else{
			scoreCard = getName() + " loses.";
		}
		
		return scoreCard;
		
	}
	
}
