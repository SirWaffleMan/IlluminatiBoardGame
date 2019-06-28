package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class FiendishFluidators extends GroupCard{

	public FiendishFluidators() {
		super("Fiendish Fluidators", 3, -1, 5, 1);
		addAlignment(Alignments.Fanatic);
		
		hasTopArrow = true;
		hasRightArrow = true;
	}
	
}
