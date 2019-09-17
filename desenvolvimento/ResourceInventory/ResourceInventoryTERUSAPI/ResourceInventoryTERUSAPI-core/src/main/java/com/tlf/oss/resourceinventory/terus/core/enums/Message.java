package com.tlf.oss.resourceinventory.terus.core.enums;

public enum Message {

	ERRO_BLOQUEIO_PORTA_VOZ_TERUS("Erro ao bloquear porta voz no terus"),
	ERRO_DESBLOQUEIO_PORTA_VOZ_TERUS("Erro ao desbloquear porta voz no terus"),
	ERRO_RESOURCE_ENTITY("Erro ao validar o objeto ResourceInventoryEntity"),
	ERRO_RESOURCE_NOT_SERVICESPECCHARDESCRIBES("O tamanho da lista resourceFacingService.serviceDescribedBy.serviceSpecCharDescribes eh 0"),
	ERRO_RESOURCE_NOT_SERVICEDESCRIBEDBY("O tamanho da lista resourceFacingService.serviceDescribedBy eh 0"),
	ERRO_RESOURCE_NOT_CUSTOMERFACINGSERVICE("O valor do campo customerFacingServiceList eh nulo"),
	BUSINESS_ERROR_TIMEOUT_MSG("Tempo de resposta excedido");

	private final String value;

	private Message(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
