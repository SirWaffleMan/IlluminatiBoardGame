package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class Vloggers extends GroupCard{
	public Vloggers() {
		super("Vloggers", 0, 1, 5, 1);
		addAlignment(Alignments.Peaceful);
		addAlignment(Alignments.Media); 
	}
}