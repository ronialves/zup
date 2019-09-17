package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.QueryHint;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;

@Entity
@Cacheable(false)
@NamedNativeQuery(
	name = "QueryAvailabilityDSLAM", 
	query = "with " +
			" technologies as " +
			" (select 'ADSL' as technology " +
			"    from dual " +
			"  union all " +
			"  select 'ADSL2+' as technology " +
			"    from dual " +
			"  union all " +
			"  select 'VDSL' as technology from dual), " +
			"   free_circuits as " +
			" (select p.*, " +
			"         (SELECT att.attr_value " +
			"            FROM port_attr_settings att " +
			"           WHERE att.port_inst_id = p.port_inst_id " +
			"             AND att.val_attr_inst_id = ?uda_tipo_porta) technology " +
			"    from site_inst         s, " +
			"         equip_inst        e, " +
			"         card_inst         ca, " +
			"         epa               p, " +
			"         circ_path_element ce " +
			"   where 1 = 1 " +
			"     and exists ( /* uda_cnl */ " +
			"          select 1	" +
			"            from site_attr_settings su " + 
			"           where su.SITE_INST_ID = s.SITE_INST_ID " +
			"             and su.VAL_ATTR_INST_ID = ?uda_cnl " +
			"             and su.ATTR_VALUE = ?cnl) " +
			"     and exists ( /* uda_sigla_at */ " +
			"          select 1	" +
			"            from site_attr_settings su2 " +
			"           where su2.SITE_INST_ID = s.SITE_INST_ID " +
			"             and su2.VAL_ATTR_INST_ID = ?uda_sigla_at " +
			"             and su2.ATTR_VALUE = ?sigla_at) " +
			"     and e.SITE_INST_ID = s.site_inst_id " +
			"     AND e.status = 'ATIVO' " +
			"     AND e.eq_class = 'S' " +
			"     aND e.type = 'DSLAM' " +
			"     and exists ( /* uda_tipo_rede */ " +
			"          select 1 " +
			"            from equip_attr_settings eu " +
			"           where eu.EQUIP_INST_ID = e.EQUIP_INST_ID " +
			"             and eu.val_attr_inst_id = ?uda_tipo_rede " +
			"             and eu.attr_value = 'METRO ETHERNET') " +
			"     and ca.EQUIP_INST_ID = e.equip_inst_id " +
			"     and ca.status = 'ATIVO' " +
			"     and exists ( /* uda_protocolo */ " +
			"          select 1 " +
			"            from card_attr_settings cas " +
			"           where cas.CARD_INST_ID = ca.card_inst_id " +
			"             and val_attr_inst_id = ?uda_protocolo " +
			"             and cas.ATTR_VALUE = ?protocolo) " +
			"     and p.equip_inst_id = e.EQUIP_INST_ID " +
			"     and p.card_inst_id = ca.card_inst_id " +
			"     and p.bandwidth = 'PAR_DE_COBRE' " +
			"     and p.status = 'LIVRE' " +
			"     and p.circ_path_inst_id IS NULL " +
			"     and ce.port_inst_id = p.port_inst_id " +
			"     and exists (select 1 " +
			"            from circ_path_inst c " +
			"           where ce.circ_path_inst_id = c.circ_path_inst_id " +
			"             AND c.status = 'CONFIGURADO' " +
			"             AND c.customer_id IS NULL " +
			"             AND c.type = 'PATH_SPEEDY') " +
			"     and exists " +
			"   (select 1 " +
			"            from epa pa " +
			"           where pa.port_inst_id = " +
			"                 (SELECT MAX(cc.port_inst_id) " +
			"                    FROM circ_path_element cc " +
			"                   WHERE cc.circ_path_inst_id = ce.circ_path_inst_id" + 
			"                    AND cc.port_inst_id != ce.port_inst_id) " +
			"             AND pa.BANDWIDTH = 'PVC' " +
			"             AND NOT EXISTS " +
			"           ( /* uda_vpn */ " +
			"                  SELECT 1 " +
			"                    FROM equip_attr_settings eas " +
			"                   WHERE eas.equip_inst_id = pa.equip_inst_id " +
			"                     AND eas.val_attr_inst_id = ?uda_vpn " +
			"                     AND eas.attr_value = 'SIM') " +
			"             AND 'DINAMICO' = " +
			"                 ( /* uda_ip */ " +
			"                  SELECT attr_value " +
			"                    FROM port_attr_settings pu " +
			"                   WHERE pu.val_attr_inst_id = ?uda_ip " +
			"                     and pu.port_inst_id = pa.port_inst_id))), " +
			" free_circuits_grouped as " +
			" (select count(1) as freePorts, technology " +
			"   from free_circuits " +
			"   group by technology) " +
			" select tec.*, nvl(fcg.freePorts, 0) as freePorts, velocity velocity_down " +
			"  from technologies tec " +
			" left join free_circuits_grouped fcg " +
			"    on tec.technology = fcg.technology, PORT_VELOCITY_PRIORITY pvp, " +
			" EQUIPMENT_CATALOG ec, PORT_CATALOG pc, NETWORK_CATALOG nc " +
			" where 1 = 1 " + 
			"   and ec.ID_EQUIPMENT_CATALOG = pvp.ID_EQUIPMENT_CATALOG " +
			"   AND pc.ID_PORT_CATALOG = pvp.ID_PORT_CATALOG " +
			"   AND nc.ID_NETWORK_CATALOG = pvp.ID_NETWORK_CATALOG " +
			"   AND ec.EQUIPMENT_DESCRIPTION = 'DSLAM' " +
			"   AND nc.NETWORK_DESCRIPTION = 'METRO ETHERNET' " +
			"   AND pc.PORT_DESCRIPTION = tec.technology ",  
	resultClass = RetrieveAvailabilityDslamEntity.class, 
	hints = { @QueryHint(name = "eclipselink.query-results-cache", value = "false") 
}) 
public class RetrieveAvailabilityDslamEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "technology")
	private String technology;
	
	@Column(name = "freePorts")
	private Integer quantityPort;

	@Column(name = "velocity_down")
	private Integer speed;

	@Transient
	private ResultTo result;
	
	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Integer getQuantityPort() {
		return quantityPort;
	}

	public void setQuantityPort(Integer quantityPort) {
		this.quantityPort = quantityPort;
	}
	
	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public ResultTo getResult() {
		if (null == result) {
			result = new ResultTo();
		}
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "RetrieveAvailabilityDslamEntity [technology=" + technology + ", quantityPort=" + quantityPort
				+ ", speed=" + speed + "]";
	}
	
}
