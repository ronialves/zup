package com.tlf.oss.resourceinventory.granite.core.enums;

import java.util.EnumSet;

/**
 * 
 * @author paulo nicezio
 *
 */
public enum StatusPathType {

	ACTIVE("ATIVO"), 
	RESERVED("RESERVADO"), 
	IN_CONFIGURATION("EM CONFIGURACAO"),
	CONFIGURED("CONFIGURADO");
	
	private final String value;

	private StatusPathType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static StatusPathType getStatusPathType(String value) {
		for (StatusPathType pathType : EnumSet.allOf(StatusPathType.class)) {
			if (pathType.getValue().equals(value)) {
				return pathType;
			}
		}
		return null;
	}
}
