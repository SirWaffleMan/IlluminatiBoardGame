package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class BigMedia extends GroupCard{
	public BigMedia() {
		super("BigMedia", 4, 3, 6, 3);
		//An extra +2 on any attempt to control a media group
		
		addAlignment(Alignments.Straight);
		addAlignment(Alignments.Liberal);
		addAlignment(Alignments.Media);
		
		hasTopArrow = true;
		hasRightArrow = true;
		hasBottomArrow = true;
	}
}
