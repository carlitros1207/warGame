package warGame;

public class Test {
	public static void main(String[] args) {
		Player bob = new Player("bob");
		Player sue = new Player("sue");

		Deck deck = new Deck();
		deck.populateDeck();
		//deck.shuffleDeck();
		deck.printAllDeck();
		
		
		
		System.out.println(bob.getName());
		System.out.println(sue.getName());

	}

}
