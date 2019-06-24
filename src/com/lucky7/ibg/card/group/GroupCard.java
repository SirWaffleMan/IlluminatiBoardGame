package com.lucky7.ibg.card.group;

import java.util.ArrayList;

import com.lucky7.ibg.card.Alignments;
import com.lucky7.ibg.card.Card;

public abstract class GroupCard extends Card{
	
	// Card properties
	protected int power;
	protected int tPower;
	protected int resistance;
	protected int income;
	protected int balance;
	protected ArrayList<Alignments> alignments;
	
	// Attached cards
	protected GroupCard topCard;
	protected GroupCard rightCard;
	protected GroupCard bottomCard;
	protected GroupCard leftCard;
	
	protected SourceDirection source = SourceDirection.NONE;

	/*
	 * If card does not have a certain attribute (the card doesn't have a power or resistance
	 * for example) enter a -1 for that value. Note: there is a difference between a card not
	 * having a power and a card having a power of 0. If it has a 0 enter 0. Remember to add
	 * group card you made to deck at bottom of Game.java
	 */
	public GroupCard(String name, int power, int tPower, int resistance, int income) {
		super(name);
		this.power = power;
		this.tPower = tPower;
		this.resistance = resistance;
		this.income = income;
		this.balance = 0;
		alignments = new ArrayList<Alignments>();
	}
	
	public void setPower(int p) {
		this.power = p;
	}
	
	public void setTPower(int tp) {
		this.tPower = tp;
	}
	
	public void setResistance(int r) {
		this.resistance = r;
	}
	
	public void setIncome(int i) {
		this.income = i;
	}
	
	public void addAlignment(Alignments a) {
		alignments.add(a);
	}
	
	public int getPower() {
		return power;
	}
	
	public int getResistance() {
		return resistance;
	}
	
	public int getIncome() {
		return income;
	}
	
	public void addIncome() {
		this.balance += income;
	}
	
	public ArrayList<Alignments> getAlignments(){
		return alignments;
	}
	
	public void attachTop(GroupCard card) {
		topCard = card;
	}
	
	public void attachRight(GroupCard card) {
		rightCard = card;
	}
	
	public void attachBottom(GroupCard card) {
		bottomCard = card;
	}
	
	public void attachLeft(GroupCard card) {
		leftCard = card;
	}

}
