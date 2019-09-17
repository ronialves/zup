package com.tlf.oss.resourceinventory.radius.enums;

/**
 * REC3635-1110 | REC3635-2042
 * 
 * @project Fusion
 * @author 80629552
 * @since 20190325
 */

public enum ExceptionInfoEnum {
	
	RIRADIUS_001("RIRADIUS-001", "Erro ao validar o objeto ResourceInventoryEntity", "O valor do campo %s eh nulo"),
	RIRADIUS_002("RIRADIUS-002", "Erro de conexao", "%s: %s"),
	RIRADIUS_003("RIRADIUS-003", "Erro ao executar Query %s", ""),
	RIRADIUS_004("RIRADIUS-004", "Erro interno", "%s"),
	RIRADIUS_999("RIRADIUS-999", "Erro nao mapeado", "");

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
