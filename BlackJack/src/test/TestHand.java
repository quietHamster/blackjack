/*
 * @author	Quan Q. Phan
 * @date	7/26/2017
 * @since	1.0
 */

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Card;
import main.Hand;

public class TestHand {

	@Test
	public void bustedHandPlayer() {
		
		Hand hand = new Hand("Player");
		
		Card c1 = new Card("10","S");
		Card c2 = new Card("3","H");
		Card c3 = new Card("K","D");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		hand.receiveCard(c3);
		
		// this hand is BUSTED
		// expected the return is TRUE
		assertTrue(hand.isBusted()); 
		
	}
	
	@Test
	public void notBustedHandPlayer() {
		
		Hand hand = new Hand("Player");
		
		Card c1 = new Card("A","S");
		Card c2 = new Card("A","H");
		Card c3 = new Card("10","D");
		Card c4 = new Card("5","C");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		hand.receiveCard(c3);
		hand.receiveCard(c4);
		
		// this hand is NOT BUSTED
		// expected the return is TRUE
		assertFalse(hand.isBusted()); 
		
	}
	
	@Test
	public void hasAtLeastOneAceHandPlayer() {
		
		Hand hand = new Hand("Player");
		
		Card c1 = new Card("A","S");
		
		hand.receiveCard(c1);
		
		// this hand has ONE Ace
		// expected the return is TRUE
		assertTrue(hand.hasAtLeastOneAce()); 
		
	}
	
	@Test
	public void blackjackHandPlayer() {
		
		Hand hand = new Hand("Player");
		
		Card c1 = new Card("10","S");
		Card c2 = new Card("A","H");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		
		// this hand is blackjack
		// expected the return is TRUE
		assertTrue(hand.isBlackJack()); 
		
	}
	
	@Test
	public void noBlackjackHandPlayer() {
		
		Hand hand = new Hand("Player");
		
		Card c1 = new Card("8","S");
		Card c2 = new Card("3","H");
		Card c3 = new Card("K","C");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		hand.receiveCard(c3);
		
		// this hand is NOT blackjack
		// expected the return is FALSE
		assertFalse(hand.isBlackJack()); 
		
	}

	

}
