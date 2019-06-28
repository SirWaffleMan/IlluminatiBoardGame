package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class TheUnitedNations extends GroupCard{
	public TheUnitedNations() {
		super("The United Nations", 1, -1, 3, 3);
		addAlignment(Alignments.Liberal); 
		addAlignment(Alignments.Peaceful); 

		hasBottomArrow = true;
	}
}