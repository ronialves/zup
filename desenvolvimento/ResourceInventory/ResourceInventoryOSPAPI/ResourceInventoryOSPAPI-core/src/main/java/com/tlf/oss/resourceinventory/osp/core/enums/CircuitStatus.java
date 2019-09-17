package com.tlf.oss.resourceinventory.osp.core.enums;

public enum CircuitStatus {
	DESIGNADO("1"),
	RESERVADO("2"), 
	OCUPADO("3"),
	A_RETIRAR("4");

	private final String value;

	private CircuitStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static CircuitStatus getByValue(String value) {
		for(CircuitStatus cs : CircuitStatus.values()) {
			if(cs.getValue().equalsIgnoreCase(value)) {
				return cs;
			}
		}
		return null;
	}
}
