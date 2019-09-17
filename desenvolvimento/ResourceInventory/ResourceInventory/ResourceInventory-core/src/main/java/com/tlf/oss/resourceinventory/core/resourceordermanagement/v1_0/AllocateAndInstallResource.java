package com.tlf.oss.resourceinventory.core.resourceordermanagement.v1_0;

import com.tlf.oss.common.client.RestClient;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.properties.Configuration;
import com.tlf.oss.common.properties.WeblogicConfiguration;
import com.tlf.oss.common.schemas.entity.Warn;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.core.resourceordermanagement.v1_0.mapping.AllocateAndInstallResourceMapping;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.*;

import javax.inject.Inject;
import javax.xml.ws.Holder;

@Logged
public class AllocateAndInstallResource {
    private static final Configuration CFG = Configuration.getInstance(Constants.SERVER_PROPERTY, Constants.LOCAL_FILE);
    private static final WeblogicConfiguration WCFG = WeblogicConfiguration.getInstance();
    private static final String URL = String.format(CFG.get(Constants.URL_ORCHESTRATION), WCFG.getCurrentNodeName(), WCFG.getCurrentPort());
    
    @Inject
    private OSSLogger logger;

    public DetermineResourceAvailabilityOut determineResourceAvailability(Header header, Holder<Warn> warn, DetermineResourceAvailabilityIn in) throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntity = AllocateAndInstallResourceMapping.toResourceInventoryEntity(in);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.DETERMINE_AVALIABILITY)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        return AllocateAndInstallResourceMapping.toDetermineResourceAvailabilityOut(out, warn);
    }

    public ReserveResourceOut reserveResource(Header header, ReserveResourceIn in) throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntity = AllocateAndInstallResourceMapping.toResourceInventoryEntity(in);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.RESERVE_RESOURCE)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        return AllocateAndInstallResourceMapping.toReserveResourceOut(out);
    }

    public ReleaseResourceOut releaseResource(Header header, ReleaseResourceIn in) throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntity = AllocateAndInstallResourceMapping.toResourceInventoryEntity(in);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.RELEASE_RESOURCE)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        return AllocateAndInstallResourceMapping.toReleaseResourceOut(out);
    }

    public AllocateResourceOut allocateResource(Header header, AllocateResourceIn in) throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntity = AllocateAndInstallResourceMapping.toResourceInventoryEntity(in);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.ALLOCATE_RESOURCE)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        return AllocateAndInstallResourceMapping.toAllocateResourceOut(out);
    }

    public InstallResourceOut installResource(Header header, InstallResourceIn in) throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntity = AllocateAndInstallResourceMapping.toResourceInventoryEntity(in);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.INSTALL_RESOURCE)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        return AllocateAndInstallResourceMapping.toInstallResourceOut(out);
    }

    public DeallocateResourceOut deallocateResource(Header header, DeallocateResourceIn in) throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntity = AllocateAndInstallResourceMapping.toResourceInventoryEntity(in);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.DEALLOCATE_RESOURCE)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        return AllocateAndInstallResourceMapping.toDeallocateResourceOut(out);
    }

    public UninstallResourceOut unistallResourceOut(Header header, UninstallResourceIn in) throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntity = AllocateAndInstallResourceMapping.toResourceInventoryEntity(in);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(resourceInventoryEntity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.UNINSTALL_RESOURCE)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);

        return AllocateAndInstallResourceMapping.toUninstallResourceOut(out);

    }

    public UpdateResourceOut updateResource(Header header, UpdateResourceIn in) throws OSSBusinessException {
        final ResourceInventoryEntity entity = AllocateAndInstallResourceMapping.toResourceInventoryEntity(in);

        ResourceInventoryEntity out = RestClient.Builder
                .newBuilder(logger, header)
                .target(URL)
                .entity(entity)
                .pathParam("version", "1.0")
                .pathParam("action", Constants.UPDATE_RESOURCE)
                .method(RestClient.Method.Post)
                .build()
                .callService(ResourceInventoryEntity.class);


        return AllocateAndInstallResourceMapping.toUpdateResourceOut(out);
    }

}
