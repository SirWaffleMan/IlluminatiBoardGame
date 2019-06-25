package com.lucky7.ibg.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lucky7.ibg.Game;

public class TransferWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel panel;
	Game game;
	
	public TransferWindow(Game g) {
		this.game = g;
	}
}
