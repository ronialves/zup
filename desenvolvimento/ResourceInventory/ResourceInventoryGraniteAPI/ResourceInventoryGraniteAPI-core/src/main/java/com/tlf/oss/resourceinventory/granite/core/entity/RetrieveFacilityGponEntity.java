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

@Table(name="equip_attr_settings")
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="QueryGponFacility", query="SELECT tecnology,"
			+ "       Access_side_a.terminal_number,"
			+ "       Access_side_z.aggreg_name,"
			+ "       cable,"
			+ "       fiber,"
			+ "       access_equipment_name,"
			+ "       access_equipment_port,"
			+ "       access_equipment_slot,"
			+ "       logical_port,"
			+ "       access_equipment_vendor,"
			+ "       access_equipment_model,"
			+ "       nasport,"
			+ "       nasip,"
			+ "       network_vlan,"
			+ "       user_vlan,"
			+ "       vlan_voip,"
			+ "       (SELECT rase.attr_value"
			+ "          FROM Resource_Attr_Settings rase, val_attr_name vana"
			+ "         WHERE rase.resource_inst_id = Access_side_a.servce_amo_id"
			+ "           AND vana.group_name = 'SERVICO_AMO_LINE'"
			+ "           AND vana.attr_name = 'ID_ONT'"
			+ "           AND rase.val_attr_inst_id = vana.val_attr_inst_id"
			+ "           AND ROWNUM = 1) ont_id,"
			+ "       (SELECT DECODE(UPPER(cpa.vl_conteudo), 'BUSINESS', 'S', 'N')"
			+ "          FROM sigres_inventory.conteudo_parametro           cpa,"
			+ "               sigres_inventory.parametro                    pa,"
			+ "               sigres_inventory.associacao_servico_parametro aspar,"
			+ "               sigres_inventory.service_code                 scd"
			+ "         WHERE aspar.id_servico = scd.id_servico"
			+ "           AND pa.ds_parametro = 'TIPO_CLASSE'"
			+ "           AND pa.id_parametro = aspar.id_parametro"
			+ "           AND cpa.id_parametro = pa.id_parametro"
			+ "           AND aspar.id_conteudo = cpa.id_conteudo"
			+ "           AND aspar.id_parametro = cpa.id_parametro"
			+ "           AND scd.codigo_servico ="
			+ "               NVL(Access_side_a.pt_service_code,"
			+ "                   (SELECT rase.attr_value"
			+ "                      FROM Resource_Attr_Settings rase, val_attr_name vana"
			+ "                     WHERE rase.resource_inst_id = Access_side_a.servce_amo_id"
			+ "                       AND vana.group_name = 'SERVICO_AMO_LINE'"
			+ "                       AND vana.attr_name = 'CODIGO_SERVICO'"
			+ "                       AND rase.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                       AND ROWNUM = 1))"
			+ "           AND ROWNUM = 1) fixed_ip_flag,"
			+ "       Access_side_z.fixed_ip_address_v4,"
			+ "       Access_side_z.fixed_ip_address_v6,"
			+ "       (SELECT DECODE(rase.attr_value, 'SIM', 'S', 'N')"
			+ "          FROM Resource_Attr_Settings rase, val_attr_name vana"
			+ "         WHERE rase.resource_inst_id = Access_side_a.servce_amo_id"
			+ "           AND vana.group_name = 'SERVICO_AMO_LINE'"
			+ "           AND vana.attr_name = 'BHS'"
			+ "           AND rase.val_attr_inst_id = vana.val_attr_inst_id"
			+ "           AND ROWNUM = 1) bhs_hgu_configuration,"
			+ "       Access_side_z.path_speedy_status,"
			+ "       Access_side_a.path_transporte_status,"
			+ "       access_side_a.ont_model,"
			+ "       access_side_a.ont_version,"
			+ "       'Term_' || substr(access_side_z.terminal_number, 5) || '_VlanUsu_' ||"
			+ "       Access_side_z.user_vlan service_description,"
			+ "       (SELECT ras.attr_value"
			+ "          FROM resource_attr_settings ras, val_attr_name van"
			+ "         WHERE ras.resource_inst_id = access_side_a.servce_amo_id"
			+ "           AND van.val_attr_inst_id = ras.val_attr_inst_id"
			+ "           AND van.group_name = 'SERVICO_AMO_LINE'"
			+ "           AND van.attr_name = 'ID_ONT') GPON_PASSWORD,"
			+ "       equipament_rack,"
			+ "       equipament_subrack,"
			+ "       equipament_ipaddress,"
			+ "       access_side_z.model,"
			+ "       access_side_z.vendor,"
			+ "		  equipament_shelf"
			+ "  FROM (SELECT 'GPON' tecnology,"
			+ "               cpas.attr_value terminal_number,"
			+ "               (SELECT pase.attr_value"
			+ "                  FROM val_attr_name vana, port_attr_settings pase"
			+ "                 WHERE vana.group_name = 'ATENDIMENTO_CLIENTE'"
			+ "                   AND vana.attr_name = 'CABO'"
			+ "                   AND pase.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND pase.port_inst_id = epa.port_inst_id) cable,"
			+ "               (SELECT pase.attr_value"
			+ "                  FROM val_attr_name vana, port_attr_settings pase"
			+ "                 WHERE vana.group_name = 'ATENDIMENTO_CLIENTE'"
			+ "                   AND vana.attr_name = 'FIBRA'"
			+ "                   AND pase.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND pase.port_inst_id = epa.port_inst_id) fiber,"
			+ "               (SELECT ease.attr_value"
			+ "                  FROM val_attr_name vana, equip_attr_settings ease"
			+ "                 WHERE vana.group_name = 'EQUIPAMENTO_ENGENHARIA'"
			+ "                   AND vana.attr_name = 'NOME_EQUIPAMENTO'"
			+ "                   AND ease.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND ease.equip_inst_id = ei_olt.equip_inst_id) access_equipment_name,"
			+ "               (SELECT ease.attr_value"
			+ "                  FROM val_attr_name vana, equip_attr_settings ease"
			+ "                 WHERE vana.group_name = 'EQUIPAMENTO_VOIP'"
			+ "                   AND vana.attr_name = 'VLAN_VOIP'"
			+ "                   AND ease.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND ease.equip_inst_id = ei_olt.equip_inst_id) vlan_voip,"
			+ "               epa.port_hum_id access_equipment_port,"
			+ "               ci_olt.slot access_equipment_slot,"
			+ "               (SELECT rase.attr_value"
			+ "                  FROM val_attr_name vana, Resource_Attr_Settings rase"
			+ "                 WHERE vana.group_name = 'PORTA_LOGICA'"
			+ "                   AND vana.attr_name = 'GPON_ID'"
			+ "                   AND rase.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND rase.resource_inst_id = ri_olt.resource_inst_id) logical_port,"
			+ "               (SELECT serv.attr_value"
			+ "                  FROM circ_path_attr_settings serv, val_attr_name vana"
			+ "                 WHERE serv.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND vana.group_name = 'LINE'"
			+ "                   AND vana.attr_name = 'CODIGO_SERVICO'"
			+ "                   AND serv.circ_path_inst_id = cpin.circ_path_inst_id) pt_service_code,"
			+ "               ei_olt.vendor access_equipment_vendor,"
			+ "               ei_olt.model access_equipment_model,"
			+ "               (SELECT ri_servs.resource_inst_id"
			+ "                  FROM resource_definition_inst rdin,"
			+ "                       resource_inst            ri_servs,"
			+ "                       resource_associations    ra_servs,"
			+ "                       circ_path_element        e_servs"
			+ "                 WHERE e_servs.path_inst_id = cpin.circ_path_inst_id"
			+ "                   AND ra_servs.target_inst_id = e_servs.circ_path_inst_id"
			+ "                   AND ra_servs.target_type_id = 10"
			+ "                   AND ri_servs.resource_inst_id = ra_servs.resource_inst_id"
			+ "                   AND ri_servs.definition_inst_id = rdin.definition_inst_id"
			+ "                   AND rdin.name = 'SERVICO_AMO'"
			+ "                   AND ROWNUM = 1) servce_amo_id,"
			+ "               cpin.status path_transporte_status,"
			+ "               (SELECT ras.attr_value"
			+ "                  FROM resource_attr_settings ras, val_attr_name van"
			+ "                 WHERE ras.resource_inst_id = ri_olt.resource_inst_id"
			+ "                   AND van.val_attr_inst_id = ras.val_attr_inst_id"
			+ "                   AND van.group_name = 'PORTA_LOGICA'"
			+ "                   AND van.attr_name = 'MODELO_ONT') ONT_MODEL,"
			+ "               (SELECT ras.attr_value"
			+ "                  FROM resource_attr_settings ras, val_attr_name van"
			+ "                 WHERE ras.resource_inst_id = ri_olt.resource_inst_id"
			+ "                   AND van.val_attr_inst_id = ras.val_attr_inst_id"
			+ "                   AND van.group_name = 'PORTA_LOGICA'"
			+ "                   AND van.attr_name = 'VERSAO_ONT') ONT_VERSION,"
			+ "               ei_olt.frame AS equipament_rack,"
			+ "               DECODE(ei_olt.vendor,"
			+ "                      'ERICSSON',"
			+ "                      ei_olt.shelf,"
			+ "                      'HUAWEI TECHNOLOGIES',"
			+ "                      ei_olt.shelf,"
			+ "                      NULL) AS equipament_subrack,"
			+ "		          DECODE(ei_olt.vendor,'ALCATEL',ei_olt.shelf,'LUCENT TECHNOLOGIES',NULL) AS equipament_shelf,"
			+ "               (SELECT ease.attr_value"
			+ "                  FROM val_attr_name vana, equip_attr_settings ease"
			+ "                 WHERE vana.group_name = 'EQUIPAMENTO_ENGENHARIA'"
			+ "                   AND vana.attr_name = 'ENDERECO_IP'"
			+ "                   AND ease.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND ease.equip_inst_id = ei_olt.equip_inst_id"
			+ "                   AND ROWNUM < 2) AS equipament_ipaddress"
			+ "          FROM circ_path_inst cpin,"
			+ "               circ_path_attr_settings cpas,"
			+ "               val_attr_name vana,"
			+ "               circ_path_element e_olt,"
			+ "               resource_definition_inst p_log,"
			+ "               Resource_Inst ri_olt,"
			+ "               Resource_Associations ra_olt,"
			+ "               epa,"
			+ "               card_inst ci_olt,"
			+ "               equip_inst ei_olt"
			+ "         WHERE cpin.type = 'PATH_TRANSPORTE_FTTX'"
			+ "           AND cpas.circ_path_inst_id = cpin.circ_path_inst_id"
			+ "           AND cpas.attr_value IS NOT NULL"
			+ "           AND vana.val_attr_inst_id = cpas.val_attr_inst_id"
			+ "           AND vana.group_name = 'LINE'"
			+ "           AND vana.attr_name = 'NUMERO_TERMINAL'"
			+ "           AND e_olt.circ_path_inst_id = cpin.circ_path_inst_id"
			+ "           AND ri_olt.resource_inst_id = e_olt.resource_inst_id"
			+ "           AND ri_olt.definition_inst_id = e_olt.definition_id"
			+ "           AND p_log.definition_inst_id = ri_olt.definition_inst_id"
			+ "           AND p_log.name = 'PORTA_LOGICA_AMO'"
			+ "           AND ra_olt.resource_inst_id = ri_olt.resource_inst_id"
			+ "           AND epa.port_inst_id = ra_olt.target_inst_id"
			+ "           AND ci_olt.card_inst_id = epa.card_inst_id"
			+ "           AND ci_olt.equip_inst_id = epa.equip_inst_id"
			+ "           AND ei_olt.equip_inst_id = ci_olt.equip_inst_id) Access_side_a,"
			+ "       (SELECT cpas.Attr_Value terminal_number,"
			+ "               e_name.attr_value as aggreg_name,"
			+ "               eins.vendor,"
			+ "               eins.model,"
			+ "               (SELECT cpas.attr_value"
			+ "                  FROM val_attr_name vana, circ_path_attr_settings cpas"
			+ "                 WHERE vana.group_name = 'PATH_PROCESSO'"
			+ "                   AND vana.attr_name = 'NASPORT_CALCULADO'"
			+ "                   AND cpas.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND cpas.circ_path_inst_id = cpin.circ_path_inst_id) nasport,"
			+ "               (SELECT cpas.attr_value"
			+ "                  FROM val_attr_name vana, circ_path_attr_settings cpas"
			+ "                 WHERE vana.group_name = 'PATH_PROCESSO'"
			+ "                   AND vana.attr_name = 'NASIP'"
			+ "                   AND cpas.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND cpas.circ_path_inst_id = cpin.circ_path_inst_id) nasip,"
			+ "               (SELECT pase.attr_value"
			+ "                  FROM val_attr_name vana, port_attr_settings pase"
			+ "                 WHERE vana.group_name = 'PORTA'"
			+ "                   AND vana.attr_name = 'VLAN_REDE'"
			+ "                   AND pase.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND pase.port_inst_id = epa.port_inst_id) network_vlan,"
			+ "               (SELECT pase.attr_value"
			+ "                  FROM val_attr_name vana, port_attr_settings pase"
			+ "                 WHERE vana.group_name = 'PORTA'"
			+ "                   AND vana.attr_name = 'VLAN_USUARIO'"
			+ "                   AND pase.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND pase.port_inst_id = epa.port_inst_id) user_vlan,"
			+ "               (SELECT pase.attr_value"
			+ "                  FROM val_attr_name vana, port_attr_settings pase"
			+ "                 WHERE vana.group_name = 'PORTA_ENDIP'"
			+ "                   AND vana.attr_name = 'END_IP_PC'"
			+ "                   AND pase.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND pase.port_inst_id = epa.port_inst_id) fixed_ip_address_v4,"
			+ "               (SELECT pase.attr_value"
			+ "                  FROM val_attr_name vana, port_attr_settings pase"
			+ "                 WHERE vana.group_name = 'PORTA_ENDIP'"
			+ "                   AND vana.attr_name = 'END_IP_PC_6'"
			+ "                   AND pase.val_attr_inst_id = vana.val_attr_inst_id"
			+ "                   AND pase.port_inst_id = epa.port_inst_id) fixed_ip_address_v6,"
			+ "               cpin.status path_speedy_status"
			+ "          FROM circ_path_inst cpin,"
			+ "               circ_path_attr_settings cpas,"
			+ "               val_attr_name vana,"
			+ "               circ_path_element e_agr,"
			+ "               epa,"
			+ "               equip_inst eins,"
			+ "               equip_attr_settings e_name,"
			+ "               val_attr_name va_name"
			+ "         WHERE cpin.type = 'PATH_SPEEDY_FTTX'"
			+ "           AND cpas.circ_path_inst_id = cpin.circ_path_inst_id"
			+ "           AND cpas.attr_value IS NOT NULL"
			+ "           AND vana.val_attr_inst_id = cpas.val_attr_inst_id"
			+ "           AND vana.group_name = 'LINE'"
			+ "           AND vana.attr_name = 'NUMERO_TERMINAL'"
			+ "           AND e_agr.circ_path_inst_id = cpin.circ_path_inst_id"
			+ "           AND epa.port_inst_id = e_agr.Port_Inst_Id"
			+ "           AND eins.equip_inst_id = epa.equip_inst_id"
			+ "			  AND eins.type IN (SELECT ret.equip_type"          	   
			+ "               FROM retrieve_equipment_type ret"                    
			+ "               WHERE ret.equip_group = 'EQUIPAMENTO TERMINADOR')"
			+ "           AND e_name.equip_inst_id = eins.equip_inst_id"
			+ "           AND e_name.val_attr_inst_id = va_name.val_attr_inst_id"
			+ "           AND va_name.group_name = 'EQUIPAMENTO_ENGENHARIA'"
			+ "           AND va_name.attr_name = 'NOME_EQUIPAMENTO') Access_side_z"
			+ " WHERE Access_side_z.terminal_number = Access_side_a.terminal_number"
			+ "   AND Access_side_z.terminal_number = ?"
