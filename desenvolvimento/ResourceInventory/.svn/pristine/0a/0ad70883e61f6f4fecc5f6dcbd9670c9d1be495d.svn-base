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
@Table(name = "ESTADO_SERVICO_ASSINANTE")
public class EstadoServicoAssinante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CPE_OWNER.ESTADO_SERVICO_ASSINANTE_SEQ", sequenceName = "CPE_OWNER.ESTADO_SERVICO_ASSINANTE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPE_OWNER.ESTADO_SERVICO_ASSINANTE_SEQ")
	@Column(name = "ID")
	private Integer id;

	@Basic
	@Column(name = "ESTADO_SERVICO")
	private String estadoServico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstadoServico() {
		return estadoServico;
	}

	public void setEstadoServico(String estadoServico) {
		this.estadoServico = estadoServico;
	}

	@Override
	public String toString() {
		return "EstadoServicoAssinante [id=" + id + ", estadoServico=" + estadoServico + "]";
	}

}
