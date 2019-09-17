package com.tlf.oss.resourceinventory.granite.core.enums;

import java.util.EnumSet;
import java.util.Optional;

public enum IpType {

	FIXED("FIXED", "Business"),
	DYNAMIC("DYNAMIC", "Home");

	private final String type;
	private final String serviceClass;

	private IpType(String type, String serviceClass) {
		this.type = type;
		this.serviceClass = serviceClass;
	}

	public String getType() {
		return type;
	}

	public String getServiceClass() {
		return serviceClass;
	}

	private static final EnumSet<IpType> VALUES = EnumSet.allOf(IpType.class);

	public static Optional<IpType> retrieveIpTypeByType(String value) {
		return VALUES.stream()
					 .filter(type -> type.getType().equals(value))
					 .findFirst();
	}

	public static Optional<IpType> retrieveIpTypeByServiceClass(String value) {
		return VALUES.stream()
					 .filter(serviceClass -> serviceClass.getServiceClass().equals(value))
					 .findFirst();
	}
}
