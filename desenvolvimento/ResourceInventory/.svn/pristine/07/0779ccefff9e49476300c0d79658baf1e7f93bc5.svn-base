package com.tlf.oss.resourceinventory.tbs.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "gatherResource", resultClasses = GatherResourceEntity.class, procedureName = "ASAP.TLF_SP_ANALISA_FUSION", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EQUIPMENT_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ARMARIO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_SPLITTER_1N", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NAME_HL", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_VENDOR_HL", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_HOSTNAME", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NASIP", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SITE", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_IP_ADDRESS", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_MASCARA_IP", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_GERENCIA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SWITCH_ATENDIMENTO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_V5ID", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SWITCH_ATENDIMENTO2", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_V5ID2", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SHASTA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_PROTOCOLO_AGCF", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NOME_AGCF", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_IP_ADDRESS_AGCF", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NUMERO_BRAS", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SLOT_BRAS", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SUB_SLOT_BRAS", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_PORTA_BRAS", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_STACK_VLAN", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NUMERO_AGREGADOR", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SLOT_AGREGADOR", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_SUB_SLOT_AGREGADOR", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_PORTA_AGREGADOR", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_TIPO_CATEGORIA_VLAN", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_VLAN_VOD", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_VLAN_VOIP", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_VLAN_MCAST", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_VLAN_IPTV", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_EXTERNAL_NETWORK_OWNER", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_FUSION", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_COD_RETORNO", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_MSG_RETORNO", type = String.class),
        })
})
public class GatherResourceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic
    @Column(name = "P_EQUIPMENT_ID")
    private Integer equipmentId;

    @Basic
    @Column(name = "P_ARMARIO")
    private String armario;

    @Basic
    @Column(name = "P_SPLITTER_1N")
    private String splitter1n;

    @Basic
    @Column(name = "P_NAME_HL")
    private String nameHL;

    @Basic
    @Column(name = "P_VENDOR_HL")
    private String vendorHL;

    @Basic
    @Column(name = "P_HOSTNAME")
    private String hostName;

    @Basic
    @Column(name = "P_NASIP")
    private String nasip;

    @Basic
    @Column(name = "P_SITE")
    private String site;


    @Basic
    @Column(name = "P_IP_ADDRESS")
    private String ipAddress;

    @Basic
    @Column(name = "P_MASCARA_IP")
    private String mascaraIp;

    @Basic
    @Column(name = "P_GERENCIA")
    private String gerencia;

    @Basic
    @Column(name = "P_SWITCH_ATENDIMENTO")
    private String switchAtendimento;

    @Basic
    @Column(name = "P_V5ID")
    private String v5ID;

    @Basic
    @Column(name = "P_SWITCH_ATENDIMENTO2")
    private String switchAtendimento2;

    @Basic
    @Column(name = "P_V5ID2")
    private String v5ID2;

    @Basic
    @Column(name = "P_SHASTA")
    private String shasta;

    @Basic
    @Column(name = "P_PROTOCOLO_AGCF")
    private String protocoloAGCF;

    @Basic
    @Column(name = "P_NOME_AGCF")
    private String nomeAGCF;

    @Basic
    @Column(name = "P_IP_ADDRESS_AGCF")
    private String ipAddressAGCF;

    @Basic
    @Column(name = "P_NUMERO_BRAS")
    private String numeroBras;

    @Basic
    @Column(name = "P_SLOT_BRAS")
    private String slotBras;

    @Basic
    @Column(name = "P_SUB_SLOT_BRAS")
    private String subSlotBras;

    @Basic
    @Column(name = "P_PORTA_BRAS")
    private String portaBras;

    @Basic
    @Column(name = "P_STACK_VLAN")
    private Integer stackVlan;

    @Basic
    @Column(name = "P_NUMERO_AGREGADOR")
    private String numeroAgregador;

    @Basic
    @Column(name = "P_SLOT_AGREGADOR")
    private String slotAgregador;

    @Basic
    @Column(name = "P_SUB_SLOT_AGREGADOR")
    private String subSlotAgregador;

    @Basic
    @Column(name = "P_PORTA_AGREGADOR")
    private String portaAgregador;

    @Basic
    @Column(name = "P_TIPO_CATEGORIA_VLAN")
    private String tipoCategatoriaVlan;

    @Basic
    @Column(name = "P_VLAN_VOD")
    private Integer vlanVod;

    @Basic
    @Column(name = "P_VLAN_VOIP")
    private Integer vlanVoip;

    @Basic
    @Column(name = "P_VLAN_MCAST")
    private Integer vlanMcast;

    @Basic
    @Column(name = "P_VLAN_IPTV")
    private Integer vlanIptv;

    @Basic
    @Column(name = "P_EXTERNAL_NETWORK_OWNER")
    private String externalNetworkOwner;

    @Basic
    @Column(name = "P_FUSION")
    private String fusion;

    @Id
    @Basic
    @Column(name = "P_COD_RETORNO")
    private Integer codigoRetorno;

    @Basic
    @Column(name = "P_MSG_RETORNO")
    private String mensagemRetorno;

    public  GatherResourceEntity() {}

    public GatherResourceEntity(
            Integer equipmentId, String armario, String splitter1n, String nameHL, String vendorHL,
            String hostName, String nasip, String site, String ipAddress, String mascaraIp, String gerencia, String switchAtendimento,
            String v5ID, String switchAtendimento2, String v5ID2, String shasta, String protocoloAGCF, String nomeAGCF,
            String ipAddressAGCF, String numeroBras, String slotBras, String subSlotBras, String portaBras,
            Integer stackVlan, String numeroAgregador, String slotAgregador, String subSlotAgregador,
            String portaAgregador, String tipoCategatoriaVlan, Integer vlanVod, Integer vlanVoip,
            Integer vlanMcast, Integer vlanIptv, String externalNetworkOwner, String fusion,
            Integer codigoRetorno, String mensagemRetorno
    ) {
        super();
        this.equipmentId = equipmentId;
        this.armario = armario;
        this.splitter1n = splitter1n;
        this.nameHL = nameHL;
        this.vendorHL = vendorHL;
        this.hostName = hostName;
        this.nasip = nasip;
        this.site = site;
        this.ipAddress = ipAddress;
        this.mascaraIp = mascaraIp;
        this.gerencia = gerencia;
        this.switchAtendimento = switchAtendimento;
        this.v5ID = v5ID;
        this.switchAtendimento2 = switchAtendimento2;
        this.v5ID2 = v5ID2;
        this.shasta = shasta;
        this.protocoloAGCF = protocoloAGCF;
        this.nomeAGCF = nomeAGCF;
        this.ipAddressAGCF = ipAddressAGCF;
        this.numeroBras = numeroBras;
        this.slotBras = slotBras;
        this.subSlotBras = subSlotBras;
        this.portaBras = portaBras;
        this.stackVlan = stackVlan;
        this.numeroAgregador = numeroAgregador;
        this.slotAgregador = slotAgregador;
        this.subSlotAgregador = subSlotAgregador;
        this.portaAgregador = portaAgregador;
        this.tipoCategatoriaVlan = tipoCategatoriaVlan;
        this.vlanVod = vlanVod;
        this.vlanVoip = vlanVoip;
        this.vlanMcast = vlanMcast;
        this.vlanIptv = vlanIptv;
        this.externalNetworkOwner = externalNetworkOwner;
        this.fusion = fusion;
        this.codigoRetorno = codigoRetorno;
        this.mensagemRetorno = mensagemRetorno;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GatherResourceEntity [");
        if (equipmentId != null) {
            builder.append("equimentId=");
            builder.append(equipmentId);
            builder.append(", ");
        }
        if (armario != null) {
            builder.append("armario=");
            builder.append(armario);
            builder.append(", ");
        }
        if (splitter1n != null) {
            builder.append("splitter1n=");
            builder.append(splitter1n);
            builder.append(", ");
        }
        if (nameHL != null) {
            builder.append("nameHL=");
            builder.append(nameHL);
            builder.append(", ");
        }
        if (vendorHL != null) {
            builder.append("vendorHL=");
            builder.append(vendorHL);
            builder.append(", ");
        }
        if (hostName != null) {
            builder.append("hostName=");
            builder.append(hostName);
            builder.append(", ");
        }
        if (nasip != null) {
            builder.append("nasip=");
            builder.append(nasip);
            builder.append(", ");
        }
        if (site != null) {
            builder.append("site=");
            builder.append(site);
            builder.append(", ");
        }

        if (ipAddress != null) {
            builder.append("ipAddress=");
            builder.append(ipAddress);
            builder.append(", ");
        }

        if (mascaraIp != null) {
            builder.append("mascaraIp=");
            builder.append(mascaraIp);
            builder.append(", ");
        }

        if (gerencia != null) {
            builder.append("gerencia=");
            builder.append(gerencia);
            builder.append(", ");
        }

        if (switchAtendimento != null) {
            builder.append("switchAtendimento=");
            builder.append(switchAtendimento);
            builder.append(", ");
        }

        if (v5ID != null) {
            builder.append("v5ID=");
            builder.append(v5ID);
            builder.append(", ");
        }

        if (switchAtendimento2 != null) {
            builder.append("switchAtendimento2=");
            builder.append(switchAtendimento2);
            builder.append(", ");
        }

        if (v5ID2 != null) {
            builder.append("v5ID2=");
            builder.append(v5ID2);
            builder.append(", ");
        }

        if (shasta != null) {
            builder.append("shasta=");
            builder.append(shasta);
            builder.append(", ");
        }

        if (protocoloAGCF != null) {
            builder.append("protocoloAGCF=");
            builder.append(protocoloAGCF);
            builder.append(", ");
        }

        if (nomeAGCF != null) {
            builder.append("nomeAGCF=");
            builder.append(nomeAGCF);
            builder.append(", ");
        }

        if (ipAddressAGCF != null) {
            builder.append("ipAddressAGCF=");
            builder.append(ipAddressAGCF);
            builder.append(", ");
        }

        if (numeroBras != null) {
            builder.append("numeroBras=");
            builder.append(numeroBras);
            builder.append(", ");
        }

        if (slotBras != null) {
            builder.append("slotBras=");
            builder.append(slotBras);
            builder.append(", ");
        }

        if (subSlotBras != null) {
            builder.append("subSlotBras=");
            builder.append(subSlotBras);
            builder.append(", ");
        }

        if (portaBras != null) {
            builder.append("portaBras=");
            builder.append(portaBras);
            builder.append(", ");
        }

        if (stackVlan != null) {
            builder.append("stackVlan=");
            builder.append(stackVlan);
            builder.append(", ");
        }

        if (numeroAgregador != null) {
            builder.append("numeroAgregador=");
            builder.append(numeroAgregador);
            builder.append(", ");
        }

        if (slotAgregador != null) {
            builder.append("slotAgregador=");
            builder.append(slotAgregador);
            builder.append(", ");
        }

        if (subSlotAgregador != null) {
            builder.append("subSlotAgregador=");
            builder.append(subSlotAgregador);
            builder.append(", ");
        }

        if (portaAgregador != null) {
            builder.append("portaAgregador=");
            builder.append(portaAgregador);
            builder.append(", ");
        }

        if (tipoCategatoriaVlan != null) {
            builder.append("tipoCategatoriaVlan=");
            builder.append(tipoCategatoriaVlan);
            builder.append(", ");
        }

        if (vlanVod != null) {
            builder.append("vlanVod=");
            builder.append(vlanVod);
            builder.append(", ");
        }

        if (vlanVoip != null) {
            builder.append("vlanVoip=");
            builder.append(vlanVoip);
            builder.append(", ");
        }

        if (vlanMcast != null) {
            builder.append("vlanMcast=");
            builder.append(vlanMcast);
            builder.append(", ");
        }

        if (vlanIptv != null) {
            builder.append("vlanIptv=");
            builder.append(vlanIptv);
            builder.append(", ");
        }

        if (externalNetworkOwner != null) {
            builder.append("externalNetworkOwner=");
            builder.append(externalNetworkOwner);
            builder.append(", ");
        }

        if (fusion != null) {
            builder.append("fusion=");
            builder.append(fusion);
            builder.append(", ");
        }

        if (codigoRetorno != null) {
            builder.append("codigoRetorno=");
            builder.append(codigoRetorno);
            builder.append(", ");
        }
        if (mensagemRetorno != null) {
            builder.append("mensagemRetorno=");
            builder.append(mensagemRetorno);
            builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getArmario() {
        return armario;
    }

    public void setArmario(String armario) {
        this.armario = armario;
    }

    public String getSplitter1n() {
        return splitter1n;
    }

    public void setSplitter1n(String splitter1n) {
        this.splitter1n = splitter1n;
    }

    public String getNameHL() {
        return nameHL;
    }

    public void setNameHL(String nameHL) {
        this.nameHL = nameHL;
    }

    public String getVendorHL() {
        return vendorHL;
    }

    public void setVendorHL(String vendorHL) {
        this.vendorHL = vendorHL;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getNasip() {
        return nasip;
    }

    public void setNasip(String nasip) {
        this.nasip = nasip;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMascaraIp() {
        return this.mascaraIp;
    }
    public void setMascaraIp(String mascaraIp) {
        this.mascaraIp = mascaraIp;
    }

    public String getGerencia() {
        return this.gerencia;
    }
    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getSwitchAtendimento() {
        return this.switchAtendimento;
    }
    public void setSwitchAtendimento(String switchAtendimento) {
        this.switchAtendimento = switchAtendimento;
    }

    public String getV5ID() {
        return this.v5ID;
    }
    public void setV5ID(String v5ID) {
        this.v5ID = v5ID;
    }

    public String getSwitchAtendimento2() {
        return this.switchAtendimento2;
    }
    public void setSwitchAtendimento2(String switchAtendimento2) {
        this.switchAtendimento2 = switchAtendimento2;
    }

    public String getV5ID2() {
        return this.v5ID2;
    }
    public void setV5ID2(String v5ID2) {
        this.v5ID2 = v5ID2;
    }

    public String getShasta() {
        return this.shasta;
    }
    public void setShasta(String shasta) {
        this.shasta = shasta;
    }

    public String getProtocoloAGCF() {
        return this.protocoloAGCF;
    }
    public void setProtocoloAGCF(String protocoloAGCF) {
        this.protocoloAGCF = protocoloAGCF;
    }

    public String getNomeAGCF() {
        return this.nomeAGCF;
    }
    public void setNomeAGCF(String nomeAGCF) {
        this.nomeAGCF = nomeAGCF;
    }

    public String getIpAddressAGCF() {
        return this.ipAddressAGCF;
    }
    public void setIpAddressAGCF(String ipAddressAGCF) {
        this.ipAddressAGCF = ipAddressAGCF;
    }

    public String getNumeroBras() {
        return this.numeroBras;
    }
    public void setNumeroBras(String numeroBras) {
        this.numeroBras = numeroBras;
    }

    public String getSlotBras() {
        return this.slotBras;
    }
    public void setSlotBras(String slotBras) {
        this.slotBras = slotBras;
    }

    public String getSubSlotBras() {
        return this.subSlotBras;
    }
    public void setSubSlotBras(String subSlotBras) {
        this.subSlotBras = subSlotBras;
    }

    public String getPortaBras() {
        return this.portaBras;
    }
    public void setPortaBras(String portaBras) {
        this.portaBras = portaBras;
    }

    public Integer getStackVlan() {
        return this.stackVlan;
    }
    public void setStackVlan(Integer stackVlan) {
        this.stackVlan = stackVlan;
    }

    public String getNumeroAgregador() {
        return this.numeroAgregador;
    }
    public void setNumeroAgregador(String numeroAgregador) {
        this.numeroAgregador = numeroAgregador;
    }

    public String getSlotAgregador() {
        return this.slotAgregador;
    }
    public void setSlotAgregador(String slotAgregador) {
        this.slotAgregador = slotAgregador;
    }

    public String getSubSlotAgregador() {
        return this.subSlotAgregador;
    }
    public void setSubSlotAgregador(String subSlotAgregador) {
        this.subSlotAgregador = subSlotAgregador;
    }

    public String getPortaAgregador() {
        return this.portaAgregador;
    }
    public void setPortaAgregador(String portaAgregador) {
        this.portaAgregador = portaAgregador;
    }

    public String getTipoCategatoriaVlan() {
        return this.tipoCategatoriaVlan;
    }
    public void setTipoCategatoriaVlan(String tipoCategatoriaVlan) {
        this.tipoCategatoriaVlan = tipoCategatoriaVlan;
    }

    public Integer getVlanVod() {
        return this.vlanVod;
    }
    public void setVlanVod(Integer vlanVod) {
        this.vlanVod = vlanVod;
    }

    public Integer getVlanVoip() {
        return this.vlanVoip;
    }
    public void setVlanVoip(Integer vlanVoip) {
        this.vlanVoip = vlanVoip;
    }

    public Integer getVlanMcast() {
        return this.vlanMcast;
    }
    public void setVlanMcast(Integer vlanMcast) {
        this.vlanMcast = vlanMcast;
    }

    public Integer getVlanIptv() {
        return this.vlanIptv;
    }
    public void setVlanIptv(Integer vlanIptv) {
        this.vlanIptv = vlanIptv;
    }

    public String getExternalNetworkOwner() {
        return this.externalNetworkOwner;
    }
    public void setExternalNetworkOwner(String externalNetworkOwner) {
        this.externalNetworkOwner = externalNetworkOwner;
    }

    public String getFusion() {
        return this.fusion;
    }
    public void setFusion(String fusion) {
        this.fusion = fusion;
    }

    public Integer getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(Integer codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public String getMensagemRetorno() {
        return mensagemRetorno;
    }

    public void setMensagemRetorno(String mensagemRetorno) {
        this.mensagemRetorno = mensagemRetorno;
    }
}
