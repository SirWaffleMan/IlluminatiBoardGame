package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class MoralMinority extends GroupCard{

	public MoralMinority() {
		super("Moral Minority", 2, -1, 1, 2);
		addAlignment(Alignments.Conservative);
		addAlignment(Alignments.Straight);
		addAlignment(Alignments.Fanatic);
		
		hasTopArrow = true;
	}
}
	