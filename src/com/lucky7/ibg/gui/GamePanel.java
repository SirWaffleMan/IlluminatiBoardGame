package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, super.getWidth(), super.getHeight());
	}
}
