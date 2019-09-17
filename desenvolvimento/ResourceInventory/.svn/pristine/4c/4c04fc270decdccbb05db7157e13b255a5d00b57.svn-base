package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkAddressAssociation", propOrder = {
    "ipAddressList",
    "atomicNetworkAddress"
})
public class NetworkAddressAssociation {
   
    @XmlElement(name = "ipAddress")
	protected List<IPAddress> ipAddressList;

    protected AtomicNetworkAddress atomicNetworkAddress;

    public AtomicNetworkAddress getAtomicNetworkAddress() {
        return atomicNetworkAddress;
    }

    public void setAtomicNetworkAddress(AtomicNetworkAddress value) {
        this.atomicNetworkAddress = value;
    }

	public List<IPAddress> getIpAddressList() {
		return ipAddressList==null? new ArrayList<IPAddress>():ipAddressList;
    }

	public void setIpAddressList(List<IPAddress> ipAddressList) {
		this.ipAddressList = ipAddressList;
    }
	
	public void setIpAddressList(IPAddress ... ipAddresses){
		this.ipAddressList = Arrays.asList(ipAddresses);
	}
	
	public void addIpAddress(IPAddress ipAddress){
		this.getIpAddressList().add(ipAddress);
	}
}
