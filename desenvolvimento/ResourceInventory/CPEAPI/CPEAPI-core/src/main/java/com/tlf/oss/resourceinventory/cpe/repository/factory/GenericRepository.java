package com.tlf.oss.resourceinventory.cpe.repository.factory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;

public class GenericRepository {

	@PersistenceContext(name = CpeConstants.CPE_DATASOURCE)
	protected EntityManager factory;

	protected String logIn(String nameQuery, Query query) {
		final StringBuilder log = new StringBuilder(nameQuery);
		log.append("Param In :");

		query.getParameters().forEach(param -> {
			String parameterName = param.getName();
			Object parameterValue = query.getParameterValue(parameterName);

			log.append(parameterName).append(" = ").append(parameterValue).append(System.lineSeparator());
		});

		return log.toString();
	}

	@SuppressWarnings("rawtypes")
	protected String logOut(List result) {
		final StringBuilder log = new StringBuilder("Param Out :");
		final int resultSize = result.size();
		if (resultSize == 0) {
			log.append("No result");
		} else if (resultSize == 1) {
			log.append(result.get(0).toString());
		} else {
			log.append(String.format("Result: %s registers", resultSize));
		}

		return log.toString();
	}

	protected EntityManager getEntityManager() {
		return factory;
	}

	protected <T> void create(T entity) throws OSSBusinessException {
		try {
			factory.persist(entity);
			factory.flush();
		} catch (PersistenceException e) {
			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(),
					String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));
		} catch (Exception e) {
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					FalloutCode.RICPE_999.getMessage());
		}
	}

	protected <T> void update(T entity) throws OSSBusinessException {
		try {
			factory.merge(entity);
			factory.flush();
		} catch (PersistenceException e) {
			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(),
					String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));
		} catch (Exception e) {
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					FalloutCode.RICPE_999.getMessage());
		}
	}

	protected <T> void delete(T entity) throws OSSBusinessException {
		try {
			factory.remove(entity);
			factory.flush();

		} catch (PersistenceException e) {
			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(),
					String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));
		} catch (Exception e) {
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					FalloutCode.RICPE_999.getMessage());
		}
	}
	
	protected <T> T findById(Class<T> clazz, Integer id) throws OSSBusinessException{
		try {
			return (T) factory.find(clazz, id);
		}
		catch (PersistenceException e) {
			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(), String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));		
		}
		catch (Exception e) {
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(), FalloutCode.RICPE_999.getMessage());
		}
	}

}
