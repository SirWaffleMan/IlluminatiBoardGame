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
import com.lucky7.ibg.input.AttackInput;


public class AttackWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JPanel panel;
	Game game;
	JLabel attackLabel;
	JLabel placementLabel;
	JLabel rollLabel;
	public JButton enactAttackButton;
	AttackInput input;
	public JComboBox<String> uncontrolledList;
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
		uncontrolledList = new JComboBox<String>();
		placementList = new JComboBox<String>();
		
		// TODO: Add other player's cards
		for(int i = 0; i < game.uncontrolled.size(); i++) {
			uncontrolledList.addItem(game.uncontrolled.get(i).getName());
		}
		
		placementList.addItem("Top");
		placementList.addItem("Right");
		placementList.addItem("Bottom");
		placementList.addItem("Left");
		
		//panel.setPreferredSize(new Dimension(400, 300));
		uncontrolledList.setPreferredSize(new Dimension(100,20));
		placementList.setPreferredSize(new Dimension(100,20));
		
		
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
		//TODO: Check if it's a card that player owns
		
		dispose();
	}
	
}
