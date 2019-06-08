package com.lucky7.ibg.player;

public class Player {
	
	String name;
	boolean isCPU;
	
	public Player(String name, boolean isCPU) {
		this.name = name;
		this.isCPU = isCPU;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isCPU() {
		return isCPU;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
