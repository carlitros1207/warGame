package warGame;

public class Game {
	public static void main(String[] args) {
		Player bob = new Player("bob");
		Player sue = new Player("sue");

		Deck deck = new Deck();
		deck.addCardToDeck(4, 3);
		deck.getCard();
		System.out.println(bob.getName());
		System.out.println(sue.getName());

	}

}
