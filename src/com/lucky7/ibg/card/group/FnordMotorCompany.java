package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class FnordMotorCompany extends GroupCard{

	public FnordMotorCompany() {
		super("Fnord Motor Company", 2, -1, 4, 2);
		addAlignment(Alignments.Peaceful);
		
		hasRightArrow = true;
	}
	
}
