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
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lucky7.ibg.Game;
import com.lucky7.ibg.card.group.GroupCard;
import com.lucky7.ibg.input.AttackToDestroyInput;
import com.lucky7.ibg.player.Player;
import com.lucky7.ibg.player.PowerStructure;

public class AttackToDestroyWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JPanel panel;
	Game game;
	JLabel attackLabel;
	JLabel rollLabel;
	public JButton enactAttackButton;
	AttackToDestroyInput input;
	public JComboBox<GroupCard> uncontrolledList;
	public JComboBox<String> placementList;
	JSlider powerSlider;
	int target = 0;
	int moneySpent = 0;
	
	GroupCard card;
	GroupCard attackedCard;
	
	public AttackToDestroyWindow(Game g) {
		this.game = g;
		setLocationRelativeTo(g.frame);
		input = new AttackToDestroyInput(this);
		attackLabel = new JLabel("Which group to destroy?");
		attackLabel.setForeground(Color.WHITE);
		rollLabel = new JLabel("Roll: 10 or less");
		rollLabel.setForeground(Color.RED);
		
		enactAttackButton = new JButton("Enact Attack");
		enactAttackButton.addActionListener(input);
		panel = new JPanel();
		panel.setBackground(new Color(60,60,60));
		panel.setLayout(new GridBagLayout());
		uncontrolledList = new JComboBox<GroupCard>();
		
		// Add uncontrolled group cards
		for(int i = 0; i < game.uncontrolled.size(); i++) {
			uncontrolledList.addItem(game.uncontrolled.get(i));
		}
		
		// Add player's controlled cards
		for(int i = 0; i < game.getControlledGroups().size() - game.players.size(); i++) {
			uncontrolledList.addItem(game.getControlledGroups(i));
		}
				
		int min = 1;
		int max = game.getSelectedCard().getBalance();
		int init = 1;
		if(max != 0) {
			powerSlider = new JSlider(JSlider.HORIZONTAL,min, max, init);
			powerSlider.setMajorTickSpacing(max-1);
			powerSlider.setMinorTickSpacing(1);
			powerSlider.setPaintTicks(true);
			powerSlider.setPaintLabels(true);
			powerSlider.setBackground(new Color(60,60,60));
			powerSlider.setForeground(Color.WHITE);
			powerSlider.addChangeListener(new ChangeListener() {
		        @Override
		        public void stateChanged(ChangeEvent ce) {
		            updateRollLabel();
		        }
		    });
		}

		
		uncontrolledList.setPreferredSize(new Dimension(200,20));		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NORTH;
		gbc.insets = new Insets(6,6,6,6);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(attackLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(uncontrolledList, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(powerSlider, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(rollLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(enactAttackButton, gbc);
		setTitle("AttackToDestroy");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		add(panel);
		pack();
		
		card = game.getSelectedCard();
		attackedCard = (GroupCard) uncontrolledList.getSelectedItem();
		updateRollLabel();
	}
	
	public void updateRollLabel() {
		attackedCard = (GroupCard) uncontrolledList.getSelectedItem();
		// TODO: Fix this bodge
		try {
			target = card.getPower() - attackedCard.getResistance();
			moneySpent = (powerSlider != null) ? powerSlider.getValue() : 0;
			
			rollLabel.setText("Roll: " + (target + moneySpent) + " or less");
		}catch(NullPointerException e) {
			
		}
	}
	
	public void enactAttack() {
		
		Player player = game.getCurrentPlayer();
		
		int roll = game.rollDice();
		int target = 10;
		
		if(roll <= target && roll < 11) {
			game.addLog("Attack was successful! \"" + attackedCard.getName() + "\" was destroyed!");
			
			// Remove card from player and add into discard pile
			for(int i = 0; i < game.players.size(); i++) {
				for(int j = 0; j < game.players.get(i).getControlledGroups().size(); j++) {
					if(attackedCard == game.players.get(i).getControlledGroups().get(j)) {
						GroupCard card = game.players.get(i).removeCard(attackedCard);
						game.discardPile.add(card);
					}
				}
			}
			
			// Remove card from uncontrolled groups (if it exists)
			for(int i = 0; i < game.uncontrolled.size(); i++) {
				if(attackedCard == game.uncontrolled.get(i)) {
					game.discardPile.add(game.uncontrolled.remove(i));
				}
			}
		}else {
			game.addLog("Attack was not successful!");
		}
		
		game.actionPanel.lowerActionCount();
		game.actionPanel.updatePlayer(player);
		game.gamePanel.repaint();
		
		dispose();
	}
	
}
