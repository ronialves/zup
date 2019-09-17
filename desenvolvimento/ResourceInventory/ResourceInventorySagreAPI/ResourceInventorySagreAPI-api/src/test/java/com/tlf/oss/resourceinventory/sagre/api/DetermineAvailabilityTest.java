package com.tlf.oss.resourceinventory.sagre.api;

import java.util.Map;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.core.mapping.EntityConverterIn;
import com.tlf.oss.resourceinventory.sagre.api.dao.EntityManagerTest;
import com.tlf.oss.resourceinventory.sagre.api.v1_0.DetermineAvailabilityService;
import com.tlf.oss.resourceinventory.sagre.core.DetermineAvailabilityController;
import com.tlf.oss.resourceinventory.sagre.repository.DetermineAvailabilityRepository;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.DetermineResourceAvailabilityIn;

@RunWith(MockitoJUnitRunner.class)
public class DetermineAvailabilityTest extends BaseTest{
	
	
	@InjectMocks
	private DetermineAvailabilityService determineAvailabilityService;

	@Mock(answer = Answers.CALLS_REAL_METHODS)
	private DetermineAvailabilityController determineAvailabilityController;

	@Mock(answer = Answers.CALLS_REAL_METHODS)
	private DetermineAvailabilityRepository determineAvailabilityRepository;

	@Mock(answer = Answers.CALLS_REAL_METHODS)
	private OSSLogger logger;
	
	@Mock(answer = Answers.CALLS_REAL_METHODS)
	private OSSLogger controllerLogger;
	
	private EntityManagerTest database;
	private DetermineResourceAvailabilityIn input;
	private Map<String, Object> output;

	@Before
	public void before() throws Exception {
		input = new DetermineResourceAvailabilityIn();
		output = loaderMapOutput("determineAvailability/DetermineAvailabilityResponse.xml");
		
		Field fieldWrapper = DetermineAvailabilityController.class.getDeclaredField("determineAvailabilityRepository");
		fieldWrapper.setAccessible(true);
		fieldWrapper.set(determineAvailabilityController, determineAvailabilityRepository);
		
		Field fieldControllerLogger = DetermineAvailabilityController.class.getDeclaredField("logger");
		fieldControllerLogger.setAccessible(true);
		fieldControllerLogger.set(determineAvailabilityController, controllerLogger);
		
		database = new EntityManagerTest();
		Field fieldEntityManager = DetermineAvailabilityRepository.class.getSuperclass().getDeclaredField("factory");
		fieldEntityManager.setAccessible(true);
		fieldEntityManager.set(determineAvailabilityRepository, database);
		
		Field fieldLogger = DetermineAvailabilityRepository.class.getDeclaredField("logger");
		fieldLogger.setAccessible(true);
		fieldLogger.set(determineAvailabilityRepository, logger);

	}
	
	@Test
	public void testConfigureModifyPortOSSBusinessException() throws OSSBusinessException {	
		input = loaderInput("determineAvailability/DetermineAvailabilityRequest.xml", DetermineResourceAvailabilityIn.class);
	
		Response retorno = determineAvailabilityService.doExecution(EntityConverterIn.toResourceInventoryEntity(input));
		assertEquals(Status.OK.getStatusCode(), retorno.getStatus());
		Map<String, Object> mapEnviado = database.getMap();
		assertEquals(output.keySet(), mapEnviado.keySet());
		
	}
	
	@Test
	public void testBlockageEquipment() throws OSSBusinessException {
		final String CODE = "RI-0101";
		final String MESSAGE = "Equipamento Bloqueado";
		
		input = loaderInput("determineAvailability/DetermineAvailabilityRequest.xml", DetermineResourceAvailabilityIn.class);
		
		Response retorno = determineAvailabilityService.doExecution(EntityConverterIn.toResourceInventoryEntity(input));
		ResourceInventoryEntity entity = (ResourceInventoryEntity) retorno.getEntity();
		assertEquals(CODE, entity.getResourceInventoryWarn().getCode());
		assertEquals(MESSAGE, entity.getResourceInventoryWarn().getMessage());
	}

}
