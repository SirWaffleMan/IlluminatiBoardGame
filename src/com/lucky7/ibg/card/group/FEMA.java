package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class FEMA extends GroupCard{

	public FEMA() {
		super("FEMA", 4, 3, 4, 3);
		addAlignment(Alignments.Peaceful);
		
		hasTopArrow = true;
		hasRightArrow = true;
		hasBottomArrow = true;
	}
	
}
