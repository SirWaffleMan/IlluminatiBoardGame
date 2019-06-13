package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class BoySprouts extends GroupCard{
	public BoySprouts() {
		super("BoySprouts", -1, -1, 3, 1);
		
		addAlignment(Alignments.Liberal);
		addAlignment(Alignments.Straight);
	}
}