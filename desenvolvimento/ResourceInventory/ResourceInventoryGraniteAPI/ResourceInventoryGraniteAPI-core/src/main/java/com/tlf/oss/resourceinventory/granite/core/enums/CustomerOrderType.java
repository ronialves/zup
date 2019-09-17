package com.tlf.oss.resourceinventory.granite.core.enums;

/**
 * 
 * @author paulo nicezio
 *
 */
public enum CustomerOrderType {

	OFFER_EDITION("Edição de Oferta"),
	CHANGE_OFFER("Mudança de Oferta"),
	SALE_OFFER("Venda"),
	CHANGE_ADDRESS("Mudança de Endereço");
    
    private final String value;
 
    private CustomerOrderType(String value) {
        this.value = value;
    }
 
    public String getValue() {
        return value;
    }
    
}
