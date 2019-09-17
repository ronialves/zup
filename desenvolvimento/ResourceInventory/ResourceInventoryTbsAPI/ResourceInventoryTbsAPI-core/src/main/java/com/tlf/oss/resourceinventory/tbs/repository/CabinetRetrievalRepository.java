package com.tlf.oss.resourceinventory.tbs.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.StoredProcedureQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.Equipment;
import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.core.utils.Constants;
import com.tlf.oss.resourceinventory.tbs.entity.CabinetRetrievalEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.factory.GenericRepository;

/**
 * REC2164-44-RI | REC3164-223
 * 
 * @project IONIX-SIGITM
 * @author 80629552
 * @since 20190328
 */
public class CabinetRetrievalRepository extends GenericRepository {

	private static final long serialVersionUID = -8033484033628300825L;

	@Inject
	private OSSLogger logger;
	
	private static final String STATE_OR_PROVINCE = "stateOrProvince";
    private static final String CNL_ACRONYM = "cnlAcronym";
	private static final String MICROAREA = "microarea"; 
	
	private final String PROC_GET_ARVORE = "ASAP.TLF_SP_SIGITM_GET_ARVORE";
	private final String PROC_GET_LOCALIDADE = "ASAP.TLF_SP_SIGITM_GET_LOCALIDADE";
	private final String PROC_GET_TRONCO = "ASAP.TLF_SP_SIGITM_GET_TRONCO";
	
	/**
	 * Executa Procedure para consultar equipamentos no TBS
	 * 
	 * @param entity
	 * @return {@link ResourceInventoryEntity}
	 * @throws OSSBusinessException 
	 */
	@SuppressWarnings("unchecked")
	public ResourceInventoryEntity getCabinetByLocation(ResourceInventoryEntity entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, this.getClass().getName() + " -  executando procedure " + PROC_GET_LOCALIDADE);
		
		List<CabinetRetrievalEntity> resultList = null;
		Integer codRetorno = null;
		String msgRetorno = "";
		
