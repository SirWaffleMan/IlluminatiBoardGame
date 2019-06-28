package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class OnlineVideos extends GroupCard{

	public OnlineVideos() {
		super("Online Videos", 3, -1, 3, 4);
		addAlignment(Alignments.Media);
		
		hasTopArrow = true;
		hasRightArrow = true;
	}
}
	
