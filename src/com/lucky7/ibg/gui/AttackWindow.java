package com.lucky7.ibg.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lucky7.ibg.Game;
import com.lucky7.ibg.card.group.GroupCard;
import com.lucky7.ibg.card.group.SourceDirection;
import com.lucky7.ibg.input.AttackInput;
import com.lucky7.ibg.player.Player;
import com.lucky7.ibg.player.PowerStructure;


public class AttackWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JPanel panel;
	Game game;
	JLabel attackLabel;
	JLabel placementLabel;
	JLabel rollLabel;
	public JButton enactAttackButton;
	AttackInput input;
	public JComboBox<GroupCard> uncontrolledList;
	public JComboBox<String> placementList;
	
	
	public AttackWindow(Game g) {
		this.game = g;
		setLocationRelativeTo(g.frame);
		input = new AttackInput(this);
		attackLabel = new JLabel("Which group to attack?");
		attackLabel.setForeground(Color.WHITE);
		placementLabel = new JLabel("Where would you like to place?");
		placementLabel.setForeground(Color.WHITE);
		rollLabel = new JLabel("Roll: 10 or less");
		rollLabel.setForeground(Color.RED);
		
		enactAttackButton = new JButton("Enact Attack");
		enactAttackButton.addActionListener(input);
		panel = new JPanel();
		panel.setBackground(new Color(60,60,60));
		panel.setLayout(new GridBagLayout());
		uncontrolledList = new JComboBox<GroupCard>();
		placementList = new JComboBox<String>();
		
		// TODO: Add other player's cards
		for(int i = 0; i < game.uncontrolled.size(); i++) {
			uncontrolledList.addItem(game.uncontrolled.get(i));
		}
		
		placementList.addItem("Top");
		placementList.addItem("Right");
		placementList.addItem("Bottom");
		placementList.addItem("Left");
		
		uncontrolledList.setPreferredSize(new Dimension(200,20));
		placementList.setPreferredSize(new Dimension(200,20));
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NORTH;
		gbc.insets = new Insets(6,6,6,6);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(attackLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(uncontrolledList, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(placementLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(placementList, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(rollLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(enactAttackButton, gbc);
		setTitle("Attack");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		add(panel);
		pack();
	}


	public void enactAttack() {
		
		Player player = game.getCurrentPlayer();
		PowerStructure ps = player.getPowerStructure();
		GroupCard card = game.getSelectedCard();
		GroupCard attackedCard = (GroupCard) uncontrolledList.getSelectedItem();
		String placement = (String) placementList.getSelectedItem();
		
		SourceDirection direction = SourceDirection.NONE;
		switch(placement) {
		case "Top":
			direction = SourceDirection.TOP;
			break;
		case "Right":
			direction = SourceDirection.RIGHT;
			break;
		case "Bottom":
			direction = SourceDirection.BOTTOM;
			break;
		case "Left":
			direction = SourceDirection.LEFT;
			break;
		}
		
		
		int roll = game.rollDice();
		int target = 10;
		
		if(roll <= target && roll < 11) {
			game.addLog("Attack was successful!");
			player.addCardToPowerStructure(card, attackedCard, direction);
		}else {
			game.addLog("Attack was not successful!");
		}
		
		game.actionPanel.updatePlayer(player);
		game.gamePanel.repaint();
		
		dispose();
	}
	
}
