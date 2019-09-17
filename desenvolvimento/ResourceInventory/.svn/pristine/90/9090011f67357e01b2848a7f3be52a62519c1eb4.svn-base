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
@Table(name = "RECURSO_LOGICO")
public class RecursoLogico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CPE_OWNER.RECURSO_LOGICO_SEQ", sequenceName = "CPE_OWNER.RECURSO_LOGICO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPE_OWNER.RECURSO_LOGICO_SEQ")
	@Column(name = "ID")
	private Integer id;

	@Basic
	@Column(name = "ID_FXS")
	private Integer idFxs;

	@Basic
	@Column(name = "DISPOSITIVO_FISICO_ID")
	private Integer dispositivoFisicoId;

	@Basic
	@Column(name = "SERVICO_ASSINANTE_ID")
	private Integer servicoAssinanteId;

	@Basic
	@Column(name = "MAIN_KEY")
	private String mainKey;

	@Basic
	@Column(name = "CASN")
	private String casn;

	@Basic
	@Column(name = "ESTADO_RECURSO_LOGICO_ID")
	private Integer estadoRecursoLogicoId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdFxs() {
		return idFxs;
	}

	public void setIdFxs(Integer idFxs) {
		this.idFxs = idFxs;
	}

	public Integer getDispositivoFisicoId() {
		return dispositivoFisicoId;
	}

	public void setDispositivoFisicoId(Integer deispositivoFisicoId) {
		this.dispositivoFisicoId = deispositivoFisicoId;
	}

	public Integer getServicoAssinanteId() {
		return servicoAssinanteId;
	}

	public void setServicoAssinanteId(Integer servicoAssinanteId) {
		this.servicoAssinanteId = servicoAssinanteId;
	}

	public String getMainKey() {
		return mainKey;
	}

	public void setMainKey(String mainKey) {
		this.mainKey = mainKey;
	}
	
	public Integer getEstadoRecursoLogicoId() {
		return estadoRecursoLogicoId;
	}

	public void setEstadoRecursoLogicoId(Integer estadoRecursoLogicoId) {
		this.estadoRecursoLogicoId = estadoRecursoLogicoId;
	}

	@Override
	public String toString() {
		return "RecursoLogico [id=" + id + ", idFxs=" + idFxs + ", dispositivoFisicoId=" + dispositivoFisicoId
		        + ", servicoAssinanteId=" + servicoAssinanteId + ", mainKey=" + mainKey + ", casn=" + casn
		        + ", estadoRecursoLogicoId=" + estadoRecursoLogicoId + "]";
	}

	public String getCasn() {
		return casn;
	}

	public void setCasn(String casn) {
		this.casn = casn;
	}
}
