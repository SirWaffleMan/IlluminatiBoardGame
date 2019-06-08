package com.lucky7.ibg;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.lucky7.ibg.gui.GamePanel;
import com.lucky7.ibg.player.Player;

public class Game implements Runnable{
	
	Thread thread;
	ArrayList<Player> players;
	
	JFrame frame;
	GamePanel panel;
	
	public static boolean checkValidGame(ArrayList<Player> players) {
		if(players.size() >= 2) {
			return true;
		}
		return false;
	}
	
	public void addPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Game() {
		thread = new Thread(this);
	}
	
	public void start() {
		thread.start();
	}
	
	void init() {
		// Initialize
		frame = new JFrame("Illuminati - Lucky7");
		panel = new GamePanel();
	}
	
	void configureWindow() {
		panel.setPreferredSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		panel.setFocusable(true);
		panel.requestFocusInWindow();
	}

	@Override
	public void run() {
		// Game main process
		init();
		configureWindow();
	}
}
