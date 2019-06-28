package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class CloneArrangers extends GroupCard{

	public CloneArrangers() {
		super("CloneArrangers", 6, 2, 6, 1);
		//+3 on any attempt to destroy any group
		
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Criminal);
		
		hasRightArrow = true;
		hasBottomArrow = true;
	}
}
