package com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0;

import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Equipment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveResourceInformationOut", propOrder = { "cabinet" })
public class GatherResourceInformationOut {
    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    private Cabinet cabinet;
}
