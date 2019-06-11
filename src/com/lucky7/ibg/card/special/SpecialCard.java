package com.lucky7.ibg.card.special;

import com.lucky7.ibg.card.Card;

public abstract class SpecialCard extends Card{
	
	String description;
	
	public SpecialCard(String name, String desc) {
		super(name);
		this.description = desc;
	}
	
	public String getDescription() {
		return description;
	}
}
