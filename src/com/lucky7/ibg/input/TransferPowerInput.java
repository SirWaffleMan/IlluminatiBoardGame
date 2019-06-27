package com.lucky7.ibg.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lucky7.ibg.gui.TransferPower;

public class TransferPowerInput implements ActionListener{
	
	TransferPower transferPower;
	
	public TransferPowerInput(TransferPower w) {
		this.transferPower = w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == transferPower.groupList1) {
			
		}else if(e.getSource() == transferPower.enactTransferButton) {
			transferPower.enactTransfer();
		}
	}
}
