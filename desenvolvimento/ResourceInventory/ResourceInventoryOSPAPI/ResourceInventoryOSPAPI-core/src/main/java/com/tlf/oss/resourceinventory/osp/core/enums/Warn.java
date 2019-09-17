package com.tlf.oss.resourceinventory.osp.core.enums;

public enum Warn {

	ENDERECO_BLOQUEADO("RI-0102", "Endereço Bloqueado"), 
	ENDERECO_SATURADO("RI-0103", "Endereço Saturado");

	private final String code;
	private final String message;

	private Warn(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
