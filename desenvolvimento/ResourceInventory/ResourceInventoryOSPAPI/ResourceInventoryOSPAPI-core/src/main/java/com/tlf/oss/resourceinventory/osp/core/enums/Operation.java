package com.tlf.oss.resourceinventory.osp.core.enums;

public enum Operation {

	DEALLOCATE("2"),
	INSTALL("1"),
	UNINSTALL("1"),
	CANCELAMENTO("2"),
	CHANGE_OFFER("Mudança de Oferta"), 
	OFFER_EDITION("Edição de Oferta"), 
	SALE_OFFER("Venda de Oferta"), 
	TRUE("true"),
	CHANGE_ADDRESS("Mudança de Endereço"),
	NETWORK_OWNER_ID("NetworkOwnerID");

	private final String value;

	private Operation(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
