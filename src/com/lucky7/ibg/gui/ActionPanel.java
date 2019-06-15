package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lucky7.ibg.card.group.GroupCard;
import com.lucky7.ibg.player.Player;

public class ActionPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	Player currentPlayer;
	
	public JLabel currentPlayerLabel;
	public JLabel cardSelectedLabel;
	JComboBox<GroupCard> cardSelectedList;
	public JButton attackToControlButton;
	public JButton attackToNeutralizeButton;
	public JButton attackToDestroyButton;
	public JButton transferMoneyButton;
	public JButton moveGroupButton;
	public JButton dropGroupButton;
	public JButton transferPowerButton;
	
	public ActionPanel() {
		init();
		configure();
	}
	
	public void updatePlayer(Player p) {
		this.currentPlayer = p;
		currentPlayerLabel.setText(p.getName());
		for(int i = 0; i < p.getControlledGroups().size(); i++) {
			cardSelectedList.addItem(p.getControlledGroups().get(i));
		}
	}
	
	void init() {
		currentPlayerLabel = new JLabel();
		currentPlayerLabel.setFont(new Font("Arial", Font.BOLD, 24));
		currentPlayerLabel.setForeground(Color.BLUE);
		cardSelectedLabel = new JLabel("Card selected:");
		cardSelectedList = new JComboBox<GroupCard>();
		attackToControlButton = new JButton("Attack to Control");
		attackToNeutralizeButton = new JButton("Attack to Neutralize");
		attackToDestroyButton = new JButton("Attack to Destroy");
		transferMoneyButton = new JButton("Transfer Money");
		moveGroupButton = new JButton("Move Group");
		dropGroupButton = new JButton("Drop Group");
		transferPowerButton = new JButton("Transfer Power");
	}
	
	void configure() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(currentPlayerLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(cardSelectedLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(cardSelectedList, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(10,0,0,0);
		add(attackToControlButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(0,0,0,0);
		add(attackToNeutralizeButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(attackToDestroyButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		add(transferMoneyButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		add(moveGroupButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		add(dropGroupButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		add(transferPowerButton, gbc);
	}
}
