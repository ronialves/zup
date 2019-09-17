package com.tlf.oss.resourceinventory.tbs.repository.factory;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * BEATRIXTWO-26 | DEMOSS-2171
 * 
 * @project Beatrix Fase 2
 * @author jannayna.c.araujo
 * @since 201709
 */

public class GenericRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="TbsDS")
	private EntityManager factory;
	
	/**
	 * Gera log com a entrada da query
	 * @param result
	 */
	protected String getlogIn(String nameQuery, Query query) {
		StringBuilder logBuilder = new StringBuilder(nameQuery);
		logBuilder.append("Param IN :");
		
		query.getParameters().forEach(parameter -> {
			String parameterName = parameter.getName();
			Object parameterValue = query.getParameterValue(parameterName);
			
			logBuilder.append(parameterName).append(" = ").append(parameterValue);
		});
		
		return logBuilder.toString();
	}
	
	public EntityManager getFactory() {
		return factory;
	}
}