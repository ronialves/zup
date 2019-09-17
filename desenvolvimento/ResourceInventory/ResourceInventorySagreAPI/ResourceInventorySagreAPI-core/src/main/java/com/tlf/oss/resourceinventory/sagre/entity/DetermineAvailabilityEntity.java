package com.tlf.oss.resourceinventory.sagre.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.sagre.to.ResultTo;

@SuppressWarnings("serial")
@Entity
@NamedStoredProcedureQuery(name = "determineAvailability", resultClasses = DetermineAvailabilityEntity.class, procedureName = "SAGREMAN.GVT_SP_SOA_CONS_COB_FIBRA", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_cnl", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_street_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_address_num", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_status", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_fail_diag", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_bloqueio_endereco", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_tecnology", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_estacao_telefonica", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_ident_equip1", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_ident_equip2", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_bloqueio_equipamento", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_razao_bloqueio_eqpto", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_equipment_type", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_qtd_fibras", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_switch", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_compartilhamento", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_armario_optico", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_tipo_cobertura", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_cod", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_msg", type = String.class) })
public class DetermineAvailabilityEntity implements Serializable {

	
	@Basic
	@Column(name = "p_in_cnl")
	private Integer cnl;

	@Basic
	@Column(name = "p_in_street_code")
	private String streetCode;

	@Basic
	@Column(name = "p_in_address_num")
	private String streetNumber;

	@Basic
	@Column(name = "p_out_status")
	private Integer status;

	@Basic
	@Column(name = "p_out_fail_diag")
	private Integer failDiag;

	@Basic
	@Column(name = "p_out_bloqueio_endereco")
	private Integer blockageAddress;

	@Basic
	@Column(name = "p_out_tecnology")
	private Integer technology;

	@Basic
	@Column(name = "p_out_estacao_telefonica")
	private String station;

	@Basic
	@Column(name = "p_out_ident_equip1")
	private String identEquip1;

	@Basic
	@Column(name = "p_out_ident_equip2")
	private String identEquip2;

	@Basic
	@Column(name = "p_out_bloqueio_equipamento")
	private Integer blockageEquipment;

	@Basic
	@Column(name = "p_out_razao_bloqueio_eqpto")
	private String blockageReason;

	@Basic
	@Column(name = "p_out_equipment_type")
	private String equipmentType;

	@Basic
	@Column(name = "p_out_qtd_fibras")
	private Integer quantityPort;

	@Basic
	@Column(name = "p_out_switch")
	private String switchName;

	@Basic
	@Column(name = "p_out_compartilhamento")
	private Integer share;

	@Basic
	@Column(name = "p_out_armario_optico")
	private String cabinetName;

	@Basic
	@Column(name = "p_out_tipo_cobertura")
	private String typeCoverage;

	@Id
	@Basic
	@Column(name = "p_out_cod")
	private Integer returnCode;

	@Basic
	@Column(name = "p_out_msg")
	private String message;

	@Transient
	private ResultTo result;

	public DetermineAvailabilityEntity() {
		super();
	}

	public DetermineAvailabilityEntity(Integer cnl, String streetCode, String streetNumber, Integer status,
			Integer failDiag, Integer blockageAddress, Integer technology, String station, String identEquip1,
			String identEquip2, Integer blockageEquipment, String blockageReason, String equipmentType,
			Integer quantityPort, String switchName, Integer share, String cabinetName, String typeCoverage,
			Integer returnCode, String message, ResultTo result) {
		super();
		this.cnl = cnl;
		this.streetCode = streetCode;
		this.streetNumber = streetNumber;
		this.status = status;
		this.failDiag = failDiag;
		this.blockageAddress = blockageAddress;
		this.technology = technology;
		this.station = station;
		this.identEquip1 = identEquip1;
		this.identEquip2 = identEquip2;
		this.blockageEquipment = blockageEquipment;
		this.blockageReason = blockageReason;
		this.equipmentType = equipmentType;
		this.quantityPort = quantityPort;
		this.switchName = switchName;
		this.share = share;
		this.cabinetName = cabinetName;
		this.typeCoverage = typeCoverage;
		this.returnCode = returnCode;
		this.message = message;
		this.result = result;
	}

	public Integer getCnl() {
		return cnl;
	}

	public void setCnl(Integer cnl) {
		this.cnl = cnl;
	}

	public String getStreetCode() {
		return streetCode;
	}

	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getFailDiag() {
		return failDiag;
	}

	public void setFailDiag(Integer failDiag) {
		this.failDiag = failDiag;
	}

	public Integer getBlockageAddress() {
		return blockageAddress;
	}

	public void setBlockageAddress(Integer blockageAddress) {
		this.blockageAddress = blockageAddress;
	}

	public Integer getTechnology() {
		return technology;
	}

	public void setTechnology(Integer technology) {
		this.technology = technology;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getIdentEquip1() {
		return identEquip1;
	}

	public void setIdentEquip1(String identEquip1) {
		this.identEquip1 = identEquip1;
	}

	public String getIdentEquip2() {
		return identEquip2;
	}

	public void setIdentEquip2(String identEquip2) {
		this.identEquip2 = identEquip2;
	}

	public Integer getBlockageEquipment() {
		return blockageEquipment;
	}

	public void setBlockageEquipment(Integer blockageEquipment) {
		this.blockageEquipment = blockageEquipment;
	}

	public String getBlockageReason() {
		return blockageReason;
	}

	public void setBlockageReason(String blockageReason) {
		this.blockageReason = blockageReason;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public Integer getQuantityPort() {
		return quantityPort;
	}

	public void setQuantityPort(Integer quantityPort) {
		this.quantityPort = quantityPort;
	}

	public String getSwitchName() {
		return switchName;
	}

	public void setSwitchName(String switchName) {
		this.switchName = switchName;
	}

	public Integer getShare() {
		return share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public String getCabinetName() {
		return cabinetName;
	}

	public void setCabinetName(String cabinetName) {
		this.cabinetName = cabinetName;
	}

	public String getTypeCoverage() {
		return typeCoverage;
	}

	public void setTypeCoverage(String typeCoverage) {
		this.typeCoverage = typeCoverage;
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultTo getResult() {
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	@Override
	public String toString() {
		String retorno = this.getClass().getSimpleName() + "=";
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				String name = field.getName();
				Object value = field.get(this);
				retorno += name + ":" + value + ";";
				
				} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return retorno;
	}
}
