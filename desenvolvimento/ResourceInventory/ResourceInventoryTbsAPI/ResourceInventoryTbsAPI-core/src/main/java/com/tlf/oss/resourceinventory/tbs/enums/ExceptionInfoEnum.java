package com.tlf.oss.resourceinventory.tbs.enums;

/**
 * BEATFAS-102 | DEMOSS-3331
 * 
 * @project Beatrix Fase 3
 * @author bruna.barbosa
 * @since 201805
 */

public enum ExceptionInfoEnum {
	
	RITBS_001("RITBS-001", "Erro ao validar o objeto ResourceInventoryEntity", "O valor do campo %s eh nulo"),
	RITBS_002("RITBS-002", "Erro de conexao", "%s: %s"),
	RITBS_003("RITBS", "Erro ao chamar a procedure %s", ""),
	RITBS_004("RITBS-004", "Erro interno", ""),
	RITBS_999("RITBS-999", "Erro nao mapeado", "");

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
