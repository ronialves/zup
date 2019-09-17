package com.tlf.oss.resourceinventory.granite.core.enums;

public enum Operation {

	CHANGE_OFFER("Mudança de Oferta"), 
	OFFER_EDITION("Edição de Oferta"), 
	SALE_OFFER("Venda de Oferta"), 
	TRUE("true"),
	CHANGE_ADDRESS("Mudança de Endereço");

	private final String value;

	private Operation(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
