package com.tlf.oss.resourceinventory.tbs.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = RetrievalEquipmentDetailPortEntity.RETRIEVAL_EQUIPMENT_DETAIL_PORT, 
			procedureName = "TLF_SP_SIGITM_GET_PORTA", resultClasses = RetrievalEquipmentDetailPortEntity.class, 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_equipment_id", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "cur1", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_cod_retorno", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_msg_retorno", type = String.class)}) })
public class RetrievalEquipmentDetailPortEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String RETRIEVAL_EQUIPMENT_DETAIL_PORT = "retrievalEquipmentDetailPort";
	
	@Id
	@Basic
	@Column(name="PORTADDR_SEQ")
	private String portAddrSeq;
	
	@Basic
	@Column(name="NODE_ADDRESS")
	private String nodeAddress;
	
	@Basic
	@Column(name="RATE_CODE")
	private String rateCode;
	
	@Basic
	@Column(name="STATUS_PORTA")
	private String portStatus;
	
	@Basic
	@Column(name="ECCKT")
	private String ecckt;
	
	@Basic
	@Column(name="STATUS_CIRCUITO")
	private String circuitStatus;
	
	@Basic
	@Column(name="PORTADDR_SEQ_2")
	private String portAddrSeq2;

	@Basic
	@Column(name="NODE_ADDRESS_2")
	private String nodeAddress2;
	
	@Basic
	@Column(name="RATE_CODE_2")
	private String rateCode2;
	
	@Basic
	@Column(name="STATUS_PORTA_2")
	private String portStatus2;
	
	@Basic
	@Column(name="ECCKT_2")
	private String ecckt2;
	
	@Basic
	@Column(name="STATUS_CIRCUITO_2")
	private String circuitStatus2;
	
	@Basic
	@Column(name="EQUIPMENT_ID")
	private String equipmentId;
	
	@Basic
	@Column(name="CIRCUIT_DESIGN_ID")
	private String circuitDesignId;
	
	@Basic
	@Column(name="CIRCUIT_DESIGN_ID_2")
	private String circuitDesignId2;
	
	@Basic
	@Column(name="p_cod_retorno")
	private String codRetorno;
	
	@Basic
	@Column(name="p_msg_retorno")
	private String msgRetorno;

	public String getRateCode() {
		return rateCode;
	}

	public void setRateCode(String rateCode) {
		this.rateCode = rateCode;
	}

	public String getPortStatus() {
		return portStatus;
	}

	public void setPortStatus(String portStatus) {
		this.portStatus = portStatus;
	}

	public String getEcckt() {
		return ecckt;
	}

	public void setEcckt(String ecckt) {
		this.ecckt = ecckt;
	}

	public String getCircuitStatus() {
		return circuitStatus;
	}

	public void setCircuitStatus(String circuitStatus) {
		this.circuitStatus = circuitStatus;
	}

	public String getNodeAddress2() {
		return nodeAddress2;
	}

	public void setNodeAddress2(String nodeAddress2) {
		this.nodeAddress2 = nodeAddress2;
	}

	public String getRateCode2() {
		return rateCode2;
	}

	public void setRateCode2(String rateCode2) {
		this.rateCode2 = rateCode2;
	}

	public String getCircuitStatus2() {
		return circuitStatus2;
	}

	public void setCircuitStatus2(String circuitStatus2) {
		this.circuitStatus2 = circuitStatus2;
	}

	public String getCodRetorno() {
		return codRetorno;
	}

	public void setCodRetorno(String codRetorno) {
		this.codRetorno = codRetorno;
	}

	public String getMsgRetorno() {
		return msgRetorno;
	}

	public void setMsgRetorno(String msgRetorno) {
		this.msgRetorno = msgRetorno;
	}

	public String getPortAddrSeq() {
		return portAddrSeq;
	}

	public void setPortAddrSeq(String portAddrSeq) {
		this.portAddrSeq = portAddrSeq;
	}

	public String getNodeAddress() {
		return nodeAddress;
	}

	public void setNodeAddress(String nodeAddress) {
		this.nodeAddress = nodeAddress;
	}

	public String getPortAddrSeq2() {
		return portAddrSeq2;
	}

	public void setPortAddrSeq2(String portAddrSeq2) {
		this.portAddrSeq2 = portAddrSeq2;
	}

	public String getPortStatus2() {
		return portStatus2;
	}

	public void setPortStatus2(String portStatus2) {
		this.portStatus2 = portStatus2;
	}

	public String getEcckt2() {
		return ecckt2;
	}

	public void setEcckt2(String ecckt2) {
		this.ecckt2 = ecckt2;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getCircuitDesignId() {
		return circuitDesignId;
	}

	public void setCircuitDesignId(String circuitDesignId) {
		this.circuitDesignId = circuitDesignId;
	}

	public String getCircuitDesignId2() {
		return circuitDesignId2;
	}

	public void setCircuitDesignId2(String circuitDesignId2) {
		this.circuitDesignId2 = circuitDesignId2;
	}	
}