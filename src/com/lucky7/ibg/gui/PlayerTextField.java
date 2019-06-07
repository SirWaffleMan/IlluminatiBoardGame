package com.lucky7.ibg.gui;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerTextField extends JPanel{
	private static final long serialVersionUID = 1L;
	
	JTextField name;
	JCheckBox isCPU;
	
	public PlayerTextField() {
		init();
		addComponents();
	}
	
	void init() {
		name = new JTextField(30);
		isCPU = new JCheckBox();
		
		name.setToolTipText("Enter name of player");
		isCPU.setToolTipText("is this player a CPU?");
	}
	
	void addComponents() {
		add(name);
		add(isCPU);
	}
}
