package com.tlf.oss.resourceinventory.granite.core.enums;

import java.util.EnumSet;

public enum StatusResources {

	ACTIVE("ATIVO"),
	IN_CONFIGURATION("EM CONFIGURACAO"),
	RESERVED("RESERVADO");

	private final String status;

	private StatusResources(String status) {
		this.status = status;
	}

	private static final EnumSet<StatusResources> VALUES = EnumSet.allOf(StatusResources.class);

	public static StatusResources getStatusResources(String value) {
		return VALUES.stream()
    				 .filter(status -> status.getStatus().equals(value))
    				 .findFirst()
    				 .orElse(null);
	}

	public String getStatus() {
		return status;
	}
}
