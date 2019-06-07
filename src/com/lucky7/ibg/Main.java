package com.lucky7.ibg;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.lucky7.ibg.gui.Renderer;

public class Main {
	
	static JFrame frame;
	static Renderer renderer;
	static Game game;
	
	public static void main(String[] args) {
		init();
		configureWindow();
	}
	
	static void init() {
		// Initialize
		game = new Game();
		frame = new JFrame();
		renderer = new Renderer();
	}
	
	static void configureWindow() {
		// Setup Window
		frame.setTitle("Illuminati Board Game");
		renderer.setPreferredSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(renderer);
		frame.setVisible(true);
		frame.pack();
		renderer.setFocusable(true);
		renderer.requestFocusInWindow();
	}

}
