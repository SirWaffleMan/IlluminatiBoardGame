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
	
	public GroupCard removeCard(GroupCard card) {
		for(int i = 0; i < powerStructure.controlledGroups.size(); i++) {
			if(card == powerStructure.controlledGroups.get(i)) {
				for(int j = 0; j < powerStructure.controlledGroups.size(); j++) {
					if(getControlledGroups().get(j).getTopCard() == card) {
						getControlledGroups().get(j).attachTop(null);
					}else if(getControlledGroups().get(j).getBottomCard() == card) {
						getControlledGroups().get(j).attachBottom(null);
					}else if(getControlledGroups().get(j).getRightCard() == card) {
						getControlledGroups().get(j).attachRight(null);
					}else if(getControlledGroups().get(j).getLeftCard() == card) {
						getControlledGroups().get(j).attachLeft(null);
					}
				}
			}
		}
		getControlledGroups().remove(card);
		return card;
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
