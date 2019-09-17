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


/**
 * BEATRIXTWO-22 | DEMOSS-2155
 * 
 * @project Beatrix Fase 2
 * @author renan.n.Oliveira
 * @since 201709
 */

@Entity
@NamedStoredProcedureQuery(name = "reserve", resultClasses = ReserveEntity.class, procedureName = "SAGREMAN.GVT_SP_SOA_CRIA_RS_CTRL", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_cnl", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tec_acesso", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tec_voz", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_id_acesso", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_sos", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_street_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_lote", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_ident_equip1", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_ident_equip2", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_ident_equip3", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tipo_reserva", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_origem", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_aux1", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_cod", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_msg", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_in_tipo_documento", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_classe_servico", type = String.class)})

public class ReserveEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name = "p_in_cnl")
	private Integer cnl;

	@Basic
	@Column(name = "p_in_tec_acesso")
	private String tecAcesso;

	@Basic
	@Column(name = "p_in_tec_voz")
	private String tecVoz;

	@Basic
	@Column(name = "p_in_id_acesso")
	private String idAcesso;

	@Basic
	@Column(name = "p_in_sos")
	private String inSos;

	@Basic
	@Column(name = "p_in_street_code")
	private String streetCode;

	@Basic
	@Column(name = "p_in_lote")
	private String inLote;

	@Basic
	@Column(name = "p_in_ident_equip1")
	private String identEquip1;

	@Basic
	@Column(name = "p_in_ident_equip2")
	private String identEquip2;

	@Basic
	@Column(name = "p_in_ident_equip3")
	private String identEquip3;

	@Basic
	@Column(name = "p_in_tipo_reserva")
	private String tipoReserva;

	@Basic
	@Column(name = "p_in_origem")
	private String inOrigem;

	@Basic
	@Column(name = "p_out_aux1")
	private String aux1;

	@Id
	@Basic
	@Column(name = "p_out_cod")
	private Integer cod;

	@Basic
	@Column(name = "p_out_msg")
	private String msg;

	@Basic
	@Column(name = "p_in_tipo_documento")
	private String tipoDocumento;

	@Basic
	@Column(name = "p_in_classe_servico")
	private String classeServico;

	@Transient
	private ResultTo result;

	public ReserveEntity() {
		super();
	}
	
	public ReserveEntity(Integer cnl, String tecAcesso, String tecVoz, String idAcesso,
			String inSos, String streetCode, String inLote, String identEquip1, String identEquip2,
			String identEquip3, String tipoReserva, String inOrigem, String aux1,
			Integer cod, String msg, String tipoDocumento, String classeServico) {
		super();
		this.cnl = cnl;
		this.tecAcesso = tecAcesso;
		this.tecVoz = tecVoz;
		this.idAcesso = idAcesso;
		this.inSos = inSos;
		this.streetCode = streetCode;
		this.inLote = inLote;
		this.identEquip1 = identEquip1;
		this.identEquip2 = identEquip2;
		this.identEquip3 = identEquip3;
		this.tipoReserva = tipoReserva;
		this.inOrigem = inOrigem;
		this.aux1 = aux1;
		this.cod = cod;
		this.msg = msg;
		this.tipoDocumento = tipoDocumento;
		this.classeServico = classeServico;
	}

	public Integer getCnl() {
		return cnl;
	}

	public void setCnl(Integer cnl) {
		this.cnl = cnl;
	}

	public String getTecAcesso() {
		return tecAcesso;
	}

	public void setTecAcesso(String tecAcesso) {
		this.tecAcesso = tecAcesso;
	}

	public String getTecVoz() {
		return tecVoz;
	}

	public void setTecVoz(String tecVoz) {
		this.tecVoz = tecVoz;
	}

	public String getIdAcesso() {
		return idAcesso;
	}

	public void setIdAcesso(String idAcesso) {
		this.idAcesso = idAcesso;
	}

	public String getInSos() {
		return inSos;
	}

	public void setInSos(String inSos) {
		this.inSos = inSos;

	}

	public String getStreetCode() {
		return streetCode;
	}

	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}

	public String getInLote() {
		return inLote;
	}

	public void setInLote(String inLote) {
		this.inLote = inLote;
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

	public String getIdentEquip3() {
		return identEquip3;
	}

	public void setIdentEquip3(String identEquip3) {
		this.identEquip3 = identEquip3;
	}

	public String getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	public String getInOrigem() {
		return inOrigem;
	}

	public void setInOrigem(String inOrigem) {
		this.inOrigem = inOrigem;
	}

	public String getAux1() {
		return aux1;
	}

	public void setAux1(String aux1) {
		this.aux1 = aux1;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getClasseServico() {
		return classeServico;
	}

	public void setClasseServico(String classeServico) {
		this.classeServico = classeServico;
	}

	public ResultTo getResult() {
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
}
