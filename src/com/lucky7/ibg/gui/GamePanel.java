package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.lucky7.ibg.Game;
import com.lucky7.ibg.card.group.GroupCard;
import com.lucky7.ibg.player.PowerStructure;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	Game game;
	BufferedImage eye;
	
	public GamePanel(Game g) {
		this.game = g;
		try {
			eye = ImageIO.read(new File("res/illuminati_eye.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		renderCard(ps.getControlledGroups().get(0), getWidth()/2 - 28, getHeight()/2 - 28, g);
	}
	
	private void renderCard(GroupCard card, int x, int y, Graphics g) {
		
		final int w = 56;
		final int h = 56;
		final int s = 5;
		
		g.setColor(Color.YELLOW);
		g.drawImage(eye, x, y, w, h, this);
		
		
		if(card.getTopCard() != null) {
			g.fillRect(x,y-s,w,s);
			renderCard(card.getTopCard(), x, y-h-s, g);
		}
		
		if(card.getRightCard() != null) {
			g.fillRect(x+w, y, s, h);
			renderCard(card.getRightCard(), x+w+s, y, g);
		}
		
		if(card.getBottomCard() != null) {
			g.fillRect(x, y+h, w, s);
			renderCard(card.getBottomCard(), x, y+h+s, g);
		}
		
		if(card.getLeftCard() != null) {
			g.fillRect(x-s, y, s, h);
			renderCard(card.getLeftCard(), x-w-s, y, g);
		}
		
		if(game.actionPanel.cardSelectedList.getSelectedItem().equals(card)) {
			drawSelectCursor(x,y,g);
		}
		
	}
	
	private void drawSelectCursor(int x, int y, Graphics g) {
		g.setColor(Color.red);
		g.drawRect(x, y, 56, 56);
		g.drawRect(x+1, y+1, 54, 54);
		g.drawRect(x+2, y+2, 52, 52);
		g.setColor(Color.yellow);
		repaint();
	}
}
