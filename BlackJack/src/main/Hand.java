/*
 * @author	Quan Q. Phan
 * @date	05/25/2017
 * @since	1.0
 */

package main;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> cardList = new ArrayList<Card>();
	private boolean isBusted = false;
	private boolean isDealer = false;
	private int value = 0;
	private boolean hasBlackJack = false;
	
	/*
	 * Constructor.
	 * @param	String role
	 * @logic	determine if the hand is Dealer Hand or Player hand
	 * 			because the counting mechanism is different
	 */
	public Hand(String role){
		
		if(role.equalsIgnoreCase("DEALER")){
			
			this.isDealer = true;
		}
	}
	
	/*
	 * Add a card into a hand
	 * Update the value of the hand
	 * Set isBusted value (TRUE/FALSE) depend on the hand value
     * @param	Card card:	one card object
     * @impact	File image:	image associated to a card
     * 			int value:	value of the hand
     */
	public void receiveCard(Card card){
		
		card.setOrderInHand(this.cardList.size()+1);
		
		this.cardList.add(card);
		
		this.value = 0; // reset the value before increment
		
		for(Card c : this.cardList){
			
			this.value += c.getValue();
			
		}
		
		if(this.isDealer){ // Dealer Hand
			
			
			// TODO 
			
		} else { // Player Hand
			
			
			if(card.getOrderInHand() == 2 &&  // the second card in hand
					this.value == 21){
				
				this.hasBlackJack = true;
				
			} 
			
			// check for SOFT Ace
			
			if(this.hasAtLeastOneAce()){ 
				
				if(this.value > 21){
					
					this.value -= (10 * this.countNumAces());
					
				}
				
			}
			
		}
		
		

		

		
		// check if the hand is busted
		
		if(this.value > 21){
			
			this.isBusted = true;
			
		}
		
	}
	
	/*
	 * Count number of Ace(s) in the hand
     * @return	int numAces
     */
	private int countNumAces(){
		
		if(!this.hasAtLeastOneAce()){
			
			return 0;
			
		}
		
		int numAces = 0;
		
		for(Card card : this.cardList){
			
			if(card.getRank().equalsIgnoreCase("A")){
				
				
				numAces++;
				
			}
			
		}
		
		return numAces;
		
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
	 * Get value if the hand has BlackJack or not
     * @return	boolean hasBlackJack
     */
	public boolean isBlackJack(){
		
		return this.hasBlackJack;
		
	}
	
	/*
	 * Check if the hand is Dealer's hand
     * @return	boolean isDealer:	TRUE/FALSE
     */
	public boolean isDealer(){
		
		return this.isDealer;
		
	}
	
	/*
	 * Check if the hand has at least one Ace card or not 
     * @return	boolean	TRUE/FALSE
     */
	public boolean hasAtLeastOneAce(){
		
		for(Card c : this.cardList){
			
			if(c.getRank().equalsIgnoreCase("A")){
				
				return true;
				
			}
		}
		
		return false;
		
	}
	
	/*
	 * Check if the hand is splittable
     * @return	boolean	TRUE/FALSE
     */
	public boolean isSpittable(){
		
		if(this.cardList.size() == 2 &&
		   this.cardList.get(0).getRank().equalsIgnoreCase(this.cardList.get(1).getRank())){
			
			return true;
			
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
