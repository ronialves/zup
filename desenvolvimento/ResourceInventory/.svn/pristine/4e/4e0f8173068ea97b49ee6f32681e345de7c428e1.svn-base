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
 * REC3635-1110 | REC3635-2042
 * 
 * @project Fusion
 * @author 80629552
 * @since 20190325
 */
public class AllocateRepository extends GenericRepository{

	private static final long serialVersionUID = 6180885890567189585L;
	
	@Inject
	private OSSLogger logger;
	
	public String getShastaCity(String desiginadorAcesso) throws OSSBusinessException {
		
		logger.log(OSSLogger.INFO, "Buscando o CNL do shasta city na tabela TNETPRO_POOL");
		
		String result = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DECODE(MAX(SHASTA_CITY), NULL, 'RJO', MAX(SHASTA_CITY)) ");
		sql.append(" FROM " +RADIUS_SCHEMA +".TNETPRO_POOL ");
		sql.append(" WHERE SHASTA_CITY = ? ");
		sql.append(" AND (RELEASE_DATE < SYSDATE OR RELEASE_DATE IS NULL) ");
		sql.append(" AND ROWNUM = 1 ");
		
		try {
			
			if (desiginadorAcesso != null && !desiginadorAcesso.trim().isEmpty()) {
				String designador = desiginadorAcesso.substring(0, 3);
				
				Query query;
				query = getFactory().createNativeQuery(sql.toString());
				
				query.setParameter(1, designador);
				
				result = (String) query.getSingleResult();				
			}else{
				logger.log(OSSLogger.ERROR, "O valor do campo SERVICE_ID eh Vazio ou Nulo");
				throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_001.getDescription(),
						ExceptionInfoEnum.RIRADIUS_001.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_001.getMessage(),
								"O valor do campo SERVICE_ID eh Vazio ou Nulo"));
			}
			
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			logger.log(OSSLogger.ERROR, "Erro ao buscar SHASTA_CITY na tabela TNETPRO_POOL");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Erro ao buscar SHASTA_CITY na tabela TNETPRO_POOL");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));	
	
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Erro ao buscar SHASTA_CITY na tabela TNETPRO_POOL");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_999.getDescription(),
					ExceptionInfoEnum.RIRADIUS_999.getCode(), e.getMessage());		
		}
		
		return result;
	}
	
	public String getIpAddress(String desiginadorAcesso, String shastaCity) throws OSSBusinessException {
		
		logger.log(OSSLogger.INFO, "Buscando ip fixo para o designador, ou proximo ip livre");
		
		String result = null;
		
		StringBuilder sql = new StringBuilder();		
		sql.append(" SELECT IP AS IPADDRESSFIXO ");
		sql.append(" FROM ( SELECT IP_ADDRESS IP, 1 SEQ ");
		sql.append("         FROM " +RADIUS_SCHEMA +".GVT_NC_TNET_IP_CUSTOMER ");
		sql.append("         WHERE DESIGNATOR LIKE ? ");
		sql.append(" UNION ");
		sql.append("     SELECT IPADDRESS IP, 2 SEQ ");
		sql.append("     FROM " +RADIUS_SCHEMA +".TNETPRO_POOL ");
		sql.append("     WHERE SHASTA_CITY = ? AND (RELEASE_DATE < SYSDATE OR RELEASE_DATE IS NULL) AND ROWNUM = 1 ");
		sql.append("         ORDER BY SEQ ) ");
		sql.append(" WHERE IP IS NOT NULL AND ROWNUM = 1 ");
		
		try {
			
			Query query;
			query = getFactory().createNativeQuery(sql.toString());
			
			query.setParameter(1, desiginadorAcesso);
			query.setParameter(2, shastaCity);

			result = (String) query.getSingleResult();
			
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			logger.log(OSSLogger.ERROR, "Erro ao buscar Ip_Address ");
				throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
						ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
								"Erro ao executar Query no Radius", e.getMessage()));

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Erro ao buscar Ip_Address ");
				throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
						ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
								"Erro ao executar Query no Radius", e.getMessage()));	
				
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Erro ao buscar Ip_Address ");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_999.getDescription(),
					ExceptionInfoEnum.RIRADIUS_999.getCode(), e.getMessage());		
			
		}
		
		return result;
	}
	
	public void allocateIp(String ipAddress) throws OSSBusinessException {
		
		logger.log(OSSLogger.INFO, "Alocando ip na tabela TNETPRO_POOL");
				
		StringBuilder sql = new StringBuilder();		
		sql.append(" UPDATE " +RADIUS_SCHEMA +".TNETPRO_POOL SET RELEASE_DATE = to_date('31/12/2099','DD/MM/YYYY') WHERE IPADDRESS = ? ");
		
		try {
			
			Query query;
			query = getFactory().createNativeQuery(sql.toString());
			
			query.setParameter(1, ipAddress);

			query.executeUpdate();
			
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar Ip na tabela TNETPRO_POOL");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar Ip na tabela TNETPRO_POOL");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));	
	
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar Ip na tabela TNETPRO_POOL");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_999.getDescription(),
					ExceptionInfoEnum.RIRADIUS_999.getCode(), e.getMessage());				
		}

	}
	
	public void allocateIpToDesignator(String ipAddress, String designadorAcesso) throws OSSBusinessException {
		
		logger.log(OSSLogger.INFO, "Alocando ip ao designador na tabela GVT_NC_TNET_IP_CUSTOMER");
				
		StringBuilder sql = new StringBuilder();		
		sql.append(" INSERT INTO " +RADIUS_SCHEMA +".GVT_NC_TNET_IP_CUSTOMER ");
		sql.append(" (DESIGNATOR, IP_STATUS, IP_ADDRESS, ACTIVATION_DATE, LAST_MODIFIED_USERID, LAST_MODIFIED_DATE) ");
		sql.append(" VALUES ");
		sql.append(" (?, 'A', ?, SYSDATE, 'NEC_RADIUS', SYSDATE) ");
				
		try {
			
			Query query;
			query = getFactory().createNativeQuery(sql.toString());
			
			query.setParameter(1, designadorAcesso);
			query.setParameter(2, ipAddress);

			query.executeUpdate();
			
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar Ip ao Designador na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar Ip ao Designador na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));	
			
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar Ip ao Designador na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_999.getDescription(),
					ExceptionInfoEnum.RIRADIUS_999.getCode(), e.getMessage());			
		}

	}
	
	public void allocateUpdateIpToDesignator(String ipAddress, String designadorAcesso) throws OSSBusinessException {
		
		logger.log(OSSLogger.INFO, "Alocando ip ao designador na tabela GVT_NC_TNET_IP_CUSTOMER");
				
		StringBuilder sql = new StringBuilder();		
		sql.append(" UPDATE " +RADIUS_SCHEMA +".GVT_NC_TNET_IP_CUSTOMER ");
		sql.append(" SET IP_ADDRESS = ? , LAST_MODIFIED_USERID = 'NEC_RADIUS' , LAST_MODIFIED_DATE = SYSDATE ");
		sql.append(" WHERE DESIGNATOR = ? ");
		sql.append(" AND IP_STATUS = 'A' ");
				
		try {
			
			Query query;
			query = getFactory().createNativeQuery(sql.toString());
			
			query.setParameter(1, ipAddress);
			query.setParameter(2, designadorAcesso);

			query.executeUpdate();
			
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar Ip ao Designador na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar Ip ao Designador na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));	
			
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Erro ao alocar Ip ao Designador na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_999.getDescription(),
					ExceptionInfoEnum.RIRADIUS_999.getCode(), e.getMessage());			
		}

	}
	
	public boolean checkAllocateIpToDesignator(String designadorAcesso, String ipAddress) throws OSSBusinessException{
		
		logger.log(OSSLogger.INFO, "Verificando alocação na tabela GVT_NC_TNET_IP_CUSTOMER por DESIGNATOR: '" +designadorAcesso +"' e IP_ADDRESS: '" +ipAddress +"'");
		
		boolean checkIpTodesignator = false;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DESIGNATOR, IP_STATUS, IP_ADDRESS ");
		sql.append(" FROM " +RADIUS_SCHEMA +".GVT_NC_TNET_IP_CUSTOMER ");
		sql.append(" WHERE DESIGNATOR LIKE ? AND IP_STATUS = 'A' ");
		
		try {
			
			Query query;
			query = getFactory().createNativeQuery(sql.toString());
			
			query.setParameter(1, designadorAcesso);

			List<Object[]> object = query.getResultList();
			
			if(object != null && !object.isEmpty()){
				
				String ip = object.get(0)[2] != null ? String.valueOf(object.get(0)[2]) : null;
				
				if (ip != null && !ip.equals(ipAddress)) {
					logger.log(OSSLogger.ERROR, "Erro IP_ADDRESS: '" +ip +"' na Tabela GVT_NC_TNET_IP_CUSTOMER ja alocado.");
					throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_004.getDescription(),
							ExceptionInfoEnum.RIRADIUS_004.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_004.getMessage(),
									"Erro IP_ADDRESS: '" +ip +"' na Tabela GVT_NC_TNET_IP_CUSTOMER ja alocado."));
				}
				
				checkIpTodesignator = true;
			}
			
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			logger.log(OSSLogger.ERROR, "Erro ao consultar registro na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Erro ao consultar registro na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_002.getDescription(),
					ExceptionInfoEnum.RIRADIUS_002.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro ao executar Query no Radius", e.getMessage()));	
			
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Erro ao consultar registro na tabela GVT_NC_TNET_IP_CUSTOMER");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_999.getDescription(),
					ExceptionInfoEnum.RIRADIUS_999.getCode(), e.getMessage());			
		}
		
		return checkIpTodesignator;
	}
	
}
