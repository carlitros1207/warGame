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
	
	/*
	public void playGame() {
		int iterations = 0;
		while(iterations < 30 && player2.getPlayerDeck().getCard() != null && player1.getPlayerDeck().getCard() != null) {
			runRound(this.player1,this.player2);
			iterations++;
		}
		checkDecks();
	}
	
	private void runRound(Player player1 , Player player2){
		if(player2.getPlayerDeck().getCard() != null && player1.getPlayerDeck().getCard() != null) {
			if(player1.getPlayerDeck().getCard().getCardValue().getValue() < player2.getPlayerDeck().getCard().getCardValue().getValue()) {
				System.out.println(player1.getName() + " played " + player1.getPlayerDeck().getCard());
				System.out.println(player2.getName() + " played " + player2.getPlayerDeck().getCard());
				System.out.println(player2.getName() + " wins this round!");
				mainDeck.addCardToDeck(player1.getPlayerDeck().removeCard());
				mainDeck.addCardToDeck(player2.getPlayerDeck().removeCard());
				player1.getPlayerDeck().addCardToDeck(mainDeck.removeCard());
				player1.getPlayerDeck().addCardToDeck(mainDeck.removeCard());

			}else {
				if(player1.getPlayerDeck().getCard().getCardValue().getValue() > player2.getPlayerDeck().getCard().getCardValue().getValue()) {
					System.out.println(player1.getName() + " played " + player1.getPlayerDeck().getCard());
					System.out.println(player2.getName() + " played " + player2.getPlayerDeck().getCard());
					System.out.println(player1.getName() + " wins this round!");
					mainDeck.addCardToDeck(player1.getPlayerDeck().removeCard());
					mainDeck.addCardToDeck(player2.getPlayerDeck().removeCard());
					player2.getPlayerDeck().addCardToDeck(mainDeck.removeCard());
					player2.getPlayerDeck().addCardToDeck(mainDeck.removeCard());
				}else {
					if(player1.getPlayerDeck().getCard().getCardValue().getValue() == player2.getPlayerDeck().getCard().getCardValue().getValue()) {
						System.out.println(player1.getName() + " played " + player1.getPlayerDeck().getCard());
						System.out.println(player2.getName() + " played " + player2.getPlayerDeck().getCard());
						System.out.println("WAR!");
						mainDeck.addCardToDeck(player1.getPlayerDeck().removeCard());
						mainDeck.addCardToDeck(player2.getPlayerDeck().removeCard());
						runRound(player1, player2);
					}
				}
			}		
		}
	}
	

	
	public void checkDecks() {
		if(player1.getPlayerDeck().getDeck().isEmpty() == true) {
			System.out.println(player1.getName() + " wins the game!");
			System.exit(0);
		}
		if(player2.getPlayerDeck().getDeck().isEmpty() == true) {
			System.out.println(player2.getName() + " wins the game!");
			System.exit(0);
		}

	}
	

	
	public int getPlayer1() {
		return 0;
	}


	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}


	public int getPlayer2() {
		return 1;
	}


	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	*/


	public Deck getMainDeck() {
		return mainDeck;
	}

	public void setMainDeck(Deck mainDeck) {
		this.mainDeck = mainDeck;
	}

}
