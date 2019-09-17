package com.tlf.oss.resourceinventory.radius.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.radius.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.radius.repository.factory.GenericRepository;

/**
 * REC3635-1294 | REC3635-2045
 * 
 * @project Fusion
 * @author 80645973
 * @param <getIpAdress>
 * @since 20190326
 * 
 */

public class DeallocateRepository extends GenericRepository {

	public static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	public String getIpAddress(String desiginadorBandaLarga) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Buscando o IP  na tabela GVT_NC_TNET_IP_CUSTOMER ");

		String result = null;

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT IP_ADDRESS IP ");
		sql.append(" FROM " + RADIUS_SCHEMA + ".GVT_NC_TNET_IP_CUSTOMER ");
		sql.append(" WHERE DESIGNATOR LIKE  ?  ");

		try {

			if (desiginadorBandaLarga != null && !desiginadorBandaLarga.trim().isEmpty()) {

				Query query;

				query = getFactory().createNativeQuery(sql.toString());

				query.setParameter(1, desiginadorBandaLarga);
				
				List<String> resultList = query.getResultList();
				
				if (resultList != null) {
					
					for (String radiusIP : resultList) {
						result = radiusIP;
						break;
					}
				}

			} else {
				logger.log(OSSLogger.ERROR, "O valor do campo DESIGNATOR eh Vazio ou Nulo");
				throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_001.getDescription(),
						ExceptionInfoEnum.RIRADIUS_001.getCode(),
						String.format(ExceptionInfoEnum.RIRADIUS_001.getMessage(),
								"O valor do campo  DESIGNATOR eh Vazio ou Nulo"));
			}
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {

			logger.log(OSSLogger.ERROR, "Erro ao buscar IP_ADRESS na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", ((Throwable) e).getMessage()));

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Erro ao buscar IP_ADRESS  na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));

		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Erro ao buscar IP_ADRESS na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_999.getDescription(),
					ExceptionInfoEnum.RIRADIUS_999.getCode(), e.getMessage());
		}
		return result;
	}

	public void deallocateIpAddress(String ipAddress) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Atualizando o RELEASE_DATE  na tabela TNETPRO_POOL ");

		StringBuilder sql = new StringBuilder();
		sql.append(	" UPDATE " + RADIUS_SCHEMA + ".TNETPRO_POOL SET RELEASE_DATE = SYSDATE + 90  WHERE IPADDRESS LIKE ? ");

		try {
			Query query;

			query = getFactory().createNativeQuery(sql.toString());

			query.setParameter(1, ipAddress);

			query.executeUpdate();

		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar RELEASE_DATE na tabela TNETPRO_POOL");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar RELEASE_DATE na tabela TNETPRO_POOL");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));

		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar RELEASE_DATE na tabela TNETPRO_POOL");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_999.getDescription(),
					ExceptionInfoEnum.RIRADIUS_999.getCode(), e.getMessage());
		}

	}

	public void deallocateDesignador(String designadorAcesso) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Exclusão de designador  na tabela GVT_NC_TNET_IP_CUSTOMER");

		StringBuilder sql = new StringBuilder();

		sql.append(" DELETE FROM " + RADIUS_SCHEMA + ".GVT_NC_TNET_IP_CUSTOMER ");

		sql.append(" WHERE DESIGNATOR LIKE ? ");

		try {
			Query query;
			query = getFactory().createNativeQuery(sql.toString());

			query.setParameter(1, designadorAcesso);

			query.executeUpdate();

		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			logger.log(OSSLogger.ERROR, "Erro ao excluir registro na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Erro ao excluir registro na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));

		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Erro ao excluir registro na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_999.getDescription(),
					ExceptionInfoEnum.RIRADIUS_999.getCode(), e.getMessage());
		}

	}

}
