/*
 * @author	Quan Q. Phan
 * @date	05/26/2017
 * @since	1.0
 */

package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Shoe {

	private ArrayList<Card> cardList = new ArrayList<Card>();
	private int numDeck = 0;
	
	public Shoe(int n){
		this.numDeck = n;
		this.initialize();
		this.shuffle();
		this.insertCutCard();
	}
	
	/*
	 * Initialize cards in a shoe
	 * @impact	this.cardList
     */
	private void initialize(){
		
		Deck deck = new Deck();
		
		for(int num = 1; num <= numDeck; num++){
			
			this.cardList.addAll(deck.getDeck());
		}
	}
	
	/*
	 * Show all cards in a shoe
	 * This method is for Testing purpose
     */
	public void showAllCardsFaceUp(){
		
		for(int card = 0; card < this.cardList.size(); card++){
			
			System.out.print(" ".concat(this.cardList.get(card).getRank().concat(
					this.cardList.get(card).getSuit())));
			
			if((card + 1) % 13 == 0){
				System.out.println("");
			}
		}
	}
	
	/*
	 * Shuffle all cards in a shoe
	 * @impact	this.cardList	All cards are shuffled
     */
	private void shuffle(){

		Random rand = new Random();
		int min = 1;
		int max = this.cardList.size();
		ArrayList<Integer> rndVals = new ArrayList<Integer>();
		
		// fill the rndVals array list with randomized elements
		while(rndVals.size() < max){
			
			// nextInt is normally exclusive of the top value,
		    // so add 1 to make it inclusive
		    int randomNum = rand.nextInt((max - min) + 1) + min;
		    
		    if(rndVals.indexOf(randomNum) == -1){
		    	
		    	rndVals.add(randomNum);
		    }
		}
		
		ArrayList<Card> shuffledList = new ArrayList<Card>();
		
		// for each element in the rndVals array list
		// match it with element in the original this.cardList
		for(int rdvl = 0; rdvl < rndVals.size(); rdvl++){
			
			shuffledList.add(this.cardList.get(rndVals.get(rdvl) - 1));
			
		}
		
		// swap the original list to the shuffled list
		this.cardList.clear();
		this.cardList.addAll(shuffledList);
		
	}
	
	/*
	 * Get shoe's cardList
	 * @return ArrayList<Card> this.cardList
	 */
	public ArrayList<Card> getShoe(){
		
		return this.cardList;
	}
	
	/*
	 * Get shoe's top card
	 * @return Card card
	 */
	public Card getTopCard(){
		
		Card card = this.cardList.get(0);
		this.cardList.remove(0);
		return card;
		
	}
	
	/*
	 * Insert a CUT card into the shoe's cardList
	 * @impact ArrayList<Card> this.cardList
	 * allowed position: from 75% to 90% the shoe from the first card
	 * e.i. with a shoe of 52 cards, the cut card need to be placed 
	 * at the position of 75% (39th card from the first card) 
	 * to 90% (46th card from the first card)
	 * card1 | card2 | ........ | card39 | ...cut card in this range...... | card48 | card49 | .... | card52
	 */
	private void insertCutCard(){
		
		ArrayList<Card> cutCardInsertedList = new ArrayList<Card>();
		Random rand = new Random();
		int min = (int) (this.cardList.size() * 0.75);
		int max = (int) (this.cardList.size() * 0.9);
		
		// nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
		int cutPosition = rand.nextInt((max - min) + 1) + min;
		
		for(int position = 0; position < cutPosition; position++){
			
			cutCardInsertedList.add(this.cardList.get(position));
		}
		
		Card cutCard = new Card("CUT","");
		cutCardInsertedList.add(cutCard);
		
		for(int position = cutPosition; position < this.cardList.size(); position++){
			
			cutCardInsertedList.add(this.cardList.get(position));
		}
		
		// swap the shuffled list to the shuffled list WITH the CUT card
		this.cardList.clear();
		this.cardList.addAll(cutCardInsertedList);
	}
	
}
