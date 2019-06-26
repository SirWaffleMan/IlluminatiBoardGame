package com.lucky7.ibg.player;

import java.util.ArrayList;

import com.lucky7.ibg.card.group.GroupCard;
import com.lucky7.ibg.card.group.SourceDirection;
import com.lucky7.ibg.card.illuminati.IlluminatiCard;
import com.lucky7.ibg.card.special.SpecialCard;

public class PowerStructure {
	
	ArrayList<GroupCard> controlledGroups;
	ArrayList<SpecialCard> specialCards;
	
	public PowerStructure() {
		controlledGroups = new ArrayList<GroupCard>();
		specialCards = new ArrayList<SpecialCard>();
	}
	
	public void addSpecialCard(SpecialCard card) {
		specialCards.add(card);
	}
	
	public void addIlluminatiToPowerStructure(IlluminatiCard illuminatiCard) {
		controlledGroups.add(illuminatiCard);
	}
	
	public ArrayList<GroupCard> getControlledGroups(){
		return controlledGroups;
	}
	
	public void addToPowerStructure(GroupCard rootCard, GroupCard leafCard, SourceDirection side) {
		
		controlledGroups.add(leafCard);
		
		switch(side) {
		case TOP:
			rootCard.attachTop(leafCard);
			break;
		case BOTTOM:
			rootCard.attachBottom(leafCard);
			break;
		case LEFT:
			rootCard.attachLeft(leafCard);
			break;
		case RIGHT:
			rootCard.attachRight(leafCard);
			break;
		case NONE:
			return;
		default:
			return;
		}
	}
}
