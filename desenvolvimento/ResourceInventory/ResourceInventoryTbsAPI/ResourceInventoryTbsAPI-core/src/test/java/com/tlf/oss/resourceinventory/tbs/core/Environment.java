package com.tlf.oss.resourceinventory.tbs.core;

import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

import javax.xml.bind.JAXB;

public class Environment {
    public ResourceInventoryEntity parseResourceInventoryEntityFromXML(String xmlFile) {
        return JAXB.unmarshal(getClass().getResourceAsStream("/mocks/" + xmlFile), ResourceInventoryEntity.class);
    }
}

