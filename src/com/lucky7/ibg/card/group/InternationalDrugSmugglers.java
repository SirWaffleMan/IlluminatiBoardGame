package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class InternationalDrugSmugglers extends GroupCard{

	public InternationalDrugSmugglers() {
		super("International Drugs Smugglers", 3, -1, 5, 5);
		addAlignment(Alignments.Criminal);
		
		hasTopArrow = true;
		hasRightArrow = true;
		hasBottomArrow = true;
	}
	
}