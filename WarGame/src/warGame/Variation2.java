package warGame;

import java.util.List;

public class Variation2 extends War {

	public Variation2(List<Player> players, Deck mainDeck) {
		super(players, mainDeck);
	}
	
	public void playGame() {
		// For variations 2 and 3 players run out of cards at the same time.
		while(players.get(PLAYER_2).getPlayerDeck().getCard() != null) {
			runRound(players);
		}
		checkScores();
	}
	
	private void runRound(List<Player> players) {
		if (players.get(PLAYER_1).getPlayerDeck().getCard() != null && players.get(PLAYER_2).getPlayerDeck().getCard() != null) {
			System.out.println(players.get(PLAYER_1).getName() + " played " + players.get(PLAYER_1).getPlayerDeck().getCard());
			System.out.println(players.get(PLAYER_2).getName() + " played " + players.get(PLAYER_2).getPlayerDeck().getCard());
		} else return;
		
		if ( getPlayersCardValue(PLAYER_1) > getPlayersCardValue(PLAYER_2) )
		{
			System.out.println(players.get(PLAYER_1).getName() + " wins this round!");
			addToDownPiles(players);
			collectDownPiles(PLAYER_1);
		} else if ( getPlayersCardValue(PLAYER_2) > getPlayersCardValue(PLAYER_1) )
		{
			System.out.println(players.get(PLAYER_2).getName() + " wins this round!");
			addToDownPiles(players);
			collectDownPiles(PLAYER_2);
		} else {
			System.out.println("WAR!");
			// 2 cards go in the down pile because one is the card just played
			addToDownPiles(players);
			addToDownPiles(players);
			runRound(players);
		}
	}
	
	public String checkScores() {
		StringBuilder winnerString = new StringBuilder();
		if ( players.get(PLAYER_1).getScorePile().getDeck().size() > 
				players.get(PLAYER_2).getScorePile().getDeck().size() ) 
		{
			System.out.println(players.get(PLAYER_1).getName() + " wins the game!");
			winnerString.append(players.get(PLAYER_1).getName() + " wins the game!");
		} else if (players.get(PLAYER_2).getScorePile().getDeck().size() > 
					players.get(PLAYER_1).getScorePile().getDeck().size() ) 
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


}
