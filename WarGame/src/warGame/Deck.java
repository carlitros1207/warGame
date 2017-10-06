package warGame;

import java.util.Collections;
import java.util.Stack;

public class Deck {
	private Stack<Card> deck;
	
	
	public Deck() {
		deck = new Stack<Card>();
	}
	
	public void addCardToDeck(CardValue val, CardSuit suit) {
		Card card = new Card(val,suit);
		deck.push(card);
	}
	
	public void populateDeck() {
		for(CardSuit suit : CardSuit.values()){
			for(CardValue val : CardValue.values()){
				addCardToDeck(val,suit);
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
	public void getCard(){
		if(deck.empty() == true) {
			System.out.println("Deck is empty");
		}else
			System.out.println(deck.pop().toString());
	}
}
