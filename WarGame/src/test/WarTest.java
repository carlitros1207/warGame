package test;
import warGame.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.Test;

import junit.framework.TestCase;

public class WarTest extends TestCase {
	private Deck testDeck = new Deck();
	private Player bob = new Player("bob");
	private Player sue = new Player("sue");
	private Player jon = new Player("jon");
	private List<Player> players = new ArrayList<Player>();
	@Before
	public void setUp(){
		testDeck.populateDeck();
		players.add(bob);
		players.add(sue);
	}
	
	@After
	public void tearDown(){
		testDeck = null;
		bob = null;
		sue = null;
		jon = null;
		players = null;
		assertNull(testDeck);
		assertNull(bob);
		assertNull(players);
		assertNull(sue);
		assertNull(jon);
		
	}
	
	@Test
	public void testVariation1TwoPlayers() {
		Variation1 game = new Variation1(players, testDeck);
		game.dealCardsToPlayers();
		assertNotNull(bob.getPlayerDeck());
		assertNotNull(sue.getPlayerDeck());
		game.playGame();
		assertTrue(game.checkDecks().equals("bob wins the game!"));
		
	}
	@Test
	public void testVariation1SueWins(){
		Deck riggedDeck = new Deck();
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.CLUBS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.HEARTS));
		
		Variation1 game = new Variation1(players, riggedDeck);
		game.dealCardsToPlayers();
		game.playGame();
		assertTrue(game.checkDecks().equals("Tie game!"));
	}
	
	@Test
	public void testVariation2TwoPlayers() {
		Variation2 game = new Variation2(players, testDeck);
		game.dealCardsToPlayers();
		assertNotNull(bob.getPlayerDeck());
		assertNotNull(sue.getPlayerDeck());
		game.playGame();
		assertTrue(game.checkScores().equals("bob wins the game!"));
		
	}
	

}
