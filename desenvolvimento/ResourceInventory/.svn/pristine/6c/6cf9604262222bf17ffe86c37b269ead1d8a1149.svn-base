package com.tlf.oss.resourceinventory.orchestration.core.scheduler;

import java.util.UUID;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.jms.MessageSender;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.orchestration.core.OrchestrationController;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.ExpiredResource;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.RetrieveExpiredResources;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Singleton(name="com.tlf.oss.resourceinventory.orchestration.core.scheduler.ReleaseResourceSchedule")
public class ReleaseResourceSchedule {

	@Inject
	private OSSLogger logger;
	
	@Inject
	private Header header;
	
	@Inject
	private OrchestrationController orchestration;
	
	@Resource(lookup = "cf.ConnectionFactoryReleaseResourceQueue")
	private ConnectionFactory factory;

	@Resource(lookup = "jms.ReleaseResourceQueue")
	private Queue queueIn;

	@Schedule(hour="*")
	public void onTimeout() {
		logger.setServiceName("ReleaseResourceScheduler_onTimeout");
		logger.setBase("[Schedule] - [" + getClass().getSuperclass().getName() + " - onTimeout]");		
		header.setClientId("Scheduler");
		header.setMessageId(UUID.randomUUID().toString());
		logger.log(OSSLogger.INFO, "START");
		
		try {
			execute();
		} catch (Exception e) {
			logger.error("ERROR", e);
		} finally {
			logger.log(OSSLogger.INFO, "END");
		}
	}
	
	
	private void execute() throws Exception {
		RetrieveExpiredResources retrieve = new RetrieveExpiredResources();
		retrieve.setAddress(new BrazilianUrbanPropertyAddress());
		retrieve.getAddress().setNetworkOwner("VIVO1");
		
		retrieve = orchestration.execute("1.0", "RETRIEVE", retrieve);
		
		if (retrieve == null || retrieve.getExpiredResourceList() == null) {
			return;
		}
		
		for (ExpiredResource expiredResource : retrieve.getExpiredResourceList()) {
			ResourceInventoryEntity entity = createResourceInventoryEntity(expiredResource);
			
			MessageSender.Builder
				.newBuilder(logger, header)
				.factory(factory)
				.destination(queueIn)
				.message(XMLUtil.getXMLValue(entity))
				.build()
				.send();					
		}					
	}

	
	private ResourceInventoryEntity createResourceInventoryEntity(ExpiredResource expiredResource) {
		ResourceInventoryEntity entity = new ResourceInventoryEntity();
		entity.setAddress(new BrazilianUrbanPropertyAddress());
		entity.getAddress().setCnl(expiredResource.getCnl());
		entity.getAddress().setTelephonicArea(expiredResource.getTelephonicArea());
		entity.setResourceFacingService(new ResourceFacingService());
		entity.getResourceFacingService().setServiceId(expiredResource.getServiceId());
		entity.getAddress().setPlacePhysicalResourceAssoc(new PlacePhysicalResourceAssoc());
		entity.getAddress().getPlacePhysicalResourceAssoc().setPhysicalLink(new PhysicalLink());
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology(expiredResource.getTechnology());
		entity.getAddress().setNetworkOwner("VIVO1");
		return entity;
	}
	
}
