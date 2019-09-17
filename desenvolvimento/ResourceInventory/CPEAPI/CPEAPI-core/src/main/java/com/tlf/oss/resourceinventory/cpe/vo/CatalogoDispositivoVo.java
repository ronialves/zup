package com.tlf.oss.resourceinventory.cpe.vo;

import java.util.List;

public class CatalogoDispositivoVo {

	private Integer id;
	private String modelo;
	private String fabricante;
	private String rede;
	private Integer categoriaDispositivoId;
	private String descricao;
	private String sku;
	private CategoriaDispositivoVo categoriaDispositivo;
	private List<CaracteristicaDispositivoVo> caracteristicas;
	private boolean hasAssociatedDevices;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public CategoriaDispositivoVo getCategoriaDispositivo() {
		return categoriaDispositivo;
	}

	public void setCategoriaDispositivo(CategoriaDispositivoVo categoriaDispositivo) {
		this.categoriaDispositivo = categoriaDispositivo;
	}

	public List<CaracteristicaDispositivoVo> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<CaracteristicaDispositivoVo> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public boolean isHasAssociatedDevices() {
		return hasAssociatedDevices;
	}

	public void setHasAssociatedDevices(boolean hasAssociatedDevices) {
		this.hasAssociatedDevices = hasAssociatedDevices;
	}

	@Override
	public String toString() {
		return "CatalogoDispositivoVo [id=" + id + ", modelo=" + modelo + ", fabricante=" + fabricante + ", rede="
				+ rede + ", categoriaDispositivoId=" + categoriaDispositivoId + ", descricao=" + descricao + ", sku="
				+ sku + ", categoriaDispositivo=" + categoriaDispositivo + ", caracteristicas=" + caracteristicas
				+ ", hasAssociatedDevices=" + hasAssociatedDevices + "]";
	}
}
