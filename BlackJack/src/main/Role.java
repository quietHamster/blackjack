/*
 * @author	Quan Q. Phan
 * @date	08/06/2017
 * @since	1.0
 */

package main;

import java.util.ArrayList;

public class Role {
	
	private String name = null;
	private ArrayList<Hand> handList = new ArrayList<Hand>();
	private double bank = 0.0;
	private Hand hand = null;
	
	public Role(){
		
		this.name = "Dealer";
		this.bank = 100000000; // 100M in Dealer bank
		
	}
	
	public Role(String _name, double _bank){
		
		this.name = _name;
		this.bank = _bank;
		
	}

	/*
	 * Get role bank amount
	 * @return double bank
	 */
	public double getBank(){
		
		return this.bank;
		
	}
	
	/*
	 * Get role name
	 * @return String name
	 */
	public String getName(){
		
		return this.name;
		
	}
	
	/*
	 * Add one hand to the role's hand list
	 * This method is for the history of the role
	 * @impact	ArrayList<Hand>	handList
	 */
	public void addHand(Hand hand){
		
		this.handList.add(hand);
		
	}
	
	/*
	 * Get role's hand list
	 * @return ArrayList<Hand> handList
	 */
	public ArrayList<Hand> getHandList(){
		
		return this.handList;
		
	}
	
	/*
	 * Initialize one hand
	 * @impact this.hand
	 */
	public void initializeOneHand(){
		
		this.hand = new Hand(this.name);
		
	}
}
