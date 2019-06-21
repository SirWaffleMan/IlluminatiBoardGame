package com.lucky7.ibg.player;

import java.util.ArrayList;

import com.lucky7.ibg.card.group.GroupCard;
import com.lucky7.ibg.card.illuminati.IlluminatiCard;

public class Player {
	
	String name;
	IlluminatiCard illuminatiCard;
	ArrayList<GroupCard> controlledGroups;
	
	public Player(String name) {
		this.name = name;
		this.controlledGroups = new ArrayList<GroupCard>();
	}
	
	public ArrayList<GroupCard> getControlledGroups() {
		return controlledGroups;
	}
	
	public String getName() {
		return name;
	}
	
	public void addIncome() {
		for(GroupCard card : controlledGroups) {
			card.addIncome();
		}
	}
	
	public void addCardToPowerStructure(GroupCard card) {
		controlledGroups.add(card);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
