package com.tlf.oss.resourceinventory.scqla.core.enums;

public enum Code {

	RI_SCQLA_001("RISCQLA-001"),
	RI_SCQLA_002("RISCQLA-002"),
	//Erro exclusivo da facilidade, quando nao encontra facilidade
	RI_SCQLA_003("RISCQLA-003");

	private final String value;

	private Code(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
