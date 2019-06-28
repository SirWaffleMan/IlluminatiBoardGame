package com.lucky7.ibg.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lucky7.ibg.gui.AttackToControlWindow;

public class AttackToControlInput implements ActionListener{
	
	AttackToControlWindow attackWindow;
	
	public AttackToControlInput(AttackToControlWindow w) {
		this.attackWindow = w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == attackWindow.uncontrolledList) {
			
		}else if(e.getSource() == attackWindow.enactAttackButton) {
			attackWindow.enactAttack();
		}else if(e.getSource() == attackWindow.powerSlider) {
			
		}
	}
}
