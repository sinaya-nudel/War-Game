
/* Author: Sinaya Nudel 203191663
 * Date: 28/03/18
 */
public class Card{
	private final String face;
	private final String suit;
	
	public Card(String cardFace, String cardSuit){
		this.face = cardFace;
		this.suit = cardSuit;
	}
	
	public String toString(){
		if(this.face!="JOKER")
			return face + " of " + suit;
		return "JOKER";
				
	}

	private int getValue(){ 
		if(this.face=="DEUCE")
			return 1;
		if(this.face=="THREE")
			return 2;
		if(this.face=="FOUR")
			return 3;
		if(this.face=="FIVE")
			return 4;
		if(this.face=="SIX")
			return 5;
		if(this.face=="SEVEN")
			return 6;
		if(this.face=="EIGHT")
			return 7;
		if(this.face=="NINE")
			return 8;
		if(this.face=="TEN")
			return 9;
		if(this.face=="JACK")
			return 10;
		if(this.face=="QUEEN")
			return 11;
		if(this.face=="KING")
			return 12;
		if(this.face== "ACE" )
			return 13;
		if(this.face== "JOKER" )
			return 14;
		return 0;
		
	}

	protected int isBigger(Card other){
		if(this.getValue()>other.getValue())
			return 1;
		if(this.getValue()<other.getValue())
			return -1;
		return 0; //if equals
	}
}
