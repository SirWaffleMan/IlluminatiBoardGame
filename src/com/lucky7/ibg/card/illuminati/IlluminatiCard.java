package com.lucky7.ibg.card.illuminati;

import com.lucky7.ibg.card.Card;

public abstract class IlluminatiCard extends Card {
	
	protected int power;
	protected int tPower;
	protected int income;

	public IlluminatiCard(String name, int power, int tPower, int income) {
		super(name);
		this.power = power;
		this.tPower = tPower;
		this.income = income;
	}

}
