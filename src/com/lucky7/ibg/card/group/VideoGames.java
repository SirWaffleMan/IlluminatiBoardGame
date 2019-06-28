package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class VideoGames extends GroupCard{
	public VideoGames() {
		super("Video Games", 2, -1, 3, 7);
		addAlignment(Alignments.Media);
		
		hasTopArrow = true;
	}
}
