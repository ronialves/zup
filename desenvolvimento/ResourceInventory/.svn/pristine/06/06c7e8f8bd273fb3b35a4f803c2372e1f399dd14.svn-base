package com.tlf.oss.resourceinventory.core.faultmanagement.v1_0;

import com.tlf.oss.common.client.RestClient;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.properties.Configuration;
import com.tlf.oss.common.properties.WeblogicConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.core.faultmanagement.v1_0.mapping.FaultManagementResourceDataCollectionMapping;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

import javax.inject.Inject;

@Logged
public class FaultManagementResourceDataCollection {

    @Inject private OSSLogger logger;

    private static final Configuration CFG = Configuration.getInstance(Constants.SERVER_PROPERTY, Constants.LOCAL_FILE);
    private static final WeblogicConfiguration WCFG = WeblogicConfiguration.getInstance();
    private static final String URL = String.format(CFG.get(Constants.URL_ORCHESTRATION), WCFG.getCurrentNodeName(), WCFG.getCurrentPort());
    public com.tlf.oss.resourceinventory.schemas.api.faultmanagement.RetrieveResourceInformationOut retrieveResourceInformationFM(
            Header header,
            com.tlf.oss.resourceinventory.schemas.api.faultmanagement.RetrieveResourceInformationIn retrieveResourceInformationIn)
            throws OSSBusinessException {

        ResourceInventoryEntity resourceInventoryEntity = FaultManagementResourceDataCollectionMapping.toResourceInventoryEntityFM(retrieveResourceInformationIn);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.FAULTMANAGEMENT)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        return FaultManagementResourceDataCollectionMapping.toRetrieveResourceInformationOutFM(out);
    }
}
