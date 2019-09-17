package com.tlf.oss.resourceinventory.granite.core.enums;

public enum TypeAvailability {
	
	MSAN("MSAN"), 
	OLT("OLT"), 
	DSLAM("DSLAM"), 
	VDSL("VDSL"), 
	ADSL("ADSL"), 
	ADSL2PLUS("ADSL2+"), 
	METALICO("METALICO"), 
	BROADBAND("BROADBAND"), 
	SIP("SIP"), 
	HOME("HOME");

	private String types;

	private TypeAvailability(String types) {
		this.types = types;
	}

	public String getTypes() {
		return types;
	}

}
