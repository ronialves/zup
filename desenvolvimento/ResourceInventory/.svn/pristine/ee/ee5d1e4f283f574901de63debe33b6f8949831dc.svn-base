package com.tlf.oss.resourceinventory.tbs.core;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.*;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0.GatherResourceInformation;
import com.tlf.oss.resourceinventory.tbs.entity.GatherResourceEntity;
import com.tlf.oss.resourceinventory.tbs.repository.GatherResourceInformationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GatherResourceInformationControllerTest {

    @Mock GatherResourceInformationRepository gatherResourceInformationRepository;
    @Spy OSSLogger ossLogger;

    @InjectMocks GatherResourceInformationController gatherResourceInformationController;
    private final Environment environment = new Environment();

    @Test
    public void gatherResourceInformationByCabinetAndSplitter() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("GatherResourceInformationByCabinetAndSplitter.xml");
        GatherResourceInformation gatherResourceInformation = resourceInventoryEntityRequest.getGatherResourceInformation();
        Cabinet cabinet = gatherResourceInformation.getCabinet();
        Splitter splitter = gatherResourceInformation.getSplitter();
        GatherResourceEntity gatherResourceEntity = this.buildGatherResourceEntity("PRCT-ADDR", "ALCATEL", "darh.vader", "10.34.51.253",
                "death.star", "198.58.4.5", "25", "P48", "CTA-2344", "PI&*()", "LOS", "OIO89",
                "SHASTA", "AGCFPROTO", "AGCFNAME, ","198.3.3.3", "78", "5", "4", "84", 45,
                "90", "4", "5", "80", "TIPOC", 4,1,2, 3, "SPACE", "TRUE");

        when(this.gatherResourceInformationRepository.gatherResourceInformationByCabinetAndSplitter(cabinet, splitter))
                .thenReturn(gatherResourceEntity);

        ResourceInventoryEntity resourceInventoryEntityResponse = this.gatherResourceInformationController.gatherResource(resourceInventoryEntityRequest);
        this.validateFusedNetwork(gatherResourceEntity, resourceInventoryEntityResponse);
        verify(this.gatherResourceInformationRepository, times(0)).gatherResourceInformationByEquipment(any());
        verify(this.gatherResourceInformationRepository, times(1)).gatherResourceInformationByCabinetAndSplitter(cabinet, splitter);
    }

    @Test
    public void gatherResourceInformationByCabinetAndSplitterNotFused() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("GatherResourceInformationByCabinetAndSplitter.xml");
        GatherResourceInformation gatherResourceInformation = resourceInventoryEntityRequest.getGatherResourceInformation();
        Cabinet cabinet = gatherResourceInformation.getCabinet();
        Splitter splitter = gatherResourceInformation.getSplitter();
        GatherResourceEntity gatherResourceEntity = this.buildGatherResourceEntity("PRCT-OUI", "NOKIA", "darh.vader", null,
                "death.star", "198.158.4.5", "24", "P+98", "CTA-781", "PI&*()", "L-PO01", "OIO89",
                "SHASTA", "AGCFPROTO", "AGCFNAME, ","198.3.3.3", "78", "5", "4", "84", 45,
                "901", "24", "54", "80", "TIPOA", 10,1,2, 8, "ALCA", "FALSE");

        when(this.gatherResourceInformationRepository.gatherResourceInformationByCabinetAndSplitter(cabinet, splitter))
                .thenReturn(gatherResourceEntity);

        ResourceInventoryEntity resourceInventoryEntityResponse = this.gatherResourceInformationController.gatherResource(resourceInventoryEntityRequest);
        this.validateResponse(gatherResourceEntity, resourceInventoryEntityResponse, 19, 12);
        verify(this.gatherResourceInformationRepository, times(0)).gatherResourceInformationByEquipment(any());
        verify(this.gatherResourceInformationRepository, times(1)).gatherResourceInformationByCabinetAndSplitter(cabinet, splitter);
    }


    @Test
    public void gatherResourceInformationByShelf() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("GatherResourceInformationByShelf.xml");
        GatherResourceInformation gatherResourceInformation = resourceInventoryEntityRequest.getGatherResourceInformation();
        Shelf shelf = gatherResourceInformation.getShelf();
        PortAdapterCard portAdapterCard = shelf.getHasCards().get(0);
        GatherResourceEntity gatherResourceEntity = this.buildGatherResourceEntity("PRCT-OUI", "NOKIA", "darh.vader", "10.34.51.253",
                "death.star", "198.158.4.5", "24", "P+98", "CTA-781", "PI&*()", "L-PO01", "OIO89",
                "SHASTA", "AGCFPROTO", "AGCFNAME, ","105.3.3.3", "78", "5", "4", "84", 45,
                "90", "4", "5", "80", "TIPOA", 4,1,2, 3, "ALCA", "TRUE");

        when(this.gatherResourceInformationRepository.gatherResourceInformationByEquipment(portAdapterCard))
                .thenReturn(gatherResourceEntity);

        ResourceInventoryEntity resourceInventoryEntityResponse = this.gatherResourceInformationController.gatherResource(resourceInventoryEntityRequest);
        this.validateFusedNetwork(gatherResourceEntity, resourceInventoryEntityResponse);
        verify(this.gatherResourceInformationRepository, times(1)).gatherResourceInformationByEquipment(any());
        verify(this.gatherResourceInformationRepository, times(0)).gatherResourceInformationByCabinetAndSplitter(any(), any());
    }

    @Test(expected = OSSBusinessException.class)
    public void gatherResourceInformationNotFound() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("GatherResourceInformationByShelf.xml");
        GatherResourceInformation gatherResourceInformation = resourceInventoryEntityRequest.getGatherResourceInformation();
        Shelf shelf = gatherResourceInformation.getShelf();
        GatherResourceEntity gatherResourceEntity = this.buildErrorGatherResourceEntity("EQUIPAMENTO NÃO ENCONTRADO", 404);
        PortAdapterCard portAdapterCard = shelf.getHasCards().get(0);
        when(this.gatherResourceInformationRepository.gatherResourceInformationByEquipment(portAdapterCard))
                .thenReturn(gatherResourceEntity);

        ResourceInventoryEntity resourceInventoryEntityResponse = this.gatherResourceInformationController.gatherResource(resourceInventoryEntityRequest);
    }

    public GatherResourceEntity buildGatherResourceEntity(String nameHL, String vendor, String hostname, String nasip, String site, String ipAddress,
                                                          String mascaraIp, String gerencia, String switchAtendimento, String v5id, String switchAtendimento2,
                                                          String v5id2, String shasta, String protocoloAGCF, String nomeAGCF, String ipAddressAGCF, String numeroBras,
                                                          String slotBras, String subSlotBras, String portaBras, Integer stackVlan, String numeroAgregador, String slotAgregador,
                                                          String subSlotAgregador, String portaAgregador, String tipoCategoriaVlan, Integer vlanVOD, Integer vlanVOIP, Integer vlanMcast,
                                                          Integer vlanIpTV, String eno, String fusion) {
        GatherResourceEntity gatherResourceEntity = new GatherResourceEntity(null, null, null, nameHL, vendor, hostname, nasip, site, ipAddress, mascaraIp, gerencia, switchAtendimento, v5id,
                switchAtendimento2, v5id2, shasta, protocoloAGCF, nomeAGCF, ipAddressAGCF, numeroBras, slotBras, subSlotBras, portaBras, stackVlan, numeroAgregador, slotAgregador,
                subSlotAgregador, portaAgregador, tipoCategoriaVlan, vlanVOD, vlanVOIP, vlanMcast, vlanIpTV, eno, fusion, null, null);
        return gatherResourceEntity;
    }

    public GatherResourceEntity buildErrorGatherResourceEntity(String message, int code) {
        GatherResourceEntity gatherResourceEntity = new GatherResourceEntity();

        gatherResourceEntity.setMensagemRetorno(message);
        gatherResourceEntity.setCodigoRetorno(code);

        return gatherResourceEntity;
    }

    public void validateResponse(GatherResourceEntity gatherResourceEntity, ResourceInventoryEntity resourceInventoryEntity, long logicalSize, long resourceSize) {
        Shelf shelf = this.validateResponse(resourceInventoryEntity);
        this.validateResponseLogicalResources(gatherResourceEntity, shelf, logicalSize, "FALSE");
        this.validateResponseResourceCharacteristics(gatherResourceEntity, shelf, resourceSize);
    }
    public Shelf validateResponse(ResourceInventoryEntity resourceInventoryEntity) {
        Assert.assertNotNull(resourceInventoryEntity.getCabinet());
        Cabinet cabinet = resourceInventoryEntity.getCabinet();

        Assert.assertEquals(1, cabinet.getHasShelves().size());
        Shelf shelf = cabinet.getHasShelves().get(0);

        Assert.assertEquals(1, shelf.getHasCards().size());
        PortAdapterCard portAdapterCard = shelf.getHasCards().get(0);
        Assert.assertEquals(1, portAdapterCard.getContainsPorts().size());

        return shelf;
    }
    public List<ResourceCharacteristicSpecification> validateResponseResourceCharacteristics(GatherResourceEntity gatherResourceEntity, Shelf shelf, long resourceSize) {
        List<ResourceCharacteristicSpecification> resourceCharacteristicSpecifications = shelf.getResourceCharacteristicSpecifications();
        Assert.assertEquals(resourceSize, resourceCharacteristicSpecifications.size());
        return  resourceCharacteristicSpecifications;
    }
    public List<LogicalResource> validateResponseLogicalResources(GatherResourceEntity gatherResourceEntity, Shelf shelf, long logicalSize, String fusion) {
        PortAdapterCard portAdapterCard = shelf.getHasCards().get(0);
        PhysicalPort physicalPort = portAdapterCard.getContainsPorts().get(0);
        Assert.assertNotNull(physicalPort);

        LogicalResourceAssociation logicalResourceAssociation = physicalPort.getLogicalResourceAssociation();
        Assert.assertNotNull(logicalResourceAssociation);
        Assert.assertEquals(logicalSize, logicalResourceAssociation.getLogicalResource().size());
        List<LogicalResource> logicalResources = logicalResourceAssociation.getLogicalResource();
        boolean hasHostname = false;

        for (LogicalResource logicalResource: logicalResources) {
            String value = logicalResource.getValue();
            String name = logicalResource.getName();

            if (name.equals("HOSTNAME")) {
                Assert.assertEquals(gatherResourceEntity.getHostName(), value);
                hasHostname = true;
            } else if (name.equals("VENDOR_HL")) {
                Assert.assertEquals(gatherResourceEntity.getVendorHL(), value);
            } else if (name.equals("NAME__HL")) {
                Assert.assertEquals(gatherResourceEntity.getNameHL(), value);
            } else if (name.equals("FUSION")) {
                Assert.assertEquals(fusion, value);
            }
        }
        Assert.assertTrue(hasHostname);
        return logicalResources;
    }
    public void validateFusedNetwork(GatherResourceEntity gatherResourceEntity, ResourceInventoryEntity resourceInventoryEntity) {
        Shelf shelf = this.validateResponse(resourceInventoryEntity);
        List<LogicalResource> logicalResources = this.validateResponseLogicalResources(gatherResourceEntity, shelf, 20, "TRUE");
        this.validateResponseResourceCharacteristics(gatherResourceEntity, shelf, 12);

        Assert.assertTrue(logicalResources.stream().anyMatch(logicalResource -> {
            String name = logicalResource.getName();
            return name.equals("NASIP");
        }));
        Assert.assertTrue(logicalResources.stream().anyMatch(logicalResource -> {
            String name = logicalResource.getName();
            return name.equals("FUSION_NETWORK");
        }));
    }
}