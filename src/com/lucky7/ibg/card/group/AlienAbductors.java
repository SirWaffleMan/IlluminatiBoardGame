package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class AlienAbductors extends GroupCard{

	public AlienAbductors() {
		super("Alien Abductors", 2, 0, 5, 1);
		addAlignment(Alignments.Weird);
		addAlignment(Alignments.Criminal);
		
		hasBottomArrow = true;
	}
	
}
