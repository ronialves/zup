package com.tlf.oss.resourceinventory.sagre.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.sagre.entity.DetermineAvailabilityEntity;
import com.tlf.oss.resourceinventory.sagre.entity.DetermineDistanceEntity;
import com.tlf.oss.resourceinventory.sagre.entity.DetermineResourceAvailabilityMetallic;
import com.tlf.oss.resourceinventory.sagre.repository.factory.GenericRepository;


@SuppressWarnings("serial")
public class DetermineAvailabilityRepository extends GenericRepository implements Serializable {

	@PersistenceContext(name="SagreDS")
	EntityManager factory;

	@Inject
	protected OSSLogger logger;
	
	public DetermineAvailabilityEntity getDetermineAvailability(DetermineAvailabilityEntity entity)
			throws OSSBusinessException {
		DetermineAvailabilityEntity result = new DetermineAvailabilityEntity();
		getFactory().getEntityManagerFactory().getCache().evict(DetermineAvailabilityEntity.class);

		try {
			TypedQuery<DetermineAvailabilityEntity> query;
			query = getFactory().createNamedQuery("determineAvailability", DetermineAvailabilityEntity.class);

			query.setParameter("p_in_cnl", entity.getCnl());
			query.setParameter("p_in_street_code", entity.getStreetCode());
			query.setParameter("p_in_address_num", entity.getStreetNumber());
			query.setParameter("p_out_status", entity.getStatus());
			query.setParameter("p_out_fail_diag", entity.getFailDiag());
			query.setParameter("p_out_bloqueio_endereco", entity.getBlockageAddress());
			query.setParameter("p_out_tecnology", entity.getTechnology());
			query.setParameter("p_out_estacao_telefonica", entity.getStation());
			query.setParameter("p_out_ident_equip1", entity.getIdentEquip1());
			query.setParameter("p_out_ident_equip2", entity.getIdentEquip2());
			query.setParameter("p_out_bloqueio_equipamento", entity.getBlockageEquipment());
			query.setParameter("p_out_razao_bloqueio_eqpto", entity.getBlockageReason());
			query.setParameter("p_out_equipment_type", entity.getEquipmentType());
			query.setParameter("p_out_qtd_fibras", entity.getQuantityPort());
			query.setParameter("p_out_switch", entity.getSwitchName());
			query.setParameter("p_out_compartilhamento", entity.getShare());
			query.setParameter("p_out_armario_optico", entity.getCabinetName());
			query.setParameter("p_out_tipo_cobertura", entity.getTypeCoverage());
			query.setParameter("p_out_cod", entity.getReturnCode());
			query.setParameter("p_out_msg", entity.getMessage());

			logIn(query);
			
			logger.log(OSSLogger.INFO, query.getParameters().toString());

			result = query.getSingleResult();

			logOut(result);
		} catch (Exception e) {
			result.getResult().setCode("10");
			result.getResult().setDescription(e.getMessage());
		}

		return result;
	}
	
	public DetermineDistanceEntity getDistance(DetermineDistanceEntity entity)
			throws OSSBusinessException {

		DetermineDistanceEntity queryResult = new DetermineDistanceEntity();
		getFactory().getEntityManagerFactory().getCache().evict(DetermineDistanceEntity.class);
		
		try {
			TypedQuery<DetermineDistanceEntity> query;
			query = getFactory().createNamedQuery("determineDistance", DetermineDistanceEntity.class);

			query.setParameter("p_in_cnl", entity.getCnl());
			query.setParameter("p_in_street_code", entity.getStreetCode());
			query.setParameter("p_in_address_num", entity.getStreetNumber());
			query.setParameter("p_in_ident_equip1", entity.getCabinetId());
			query.setParameter("p_in_ident_equip2",  entity.getTerminalBoxId());
			query.setParameter("p_in_origem", Constants.RESOURCE_INVENTORY_ORIGEM);
			query.setParameter("p_out_distancia", entity.getDistance());			
			query.setParameter("p_out_cod", entity.getCode());
			query.setParameter("p_out_msg", entity.getMessage());
			
			logIn(query);
			
			logger.log(OSSLogger.INFO, query.getParameters().toString());

			queryResult = query.getSingleResult();

			logOutDistance(queryResult);
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getCause());
		}

		return queryResult;
	}
	
	/**
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	public DetermineResourceAvailabilityMetallic getDetermineAvailabilityMetallic(DetermineResourceAvailabilityMetallic entity)
			throws OSSBusinessException {
	
		DetermineResourceAvailabilityMetallic result = new DetermineResourceAvailabilityMetallic();
		
		getFactory().getEntityManagerFactory().getCache().evict(DetermineResourceAvailabilityMetallic.class);
		
		try {
			TypedQuery<DetermineResourceAvailabilityMetallic> query;
			query = getFactory().createNamedQuery("determineResourceAvailabilityMetallic", DetermineResourceAvailabilityMetallic.class);

			query.setParameter("p_in_cnl", entity.getCnl());
			query.setParameter("p_in_street_code", entity.getStreetCode());
			query.setParameter("p_in_address_num", entity.getAddressNum());
			query.setParameter("p_out_status", entity.getStatus());
			query.setParameter("p_out_fail_diag", entity.getFailDiag());
			query.setParameter("p_out_bloqueio_endereco", entity.getBlockageAddress());
			query.setParameter("p_out_tecnology", entity.getTechnology());
			query.setParameter("p_out_estacao_telefonica", entity.getEstacaoTelefonica());
			query.setParameter("p_out_ident_equip1", entity.getIdentEquip1());
			query.setParameter("p_out_ident_equip2", entity.getIdentEquip2());
			query.setParameter("p_out_bloqueio_equipamento", entity.getBlockageEquipment());
			query.setParameter("p_out_razao_bloqueio_eqpto", entity.getRazaoBloqueio());
			query.setParameter("p_out_shadow", entity.getShadow());
			query.setParameter("p_out_equipment_type", entity.getEquipmentType());
			query.setParameter("p_out_qtd_pares", entity.getQtdPares());
			query.setParameter("p_out_switch", entity.getSwitchName());
			query.setParameter("p_out_compartilhamento", entity.getCompartilhamento());
			query.setParameter("p_out_armario_optico", entity.getArmarioOptico());
			query.setParameter("p_out_armario_metalico", entity.getArmarioMetalico());
			query.setParameter("p_out_cod", entity.getReturnCode());
			query.setParameter("p_out_msg", entity.getMessage());

			logInMetallic(query);
			
			logger.log(OSSLogger.INFO, query.getParameters().toString());

			result = query.getSingleResult();

			logOutMetalic(result);
			
		} catch (Exception e) {
			result.getResult().setCode("10");
			result.getResult().setDescription(e.getMessage());
		}

		return result;
	}

	private void logIn(Query query) {
		String log = getlogIn("SAGREMAN.GVT_SP_SOA_CONS_COB_FIBRA", query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logInMetallic(Query query) {
		String log = getlogIn("SAGREMAN.GVT_SP_SOA_CONSULTA_COBERTURA", query);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(DetermineAvailabilityEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_out_cod = ").append(result.getReturnCode()).append("p_out_msg = ")
				.append(result.getMessage()).toString();
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOutMetalic(DetermineResourceAvailabilityMetallic result) {
		String log = new StringBuilder("Param OUT: ").append("p_out_cod = ").append(result.getReturnCode()).append("p_out_msg = ")
				.append(result.getMessage()).toString();
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOutDistance(DetermineDistanceEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_out_cod = ").append(result.getCode()).append("p_out_msg = ")
				.append(result.getMessage()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}