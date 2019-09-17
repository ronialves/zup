package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;

@Table(name="aloc_minidslam")
@Entity
@Cacheable(false)
@NamedNativeQueries({
	@NamedNativeQuery(name="QueryCheckMSAN",query=
			"SELECT am.tipo "+
					"FROM aloc_minidslam am "+
					"WHERE am.cnl = ? "+
					"AND am.at = ? "+
					"AND am.armario = ? "+
					"AND upper(am.tipo) = 'MSAN' "+
			"AND ROWNUM < 2",
			hints={
				    @QueryHint(name="eclipselink.query-results-cache", value="false")
				  }),
	@NamedNativeQuery(name="QueryAvailabilityMSAN",query=
			" WITH technologies AS                                                         "+
					"  (SELECT 'ADSL' AS technology                                        "+
					"     FROM dual                                                        "+
					"   UNION ALL                                                          "+
					"   SELECT 'ADSL2+' AS technology                                      "+
					"     FROM dual                                                        "+
					"   UNION ALL                                                          "+
					"   SELECT 'VDSL' AS technology                                        "+
					"     FROM dual),                                                      "+
					" free_circuits AS                                                     "+
					"  (SELECT p.*,                                                        "+
					"          (SELECT att.attr_value                                      "+
					"             FROM port_attr_settings att                              "+
					"            WHERE att.port_inst_id = p.port_inst_id                   "+
					"              AND att.val_attr_inst_id = ? 			               "+
					"              AND att.attr_value = 'VDSL') technology                 "+
					"     FROM circ_path_inst      c,                                      "+
					"          circ_path_element   ce,                                     "+
					"          epa                 p,                                      "+
					"          epa                 pa,                                     "+
					"          card_inst           ca,                                     "+
					"          card_attr_settings  cas,                                    "+
					"          equip_attr_settings eu,                                     "+
					"          equip_attr_settings eg,                                     "+
					"          equip_inst          e,                                      "+
					"          site_attr_settings  su,                                     "+
					"          site_inst           s,                                      "+
					"          aloc_minidslam      am,                                     "+
					"          conexoes_pots_msan  cpm                                     "+
					"    WHERE e.equip_inst_id = ca.equip_inst_id                          "+
					"      AND ca.card_inst_id = p.card_inst_id                            "+
					"      AND p.port_inst_id = ce.port_inst_id                            "+
					"      AND ce.circ_path_inst_id = c.circ_path_inst_id                  "+
					"      AND e.equip_inst_id = eu.equip_inst_id                          "+
					"      AND e.equip_inst_id = eg.equip_inst_id						   "+
					"      AND e.site_inst_id = s.site_inst_id                             "+
					"      AND s.site_inst_id = su.site_inst_id                            "+
					"      AND eg.attr_value = cpm.id_msan                		           "+
					"      AND ca.slot = cpm.slot_vdsl       			                   "+
					"      AND p.port_hum_id = cpm.porta_vdsl                              "+
					"      AND NOT EXISTS (SELECT 1                                        "+
					"             FROM equip_attr_settings eas                             "+
					"            WHERE eas.equip_inst_id = pa.equip_inst_id                "+
					"              AND eas.val_attr_inst_id = ? 		                   "+
					"              AND eas.attr_value = 'SIM')                             "+
					"      AND 'DINAMICO' =                                                "+
					"          (SELECT attr_value                                          "+
					"             FROM port_attr_settings pu                               "+
					"            WHERE pu.val_attr_inst_id = ? 			                   "+
					"              AND pu.port_inst_id = pa.port_inst_id)                  "+
					"      AND c.status = 'CONFIGURADO'                                    "+
					"      AND c.customer_id IS NULL                                       "+
					"      AND c.type = 'PATH_SPEEDY'                                      "+
					"      AND pa.port_inst_id =                                           "+
					"          (SELECT MAX(cc.port_inst_id)                                "+
					"             FROM circ_path_element cc                                "+
					"            WHERE cc.circ_path_inst_id = c.circ_path_inst_id          "+
					"              AND cc.port_inst_id != p.port_inst_id)                  "+
					"      AND EXISTS                                                      "+
					"    (SELECT 1                                                         "+
					"             FROM site_attr_settings sas                              "+
					"            WHERE sas.site_inst_id = s.site_inst_id                   "+
					"              AND sas.val_attr_inst_id = ?) 			               "+
					"      AND pa.bandwidth = 'PVC'                                        "+
					"      AND p.status = 'LIVRE'                                          "+
					"      AND p.bandwidth = 'PAR_DE_COBRE'                                "+
					"      AND eu.val_attr_inst_id = ? 				                       "+
					"      AND eu.attr_value = 'METRO ETHERNET'                            "+
					"      AND eg.val_attr_inst_id = ?       					           "+
					"      AND e.status = 'ATIVO'                                          "+
					"      AND e.type = 'MSAN'                                             "+
					"      AND su.attr_value = am.cnl                                      "+
					"      AND su.val_attr_inst_id = ? 			                           "+
					"      AND s.site_hum_id LIKE '%_' || am.at                            "+
					"      AND s.num = 'CENTRO DE FIOS'                                    "+
					"      AND ca.status = 'ATIVO'                                         "+
					"      AND e.equip_inst_id = am.equip_inst_id                          "+
					"      AND ca.card_inst_id = am.card_inst_id                           "+
					"      AND p.port_hum_id BETWEEN am.porta_inicial AND am.porta_final   "+
					"      AND am.armario = ? 			                                   "+
					"      AND am.cnl = ? 		                                           "+
					"      AND am.at = ? 		                                           "+
					"      AND am.status = 'Ativo'                                         "+
					"      AND upper(am.tipo) = 'MSAN'                                     "+
					"      AND cas.card_inst_id = ca.card_inst_id                          "+
					"      AND cas.val_attr_inst_id = ? 		                           "+
					"      AND cas.attr_value = ?	 	                                   "+
					" 	   AND cpm.prefixo_mcdu_terminal IS NULL                           "+
					" 	   AND cpm.status_pots = 'LIVRE'),                                 "+
					" free_circuits_grouped AS                                             "+
					"  (SELECT COUNT(1) AS freePorts, technology                           "+
					"     FROM free_circuits                                               "+
					"    GROUP BY technology)                                              "+
					" select tec.technology, nvl(fcg.freePorts, 0) as freePorts,           "+
					"        (CASE tec.technology                                          "+
					"            WHEN 'ADSL' THEN 0                                        "+
					"            WHEN 'ADSL2+' THEN 0                                      "+
					"            ELSE pvp.velocity                                         "+
					"         END) velocity_down                                           "+
					"   from technologies tec                                              "+
					"   left join free_circuits_grouped fcg                                "+
					"     on tec.technology = fcg.technology, PORT_VELOCITY_PRIORITY pvp,  "+
					"  EQUIPMENT_CATALOG ec, PORT_CATALOG pc, NETWORK_CATALOG nc           "+ 
					"  where 1 = 1                                                         "+
					"    and ec.ID_EQUIPMENT_CATALOG = pvp.ID_EQUIPMENT_CATALOG            "+
					"    AND pc.ID_PORT_CATALOG = pvp.ID_PORT_CATALOG                      "+
					"    AND nc.ID_NETWORK_CATALOG = pvp.ID_NETWORK_CATALOG                "+
					"    AND ec.EQUIPMENT_DESCRIPTION = 'MSAN'                             "+
					"    AND nc.NETWORK_DESCRIPTION = 'METRO ETHERNET'                    " ,resultClass = RetrieveAvailabilityMsanEntity.class,
			hints={
				    @QueryHint(name="eclipselink.query-results-cache", value="false")
				  })})

public class RetrieveAvailabilityMsanEntity extends EntityCommon<Long> implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "freePorts")
	private Integer quantityPort;

	@Id
	@Column(name = "technology")
	private String technology;
	
	@Column(name="velocity_down")
	private Integer Speed;
	
	@Transient
	private String typeEquipment;
	
	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Integer getSpeed() {
		return Speed;
	}

	public void setSpeed(Integer speed) {
		Speed = speed;
	}

	@Transient
	private ResultTo result = new ResultTo();
	
	public ResultTo getResult() {
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	public String getTypeEquipment() {
		return typeEquipment;
	}

	public void setTypeEquipment(String typeEquipment) {
		this.typeEquipment = typeEquipment;
	}

	public Integer getQuantityPort() {
		return quantityPort;
	}

	public void setQuantityPort(Integer quantityPort) {
		this.quantityPort = quantityPort;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}
}
