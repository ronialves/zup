package com.tlf.oss.resourceinventory.granite.core.enums;

import java.util.EnumSet;

/**
 * 
 * @author dsjunior
 *
 */
public enum StatusMsanPotsType {

	LOCKED("BLOQUEADO"), 
	FREE("LIVRE"),
	UPDATEPOTS("UPDATEPOTS"),
	SEND_TERUS("TRUE"),
	NOT_TERUS("FALSE");
	
	private final String value;

	private StatusMsanPotsType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static StatusMsanPotsType getStatusMsanPots(String value) {
		
		for (StatusMsanPotsType statusMsanPots : EnumSet.allOf(StatusMsanPotsType.class)) {
		
			if (statusMsanPots.getValue().equals(value)) {
				return statusMsanPots;
			}
		}
		
		return null;
	}
	
}
