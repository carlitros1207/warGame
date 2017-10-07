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
		
		System.out.println("Variation 1 begin\n");
		game1.dealCardsToPlayers();
		game1.playGame();
		//System.out.println(bob.getPlayerDeck().getCard());
		//System.out.println(sue.getPlayerDeck().getCard());
		playGame2();
	}
	
	private static void playGame2() {
		Player bob = new Player("bob");
		Player sue = new Player("sue");
		Deck deck = new Deck();
		List<Player> players = new ArrayList<Player>();
		players.add(bob);
		players.add(sue);
		Variation2 game2 = new Variation2(players, deck);
		
		deck.populateDeck();
		deck.shuffleDeck();
		
		System.out.println("\nVariation 2 begin\n");
		game2.dealCardsToPlayers();
		game2.playGame();
	}

}
