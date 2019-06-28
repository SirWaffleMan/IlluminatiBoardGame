package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class UndergroundMedia extends GroupCard{
	public UndergroundMedia() {
		super("Underground Media", 1, 1, 5, 0);
		addAlignment(Alignments.Liberal); 
		addAlignment(Alignments.Media); 

		hasBottomArrow = true;
	}
}