, resultClass = RetrieveFacilityGponEntity.class)
})
public class RetrieveFacilityGponEntity extends EntityCommon<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic
	@Column(name="tecnology")
	private String tecnology;

	@Basic
	@Column(name="terminal_number")
	private String terminalNumber;
	
	@Id
	@Basic
	@Column(name="aggreg_name")
	private String aggregatorEquipmentName;

	@Basic
	@Column(name="model")
	private String aggregatorEquipmentModel;
	
	@Basic
	@Column(name="vendor")
	private String aggregatorEquipmentVendor;

	@Basic
	@Column(name="cable")
	private String primaryCable;

	@Basic
	@Column(name="fiber")
	private String primaryFiber;

	@Basic
	@Column(name="access_equipment_name")
	private String accessEquipmentName;

	@Basic
	@Column(name="access_equipment_port")
	private String accessEquipmentPort;

	@Basic
	@Column(name="access_equipment_slot")
	private String accessEquipmentSlot;

	@Basic
	@Column(name="logical_port")
	private String logical_port;

	@Basic
	@Column(name="access_equipment_vendor")
	private String access_equipment_vendor;
	
	@Basic
	@Column(name="access_equipment_model")
	private String access_equipment_model;

	@Basic
	@Column(name="nasip")
	private String nasip;

	@Basic
	@Column(name="nasport")
	private String nasport;

	@Basic
	@Column(name="network_vlan")
	private String  network_vlan;

	@Basic
	@Column(name="user_vlan")
	private String  user_vlan;

	@Basic
	@Column(name="vlan_voip")
	private String vlan_voip;
	
	@Basic
	@Column(name="ont_id")
	private String ont_id;

	@Basic
	@Column(name="fixed_ip_flag")
	private String fixed_ip_flag;

	@Basic
	@Column(name="fixed_ip_address_v4")
	private String fixed_ip_address_v4;

	@Basic
	@Column(name="fixed_ip_address_v6")
	private String fixed_ip_address_v6;

	@Basic
	@Column(name="bhs_hgu_configuration")
	private String bhsHguConfiguration;

	@Basic
	@Column(name="path_speedy_status")
	private String pathSpeedyStatus;

	@Basic
	@Column(name="path_transporte_status")
	private String pathTransporteStatus;
	
	@Basic
	@Column(name="gpon_password")
	private String gpon_password;

	@Basic
	@Column(name="service_description")
	private String service_description;

	@Basic
	@Column(name="ont_model")
	private String ont_model;

	@Basic
	@Column(name="ont_version")
	private String ont_version;

	@Basic
	@Column(name="equipament_ipaddress")
	private String equipament_ipaddress;

	@Basic
	@Column(name="equipament_rack")
	private String equipament_rack;

	@Basic
	@Column(name="equipament_subrack")
	private String equipament_subrack;
	
	@Basic
	@Column(name="equipament_shelf")
	private String equipamentShelf;
	
	@Transient
	private ResultTo result ;

	public String getTecnology() {
		return tecnology;
	}

	public void setTecnology(String tecnology) {
		this.tecnology = tecnology;
	}

	public String getTerminalNumber() {
		return terminalNumber;
	}

	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

	public String getAggregatorEquipmentName() {
		return aggregatorEquipmentName;
	}

	public void setAggregatorEquipmentName(String aggregatorEquipmentName) {
		this.aggregatorEquipmentName = aggregatorEquipmentName;
	}

	public String getAggregatorEquipmentModel() {
		return aggregatorEquipmentModel;
	}

	public void setAggregatorEquipmentModel(String aggregatorEquipmentModel) {
		this.aggregatorEquipmentModel = aggregatorEquipmentModel;
	}

	public String getPrimaryCable() {
		return primaryCable;
	}

	public void setPrimaryCable(String primaryCable) {
		this.primaryCable = primaryCable;
	}

	public String getPrimaryFiber() {
		return primaryFiber;
	}

	public void setPrimaryFiber(String primaryFiber) {
		this.primaryFiber = primaryFiber;
	}

	public String getAccessEquipmentName() {
		return accessEquipmentName;
	}

	public void setAccessEquipmentName(String accessEquipmentName) {
		this.accessEquipmentName = accessEquipmentName;
	}

	public String getAccessEquipmentPort() {
		return accessEquipmentPort;
	}

	public void setAccessEquipmentPort(String accessEquipmentPort) {
		this.accessEquipmentPort = accessEquipmentPort;
	}

	public String getAccessEquipmentSlot() {
		return accessEquipmentSlot;
	}

	public void setAccessEquipmentSlot(String accessEquipmentSlot) {
		this.accessEquipmentSlot = accessEquipmentSlot;
	}

	public String getLogical_port() {
		return logical_port;
	}

	public void setLogical_port(String logical_port) {
		this.logical_port = logical_port;
	}

	public String getAccess_equipment_vendor() {
		return access_equipment_vendor;
	}

	public void setAccess_equipment_vendor(String access_equipment_vendor) {
		this.access_equipment_vendor = access_equipment_vendor;
	}

	public String getAccess_equipment_model() {
		return access_equipment_model;
	}

	public void setAccess_equipment_model(String access_equipment_model) {
		this.access_equipment_model = access_equipment_model;
	}

	public String getNasip() {
		return nasip;
	}

	public void setNasip(String nasip) {
		this.nasip = nasip;
	}

	public String getNasport() {
		return nasport;
	}

	public void setNasport(String nasport) {
		this.nasport = nasport;
	}

	public String getNetwork_vlan() {
		return network_vlan;
	}

	public void setNetwork_vlan(String network_vlan) {
		this.network_vlan = network_vlan;
	}

	public String getUser_vlan() {
		return user_vlan;
	}

	public void setUser_vlan(String user_vlan) {
		this.user_vlan = user_vlan;
	}

	public String getVlan_voip() {
		return vlan_voip;
	}

	public void setVlan_voip(String vlan_voip) {
		this.vlan_voip = vlan_voip;
	}

	public String getOnt_id() {
		return ont_id;
	}

	public void setOnt_id(String ont_id) {
		this.ont_id = ont_id;
	}

	public String getFixed_ip_flag() {
		return fixed_ip_flag;
	}

	public void setFixed_ip_flag(String fixed_ip_flag) {
		this.fixed_ip_flag = fixed_ip_flag;
	}

	public String getFixed_ip_address_v4() {
		return fixed_ip_address_v4;
	}

	public void setFixed_ip_address_v4(String fixed_ip_address_v4) {
		this.fixed_ip_address_v4 = fixed_ip_address_v4;
	}

	public String getFixed_ip_address_v6() {
		return fixed_ip_address_v6;
	}

	public void setFixed_ip_address_v6(String fixed_ip_address_v6) {
		this.fixed_ip_address_v6 = fixed_ip_address_v6;
	}

	public String getBhsHguConfiguration() {
		return bhsHguConfiguration;
	}

	public void setBhsHguConfiguration(String bhsHguConfiguration) {
		this.bhsHguConfiguration = bhsHguConfiguration;
	}

	public String getPathSpeedyStatus() {
		return pathSpeedyStatus;
	}

	public void setPathSpeedyStatus(String pathSpeedyStatus) {
		this.pathSpeedyStatus = pathSpeedyStatus;
	}

	public String getPathTransporteStatus() {
		return pathTransporteStatus;
	}

	public void setPathTransporteStatus(String pathTransporteStatus) {
		this.pathTransporteStatus = pathTransporteStatus;
	}

	public String getGpon_password() {
		return gpon_password;
	}

	public void setGpon_password(String gpon_password) {
		this.gpon_password = gpon_password;
	}

	public String getService_description() {
		return service_description;
	}

	public void setService_description(String service_description) {
		this.service_description = service_description;
	}

	public String getOnt_model() {
		return ont_model;
	}

	public void setOnt_model(String ont_model) {
		this.ont_model = ont_model;
	}

	public String getOnt_version() {
		return ont_version;
	}

	public void setOnt_version(String ont_version) {
		this.ont_version = ont_version;
	}

	public String getEquipament_ipaddress() {
		return equipament_ipaddress;
	}

	public void setEquipament_ipaddress(String equipament_ipaddress) {
		this.equipament_ipaddress = equipament_ipaddress;
	}

	public String getEquipament_rack() {
		return equipament_rack;
	}

	public void setEquipament_rack(String equipament_rack) {
		this.equipament_rack = equipament_rack;
	}

	public String getEquipament_subrack() {
		return equipament_subrack;
	}

	public void setEquipament_subrack(String equipament_subrack) {
		this.equipament_subrack = equipament_subrack;
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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	public String getAggregatorEquipmentVendor() {
		return aggregatorEquipmentVendor;
	}

	public void setAggregatorEquipmentVendor(String aggregatorEquipmentVendor) {
		this.aggregatorEquipmentVendor = aggregatorEquipmentVendor;
	}
	
	public String getEquipamentShelf() {
		return equipamentShelf;
	}

	public void setEquipamentShelf(String equipamentShelf) {
		this.equipamentShelf = equipamentShelf;
	}
}

