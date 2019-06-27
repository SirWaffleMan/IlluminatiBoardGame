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

import com.lucky7.ibg.Game;
import com.lucky7.ibg.input.TransferInput;

public class TransferWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel panel;
	Game game;
	JLabel transferLabel;
	JLabel amountLabel;
	public JButton enactTransferButton;
	TransferInput input;
	public JComboBox<String> groupList;
	JSlider mbSlider;
	
	public TransferWindow(Game g) {
		this.game = g;
		setLocationRelativeTo(g.frame);
		input = new TransferInput(this);
		transferLabel = new JLabel("Which group to transfer MB?");
		transferLabel.setForeground(Color.WHITE);
		amountLabel = new JLabel("How much to transfer?");
		amountLabel.setForeground(Color.WHITE);
		enactTransferButton = new JButton("Enact Transfer");
		enactTransferButton.addActionListener(input);
		
		panel = new JPanel();
		panel.setBackground(new Color(60,60,60));
		panel.setLayout(new GridBagLayout());
		
		groupList = new JComboBox<String>();
		groupList.addItem("1");
		groupList.addItem("2");
		groupList.addItem("3");
		groupList.addItem("4");
		groupList.setPreferredSize(new Dimension(100,20));
		
		int min = 0;
		int max = 15;
		int init = 0;
		mbSlider = new JSlider(JSlider.HORIZONTAL,
                min, max, init);
		mbSlider.setMajorTickSpacing(5);
		mbSlider.setMinorTickSpacing(1);
		mbSlider.setPaintTicks(true);
		mbSlider.setPaintLabels(true);
		mbSlider.setBackground(new Color(60,60,60));
		mbSlider.setForeground(Color.WHITE);
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NORTH;
		gbc.insets = new Insets(6,6,6,6);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(transferLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(groupList, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(amountLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(mbSlider, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(enactTransferButton, gbc);
		setTitle("Transfer Money");
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
