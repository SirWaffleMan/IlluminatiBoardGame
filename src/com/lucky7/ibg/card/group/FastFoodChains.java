package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class FastFoodChains extends GroupCard{

	public FastFoodChains() {
		super("Fast Food Chains", 2, 0, 4, 3);
		addAlignment(Alignments.Straight);
		
		hasBottomArrow = true;
	}

}
