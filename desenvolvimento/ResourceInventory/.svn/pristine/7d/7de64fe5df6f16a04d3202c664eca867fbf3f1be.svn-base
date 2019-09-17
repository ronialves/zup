package com.tlf.oss.resourceinventory.granite.core.enums.converter;
/**
 * Classe responsavel por fazer o parser do retorno do BD para o Enum "StatusPathType", 
 * sem essa classe, sempre que for executado uma query que precisa popular o ENUM "StatusPathType"
 * a seguinte exception é lançada
 * Exception Description: No conversion value provided for the value [RESERVADO] in field [RETRIEVEPATHENTITY.status].
 */
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;

@Converter(autoApply = true)
public class EnumConverter implements AttributeConverter<StatusPathType, String> {

	@Override
	public String convertToDatabaseColumn(StatusPathType statusPathType) {
		return statusPathType.getValue();
	}

	@Override
	public StatusPathType convertToEntityAttribute(String dbData) {
		return StatusPathType.getStatusPathType(dbData);
	}
	
}