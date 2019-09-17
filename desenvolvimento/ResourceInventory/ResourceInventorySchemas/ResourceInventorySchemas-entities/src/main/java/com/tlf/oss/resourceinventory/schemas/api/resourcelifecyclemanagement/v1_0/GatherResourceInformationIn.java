package com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0;

import com.tlf.oss.resourceinventory.schemas.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GatherResourceInformationIn", propOrder = { "brazilianUrbanPropertyAddress", "cabinet", "shelf", "splitter", "resourceOrder"})
public class GatherResourceInformationIn {
    protected BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress;
    protected Cabinet cabinet;
    protected Shelf shelf;
    protected Splitter splitter;
    private ResourceOrder resourceOrder;

    public GatherResourceInformationIn() {
    }

    public BrazilianUrbanPropertyAddress getBrazilianUrbanPropertyAddress() {
        return brazilianUrbanPropertyAddress;
    }

    public void setBrazilianUrbanPropertyAddress(BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress) {
        this.brazilianUrbanPropertyAddress = brazilianUrbanPropertyAddress;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public Splitter getSplitter() {
        return splitter;
    }

    public void setSplitter(Splitter splitter) {
        this.splitter = splitter;
    }

    public void setResourceOrder(ResourceOrder resourceOrder) {
        this.resourceOrder = resourceOrder;
    }

    public ResourceOrder getResourceOrder() {
        return resourceOrder;
    }
}