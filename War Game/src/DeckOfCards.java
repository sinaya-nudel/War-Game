

import java.util.ArrayList;
import java.util.Collections;

/* Author: Sinaya Nudel 203191663
 * Date: 28/03/18
 */
public class DeckOfCards{ 
	private ArrayList<Card> deck;
	
	
	public DeckOfCards(boolean isE) { //true will cause a creation of object with empty arraylist. false- to full deck.
		deck = new ArrayList<Card>();
		if(isE==false){
			 String[] faces = { 
				   "DEUCE", "THREE", "FOUR", "FIVE", "SIX", "SEVEN",
				   "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE" 
				};
				
			 String[] suits = {
					   "DIAMONDS", 
					   "CLUBS", 
					   "HEARTS", 
					   "SPADES" 
					};
					
		     for (int i=0;i<faces.length;i++) {
		            for (int j=0;j<suits.length;j++) {
		            	deck.add(new Card(faces[i], suits[j]));
		            
		            }
		           
		        }
		     deck.add(new Card("JOKER", null));
		     deck.add(new Card("JOKER", null));
		     Collections.shuffle(deck);
		}
	 }
	protected Card getTop(){//get the top card from the deck and remove it from the deck
		if(!this.isEmptyDeck())
		     return deck.remove(0); 
		else
			return null;
	}
	protected boolean isEmptyDeck(){
		return this.deck.isEmpty();
	}
	
	protected void addCard(Card a){
		this.deck.add(a);
	}
	
	protected int howManyCards(){
		return this.deck.size();
	}
	

	
}

