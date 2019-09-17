package com.tlf.oss.resourceinventory.orchestration.rules.resourceordermanagement;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.orchestration.core.entity.Action;
import com.tlf.oss.resourceinventory.orchestration.core.rules.ExecutionRules;
import com.tlf.oss.resourceinventory.orchestration.core.util.Environment;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RetrieveTest {

    private final Environment environment = new Environment();
    private final String NO_ACTION_MESSAGE_ERROR = "[RIO-006] :: Requisição não identificada -> Não foi encontrado nenhuma action a ser executada";

    @Spy OSSLogger ossLogger;
    @InjectMocks ExecutionRules executionRules;

    @Test
    public void retrieveNetworkResource() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveNetworkResource.xml");
        Action action = this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        Assert.assertEquals("1.0_RETRIEVE_RESOURCE_INFORMATION_VIVO2", action.getName());
    }

    @Test
    public void retrieveNetworkResourceWithResourceOrderItemId() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveNetworkResourceWithResourceOrdemItemID.xml");
        Action action = this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        Assert.assertEquals("1.0_RETRIEVE_RESOURCE_INFORMATION_VIVO2", action.getName());
    }

    @Test
    public void retrieveRangerCorporateNumber() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveRangeCorporateNumber.xml");
        Action action = this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        Assert.assertEquals("1.0_RETRIEVE_RANGER_CORPORATE_NUMBER_VIVO2", action.getName());
    }

    @Test
    public void retrieveNetworkResourceWithCustomerOrder() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveNetworkResourceWithCustomerOrder.xml");
        Action action = this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        Assert.assertEquals("1.0_RETRIEVE_RESOURCE_INFORMATION_VIVO2", action.getName());
    }


    @Test
    public void retrieveStaticIp() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveStaticIp.xml");
        Action action = this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        Assert.assertEquals("1.0_STATIC_IP_RETRIEVE_VIVO2", action.getName());
    }

    @Test(expected = OSSBusinessException.class)
    public void retrieveNoResourceOrder() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveNoResourceOrder.xml");
        try {
            this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        } catch (OSSBusinessException ex) {
            Assert.assertEquals(this.NO_ACTION_MESSAGE_ERROR, ex.getMessage());
            throw ex;
        }
    }

    @Test(expected = OSSBusinessException.class)
    public void retrieveEmptyResourceOrder() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveEmptyResourceOrder.xml");
        try {
            this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        } catch (OSSBusinessException ex) {
            Assert.assertEquals(this.NO_ACTION_MESSAGE_ERROR, ex.getMessage());
            throw ex;
        }
    }

    @Test(expected = OSSBusinessException.class)
    public void retrieveEmptyResourceOrderItem() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveEmptyResourceOrderItem.xml");
        try {
            this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        } catch (OSSBusinessException ex) {
            Assert.assertEquals(this.NO_ACTION_MESSAGE_ERROR, ex.getMessage());
            throw ex;
        }
    }

    @Test(expected = OSSBusinessException.class)
    public void retrieveNoResourceFacingService() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveNoResourceFacingService.xml");
        try {
            this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        } catch (OSSBusinessException ex) {
            Assert.assertEquals(this.NO_ACTION_MESSAGE_ERROR, ex.getMessage());
            throw ex;
        }
    }

    @Test(expected = OSSBusinessException.class)
    public void retrieveNoServiceID() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveNoServiceID.xml");
        try {
            this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        } catch (OSSBusinessException ex) {
            Assert.assertEquals(this.NO_ACTION_MESSAGE_ERROR, ex.getMessage());
            throw ex;
        }
    }
    @Test(expected = OSSBusinessException.class)
    public void retrieveEmptyServiceID() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("RetrieveEmptyServiceID.xml");
        try {
            this.executionRules.getAction("1.0", "retrieve", resourceInventoryEntityRequest);
        } catch (OSSBusinessException ex) {
            Assert.assertEquals(this.NO_ACTION_MESSAGE_ERROR, ex.getMessage());
            throw ex;
        }
    }
}
