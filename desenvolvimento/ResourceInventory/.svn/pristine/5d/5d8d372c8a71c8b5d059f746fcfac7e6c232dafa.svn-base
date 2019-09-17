package com.tlf.oss.resourceinventory.granite.core.repository.factory;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * 
 * @param <P>
 *            Type of id ; ex Long
 * @param <T>
 *            Type of EntityCommon; ex Usuario.class}
 */
public class GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(name="GraniteServicePU")
	private EntityManager entityManager;
/**
 * Metodo responsvel por logar informações da camada DAO
 * O terceiro parametro é usado para quando é executado uma nativeQuery, o objeto Query segundo paramento
 * não funciona para essa situação, por isso foi adicionado o terceiro parametro, o mesmo e responsavel por
 * recuperar os parametros de entrada de qualquer query e logar.
 * @param nameQuery = Nome da query ou proc executada
 * @param query = Objeto que retorna os campos para logar as informações de entrada
 * @param param = Usado para recuperar informações de entrada para NativeQuery, a mesma nao funciona para
 * o objeto acima Query
 * @return
 */
	protected String getlogIn(String nameQuery, Query query, String... param) {
		StringBuilder logBuilder = new StringBuilder(nameQuery);
		logBuilder.append("Param IN :");
		
		//nova condição adicionada ao log
		//para logar informações de nativeQuery, o mesmo nao funciona com o getParameters do objeto Query
		//caso seja informado o param, recupera informação para logar
		//caso contrario continua extraindo a informação do Objeto Query
		if(param.length > 0){
			for (String value : param) {
				logBuilder.append("Param")
				.append(" = ")
				.append(value);
			}	
		}else{
			query.getParameters().forEach(parameter -> {
				String parameterName = parameter.getName();
				Object parameterValue = query.getParameterValue(parameterName);

				logBuilder.append(parameterName)
				.append(" = ")
				.append(parameterValue);
			});
		}

		return logBuilder.toString();
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
