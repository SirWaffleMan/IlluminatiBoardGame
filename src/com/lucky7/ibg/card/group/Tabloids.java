package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class Tabloids extends GroupCard{

	public Tabloids() {
		super("Tabloids", 2, -1, 3, 3);
		addAlignment(Alignments.Weird);
		addAlignment(Alignments.Media);
		
		hasBottomArrow = true;
	}
}
	
