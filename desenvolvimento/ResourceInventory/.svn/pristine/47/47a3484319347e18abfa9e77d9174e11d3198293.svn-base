
package com.tlf.oss.resourceinventory.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPAddress", propOrder = {
    "networkNumber","modemLanMasc","modemWanMasc","type"
})
public class IPAddress {
	
    protected String networkNumber;
    @Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
    protected String modemLanMasc;
    @Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
    protected String modemWanMasc ;
    protected String type ;
    
    public String getModemLanMasc() {
		return modemLanMasc;
	}

	public void setModemLanMasc(String modemLanMasc) {
		this.modemLanMasc = modemLanMasc;
	}

	public String getModemWanMasc() {
		return modemWanMasc;
	}

	public void setModemWanMasc(String modemWanMasc) {
		this.modemWanMasc = modemWanMasc;
	}

	public String getNetworkNumber() {
        return networkNumber;
    }

    public void setNetworkNumber(String value) {
        this.networkNumber = value;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
}
