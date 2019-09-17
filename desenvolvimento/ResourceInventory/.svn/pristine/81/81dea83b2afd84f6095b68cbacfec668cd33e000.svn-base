package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;

@Entity
@Table
@NamedNativeQueries({
	@NamedNativeQuery(name=RetrievePathEntity.QUERY_EQUIP_TYPE,query=
			"SELECT ei.type											 "
			+ " FROM circ_path_inst cpi,                             "
			+ " circ_path_element cpe,                               "
			+ " circ_path_attr_settings cpas,                        "
			+ " val_attr_name van,                                   "
			+ " epa p,                                               "
			+ " card_inst ci,                                        "
			+ " equip_inst ei                                        "
			+ " WHERE cpi.circ_path_inst_id = cpe.circ_path_inst_id  "
			+ " AND cpi.circ_path_inst_id = cpas.circ_path_inst_id   "
			+ " AND cpas.val_attr_inst_id = van.val_attr_inst_id     "
			+ " AND cpe.port_inst_id = p.port_inst_id                "
			+ " AND p.card_inst_id = ci.card_inst_id                 "
			+ " AND ci.equip_inst_id = ei.equip_inst_id              "			
    		+ " AND ei.type NOT IN (SELECT ret.equip_type  			 "          	   
    		+ " FROM retrieve_equipment_type ret  					 "                      
    		+ " WHERE ret.equip_group = 'EQUIPAMENTO TERMINADOR')    "    			
			+ " AND cpi.type = 'PATH_SPEEDY'                         "
			+ " AND cpi.status = 'ATIVO'                             "
			+ " AND van.group_name = 'LINE'                          "
			+ " AND van.attr_name = 'NUMERO_TERMINAL'                "
			+ " AND cpas.attr_value = ?            					 "),
	@NamedNativeQuery(name = RetrievePathEntity.QUERY_RESOURCE_PATHS, 
	query = "SELECT  cpi.circ_path_inst_id"
			+ ", cpi.status                                                        "
			+ ", cpi.bandwidth                                                     "
			+ ", cpi.type                                                          "
			+ ", cpi.topology                                                      "
			+ ", (SELECT p.port_inst_id  										   "
			+ "      FROM circ_path_element cpe,                                   "
			+ "                  epa p,                                            "
			+ "                  card_inst ci,                                     "
			+ "                  equip_inst ei                                     "
			+ "       WHERE cpi.circ_path_inst_id = cpe.circ_path_inst_id          "
			+ "           AND cpe.port_inst_id = p.port_inst_id                    "
			+ "           AND p.card_inst_id = ci.card_inst_id                     "
			+ "          AND ci.equip_inst_id = ei.equip_inst_id                   "			
			+ "          AND   ei.type  NOT IN (SELECT ret.equip_type          	   "
			+ "                FROM retrieve_equipment_type ret                    "
			+ "                WHERE ret.equip_group = 'EQUIPAMENTO TERMINADOR')   "  			
			+ "          ) id_port_access                						   "
			+ "        FROM                                                        "
			+ "            circ_path_inst cpi,                                     "
			+ "            circ_path_attr_settings cpas                            "
			+ "        WHERE                                                       "
			+ "                cpi.circ_path_inst_id = cpas.circ_path_inst_id      "
			+ "            AND                                                     "
			+ "                cpas.val_attr_inst_id = (                           "
			+ "                    SELECT                                          "
			+ "                        van.val_attr_inst_id                        "
			+ "                    FROM                                            "
			+ "                        val_attr_name van                           "
			+ "                    WHERE                                           "
			+ "                            van.attr_name = 'NUMERO_TERMINAL'       "
			+ "                        AND                                         "
			+ "                            van.group_name = 'LINE' )               "
			+ "                    AND cpas.attr_value = ?                         "
			+ "            AND                                                     "
			+ "                EXISTS (                                            "
			+ "                    SELECT                                          "
			+ "                        1                                           "
			+ "                    FROM                                            "
			+ "                        circ_path_element cpe                       "
			+ "                    WHERE                                           "
			+ "                        cpe.circ_path_inst_id = cpi.circ_path_inst_id)", 
			resultClass = RetrievePathEntity.class,
	hints = { @QueryHint(name = "eclipselink.query-results-cache", value = "false") 
	}),
	@NamedNativeQuery(name = RetrievePathEntity.QUERY_RESOURCE_PATHS_GPON, 
	query = "SELECT "
			+ "  cpi.circ_path_inst_id,"
			+ "  cpi.status status,"
			+ "  servico_amo.status servico_amo_status" 
			+ " FROM "
			+ "  circ_path_inst cpi, " 
			+ "  circ_path_attr_settings cpa, "
			+ "  val_attr_name van,"
			+ "  (SELECT "
			+ "    ri.status,"
			+ "    ras.attr_value"
			+ "  FROM "
			+ "    resource_inst ri,"
			+ "    resource_attr_settings ras,"
			+ "    val_attr_name van"
			+ "  WHERE ri.resource_inst_id = ras.resource_inst_id"
			+ "        and van.val_attr_inst_id = ras.val_attr_inst_id"
			+ "        and van.group_name = 'SERVICO_AMO_LINE'"
			+ "        and van.attr_name = 'NUMERO_TERMINAL') servico_amo"
			+ "  WHERE cpi.circ_path_inst_id = cpa.circ_path_inst_id"
			+ "      AND cpi.type = 'PATH_TRANSPORTE_FTTX'"
			+ "      AND van.val_attr_inst_id = cpa.val_attr_inst_id"
			+ "      AND van.attr_name = 'NUMERO_TERMINAL'"
			+ "      AND van.group_name = 'LINE'"
			+ "      AND servico_amo.attr_value (+) = cpa.attr_value"
			+ "      AND cpa.attr_value = ?", 
				resultClass = RetrievePathEntity.class, hints = {
						@QueryHint(name = "eclipselink.query-results-cache", value = "false") }) })

