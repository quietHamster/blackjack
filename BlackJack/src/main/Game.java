/*
 * @author	Quan Q. Phan
 * @date	08/08/2017
 * @since	1.0
 */

package main;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private ArrayList<Role> playersList = new ArrayList<Role>();
	private boolean isCompleted = false;
	private Shoe shoe = null;
	private Role dealer = null;
	
	public Game(int _numPlayers){
		
		this.shoe = new Shoe(8);

		for(int p = 0; p < _numPlayers; p++){
			
			Role player = new Role("Player_".concat(Integer.toString(p)),1000);
			
			playersList.add(player);
			
		}
		
		this.dealer = new Role();
		
	}

	/*
	 * Check if need to re-shuffle the whole shoe
	 * because the CUT card was reached
     * @return	boolean	isCompleted	TRUE/FALSE
     */
	public boolean needReshuffle(){
		
		return this.isCompleted;
		
	}
	
	/*
	 * Deal one card
	 * If it is the CUT card, set the isCompleted = TRUE
     * @return	Card card
     */
	public Card dealOneCard(){
		
		Card card = this.shoe.getTopCard();
		
		if(card.getRank().equalsIgnoreCase("CUT")){
			
			this.isCompleted = true;
			
		}
		
		return card;
	}
	
	/*
	 * Get dealer object
     * @return	Role dealer
     */
	public Role getDealer(){
		
		return this.dealer;
	}
	
	/*
	 * Get dealer object
     * @return	Role dealer
     */
	public ArrayList<Role> getPlayersList(){
		
		return this.playersList;
		
	}
	
	public boolean buyInsurance(){
		
		System.out.println("Do you want to buy insurance? (Y/N):\t");
		
		Scanner scanner = new Scanner(System.in);
		
		String choice = scanner.next();
		
		while(!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N")){
			
			System.out.println("Do you want to buy insurance? (Y/N):\t");
			choice = scanner.next();
			
		}
		
		scanner.close();
		
		if(choice.equalsIgnoreCase("Y")){
			
			return true;
			
		}
		
		return false;
	
	}
	
}
