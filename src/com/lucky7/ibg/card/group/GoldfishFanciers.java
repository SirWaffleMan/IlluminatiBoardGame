package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class GoldfishFanciers extends GroupCard{

	public GoldfishFanciers() {
		super("Goldfish Fanciers", -1, -1, 4, 1);
		addAlignment(Alignments.Peaceful);
		addAlignment(Alignments.Fanatic);
	}
	
}