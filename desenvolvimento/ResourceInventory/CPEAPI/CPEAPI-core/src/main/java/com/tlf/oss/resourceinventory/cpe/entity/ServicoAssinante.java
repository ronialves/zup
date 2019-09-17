package com.tlf.oss.resourceinventory.cpe.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICO_ASSINANTE")
public class ServicoAssinante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CPE_OWNER.SERVICO_ASSINANTE_SEQ", sequenceName = "CPE_OWNER.SERVICO_ASSINANTE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPE_OWNER.SERVICO_ASSINANTE_SEQ")
	@Column(name = "ID")
	private Integer id;

	@Basic
	@Column(name = "TIPO_RFS")
	private String tipoRfs;

	@Basic
	@Column(name = "ESTADO_SERVICO_ASSINANTE_ID")
	private Integer estadoServicoAssinanteId;

	@Basic
	@Column(name = "SERVICE_ID")
	private String serviceId;

	@Basic
	@Column(name = "NRC")
	private String nrc;

	@Basic
	@Column(name = "ACCESS_ID")
	private String accessId;

	@Basic
	@Column(name = "NUMERO_TELEFONE")
	private String numeroTelefone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoRfs() {
		return tipoRfs;
	}

	public void setTipoRfs(String tipoRfs) {
		this.tipoRfs = tipoRfs;
	}

	public Integer getEstadoServicoAssinanteId() {
		return estadoServicoAssinanteId;
	}

	public void setEstadoServicoAssinanteId(Integer estadoServicoAssinanteId) {
		this.estadoServicoAssinanteId = estadoServicoAssinanteId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	@Override
	public String toString() {
		return "ServicoAssinante [id=" + id + ", tipoRfs=" + tipoRfs + ", estadoServicoAssinanteId="
				+ estadoServicoAssinanteId + ", serviceId=" + serviceId + ", nrc=" + nrc + ", accessId=" + accessId
				+ ", numeroTelefone=" + numeroTelefone + "]";
	}
}
