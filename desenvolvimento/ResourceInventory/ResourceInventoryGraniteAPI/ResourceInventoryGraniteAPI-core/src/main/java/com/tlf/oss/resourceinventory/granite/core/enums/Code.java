package com.tlf.oss.resourceinventory.granite.core.enums;

public enum Code {

	RIGRANITE_001("RIGRANITE-001", "Erro ao validar o objeto ResourceInventoryEntity", "O valor do campo %s é nulo"),
	RIGRANITE_002("RIGRANITE-002", "Erro de conexão", "%s: %s"),
	RIGRANITE_003("RIGRANITE", "Erro ao chamar a procedure %s", ""),
	RIGRANITE_004("RIGRANITE-004", "Erro interno", ""),
	RIGRANITE_005("RIGRANITE-005", "Servico interno indisponível", ""),
	RIGRANITE_006("RIGRANITE-006", "Requisicao não identificada", ""),
	RIGRANITE_007("RIGRANITE-007", "Erro na execucao de regras", ""),
	RIGRANITE_008("RIGRANITE-008", "Erro de mapeamento entre objetos", ""),
	RIGRANITE_999("RIGRANITE-999", "Erro não mapeado", ""),
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
