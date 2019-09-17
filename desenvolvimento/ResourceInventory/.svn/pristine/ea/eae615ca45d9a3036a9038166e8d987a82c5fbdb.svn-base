package com.tlf.oss.resourceinventory.tbs.api.v2_0;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("2.0")
public class RestConfig extends Application{

    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(FacilityRetrievalV2Service.class);
        return s;
    }

}