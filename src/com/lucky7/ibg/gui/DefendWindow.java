package com.lucky7.ibg.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lucky7.ibg.Game;

public class DefendWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	Game game;
	JPanel panel;
	
	public DefendWindow(Game g) {
		this.game = g;
		panel = new JPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Defend");
		setVisible(true);
		add(panel);
		pack();
		
	}

}
