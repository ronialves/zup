/**
 * 
 */
package com.tlf.oss.resourceinventory.television.enums;

/**
 * @author melissa.d.goncalves
 *
 */
public enum EntityFields {
	
	SERVER_PROPERTY("resourceInventory"),
	LOCAL_FILE("resourceInventory.properties"),
	URL_ORCHESTRATION("ri.orchestration.url"),
	OPER_DETERMINE_AVALIABILITY("determine"),
	OPER_RESERVE_RESOURCE("reserve"),
	OPER_RELEASE_RESOURCE("release"),
	OPER_ALLOCATE_RESOURCE("allocate"),
	OPER_UNINSTALL_RESOURCE("uninstall"),
	OPER_INSTALL_RESOURCE("install"),
	OPER_RETRIEVE_RESOURCE_INFORMATION("retrieve"),
	OPER_DEALLOCATE_RESOURCE("deallocate"),
	OPER_RETRIEVE_ACCESS_INFORMATION("accessInformation"),
	OPER_RESOURCE_FACING_SERVICE("resourceFacingService"),
	OPER_RETRIEVE_RESOURCE_INFORMATION_V2("retrieve_v2"),
	CNL("cnl"),
	CABINET("cabinet"),
	ACCESS_TECHNOLOGY("accessTechnology"),
	ADDRESS("address"),
	STREET_NR_FIRST("streetNrFirst"),
	STREET_CODE("streetCode"),
	TELEPHONIC_AREA("telephonicArea"),
	VOICE_PROTOCOL("voiceProtocol"),
	SERVICE_ID("serviceId"),
	ID("id"),
	NAME("name"),
	NETWORK_OWNER("networkOwner"),
	PURCHASE_ORDER_NUMBER("purchaseOrderNumber"),
	TERMINAL_BOX("terminalBox"),
	STATUS("status"),
	IPV4("IPV4"),
	IPV6("IPV6"),
	RI_ID("7.2"),
	CONDITIONAL_ACCESS_SYSTEM("conditionalAccessSystem");
	
	private final String value;

	private EntityFields(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}


}
