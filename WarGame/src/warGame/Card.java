package warGame;

public class Card extends Deck{
	private int value;
	private int face;
	
	public Card(int val, int face) {
		setValue(val);
		setFace(face);
	}

	@Override
	public String toString() {

        //suing StringBuilder for modifiability later on
        StringBuilder displayCard = new StringBuilder();
        
        //personal choice to use switch
        switch(value){
            //since rank is int type, now match int 11 to String jack...14 to Ace
            case 11:
                displayCard.append("Jack");
                break;
            case 12:
                displayCard.append("Queen");
                break;
            case 13:
                displayCard.append("King");
                break;
            case 14:
                displayCard.append("Ace");
                break;    
            default:
                displayCard.append(value); //number from 2 to 10 does not need to modify
                break;
        }//end rank switch
        
        displayCard.append(" of "); //setting the format of the output
        
        switch(face){
            case 0:
                displayCard.append("Spades");
                break;
            case 1:
                displayCard.append("Hearts");
                break;
            case 2:
                displayCard.append("Clubs");
                break;
            case 3:
                displayCard.append("Diamonds");
                break;
            default: //anything else, do nothing
                break;
        }//end suit switch
        
        //return the result of an entire cmombined string
        return displayCard.toString();
	}


	public void setValue(int value) {
		this.value = value;
	}

	public void setFace(int face) {
		this.face = face;
	}

}
