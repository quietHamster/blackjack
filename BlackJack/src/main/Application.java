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
		
		while(!game.needReshuffle()){
			
			// one card face up to player1
			// one card face up to dealer
			// one card face up to player1
			// one card face down to dealer
			
			Card card = game.dealOneCard();
			
			player1.
			
			
			
		}
	}
}
