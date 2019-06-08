package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
	public JButton startGameButton;
	public JPanel playMenuPanel;
	public JScrollPane scrollPane;
	public PlayerTextField[] playerField;
	public JTextArea instructions;
	
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
		playMenuPanel.setVisible(true);
		g.drawImage(illuminati_img, 0, 0, super.getWidth(), super.getHeight(), this);
	}
	
	void init() {
		// Initializes objects
		navigator = new ScreenNavigator(this);
		playButton = new JButton("Play");
		exitButton = new JButton("Exit");
		backButton = new JButton("Back");
		startGameButton = new JButton("Start Game");
		instructions = new JTextArea();
		instructions.setText("Instructions:\n"
							+ "Please enter name of the player and check box if the player is a CPU.\n"
							+"Leave the fields blank if you don't want anymore players.\n"
							+"Press \"Start Game\" when you are ready to play the game.");
		instructions.setPreferredSize(new Dimension(380, 130));
		instructions.setEditable(false);
		instructions.setLineWrap(true);
		playMenuPanel = new JPanel();
		
		playerField = new PlayerTextField[7];
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		for(int i = 0; i < playerField.length; i++) {
			playerField[i] = new PlayerTextField();
			p.add(playerField[i]);
		}
		scrollPane = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		playMenuPanel.add(backButton);
		playMenuPanel.add(startGameButton);
		playMenuPanel.add(scrollPane);
		playMenuPanel.add(instructions);
		playMenuPanel.setPreferredSize(new Dimension(400, 400));
		
		// Add listeners
		playButton.addActionListener(navigator);
		exitButton.addActionListener(navigator);
		backButton.addActionListener(navigator);
		startGameButton.addActionListener(navigator);
	}
	
	void addComponents() {
		// Adds buttons to panel
		add(playButton);
		add(exitButton);
		
		add(playMenuPanel);
		
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
		playMenuPanel.setVisible(false);
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
