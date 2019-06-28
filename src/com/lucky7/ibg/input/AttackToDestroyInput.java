package com.lucky7.ibg.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lucky7.ibg.gui.AttackToDestroyWindow;

public class AttackToDestroyInput implements ActionListener{

	AttackToDestroyWindow attackWindow;
	
	public AttackToDestroyInput(AttackToDestroyWindow w) {
		this.attackWindow = w;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == attackWindow.uncontrolledList) {
			
		}else if(e.getSource() == attackWindow.enactAttackButton) {
			attackWindow.enactAttack();
		}
		
	}

}
