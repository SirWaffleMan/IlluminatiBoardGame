package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.lucky7.ibg.Game;

public class Renderer extends JPanel{

	private static final long serialVersionUID = 1L;
	
	Game game;
	
	public Renderer(Game g) {
		this.game = g;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Black Background
		g.setColor(Color.black);
		g.fillRect(0, 0, super.getWidth(), super.getHeight());
	}
}