public class RetrievePathEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String QUERY_RESOURCE_PATHS = "QueryResourcePaths";
	public static final String QUERY_EQUIP_TYPE = "QueryEquipType";
	public static final String QUERY_RESOURCE_PATHS_GPON = "QueryResourcePathsGpon";

	@Id
	@Column(name = "circ_path_inst_id")
	private Long circPathInstId;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusPathType status;

	@Column(name = "servico_amo_status")
	@Enumerated(EnumType.STRING)
	private StatusPathType resourceStatus;

	@Column
	private String bandwidth;

	@Column
	private String type;
	
	@Column
	private String topology;

	@Transient
	private String terminal;

	@Column(name = "id_port_access")
	private String port;

	@Transient
	private Operation operation;

	public Long getCircPathInstId() {
		return circPathInstId;
	}

	public void setCircPathInstId(Long circPathInstId) {
		this.circPathInstId = circPathInstId;
	}

	public StatusPathType getStatus() {
		return status;
	}

	public void setStatus(StatusPathType status) {
		this.status = status;
	}

	public StatusPathType getResourceStatus() {
		return resourceStatus;
	}
	
	public void setResourceStatus(StatusPathType resourceStatus) {
		this.resourceStatus = resourceStatus;
	}

	public String getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTopology() {
		return topology;
	}

	public void setTopology(String topology) {
		this.topology = topology;
	}

	public String getTerminal() {
		return terminal;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "RetrievePathEntity [circPathInstId=" + circPathInstId + ", status=" + (status != null ? status.getValue() : null) + "]";
	}

	public boolean isOfferEdition() {
		return Operation.OFFER_EDITION.equals(this.operation);
	}

	public boolean isChangePort() {
		return Operation.CHANGE_OFFER.equals(this.operation);
	}

	public boolean isSaleOffer() {
		return Operation.SALE_OFFER.equals(this.operation);
	}
}
