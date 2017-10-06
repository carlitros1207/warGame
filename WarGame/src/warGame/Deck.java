package warGame;

import java.util.Collections;
import java.util.Stack;

public class Deck {
	private Stack<Card> deck;
	
	
	public Deck() {
		deck = new Stack<Card>();
	}
	
	public void addCardToDeck(Card card) {
		deck.push(card);
	}
	
	public void populateDeck() {
		for(CardSuit suit : CardSuit.values()){
			for(CardValue val : CardValue.values()){
				addCardToDeck(new Card(val,suit));
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
		if(deck.empty() == true) {
			return null;
		}else
			return deck.peek();
	}
	public Card removeCard() {
		if(deck.empty() == true) {
			return null;
		}else
			return deck.pop();
	}
	public Stack<Card> getDeck() {
		return deck;
	}
}
