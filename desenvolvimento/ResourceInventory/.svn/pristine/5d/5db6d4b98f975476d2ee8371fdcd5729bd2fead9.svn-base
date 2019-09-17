package com.tlf.oss.resourceinventory.granite.core.enums;

import java.util.EnumSet;

/**
 * 
 * @author paulo nicezio
 *
 */
public enum StatusFacilityType {

	ACTIVE("ACTIVE"), 
	NEW("NEW");
	
	private final String value;

	private StatusFacilityType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static StatusFacilityType getStatusPathType(String value) {
		for (StatusFacilityType pathType : EnumSet.allOf(StatusFacilityType.class)) {
			if (pathType.getValue().equals(value)) {
				return pathType;
			}
		}
		return null;
	}
}
