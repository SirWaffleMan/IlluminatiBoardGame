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
import com.lucky7.ibg.input.TransferPowerInput;

public class TransferPower extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel panel;
	Game game;
	JLabel transferLabel;
	JLabel amountLabel;
	public JButton enactTransferButton;
	TransferPowerInput input;
	public JComboBox<String> groupList1;
	public JComboBox<String> groupList2;
	
	public TransferPower(Game g) {
		this.game = g;
		setLocationRelativeTo(g.frame);
		input = new TransferPowerInput(this);
		transferLabel = new JLabel("Transfer power from?");
		transferLabel.setForeground(Color.WHITE);
		amountLabel = new JLabel("Transfer power to?");
		amountLabel.setForeground(Color.WHITE);
		enactTransferButton = new JButton("Enact Transfer");
		enactTransferButton.addActionListener(input);
		
		panel = new JPanel();
		panel.setBackground(new Color(60,60,60));
		panel.setLayout(new GridBagLayout());
		
		groupList1 = new JComboBox<String>();
		groupList1.addItem("1");
		groupList1.addItem("2");
		groupList1.addItem("3");
		groupList1.addItem("4");
		groupList1.setPreferredSize(new Dimension(100,20));
		
		groupList2 = new JComboBox<String>();
		groupList2.addItem("1");
		groupList2.addItem("2");
		groupList2.addItem("3");
		groupList2.addItem("4");
		groupList2.setPreferredSize(new Dimension(100,20));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NORTH;
		gbc.insets = new Insets(6,6,6,6);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(transferLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(groupList1, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(amountLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(groupList2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(enactTransferButton, gbc);
		setTitle("Transfer Power");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		add(panel);
		pack();
	}
	
	public void enactTransfer() {
		//TODO: Check if it's a card that player owns
		
		dispose();
	}
	
}
