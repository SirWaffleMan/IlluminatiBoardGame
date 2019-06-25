package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class BoySprouts extends GroupCard{
	public BoySprouts() {
		super("Boy Sprouts", -1, -1, 3, 1);
		
		addAlignment(Alignments.Straight);
		addAlignment(Alignments.Peaceful);
	}
}