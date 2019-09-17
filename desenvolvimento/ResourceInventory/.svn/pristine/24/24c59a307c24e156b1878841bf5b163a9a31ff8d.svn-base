package com.tlf.oss.resourceinventory.core.resourcelifecyclemanagement.v1_0;

import com.tlf.oss.common.client.RestClient;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.properties.Configuration;
import com.tlf.oss.common.properties.WeblogicConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.core.resourcelifecyclemanagement.v1_0.mapping.GatherAndAnalyseResourceInformationMapping;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0.GatherResourceInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0.GatherResourceInformationOut;

import javax.inject.Inject;

@Logged
public class GatherAndAnalyseResourceInformation {

    private static final Configuration CFG = Configuration.getInstance(Constants.SERVER_PROPERTY, Constants.LOCAL_FILE);
    private static final WeblogicConfiguration WCFG = WeblogicConfiguration.getInstance();
    private static final String URL = String.format(CFG.get(Constants.URL_ORCHESTRATION), WCFG.getCurrentNodeName(), WCFG.getCurrentPort());

    @Inject
    private OSSLogger logger;

    public GatherResourceInformationOut gatherResourceInformation(
            Header header,
            GatherResourceInformationIn gatherResourceInformationIn)
            throws OSSBusinessException {

        ResourceInventoryEntity resourceInventoryEntity = GatherAndAnalyseResourceInformationMapping.toResourceInventoryEntityGattherIn(gatherResourceInformationIn);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.GATHER_AND_ANALYSE_RESOURCE_INFORMATION)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        return GatherAndAnalyseResourceInformationMapping.toResourceInventoryEntityGattherOut(out);
    }
}
