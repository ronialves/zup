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
@Table(name = "CATEGORIA_DISPOSITIVO")
public class CategoriaDispositivo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CPE_OWNER.CATEGORIA_DISPOSITIVO_SEQ", sequenceName = "CPE_OWNER.CATEGORIA_DISPOSITIVO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CPE_OWNER.CATEGORIA_DISPOSITIVO_SEQ")
	@Column(name = "ID")
	private Integer id;

	@Basic
	@Column(name = "TIPO_RFS")
	private String tipoRfs;

	@Basic
	@Column(name = "NOME_CATEGORIA")
	private String nomeCategoria;

	public CategoriaDispositivo() {	}

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

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	@Override
	public String toString() {
		return "CategoriaDispositivo [id=" + id + ", tipoRfs=" + tipoRfs + ", nomeCategoria=" + nomeCategoria
				+ "]";
	}

}
