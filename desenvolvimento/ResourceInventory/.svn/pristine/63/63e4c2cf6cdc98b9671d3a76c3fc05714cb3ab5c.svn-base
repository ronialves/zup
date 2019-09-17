package com.tlf.oss.resourceinventory.sagre.enums;

/**
 * BEATFAS-101 | DEMOSS-3320
 * 
 * @project Beatrix Fase 3
 * @author bruna.barbosa
 * @since 201806
 */

public enum ExceptionInfoEnum {
	
	RISAGRE_001("RISAGRE-001", "Erro ao validar o objeto ResourceInventoryEntity", "O valor do campo %s eh nulo"),
	RISAGRE_002("RISAGRE-002", "Erro de conexao", "%s: %s"),
	RISAGRE_003("RISAGRE", "Erro ao chamar a procedure %s", ""),
	RISAGRE_004("RISAGRE-004", "Erro interno", ""),
	RISAGRE_999("RISAGRE-999", "Erro nao mapeado", "%s: %s");

	final String code;
	final String description;
    final String message;
	 
	private ExceptionInfoEnum(String code, String description, String message) {
		this.code = code;
		this.description = description;
		this.message = message;
	}

	public String getCode(){
		return code;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getMessage(){
		return message;
	}

}
