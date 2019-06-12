package com.lucky7.ibg.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatBox extends JPanel{

	private static final long serialVersionUID = 1L;
	JTextField messageField;
	JButton sendButton;
	
	public ChatBox() {
		messageField = new JTextField(10);
		sendButton = new JButton("Send");
		this.add(messageField);
		this.add(sendButton);
	}
}
