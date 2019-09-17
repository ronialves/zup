package com.tlf.oss.resourceinventory.core.resourceordermanagement.v1_0;

import com.tlf.oss.common.client.RestClient;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.properties.Configuration;
import com.tlf.oss.common.properties.WeblogicConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.core.resourceordermanagement.v1_0.mapping.ResourceDataCollectionMapping;
import com.tlf.oss.resourceinventory.schemas.api.CustomerEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveAccessInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveAccessInformationOut;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveResourceInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveResourceInformationOut;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Logged
public class ResourceDataCollection {

    private static final Configuration CFG = Configuration.getInstance(Constants.SERVER_PROPERTY, Constants.LOCAL_FILE);
    private static final WeblogicConfiguration WCFG = WeblogicConfiguration.getInstance();
    private static final String URL = String.format(CFG.get(Constants.URL_ORCHESTRATION), WCFG.getCurrentNodeName(), WCFG.getCurrentPort());
    private static final String URL_RETRIEVE_CUSTOMER = String.format(CFG.get(Constants.URL_REPOSITORY_CUSTOMER_RETRIEVE), WCFG.getCurrentNodeName(), WCFG.getCurrentPort());

    @Inject
    private OSSLogger logger;

    public RetrieveResourceInformationOut retrieveResourceInformation(Header header, RetrieveResourceInformationIn in)
            throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntity = ResourceDataCollectionMapping.toResourceInventoryEntity(in);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.RETRIEVE_RESOURCE_INFORMATION)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        return ResourceDataCollectionMapping.toRetrieveResourceInformationOut(out);
    }

    public RetrieveAccessInformationOut retrieveAccessInformation(Header header, RetrieveAccessInformationIn in) throws OSSBusinessException {

        Response response = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL_RETRIEVE_CUSTOMER)
                .pathParam("version", "1.0")
                .pathParam("entity", "customer")
                .pathParam("id", in.getResourceFacingService().getServiceId())
                .method(RestClient.Method.Get)
                .validateNotFound(false)
                .build()
                .callService(Response.class);

        if (response.getStatus() == 404) {
            return null;
        }

        CustomerEntity out =  response.readEntity(CustomerEntity.class);
        return ResourceDataCollectionMapping.toRetrieveAccessInformationOut(out);
    }
}
