package warGame;

public class Player {
	
	private String name;
	private Deck playerDeck;
	private Deck downPile;
	private Deck scorePile;
	
	public Player(String name) {
		setName(name);
		playerDeck = new Deck();
		downPile = new Deck();
		scorePile = new Deck();
	}

	public Deck getPlayerDeck() {
		return playerDeck;
	}
	
	public Deck getDownPile() {
		return downPile;
	}
	
	public Deck getScorePile() {
		return scorePile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
