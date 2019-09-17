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
import javax.persistence.Transient;

@Entity
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "retrieveNetworkSyncInfo", resultClasses = RetrieveEntity.class, procedureName = "ASAP.GVT_SP_GET_INFO_CFGSIN", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DOCUMENT_NUMBER", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CIRCUIT_ACTIVITY_IND", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_IP_ADDRESS", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_INSTANCIA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SLOT", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_PORTA_FISICA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_V5ID", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_RIN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NAME_DSLAM", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_VENDOR_NAME", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_PORTA_LOGICA", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SVLAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_CVLAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_DOWNSTREAM", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_UPSTREAM", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_MODELO_PLACA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_ERRO", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_MSG", type = String.class) }),
		@NamedStoredProcedureQuery(name = "retrieveCrossConnectionInfo", resultClasses = RetrieveEntity.class, procedureName = "ASAP.GVT_SP_GET_INFO_CROSS_PARAMS", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DOCUMENT_NUMBER", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_IP_ADDRESS", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_INSTANCIA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SLOT", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_PORTA_FISICA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_V5ID", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_TRIBUTARIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_VENDOR_NAME", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_PORTA_LOGICA", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_CIRCUIT_ACTIVITY_IND", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_ERRO", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_MSG", type = String.class) }) })
public class RetrieveEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name = "P_DOCUMENT_NUMBER")
	private Integer documentNumber;

	@Basic
	@Column(name = "P_IP_ADDRESS")
	private String ipAddress;

	@Basic
	@Column(name = "P_INSTANCIA")
	private String instancia;

	@Basic
	@Column(name = "P_SLOT")
	private String slot;

	@Basic
	@Column(name = "P_PORTA_FISICA")
	private String portaFisica;

	@Basic
	@Column(name = "P_V5ID")
	private String v5id;

	@Basic
	@Column(name = "P_RIN")
	private String rin;

	@Basic
	@Column(name = "P_NAME_DSLAM")
	private String nameDslam;

	@Basic
	@Column(name = "P_TRIBUTARIO")
	private String tributario;

	@Basic
	@Column(name = "P_VENDOR_NAME")
	private String vendorName;

	@Basic
	@Column(name = "P_PORTA_LOGICA")
	private Integer portaLogica;

	@Basic
	@Column(name = "P_SVLAN")
	private String svlan;

	@Basic
	@Column(name = "P_CVLAN")
	private String cvlan;

	@Basic
	@Column(name = "P_DOWNSTREAM")
	private String downstream;

	@Basic
	@Column(name = "P_UPSTREAM")
	private String upstream;

	@Basic
	@Column(name = "P_MODELO_PLACA")
	private String modeloPlaca;

	@Basic
	@Column(name = "P_CIRCUIT_ACTIVITY_IND")
	private String circuitActivityInd;

	@Id
	@Basic
	@Column(name = "P_ERRO")
	private Integer erro;

	@Basic
	@Column(name = "P_MSG")
	private String msg;

	@Transient
	private String typeOfResource;

	public RetrieveEntity() {
	}

	/**
	 * @param documentNumber
	 * @param ipAddress
	 * @param instancia
	 * @param slot
	 * @param portaFisica
	 * @param v5id
	 * @param rin
	 * @param nameDslam
	 * @param tributario
	 * @param vendorName
	 * @param portaLogica
	 * @param svlan
	 * @param cvlan
	 * @param downstream
	 * @param upstream
	 * @param modeloPlaca
	 * @param circuitActivityInd
	 * @param erro
	 * @param msg
	 * @param typeOfResource
	 */
	public RetrieveEntity(Integer documentNumber, String ipAddress, String instancia, String slot, String portaFisica,
			String v5id, String rin, String nameDslam, String tributario, String vendorName, Integer portaLogica,
			String svlan, String cvlan, String downstream, String upstream, String modeloPlaca,
			String circuitActivityInd, Integer erro, String msg, String typeOfResource) {
		super();
		this.documentNumber = documentNumber;
		this.ipAddress = ipAddress;
		this.instancia = instancia;
		this.slot = slot;
		this.portaFisica = portaFisica;
		this.v5id = v5id;
		this.rin = rin;
		this.nameDslam = nameDslam;
		this.tributario = tributario;
		this.vendorName = vendorName;
		this.portaLogica = portaLogica;
		this.svlan = svlan;
		this.cvlan = cvlan;
		this.downstream = downstream;
		this.upstream = upstream;
		this.modeloPlaca = modeloPlaca;
		this.circuitActivityInd = circuitActivityInd;
		this.erro = erro;
		this.msg = msg;
		this.typeOfResource = typeOfResource;
	}

	/**
	 * @return the documentNumber
	 */
	public Integer getDocumentNumber() {
		return documentNumber;
	}

	/**
	 * @param documentNumber
	 *            the documentNumber to set
	 */
	public void setDocumentNumber(Integer documentNumber) {
		this.documentNumber = documentNumber;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress
	 *            the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the instancia
	 */
	public String getInstancia() {
		return instancia;
	}

	/**
	 * @param instancia
	 *            the instancia to set
	 */
	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

	/**
	 * @return the slot
	 */
	public String getSlot() {
		return slot;
	}

	/**
	 * @param slot
	 *            the slot to set
	 */
	public void setSlot(String slot) {
		this.slot = slot;
	}

	/**
	 * @return the portaFisica
	 */
	public String getPortaFisica() {
		return portaFisica;
	}

	/**
	 * @param portaFisica
	 *            the portaFisica to set
	 */
	public void setPortaFisica(String portaFisica) {
		this.portaFisica = portaFisica;
	}

	/**
	 * @return the v5id
	 */
	public String getV5id() {
		return v5id;
	}

	/**
	 * @param v5id
	 *            the v5id to set
	 */
	public void setV5id(String v5id) {
		this.v5id = v5id;
	}

	/**
	 * @return the tributario
	 */
	public String getTributario() {
		return tributario;
	}

	/**
	 * @param tributario
	 *            the tributario to set
	 */
	public void setTributario(String tributario) {
		this.tributario = tributario;
	}

	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName
	 *            the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * @return the portaLogica
	 */
	public Integer getPortaLogica() {
		return portaLogica;
	}

	/**
	 * @param portaLogica
	 *            the portaLogica to set
	 */
	public void setPortaLogica(Integer portaLogica) {
		this.portaLogica = portaLogica;
	}

	/**
	 * @return the circuitActivityInd
	 */
	public String getCircuitActivityInd() {
		return circuitActivityInd;
	}

	/**
	 * @param circuitActivityInd
	 *            the circuitActivityInd to set
	 */
	public void setCircuitActivityInd(String circuitActivityInd) {
		this.circuitActivityInd = circuitActivityInd;
	}

	/**
	 * @return the erro
	 */
	public Integer getErro() {
		return erro;
	}

	/**
	 * @param erro
	 *            the erro to set
	 */
	public void setErro(Integer erro) {
		this.erro = erro;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the typeOfResource
	 */
	public String getTypeOfResource() {
		return typeOfResource;
	}

	/**
	 * @param typeOfResource
	 *            the typeOfResource to set
	 */
	public void setTypeOfResource(String typeOfResource) {
		this.typeOfResource = typeOfResource;
	}

	/**
	 * @return the rin
	 */
	public String getRin() {
		return rin;
	}

	/**
	 * @param rin
	 *            the rin to set
	 */
	public void setRin(String rin) {
		this.rin = rin;
	}

	/**
	 * @return the nameDslam
	 */
	public String getNameDslam() {
		return nameDslam;
	}

	/**
	 * @param nameDslam
	 *            the nameDslam to set
	 */
	public void setNameDslam(String nameDslam) {
		this.nameDslam = nameDslam;
	}

	/**
	 * @return the svlan
	 */
	public String getSvlan() {
		return svlan;
	}

	/**
	 * @param svlan
	 *            the svlan to set
	 */
	public void setSvlan(String svlan) {
		this.svlan = svlan;
	}

	/**
	 * @return the cvlan
	 */
	public String getCvlan() {
		return cvlan;
	}

	/**
	 * @param cvlan
	 *            the cvlan to set
	 */
	public void setCvlan(String cvlan) {
		this.cvlan = cvlan;
	}

	/**
	 * @return the downstream
	 */
	public String getDownstream() {
		return downstream;
	}

	/**
	 * @param downstream
	 *            the downstream to set
	 */
	public void setDownstream(String downstream) {
		this.downstream = downstream;
	}

	/**
	 * @return the upstream
	 */
	public String getUpstream() {
		return upstream;
	}

	/**
	 * @param upstream
	 *            the upstream to set
	 */
	public void setUpstream(String upstream) {
		this.upstream = upstream;
	}

	/**
	 * @return the modeloPlaca
	 */
	public String getModeloPlaca() {
		return modeloPlaca;
	}

	/**
	 * @param modeloPlaca
	 *            the modeloPlaca to set
	 */
	public void setModeloPlaca(String modeloPlaca) {
		this.modeloPlaca = modeloPlaca;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RetrieveEntity [");
		if (documentNumber != null) {
			builder.append("documentNumber=");
			builder.append(documentNumber);
			builder.append(", ");
		}
		if (ipAddress != null) {
			builder.append("ipAddress=");
			builder.append(ipAddress);
			builder.append(", ");
		}
		if (instancia != null) {
			builder.append("instancia=");
			builder.append(instancia);
			builder.append(", ");
		}
		if (slot != null) {
			builder.append("slot=");
			builder.append(slot);
			builder.append(", ");
		}
		if (portaFisica != null) {
			builder.append("portaFisica=");
			builder.append(portaFisica);
			builder.append(", ");
		}
		if (v5id != null) {
			builder.append("v5id=");
			builder.append(v5id);
			builder.append(", ");
		}
		if (rin != null) {
			builder.append("rin=");
			builder.append(rin);
			builder.append(", ");
		}
		if (nameDslam != null) {
			builder.append("nameDslam=");
			builder.append(nameDslam);
			builder.append(", ");
		}
		if (tributario != null) {
			builder.append("tributario=");
			builder.append(tributario);
			builder.append(", ");
		}
		if (vendorName != null) {
			builder.append("vendorName=");
			builder.append(vendorName);
			builder.append(", ");
		}
		if (portaLogica != null) {
			builder.append("portaLogica=");
			builder.append(portaLogica);
			builder.append(", ");
		}
		if (svlan != null) {
			builder.append("svlan=");
			builder.append(svlan);
			builder.append(", ");
		}
		if (cvlan != null) {
			builder.append("cvlan=");
			builder.append(cvlan);
			builder.append(", ");
		}
		if (downstream != null) {
			builder.append("downstream=");
			builder.append(downstream);
			builder.append(", ");
		}
		if (upstream != null) {
			builder.append("upstream=");
			builder.append(upstream);
			builder.append(", ");
		}
		if (modeloPlaca != null) {
			builder.append("modeloPlaca=");
			builder.append(modeloPlaca);
			builder.append(", ");
		}
		if (circuitActivityInd != null) {
			builder.append("circuitActivityInd=");
			builder.append(circuitActivityInd);
			builder.append(", ");
		}
		if (erro != null) {
			builder.append("erro=");
			builder.append(erro);
			builder.append(", ");
		}
		if (msg != null) {
			builder.append("msg=");
			builder.append(msg);
			builder.append(", ");
		}
		if (typeOfResource != null) {
			builder.append("typeOfResource=");
			builder.append(typeOfResource);
		}
		builder.append("]");
		return builder.toString();
	}

}
