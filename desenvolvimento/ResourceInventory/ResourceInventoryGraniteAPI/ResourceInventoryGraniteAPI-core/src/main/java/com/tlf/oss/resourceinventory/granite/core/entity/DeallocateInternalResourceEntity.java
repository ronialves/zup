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
@NamedStoredProcedureQuery(name = "deallocateInternalResource", resultClasses = DeallocateInternalResourceEntity.class,procedureName = "PKG_ALLOCATE.PRC_DEALLOCATE_PATH",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_circ_path_inst_id", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_status", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
})public class DeallocateInternalResourceEntity extends EntityCommon<Long> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name="p_circ_path_inst_id")
	private Long circPathInstId;

	@Basic
	@Column(name="p_status")
	private String status;

	@Id
	@Basic
	@Column(name="p_ret_code")
	private String code;
	
	@Basic
	@Column(name="p_ret_msg")
	private String description;
	
	@Transient
	private ResultTo result ;
	
	@Transient
	private String idConexoesPotsMsan;

	@Transient
	private String idMsan;

	@Transient
	private String lic;

	@Transient
	private boolean updatePots;
	
	@Transient
	private Cabinet cabinet;
	
	@Transient
	private OperationService operationService;

	
	public DeallocateInternalResourceEntity() {
		super();
	}
	
	public DeallocateInternalResourceEntity(Long circPathInstId, String status, String code, String description, ResultTo result) {
		super();
		this.circPathInstId=circPathInstId;
		this.status=status;
		this.code = code;
		this.description = description;
		this.result = result;
	}
	
	public Long getCircPathInstId() {
		return circPathInstId;
	}

	public void setCircPathInstId(Long circPathInstId) {
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
		if(null==result){
			result= new ResultTo();
		}
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdConexoesPotsMsan() {
		return idConexoesPotsMsan;
	}

	public void setIdConexoesPotsMsan(String idConexoesPotsMsan) {
		this.idConexoesPotsMsan = idConexoesPotsMsan;
	}

	public String getIdMsan() {
		return idMsan;
	}

	public void setIdMsan(String idMsan) {
		this.idMsan = idMsan;
	}

	public String getLic() {
		return lic;
	}

	public void setLic(String lic) {
		this.lic = lic;
	}

	public boolean isUpdatePots() {
		return updatePots;
	}

	public void setUpdatePots(boolean updatePots) {
		this.updatePots = updatePots;
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
	
}