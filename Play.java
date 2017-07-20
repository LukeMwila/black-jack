package myPackage;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		final int MIN_PLAYERS = 1; /*:::Minimum number of players:::*/
		int playerCount = 0;
		ArrayList<Player> players = new ArrayList<Player>();
		Deck deck = Deck.getInstance();
		deck.shuffleDeck();
		Dealer dealer = new Dealer("The Dealer - Bob Marley");
		dealer.checkHand();
		int dealersHandTotal = dealer.getHandTotal();
		
		boolean blackJackManager = true;
		while (blackJackManager){ 
			int menuChoice = printMenu();
			switch (menuChoice)
			{ 
				case 1:
					System.out.println("You chose to create a new player.");
					players.add(getNewPlayer());				
					playerCount++;
					break;
					
				case 2:
					System.out.println("You chose to start the game.");
					if (playerCount < MIN_PLAYERS)
					{
						System.out.println("You need to add at least one player to the game.");
					}
					else
					{
						blackJackManager = false;
					}
					break;
			}
		}

		/*:::Start Game:::*/
		players.stream().forEach(Player::checkHand);
		/*:::Show the dealer's hand and then show every player's hand. Must show if the player beat the dealer or not:::*/
		dealer.showHand();
		players.stream().forEach(Player::showHand);
		for(Player player : players){ 
			System.out.println(player.getPlayerScore(dealersHandTotal));	  
		}
	}
	
	/*:::Print the menu:::*/
	public static int printMenu(){
		Scanner input = new Scanner(System.in);
		System.out.println("*******************************************");
		System.out.println("* Welcome to Black Jack 21 *");
		System.out.println("*******************************************");
		System.out.println("Would you like to add a player?");
		System.out.println("-------------------------------------------");
		System.out.println("Enter '1' to add a new player");
		System.out.println("Enter '2' to start the game");
		System.out.println("-------------------------------------------");
		System.out.println("*******************************************");
		return Integer.parseInt(input.nextLine());
	}
	
	/*:::Add a new player to the game:::*/
	public static Player getNewPlayer()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the name of the player:");
		String name = scanner.nextLine();
		return new Player(name); 
	}
	
}
