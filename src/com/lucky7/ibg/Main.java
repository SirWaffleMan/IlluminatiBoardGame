package com.lucky7.ibg;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.lucky7.ibg.gui.ClientPanel;

public class Main {
	
	static JFrame frame;
	static ClientPanel clientPanel;
	static Game game;
	
	public static void main(String[] args) {
		init();
		configureWindow();
		startClient();
	}
	
	static void init() {
		// Initialize
		game = new Game();
		frame = new JFrame();
		clientPanel = new ClientPanel(game);
	}
	
	static void configureWindow() {
		// Setup Window
		frame.setTitle("Illuminati Client - Lucky7");
		clientPanel.setPreferredSize(new Dimension(600, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(clientPanel);
		frame.setVisible(true);
		frame.pack();
		clientPanel.setFocusable(true);
		clientPanel.requestFocusInWindow();
	}
	
	static void startClient() {
		while(true) {
			clientPanel.repaint();
		}
	}
	
	public static void startGame() {
		game.addPlayers(clientPanel.getPlayers());
		game.start();
	}

}
