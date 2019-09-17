package com.tlf.oss.resourceinventory.granite.core.enums;

public enum EntityFields {

	NETWORK_OWNER_ID("networkOwnerID"),
	NAME("name"),
	VALUE("value"),
	PLACEPHYSICALRESOURCEASSOC("placePhysicalResourceAssoc"),
	PHYSICALLINK("placePhysicalResourceAssoc.physicalLink"),
	ACCESSTECHNOLOGY("placePhysicalResourceAssoc.physicalLink.accessTechnology"),
	VOICEPROTOCOL("placePhysicalResourceAssoc.physicalLink.voiceProtocol"),
	DOWNSTREAM("downstream"),
	PRIMARYCABLE("primaryCable"),
	PRIMARYFIBER("primaryFiber"),
	CNL("cnl"),
	NRC("NRC"),
	AT("telephonicArea"),
	CATEGORY("category"),
	SERVICE_ID("serviceId"),
	BROADBAND("BROADBAND");

	private final String value;

	private EntityFields(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
