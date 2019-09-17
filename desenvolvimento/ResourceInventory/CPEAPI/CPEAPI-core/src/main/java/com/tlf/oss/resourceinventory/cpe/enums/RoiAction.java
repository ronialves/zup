package com.tlf.oss.resourceinventory.cpe.enums;

public enum RoiAction {

    PROVIDE("Provide"),
    ADD("Add"),
    MODIFY("Modify"),
    CEASE("Cease"),
    DELETE("Delete");

    private final String action;

    private RoiAction(String action) {
        this.action = action;
    }

	public String getAction() {
		return action;
	}
}
