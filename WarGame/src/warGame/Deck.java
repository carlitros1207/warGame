package warGame;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

	/**
	 * Decks are now LinkedLists so we can add to and take
	 * from the top and bottom.
	 */

public class Deck {
	private LinkedList<Card> deck;
	
	
	public Deck() {
		deck = new LinkedList<Card>();
	}
	
	public void addCardToTopOfDeck(Card card) {
		deck.push(card);
	}
	
	public void addCardToBottomOfDeck(Card card) {
		deck.addLast(card);
	}
	
	public void populateDeck() {
		for(CardSuit suit : CardSuit.values()){
			for(CardValue val : CardValue.values()){
				addCardToTopOfDeck(new Card(val,suit));
			}
		}
	}
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public void printAllDeck() {
		Object[] vals = deck.toArray();
		for(Object obj : vals) {
				System.out.println(obj);
		}
	}
	public Card getCard(){
		if(deck.isEmpty() == true) {
			return null;
		}else
			return deck.peek();
	}
	public Card removeCard() {
		if(deck.isEmpty() == true) {
			return null;
		}else
			return deck.pop();
	}
	public LinkedList<Card> getDeck() {
		return deck;
	}
}
