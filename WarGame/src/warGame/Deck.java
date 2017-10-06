package warGame;

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
	public void getCard() {
		System.out.println("hello");
		System.out.println(deck.pop().toString());
	}
}
