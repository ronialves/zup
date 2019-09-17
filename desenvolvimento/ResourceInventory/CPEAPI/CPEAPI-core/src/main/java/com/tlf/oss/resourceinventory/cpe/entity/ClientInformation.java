package com.tlf.oss.resourceinventory.cpe.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ClientInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String QUERY_RETRIEVE_CLIENT_INFORMATION = "RetrieveClientInformation";

	@Id
	@Basic
	@Column(name = "ID")
	private String id;
	
	@Basic
	@Column(name = "SERVICE_ID")
	private String serviceId;

	@Basic
	@Column(name = "TIPO_RFS")
	private String tipoRfs;

	@Basic
	@Column(name = "STATUS")
	private String status;

	@Basic
	@Column(name = "TELEPHONE_NUMBER")
	private String numeroTelefone;

	@Basic
	@Column(name = "GPON_SERIAL_NUMBER")
	private String numeroSerialGpon;

	@Basic
	@Column(name = "SERIAL_NUMBER")
	private String numeroSerial;

	@Basic
	@Column(name = "MACADDRESS")
	private String macAddress;

	@Basic
	@Column(name = "CATEGORIA_ESPERADA")
	private String categoriaEsperada;

	@Basic
	@Column(name = "CATEGORIA_CORRENTE")
	private String categoriaCorrente;

	@Basic
	@Column(name = "EQUIPMENT_MODEL")
	private String model;

	@Basic
	@Column(name = "EQUIPMENT_VENDOR")
	private String vendor;

	@Basic
	@Column(name = "ID_FXS")
	private String idFxs;

	@Basic
	@Column(name = "CATALOGO_DISPOSITIVO_ID")
	private Integer catalogoDispositivoId;

	@Transient
	private List<CaracteristicaDispositivo> caracteristicas;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getTipoRfs() {
		return tipoRfs;
	}

	public void setTipoRfs(String tipoRfs) {
		this.tipoRfs = tipoRfs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getNumeroSerialGpon() {
		return numeroSerialGpon;
	}

	public void setNumeroSerialGpon(String numeroSerialGpon) {
		this.numeroSerialGpon = numeroSerialGpon;
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

	public String getCategoriaEsperada() {
		return categoriaEsperada;
	}

	public void setCategoriaEsperada(String categoriaEsperada) {
		this.categoriaEsperada = categoriaEsperada;
	}

	public String getCategoriaCorrente() {
		return categoriaCorrente;
	}

	public void setCategoriaCorrente(String categoriaCorrente) {
		this.categoriaCorrente = categoriaCorrente;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getIdFxs() {
		return idFxs;
	}

	public void setIdFxs(String idFxs) {
		this.idFxs = idFxs;
	}

	public Integer getCatalogoDispositivoId() {
		return catalogoDispositivoId;
	}

	public void setCatalogoDispositivoId(Integer catalogoDispositivoId) {
		this.catalogoDispositivoId = catalogoDispositivoId;
	}

	public List<CaracteristicaDispositivo> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<CaracteristicaDispositivo> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caracteristicas == null) ? 0 : caracteristicas.hashCode());
		result = prime * result + ((catalogoDispositivoId == null) ? 0 : catalogoDispositivoId.hashCode());
		result = prime * result + ((categoriaCorrente == null) ? 0 : categoriaCorrente.hashCode());
		result = prime * result + ((categoriaEsperada == null) ? 0 : categoriaEsperada.hashCode());
		result = prime * result + ((idFxs == null) ? 0 : idFxs.hashCode());
		result = prime * result + ((macAddress == null) ? 0 : macAddress.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((numeroSerial == null) ? 0 : numeroSerial.hashCode());
		result = prime * result + ((numeroSerialGpon == null) ? 0 : numeroSerialGpon.hashCode());
		result = prime * result + ((numeroTelefone == null) ? 0 : numeroTelefone.hashCode());
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoRfs == null) ? 0 : tipoRfs.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
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
		ClientInformation other = (ClientInformation) obj;
		if (caracteristicas == null) {
			if (other.caracteristicas != null)
				return false;
		} else if (!caracteristicas.equals(other.caracteristicas))
			return false;
		if (catalogoDispositivoId == null) {
			if (other.catalogoDispositivoId != null)
				return false;
		} else if (!catalogoDispositivoId.equals(other.catalogoDispositivoId))
			return false;
		if (categoriaCorrente == null) {
			if (other.categoriaCorrente != null)
				return false;
		} else if (!categoriaCorrente.equals(other.categoriaCorrente))
			return false;
		if (categoriaEsperada == null) {
			if (other.categoriaEsperada != null)
				return false;
		} else if (!categoriaEsperada.equals(other.categoriaEsperada))
			return false;
		if (idFxs == null) {
			if (other.idFxs != null)
				return false;
		} else if (!idFxs.equals(other.idFxs))
			return false;
		if (macAddress == null) {
			if (other.macAddress != null)
				return false;
		} else if (!macAddress.equals(other.macAddress))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (numeroSerial == null) {
			if (other.numeroSerial != null)
				return false;
		} else if (!numeroSerial.equals(other.numeroSerial))
			return false;
		if (numeroSerialGpon == null) {
			if (other.numeroSerialGpon != null)
				return false;
		} else if (!numeroSerialGpon.equals(other.numeroSerialGpon))
			return false;
		if (numeroTelefone == null) {
			if (other.numeroTelefone != null)
				return false;
		} else if (!numeroTelefone.equals(other.numeroTelefone))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoRfs == null) {
			if (other.tipoRfs != null)
				return false;
		} else if (!tipoRfs.equals(other.tipoRfs))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientInformation [serviceId=" + serviceId + ", tipoRfs=" + tipoRfs + ", status=" + status
				+ ", numeroTelefone=" + numeroTelefone + ", numeroSerialGpon=" + numeroSerialGpon + ", numeroSerial="
				+ numeroSerial + ", macAddress=" + macAddress + ", categoriaEsperada=" + categoriaEsperada
				+ ", categoriaCorrente=" + categoriaCorrente + ", model=" + model + ", vendor=" + vendor + ", idFxs="
				+ idFxs + ", catalogoDispositivoId=" + catalogoDispositivoId + ", caracteristicas=" + caracteristicas
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
