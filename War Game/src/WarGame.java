
import javax.swing.JOptionPane;
/* Author: Sinaya Nudel 203191663
 * Date: 28/03/18
 */
public class WarGame {
	private DeckOfCards _deckMain; //the starting deck of cards of the game.
	private DeckOfCards _deckA; // player A deck of cards
	private DeckOfCards _deckB;// player B deck of cards
	private String _nameA; //player A name
	private String _nameB; //player B name
	private final int WAR_CARDS_NUM = 3; //the number of cards each player puts in a war case
	
	public WarGame(){
		reset();
	}
	
	private void reset(){
		setNames();
		_deckMain = new DeckOfCards(false);
		_deckA = new DeckOfCards(true);
		_deckB = new DeckOfCards(true);
		while(!_deckMain.isEmptyDeck()){  //sharing the cards between the two players equally. 
			_deckA.addCard(_deckMain.getTop());
			_deckB.addCard(_deckMain.getTop());
		}//at this point of the game, each player started with 27 shuffled cards. the mainDeck is empty.
	}
	
	private void setNames(){
		_nameA = JOptionPane.showInputDialog(null,
				  "Enter a name for the first player:");
		_nameB = JOptionPane.showInputDialog(null,
				  "Enter a name for the second player:");
	}
	private void tryRound(){
		Card a = _deckA.getTop();
		Card b = _deckB.getTop();
		int isAwins = a.isBigger(b);//returns 1 if player A is the winner, -1 if B is the winner, or 0 if there is a draw for this round
		_deckMain.addCard(a); // putting the cards for this round in the main deck
		_deckMain.addCard(b);
		if(isAwins==1){
			JOptionPane.showMessageDialog(null, _nameA + " card: " + a.toString() + "\n" + _nameB + " card: " + b.toString() + "\n\n\n" + _nameA + " is the winner this round!\n\n\n", 
					"message",JOptionPane.INFORMATION_MESSAGE);
			cardsWinning(_deckA,_nameA);
		}
		if(isAwins==-1){
			JOptionPane.showMessageDialog(null, _nameA + " card: " + a.toString() + "\n" + _nameB + " card: " + b.toString() + "\n\n\n" + _nameB + " is the winner this round!\n\n\n", 
					"message",JOptionPane.INFORMATION_MESSAGE);
			cardsWinning(_deckB,_nameB);
		}
		if(isAwins==0){
			JOptionPane.showMessageDialog(null, _nameA + " card: " + a.toString() + "\n" + _nameB + " card: " + b.toString() + "\n\n\nIt's a WAR!\n\n\n", 
					"message",JOptionPane.INFORMATION_MESSAGE);
			warCase();
		}
	}
	private void cardsWinning(DeckOfCards d, String winner){ //giving the winner the cards from the main deck and introducing a list of them
		String temp = "";
		while(!_deckMain.isEmptyDeck()){
			Card t = _deckMain.getTop();
			temp+="\n"+t.toString();
			d.addCard(t);
			
		}
		JOptionPane.showMessageDialog(null, winner + " gets the cards: "+ temp +"\n\n"+ _nameA + " has " + _deckA.howManyCards() + " cards.\n" + _nameB + " has " + _deckB.howManyCards() + " cards.\n", 
					"message",JOptionPane.INFORMATION_MESSAGE);
	}
	private void warCase(){
		for(int i=1;!_deckA.isEmptyDeck()&&!_deckB.isEmptyDeck()&&i<WAR_CARDS_NUM;i++){ // in a war case, the top cards are chosen but only the last is playing. this method only responsible for the "un-played" cards
			Card a = _deckA.getTop();
			Card b = _deckB.getTop();
			JOptionPane.showMessageDialog(null,"Put " + i, 
					"message",JOptionPane.INFORMATION_MESSAGE);
			_deckMain.addCard(a);
			_deckMain.addCard(b);
		}
	}
	public void play(){
		
		while(!_deckA.isEmptyDeck()&&!_deckB.isEmptyDeck()){
			
			JOptionPane.showMessageDialog(null,"Play!", 
					"message",JOptionPane.INFORMATION_MESSAGE);
			
			tryRound();
			
		}
		if(_deckA.isEmptyDeck()&&_deckB.isEmptyDeck()) // in a case that the two players is ran out of cards. very rare situation. can happen if there is a long sequence of war case and all the cards is moving to the main deck.
			JOptionPane.showMessageDialog(null, "IT'S A DROW!\n\nGAME OVER\n\n" , 
					"message",JOptionPane.INFORMATION_MESSAGE);
		else if(_deckA.isEmptyDeck()) //player A ran out of cards and B is the winner
			JOptionPane.showMessageDialog(null,_nameB + " IS THE WINNER!\n\nGAME OVER\n\n" , 
					"message",JOptionPane.INFORMATION_MESSAGE);
		else if(_deckB.isEmptyDeck()) //player B ran out of cards and A is the winner
			JOptionPane.showMessageDialog(null,_nameA + " IS THE WINNER!\n\nGAME OVER\n\n" , 
					"message",JOptionPane.INFORMATION_MESSAGE);
		int reply = JOptionPane.showConfirmDialog(null, //A message - asking if the user wants to start a new game
			    "Do you want to start a new game?", "message",
			    JOptionPane.YES_NO_OPTION);
		
		if(reply == JOptionPane.YES_OPTION){
			reset();
			play(); //recursion that stops only if the user choose not to start a new game
		} 
	
	}
}
