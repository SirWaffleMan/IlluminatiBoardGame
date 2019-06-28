package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lucky7.ibg.Game;
import com.lucky7.ibg.input.ScreenNavigator;
import com.lucky7.ibg.player.Player;

public class ClientPanel extends JPanel{

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
	public JPanel Panel;
	public PlayerTextField[] playerField;
	public JLabel status;
	public JLabel ScrollLabel;
	
	// Images
	BufferedImage illuminati_img;
	
	public ClientPanel(Game g) {
		this.game = g;
		this.state = ScreenState.MainMenu;
		init();
		addComponents();
		loadResources();
	}
	
	void renderGame(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("Game is running...", 20, super.getHeight() - 20);
	}
	
	void renderMainMenu(Graphics g) {
		playButton.setVisible(true);
		exitButton.setVisible(true);
	}
	
	void renderPlayMenu(Graphics g) {
		playMenuPanel.setVisible(true);
	}
	
	void init() {
		// Initializes objects
		navigator = new ScreenNavigator(this);
		playButton = new JButton("PLAY");
		exitButton = new JButton("EXIT");
		backButton = new JButton("Back");
		startGameButton = new JButton("Start Game");
		ScrollLabel = new JLabel("  Name: ");
		status = new JLabel();
		status.setForeground(Color.RED);
		status.setText("A minimum of 2 players is required. No duplicate names.");
		status.setVisible(false);
		playMenuPanel = new JPanel();
		
		playerField = new PlayerTextField[6];
		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		p.add(ScrollLabel, gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		for(int i = 0; i < playerField.length; i++) {
			playerField[i] = new PlayerTextField();
			gbc.gridy = i + 1;
			p.add(playerField[i], gbc);
		}
		
		playMenuPanel.add(backButton);
		playMenuPanel.add(startGameButton);
		playMenuPanel.add(p);
		playMenuPanel.add(status);
		playMenuPanel.setPreferredSize(new Dimension(400, 300));
		
		// Add listeners
		playButton.addActionListener(navigator);
		exitButton.addActionListener(navigator);
		backButton.addActionListener(navigator);
		startGameButton.addActionListener(navigator);
		
		// Configure buttons
		playButton.setPreferredSize(new Dimension(160, 40));
		exitButton.setPreferredSize(new Dimension(160, 40));
		
		playButton.setBackground(new Color(0, 102, 13));
		playButton.setForeground(Color.white);
		playButton.setFont(new Font("Arial", Font.BOLD, 16));
		
		exitButton.setBackground(new Color(0, 102, 13));
		exitButton.setForeground(Color.white);
		exitButton.setFont(new Font("Arial", Font.BOLD, 16));
		
		backButton.setBackground(new Color(0, 102, 13));
		backButton.setForeground(Color.white);
		backButton.setFont(new Font("Arial", Font.BOLD, 12));
		
		startGameButton.setBackground(new Color(0, 102, 13));
		startGameButton.setForeground(Color.white);
		startGameButton.setFont(new Font("Arial", Font.BOLD, 12));
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
	
	public ArrayList<Player> getPlayers(){
		ArrayList<Player> players = new ArrayList<Player>();
		
		for(int i = 0; i < playerField.length; i++) 
		{
			if(!playerField[i].getName().equals("")) {
				players.add(new Player(playerField[i].getName()));
			}
		}
		
		return players;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Black Background
		g.setColor(Color.black);
		g.fillRect(0, 0, super.getWidth(), super.getHeight());
		g.drawImage(illuminati_img, 0, 0, super.getWidth(), super.getHeight(), this);
		
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
