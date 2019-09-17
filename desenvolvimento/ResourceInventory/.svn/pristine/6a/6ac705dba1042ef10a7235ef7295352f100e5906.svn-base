package com.tlf.oss.resourceinventory.tbs.entity.v2_0;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.tbs.to.ResultTo;

/**
 * BEATRIXTWO-70 | DEMOSS-2285
 *
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201710
 */
@SuppressWarnings("serial")
@Entity
@NamedStoredProcedureQuery(name = "retrieveFacilityResource", resultClasses = RetrieveFacilityEntity.class, procedureName = "ASAP.GVT_SP_GET_INFO_FACILIT_GPON", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DESIGNADOR", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ACTIVITY_IND", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "CUR1", type = void.class) })
public class RetrieveFacilityEntity implements Serializable {

	@Basic
	@Column(name = "P_DESIGNADOR")
	private String designator;

	@Basic
	@Column(name = "CIRCUIT_ACTIVITY_IND")
	private String activity;

	@Basic
	@Column(name = "IP_ADDRESS")
	private String ipAddress;

	@Basic
	@Column(name = "DESIGNADOR_ACESSO")
	private String designadorAcesso;

	@Basic
	@Column(name = "SLOT")
	private String slot;

	@Basic
	@Column(name = "PORTA_FISICA")
	private String port;

	@Basic
	@Column(name = "NAME_DSLAM")
	private String dslamName;

	@Basic
	@Column(name = "VENDOR_NAME")
	private String vendorName;

	@Basic
	@Column(name = "MODELO_PLACA")
	private String boardModel;

	@Basic
	@Column(name = "PORTA_LOGICA")
	private String portLogic;

	@Basic
	@Column(name = "SVLAN")
	private String svlan;

	@Basic
	@Column(name = "CVLAN")
	private String cvlan;

	@Basic
	@Column(name = "DOWNSTREAM")
	private String downstream;

	@Basic
	@Column(name = "UPSTREAM")
	private String upstream;

	@Basic
	@Column(name = "TECNOLOGIA")
	private String accessTechnology;

	@Basic
	@Column(name = "SWITCH_ATENDIMENTO")
	private String switchAtendimento;

	@Basic
	@Column(name = "ARMARIO")
	private String cabinet;
	
	@Basic
	@Column(name = "RIN_VLAN")
	private String rinVlan;
	
	@Basic
	@Column(name = "VLAN_MCAST")
	private Integer vlanMulticast;
	
	@Basic
	@Column(name = "VLAN_VOD")
	private Integer vlanVod;
	
	@Basic
	@Column(name = "VLAN_VOIP")
	private Integer vlanVoip;
	
	@Basic
	@Column(name = "SHASTA")
	private String shasta;
	
	@Basic
	@Column(name = "MODELO_SHELF")
	private String shelfModel;

	@Id
	@Basic
	@Column(name = "COD_RETORNO")
	private Integer resultCode;

	@Column(name = "MSG_RETORNO")
	private String message;
	
	@Column(name = "IP_ADDRESS_C1")
	private String ipAddressc1;
	
	@Column(name = "INSTANCIA_C1")
	private String instanciac1;
	
	@Column(name = "SLOT_C1")
	private String slotc1;
	
	@Column(name = "PORTA_FISICA_C1")
	private String portaFisicac1;
	
	@Column(name = "V5ID_C1")
	private String v5idc1;
	
	@Column(name = "TRIBUTARIO_C1")
	private String tributarioc1;
	
	@Column(name = "VENDOR_NAME_C1")
	private String vendorNamec1;
	
	@Column(name = "PORTA_LOGICA_C1")
	private String portaLogicac1;
    
	@Column(name = "CIRCUIT_ACTIVITY_IND_C1")
	private String circuitActivityIndc1;
    
	@Transient
	private ResultTo result;

	public RetrieveFacilityEntity() {
		super();
	}

	public RetrieveFacilityEntity(String designator, String activity){
		super();
		this.designator = designator;
		this.activity = activity;
	}

	public String getDesignator() {
		return designator;
	}

