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
			game.attackToControl();
		}else if(e.getSource() == game.actionPanel.attackToDestroyButton) {
			game.attackToDestory();
		}else if(e.getSource() == game.actionPanel.attackToNeutralizeButton) {
			game.attackToNeutralize();
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
			game.endTurn();
		}else if(e.getSource() == game.globalActionPanel.resignButton) {
			game.resign();
		}else if(e.getSource() == game.globalActionPanel.viewList) {
			game.gamePanel.repaint();
		}
	}
}
