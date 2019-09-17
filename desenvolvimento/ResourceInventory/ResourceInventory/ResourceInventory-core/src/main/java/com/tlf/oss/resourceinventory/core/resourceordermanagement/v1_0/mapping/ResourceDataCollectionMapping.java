package com.tlf.oss.resourceinventory.core.resourceordermanagement.v1_0.mapping;

import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.CustomerEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveAccessInformationOut;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveResourceInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveResourceInformationOut;

public class ResourceDataCollectionMapping {
    public static ResourceInventoryEntity toResourceInventoryEntity(RetrieveResourceInformationIn in) {
        ResourceInventoryEntity ri = new ResourceInventoryEntity();
        ri.setResourceFacingService(in.getResourceFacingService());
        ri.setAddress(in.getBrazilianUrbanPropertyAddress());
        ri.setCustomerOrder(in.getCustomerOrder());
        ri.setResourceOrder(in.getResourceOrder());
        return ri;
    }

    public static RetrieveResourceInformationOut toRetrieveResourceInformationOut(ResourceInventoryEntity res) {
        RetrieveResourceInformationOut out = new RetrieveResourceInformationOut();
        out.setCabinet(res.getCabinet());
        out.setGeneralDistributors(res.getGeneralDistributors());
        out.setNetworkAggregator(res.getNetworkAggregator());
        out.setResourceOrder(res.getResourceOrder());
        out.setResourceFacingService(res.getResourceFacingService());
        out.setCustomerFacingService(res.getCustomerFacingService());

        if(res.getAddress() != null)
            out.setAddress(res.getAddress());

        return out;
    }

    public static RetrieveAccessInformationOut toRetrieveAccessInformationOut(CustomerEntity res) {
        RetrieveAccessInformationOut out = new RetrieveAccessInformationOut();

        ResourceFacingService resourceFacingService = new ResourceFacingService();
        resourceFacingService.setServiceId(res.getAccessDesignator());
        updateResourceFacingService(resourceFacingService, "NetworkOwnerId", res.getAccessId());
        updateResourceFacingService(resourceFacingService, "NRC", res.getCustomerId());
        updateResourceFacingService(resourceFacingService, "NetworkOwner", res.getNetworkOwner());
        out.setResourceFacingService(resourceFacingService);
        return out;
    }


    private static void updateResourceFacingService(ResourceFacingService resourceFacingService, String name, String value) {
        ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
        serviceSpecCharDescribes.setValue(value);

        ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
        serviceDescribedBy.setName(name);
        serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);

        resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
    }
}
