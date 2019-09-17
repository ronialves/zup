package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;

@Table(name="conexoes_pots_msan")
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name=RetrieveMsanPotsEntity.QUERY_RESOURCE_MSAN_POTS, query=
			"select epa.port_inst_id pta_vdsl,								"+	
					"       cpm.id_conexoes_pots_msan,                      "+
					"       cpm.id_msan,                                    "+
					"       cpm.lic,                                        "+
					"       cpm.slot_pots,                                  "+
					"       cpm.porta_pots,                                 "+
					"       cpm.slot_vdsl,                                  "+
					"       cpm.porta_vdsl,                                 "+
					"       cpm.status_pots,                                "+
					"       cpm.last_status_pots,                           "+
					"       cpas.attr_value                                 "+
					" from circ_path_inst cpi,                              "+
					"     circ_path_attr_settings cpas,                     "+
					"     circ_path_element cpe,                            "+
					"     val_attr_name van,                                "+
					"     epa,                                              "+
					"     card_inst ci,                                     "+
					"     equip_inst ei,                                    "+
					"     equip_attr_settings eas,                          "+
					"     val_attr_name vaneq,                              "+
					"     conexoes_pots_msan cpm                            "+
					" where cpi.circ_path_inst_id = cpe.circ_path_inst_id   "+
					" and   cpi.circ_path_inst_id = cpas.circ_path_inst_id  "+
					" and   van.val_attr_inst_id = cpas.val_attr_inst_id    "+
					" and   epa.port_inst_id = cpe.port_inst_id             "+
					" and   ci.card_inst_id = epa.card_inst_id              "+
					" and   ei.equip_inst_id= ci.equip_inst_id              "+
					" and   ei.equip_inst_id = eas.equip_inst_id            "+
					" and   vaneq.val_attr_inst_id = eas.val_attr_inst_id   "+
					" AND   eas.attr_value = cpm.id_msan                    "+
					" and   ci.slot = cpm.slot_vdsl                         "+
					" and   epa.port_hum_id = cpm.porta_vdsl                "+
					" and   vaneq.group_name = 'EQUIPAMENTO_ENGENHARIA'     "+
					" and   vaneq.attr_name = 'NOME_EQUIPAMENTO'            "+
					" and   van.group_name = 'LINE'                         "+
					" AND   van.attr_name = 'NUMERO_TERMINAL'               "+
					" and   ei.type  NOT IN (SELECT ret.equip_type          "+
					"       FROM retrieve_equipment_type ret                "+
					"       WHERE ret.equip_group = 'EQUIPAMENTO TERMINADOR')"+						
					" AND   cpas.attr_value = ?                             "+
					" AND   rownum < 2	                                    ", 
					resultClass = RetrieveMsanPotsEntity.class)})
public class RetrieveMsanPotsEntity extends EntityCommon<Long> implements Serializable  {

	private static final long serialVersionUID = 1L;

	
    public static final String QUERY_RESOURCE_MSAN_POTS = "QueryResourceMsanPots";

	@Id
	@Basic
	@Column(name = "id_conexoes_pots_msan")
	private Long idConexoesPotsMsan;

	@Basic
	@Column(name="id_msan")
	private String idMsan;
	
	@Basic
	@Column(name="pta_vdsl")
	private String ptaVdsl;
	
	@Basic
	@Column(name="porta_vdsl")
	private String portaVdsl;

	@Basic
	@Column(name="slot_vdsl")
	private String slotVdsl;

	@Basic
	@Column(name="porta_pots")
	private String portaPots;
	
	
	@Basic
	@Column(name="slot_pots")
	private String slotPots;
	
	@Basic
	@Column(name="lic")
	private String lic;
	
	@Basic
	@Column(name="cnl_terminal")
	private String cnlTerminal;

	@Column(name="status_pots")
	private String status;
	
	@Column(name="last_status_pots")
	private String lastStatus;
	
	@Basic
	@Column(name="prefixo_mcdu_terminal")
	private String prefixoMcduTerminal;
	
	@Basic
	@Column(name="attr_value")
	private String terminal;
	
	@Transient
	private ResultTo result ;
	
	public String getLic() {
		return lic;
	}

	public void setLic(String lic) {
		this.lic = lic;
	}

	public String getCnlTerminal() {
		return cnlTerminal;
	}

	public void setCnlTerminal(String cnlTerminal) {
		this.cnlTerminal = cnlTerminal;
	}

	public String getPrefixoMcduTerminal() {
		return prefixoMcduTerminal;
	}

	public void setPrefixoMcduTerminal(String prefixoMcduTerminal) {
		this.prefixoMcduTerminal = prefixoMcduTerminal;
	}
	
	public ResultTo getResult() {
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	@Override
	public Long getId() {
		return idConexoesPotsMsan;
	}

	@Override
	public void setId(Long id) {
		this.idConexoesPotsMsan = id;
	}

	public Long getIdConexoesPotsMsan() {
		return idConexoesPotsMsan;
	}

	public void setIdConexoesPotsMsan(Long idConexoesPotsMsan) {
		this.idConexoesPotsMsan = idConexoesPotsMsan;
	}

	public String getIdMsan() {
		return idMsan;
	}

	public void setIdMsan(String idMsan) {
		this.idMsan = idMsan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastStatus() {
		return lastStatus;
	}

	public void setLastStatus(String lastStatus) {
		this.lastStatus = lastStatus;
	}

	public String getPtaVdsl() {
		return ptaVdsl;
	}

	public void setPtaVdsl(String ptaVdsl) {
		this.ptaVdsl = ptaVdsl;
	}

	public String getSlotPots() {
		return slotPots;
	}

	public void setSlotPots(String slotPots) {
		this.slotPots = slotPots;
	}

	public String getPortaVdsl() {
		return portaVdsl;
	}

	public void setPortaVdsl(String portaVdsl) {
		this.portaVdsl = portaVdsl;
	}

	public String getSlotVdsl() {
		return slotVdsl;
	}

	public void setSlotVdsl(String slotVdsl) {
		this.slotVdsl = slotVdsl;
	}

	public String getPortaPots() {
		return portaPots;
	}

	public void setPortaPots(String portaPots) {
		this.portaPots = portaPots;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

}