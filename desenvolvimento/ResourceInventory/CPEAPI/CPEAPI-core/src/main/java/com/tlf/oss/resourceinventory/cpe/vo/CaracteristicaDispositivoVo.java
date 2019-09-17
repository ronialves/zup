package com.tlf.oss.resourceinventory.cpe.vo;

import com.tlf.oss.resourceinventory.cpe.entity.CatalogoDispositivo;

public class CaracteristicaDispositivoVo {

	private Integer id;
	private String nome;
	private String valor;
	private Integer catalagoDispositivoId;
	private CatalogoDispositivo catalogo;

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

	public Integer getCatalagoDispositivoId() {
		return catalagoDispositivoId;
	}

	public void setCatalagoDispositivoId(Integer catalagoDispositivoId) {
		this.catalagoDispositivoId = catalagoDispositivoId;
	}

	public CatalogoDispositivo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(CatalogoDispositivo catalogo) {
		this.catalogo = catalogo;
	}

	@Override
	public String toString() {
		return "CaracteristicaDispositivoVo [id=" + id + ", nome=" + nome + ", valor=" + valor + ", catalagoDispositivoId="
				+ catalagoDispositivoId + "]";
	}

}
