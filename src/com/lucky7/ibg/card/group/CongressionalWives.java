package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class CongressionalWives extends GroupCard{

	public CongressionalWives() {
		super("Congressional Wives", 1, 0, 4, 1);
		addAlignment(Alignments.Straight);
		addAlignment(Alignments.Conservative);
		
		hasRightArrow = true;
	}

}