		try {
			
			StoredProcedureQuery procedureQuery = getFactory().createStoredProcedureQuery(PROC_GET_LOCALIDADE);
			
			procedureQuery.registerStoredProcedureParameter("P_STATE_CODE", String.class, ParameterMode.IN);
			procedureQuery.registerStoredProcedureParameter("P_CNL", String.class, ParameterMode.IN);
            procedureQuery.registerStoredProcedureParameter("P_SITE", String.class, ParameterMode.IN);
            procedureQuery.registerStoredProcedureParameter("CUR1", void.class, ParameterMode.REF_CURSOR);
            procedureQuery.registerStoredProcedureParameter("P_COD_RETORNO", Integer.class, ParameterMode.OUT);
            procedureQuery.registerStoredProcedureParameter("P_MSG_RETORNO", String.class, ParameterMode.OUT);
            
            String stateOrProvince = getParamValue(entity, Constants.NETWORK_OWNER_VIVO2, STATE_OR_PROVINCE);
			String cnl = getParamValue(entity, Constants.NETWORK_OWNER_VIVO2, CNL_ACRONYM);
			String microArea = getParamValue(entity, Constants.NETWORK_OWNER_VIVO2, MICROAREA);
            
			procedureQuery.setParameter("P_STATE_CODE", stateOrProvince);
			procedureQuery.setParameter("P_CNL", cnl);
			procedureQuery.setParameter("P_SITE", microArea);
			
            procedureQuery.execute();
            
            resultList = castToCabinetRetrievalEntity((List<Object[]>) procedureQuery.getOutputParameterValue("CUR1"));
			codRetorno = (Integer) procedureQuery.getOutputParameterValue("P_COD_RETORNO");
			msgRetorno = (String) procedureQuery.getOutputParameterValue("P_MSG_RETORNO");
						
    		logger.log(OSSLogger.INFO, this.getClass().getName() + " -  procedure "+ PROC_GET_LOCALIDADE + " executada com sucesso");			
		
			
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_SIGITM_GET_LOCATION no TBS", e.getMessage()));

		} catch (PersistenceException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_SIGITM_GET_LOCATION no TBS", e.getMessage()));

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_999.getDescription(),
					ExceptionInfoEnum.RITBS_999.getCode(), e.getMessage());
		}

		return equipmentMapper(entity, codRetorno, msgRetorno, resultList);
	}
		
	
	private List<CabinetRetrievalEntity> castToCabinetRetrievalEntity(List<Object[]> list) {
		List<CabinetRetrievalEntity> result = new ArrayList<>();
		
		for (Object[] procResult : list) {
			CabinetRetrievalEntity entity = new CabinetRetrievalEntity();		
			entity.setClliCode(objectToString(procResult[2]));
			entity.setLocationName(objectToString(procResult[3]));
			entity.setLocationType(objectToString(procResult[4]));			
			entity.setLocationId(objectToString(procResult[5]));
			
			result.add(entity);
		}
		
		return result;
	}	
		

	/**
	 * Executa Procedure para consultar os ids dos equipamentos
	 * 
	 * @param entity
	 * @return {@link ResourceInventoryEntity}
	 * @throws OSSBusinessException 
	 */
	@SuppressWarnings("unchecked")
	public ResourceInventoryEntity getEquipmentTrunk(ResourceInventoryEntity entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, this.getClass().getName() + " -  executando procedure " + PROC_GET_TRONCO);
		
		List<CabinetRetrievalEntity> resultList = null;
		Integer codRetorno = null;
		String msgRetorno = "";
		
		try {
			
			StoredProcedureQuery procedureQuery = getFactory().createStoredProcedureQuery(PROC_GET_TRONCO);
			
			procedureQuery.registerStoredProcedureParameter("P_STATE_CODE", String.class, ParameterMode.IN);
			procedureQuery.registerStoredProcedureParameter("P_CNL", String.class, ParameterMode.IN);
            procedureQuery.registerStoredProcedureParameter("P_CLLI_CODE", String.class, ParameterMode.IN);
            procedureQuery.registerStoredProcedureParameter("CUR1", void.class, ParameterMode.REF_CURSOR);
            procedureQuery.registerStoredProcedureParameter("P_COD_RETORNO", Integer.class, ParameterMode.OUT);
            procedureQuery.registerStoredProcedureParameter("P_MSG_RETORNO", String.class, ParameterMode.OUT);
						
			String stateOrProvince = getParamValue(entity, Constants.NETWORK_OWNER_VIVO2, STATE_OR_PROVINCE);
			String cnl = getParamValue(entity, Constants.NETWORK_OWNER_VIVO2, CNL_ACRONYM);
			String name = getParamValue(entity, Constants.EQUIPMENT, Constants.HOSTNAME);
			
			procedureQuery.setParameter("P_STATE_CODE", stateOrProvince);
			procedureQuery.setParameter("P_CNL", cnl);
			procedureQuery.setParameter("P_CLLI_CODE", name);
			
			procedureQuery.execute();
			
			resultList = castToCabinetRetrievalEntityTrunk((List<Object[]>) procedureQuery.getOutputParameterValue("CUR1"));
			codRetorno = (Integer) procedureQuery.getOutputParameterValue("P_COD_RETORNO");
			msgRetorno = (String) procedureQuery.getOutputParameterValue("P_MSG_RETORNO");
						
    		logger.log(OSSLogger.INFO, this.getClass().getName() + " -  procedure "+ PROC_GET_TRONCO + " executada com sucesso");			
			
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_SIGITM_GET_TRONCO no TBS", e.getMessage()));

		} catch (PersistenceException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_SIGITM_GET_TRONCO no TBS", e.getMessage()));

		} catch (Exception e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_999.getDescription(),
					ExceptionInfoEnum.RITBS_999.getCode(), e.getMessage());
		}

		return equipmentTrunkMapper(entity, codRetorno, msgRetorno, resultList);
	}
	
	private List<CabinetRetrievalEntity> castToCabinetRetrievalEntityTrunk(List<Object[]> list) {
		List<CabinetRetrievalEntity> result = new ArrayList<>();
		
		for (Object[] procResult : list) {
			CabinetRetrievalEntity entity = new CabinetRetrievalEntity();
			entity.setEquipmentId(objecToInteger(procResult[6]));
			
			result.add(entity);
		}
		
		return result;
	}	
	
	/**
	 * Executa Procedure para consultar as informacoes dos equipamentos
	 * 
	 * @param entity
	 * @return {@link ResourceInventoryEntity}
	 * @throws OSSBusinessException 
	 */
	@SuppressWarnings("unchecked")
	public List<PortAdapterCard> getEquipmentTree(Equipment entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "CabinetRetrievalDao - getEquipmentTree - Iniciando chamada a Procedure do TBS.");
		
		List<CabinetRetrievalEntity> resultList = null;
		Integer codRetorno = null;
		String msgRetorno = "";
		
		try {
			
			StoredProcedureQuery procedureQuery = getFactory().createStoredProcedureQuery(PROC_GET_ARVORE);
			
			procedureQuery.registerStoredProcedureParameter("P_EQUIPMENT_ID", Integer.class, ParameterMode.IN);
			procedureQuery.registerStoredProcedureParameter("P_FUSION", String.class, ParameterMode.IN);
            procedureQuery.registerStoredProcedureParameter("CUR1", void.class, ParameterMode.REF_CURSOR);
            procedureQuery.registerStoredProcedureParameter("P_COD_RETORNO", Integer.class, ParameterMode.OUT);
            procedureQuery.registerStoredProcedureParameter("P_MSG_RETORNO", String.class, ParameterMode.OUT);
									
			procedureQuery.setParameter("P_EQUIPMENT_ID", Integer.valueOf(entity.getId()));
			procedureQuery.setParameter("P_FUSION", null);
			
			procedureQuery.execute();
						
			resultList = castToCabinetRetrievalEntityTree((List<Object[]>) procedureQuery.getOutputParameterValue("CUR1"));
			codRetorno = (Integer) procedureQuery.getOutputParameterValue("P_COD_RETORNO");
			msgRetorno = (String) procedureQuery.getOutputParameterValue("P_MSG_RETORNO");
			
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_SIGITM_GET_ARVORE no TBS", e.getMessage()));

		} catch (PersistenceException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_SIGITM_GET_ARVORE no TBS", e.getMessage()));

		} catch (Exception e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_999.getDescription(),
					ExceptionInfoEnum.RITBS_999.getCode(), e.getMessage());
		}

		return equipmentTreeMapper(codRetorno, msgRetorno, resultList);
	}
	
	private List<CabinetRetrievalEntity> castToCabinetRetrievalEntityTree(List<Object[]> list) {
		
		List<CabinetRetrievalEntity> result = new ArrayList<>();
		
		for (Object[] procResult : list) {
			CabinetRetrievalEntity cabinetRetrievalEntity = new CabinetRetrievalEntity();
			cabinetRetrievalEntity.setMountingPositionNumber(objectToString(procResult[2]));
			cabinetRetrievalEntity.setEquipspecType(objectToString(procResult[3]));
			cabinetRetrievalEntity.setEquipmentAcronym(objectToString(procResult[4]));
			cabinetRetrievalEntity.setVendorName(objectToString(procResult[5]));
			cabinetRetrievalEntity.setEquipmentName(objectToString(procResult[6]));
			cabinetRetrievalEntity.setNotes(objectToString(procResult[7]));
			cabinetRetrievalEntity.setEquipmentIdPai(objecToInteger(procResult[9]));
			cabinetRetrievalEntity.setEquipmentIdFilho(objecToInteger(procResult[10]));
			
			result.add(cabinetRetrievalEntity);
		}	
		
		return result;
	}

	private Integer objecToInteger(Object in) {
		Integer result = 0;
		if (in != null) {
			result = Integer.parseInt(in.toString());
		}
		return result;
	}
	
	private String objectToString(Object in) {
		String result = "";
		if (in != null ) {
			result = String.valueOf(in);
		}
		return result;
	}
	
	/**
	 * Método responsável pelo mapeamento das informações do Cabinet.
	 * 
	 * @param entity
	 * @param resultQuery
	 * @return {@link ResourceInventoryEntity}
	 */
	private ResourceInventoryEntity equipmentMapper(ResourceInventoryEntity entity, Integer codRetorno, String msgRetorno, List<CabinetRetrievalEntity> resultQuery) {
		
		if(resultQuery != null && !resultQuery.isEmpty()) {
			
			List<Equipment> equipments = new ArrayList<Equipment>();
			
			for (CabinetRetrievalEntity resultEquipment : resultQuery) {
				
				Equipment equipment = new Equipment();
				
				if(resultEquipment.getClliCode() != null) {
					equipment.setName(resultEquipment.getClliCode());
				}				
				if(resultEquipment.getLocationName() != null) {
					equipment.setLocation(resultEquipment.getLocationName());
				}
				if(resultEquipment.getLocationType() != null) {
					equipment.setTypeOfResource(resultEquipment.getLocationType());
				}
				if(resultEquipment.getLocationId() != null) {
					equipment.setId(resultEquipment.getLocationId());
				}
				
				equipment.setOrigin(Constants.TBS);						
				equipments.add(equipment);
			}
			
			entity.setEquipment(equipments);
		} 

		entity.setCodeReturn(codRetorno);
		entity.setMessageReturn(msgRetorno);
		
		return entity;
	}
	
	/**
	 * Método responsável pelo mapeamento dos Ids dos Equipamentos.
	 * 
	 * @param resultQuery
	 * @return {@link Equipment}
	 */
	private ResourceInventoryEntity equipmentTrunkMapper(ResourceInventoryEntity entity, Integer codRetorno, String msgRetorno, List<CabinetRetrievalEntity> resultQuery) {
		
		if(resultQuery != null && !resultQuery.isEmpty()) {
			
			List<Equipment> equipments = new ArrayList<Equipment>();
			
			for (CabinetRetrievalEntity resultEquipment : resultQuery) {
				
				Equipment equipment = new Equipment();
				
				if (resultEquipment.getEquipmentId() != null)
					equipment.setId(resultEquipment.getEquipmentId().toString());
				
				equipments.add(equipment);
			}
			
			entity.setEquipment(equipments);
			
		}
		
		entity.setCodeReturn(codRetorno);
		entity.setMessageReturn(msgRetorno);
		
		return entity;
	}
	
	/**
	 * Método responsável pelo mapeamento das informações dos Equipamentos.
	 * @param msgRetorno 
	 * @param codRetorno 
	 * 
	 * @param resultQuery
	 * @return {@link Equipment}
	 */
	private List<PortAdapterCard> equipmentTreeMapper(Integer codRetorno, String msgRetorno, List<CabinetRetrievalEntity> resultQuery) {
		
		if(resultQuery != null && !resultQuery.isEmpty()) {
				
			List<PortAdapterCard> adapterCards = new ArrayList<PortAdapterCard>();
			
			for (CabinetRetrievalEntity resultEquipment : resultQuery) {
				
				PortAdapterCard adapterCard = new PortAdapterCard();
				PhysicalResource physicalResource = new PhysicalResource();
				
				if (resultEquipment.getMountingPositionNumber() != null)
					adapterCard.setSlot(resultEquipment.getMountingPositionNumber());
				
				if (resultEquipment.getEquipspecType() != null) {
					physicalResource.setTypeOfResource(resultEquipment.getEquipspecType());
					adapterCard.setPhysicalResource(physicalResource);
				}
				
				if (resultEquipment.getEquipmentAcronym() != null)
					adapterCard.setModel(resultEquipment.getEquipmentAcronym());
				
				if (resultEquipment.getVendorName() != null)
					adapterCard.setVendor(resultEquipment.getVendorName());
				
				if (resultEquipment.getEquipmentName() != null)
					adapterCard.setName(resultEquipment.getEquipmentName());
				
				if (resultEquipment.getNotes() != null)
					adapterCard.setNotes(resultEquipment.getNotes());
				
				if (resultEquipment.getEquipmentIdPai() != null)
					adapterCard.setSlotId(resultEquipment.getEquipmentIdPai().toString());
				
				if (resultEquipment.getEquipmentIdFilho() != null)
					adapterCard.setSubSlotId(resultEquipment.getEquipmentIdFilho().toString());
										
				adapterCards.add(adapterCard);
			}
						
			return adapterCards;
		}
		
		return null;
	}
	
	
	/**
	 * Retorna o valor do Parâmetro do ServiceDescribedBy.
	 * 
	 * @param entity
	 * @param networkOwner
	 * @param paramName
	 * @return
	 */
	private String getParamValue(ResourceInventoryEntity entity, String networkOwner, String paramName) {
		
		for (ServiceDescribedBy sdb : entity.getResourceFacingService().getServiceDescribedBy()) {			
			if (networkOwner.equalsIgnoreCase(sdb.getName())) {				
				for (ServiceSpecCharDescribes sscd : sdb.getServiceSpecCharDescribes()) {					
					if (paramName.equalsIgnoreCase(sscd.getValueType())) {
						logger.log(OSSLogger.INFO, "CabinetRetrievalRepository - getParamValue - " + paramName + " : " + sscd.getValue());
						return sscd.getValue();
					}					
				}
			}
		}
		
		return null;
	}
	
}
