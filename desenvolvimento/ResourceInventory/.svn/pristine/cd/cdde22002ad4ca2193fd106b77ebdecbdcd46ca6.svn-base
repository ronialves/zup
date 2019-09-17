package com.tlf.oss.resourceinventory.sagre.repository.factory;

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
public class GenericRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="SagreDS")
	private EntityManager factory;
	
	protected String getlogIn(String nameQuery, Query query) {
		StringBuilder logBuilder = new StringBuilder(nameQuery);
		logBuilder.append("Param IN :");
		
		query.getParameters().forEach(parameter -> {
			String parameterName = parameter.getName();
			Object parameterValue = query.getParameterValue(parameterName);
			
			logBuilder.append(parameterName).append(" = ")
					  .append(parameterValue);
		});
		
		return logBuilder.toString();
	}
	
	public EntityManager getFactory() {
		return factory;
	}
}