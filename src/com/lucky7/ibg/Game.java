package com.lucky7.ibg;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import com.lucky7.ibg.gui.GamePanel;
import com.lucky7.ibg.player.Player;

public class Game implements Runnable{
	
	Thread thread;
	
	JFrame frame;
	GamePanel gamePanel;
	JPanel actionPanel;
	JSplitPane bottomSplitPane;
	JSplitPane rightSplitPane;
	JScrollPane scrollPane;
	JTextArea gameLogger;
	
	ArrayList<Player> players;
	
	@Override
	public void run() {
		// Game main process
		init();
		configureWindow();
		notifyStartup();
		
		shufflePlayers();
		
	}
	
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
		actionPanel = new JPanel();
		gamePanel = new GamePanel();
		gamePanel.setPreferredSize(new Dimension(900, 650));
		gameLogger = new JTextArea();
		gameLogger.setEditable(false);
		gameLogger.setLineWrap(true);
		scrollPane = new JScrollPane(gameLogger);
		bottomSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, gamePanel, scrollPane);
		rightSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bottomSplitPane, actionPanel);
		
		bottomSplitPane.setDividerSize(6);
		rightSplitPane.setDividerSize(6);
	}
	
	void configureWindow() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(rightSplitPane);
		frame.setVisible(true);
		frame.pack();
		bottomSplitPane.setDividerLocation(0.8);
		rightSplitPane.setDividerLocation(0.8);
		bottomSplitPane.setFocusable(true);
		bottomSplitPane.requestFocusInWindow();
	}
	
	void addLog(String message) {
		// Add message
		gameLogger.append(message + "\n");
		// Scroll to bottom of log
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
	}
	
	void notifyStartup() {
		addLog("Game starting...");
		for(int i = 0; i < players.size(); i++) {
			Player p = players.get(i);
			addLog(p.getName() + " has joined the game.");
		}
	}
	
	void shufflePlayers() {
		Collections.shuffle(players);
		addLog("Turn order determined:");
		for(int i = 0; i < players.size(); i++) {
			int orderIndex = i+1;
			addLog(String.valueOf(orderIndex) + ". " + players.get(i));
		}
	}

}
