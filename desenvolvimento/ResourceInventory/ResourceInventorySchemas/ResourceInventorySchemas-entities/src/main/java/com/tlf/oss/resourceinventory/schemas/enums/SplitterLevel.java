package com.tlf.oss.resourceinventory.schemas.enums;

/**
 * BEATRIXTWO-441 | DEMOSS-2279
 *
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201710
 */
public enum SplitterLevel {
	
	FIRST("FIRST-LEVEL"),
	SECOND("SECOND-LEVEL");

	private String level;

	private SplitterLevel(String value) {
		this.level = value;
	}

	public String getLevel() {
		return level;
	}
}