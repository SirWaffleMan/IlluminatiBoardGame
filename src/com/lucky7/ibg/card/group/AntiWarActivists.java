package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class AntiWarActivists extends GroupCard{

	public AntiWarActivists() {
		super("Anti-War Activists", -1, -1, 3, 1);
		
		addAlignment(Alignments.Liberal);
		addAlignment(Alignments.Peaceful);
	}

}