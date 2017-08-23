/*
 * @author	Quan Q. Phan
 * @date	08/08/2017
 * @since	1.0
 */

package main;

public class Application {

	public static void main (String[] args){
		
		Game game = new Game(1);
		Role dealer = game.getDealer();
		
		// TODO
		// need to have a more generic way to get players
		// for now, assume only one player versus the dealer
		Role player1 = game.getPlayersList().get(0);
		
		while(!game.needReshuffle()){ // one round per loop
			
			// one card face up to player1
			// one card face up to dealer
			// one card face up to player1
			// one card face down to dealer
			
			Card card = game.dealOneCard();
			
			player1.initializeOneHand();
			
			Hand p1Hand = player1.getHand();
			
			// player1 get FIRST card
			p1Hand.receiveCard(card);
			
			card = game.dealOneCard();

			dealer.initializeOneHand();
			
			Hand dealerHand = dealer.getHand();
			
			// dealer get FIRST card
			dealerHand.receiveCard(card);
			
			card = game.dealOneCard();

			// player1 get SECOND card
			p1Hand.receiveCard(card);
						
			card = game.dealOneCard();
			
			// dealer get SECOND card
			dealerHand.receiveCard(card);
			
			// player1 show all cards FACE UP
			p1Hand.showCardFaceUp();
			
			// dealer show ONE card FACE UP, ONE card FACE DOWN
			dealerHand.showCardFaceUpFaceDown();
			
			// check Dealer Hand if it has a natural
			if(dealerHand.needCheckNatural()){ // have natural
				
				// TODO
				// ask player to buy insurance
			
				if(game.buyInsurance()){ // if player buy insurance
					
					
				} else() { // if player not buy insurance
					
					
				}
				
				
				
				// TODO
				// if dealer has blackjack
					// if player has blackjack
						// tie game, Dealer: T
						// tie game, Player: T
					// if player not have blackjack
						// Dealer: W
						// Player: L
				// start new round
				
				
				
				
			} 
			
			
			
			
			
			
		}
	}
}
