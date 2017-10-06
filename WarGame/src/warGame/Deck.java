package warGame;

import java.util.Collections;
import java.util.Stack;

public class Deck {
	private Stack<Card> deck;
	
	
	public Deck() {
		deck = new Stack<Card>();
	}
	
	public void addCardToDeck(int val, int face) {
		Card card = new Card(val,face);
		deck.push(card);
	}
	
	public void populateDeck() {
		for(int i = 0; i< 4;i++) {
			for(int j = 1;j < 15;j++) {
				addCardToDeck(j,i);
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
