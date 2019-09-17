package com.tlf.oss.resourceinventory.tbs.api.v1_0;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("1.0")
public class RestConfig extends Application{

    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(AllocateService.class);
        s.add(NetworkInformationRetrievalService.class);
        s.add(FacilityRetrievalService.class);
        s.add(InstallService.class);
        s.add(DeallocateService.class);
        s.add(UninstallService.class);
        s.add(ReserveService.class);
        s.add(DetermineAvailabilityService.class);
        s.add(GatherResourceInformationService.class);
        return s;
    }

}