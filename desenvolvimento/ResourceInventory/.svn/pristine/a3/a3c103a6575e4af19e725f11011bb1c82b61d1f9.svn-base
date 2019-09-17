
package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkRouteAssociation", propOrder = { "networkRoute" })
public class NetworkRouteAssociation {

	@XmlElement(name="networkRoute")
    protected List<NetworkRoute> networkRoute;

    public List<NetworkRoute> getNetworkRoute() {
        if (networkRoute == null) {
            networkRoute = new ArrayList<NetworkRoute>();
        }
        return this.networkRoute;
    }
}
