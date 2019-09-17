package com.tlf.oss.resourceinventory.osp.core.enums;

public enum ComplementType {
	HORIZONTAL ("HORIZONTAL", "2"),
    VERTICAL ("VERTICAL", "1");
     
    private final String code;
    private final String value;
    
    ComplementType(String code, String value){
    	this.code = code;
    	this.value = value;
    }

	public String getValue() {
		return value;
	}

	public String getCode() {
		return code;
	}
	
	public static ComplementType getByCode(String code) {
		for(ComplementType ct : ComplementType.values()) {
			if(ct.code.equalsIgnoreCase(code)) {
				return ct;
			}
		}
		return null;
	}
}
