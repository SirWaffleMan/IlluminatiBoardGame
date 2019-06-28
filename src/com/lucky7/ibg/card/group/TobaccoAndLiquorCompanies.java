package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class TobaccoAndLiquorCompanies extends GroupCard{
	public TobaccoAndLiquorCompanies() {
		super("Tobacco & Liquor Companies", 4, -1, 3, 3);
		addAlignment(Alignments.Straight);

		hasRightArrow = true;
		hasBottomArrow = true;
	}
}