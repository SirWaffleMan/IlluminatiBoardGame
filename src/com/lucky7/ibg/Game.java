package com.lucky7.ibg;

public class Game implements Runnable{
	
	Thread thread;
	
	public Game() {
		thread = new Thread(this);
	}
	
	public void start() {
		thread.start();
	}

	@Override
	public void run() {
		// Game main process
	}
}
