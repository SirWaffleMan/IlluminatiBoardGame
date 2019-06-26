package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.lucky7.ibg.Game;
import com.lucky7.ibg.card.group.GroupCard;
import com.lucky7.ibg.player.PowerStructure;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	Game game;
	
	public GamePanel(Game g) {
		this.game = g;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Black background
		g.setColor(Color.black);
		g.fillRect(0, 0, super.getWidth(), super.getHeight());
		
		// Draw game information
		g.setColor(Color.WHITE);
		String playerName = (String)game.globalActionPanel.viewList.getSelectedItem();
		g.drawString("Currently Viewing: " + playerName, 0, 10);
		
		// Draw power structure
		g.setColor(Color.BLUE);
		try {
			PowerStructure ps = game.getViewingPlayer().getPowerStructure();
			renderPowerStructure(ps, g);
		}catch(NullPointerException e) {
			//TODO: handle error
		}

	}
	
	private void renderPowerStructure(PowerStructure ps, Graphics g) {
		renderCard(ps.getControlledGroups().get(0), getWidth()/2 - 20, getHeight()/2 - 20, g);
	}
	
	private void renderCard(GroupCard card, int x, int y, Graphics g) {
		
		final int w = 40;
		final int h = 40;
		final int s = 5;
		
		g.fillRect(x, y, w, h);
		
		if(card.getTopCard() != null) {
			renderCard(card.getTopCard(), x, y-h-s, g);
		}
		
		if(card.getRightCard() != null) {
			renderCard(card.getRightCard(), x+w+s, y, g);
		}
		
		if(card.getBottomCard() != null) {
			renderCard(card.getBottomCard(), x, y+h+s, g);
		}
		
		if(card.getLeftCard() != null) {
			renderCard(card.getLeftCard(), x-w-s, y, g);
		}
		
	}
}
