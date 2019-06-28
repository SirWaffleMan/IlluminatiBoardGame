package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class Hollywood extends GroupCard{

	public Hollywood() {
		super("Hollywood", 2, 1, 0, 5);
		addAlignment(Alignments.Liberal);
		addAlignment(Alignments.Media);
		
		hasRightArrow = true;
		hasBottomArrow = true;
	}
	
}