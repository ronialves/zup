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
@Table(name = "ESTADO_RECURSO_lOGICO")
public class EstadoRecursoLogico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CPE_OWNER.ESTADO_RECURSO_lOGICO_SEQ", sequenceName = "CPE_OWNER.ESTADO_RECURSO_lOGICO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPE_OWNER.ESTADO_RECURSO_lOGICO_SEQ")
	@Column(name = "ID")
	private Integer id;

	@Basic
	@Column(name = "ESTADO_RECURSO")
	private String estadoRecurso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstadoRecurso() {
		return estadoRecurso;
	}

	public void setEstadoRecurso(String estadoRecurso) {
		this.estadoRecurso = estadoRecurso;
	}

	@Override
	public String toString() {
		return "EstadoRecursoLogico [id=" + id + ", estadoRecurso=" + estadoRecurso + "]";
	}
}