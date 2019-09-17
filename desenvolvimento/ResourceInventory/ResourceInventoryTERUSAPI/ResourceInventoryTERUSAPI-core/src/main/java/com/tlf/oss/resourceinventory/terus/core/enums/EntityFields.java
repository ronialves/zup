package com.tlf.oss.resourceinventory.terus.core.enums;

public enum EntityFields {

	IDMSAN("idMsan"),
	NAME("name"),
	VALUE("value"),
	LIC("lic");
	private final String value;

	private EntityFields(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
