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

@Table(name="aloc_msandslam")
@Entity
@Cacheable(false)
@NamedNativeQueries({
	@NamedNativeQuery(name="QueryFindByActiveMsanDslam", 
			query= 	" SELECT search_port_all.port_type,       																"+ 
					"       count(1) as free_ports,       																	"+ 
					"       search_port_all.velocity_down																	"+ 
					"  FROM (        																						"+ 
					"        SELECT pas_a.attr_value port_type,                												"+ 
					"                (                 																		"+ 
					"                 SELECT velocity                 														"+ 
					"                   FROM PORT_VELOCITY_PRIORITY pvp,                         							"+ 
					"                        EQUIPMENT_CATALOG et,                         								"+ 
					"                        PORT_CATALOG pt,                         										"+ 
					"                        NETWORK_CATALOG nt                 											"+ 
					"                  WHERE et.ID_EQUIPMENT_CATALOG = pvp.ID_EQUIPMENT_CATALOG                       		"+ 
					"                    AND pt.ID_PORT_CATALOG = pvp.ID_PORT_CATALOG                       				"+ 
					"                    AND nt.ID_NETWORK_CATALOG = pvp.ID_NETWORK_CATALOG                       			"+ 
					"                    AND et.EQUIPMENT_DESCRIPTION = ei_a.Type                       					"+ 
					"                    AND pt.Port_Description = pas_a.attr_value) velocity_down        					"+ 
					"          FROM (                 																		"+ 
					"                 SELECT ei.site_inst_id                 												"+ 
					"                   FROM circ_path_inst cpi,                         									"+ 
					"                         circ_path_attr_settings cpas,                         						"+ 
					"                         val_attr_name van,                         									"+ 
					"                         circ_path_element cpe,                         								"+ 
					"                         epa ep,                         												"+ 
					"                         equip_inst ei                 												"+ 
					"                  WHERE cpi.circ_path_inst_id = cpas.circ_path_inst_id                       			"+ 
					"                    AND cpas.val_attr_inst_id = van.val_attr_inst_id                       			"+ 
					"                    AND van.group_name = 'LINE'                       									"+ 
					"                    AND van.attr_name = 'NUMERO_TERMINAL'                       						"+ 
					"                    AND cpas.attr_value = ?                       						"+ 
					"                    AND cpi.type = 'PATH_SPEEDY'                       								"+ 
					"                    AND cpi.circ_path_inst_id = cpe.circ_path_inst_id                       			"+ 
					"                    AND cpe.port_inst_id = ep.port_inst_id                       						"+ 
					"                    AND ep.bandwidth = 'PAR_DE_COBRE'                       							"+ 
					"                    AND ep.equip_inst_id = ei.equip_inst_id                       						"+ 
					"                    AND ei.Type = 'DSLAM'                       										"+ 
					"                    AND ROWNUM < 2) search_teminal,                									"+ 
					"                equip_inst ei_a,                														"+ 
					"                equip_attr_settings eas_rede_type,                										"+ 
					"                card_inst ci_a,                														"+ 
					"                epa ep_a,                																"+ 
					"                port_attr_settings pas_a,                												"+ 
					"                circ_path_element cpe,                													"+ 
					"                circ_path_inst cpi2,                													"+ 
					"                card_attr_settings cas_sip        														"+ 
					"         WHERE ei_a.site_inst_id = search_teminal.site_inst_id              							"+ 
					"           AND ei_a.status = 'ATIVO'              														"+ 
					"           AND ei_a.equip_inst_id = ep_a.Equip_Inst_Id              									"+ 
					"           AND ei_a.equip_inst_id = ci_a.Equip_Inst_Id              									"+ 
					"           AND ci_a.status = 'ATIVO'              														"+ 
					"           AND ci_a.card_Inst_Id = ep_a.Card_Inst_Id              										"+ 
					"           AND ci_a.equip_inst_id = ep_a.equip_inst_id              									"+ 
					"           AND cas_sip.card_inst_id = ci_a.card_inst_id              									"+ 
					"           AND cas_sip.val_attr_inst_id =              												"+ 
					"               (SELECT van.val_attr_inst_id                											"+ 
					"                  FROM val_attr_name van                												"+ 
					"                 WHERE van.attr_name = 'PROTOCOLO_VOZ'                      							"+ 
					"                   AND van.group_name = 'CARTAO_PROTOCOLOS')              								"+ 
					"           AND cas_sip.attr_value = 'SIP'              												"+ 
					"           AND ep_a.bandwidth = 'PAR_DE_COBRE'              											"+ 
					"           AND ep_a.status = 'LIVRE'              														"+ 
					"           AND ep_a.port_inst_id = pas_a.port_inst_id              									"+ 
					"           AND pas_a.val_attr_inst_id =              													"+ 
					"               (SELECT van.val_attr_inst_id                											"+ 
					"                  FROM val_attr_name van                												"+ 
					"                 WHERE van.group_name = 'ATIVACAO_UPLOAD_FIS'                      					"+ 
					"                   AND van.attr_name = 'TIPO')              											"+ 
					"           AND ep_a.port_inst_id = cpe.port_inst_id              										"+ 
					"           and exists        																			"+ 
					"         (select 1                																		"+ 
					"                  from epa pa                															"+ 
					"                 where pa.port_inst_id =                      											"+ 
					"                       (SELECT MAX(cc.port_inst_id)                        							"+ 
					"                          FROM circ_path_element cc                        							"+ 
					"                         WHERE cc.circ_path_inst_id = cpe.circ_path_inst_id                            "+ 
					"                           AND cc.port_inst_id != cpe.port_inst_id)                      				"+ 
					"                   AND pa.BANDWIDTH = 'PVC'                      										"+ 
					"                   AND NOT EXISTS                														"+ 
					"                 ( /* uda_vpn */                        												"+ 
					"                        SELECT 1                        												"+ 
					"                          FROM equip_attr_settings eas                        							"+ 
					"                         WHERE eas.equip_inst_id = pa.equip_inst_id                              		"+ 
					"                           AND eas.val_attr_inst_id =													"+ 
					"                               (SELECT van.val_attr_inst_id                               				"+ 
					"                                  FROM val_attr_name van                               				"+ 
					"                                 WHERE UPPER(van.group_name) =                               			"+ 
					"                                       'EQUIPAMENTO_GERAL'                               				"+ 
					"                                   AND UPPER(van.attr_name) = 'SERVICO_VPN')                           "+ 
					"                           AND eas.attr_value = 'SIM')                      							"+ 
					"                   AND 'DINAMICO' =                      												"+ 
					"                       ( /* uda_ip */                        											"+ 
					"                        SELECT attr_value                        										"+ 
					"                          FROM port_attr_settings pu                        							"+ 
					"                         WHERE pu.val_attr_inst_id =                               					"+ 
					"                               (SELECT van.val_attr_inst_id                               				"+ 
					"                                  FROM val_attr_name van                               				"+ 
					"                                 WHERE UPPER(van.group_name) =                               			"+ 
					"                                       'ATIVACAO_UPLOAD_LOG'                               			"+ 
					"                                   AND UPPER(van.attr_name) =                               			"+ 
					"                                       'TIPO_ENDERECAMENTO')                              				"+ 
					"                           and pu.port_inst_id = pa.port_inst_id))              						"+ 
					"           AND cpi2.status = 'CONFIGURADO'              												"+ 
					"           AND cpi2.customer_id IS NULL              													"+ 
					"           AND cpi2.type = 'PATH_SPEEDY'              													"+ 
					"           AND cpi2.circ_path_inst_id = cpe.circ_path_inst_id              							"+ 
					"           AND ei_a.equip_inst_id = eas_rede_type.equip_inst_id              							"+ 
					"           AND eas_rede_type.val_attr_inst_id =              											"+ 
					"               (SELECT van.val_attr_inst_id                											"+ 
					"                  FROM val_attr_name van                												"+ 
					"                 WHERE van.group_name = 'EQUIPAMENTO_GERAL'                      						"+ 
					"                   AND van.attr_name = 'TIPO_REDE')                            						"+ 
					"           AND eas_rede_type.attr_value = 'METRO ETHERNET'												"+ 
					"        UNION ALL        																				"+ 
					"        SELECT pas_a.attr_value port_type,                												"+ 
					"                (SELECT velocity                 														"+ 
					"                   FROM PORT_VELOCITY_PRIORITY pvp,                        							"+ 
					"                        EQUIPMENT_CATALOG et,                        									"+ 
					"                        PORT_CATALOG pt,                        										"+ 
					"                        NETWORK_CATALOG nt                 											"+ 
					"                  WHERE et.ID_EQUIPMENT_CATALOG = pvp.ID_EQUIPMENT_CATALOG                       		"+ 
					"                    AND pt.ID_PORT_CATALOG = pvp.ID_PORT_CATALOG                       				"+ 
					"                    AND nt.ID_NETWORK_CATALOG = pvp.ID_NETWORK_CATALOG                       			"+ 
					"                    AND ET.EQUIPMENT_DESCRIPTION = ei_a.Type                       					"+ 
					"                    AND pt.Port_Description = pas_a.attr_value) velocity_down        					"+ 
					"          FROM (SELECT ei.site_inst_id,                        										"+ 
					"                        (select sas.attr_value                         								"+ 
					"                           FROM site_attr_settings sas, val_attr_name van_site                         "+ 
					"                          WHERE ei.site_inst_id = sas.site_inst_id                               		"+ 
					"                            AND sas.val_attr_inst_id = van_site.val_attr_inst_id                       "+ 
					"                            AND van_site.group_name = 'LOCALIDADE'                               		"+ 
					"                            AND van_site.attr_name = 'CNL') as cnl,                        			"+ 
					"                        (select sas.attr_value                         								"+ 
					"                           FROM site_attr_settings sas, val_attr_name van_site                         "+ 
					"                          WHERE ei.site_inst_id = sas.site_inst_id                               		"+ 
					"                            AND sas.val_attr_inst_id = van_site.val_attr_inst_id                       "+ 
					"                            AND van_site.group_name = 'LOCALIDADE'                               		"+ 
					"                            AND van_site.attr_name = 'SIGLA_AT') as sigla_at,                        	"+ 
					"                        (select pas.attr_value                         								"+
					"                           FROM port_attr_settings pas,												"+ 
					"								 val_attr_name      van_armario                         				"+ 
					"                          WHERE ep.Port_Inst_Id = pas.port_inst_id                               		"+ 
					"                            AND pas.val_attr_inst_id =                               					"+ 
					"                                van_armario.val_attr_inst_id                               			"+ 
					"                            AND van_armario.group_name = 'ATENDIMENTO_CLIENTE'                         "+ 
					"                            AND van_armario.attr_name = 'ARMARIO') as armario                 			"+
					"                   FROM circ_path_inst cpi,                        									"+
					"                        circ_path_attr_settings cpas,                        							"+
					"                        val_attr_name     van,															"+
					"					 			circ_path_element cpe,                        							"+ 
					"                        epa        ep,																	"+
					"                        equip_inst ei                 													"+
					"                  WHERE cpi.circ_path_inst_id = cpas.circ_path_inst_id                       			"+
					"                    AND cpas.val_attr_inst_id = van.val_attr_inst_id                       			"+
					"                    AND van.group_name = 'LINE'                       									"+
					"                    AND van.attr_name = 'NUMERO_TERMINAL'                       						"+
					"                    AND cpas.attr_value = ?                       						"+
					"                    AND cpi.type = 'PATH_SPEEDY'                       								"+
					"                    AND cpi.circ_path_inst_id = cpe.circ_path_inst_id                       			"+
					"                    AND cpe.port_inst_id = ep.port_inst_id                       						"+
					"                    AND ep.bandwidth = 'PAR_DE_COBRE'                       							"+
					"                    AND ep.equip_inst_id = ei.equip_inst_id                       						"+
					"                    AND ei.Type = 'MSAN'                       										"+
					"                    AND ROWNUM < 2) search_teminal,                									"+
					"                equip_inst ei_a,                														"+
					"                equip_attr_settings eas_rede,                											"+
					"                equip_attr_settings eas_neg,                											"+
					"                card_inst ci_a,                														"+
					"                epa ep_a,                																"+
					"                port_attr_settings pas_a,                												"+
					"                circ_path_element cpe,                													"+
					"                circ_path_inst cpi2,                													"+ 
					"                aloc_minidslam am,                														"+
					"                card_attr_settings cas_sip,                											"+
					"                conexoes_pots_msan cpm        															"+
					"         WHERE ei_a.site_inst_id = search_teminal.site_inst_id              							"+
					"           AND ei_a.status = 'ATIVO'              														"+
					"           AND ei_a.equip_inst_id = ep_a.Equip_Inst_Id              									"+
					"           AND ei_a.equip_inst_id = ci_a.Equip_Inst_Id              									"+
					"           AND ci_a.status = 'ATIVO'              														"+
					"           AND ci_a.Card_Inst_Id = ep_a.Card_Inst_Id              										"+
					"           AND ci_a.equip_inst_id = ep_a.equip_inst_id              									"+
					"           AND cas_sip.card_inst_id = ci_a.card_inst_id              									"+
					"           AND cas_sip.val_attr_inst_id =              												"+
					"               (SELECT van.val_attr_inst_id                											"+
					"                  FROM val_attr_name van                												"+
					"                 WHERE van.attr_name = 'PROTOCOLO_VOZ'                      							"+
					"                   AND van.group_name = 'CARTAO_PROTOCOLOS')              								"+
					"           AND cas_sip.attr_value = 'SIP'              												"+
					"           AND ep_a.bandwidth = 'PAR_DE_COBRE'              											"+
					"           AND ep_a.status = 'LIVRE'              														"+
					"           AND ep_a.port_inst_id = pas_a.port_inst_id              									"+
					"           AND pas_a.val_attr_inst_id =              													"+
					"               (select van.val_attr_inst_id                											"+
					"                  FROM val_attr_name van                												"+
					"                 WHERE van.group_name = 'ATIVACAO_UPLOAD_FIS'                      					"+
					"                   AND van.attr_name = 'TIPO')              											"+
					"           AND ep_a.port_inst_id = cpe.port_inst_id              										"+
					"           AND UPPER(cpi2.status) = 'CONFIGURADO'              										"+
					"           AND cpi2.customer_id IS NULL              													"+
					"           AND UPPER(cpi2.type) = 'PATH_SPEEDY'              											"+
					"           AND cpi2.circ_path_inst_id = cpe.circ_path_inst_id              							"+
					"           AND eas_rede.equip_inst_id = ei_a.equip_inst_id              								"+
					"           AND eas_rede.val_attr_inst_id =              												"+
					"               (SELECT van.val_attr_inst_id                											"+
					"                  FROM val_attr_name van                												"+
					"                 WHERE UPPER(van.group_name) = 'EQUIPAMENTO_GERAL'                      				"+
					"                   AND UPPER(van.attr_name) = 'TIPO_REDE')              								"+
					"           AND UPPER(eas_rede.attr_value) = 'METRO ETHERNET'              								"+
					"           AND eas_neg.equip_inst_id = ei_a.equip_inst_id              								"+
					"           AND eas_neg.val_attr_inst_id =              												"+
					"               (SELECT van.val_attr_inst_id                											"+
					"                  FROM val_attr_name van                												"+
					"                 WHERE UPPER(van.group_name) = 'EQUIPAMENTO_ENGENHARIA'                      			"+
					"                   AND UPPER(van.attr_name) = 'NOME_EQUIPAMENTO')              						"+
					"           AND eas_neg.attr_value = cpm.id_msan              											"+
					"           AND ci_a.slot = cpm.slot_vdsl              													"+
					"           AND ep_a.port_hum_id = cpm.porta_vdsl              											"+
					"           AND cpm.prefixo_mcdu_terminal IS NULL              											"+
					"           AND UPPER(cpm.status_pots) = 'LIVRE'              											"+
					"           AND search_teminal.cnl = am.cnl              												"+
					"           AND search_teminal.sigla_at = am.at              											"+
					"           AND search_teminal.armario = am.armario              										"+
					"           AND ei_a.equip_inst_id = am.equip_inst_id              										"+
					"           AND ci_a.card_inst_id = am.card_inst_id              										"+
					"           AND ep_a.port_hum_id BETWEEN am.porta_inicial AND am.porta_final							"+
					"          UNION ALL																					"+
					"               /* PEGA A PORTA CUJO O TERMINAL PERTENCE */        										"+ 
					"        SELECT search_terminal.attr_value port_type,                									"+ 
					"                (                 																		"+
					"                 SELECT velocity                 														"+
					"                   FROM PORT_VELOCITY_PRIORITY pvp,                         							"+
					"                         EQUIPMENT_CATALOG et,                         								"+
					"                         PORT_CATALOG pt,                         										"+
					"                         NETWORK_CATALOG nt                 											"+
					"                  WHERE et.ID_EQUIPMENT_CATALOG = pvp.ID_EQUIPMENT_CATALOG                       		"+
					"                    AND pt.ID_PORT_CATALOG = pvp.ID_PORT_CATALOG                       				"+
					"                    AND nt.ID_NETWORK_CATALOG = pvp.ID_NETWORK_CATALOG                       			"+
					"                    AND ET.EQUIPMENT_DESCRIPTION = search_terminal.Type                       			"+
					"                    AND pt.Port_Description = search_terminal.attr_value) velocity_down        		"+
					"          FROM (SELECT ei.site_inst_id, ep_a.attr_value, ei.type                 						"+
					"                   FROM circ_path_inst cpi,                        									"+
					"                        circ_path_attr_settings cpas,                        							"+
					"                        val_attr_name van,                        										"+
					"                        circ_path_element cpe,                        									"+
					"                        epa ep,                        												"+
					"                        port_attr_settings ep_a,                        								"+
					"                        equip_inst ei                 													"+
					"                  WHERE cpi.circ_path_inst_id = cpas.circ_path_inst_id                       			"+
					"                    AND cpas.val_attr_inst_id = van.val_attr_inst_id                       			"+
					"                    AND van.group_name = 'LINE'                      									"+
					"                    AND van.attr_name = 'NUMERO_TERMINAL'                       						"+ 
					"                    AND cpas.attr_value = ?                       						"+
					"                    AND cpi.type = 'PATH_SPEEDY'                       								"+
					"                    AND cpi.circ_path_inst_id = cpe.circ_path_inst_id                       			"+
					"                    AND cpe.port_inst_id = ep.port_inst_id                       						"+
					"                    AND ep.bandwidth = 'PAR_DE_COBRE'                       							"+
					"                    AND ep.equip_inst_id = ei.equip_inst_id                       						"+
					"                    AND ei.Type IN ('DSLAM','MSAN')                       								"+
					"                    AND ep.port_inst_id = ep_a.port_inst_id                       						"+
					"                    AND ep_a.val_attr_inst_id =                       									"+
					"                        (SELECT van.val_attr_inst_id                         							"+
					"                           FROM val_attr_name van                         								"+
					"                          WHERE van.group_name = 'ATIVACAO_UPLOAD_FIS'                               	"+ 
					"                            AND van.attr_name = 'TIPO')                       							"+
					"                    AND ROWNUM < 2) search_terminal        											"+
					"        ) search_port_all																				"+
					" GROUP BY search_port_all.port_type, search_port_all.velocity_down",
resultClass=AvailabilityRetrieveActiveMsanDslamEntity.class,
hints={
	    @QueryHint(name="eclipselink.query-results-cache", value="false")
	  })})
public class AvailabilityRetrieveActiveMsanDslamEntity extends EntityCommon<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name = "free_ports")
	private Integer quantityPort;

	@Column(name = "velocity_down")
	private Integer Speed;
	
	@Column(name = "port_type")
	private String typeEquipment;

	@Transient
	private ResultTo result;

	public Integer getQuantityPort() {
		return quantityPort;
	}

	public void setQuantityPort(Integer quantityPort) {
		this.quantityPort = quantityPort;
	}

	public Integer getSpeed() {
		return Speed;
	}

	public void setSpeed(Integer speed) {
		Speed = speed;
	}

	public String getTypeEquipment() {
		return typeEquipment;
	}

	public void setTypeEquipment(String typeEquipment) {
		this.typeEquipment = typeEquipment;
	}

	public ResultTo getResult() {
		if(null==result){
			result= new ResultTo();
		}
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
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
