package com.tlf.oss.resourceinventory.sagre.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.sagre.to.ResultTo;


@Entity
@NamedStoredProcedureQuery(name = "determineResourceAvailabilityMetallic", resultClasses = DetermineResourceAvailabilityMetallic.class, procedureName = "SAGREMAN.GVT_SP_SOA_CONSULTA_COBERTURA", parameters = {
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
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_shadow", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_equipment_type", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_qtd_pares", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_switch", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_compartilhamento", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_armario_optico", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_armario_metalico", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_cod", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_msg", type = String.class),
		})
public class DetermineResourceAvailabilityMetallic implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic
	@Column(name = "p_in_cnl")
	private Integer cnl;
	
	@Basic
	@Column(name = "p_in_street_code")
	private String streetCode;
	
	@Basic
	@Column(name = "p_in_address_num")
	private String addressNum;
	
	@Basic
	@Column(name = "p_out_qtd_pares")
	private Integer qtdPares;
	
	@Basic
	@Column(name = "p_out_ident_equip1")
	private String identEquip1;
	
	@Basic
	@Column(name = "p_out_armario_optico")
	private String armarioOptico;
	

	@Basic
	@Column(name = "p_out_ident_equip2")
	private String identEquip2;
	
	@Basic
	@Column(name = "p_out_equipment_type")
	private String equipmentType;
	
	@Basic
	@Column(name = "p_out_status")
	private Integer status;
	
	
	@Basic
	@Column(name = "p_out_switch")
	private String switchName;
	
	
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
	@Column(name = "p_out_bloqueio_equipamento")
	private Integer blockageEquipment;
	
	@Id
	@Basic
	@Column(name = "p_out_cod")
	private Integer returnCode;
	
	@Basic
	@Column(name = "p_out_estacao_telefonica")
	private String estacaoTelefonica;
	
	@Basic
	@Column(name = "p_out_razao_bloqueio_eqpto")
	private String razaoBloqueio;
	
	@Basic
	@Column(name = "p_out_shadow")
	private Integer shadow;
	
	@Basic
	@Column(name = "p_out_compartilhamento")
	private Integer compartilhamento;
	
	@Basic
	@Column(name = "p_out_armario_metalico")
	private String armarioMetalico;
	
	@Basic
	@Column(name = "p_out_msg")
	private String message;
	
	@Transient
	private ResultTo result;
	
	public DetermineResourceAvailabilityMetallic() {
		super();
	}


	public DetermineResourceAvailabilityMetallic(Integer cnl, String streetCode, String addressNum, Integer qtdPares,
			String identEquip1, String armarioOptico, String identEquip2, Integer blockageEquipment, String equipmentType, Integer status,
			Integer failDiag, Integer bloqueioEndereco, Integer technology, Integer blockageAddress,
			Integer resultCode, String estacaoTelefonica, String razaoBloqueio, Integer shadow,
			Integer compartilhamento, String armarioMetalico, String message, ResultTo result, String switchName) {
		super();
		this.cnl = cnl;
		this.streetCode = streetCode;
		this.addressNum = addressNum;
		this.qtdPares = qtdPares;
		this.identEquip1 = identEquip1;
		this.armarioOptico = armarioOptico;
		this.identEquip2 = identEquip2;
		this.blockageEquipment = blockageEquipment;
		this.equipmentType = equipmentType;
		this.status = status;
		this.failDiag = failDiag;
		this.blockageAddress = blockageAddress;
		this.technology = technology;
		this.returnCode = resultCode;
		this.estacaoTelefonica = estacaoTelefonica;
		this.razaoBloqueio = razaoBloqueio;
		this.shadow = shadow;
		this.compartilhamento = compartilhamento;
		this.armarioMetalico = armarioMetalico;
		this.message = message;
		this.result = result;
		this.switchName = switchName;
		
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


	public String getAddressNum() {
		return addressNum;
	}


	public void setAddressNum(String addressNum) {
		this.addressNum = addressNum;
	}


	public Integer getQtdPares() {
		return qtdPares;
	}


	public void setQtdPares(Integer qtdPares) {
		this.qtdPares = qtdPares;
	}


	public String getIdentEquip1() {
		return identEquip1;
	}


	public void setIdentEquip1(String identEquip1) {
		this.identEquip1 = identEquip1;
	}


	public String getArmarioOptico() {
		return armarioOptico;
	}


	public void setArmarioOptico(String armarioOptico) {
		this.armarioOptico = armarioOptico;
	}


	public String getIdentEquip2() {
		return identEquip2;
	}


	public void setIdentEquip2(String identEquip2) {
		this.identEquip2 = identEquip2;
	}


	public String getEquipmentType() {
		return equipmentType;
	}


	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
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


	


	public String getSwitchName() {
		return switchName;
	}


	public void setSwitchName(String switchName) {
		this.switchName = switchName;
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


	public Integer getBlockageEquipment() {
		return blockageEquipment;
	}


	public void setBlockageEquipment(Integer blockageEquipment) {
		this.blockageEquipment = blockageEquipment;
	}


	public Integer getReturnCode() {
		return returnCode;
	}


	public void setReturnCode(Integer resultCode) {
		this.returnCode = resultCode;
	}


	public String getEstacaoTelefonica() {
		return estacaoTelefonica;
	}


	public void setEstacaoTelefonica(String estacaoTelefonica) {
		this.estacaoTelefonica = estacaoTelefonica;
	}


	public String getRazaoBloqueio() {
		return razaoBloqueio;
	}


	public void setRazaoBloqueio(String razaoBloqueio) {
		this.razaoBloqueio = razaoBloqueio;
	}


	public Integer getShadow() {
		return shadow;
	}


	public void setShadow(Integer shadow) {
		this.shadow = shadow;
	}


	public Integer getCompartilhamento() {
		return compartilhamento;
	}


	public void setCompartilhamento(Integer compartilhamento) {
		this.compartilhamento = compartilhamento;
	}


	public String getArmarioMetalico() {
		return armarioMetalico;
	}


	public void setArmarioMetalico(String armarioMetalico) {
		this.armarioMetalico = armarioMetalico;
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
	
}
