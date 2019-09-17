package com.tlf.oss.resourceinventory.tbs.enums;

/**
 * BEATRIXTWO-26 | DEMOSS-2171
 * 
 * @project Beatrix Fase 2
 * @author jannayna.c.araujo
 * @since 201709
 * 
 * Estados possiveis do tipo de requisicao
 */

public enum RequestTypeEnum {

	BROADBAND("X"),
	POTS("P");

	private final String value;

	private RequestTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
