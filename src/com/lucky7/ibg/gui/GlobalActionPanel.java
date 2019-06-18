package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lucky7.ibg.input.GameInput;
import com.lucky7.ibg.player.Player;

public class GlobalActionPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	GameInput input;
	public JLabel viewLabel;
	public JComboBox<Object> viewList;
	public JButton endTurnButton;
	public JButton resignButton;
	
	public GlobalActionPanel(GameInput input) {
		this.input = input;
		init();
		configure();
	}
	
	void init() {
		viewLabel = new JLabel("View:");
		viewList = new JComboBox<Object>();
		endTurnButton = new JButton("End Turn");
		resignButton = new JButton("Resign");
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
		gbc.insets = new Insets(10,0,0,0);
		add(endTurnButton,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(2,0,0,0);
		add(resignButton,gbc);
		
		viewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		viewLabel.setForeground(Color.WHITE);
		
		viewList.setPreferredSize(new Dimension(150, 28));
		
		endTurnButton.setPreferredSize(new Dimension(150, 28));
		endTurnButton.setBackground(new Color(170, 0, 0));
		endTurnButton.setForeground(Color.white);
		endTurnButton.setFont(new Font("Arial", Font.BOLD, 12));
		endTurnButton.addActionListener(input);
		
		resignButton.setPreferredSize(new Dimension(150, 28));
		resignButton.setBackground(new Color(170, 0, 0));
		resignButton.setForeground(Color.white);
		resignButton.setFont(new Font("Arial", Font.BOLD, 12));
		resignButton.addActionListener(input);
		
		setOpaque(false);
	}
	
	public void addPlayerList(ArrayList<Player> players) {
		
		for(int i = 0; i < players.size(); i++) {
			viewList.addItem(players.get(0).getName());
		}
		
		viewList.addItem("Uncontrolled Groups");
	}
}
