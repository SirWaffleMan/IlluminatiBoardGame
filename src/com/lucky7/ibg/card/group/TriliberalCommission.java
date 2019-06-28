package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class TriliberalCommission extends GroupCard{
	public TriliberalCommission() {
		super("Triliberal Commission", 5, -1, 6, 3);
		addAlignment(Alignments.Straight); 
		addAlignment(Alignments.Liberal); 
		
		hasTopArrow = true;
		hasBottomArrow = true;

	}
}