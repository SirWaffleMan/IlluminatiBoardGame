package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class ComicBookMovies extends GroupCard{

	public ComicBookMovies() {
		super("Comic Book Movies", 1, 0, 1, 2);
		addAlignment(Alignments.Weird);
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Media);
	}

}
