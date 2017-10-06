package warGame;

public class Player {
	
	private String name;
	private Deck playerDeck; 
	
	public Player(String name) {
		setName(name);
		playerDeck = new Deck();
	}

	public Deck getPlayerDeck() {
		return playerDeck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
