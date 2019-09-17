package com.tlf.oss.resourceinventory.tbs.repository;

import java.io.Serializable;
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
import com.tlf.oss.resourceinventory.tbs.entity.DetermineAvailabilityEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.factory.GenericRepository;

@SuppressWarnings("serial")
public class DetermineAvailabilityRepository extends GenericRepository implements Serializable {

	@Inject
	protected OSSLogger logger;
	
	private final String PROC_NAME = "ASAP.TLF_SP_DETERMINE_AVAILABILITY";
	
	@SuppressWarnings("unchecked")
	public List<DetermineAvailabilityEntity> determineAvailability(DetermineAvailabilityEntity entity) throws OSSBusinessException {
		List<DetermineAvailabilityEntity> resultList = null;
		logger.log(OSSLogger.INFO, this.getClass().getName() + " -  executando procedure " + PROC_NAME);

		try {
			
			StoredProcedureQuery procedureQuery = getFactory().createStoredProcedureQuery(PROC_NAME);

			procedureQuery.registerStoredProcedureParameter("P_ARMARIO", String.class, ParameterMode.IN);
			procedureQuery.registerStoredProcedureParameter("P_TELEFONE", String.class, ParameterMode.IN);
            procedureQuery.registerStoredProcedureParameter("P_PROTOCOLO", String.class, ParameterMode.IN);
            procedureQuery.registerStoredProcedureParameter("P_SWITCH", String.class, ParameterMode.IN);
            procedureQuery.registerStoredProcedureParameter("CUR1", void.class, ParameterMode.REF_CURSOR);
            procedureQuery.registerStoredProcedureParameter("P_COD_RETORNO", Integer.class, ParameterMode.OUT);
            procedureQuery.registerStoredProcedureParameter("P_MSG_RETORNO", String.class, ParameterMode.OUT);
            
            procedureQuery.setParameter("P_ARMARIO", entity.getCabinet());
            procedureQuery.setParameter("P_TELEFONE", entity.getTelephoneNumber());
            procedureQuery.setParameter("P_PROTOCOLO", null);
            procedureQuery.setParameter("P_SWITCH", entity.getPSwitch());
            
            procedureQuery.execute();
            
			resultList = castToDetermineAvailabilityEntity((List<Object[]>) procedureQuery.getOutputParameterValue("CUR1"));
			Integer codRetorno = (Integer) procedureQuery.getOutputParameterValue("P_COD_RETORNO");
			String msgRetorno = (String) procedureQuery.getOutputParameterValue("P_MSG_RETORNO");
            
            updateProcReturnResult(resultList, entity.getCabinet(), entity.getTelephoneNumber(), entity.getPSwitch(), codRetorno, msgRetorno);
            
    		logger.log(OSSLogger.INFO, this.getClass().getName() + " -  procedure "+ PROC_NAME + " executada com sucesso");

		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_DETERMINE_AVAILABILITY no TBS", e.getMessage()));

		} catch (PersistenceException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_DETERMINE_AVAILABILITY no TBS", e.getMessage()));

		} catch (Exception e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_999.getDescription(),
					ExceptionInfoEnum.RITBS_999.getCode(), e.getMessage());
		}
		
		return resultList;
	}

	private void updateProcReturnResult(List<DetermineAvailabilityEntity> resultList,
			String cabinet, String telefone, String pSwitch, Integer codRetorno, String msgRetorno) {

		for (DetermineAvailabilityEntity determineAvailabilityEntity : resultList) {
			determineAvailabilityEntity.setCodeReturn(codRetorno);
			determineAvailabilityEntity.setMessageReturn(msgRetorno);
			determineAvailabilityEntity.setCabinet(cabinet);
			determineAvailabilityEntity.setTelephoneNumber(telefone);
			determineAvailabilityEntity.setPSwitch(pSwitch);
		}
		
		if(resultList != null && resultList.isEmpty()) {
			DetermineAvailabilityEntity entity = new DetermineAvailabilityEntity();
			entity.setCodeReturn(codRetorno);
			entity.setMessageReturn(msgRetorno);
			resultList.add(entity);
		}
	}

	private List<DetermineAvailabilityEntity> castToDetermineAvailabilityEntity(List<Object[]> list) {
		List<DetermineAvailabilityEntity> result = new ArrayList<DetermineAvailabilityEntity>();
		
		for (Object[] procResult : list) {
			DetermineAvailabilityEntity entity = new DetermineAvailabilityEntity();
			entity.setTlfSwitch(objectToString(procResult[0]));
			entity.setAvailableCapacityADSL(objecToInteger(procResult[1]));
			entity.setTotalCapacityADSL(objecToInteger(procResult[2]));
			entity.setAvailableCapacityVDSL(objecToInteger(procResult[3]));
			entity.setTotalCapacityVDSL(objecToInteger(procResult[4]));
			entity.setAvailableCapacityFTTH(objecToInteger(procResult[5]));
			entity.setTotalCapacityFTTH(objecToInteger(procResult[6]));	
			entity.setAvailableCapacityADSLSIP(objecToInteger(procResult[7]));
			entity.setTotalCapacityADSLSIP(objecToInteger(procResult[8]));
			entity.setAvailableCapacityVDSLSIP(objecToInteger(procResult[9]));
			entity.setTotalCapacityVDSLSIP(objecToInteger(procResult[10]));
			entity.setAvailableCapacityADSLAccess(objecToInteger(procResult[11]));
			entity.setTotalCapacityADSLAccess(objecToInteger(procResult[12]));
			entity.setAvailableCapacityVDSLAccess(objecToInteger(procResult[13]));
			entity.setTotalCapacityVDSLAccess(objecToInteger(procResult[14]));
			entity.setProtocolVoice(objectToString(procResult[15]));
			entity.setTechnologyAdsl(objectToString(procResult[16]));
			entity.setCode(objecToInteger(procResult[17]));
			entity.setMessage(objectToString(procResult[18]));
			
			result.add(entity);
		}
		
		return result;
	}
	
	private Integer objecToInteger (Object in) {
		Integer result = 0;
		if (in != null) {
			result = Integer.parseInt(in.toString());
		}
		return result;
	}
	
	private String objectToString (Object in) {
		String result = "";
		if (in != null ) {
			result = String.valueOf(in);
		}
		return result;
	}
}