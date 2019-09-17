package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="QueryMaxSpeedResourceCurrent", 
			query=" SELECT pvp.velocity AS max_speed " +
  "FROM circ_path_inst cpi, " +
       "circ_path_element cpe, " +
       "epa, card_inst ci, equip_inst ei, " +
       "circ_path_attr_settings cpa, val_attr_name van, " +
       "port_velocity_priority pvp, equipment_catalog ec, " +
       "network_catalog nc, port_catalog pc " +
 "WHERE cpi.circ_path_inst_id = cpe.circ_path_inst_id " +
   "AND cpe.port_inst_id = epa.port_inst_id " +
   "AND epa.card_inst_id = ci.card_inst_id " +
   "AND ci.equip_inst_id = ei.equip_inst_id " +   
    "AND ei.type NOT IN (SELECT ret.equip_type  " +         	   
	     "FROM retrieve_equipment_type ret  " +                     
	     "WHERE ret.equip_group = 'EQUIPAMENTO TERMINADOR')  " +   
   "AND cpi.circ_path_inst_id = cpa.circ_path_inst_id " +
   "AND cpa.val_attr_inst_id = van.val_attr_inst_id " +
   "AND cpi.type = 'PATH_SPEEDY' " +
   "AND pvp.id_equipment_catalog = ec.id_equipment_catalog " +
   "AND pvp.id_network_catalog = nc.id_network_catalog " +
   "AND pvp.id_port_catalog = pc.id_port_catalog " +
   "AND EXISTS (SELECT pas.attr_value " +
          "FROM port_attr_settings pas, val_attr_name van " +
         "WHERE pas.port_inst_id = epa.port_inst_id " +
           "AND pas.val_attr_inst_id = van.val_attr_inst_id " +
           "AND van.group_name = 'ATIVACAO_UPLOAD_FIS' " +
           "AND van.attr_name = 'TIPO' " +
           "AND pas.attr_value = pc.port_description) " +
   "AND UPPER(ec.equipment_description) = ei.type " +
   "AND van.group_name = 'LINE' AND van.attr_name = 'NUMERO_TERMINAL' " +
   "AND cpa.attr_value = ?")
})
public class RetrieveMaxSpeedResourceEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic
	@Column(name="p_ret_code")
	private Integer code;
	
	@Basic
	@Column(name="p_ret_msg")
	private String description;
	
	@Basic
	@Column(name="p_terminal")
	private String terminal;
	
	@Basic
	@Column(name="p_speed")
	private String speed;
	
	@Basic
	@Column(name="p_unit_speed")
	private String unitSpeed;
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getUnitSpeed() {
		return unitSpeed;
	}

	public void setUnitSpeed(String unitSpeed) {
		this.unitSpeed = unitSpeed;
	}

}
