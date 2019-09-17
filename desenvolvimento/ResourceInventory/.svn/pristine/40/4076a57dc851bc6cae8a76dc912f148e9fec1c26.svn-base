package com.tlf.oss.resourceinventory.core.resourcelifecyclemanagement.v1_0.mapping;

import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0.GatherResourceInformation;
import com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0.GatherResourceInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0.GatherResourceInformationOut;

public class GatherAndAnalyseResourceInformationMapping {
    public static ResourceInventoryEntity toResourceInventoryEntityGattherIn(GatherResourceInformationIn gatherResourceInformationIn) {

        ResourceInventoryEntity ri = new ResourceInventoryEntity();

        GatherResourceInformation gatherResourceInformation = new GatherResourceInformation();
        gatherResourceInformation.setAddress(gatherResourceInformationIn.getBrazilianUrbanPropertyAddress());
        gatherResourceInformation.setCabinet(gatherResourceInformationIn.getCabinet());
        gatherResourceInformation.setShelf(gatherResourceInformationIn.getShelf());
        gatherResourceInformation.setSplitter(gatherResourceInformationIn.getSplitter());
        gatherResourceInformation.setResourceOrder(gatherResourceInformationIn.getResourceOrder());

        ri.setGatherResourceInformation(gatherResourceInformation);

        return ri;
    }

    public static GatherResourceInformationOut toResourceInventoryEntityGattherOut(ResourceInventoryEntity resourceInventoryEntity) {

        GatherResourceInformationOut gatherResourceInformationOut = new GatherResourceInformationOut();

        gatherResourceInformationOut.setCabinet(resourceInventoryEntity.getCabinet());

        return gatherResourceInformationOut;
    }
}
