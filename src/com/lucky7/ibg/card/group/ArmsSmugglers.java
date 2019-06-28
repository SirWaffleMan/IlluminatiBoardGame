package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class ArmsSmugglers extends GroupCard{

	public ArmsSmugglers() {
		super("ArmsSmugglers", 2, -1, 6, 3);
		
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Criminal);
		
		hasRightArrow = true;
		hasBottomArrow = true;
	}

}