package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * @author luiz
 *
 */
@XmlType(name="ExpiredResource", propOrder={"terminal","cnl","at","technology","hoursReserved","status"})
@Entity
@Table(name="circ_path_inst")
@NamedNativeQuery(
		name="QueryExpiredResources",
		query=  "SELECT 'GPON' TECHNOLOGY, "+
				" ROUND((sysdate - cpi.sched_date)*24,1) HOURS_RESERVED, " +
				"       (SELECT cpas.attr_value "+
				"       FROM circ_path_attr_settings cpas, val_attr_name van "+
				"       WHERE cpas.circ_path_inst_id = cpi.circ_path_inst_id "+
				"       AND cpas.val_attr_inst_id = van.val_attr_inst_id "+
				"       AND van.group_name = 'LINE' "+
				"       AND van.attr_name = 'NUMERO_TERMINAL') numero_terminal,        "+
				"       (SELECT sas.attr_value "+
				"          FROM site_attr_settings sas, val_attr_name van "+
				"         WHERE sas.val_attr_inst_id = van.val_attr_inst_id "+
				"           AND van.group_name = 'LOCALIDADE' "+
				"           AND van.attr_name = 'CNL' "+
				"           AND sas.site_inst_id = si.site_inst_id) CNL,        "+
				"       (SELECT sas.attr_value "+
				"          FROM site_attr_settings sas, val_attr_name van "+
				"         WHERE sas.val_attr_inst_id = van.val_attr_inst_id "+
				"           AND van.group_name = 'LOCALIDADE' "+
				"           AND van.attr_name = 'SIGLA_AT' "+
				"           AND sas.site_inst_id = si.site_inst_id) AT, "+
				"       cpi.status "+
				"  FROM circ_path_inst          cpi, "+
				"       circ_path_element       cpe, "+
				"       resource_associations   ra, "+
				"       resource_inst           ri, "+
				"       resource_definition_inst rdi, "+
				"       epa                     port, "+
				"       card_inst               ci, "+
				"       equip_inst              ei, "+
				"       site_inst               si "+
				" WHERE cpi.circ_path_inst_id = cpe.circ_path_inst_id "+
				"   AND cpe.resource_inst_id = ra.resource_inst_id "+
				"   AND ra.resource_inst_id = ri.resource_inst_id "+
				"   AND ri.definition_inst_id = rdi.definition_inst_id "+
				"   AND rdi.name = 'PORTA_LOGICA_AMO' "+
				"   AND ra.target_inst_id = port.port_inst_id "+
				"   AND port.card_inst_id = ci.card_inst_id "+
				"   AND ci.equip_inst_id = ei.equip_inst_id "+
				"   AND ei.site_inst_id = si.site_inst_id "+
				"   AND cpi.type = 'PATH_TRANSPORTE_FTTX' "+
				"   AND cpi.status = 'RESERVADO' "+
				"   AND cpi.sched_date < (sysdate - (98/24)) ",
		resultClass=RetrieveExpiredResourcesEntity.class
)
public class RetrieveExpiredResourcesEntity extends EntityCommon<Long> implements Serializable  {
	
	@Id
	@Basic
	@Column(name="numero_terminal")
	private String terminal;
	
	@Basic
	@Column (name="cnl")
	private String cnl;
	
	@Basic
	@Column (name="at")
	private String at;
	
	@Basic
	@Column (name="technology")
	private String technology;
	
	@Basic
	@Column (name="status")
	private String status;
	
	@Basic
	@Column (name="hours_reserved")
	private float hoursReserved;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getCnl() {
		return cnl;
	}

	public void setCnl(String cnl) {
		this.cnl = cnl;
	}

	public String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getHoursReserved() {
		return hoursReserved;
	}

	public void setHoursReserved(float hoursReserved) {
		this.hoursReserved = hoursReserved;
	}
	
	
	
	

}
