package com.tlf.oss.resourceinventory.tbs.api.faultmanagement.v1_0;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("faultmanagement/1.0")
public class RestConfig extends Application{

    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(EquipmentRetrievalService.class);
        return s;
    }

}