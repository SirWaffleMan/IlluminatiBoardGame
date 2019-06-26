package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class TheMafia extends GroupCard{
	public TheMafia() {
		super("The Mafia", 7, -1, 7, 6);
		addAlignment(Alignments.Violent); 
		addAlignment(Alignments.Criminal); 

	}
}