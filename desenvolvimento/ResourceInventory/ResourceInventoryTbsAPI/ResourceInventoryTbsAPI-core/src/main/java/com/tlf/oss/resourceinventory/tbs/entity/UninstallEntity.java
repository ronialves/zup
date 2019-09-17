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
 * BEATRIXTWO-966 | DEMOSS-3082
 * 
 * @author jose.fabio.d.souza
 * @project Beatrix Fase 2
 * @since 201804
 *
 */
@Entity
@NamedStoredProcedureQuery(name = "uninstall", resultClasses = UninstallEntity.class, procedureName = "ASAP.TLF_SP_UNINSTALL", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_pon", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rpon", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_designador_acesso", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_activity_ind", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_document_number", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_cod_retorno", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_msg_retorno", type = String.class) })
public class UninstallEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic
	@Column(name = "p_pon")
	private String purchaseOrderNumber;
	
	@Basic
	@Column(name = "p_rpon")
	private String rpon;
	
	@Basic
	@Column(name = "p_designador_acesso")
	private String designadorAcesso;
	
	@Basic
	@Column(name = "p_activity_ind")
	private String activityInd;
	
	@Basic
	@Column(name = "p_document_number")
	private Integer documentNumber;
	
	@Id
	@Basic
	@Column(name = "p_cod_retorno")
	private Integer returnCode;
	
	@Basic
	@Column(name = "p_msg_retorno")
	private String message;
	
	@Transient
	private ResultTo result;

	public UninstallEntity() {
		super();
	}

	public UninstallEntity(String purchaseOrderNumber, String rpon, String designadorAcesso, String activityInd, Integer documentNumber, Integer returnCode, String message, ResultTo result) {
		super();
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.rpon = rpon;
		this.designadorAcesso = designadorAcesso;
		this.activityInd = activityInd;
		this.documentNumber = documentNumber;
		this.returnCode = returnCode;
		this.message = message;
		this.result = result;
	}
	
	/**
	 * @return the purchaseOrderNumber
	 */
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	/**
	 * @param purchaseOrderNumber the purchaseOrderNumber to set
	 */
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	/**
	 * @return the rpon
	 */
	public String getRpon() {
		return rpon;
	}

	/**
	 * @param rpon the rpon to set
	 */
	public void setRpon(String rpon) {
		this.rpon = rpon;
	}

	/**
	 * @return the designadorAcesso
	 */
	public String getDesignadorAcesso() {
		return designadorAcesso;
	}

	/**
	 * @param designadorAcesso the designadorAcesso to set
	 */
	public void setDesignadorAcesso(String designadorAcesso) {
		this.designadorAcesso = designadorAcesso;
	}

	/**
	 * @return the activityInd
	 */
	public String getActivityInd() {
		return activityInd;
	}

	/**
	 * @param activityInd the activityInd to set
	 */
	public void setActivityInd(String activityInd) {
		this.activityInd = activityInd;
	}

	/**
	 * @return the documentNumber
	 */
	public Integer getDocumentNumber() {
		return documentNumber;
	}

	/**
	 * @param documentNumber the documentNumber to set
	 */
	public void setDocumentNumber(Integer documentNumber) {
		this.documentNumber = documentNumber;
	}

	/**
	 * @return the returnCode
	 */
	public Integer getReturnCode() {
		return returnCode;
	}

	/**
	 * @param returnCode the returnCode to set
	 */
	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * @return the returnMessage
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param returnMessage the returnMessage to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the result
	 */
	public ResultTo getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(ResultTo result) {
		this.result = result;
	}
}
