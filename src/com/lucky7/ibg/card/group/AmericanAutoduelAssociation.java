package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class AmericanAutoduelAssociation extends GroupCard{

	public AmericanAutoduelAssociation() {
		super("American Autoduel Association", 1, 0, 5, 1);
		
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Weird);
		
		hasRightArrow = true;
	}

}
