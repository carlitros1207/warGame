package warGame;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
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

		
		System.out.println("Variation 1 begin\n");
		game1.dealCardsToPlayers();
		game1.playGame();
		playGame2();
		playGame3();
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

	private static void playGame3() {
		Player bob = new Player("bob");
		Player sue = new Player("sue");
		Player jon = new Player("jon");
		Deck deck = new Deck();
		List<Player> players = new ArrayList<Player>();
		players.add(bob);
		players.add(sue);
		players.add(jon);
		Variation3 game3 = new Variation3(players, deck);
		
		deck.populateDeck();
		deck.shuffleDeck();
		
		System.out.println("\nVariation 3 begin\n");
		game3.dealCardsToPlayers();
		game3.playGame();
	}
}