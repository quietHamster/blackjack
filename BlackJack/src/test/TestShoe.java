/*
 * @author	Quan Q. Phan
 * @date	08/04/2017
 * @since	1.0
 */

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Card;
import main.Hand;
import main.Shoe;

public class TestShoe {

	@Test
	public void insertCutCard() {
		
		Shoe shoe = new Shoe(8);
		
		boolean hasCutCard =false;
		
		while(!hasCutCard){
			
			Card card = shoe.getTopCard();
			
			if(card.getRank().equalsIgnoreCase("CUT")){
				
				hasCutCard = true;
				
			}
		}
		
		// this has CUT Card
		// expected the return is TRUE
		assertTrue(hasCutCard); 
		
	}

}
