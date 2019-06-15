package com.lucky7.ibg.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lucky7.ibg.player.Player;

public class GlobalActionPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public JLabel viewLabel;
	public JComboBox<Object> viewList;
	public JButton endTurnButton;
	
	public GlobalActionPanel() {
		init();
		configure();
	}
	
	void init() {
		viewLabel = new JLabel("View:");
		viewList = new JComboBox<Object>();
		endTurnButton = new JButton("End Turn");
	}
	
	void configure() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(viewLabel,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(viewList,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(endTurnButton,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
	}
	
	public void addPlayerList(ArrayList<Player> players) {
		
		for(int i = 0; i < players.size(); i++) {
			viewList.addItem(players.get(0).getName());
		}
		
		viewList.addItem("Uncontrolled Groups");
	}
}
