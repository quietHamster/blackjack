/*
 * @author	Quan Q. Phan
 * @date	07/26/2017
 * @since	1.0
 */

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Card;
import main.Hand;

public class TestHand {

	@Test
	public void busted_Player() {
		
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
	public void notBusted_Player() {
		
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
		// expected the return is FALSE
		assertFalse(hand.isBusted()); 
		
	}
	
	@Test
	public void hasAtLeastOneAce_Player() {
		
		Hand hand = new Hand("Player");
		
		Card c1 = new Card("10","D");
		Card c2 = new Card("A","S");
		Card c3 = new Card("7","H");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		hand.receiveCard(c3);
		
		// this hand has ONE Ace
		// expected the return is TRUE
		assertTrue(hand.hasAtLeastOneAce()); 
		
	}
	
	@Test
	public void hasMoreThanOneAce_Player() {
		
		Hand hand = new Hand("Player");
		
		Card c1 = new Card("10","D");
		Card c2 = new Card("A","S");
		Card c3 = new Card("A","H");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		hand.receiveCard(c3);
		
		// this hand has ONE Ace
		// expected the return is TRUE
		assertTrue(hand.hasAtLeastOneAce()); 
		
	}
	
	@Test
	public void isSplittable_Player() {
		
		Hand hand = new Hand("Player");
		
		Card c1 = new Card("10","D");
		Card c2 = new Card("10","S");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		
		// this hand is splittable
		// expected the return is TRUE
		assertTrue(hand.isSpittable()); 
		
	}
	
	@Test
	public void isNotSplittable_Player() {
		
		Hand hand = new Hand("Player");
		
		Card c1 = new Card("10","D");
		Card c2 = new Card("10","S");
		Card c3 = new Card("10","C");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		hand.receiveCard(c3);
		
		// this hand is NOT splittable
		// expected the return is FALSE
		assertFalse(hand.isSpittable()); 
		
	}
	
	@Test
	public void hasNoAce_Player() {
		
		Hand hand = new Hand("Player");
		
		Card c1 = new Card("6","S");
		Card c2 = new Card("3","S");
		Card c3 = new Card("K","S");
		Card c4 = new Card("J","C");
		Card c5 = new Card("J","S");
		
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		hand.receiveCard(c3);
		hand.receiveCard(c4);
		hand.receiveCard(c5);
		
		// this hand has NO Ace
		// expected the return is FALSE
		assertFalse(hand.hasAtLeastOneAce()); 
		
	}
	
	@Test
	public void blackjack_Player() {
		
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
	public void noBlackjack_Player() {
		
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

	@Test
	public void needCheckNaturalFirstCardNotAce_Dealer() {
		
		Hand hand = new Hand("Dealer");
		
		Card c1 = new Card("10","S");
		Card c2 = new Card("3","H");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		
		// this hand need to check natural
		// expected the return is TRUE
		assertTrue(hand.needCheckNatural()); 
		
	}
	
	@Test
	public void needCheckNaturalFirstCardAce_Dealer() {
		
		Hand hand = new Hand("Dealer");
		
		Card c1 = new Card("A","S");
		Card c2 = new Card("3","H");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		
		// this hand need to check natural
		// expected the return is TRUE
		assertTrue(hand.needCheckNatural()); 
		
	}
	
	@Test
	public void noNeedCheckNatural_Dealer() {
		
		Hand hand = new Hand("Dealer");
		
		Card c1 = new Card("8","S");
		Card c2 = new Card("A","H");
		
		hand.receiveCard(c1);
		hand.receiveCard(c2);
		
		// this hand does NOT need to check natural
		// expected the return is FALSE
		assertFalse(hand.needCheckNatural()); 
		
	}

}
