package warGame;

import java.util.List;

public class Variation1 extends War {

	public Variation1(List<Player> players, Deck mainDeck) {
		super(players, mainDeck);
	}
	
	public void playGame() {
		int iterations = 0;
		while(iterations < 30 && players.get(PLAYER_1).getPlayerDeck().getCard() != null
				&& players.get(PLAYER_2).getPlayerDeck().getCard() != null) 
		{
			runRound(players);
			iterations++;
		}
		checkDecks();
	}
	
	private void runRound(List<Player> players) {
		if (players.get(PLAYER_1).getPlayerDeck().getCard() != null && players.get(PLAYER_2).getPlayerDeck().getCard() != null) {
			System.out.println(players.get(PLAYER_1).getName() + " played " + players.get(PLAYER_1).getPlayerDeck().getCard());
			System.out.println(players.get(PLAYER_2).getName() + " played " + players.get(PLAYER_2).getPlayerDeck().getCard());
		}
		
		if ( players.get(PLAYER_1).getPlayerDeck().getCard().getCardValue().getValue() > 
			players.get(PLAYER_2).getPlayerDeck().getCard().getCardValue().getValue() )
		{
			System.out.println(players.get(PLAYER_1).getName() + " wins this round!");
			mainDeck.addCardToTopOfDeck(players.get(PLAYER_1).getPlayerDeck().removeCard());
			mainDeck.addCardToTopOfDeck(players.get(PLAYER_2).getPlayerDeck().removeCard());
			players.get(PLAYER_1).getPlayerDeck().addCardToBottomOfDeck(mainDeck.removeCard());
			players.get(PLAYER_1).getPlayerDeck().addCardToBottomOfDeck(mainDeck.removeCard());
		} else if ( players.get(PLAYER_2).getPlayerDeck().getCard().getCardValue().getValue() > 
					players.get(PLAYER_1).getPlayerDeck().getCard().getCardValue().getValue() )
		{
			System.out.println(players.get(PLAYER_2).getName() + " wins this round!");
			mainDeck.addCardToTopOfDeck(players.get(PLAYER_1).getPlayerDeck().removeCard());
			mainDeck.addCardToTopOfDeck(players.get(PLAYER_2).getPlayerDeck().removeCard());
			players.get(PLAYER_2).getPlayerDeck().addCardToBottomOfDeck(mainDeck.removeCard());
			players.get(PLAYER_2).getPlayerDeck().addCardToBottomOfDeck(mainDeck.removeCard());
		} else {
			System.out.println("WAR!");
			mainDeck.addCardToTopOfDeck(players.get(PLAYER_1).getPlayerDeck().removeCard());
			mainDeck.addCardToTopOfDeck(players.get(PLAYER_2).getPlayerDeck().removeCard());
			runRound(players);
		}
	}
	
	private void checkDecks() {
		if ( players.get(PLAYER_1).getPlayerDeck().getDeck().size() > 
			players.get(PLAYER_2).getPlayerDeck().getDeck().size() ) 
		{
			System.out.println(players.get(PLAYER_1).getName() + " wins the game!");
		} else if (players.get(PLAYER_2).getPlayerDeck().getDeck().size() > 
			players.get(PLAYER_1).getPlayerDeck().getDeck().size() ) 
		{
			System.out.println(players.get(PLAYER_2).getName() + " wins the game!");
		} else 
		{
			System.out.println("Tie game!");
		}
	}
}
