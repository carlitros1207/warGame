package warGame;

import java.util.Collection;
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
		} else return;
		
		if ( players.get(PLAYER_1).getPlayerDeck().getCard().getCardValue().getValue() > 
			players.get(PLAYER_2).getPlayerDeck().getCard().getCardValue().getValue() )
		{
			System.out.println(players.get(PLAYER_1).getName() + " wins this round!");
			players.get(PLAYER_1).getDownPile().addCardToTopOfDeck(players.get(PLAYER_1).getPlayerDeck().removeCard());
			players.get(PLAYER_2).getDownPile().addCardToTopOfDeck(players.get(PLAYER_2).getPlayerDeck().removeCard());
			collectDownPiles(PLAYER_1);
		} else if ( players.get(PLAYER_2).getPlayerDeck().getCard().getCardValue().getValue() > 
					players.get(PLAYER_1).getPlayerDeck().getCard().getCardValue().getValue() )
		{
			System.out.println(players.get(PLAYER_2).getName() + " wins this round!");
			players.get(PLAYER_1).getDownPile().addCardToTopOfDeck(players.get(PLAYER_1).getPlayerDeck().removeCard());
			players.get(PLAYER_2).getDownPile().addCardToTopOfDeck(players.get(PLAYER_2).getPlayerDeck().removeCard());
			collectDownPiles(PLAYER_2);
		} else {
			System.out.println("WAR!");
			players.get(PLAYER_1).getDownPile().addCardToTopOfDeck(players.get(PLAYER_1).getPlayerDeck().removeCard());
			players.get(PLAYER_2).getDownPile().addCardToTopOfDeck(players.get(PLAYER_2).getPlayerDeck().removeCard());
			runRound(players);
		}
	}
	
	@Override
	public void collectDownPiles(int winner) {
		while (!players.get(PLAYER_1).getDownPile().getDeck().isEmpty()) {
			players.get(winner).getPlayerDeck().addCardToBottomOfDeck(players.get(PLAYER_1).getDownPile().removeCard());
		}
		while (!players.get(PLAYER_2).getDownPile().getDeck().isEmpty()) {
			players.get(winner).getPlayerDeck().addCardToBottomOfDeck(players.get(PLAYER_2).getDownPile().removeCard());
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
