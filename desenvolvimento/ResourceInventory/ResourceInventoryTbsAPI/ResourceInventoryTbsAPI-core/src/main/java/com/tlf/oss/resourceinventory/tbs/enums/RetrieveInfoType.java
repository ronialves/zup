package com.tlf.oss.resourceinventory.tbs.enums;

public enum RetrieveInfoType {
	
	CROSS_CONNECTION_INFO("retrieveCrossConnectionInfo"),
	NETWORK_SYNC_INFO("retrieveNetworkSyncInfo"),
	RETRIEVE_NETWORK_INFO("retrieveNetworkInfo");

	private final String value;

	private RetrieveInfoType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
