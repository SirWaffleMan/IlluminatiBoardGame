package com.lucky7.ibg.gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerTextField extends JPanel{
	private static final long serialVersionUID = 1L;
	
	JTextField name;
	
	public PlayerTextField() {
		init();
		addComponents();
	}
	
	void init() {
		name = new JTextField(30);
			
		name.setToolTipText("Enter name of player");
		
	}
	
	void addComponents() {
		add(name);
	}
	
	public String getName() {
		return name.getText();
	}

}
