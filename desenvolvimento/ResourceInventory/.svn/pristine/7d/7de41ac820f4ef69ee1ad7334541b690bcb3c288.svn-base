package com.tlf.oss.resourceinventory.osp.core.enums;

public enum Code {

	RIOSP_001("RIOSP-001", "Erro ao validar o objeto ResourceInventoryEntity", "O valor do campo %s é nulo"),
	RIOSP_002("RIOSP-002", "Erro de conexão", "%s: %s"),
	RIOSP_003("RIOSP", "Erro ao chamar a procedure / serviço %s", ""),
	RIOSP_004("RIOSP-004", "Erro interno", ""),
	RIOSP_999("RIOSP-999", "Erro não mapeado", ""),
	SUCCESS("0", "Sucesso", "");

	private final String value;
	
	private final String description;
	
	private final String message;

	private Code(String value, String description, String message) {
		this.value = value;
		this.description = description;
		this.message = message;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	public String getMessage() {
		return message;
	}
}
