package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.OperationService;

@Entity
@NamedStoredProcedureQuery(name = CancelResourceEntity.CANCEL_RESOURCE, resultClasses = CancelResourceEntity.class,procedureName = CancelResourceEntity.PKG_RESERVE_PRC_CANCEL_RESERVE_RESOURCE,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = CancelResourceEntity.IN_P_CIRC_PATH_INST_ID, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = CancelResourceEntity.OUT_P_RET_CODE, type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = CancelResourceEntity.OUT_P_RET_MSG, type = String.class)
})public class CancelResourceEntity extends EntityCommon<Long> implements Serializable  {
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	
	public static final String OUT_P_RET_CODE = "p_ret_code";
    public static final String OUT_P_RET_MSG = "p_ret_msg";
	
	public static final String IN_P_CIRC_PATH_INST_ID = "p_circ_path_inst_id";
	
    public static final String CANCEL_RESOURCE = "cancelResource";
    public static final String PKG_RESERVE_PRC_CANCEL_RESERVE_RESOURCE = "PKG_RESERVE.PRC_CANCEL_RESERVE_RESOURCE";

	@Basic
	@Column(name="p_circ_path_inst_id")
	private String circPathInstId;

	@Id
	@Basic
	@Column(name="p_ret_code")
	private String code;
	
	@Basic
	@Column(name="p_ret_msg")
	private String description;
	
	@Transient
	private String idConexoesPotsMsan;
	
	
	@Transient
	private boolean updatePots;
	
	@Transient
	private ResultTo result ;
	
	@Transient
	private Cabinet cabinet;
	
	@Transient
	private OperationService operationService;

	
	public CancelResourceEntity() {
		super();
	}

	public CancelResourceEntity(String circPathInstId, String code, String description, ResultTo result) {
		super();
		this.circPathInstId = circPathInstId;
		this.code = code;
		this.description = description;
		this.result = result;
	}

	public String getCircPathInstId() {
		return circPathInstId;
	}

	public void setCircPathInstId(String circPathInstId) {
		this.circPathInstId = circPathInstId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResultTo getResult() {
		return result;
	}
	
	public String getIdConexoesPotsMsan() {
		return idConexoesPotsMsan;
	}

	public void setIdConexoesPotsMsan(String idConexoesPotsMsan) {
		this.idConexoesPotsMsan = idConexoesPotsMsan;
	}

	
	public boolean isUpdatePots() {
		return updatePots;
	}

	public void setUpdatePots(boolean updatePots) {
		this.updatePots = updatePots;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}
	
	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

	public OperationService getOperationService() {
		return operationService;
	}

	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}