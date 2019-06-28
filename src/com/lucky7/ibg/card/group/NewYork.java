package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class NewYork extends GroupCard{

	public NewYork() {
		super("New York", 7, -1, 8, 3);
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Criminal);
		
		hasTopArrow = true;
		hasRightArrow = true;
		hasBottomArrow = true;
	}
}
	