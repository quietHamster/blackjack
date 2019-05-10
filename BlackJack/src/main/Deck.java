/*
 * @author	Quan Q. Phan
 * @date	05/25/2017
 * @since	1.0
 */

package main;

import java.util.ArrayList;

public class Deck {

	private String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private String[] suits = {"H","D","C","S"};
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	/*
	 * Constructor.
	 * Loop through the two arrays to initialize 52 cards in a deck
	 */
	public Deck(){
		
		for(int rank = 0; rank < ranks.length; rank++){
			
			for(int suit = 0; suit < suits.length; suit++){
				
				Card aCard = new Card(ranks[rank],suits[suit]);
				deck.add(aCard);
			}
		}
	}
	
	/* 
	 * Get a deck of card
	 * @return ArrayList<Card>:	52 cards
	 * @see	./Card.java
	 */
	public ArrayList<Card> getDeck(){
		return this.deck;
	}
	
	/*
	 * Show all cards in a deck
	 * This method is for Testing purpose
     */
	public void showAllCardsFaceUp(){
		
		for(int card = 0; card < this.deck.size(); card++){
			
			System.out.print(" ".concat(this.deck.get(card).getRank().concat(
					this.deck.get(card).getSuit())));
			
			if((card + 1) % 13 == 0){
				System.out.println("");
			}
		}
	}
}
