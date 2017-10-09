package warGame;

import java.util.List;

public class Variation3 extends War {

	public Variation3(List<Player> players, Deck mainDeck) {
		super(players, mainDeck);
	}
	
	public void playGame() {
		// For variations 2 and 3 players run out of cards at the same time.
		// For variation 3 player 1 should have one extra card at the end so we check player 2.
		while(players.get(PLAYER_2).getPlayerDeck().getCard() != null) {
			runRound(players);
		}
		checkScores();
	}
	
	private void runRound(List<Player> players) {
		int max = 0, i = 0;
		Player projectedWinner = null;
		int winnerIndex = 0; // need this cuz collectDownPiles takes an int param
		
		if (players.get(PLAYER_2).getPlayerDeck().getCard() != null) {
			// get the max value produced by the 3 players and save whoever had the highest
			for (Player player : players) {
				System.out.println(player.getName() + " played " + player.getPlayerDeck().getCard());
				if (player.getPlayerDeck().getCard().getCardValue().getValue() > max) {
					max = player.getPlayerDeck().getCard().getCardValue().getValue();
					projectedWinner = player;
					winnerIndex = i;
				}
				i++;
			}
			// check if anyone matched the highest value and war happens if so
			for (Player player : players) {
				if (player.getPlayerDeck().getCard().getCardValue().getValue() == max
						&& player != projectedWinner) {
					System.out.println("WAR!");
					addToDownPiles(players);
					addToDownPiles(players);
					/*
					for (Player p : players) {      // 2 cards go in the down pile because one is the card just played
						p.getDownPile().addCardToTopOfDeck(p.getPlayerDeck().removeCard());
						p.getDownPile().addCardToTopOfDeck(p.getPlayerDeck().removeCard());
					}
					*/					
					runRound(players);
					return;
				}
			}
			// no one matched the highest value so winner takes all
			System.out.println(projectedWinner.getName() + " wins this round!");
			addToDownPiles(players);
			/*
			players.get(PLAYER_1).getDownPile().addCardToTopOfDeck(players.get(PLAYER_1).getPlayerDeck().removeCard());
			players.get(PLAYER_2).getDownPile().addCardToTopOfDeck(players.get(PLAYER_2).getPlayerDeck().removeCard());
			players.get(PLAYER_3).getDownPile().addCardToTopOfDeck(players.get(PLAYER_3).getPlayerDeck().removeCard());
			*/
			collectDownPiles(winnerIndex);
		}
	}
	
	public String checkScores() {
		StringBuilder winnerString = new StringBuilder();
		int max = 0;
		boolean twoWayTie = false;
		boolean threeWayTie = false;
		Player projectedWinner = null;
		Player otherWinner = null;
		for (Player player : players) {
			if (player.getScorePile().getDeck().size() > max) {
				max = player.getScorePile().getDeck().size();
				projectedWinner = player;
			} else if (player.getScorePile().getDeck().size() == max) {
				if (!twoWayTie) {
					otherWinner = player;
					twoWayTie = true;
				} else {
					twoWayTie = false;
					threeWayTie = true;
				}
			}
		}
		if (twoWayTie) {
			System.out.println("Tie between " + projectedWinner.getName() + " & " + otherWinner.getName() + "!");
			winnerString.append("Tie between " + projectedWinner.getName() + " & " + otherWinner.getName() + "!");
		} else if (threeWayTie) {
			System.out.println("Three-way tie! Wtf!");
			winnerString.append("Three-way tie! Wtf!");
		} else {
			System.out.println(projectedWinner.getName() + " wins the game!");
			winnerString.append(projectedWinner.getName() + " wins the game!");
		}
		return winnerString.toString();
	}

}
