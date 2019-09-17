package com.tlf.oss.resourceinventory.tbs.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.tbs.to.ResultTo;

/**
 * BEATRIXTWO-934 | DEMOSS-2998
 * 
 * @project Beatrix Fase 2
 * @author jose.fabio.d.souza
 * @since 201803
 */

@Entity
@NamedStoredProcedureQuery(name = "deallocate", resultClasses = DeallocateEntity.class, procedureName = "ASAP.TLF_SP_DEALLOCATE", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_PON", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DESIGNADOR_ACESSO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_COD_RETORNO", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_MSG_RETORNO", type = String.class) })
public class DeallocateEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name = "P_PON")
	private String purchaseOrderNumber;
	
	@Basic
	@Column(name = "P_DESIGNADOR_ACESSO")
	private String designadorAcesso;

	@Id
	@Basic
	@Column(name = "P_COD_RETORNO")
	private Integer returnCode;

	@Basic
	@Column(name = "P_MSG_RETORNO")
	private String returnMsg;

	@Transient
	private ResultTo result;

	public DeallocateEntity() {
		super();
	}

	public DeallocateEntity(String purchaseOrderNumber, String designadorAcesso, Integer returnCode, String returnMsg) {
		super();
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.designadorAcesso = designadorAcesso;
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public String getDesignadorAcesso() {
		return designadorAcesso;
	}

	public void setDesignadorAcesso(String designadorAcesso) {
		this.designadorAcesso = designadorAcesso;
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public ResultTo getResult() {
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
