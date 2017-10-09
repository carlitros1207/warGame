package test;
import warGame.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

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
		System.out.println("VAR1");
		
		Variation1 game = new Variation1(players, testDeck);
		game.dealCardsToPlayers();
		assertNotNull(bob.getPlayerDeck());
		assertNotNull(sue.getPlayerDeck());
		game.playGame();
		assertTrue(game.checkDecks().equals("bob wins the game!"));
		
	}
	
	@Test
	public void testVariation1Player2Wins(){
		System.out.println("VAR1SUEWINS");

		Deck riggedDeck = new Deck();
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.CLUBS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.TWO,CardSuit.HEARTS));
		
		Variation1 game = new Variation1(players, riggedDeck);
		game.dealCardsToPlayers();
		game.playGame();
		assertTrue(game.checkDecks().equals("sue wins the game!"));
	}
	
	@Test
	public void testVariation1TieGame(){
		System.out.println("VAR1TIE");

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
		System.out.println("VAR2");

		Variation2 game = new Variation2(players, testDeck);
		game.dealCardsToPlayers();
		assertNotNull(bob.getPlayerDeck());
		assertNotNull(sue.getPlayerDeck());
		game.playGame();
		assertTrue(game.checkScores().equals("bob wins the game!"));
		
	}
	
	@Test
	public void testVariation2TieGame(){
		System.out.println("VAR2TIE");

		Deck riggedDeck = new Deck();
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.CLUBS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.HEARTS));
		
		Variation2 game = new Variation2(players, riggedDeck);
		game.dealCardsToPlayers();
		game.playGame();
		assertTrue(game.checkScores().equals("Tie game!"));
	}
	
	@Test
	public void testVariation3() {
		System.out.println("VAR3");
		players.add(jon);
		Variation3 game = new Variation3(players, testDeck);
		game.dealCardsToPlayers();
		assertNotNull(bob.getPlayerDeck());
		assertNotNull(sue.getPlayerDeck());
		game.playGame();
		assertTrue(game.checkScores().equals("sue wins the game!"));
		
	}
	
	@Test
	public void testVariation3TwoLosingTie(){
		System.out.println("VAR3LosingTie");

		Deck riggedDeck = new Deck();
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.CLUBS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.TWO,CardSuit.HEARTS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.TWO,CardSuit.SPADES));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.THREE,CardSuit.CLUBS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.THREE,CardSuit.HEARTS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.SPADES));
		players.add(jon);
		Variation3 game = new Variation3(players, riggedDeck);
		game.dealCardsToPlayers();
		game.playGame();
		assertTrue(game.checkScores().equals("Tie between bob & jon!"));
	}
	
	@Test
	public void testVariation3TwoWayTieGame(){
		System.out.println("VAR3TWOTIE");

		Deck riggedDeck = new Deck();
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.CLUBS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.TWO,CardSuit.HEARTS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.THREE,CardSuit.SPADES));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.TWO,CardSuit.CLUBS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.THREE,CardSuit.HEARTS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.SPADES));
		players.add(jon);
		Variation3 game = new Variation3(players, riggedDeck);
		game.dealCardsToPlayers();
		game.playGame();
		assertTrue(game.checkScores().equals("Tie between bob & jon!"));
	}
	
	@Test
	public void testVariation3ThreeWayTieGame(){
		System.out.println("VAR3 Three way Tie");

		Deck riggedDeck = new Deck();
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.CLUBS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.TWO,CardSuit.HEARTS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.THREE,CardSuit.SPADES));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.TWO,CardSuit.CLUBS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.THREE,CardSuit.HEARTS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.SPADES));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.TWO,CardSuit.CLUBS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.KING,CardSuit.HEARTS));
		riggedDeck.addCardToTopOfDeck(new Card(CardValue.THREE,CardSuit.SPADES));
		players.add(jon);
		Variation3 game = new Variation3(players, riggedDeck);
		game.dealCardsToPlayers();
		game.playGame();
		assertTrue(game.checkScores().equals("Three-way tie! Wtf!"));
	}
	
	@Test
	public void testShuffleDeck(){
		System.out.println("Shuffle test");
		
		ByteArrayOutputStream unShuffledOutput = new ByteArrayOutputStream();
	    PrintStream ps1 = new PrintStream(unShuffledOutput);
	    ByteArrayOutputStream ShuffledOutput = new ByteArrayOutputStream();
	    PrintStream ps2 = new PrintStream(ShuffledOutput);
	    
	    PrintStream systemOut = System.out;
	    System.setOut(ps1);
	    
	    testDeck.printAllDeck();
	    testDeck.shuffleDeck();
	    System.setOut(ps2);
	    testDeck.printAllDeck();
	    
	    System.out.flush();
	    System.setOut(systemOut);
	    
	    assertFalse(unShuffledOutput.toString().equals(ShuffledOutput.toString()));
	}

}
