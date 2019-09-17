package com.tlf.oss.resourceinventory.orchestration.core.enums;

/**
 * BEATRIXTWO-100 | DEMOSS-3421
 * 
 * @project Beatrix Fase 3
 * @author renan.n.oliveira
 * @since 201806
 */

public enum ExceptionInfoEnum {
	

	RIO_001("RIO-001", "Erro de validacao de parametros"),
	RIO_002("RIO-002", "Erro de conexao"),
	RIO_004("RIO-004", "Erro interno"),
	RIO_006("RIO-006", "Requisição não identificada"),
	RIO_999("RIO-999", "Erro nao mapeado");

	private String code;
	private String description;

	ExceptionInfoEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
