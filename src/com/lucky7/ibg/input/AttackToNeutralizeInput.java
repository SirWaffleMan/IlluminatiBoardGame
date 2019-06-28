package com.lucky7.ibg.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lucky7.ibg.gui.AttackToNeutralizeWindow;

public class AttackToNeutralizeInput implements ActionListener{

	AttackToNeutralizeWindow attackWindow;
	
	public AttackToNeutralizeInput(AttackToNeutralizeWindow w) {
		this.attackWindow = w;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == attackWindow.controlledList) {
			
		}else if(e.getSource() == attackWindow.enactAttackButton) {
			attackWindow.enactAttack();
		}
		
	}

}
