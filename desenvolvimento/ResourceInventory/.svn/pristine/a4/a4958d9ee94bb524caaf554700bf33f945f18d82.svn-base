/**
 * 
 */
package com.tlf.oss.resourceinventory.television.enums;

/**
 * @author melissa.d.goncalves
 *
 */
public enum ExceptionInfoEnum {
	
	
	RITELEVISION_001("RITELEVISION-001", "Erro ao validar o objeto ResourceInventoryEntity", "O valor do campo %s eh nulo"),
	RITELEVISION_002("RITELEVISION-002", "Erro de conexao", "%s: %s"),
	RITELEVISION_003("RITELEVISION", "Erro ao chamar a consulta %s", ""),
	RITELEVISION_004("RITELEVISION-004", "Erro interno", ""),
	RITELEVISION_999("RITELEVISION-999", "Erro nao mapeado", "%s: %s");

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
