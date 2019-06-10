package com.lucky7.ibg.card.group;

import java.util.ArrayList;

import com.lucky7.ibg.card.Alignments;
import com.lucky7.ibg.card.Card;

public abstract class GroupCard extends Card{
	
	int power = 0;
	int tPower = 0;
	int resistance = 0;
	int income = 0;
	ArrayList<Alignments> alignments;

	public GroupCard(String name) {
		super(name);
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
	
	public ArrayList<Alignments> getAlignments(){
		return alignments;
	}

}
