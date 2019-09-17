package com.tlf.oss.resourceinventory.core.resourceordermanagement.v2_0;

import com.tlf.oss.common.client.RestClient;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.properties.Configuration;
import com.tlf.oss.common.properties.WeblogicConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.api.v2_0.RetrieveResourceInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.v2_0.RetrieveResourceInformationOut;

import javax.inject.Inject;

@Logged
public class ResourceDataCollectionV2 {
    private static final Configuration CFG = Configuration.getInstance(Constants.SERVER_PROPERTY, Constants.LOCAL_FILE);
    private static final WeblogicConfiguration WCFG = WeblogicConfiguration.getInstance();
    private static final String URL = String.format(CFG.get(Constants.URL_ORCHESTRATION), WCFG.getCurrentNodeName(), WCFG.getCurrentPort());

    @Inject
    private OSSLogger logger;

    public RetrieveResourceInformationOut retrieveResourceInformation(Header header, RetrieveResourceInformationIn in)
            throws OSSBusinessException {

        ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();
        resourceInventoryEntity.setResourceFacingService(in.getResourceFacingService());
        resourceInventoryEntity.setAddress(in.getBrazilianUrbanPropertyAddress());
        resourceInventoryEntity.setCustomerOrder(in.getCustomerOrder());
        resourceInventoryEntity.setResourceOrder(in.getResourceOrder());
        resourceInventoryEntity.setResource(in.getResource());


        resourceInventoryEntity = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "2.0")
                .pathParam("action", Constants.RETRIEVE_RESOURCE_INFORMATION)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        RetrieveResourceInformationOut out = new RetrieveResourceInformationOut();
        out.setCabinet(resourceInventoryEntity.getCabinet());
        out.setGeneralDistributors(resourceInventoryEntity.getGeneralDistributors());
        out.setNetworkAggregator(resourceInventoryEntity.getNetworkAggregator());
        out.setResourceOrder(resourceInventoryEntity.getResourceOrder());
        out.setResourceFacingService(resourceInventoryEntity.getResourceFacingService());
        out.setCustomerFacingService(resourceInventoryEntity.getCustomerFacingService());

        //Adicionando comentario para teste de deploy

        if(resourceInventoryEntity.getAddress() != null)
            out.setAddress(resourceInventoryEntity.getAddress());

        return out;
    }
}
