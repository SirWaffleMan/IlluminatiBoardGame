package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class ChainLetters extends GroupCard{

	public ChainLetters() {
		super("Chain Letters", 0, 1, 1, 3);
		addAlignment(Alignments.Conservative);
		addAlignment(Alignments.Criminal);
		addAlignment(Alignments.Media);
	}

}
