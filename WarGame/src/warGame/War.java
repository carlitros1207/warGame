package warGame;

import java.util.List;

public class War {

	// Made this class more abstract so the 3 variations can all inherit from it.
	// Most notably players are passed as a list now so variation 3 won't have to be written from scratch.
	
	public static final int PLAYER_1 = 0;
	public static final int PLAYER_2 = 1;
	public static final int PLAYER_3 = 2;
	
	public List<Player> players;
	
	public Deck mainDeck;
	
	public War(List<Player> players, Deck mainDeck) {
		this.players = players;
		setMainDeck(mainDeck);
	}
	
	public void dealCardsToPlayers() {
		while(mainDeck.getDeck().isEmpty() != true) {
			for (Player player : players) {
				if (mainDeck.getDeck().isEmpty()) break; // prevents Var3 from crashing
				player.getPlayerDeck().addCardToTopOfDeck(mainDeck.removeCard());
			}
		}
	}
	
	public void collectDownPiles(int winner) {
		while (!players.get(PLAYER_1).getDownPile().getDeck().isEmpty()) {
			players.get(winner).getScorePile().addCardToTopOfDeck(players.get(PLAYER_1).getDownPile().removeCard());
		}
		while (!players.get(PLAYER_2).getDownPile().getDeck().isEmpty()) {
			players.get(winner).getScorePile().addCardToTopOfDeck(players.get(PLAYER_2).getDownPile().removeCard());
		}
		try {
			players.get(PLAYER_3);
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		while (!players.get(PLAYER_3).getDownPile().getDeck().isEmpty()) {
			players.get(winner).getScorePile().addCardToTopOfDeck(players.get(PLAYER_3).getDownPile().removeCard());
		}
	}
	
	
	public String checkDecks() {
		StringBuilder winnerString = new StringBuilder();
		if ( players.get(PLAYER_1).getPlayerDeck().getDeck().size() > 
			players.get(PLAYER_2).getPlayerDeck().getDeck().size() ) 
		{
			winnerString.append(players.get(PLAYER_1).getName() + " wins the game!");
			System.out.println(players.get(PLAYER_1).getName() + " wins the game!");
		} else if (players.get(PLAYER_2).getPlayerDeck().getDeck().size() > 
			players.get(PLAYER_1).getPlayerDeck().getDeck().size() ) 
		{
			System.out.println(players.get(PLAYER_2).getName() + " wins the game!");
			winnerString.append(players.get(PLAYER_2).getName() + " wins the game!");
		} else 
		{
			System.out.println("Tie game!");
			winnerString.append("Tie game!");
		}
		return winnerString.toString();
	}		

	public void addToDownPiles(List<Player> players) {
		for (Player player : players) {
			player.getDownPile().addCardToTopOfDeck(player.getPlayerDeck().removeCard());
		}
	}
	
	public int getPlayersCardValue(int index) {
		return players.get(index).getPlayerDeck().getCard().getCardValue().getValue();
	}
	
	public Deck getMainDeck() {
		return mainDeck;
	}

	public void setMainDeck(Deck mainDeck) {
		this.mainDeck = mainDeck;
	}

}