	public void setDesignator(String designator) {
		this.designator = designator;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDesignadorAcesso() {
		return designadorAcesso;
	}

	public void setDesignadorAcesso(String designadorAcesso) {
		this.designadorAcesso = designadorAcesso;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDslamName() {
		return dslamName;
	}

	public void setDslamName(String dslamName) {
		this.dslamName = dslamName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getBoardModel() {
		return boardModel;
	}

	public void setBoardModel(String boardModel) {
		this.boardModel = boardModel;
	}

	public String getPortLogic() {
		return portLogic;
	}

	public void setPortLogic(String portLogic) {
		this.portLogic = portLogic;
	}

	public String getSvlan() {
		return svlan;
	}

	public void setSvlan(String svlan) {
		this.svlan = svlan;
	}

	public String getCvlan() {
		return cvlan;
	}

	public void setCvlan(String cvlan) {
		this.cvlan = cvlan;
	}

	public String getDownstream() {
		return downstream;
	}

	public void setDownstream(String downstream) {
		this.downstream = downstream;
	}

	public String getUpstream() {
		return upstream;
	}

	public void setUpstream(String upstream) {
		this.upstream = upstream;
	}

	public String getAccessTechnology() {
		return accessTechnology;
	}

	public void setAccessTechnology(String accessTechnology) {
		this.accessTechnology = accessTechnology;
	}

	public String getSwitchAtendimento() {
		return switchAtendimento;
	}

	public void setSwitchAtendimento(String switchAtendimento) {
		this.switchAtendimento = switchAtendimento;
	}

	public String getCabinet() {
		return cabinet;
	}

	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
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

	public String getIpAddressc1() {
		return ipAddressc1;
	}

	public void setIpAddressc1(String ipAddressc1) {
		this.ipAddressc1 = ipAddressc1;
	}

	public String getInstanciac1() {
		return instanciac1;
	}

	public void setInstanciac1(String instanciac1) {
		this.instanciac1 = instanciac1;
	}

	public String getSlotc1() {
		return slotc1;
	}

	public void setSlotc1(String slotc1) {
		this.slotc1 = slotc1;
	}

	public String getPortaFisicac1() {
		return portaFisicac1;
	}

	public void setPortaFisicac1(String portaFisicac1) {
		this.portaFisicac1 = portaFisicac1;
	}

	public String getV5idc1() {
		return v5idc1;
	}

	public void setV5idc1(String v5idc1) {
		this.v5idc1 = v5idc1;
	}

	public String getTributarioc1() {
		return tributarioc1;
	}

	public void setTributarioc1(String tributarioc1) {
		this.tributarioc1 = tributarioc1;
	}

	public String getVendorNamec1() {
		return vendorNamec1;
	}

	public void setVendorNamec1(String vendorNamec1) {
		this.vendorNamec1 = vendorNamec1;
	}

	public String getPortaLogicac1() {
		return portaLogicac1;
	}

	public void setPortaLogicac1(String portaLogicac1) {
		this.portaLogicac1 = portaLogicac1;
	}

	public String getCircuitActivityIndc1() {
		return circuitActivityIndc1;
	}

	public void setCircuitActivityIndc1(String circuitActivityIndc1) {
		this.circuitActivityIndc1 = circuitActivityIndc1;
	}
	
	public String getRinVlan() {
		return rinVlan;
	}

	public void setRinVlan(String rinVlan) {
		this.rinVlan = rinVlan;
	}

	public Integer getVlanMulticast() {
		return vlanMulticast;
	}

	public void setVlanMulticast(Integer vlanMulticast) {
		this.vlanMulticast = vlanMulticast;
	}

	public Integer getVlanVod() {
		return vlanVod;
	}

	public void setVlanVod(Integer vlanVod) {
		this.vlanVod = vlanVod;
	}

	public Integer getVlanVoip() {
		return vlanVoip;
	}

	public void setVlanVoip(Integer vlanVoip) {
		this.vlanVoip = vlanVoip;
	}

	public String getShasta() {
		return shasta;
	}

	public void setShasta(String shasta) {
		this.shasta = shasta;
	}

	public String getShelfModel() {
		return shelfModel;
	}

	public void setShelfModel(String shelfModel) {
		this.shelfModel = shelfModel;
	}

	@Override
	public String toString() {
		return "RetrieveFacilityEntity [designator=" + designator + ", activity="
				+ activity + ", ipAddress=" + ipAddress + ", designadorAcesso=" + designadorAcesso + ", slot=" + slot
				+ ", port=" + port + ", dslamName=" + dslamName + ", vendorName=" + vendorName + ", boardModel="
				+ boardModel + ", portLogic=" + portLogic + ", svlan=" + svlan + ", cvlan=" + cvlan + ", downstream="
				+ downstream + ", upstream=" + upstream + ", accessTechnology=" + accessTechnology + ", switchAtendimento="
				+ switchAtendimento + ", cabinet=" + cabinet + ", rinVlan=" + rinVlan + ", vlanMulticast=" + vlanMulticast
				+ ", vlanVod=" + vlanVod + ", vlanVoip=" + vlanVoip + ", shasta=" + shasta + ", shelfModel=" + shelfModel + ", resultCode="
				+ resultCode + ", message=" + message + ", ipAddressc1=" + ipAddressc1 + ", instanciac1=" + instanciac1
				+ ", slotc1=" + slotc1 + ", portaFisicac1=" + portaFisicac1 + ", v5idc1=" + v5idc1 + ", tributarioc1="
				+ tributarioc1 + ", vendorNamec1=" + vendorNamec1 + ", portaLogicac1=" + portaLogicac1
				+ ", circuitActivityIndc1=" + circuitActivityIndc1 + ", result=" + result + "]";
	}	
}