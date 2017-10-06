package warGame;

public class Card extends Deck{
	private CardValue value;
	private CardSuit suit;
	
	public Card(CardValue val, CardSuit suit) {
		setValue(val);
		setSuit(suit);
	}

	@Override
	public String toString() {

        StringBuilder displayCard = new StringBuilder();

        displayCard.append(value); 
        
        displayCard.append(" OF "); 

        displayCard.append(suit);
        
        return displayCard.toString();
	}


	public void setValue(CardValue value) {
		this.value = value;
	}
	
	public CardValue getCardValue() {
		return value;
	}

	public CardSuit getCardSuit() {
		return suit;
	}

	public void setSuit(CardSuit suit) {
		this.suit = suit;
	}
}
