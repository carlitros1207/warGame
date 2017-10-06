package warGame;

public class Test {
	public static void main(String[] args) {
		Player bob = new Player("bob");
		Player sue = new Player("sue");
		Deck deck = new Deck();
		War game = new War(bob, sue, deck);
		
		deck.populateDeck();
		deck.shuffleDeck();
		//deck.addCardToDeck(new Card(CardValue.FIVE, CardSuit.CLUBS));
		//deck.addCardToDeck(new Card(CardValue.SEVEN, CardSuit.HEARTS));
		//deck.addCardToDeck(new Card(CardValue.FIVE, CardSuit.SPADES));
		//deck.addCardToDeck(new Card(CardValue.ACE, CardSuit.DIAMONDS));
		//deck.printAllDeck();
		
		game.dealCardsToPlayers();
		game.playGame();
		//System.out.println(bob.getPlayerDeck().getCard());
		//System.out.println(sue.getPlayerDeck().getCard());
	}

}
