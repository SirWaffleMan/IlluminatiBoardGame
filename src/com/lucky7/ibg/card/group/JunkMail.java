package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class JunkMail extends GroupCard{

	public JunkMail() {
		super("Junk Mail", 1, -1, 3, 2);
		addAlignment(Alignments.Criminal);
		addAlignment(Alignments.Peaceful);
		addAlignment(Alignments.Media);
		
		hasBottomArrow = true;
	}
	
}