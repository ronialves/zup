package com.tlf.oss.resourceinventory.nwi.core;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.nwi.core.utils.Constants;
import com.tlf.oss.resourceinventory.nwi.repository.EquipmentRetrievalRepository;
import com.tlf.oss.resourceinventory.schemas.Equipment;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class EquipmentRetrievalControllerTest {
	
	@InjectMocks
	private EquipmentRetrievalController equipmentRetrievalController;
	
	@Mock
	private EquipmentRetrievalRepository equipmentRetrievalRepository;
	
	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity request;
	
	private ResourceInventoryEntity response;	
	
	@Test
	public void getEquipmentTestSimple() throws OSSBusinessException {			
		when(equipmentRetrievalRepository.getEquipment(anyObject(), anyObject())).thenReturn(response);
		ResourceInventoryEntity response = equipmentRetrievalController.retrieval(request);		
		verify(equipmentRetrievalRepository).getEquipment(anyObject(), anyObject());
		assertNotNull(response);		
	}
	
	@Test
	public void getEquipmentFilledTest() throws OSSBusinessException {
		
		ResourceInventoryEntity entity = addEquipments(request);
		
		when(equipmentRetrievalRepository.getEquipment(anyObject(), eq(Constants.EQUIPMENT))).thenReturn(response);
		ResourceInventoryEntity response = equipmentRetrievalController.retrieval(entity);
		verify(equipmentRetrievalRepository).getEquipment(anyObject(), eq(Constants.EQUIPMENT));
		assertNotNull(response);
		
	}
	
	@Test
	public void getEquipmentNoFilledTest() throws OSSBusinessException {		
		ResourceInventoryEntity entity = createResourceInventoryEntity(request);		
		when(equipmentRetrievalRepository.getEquipment(anyObject(), eq(Constants.CABINET))).thenReturn(response);
		ResourceInventoryEntity response = equipmentRetrievalController.retrieval(entity);
		verify(equipmentRetrievalRepository).getEquipment(anyObject(), eq(Constants.CABINET));
		assertNotNull(response);		
	}
	
	

	@Test
	public void retrievalTestOSSBusinessException() throws OSSBusinessException {		
		OSSBusinessException exception = new OSSBusinessException();		
		try {	
			when(equipmentRetrievalRepository.getEquipment(anyObject(), anyObject())).thenThrow(exception);
			equipmentRetrievalController.retrieval(request);
		} catch (OSSBusinessException e) {
			assertNotNull(e);
		}

	}
	
	@Before
	public void before(){
		
		request = new ResourceInventoryEntity();
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		
		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<ServiceDescribedBy>();
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName(Constants.NETWORK_OWNER_VIVO2);
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<ServiceSpecCharDescribes>();

		ServiceSpecCharDescribes stateOrProvince = new ServiceSpecCharDescribes();
		stateOrProvince.setValue("PR");
		stateOrProvince.setValueType("stateOrProvince");
		
		ServiceSpecCharDescribes city = new ServiceSpecCharDescribes();
		city.setValue("CURITIBA");
		city.setValueType("city");
		
		serviceSpecCharDescribesList.add(stateOrProvince);
		serviceSpecCharDescribesList.add(city);
				
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		
		serviceDescribedByList.add(serviceDescribedBy);
		
		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);
		
		request.setResourceFacingService(resourceFacingService);
		
		
		response = new ResourceInventoryEntity();
		
		List<Equipment> equipments = new ArrayList<Equipment>();
		
		Equipment equipment = new Equipment();
		equipment.setId("123456");
		equipment.setOrigin(Constants.NWI);

		equipments.add(equipment);
		
		response.setEquipment(equipments);		
		
		
	}
	
	public ResourceInventoryEntity addEquipments(ResourceInventoryEntity entity){
		
		ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();
		
		resourceInventoryEntity.setResourceFacingService(entity.getResourceFacingService());
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName(Constants.EQUIPMENT);
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<ServiceSpecCharDescribes>();
		
		serviceSpecCharDescribesList.add(getEquipmentDetail(Constants.HOSTNAME, "PRCTA_01"));		
		serviceSpecCharDescribesList.add(getEquipmentDetail(Constants.ORIGIN, Constants.NWI));
				
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		
		resourceInventoryEntity.getResourceFacingService().getServiceDescribedBy().add(serviceDescribedBy);
		
		return resourceInventoryEntity;
		
	}
	
	private static ServiceSpecCharDescribes getEquipmentDetail(String type, String value) {
		ServiceSpecCharDescribes equipmentDetail = new ServiceSpecCharDescribes();
		equipmentDetail.setValueType(type);
		equipmentDetail.setValue(value);
		return equipmentDetail;
	}
	
	private ResourceInventoryEntity createResourceInventoryEntity(ResourceInventoryEntity entity) {
		ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();
		
		resourceInventoryEntity.setResourceFacingService(entity.getResourceFacingService());
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName(Constants.CABINET);
				
		resourceInventoryEntity.getResourceFacingService().getServiceDescribedBy().add(serviceDescribedBy);
		
		return resourceInventoryEntity;
	}
	
}
