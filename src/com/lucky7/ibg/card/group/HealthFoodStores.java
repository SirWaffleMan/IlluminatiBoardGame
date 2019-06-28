package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class HealthFoodStores extends GroupCard{

	public HealthFoodStores() {
		super("Health Food Stores", 1, -1, 3, 2);
		addAlignment(Alignments.Liberal);
		
		hasBottomArrow = true;
	}
	
}