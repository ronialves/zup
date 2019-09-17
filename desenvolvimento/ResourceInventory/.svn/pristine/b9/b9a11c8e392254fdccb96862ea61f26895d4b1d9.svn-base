package com.tlf.oss.resourceinventory.cpe.enums;

public enum FalloutCode {
	
	RICPE_001("RICPE-001","Erro ao validar o objeto ResourceInventoryEntity", "%s não informado %s"),
	RICPE_002("RICPE-002"," Erro de conexão", "%s: %s"),
	RICPE_003("RICPE","Erro ao chamar o serviço %s", ""),
	RICPE_004("RICPE-004","Erro interno", ""),
	RICPE_005("RICPE-005","Serviço interno indisponível", ""),
	RICPE_006("RICPE-006","Requisição não identificada", ""),
	RICPE_007("RICPE-007","Erro na execução de regras", ""),
	RICPE_008("RICPE-008","Erro de mapeamento entre objetos", ""),
	RICPE_999("RICPE-999","Erro não mapeado", ""),
	SUCESS("0","Sucesso", "");
	
	private FalloutCode(String value, String description, String message){
		this.value = value;
		this.description = description;
		this.message = message;
	}
	
	private final String value;
	private final String description;
	private final String message;
	
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
