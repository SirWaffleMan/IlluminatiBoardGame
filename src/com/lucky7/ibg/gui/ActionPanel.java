package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lucky7.ibg.card.group.GroupCard;
import com.lucky7.ibg.input.GameInput;
import com.lucky7.ibg.player.Player;

public class ActionPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	Player currentPlayer;
	
	public JLabel currentPlayerLabel;
	public JLabel actionsRemainingLabel;
	public JLabel cardSelectedLabel;
	public JComboBox<GroupCard> cardSelectedList;
	public JButton attackToControlButton;
	public JButton attackToNeutralizeButton;
	public JButton attackToDestroyButton;
	public JButton transferMoneyButton;
	public JButton transferPowerButton;
	public JButton moveGroupButton;
	public JButton dropGroupButton;
	public JButton useAbilityButton;
	public GameInput input;
	int availableTurns = 2;
	
	public ActionPanel(GameInput input) {
		this.input = input;
		init();
		configure();
	}
	
	public int getAvailableTurns() {
		return availableTurns;
	}
	
	public void updatePlayer(Player p) 
	{
		this.currentPlayer = p;
		currentPlayerLabel.setText(p.getName());
		cardSelectedList.removeAllItems();
		for(int i = 0; i < p.getControlledGroups().size(); i++) {
			cardSelectedList.addItem(p.getControlledGroups().get(i));
		}
		
		repaint();
	}
	
	void init() {
		currentPlayerLabel = new JLabel();
		currentPlayerLabel.setFont(new Font("Arial", Font.BOLD, 24));
		currentPlayerLabel.setForeground(new Color(130, 144, 255));
		actionsRemainingLabel = new JLabel("" + availableTurns);
		actionsRemainingLabel.setFont(new Font("Arial", Font.BOLD, 20));
		actionsRemainingLabel.setForeground(new Color(255, 162, 56));
		cardSelectedLabel = new JLabel("Card selected:");
		cardSelectedList = new JComboBox<GroupCard>();
		attackToControlButton = new JButton("Attack to Control");
		attackToNeutralizeButton = new JButton("Attack to Neutralize");
		attackToDestroyButton = new JButton("Attack to Destroy");
		transferMoneyButton = new JButton("Transfer Money");
		moveGroupButton = new JButton("Move Group");
		dropGroupButton = new JButton("Drop Group");
		transferPowerButton = new JButton("Transfer Power");
		useAbilityButton = new JButton("Use Ability");
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
		add(actionsRemainingLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(cardSelectedLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0,0,10,0);
		add(cardSelectedList, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(0,0,2,0);
		add(attackToControlButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(attackToNeutralizeButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		add(attackToDestroyButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		add(transferMoneyButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		add(moveGroupButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		add(dropGroupButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 10;
		add(transferPowerButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 11;
		add(useAbilityButton, gbc);
		
		cardSelectedList.setPreferredSize(new Dimension(150, 28));
		
		attackToControlButton.setPreferredSize(new Dimension(150, 28));
		attackToControlButton.setBackground(new Color(0, 102, 13));
		attackToControlButton.setForeground(Color.white);
		attackToControlButton.setFont(new Font("Arial", Font.BOLD, 12));
		attackToControlButton.addActionListener(input);
		
		attackToNeutralizeButton.setPreferredSize(new Dimension(150, 28));
		attackToNeutralizeButton.setBackground(new Color(0, 102, 13));
		attackToNeutralizeButton.setForeground(Color.white);
		attackToNeutralizeButton.setFont(new Font("Arial", Font.BOLD, 12));
		attackToNeutralizeButton.addActionListener(input);
		
		attackToDestroyButton.setPreferredSize(new Dimension(150, 28));
		attackToDestroyButton.setBackground(new Color(0, 102, 13));
		attackToDestroyButton.setForeground(Color.white);
		attackToDestroyButton.setFont(new Font("Arial", Font.BOLD, 12));
		attackToDestroyButton.addActionListener(input);
		
		transferMoneyButton.setPreferredSize(new Dimension(150, 28));
		transferMoneyButton.setBackground(new Color(0, 102, 13));
		transferMoneyButton.setForeground(Color.white);
		transferMoneyButton.setFont(new Font("Arial", Font.BOLD, 12));
		transferMoneyButton.addActionListener(input);
		
		moveGroupButton.setPreferredSize(new Dimension(150, 28));
		moveGroupButton.setBackground(new Color(0, 102, 13));
		moveGroupButton.setForeground(Color.white);
		moveGroupButton.setFont(new Font("Arial", Font.BOLD, 12));
		moveGroupButton.addActionListener(input);
		
		dropGroupButton.setPreferredSize(new Dimension(150, 28));
		dropGroupButton.setBackground(new Color(0, 102, 13));
		dropGroupButton.setForeground(Color.white);
		dropGroupButton.setFont(new Font("Arial", Font.BOLD, 12));
		dropGroupButton.addActionListener(input);
		
		transferPowerButton.setPreferredSize(new Dimension(150, 28));
		transferPowerButton.setBackground(new Color(0, 102, 13));
		transferPowerButton.setForeground(Color.white);
		transferPowerButton.setFont(new Font("Arial", Font.BOLD, 12));
		transferPowerButton.addActionListener(input);
		
		useAbilityButton.setPreferredSize(new Dimension(150, 28));
		useAbilityButton.setBackground(new Color(0, 102, 13));
		useAbilityButton.setForeground(Color.white);
		useAbilityButton.setFont(new Font("Arial", Font.BOLD, 12));
		useAbilityButton.addActionListener(input);
		
		cardSelectedLabel.setForeground(Color.WHITE);
		setOpaque(false);
	}
	
	public void setActionCount(int c)
	{
		availableTurns = c;
		actionsRemainingLabel.setText("" + (availableTurns));
	}
	
	public void lowerActionCount()
	{
		if(availableTurns > 0) {
			availableTurns--;
			actionsRemainingLabel.setText("" + (availableTurns));
		}
	}
}
