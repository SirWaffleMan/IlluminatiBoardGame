package com.lucky7.ibg.card.illuminati;

import com.lucky7.ibg.card.Card;

public abstract class IlluminatiCard extends Card {
	
	protected int power;
	protected int tPower;
	protected int income;
	protected int balance;

	public IlluminatiCard(String name, int power, int tPower, int income) {
		super(name);
		this.power = power;
		this.tPower = tPower;
		this.income = income;
		this.balance = 0;
	}
	
	public void addIncome() {
		balance += income;
	}

}
