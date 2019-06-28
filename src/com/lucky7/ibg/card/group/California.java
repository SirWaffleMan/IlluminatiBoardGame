package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class California extends GroupCard{

	public California() {
		super("California", 5, 0, 4, 5);
		addAlignment(Alignments.Weird);
		addAlignment(Alignments.Liberal);
		addAlignment(Alignments.Peaceful);
		
		hasTopArrow = true;
		hasBottomArrow = true;
	}

}
