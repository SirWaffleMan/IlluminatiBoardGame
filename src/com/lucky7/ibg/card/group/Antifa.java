package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class Antifa extends GroupCard{

	public Antifa() {
		super("Antifa", 0, 1, 6, 1);
		//+2 on any attempt to destroy any group
		
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Criminal);
		addAlignment(Alignments.Fanatic);
	}

}
