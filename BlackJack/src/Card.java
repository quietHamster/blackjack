/*
 * @author	Quan Q. Phan
 * @date	5/25/2017
 * @since	1.0
 */

import java.io.File;

public class Card {

	private String rank = "";
	private String suit = "";
	private File image = null;
	private int value = 0;
	
	public Card(String r, String s){
		this.rank = r;
		this.suit = s;
		this.image = setImage(r,s);
		this.setValue();
	}
	
	/*
	 * Set the image (png type) associated to a card
     * @param	String r:	rank
     * @param	String s:	suit
     * @return	File image:	image associated to a card
     */
	private File setImage(String r, String s){
		
		String fileName = r.concat(s).concat("png");
		File image = new File(".//images//".concat(fileName));
		
		return image;
	}
	
	/* 
	 * Get card's rank
	 * @return String rank:	rank
	 */
	public String getRank(){
		
		return this.rank;
	}
	
	/* 
	 * Get card's suit
	 * @return String suit:	suit
	 */
	public String getSuit(){
		
		return this.suit;
	}
	
	/*
	 * Get card's image
	 * @return File image:	image
	 */
	public File getImage(){
		
		return this.image;
	}
	
	/*
	 * Set value to a card
	 * @impact	this.value
	 */
	private void setValue(){
		
		if(Character.isDigit(this.rank.charAt(0))){ // 2,3,4,...,10
			
			this.value = Integer.parseInt(this.rank);
			
		} else { // A,J,Q,K
			
			if(this.rank.equalsIgnoreCase("A")){
				
				this.value = 1;
				
			} else {
				
				this.value = 10;
				
			}
		}
	}
	
	/*
	 * Get card's value
	 * @return int value:	value
	 */
	public int getValue(){
		
		return this.value;
	}
}
