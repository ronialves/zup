package com.tlf.oss.resourceinventory.tbs.enums;

/**
 * BEATRIXTWO-26 | DEMOSS-2171
 * 
 * @project Beatrix Fase 2
 * @author jannayna.c.araujo
 * @since 201709
 *	
 *	Estados possiveis do acesso. 
 */

public enum AccessEnum {

	NEW("N"),
	DISCONECT("D"),
	IN_SERVICE("I");

	private final String value;

	private AccessEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
