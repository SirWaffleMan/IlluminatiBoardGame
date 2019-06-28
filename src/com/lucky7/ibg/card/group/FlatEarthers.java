package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class FlatEarthers extends GroupCard{

	public FlatEarthers() {
		super("Flat Earthers", 1, -1, 2, 1);
		addAlignment(Alignments.Weird);
		addAlignment(Alignments.Conservative);
		
		hasRightArrow = true;
	}
	
}