package com.tlf.oss.resourceinventory.tbs.core;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

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
import com.tlf.oss.resourceinventory.schemas.Equipment;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.core.utils.Constants;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.CabinetRetrievalRepository;

@RunWith(MockitoJUnitRunner.class)
public class CabinetRetrievalControllerTest {
	
	@InjectMocks
	private CabinetRetrievalController cabinetRetrievalController;
	
	@Mock
	private CabinetRetrievalRepository cabinetRetrievalRepository;
	
	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity request;
	
	private ResourceInventoryEntity response;
	
	private List<PortAdapterCard> hasCard;
	
	@Test
	public void getCabinetByLocationTest() throws OSSBusinessException{
			
		when(cabinetRetrievalRepository.getCabinetByLocation(anyObject())).thenReturn(response);
		ResourceInventoryEntity response = cabinetRetrievalController.retrieval(request);
		
		verify(cabinetRetrievalRepository).getCabinetByLocation(anyObject());
		assertNotNull(response);
		
	}
	
	@Test
	public void getEquipmentTreeTest() throws OSSBusinessException {
		
		ResourceInventoryEntity entity = addEquipments(request);
		
		when(cabinetRetrievalRepository.getEquipmentTrunk(anyObject())).thenReturn(response);
		when(cabinetRetrievalRepository.getEquipmentTree(anyObject())).thenReturn(hasCard);
		ResourceInventoryEntity response = cabinetRetrievalController.retrieval(entity);
		verify(cabinetRetrievalRepository).getEquipmentTrunk(anyObject());
		verify(cabinetRetrievalRepository).getEquipmentTree(anyObject());
		assertNotNull(response);
		
	}
	
	@Test
	public void retrievalTestOSSBusinessException() throws OSSBusinessException{
		
		OSSBusinessException exception =  new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
				ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
						"Erro ao chamar a procedure TLF_SP_SIGITM_GET_LOCATION no TBS", ""));
		
		try {	
			when(cabinetRetrievalRepository.getCabinetByLocation(anyObject())).thenThrow(exception);
			cabinetRetrievalController.retrieval(request);
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
		equipment.setOrigin(Constants.TBS);

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
		serviceSpecCharDescribesList.add(getEquipmentDetail(Constants.ORIGIN, Constants.TBS));
				
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
	
}
