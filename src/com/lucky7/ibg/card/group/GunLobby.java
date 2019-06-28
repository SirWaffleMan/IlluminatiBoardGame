package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class GunLobby extends GroupCard{

	public GunLobby() {
		super("Gun Lobby", 2, -1, 3, 1);
		addAlignment(Alignments.Conservative);
		addAlignment(Alignments.Violent);
		
		hasTopArrow = true;
		hasRightArrow = true;
	}
	
}