package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAcessInformationDslamDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAcessInformationMsanDao;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class AccessRetrieveControllerTest {

	@InjectMocks
	AccessRetrieveController accessRetrieveController;

	@Mock
	private OSSLogger logger;

	@Mock
	public RetrieveAcessInformationDslamDao rdaoDslam;

	@Mock
	public RetrieveAcessInformationMsanDao rdaoMsan;

	private ResourceInventoryEntity getAccessResourceInformationIn = new ResourceInventoryEntity();
	BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();

	@Test
	public void testGetAcessInformationResourceDslam() {
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		getAccessResourceInformationIn.setAddress(address);
		
		List <RetrieveAccessResourceInformationDslamEntity> dslams = new ArrayList<>();		
		RetrieveAccessResourceInformationDslamEntity retrieveAccessResourceInformationDslamEntity = new RetrieveAccessResourceInformationDslamEntity();
		retrieveAccessResourceInformationDslamEntity.setTypeOfResource("DSLAM");
		dslams.add(retrieveAccessResourceInformationDslamEntity);
	
		when(rdaoDslam.getAcessInformationResourceDSLAM(getAccessResourceInformationIn)).thenReturn(dslams);
		
		List <RetrieveAccessResourceInformationDslamEntity> resultList = accessRetrieveController.getAcessInformationResourceDslam(getAccessResourceInformationIn);
		
		assertNotNull(resultList);
		assertTrue("DSLAM".equalsIgnoreCase(resultList.get(0).getTypeOfResource()));
	}

	@Test
	public void testGetAcessInformationResourceMsan() {
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		getAccessResourceInformationIn.setAddress(address);
		
		List <RetrieveAccessResourceInformationMsanEntity> msan = new ArrayList<>();
		RetrieveAccessResourceInformationMsanEntity retrieveAccessResourceInformationMsanEntity = new RetrieveAccessResourceInformationMsanEntity();
		retrieveAccessResourceInformationMsanEntity.setTypeOfResource("MSAN");
		msan.add(retrieveAccessResourceInformationMsanEntity);

		when(rdaoMsan.getAcessInformationResourceMSAN(getAccessResourceInformationIn)).thenReturn(msan);

		List <RetrieveAccessResourceInformationMsanEntity> resultList = accessRetrieveController.getAcessInformationResourceMsan(getAccessResourceInformationIn);

		assertNotNull(resultList);
	
		assertTrue("MSAN".equalsIgnoreCase(resultList.get(0).getTypeOfResource()));
	}

}
