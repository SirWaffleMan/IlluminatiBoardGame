package com.lucky7.ibg.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lucky7.ibg.Game;

public class GameInput implements ActionListener{
	
	Game game;
	
	public GameInput(Game g) {
		this.game = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == game.actionPanel.attackToControlButton) {
			System.out.println("Attack To Control Button");
		}else if(e.getSource() == game.actionPanel.attackToDestroyButton) {
			System.out.println("Attack To Destroy Button");
		}else if(e.getSource() == game.actionPanel.attackToNeutralizeButton) {
			System.out.println("Attack To Neutralize Button");
		}else if(e.getSource() == game.actionPanel.transferMoneyButton) {
			System.out.println("Transfer Money Button");
		}else if(e.getSource() == game.actionPanel.moveGroupButton) {
			System.out.println("Move Group Button");
		}else if(e.getSource() == game.actionPanel.dropGroupButton) {
			System.out.println("Drop Group Button");
		}else if(e.getSource() == game.actionPanel.transferPowerButton) {
			System.out.println("Transfer Power Button");
		}else if(e.getSource() == game.actionPanel.useAbilityButton) {
			System.out.println("Use Ability Button");
		}else if(e.getSource() == game.globalActionPanel.endTurnButton) {
			System.out.println("End Turn Button");
		}else if(e.getSource() == game.globalActionPanel.resignButton) {
			System.out.println("Resign Button");
		}else if(e.getSource() == game.globalActionPanel.viewList) {
			game.gamePanel.repaint();
		}
	}
}
