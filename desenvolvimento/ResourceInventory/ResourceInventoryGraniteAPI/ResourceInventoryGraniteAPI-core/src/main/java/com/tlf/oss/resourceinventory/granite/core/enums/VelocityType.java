package com.tlf.oss.resourceinventory.granite.core.enums;

public enum VelocityType {

	DOWNSTREAM("DOWNSTREAM"),
	UPSTREAM("UPSTREAM");

	private final String type;

	private VelocityType(String value) {
		this.type = value;
	}

	public String getType() {
		return type;
	}
}
