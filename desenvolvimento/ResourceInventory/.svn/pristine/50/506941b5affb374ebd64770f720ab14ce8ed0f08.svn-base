package com.tlf.oss.resourceinventory.orchestration.rules.resourcelifecyclemanagement;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.orchestration.core.entity.Action;
import com.tlf.oss.resourceinventory.orchestration.core.interceptor.Constants;
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

    @Spy OSSLogger ossLogger;
    @InjectMocks ExecutionRules executionRules;

    @Test
    public void gatherResourceVivo2ByCabinetAndSplitter() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("GatherResourceInformationByCabinetAndSplitter.xml");
        Action action = this.executionRules.getAction("1.0", "gatherandanalyseresourceinformation", resourceInventoryEntityRequest);
        Assert.assertEquals("1.0_GATHER_RESOURCE_INFORMATION", action.getName());
    }
    @Test(expected = OSSBusinessException.class)
    public void gatherResourceVivo1ByCabinetAndSplitter() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("GatherResourceInformationByCabinetAndSplitterVivo1.xml");
        Action action = this.executionRules.getAction("1.0", "gatherandanalyseresourceinformation", resourceInventoryEntityRequest);
    }
    @Test
    public void gatherResourceVivo2ByShelf() throws OSSBusinessException {
        ResourceInventoryEntity resourceInventoryEntityRequest = environment.parseResourceInventoryEntityFromXML("GatherResourceInformationByShelf.xml");
        Action action = this.executionRules.getAction("1.0", "gatherandanalyseresourceinformation", resourceInventoryEntityRequest);
        Assert.assertEquals("1.0_GATHER_RESOURCE_INFORMATION", action.getName());
    }
}
