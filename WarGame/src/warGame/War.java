package warGame;

public class War {

	private Player player1;
	
	private Player player2;
	
	private Deck mainDeck;
	
	public War(Player player1, Player player2, Deck mainDeck) {
		setPlayer1(player1);
		setPlayer2(player2);
		setMainDeck(mainDeck);
	}
	
	public void dealCardsToPlayers() {
		while(mainDeck.getDeck().empty() != true) {
			player1.getPlayerDeck().addCardToDeck(mainDeck.removeCard());
			player2.getPlayerDeck().addCardToDeck(mainDeck.removeCard());
		}
	}
	
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
						System.out.println(player1.getName() + " WAR!");
						mainDeck.addCardToDeck(player1.getPlayerDeck().removeCard());
						mainDeck.addCardToDeck(player2.getPlayerDeck().removeCard());
						runRound(player1, player2);
					}
				}
			}		
		}
	}
	
	private void checkDecks() {
		if(player1.getPlayerDeck().getDeck().empty() == true) {
			System.out.println(player1.getName() + " wins the game!");
			System.exit(0);
		}
		if(player2.getPlayerDeck().getDeck().empty() == true) {
			System.out.println(player2.getName() + " wins the game!");
			System.exit(0);
		}

	}
	
	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Deck getMainDeck() {
		return mainDeck;
	}

	public void setMainDeck(Deck mainDeck) {
		this.mainDeck = mainDeck;
	}

}
