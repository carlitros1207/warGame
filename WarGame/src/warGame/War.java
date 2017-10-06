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
			player1.getPlayerDeck().addCardToDeck(mainDeck.getCard());
			player2.getPlayerDeck().addCardToDeck(mainDeck.getCard());
		}
	}
	
	public void playGame() {
		
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
