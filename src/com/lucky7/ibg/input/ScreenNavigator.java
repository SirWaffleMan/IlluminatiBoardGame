package com.lucky7.ibg.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lucky7.ibg.gui.Renderer;
import com.lucky7.ibg.gui.ScreenState;

public class ScreenNavigator implements ActionListener{
	
	Renderer renderer;
	
	public ScreenNavigator(Renderer r) {
		this.renderer = r;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == renderer.playButton) {
			// Navigate to Play Menu
			renderer.setScreenState(ScreenState.PlayMenu);
		}else if(e.getSource() == renderer.exitButton) {
			// Close Application
			System.exit(0);
		}else if(e.getSource() == renderer.backButton) {
			// Navigate to Main Menu
			renderer.setScreenState(ScreenState.MainMenu);
		}
	}

}
