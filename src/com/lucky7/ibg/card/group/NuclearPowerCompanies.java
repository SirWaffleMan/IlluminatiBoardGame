package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class NuclearPowerCompanies extends GroupCard{

	public NuclearPowerCompanies() {
		super("Nuclear Power Companies", 4, -1, 4, 3);
		addAlignment(Alignments.Conservative);
		
		hasRightArrow = true;
	}
}
