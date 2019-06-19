package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class Airlines extends GroupCard{
	public Airlines() {
		super("Airlines", 1, -1, 3, 1);
		addAlignment(Alignments.Straight); 
	}
}