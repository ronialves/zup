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

@Entity
@NamedStoredProcedureQuery(name = "deallocateInternalResourceGPON", resultClasses = DeallocateInternalResourceGponEntity.class,procedureName = DeallocateInternalResourceGponEntity.PRC_NAME,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_terminal", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
})public class DeallocateInternalResourceGponEntity extends EntityCommon<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String PRC_NAME = "PKG_ALLOCATE.PRC_CANCEL_ALLOCATE_GPON";
	
	@Basic
	@Column(name="p_terminal")
	private String terminal;

	@Id
	@Basic
	@Column(name="p_ret_code")
	private String code;

	@Basic
	@Column(name="p_ret_msg")
	private String description;

	@Transient
    private ResultTo result ;
	
	public DeallocateInternalResourceGponEntity() {
		super();
	}
	
	public DeallocateInternalResourceGponEntity(String terminal, String code, String description, ResultTo result) {
		super();
		this.terminal=terminal;
		this.code = code;
		this.description = description;
		this.result = result;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
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
}
