package com.lucky7.ibg.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lucky7.ibg.gui.TransferMBWindow;

public class TransferInput implements ActionListener{
	
	TransferMBWindow transferWindow;
	
	public TransferInput(TransferMBWindow w) {
		this.transferWindow = w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == transferWindow.groupList) {
			
		}else if(e.getSource() == transferWindow.enactTransferButton) {
			transferWindow.enactTransfer();
		}
	}
}
