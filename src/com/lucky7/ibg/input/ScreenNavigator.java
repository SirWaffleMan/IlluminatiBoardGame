package com.lucky7.ibg.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lucky7.ibg.Game;
import com.lucky7.ibg.Main;
import com.lucky7.ibg.gui.ClientPanel;
import com.lucky7.ibg.gui.ScreenState;

public class ScreenNavigator implements ActionListener{
	
	ClientPanel clientPanel;
	
	public ScreenNavigator(ClientPanel r) {
		this.clientPanel = r;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clientPanel.playButton) {
			// Navigate to Play Menu
			clientPanel.setScreenState(ScreenState.PlayMenu);
		}else if(e.getSource() == clientPanel.exitButton) {
			// Close Application
			System.exit(0);
		}else if(e.getSource() == clientPanel.backButton) {
			// Navigate to Main Menu
			clientPanel.setScreenState(ScreenState.MainMenu);
		}else if(e.getSource() == clientPanel.startGameButton) {
			// Check for valid information
			if(!Game.checkValidGame(clientPanel.getPlayers())) {
				clientPanel.status.setVisible(true);
				return;
			}
			clientPanel.status.setVisible(false);
			
			// Start the game
			clientPanel.setScreenState(ScreenState.Game);
			Main.startGame();
			
			
		}
	}

}
