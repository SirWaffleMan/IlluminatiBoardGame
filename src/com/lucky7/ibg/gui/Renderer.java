package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.lucky7.ibg.Game;

public class Renderer extends JPanel{

	private static final long serialVersionUID = 1L;
	
	Game game;
	ScreenState state;
	
	// Components
	JButton playButton;
	JButton exitButton;
	
	// Images
	BufferedImage illuminati_img;
	
	public Renderer(Game g) {
		this.game = g;
		this.state = ScreenState.MainMenu;
		init();
		addComponents();
		loadResources();
	}
	
	void renderGame(Graphics g) {
		
	}
	
	void renderMainMenu(Graphics g) {
		g.drawImage(illuminati_img, 0, 0, super.getWidth(), super.getHeight(), this);
	}
	
	void renderPlayMenu(Graphics g) {
		
	}
	
	void init() {
		// Initializes objects
		playButton = new JButton("Play");
		exitButton = new JButton("Exit");
	}
	
	void addComponents() {
		// Adds buttons and other components to panel
		add(playButton);
		add(exitButton);
	}
	
	void loadResources() {
		// loads images and other resources
		try {
			illuminati_img = ImageIO.read(new File("res/illuminati.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Black Background
		g.setColor(Color.black);
		g.fillRect(0, 0, super.getWidth(), super.getHeight());
		
		switch(state){
		case Game:
			renderGame(g);
			break;
		case MainMenu:
			renderMainMenu(g);
			break;
		case PlayMenu:
			renderPlayMenu(g);
			break;
		default:
			break;
		}
	}
}
