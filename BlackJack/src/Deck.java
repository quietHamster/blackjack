/*
 * @author	Quan Q. Phan
 * @date	5/25/2017
 * @since	1.0
 */

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
}
