package com.lucky7.ibg.card.group;

import java.util.ArrayList;

import com.lucky7.ibg.card.Alignments;
import com.lucky7.ibg.card.Card;

public abstract class GroupCard extends Card{
	
	protected int power;
	protected int tPower;
	protected int resistance;
	protected int income;
	protected int balance;
	protected ArrayList<Alignments> alignments;

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

}
