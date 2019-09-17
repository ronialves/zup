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

public class RetrieveRepository extends GenericRepository {

	public static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	public String getIpAddress(String designadorBandaLarga) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Buscando o IP  na tabela GVT_NC_TNET_IP_CUSTOMER ");

		String result = null;

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT IP_ADDRESS IP ");
		sql.append(" FROM " + RADIUS_SCHEMA + ".GVT_NC_TNET_IP_CUSTOMER ");
		sql.append(" WHERE DESIGNATOR LIKE  ?  AND IP_STATUS = 'A'");

		try {
			if (designadorBandaLarga != null && !designadorBandaLarga.trim().isEmpty()) {
				Query query = getFactory().createNativeQuery(sql.toString());
				query.setParameter(1, designadorBandaLarga);
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
}