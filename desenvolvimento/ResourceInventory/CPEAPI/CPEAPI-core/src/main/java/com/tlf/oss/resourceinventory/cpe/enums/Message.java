package com.tlf.oss.resourceinventory.cpe.enums;

public enum Message {
	ERROR_NO_CPE_DATA("Não há nenhum registro no inventário CPE");
	
	private final String value;
	
	private Message(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
