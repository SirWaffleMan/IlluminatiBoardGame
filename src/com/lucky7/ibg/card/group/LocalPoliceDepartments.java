package com.lucky7.ibg.card.group;

import com.lucky7.ibg.card.Alignments;

public class LocalPoliceDepartments extends GroupCard{

	public LocalPoliceDepartments() {
		super("Local Police Departments", -1, -1, 4, 1);
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Conservative);
		addAlignment(Alignments.Straight);
	}
	}
	
