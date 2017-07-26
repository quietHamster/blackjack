/*
 * @author	Quan Q. Phan
 * @date	5/25/2017
 * @since	1.0
 */

package main;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> cardList = new ArrayList<Card>();
	private boolean isBusted = false;
	private boolean isDealer = false;
	private int value = 0;
	
	/*
	 * Constructor.
	 * @param	String actorName
	 * @logic	determine if the hand is Dealer Hand or Player hand
	 * 			because the counting mechanism is different
	 */
	public Hand(String actorName){
		
		if(actorName.equalsIgnoreCase("DEALER")){
			
			this.isDealer = true;
		}
	}
	
	/*
	 * Add a card into a hand
	 * Update the value of the hand
	 * Set isBusted value (TRUE/FALSE) depend on the hand value
     * @param	Card card:	one card object
     * @impact	File image:	image associated to a card
     */
	public void receiveCard(Card card){
		
		this.cardList.add(card);
		
		// set the hand value
		int sum = 0;
		
		if(!this.hasAce()){
			
			for(Card c : this.cardList){ // card order is not important here
				
				sum += c.getValue();
				
			}
			
		} else {
			
			for(int c = 0; c < this.cardList.size(); c++){ // card order is important here
				
				sum += this.cardList.get(c).getValue();
				
				if(this.cardList.get(c).getValue() == 1){
					
					if(sum > 21){ // set the SOFT/HARD Ace card
						
						sum -= 10;
						
					}
				}
			}
		}
		
		this.value = sum;
		
		// check if the hand is busted
		if(this.value > 21){
			
			this.isBusted = true;
			
		}
	}
	
	/*
	 * Check if the hand is isBusted or not
     * @return	boolean isBusted:	TRUE/FALSE
     */
	public boolean isBusted(){
		
		return this.isBusted;
		
	}
	
	/*
	 * Get value of the hand
     * @return	int value
     */
	public int getValue(){
		
		return this.value;
		
	}
	
	/*
	 * Check if the hand is Dealer's hand
     * @return	boolean isDealer:	TRUE/FALSE
     */
	public boolean isDealer(){
		
		return this.isDealer;
		
	}
	
	/*
	 * Check if the hand has Ace card or not 
     * @return	boolean	TRUE/FALSE
     */
	private boolean hasAce(){
		
		for(Card c : this.cardList){
			
			if(c.getValue() == 1){
				
				return true;
				
			}
		}
		
		return false;
		
	}
	
	/*
	 * Check if needed to run Natural Check on the hand 
     * @return	boolean	TRUE/FALSE
     */
	public boolean needCheckNatural(){
		
		if(this.cardList.get(0).getValue() == 10 || 
		   this.cardList.get(0).getValue() == 11){
			
			return true;
			
		}
		
		return false;
	}
	
	/*
	 * Check if the hand has blackack
     * @return	boolean	TRUE/FALSE
     */
	public boolean hasBlackJack(){
		
		if (this.value == 21){
			
			return true;
			
		}
		
		return false;
	}
	
	/*
	 * Reset the hand by clearing the hand's card list
     * @impact	cardList
     */
	public void resetHand(){
		
		this.cardList.clear();
		
	}
	
	/*
	 * Show all cards in hand faced up 
     */
	public void showCardFaceUp(){
		
		for(int card = 0; card < this.cardList.size(); card++){
			
			System.out.print(" ".concat(this.cardList.get(card).getRank().
								 concat(this.cardList.get(card).getSuit())));
			
		}
		
		System.out.println();
		
	}
	
	/*
	 * Show FIRST card faced up
	 * Show SECOND card faced down
     */
	public void showCardFaceUpFaceDown(){
		
		System.out.print(" ".concat(this.cardList.get(0).getRank().
				 concat(this.cardList.get(0).getSuit())));
		
		System.out.print(" [-]");
		
		System.out.println();
		
	}
}
