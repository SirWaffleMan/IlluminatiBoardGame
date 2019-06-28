package com.lucky7.ibg.card.illuminati;

import com.lucky7.ibg.card.group.GroupCard;

public abstract class IlluminatiCard extends GroupCard {

	public IlluminatiCard(String name, int power, int tPower, int income) {
		super(name,power,tPower,0,income);
		this.power = power;
		this.tPower = tPower;
		this.income = income;
		this.balance = 0;
		
		this.hasLeftArrow = true;
		this.hasRightArrow = true;
		this.hasBottomArrow = true;
		this.hasTopArrow = true;
	}
	
	public void addIncome() {
		balance += income;
	}
	
	public String toString() {
		return name;
	}

}
