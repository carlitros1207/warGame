package warGame;

public class Card extends Deck{
	private CardValue value;
	private CardSuit suit;
	
	public Card(CardValue val, CardSuit suit) {
		setValue(val);
		setSuit(suit);
	}

	public void setSuit(CardSuit suit) {
		this.suit = suit;
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

}
