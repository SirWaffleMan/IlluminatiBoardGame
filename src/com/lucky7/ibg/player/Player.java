package com.lucky7.ibg.player;

import java.util.ArrayList;

import com.lucky7.ibg.card.group.GroupCard;
import com.lucky7.ibg.card.group.SourceDirection;
import com.lucky7.ibg.card.illuminati.IlluminatiCard;

public class Player {
	
	String name;
	PowerStructure powerStructure;
	
	public Player(String name) {
		this.name = name;
		this.powerStructure = new PowerStructure();
	}
	
	public ArrayList<GroupCard> getControlledGroups() {
		return powerStructure.getControlledGroups();
	}
	
	public PowerStructure getPowerStructure() {
		return powerStructure;
	}
	
	public String getName() {
		return name;
	}
	
	public void addIncome() {
		for(GroupCard card : powerStructure.getControlledGroups()) {
			card.addIncome();
		}
	}
	
	public void addCardToPowerStructure(GroupCard rootCard, GroupCard leafCard, SourceDirection placement) {
		powerStructure.addToPowerStructure(rootCard, leafCard, placement);
	}
	
	public void addIlluminatiToPowerStructure(IlluminatiCard card) {
		powerStructure.addIlluminatiToPowerStructure(card);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
