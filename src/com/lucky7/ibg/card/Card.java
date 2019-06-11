package com.lucky7.ibg.card;

public abstract class Card {
	
	protected String name;
	
	public Card(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
