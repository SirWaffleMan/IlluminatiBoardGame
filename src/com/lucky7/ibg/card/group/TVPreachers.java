package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class TVPreachers extends GroupCard{
	public TVPreachers() {
		super("TV Preachers", 3, -1, 6, 4);
		addAlignment(Alignments.Straight); 
		addAlignment(Alignments.Fanatic); 
		addAlignment(Alignments.Media); 
	}
}