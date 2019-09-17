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
@Table(name = "CATALOGO_DISPOSITIVO")
public class CatalogoInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String QUERY_RETRIEVE_CATALOG = "QueryRetrieveCatalog";

	@Id
	@SequenceGenerator(name = "CPE_OWNER.CATALOGO_DISPOSITIVO_SEQ", sequenceName = "CPE_OWNER.CATALOGO_DISPOSITIVO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPE_OWNER.CATALOGO_DISPOSITIVO_SEQ")
	@Column(name = "ID")
	private Integer id;

	@Basic
	@Column(name = "MODELO")
	private String modelo;

	@Basic
	@Column(name = "FABRICANTE")
	private String fabricante;

	@Basic
	@Column(name = "REDE")
	private String rede;

	@Basic
	@Column(name = "CATEGORIA_DISPOSITIVO_ID")
	private Integer categoriaDispositivoId;

	@Basic
	@Column(name = "TIPO_DISPOSITIVO")
	private String tipoDispositivo;

	@Basic
	@Column(name = "DESCRICAO")
	private String descricao;
	
	//Colunas das tabelas CATEGORIA_DISPOSITIVO e CARACTERISTICA_DISPOSITIVO
	@Basic
	@Column(name = "TIPO_RFS")
	private String tipoRFS;
	
	@Basic
	@Column(name = "NOME_CATEGORIA")
	private String nomeCategoria;
	
	@Basic
	@Column(name = "NOME_CARACTERISTICA")
	private String nomeCaracteristica;

	@Basic
	@Column(name = "VALOR")
	private String valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getRede() {
		return rede;
	}

	public void setRede(String rede) {
		this.rede = rede;
	}

	public Integer getCategoriaDispositivoId() {
		return categoriaDispositivoId;
	}

	public void setCategoriaDispositivoId(Integer categoriaDispositivoId) {
		this.categoriaDispositivoId = categoriaDispositivoId;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoRFS() {
		return tipoRFS;
	}

	public void setTipoRFS(String tipoRFS) {
		this.tipoRFS = tipoRFS;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getNomeCaracteristica() {
		return nomeCaracteristica;
	}

	public void setNomeCaracteristica(String nomeCaracteristica) {
		this.nomeCaracteristica = nomeCaracteristica;
	}
	
	@Override
	public String toString() {
		return "CatalogoInfo [id=" + id + ", modelo=" + modelo + ", fabricante=" + fabricante + ", rede=" + rede
				+ ", categoriaDispositivoId=" + categoriaDispositivoId + ", tipoDispositivo=" + tipoDispositivo
				+ ", descricao=" + descricao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaDispositivoId == null) ? 0 : categoriaDispositivoId.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((nomeCaracteristica == null) ? 0 : nomeCaracteristica.hashCode());
		result = prime * result + ((nomeCategoria == null) ? 0 : nomeCategoria.hashCode());
		result = prime * result + ((rede == null) ? 0 : rede.hashCode());
		result = prime * result + ((tipoDispositivo == null) ? 0 : tipoDispositivo.hashCode());
		result = prime * result + ((tipoRFS == null) ? 0 : tipoRFS.hashCode());
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
		CatalogoInfo other = (CatalogoInfo) obj;
		if (categoriaDispositivoId == null) {
			if (other.categoriaDispositivoId != null)
				return false;
		} else if (!categoriaDispositivoId.equals(other.categoriaDispositivoId))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (nomeCaracteristica == null) {
			if (other.nomeCaracteristica != null)
				return false;
		} else if (!nomeCaracteristica.equals(other.nomeCaracteristica))
			return false;
		if (nomeCategoria == null) {
			if (other.nomeCategoria != null)
				return false;
		} else if (!nomeCategoria.equals(other.nomeCategoria))
			return false;
		if (rede == null) {
			if (other.rede != null)
				return false;
		} else if (!rede.equals(other.rede))
			return false;
		if (tipoDispositivo == null) {
			if (other.tipoDispositivo != null)
				return false;
		} else if (!tipoDispositivo.equals(other.tipoDispositivo))
			return false;
		if (tipoRFS == null) {
			if (other.tipoRFS != null)
				return false;
		} else if (!tipoRFS.equals(other.tipoRFS))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
