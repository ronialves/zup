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
@Table(name = "DISPOSITIVO_FISICO")
public class DispositivoFisico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CPE_OWNER.DISPOSITIVO_FISICO_SEQ", sequenceName = "CPE_OWNER.DISPOSITIVO_FISICO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPE_OWNER.DISPOSITIVO_FISICO_SEQ")
	@Column(name = "ID")
	private Integer id;

	@Basic
	@Column(name = "NUMERO_SERIAL")
	private String numeroSerial;

	@Basic
	@Column(name = "MACADDRESS")
	private String macAddress;

	@Basic
	@Column(name = "CATEGORIA_DISPOSITIVO_ESPERADA")
	private Integer categoriaDispositivoEsperada;

	@Basic
	@Column(name = "CATEGORIA_DISPOSITIVO_CORRENTE")
	private Integer categoriaDispositivoCorrente;

	@Basic
	@Column(name = "CATALOGO_DISPOSITIVO_ID")
	private Integer catalagoDispositivoId;

	@Basic
	@Column(name = "NUMERO_SERIAL_GPON")
	private String numeroSerialGpon;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroSerial() {
		return numeroSerial;
	}

	public void setNumeroSerial(String numeroSerial) {
		this.numeroSerial = numeroSerial;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Integer getCategoriaDispositivoEsperada() {
		return categoriaDispositivoEsperada;
	}

	public void setCategoriaDispositivoEsperada(Integer categoriaDispositivoEsperada) {
		this.categoriaDispositivoEsperada = categoriaDispositivoEsperada;
	}

	public Integer getCategoriaDispositivoCorrente() {
		return categoriaDispositivoCorrente;
	}

	public void setCategoriaDispositivoCorrente(Integer categoriaDispositivoCorrente) {
		this.categoriaDispositivoCorrente = categoriaDispositivoCorrente;
	}

	public Integer getCatalagoDispositivoId() {
		return catalagoDispositivoId;
	}

	public void setCatalagoDispositivoId(Integer catalagoDispositivoId) {
		this.catalagoDispositivoId = catalagoDispositivoId;
	}

	public String getNumeroSerialGpon() {
		return numeroSerialGpon;
	}

	public void setNumeroSerialGpon(String numeroSerialGpon) {
		this.numeroSerialGpon = numeroSerialGpon;
	}

	@Override
	public String toString() {
		return "DispositivoFisico [id=" + id + ", numeroSerial=" + numeroSerial + ", macAddress=" + macAddress
				+ ", categoriaDispositivoEsperada=" + categoriaDispositivoEsperada + ", categoriaDispositivoCorrente="
				+ categoriaDispositivoCorrente + ", catalagoDispositivoId=" + catalagoDispositivoId
				+ ", numeroSerialGpon=" + numeroSerialGpon + "]";
	}

}
