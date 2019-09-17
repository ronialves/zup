package com.tlf.oss.resourceinventory.granite.core.enums;

public enum CircuitTypeEnum {
	METALICO ("1", "METALICO"),
	GPON     ("2", "GPON");
	
	private String code;
	private String value;
	
	CircuitTypeEnum(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public String getCode(String value) {
		return code;
	}

	public String getValue() {
		return value;
	}
	
	public static String parse(String value) {
		if (value == null) {
			return null;
		}
		
		for (CircuitTypeEnum e : CircuitTypeEnum.values()) {
			if (value.equals(e.value)) {
				return e.code;
			}
			
			if (value.equals(e.code)) {
				return e.value;
			}
		}
		
		return null;
	}

}
