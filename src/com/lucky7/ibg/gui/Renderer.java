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
import com.lucky7.ibg.input.ScreenNavigator;

public class Renderer extends JPanel{

	private static final long serialVersionUID = 1L;
	
	Game game;
	ScreenNavigator navigator;
	ScreenState state;
	
	// Components
	public JButton playButton;
	public JButton exitButton;
	public JButton backButton;
	public JButton addPlayerButton;
	public JButton startGameButton;
	
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
		playButton.setVisible(true);
		exitButton.setVisible(true);
		g.drawImage(illuminati_img, 0, 0, super.getWidth(), super.getHeight(), this);
	}
	
	void renderPlayMenu(Graphics g) {
		backButton.setVisible(true);
		addPlayerButton.setVisible(true);
		startGameButton.setVisible(true);
		g.drawImage(illuminati_img, 0, 0, super.getWidth(), super.getHeight(), this);
	}
	
	void init() {
		// Initializes objects
		navigator = new ScreenNavigator(this);
		playButton = new JButton("Play");
		exitButton = new JButton("Exit");
		backButton = new JButton("Back");
		addPlayerButton = new JButton("Add Player");
		startGameButton = new JButton("Start Game");
		
		// Add listeners
		playButton.addActionListener(navigator);
		exitButton.addActionListener(navigator);
		backButton.addActionListener(navigator);
		addPlayerButton.addActionListener(navigator);
		startGameButton.addActionListener(navigator);
	}
	
	void addComponents() {
		// Adds buttons and other components to panel
		add(playButton);
		add(exitButton);
		add(backButton);
		add(addPlayerButton);
		add(startGameButton);
		
		hideAllComponents();
	}
	
	void loadResources() {
		// loads images and other resources
		try {
			illuminati_img = ImageIO.read(new File("res/illuminati.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setScreenState(ScreenState state) {
		hideAllComponents();
		this.state = state;
	}
	
	void hideAllComponents() {
		playButton.setVisible(false);
		exitButton.setVisible(false);
		backButton.setVisible(false);
		addPlayerButton.setVisible(false);
		startGameButton.setVisible(false);
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
