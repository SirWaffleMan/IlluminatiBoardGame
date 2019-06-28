package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class Hackers extends GroupCard{

	public Hackers() {
		super("Hackers", 2, 2, 4, 2);
		addAlignment(Alignments.Weird);
		addAlignment(Alignments.Criminal);
		
		hasBottomArrow = true;
	}
	
}