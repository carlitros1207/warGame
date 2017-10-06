package warGame;

public enum CardSuit {
	HEARTS(0),SPADES(1),DIAMONDS(2),CLUBS(3);
	
	private int value;
	
	CardSuit(int value){
		setValue(value);
	}

	public void setValue(int value) {
		this.value = value;
	}
	public int getValue(){
		return this.value;
	}
}
