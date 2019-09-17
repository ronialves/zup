package com.tlf.oss.resourceinventory.cpe.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CARACTERISTICA_DISPOSITIVO")
public class CaracteristicaDispositivo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CPE_OWNER.CARACTERISTICA_DISPOSITIVO_SEQ", sequenceName = "CPE_OWNER.CARACTERISTICA_DISPOSITIVO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPE_OWNER.CARACTERISTICA_DISPOSITIVO_SEQ")
	@Column(name = "ID")
	private Integer id;

	@Basic
	@Column(name = "NOME")
	private String nome;

	@Basic
	@Column(name = "VALOR")
	private String valor;

	@ManyToOne
	@JoinColumn(name = "CATALOGO_DISPOSITIVO_ID")
	private CatalogoDispositivo catalogo;

	public CaracteristicaDispositivo() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public CatalogoDispositivo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(CatalogoDispositivo catalogo) {
		this.catalogo = catalogo;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalogo == null) ? 0 : catalogo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaracteristicaDispositivo other = (CaracteristicaDispositivo) obj;
		if (catalogo == null) {
			if (other.catalogo != null)
				return false;
		} else if (!catalogo.equals(other.catalogo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CaracteristicaDispositivo [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}
}
