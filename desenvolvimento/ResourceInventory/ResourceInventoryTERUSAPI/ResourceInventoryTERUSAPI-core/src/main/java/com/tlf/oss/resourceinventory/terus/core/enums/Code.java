package com.tlf.oss.resourceinventory.terus.core.enums;

public enum Code {

	RITERUS_001("RITERUS-001"), 
	RITERUS_002("RITERUS-002"), 
	SUCCESS("0");

	private final String value;

	private Code(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
