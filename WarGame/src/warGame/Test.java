package warGame;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Player bob = new Player("bob");
		Player sue = new Player("sue");
		Deck deck = new Deck();
		List<Player> players = new ArrayList<Player>();
		players.add(bob);
		players.add(sue);
		Variation1 game1 = new Variation1(players, deck);
		
		deck.populateDeck();
		deck.shuffleDeck();
		//deck.addCardToDeck(new Card(CardValue.FIVE, CardSuit.CLUBS));
		//deck.addCardToDeck(new Card(CardValue.SEVEN, CardSuit.HEARTS));
		//deck.addCardToDeck(new Card(CardValue.FIVE, CardSuit.SPADES));
		//deck.addCardToDeck(new Card(CardValue.ACE, CardSuit.DIAMONDS));
		//deck.printAllDeck();
		
		game1.dealCardsToPlayers();
		game1.playGame();
		//System.out.println(bob.getPlayerDeck().getCard());
		//System.out.println(sue.getPlayerDeck().getCard());
	}

}
