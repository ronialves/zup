package com.tlf.oss.resourceinventory.cpe.enums;

public enum EstadoServico {

	EM_APROVISIONAMENTO("Em aprovisionamento"),
	ATIVADO("Ativado"),
	DESABILITADO("Desabilitado"),
	SUSPENSO("Suspenso"),
	DESCONECTADO("Desconectado"),
	CANCELADO("Cancelado"),
	EM_DESCONEXAO("Em desconexão"),
	NAO_INSTALADO("Não instalado"),
	ATIVADO_TEMPORARIAMENTE("Ativado temporariamente"),
	DESCONECTADO_TEMPORARIAMENTE("Desconectado temporariamente"),
	INATIVO("Inativo");
	
	private final String value;
	
	private EstadoServico(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
