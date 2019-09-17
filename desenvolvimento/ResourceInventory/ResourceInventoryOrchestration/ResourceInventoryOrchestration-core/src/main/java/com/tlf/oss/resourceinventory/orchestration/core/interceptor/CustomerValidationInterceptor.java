package com.tlf.oss.resourceinventory.orchestration.core.interceptor;

import java.util.Date;
import java.util.Optional;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Response;

import com.tlf.oss.common.client.RestClient;
import com.tlf.oss.common.client.RestClient.Method;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.properties.Configuration;
import com.tlf.oss.common.properties.WeblogicConfiguration;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.CustomerAuditEntity;
import com.tlf.oss.resourceinventory.schemas.api.CustomerEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Interceptor
@CustomerValidation
@Priority(Interceptor.Priority.APPLICATION)
public class CustomerValidationInterceptor {

	private static final Configuration CFG = Configuration.getInstance(Constants.SERVER_PROPERTY, Constants.LOCAL_FILE);
	private static final WeblogicConfiguration WCFG = WeblogicConfiguration.getInstance();
	private static final String URL_RETRIEVE = CFG.get(Constants.URL_REPOSITORY_CUSTOMER_RETRIEVE);
	private static final String URL_SAVE = CFG.get(Constants.URL_REPOSITORY_CUSTOMER_SAVE);
	private static final String URL_DELETE = CFG.get(Constants.URL_REPOSITORY_CUSTOMER_DELETE);
	private static final String URL_UPDATE = CFG.get(Constants.URL_REPOSITORY_CUSTOMER_UPDATE);
	
	@Inject
	private OSSLogger logger;
	
	@Inject
	private Header header;
	
	private CustomerEntity getCustomer(String access) throws OSSBusinessException {
		Response response = RestClient.Builder
				.newBuilder(logger, header)
				.target(String.format(URL_RETRIEVE, WCFG.getCurrentNodeName(), WCFG.getCurrentPort()))
				.pathParam("version", "1.0")
				.pathParam("entity", "customer")
				.pathParam("id", access)
				.method(Method.Get)
				.validateNotFound(false)
				.serviceName("ri_customer_validation")
				.build()
				.callService(Response.class);
		
		if (response.getStatus() == 404) {
			return null;
		}
		
		return response.readEntity(CustomerEntity.class);
	}
	
	private void createCustomer(ResourceInventoryEntity riEntity, String orchestrationId, String action) throws OSSBusinessException {
		CustomerEntity customer = loadCustomer(riEntity);
		
		customer.setStatus("NEW");
		
		RestClient.Builder
			.newBuilder(logger, header)
			.target(String.format(URL_SAVE, WCFG.getCurrentNodeName(), WCFG.getCurrentPort()))
			.pathParam("version", "1.0")
			.pathParam("entity", "customer")
			.method(Method.Post)
			.entity(customer)
			.serviceName("ri_customer_validation")
			.build()
			.callService();
		
		saveCustomerAudit(customer, orchestrationId, action);
	}
		
	private CustomerEntity loadCustomer(ResourceInventoryEntity riEntity) {
		CustomerEntity customer = new CustomerEntity();			
		customer.setAccessDesignator(riEntity.getResourceFacingService().getServiceId());
		customer.setAccessId(getResourceFacingService(riEntity, "NetworkOwnerId"));
		customer.setCustomerId(getResourceFacingService(riEntity, "NRC"));
		customer.setNetworkOwner(riEntity.getAddress().getNetworkOwner());
		customer.setAccessTechnology(riEntity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		customer.setProvider(header.getClientId());
		customer.setCreateDate(new Date());		
		return customer;
	}
	
	private String getResourceFacingService(ResourceInventoryEntity entity, String value) {
		Optional<ServiceDescribedBy> serviceDescribedBy = entity.getResourceFacingService().getServiceDescribedBy()
				.stream()
				.filter(s -> value.equalsIgnoreCase(s.getName()))
				.findFirst();
		
		if (serviceDescribedBy.isPresent()) {
			Optional<String> serviceSpecCharDescribes = serviceDescribedBy.get().getServiceSpecCharDescribes()
					.stream()
					.filter(s -> !s.getValue().isEmpty())
					.map(ServiceSpecCharDescribes::getValue)
					.findFirst();
			
			if (serviceSpecCharDescribes.isPresent()) {
				return serviceSpecCharDescribes.get();
			}
		}

		return null;
	}
	
	private void saveCustomerAudit(CustomerEntity customer, String orchestrationId, String action) throws OSSBusinessException {
		CustomerAuditEntity customerAudit = new CustomerAuditEntity();
		customerAudit.setOrchestrationId(orchestrationId);
		customerAudit.setClientId(customer.getProvider());
		customerAudit.setMessageId(header.getMessageId());
		customerAudit.setAccessDesignator(customer.getAccessDesignator());
		customerAudit.setAction(action);		
		customerAudit.setCreateDate(customer.getCreateDate());	
		
		RestClient.Builder
			.newBuilder(logger, header)
			.target(String.format(URL_SAVE, WCFG.getCurrentNodeName(), WCFG.getCurrentPort()))
			.pathParam("version", "1.0")
			.pathParam("entity", "customerAudit")
			.method(Method.Post)
			.entity(customerAudit)
			.serviceName("ri_customer_validation")
			.build()
			.callService();
	}
	
	private void updateCustomer(ResourceInventoryEntity riEntity, String orchestrationId, String action) throws OSSBusinessException {
		CustomerEntity customer = loadCustomer(riEntity);
		
		customer.setStatus("ACTIVE");
		
		RestClient.Builder
			.newBuilder(logger, header)
			.target(String.format(URL_UPDATE, WCFG.getCurrentNodeName(), WCFG.getCurrentPort()))
			.pathParam("version", "1.0")
			.pathParam("entity", "customer")
			.method(Method.Put)
			.entity(customer)
			.serviceName("ri_customer_validation")
			.build()
			.callService();
		
		saveCustomerAudit(customer, orchestrationId, action);
	}
	
	private void deleteCustomer(ResourceInventoryEntity riEntity, String orchestrationId, String action) throws OSSBusinessException {
		CustomerEntity customer = loadCustomer(riEntity);
		
		String acesso = customer.getAccessDesignator();
		
		RestClient.Builder
			.newBuilder(logger, header)
			.target(String.format(URL_DELETE, WCFG.getCurrentNodeName(), WCFG.getCurrentPort()))
			.pathParam("version", "1.0")
			.pathParam("entity", "customer")
			.pathParam("id", acesso)
			.method(Method.Delete)
			.entity(customer)
			.serviceName("ri_customer_validation")
			.build()
			.callService();
		
		saveCustomerAudit(customer, orchestrationId, action);
	}
	
	
	private void validate(String action, Object entity, String orchestrationId) throws OSSBusinessException {
		ResourceInventoryEntity riEntity = ResourceInventoryEntity.class.cast(entity);
		
		CustomerEntity customer = getCustomer(riEntity.getResourceFacingService().getServiceId());
		
		if (Constants.RESERVE_RESOURCE.equals(action) && customer == null) {
			createCustomer(riEntity, orchestrationId, action);
		}
		
		if (Constants.INSTALL_RESOURCE.equals(action) && customer != null) {
			updateCustomer(riEntity, orchestrationId, action);
		} 
		
		if (Constants.UNINSTALL_RESOURCE.equals(action) && customer != null) {
			deleteCustomer(riEntity, orchestrationId, action);
		}
		
		if (Constants.RELEASE_RESOURCE.equals(action) && customer != null) {
			if ("NEW".equals(customer.getStatus())) {
				deleteCustomer(riEntity, orchestrationId, action);
			}
		}
		
		if (Constants.DEALLOCATE_RESOURCE.equals(action) && customer != null) {
			if ("NEW".equals(customer.getStatus())) {
				deleteCustomer(riEntity, orchestrationId, action);
			}
		}
		
	}
	
	private boolean checkCreateAudit(InvocationContext ctx) {
		
		String action = String.valueOf(ctx.getParameters()[1]);
		if (action.equalsIgnoreCase("RETRIEVE") || action.equalsIgnoreCase("DETERMINE")) {
			return false;
		}
		
		return true;
	}
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		boolean checkValidateCustomer = checkCreateAudit(ctx);
		
		if (!checkValidateCustomer) {
			return ctx.proceed();
		}
		
		Object obj = ctx.proceed();
		
		
		try {
			if (obj != null && Response.class.isInstance(obj)) {
				Response response = Response.class.cast(obj);
				
				if (response.getStatus() == 500 || response.getStatus() == 400) {
					return obj;
				}
			}
			
			String orchestrationID =  (String) ctx.getContextData().get("orchestrationID");
			String action = String.valueOf(ctx.getParameters()[1]);
			Object entity = ctx.getParameters()[2];
			validate(action, entity, orchestrationID);
		} catch (Exception e) {
			logger.error("Não foi possivel gerar auditoria", e);
		} finally {
		}
		
		return obj;
	}
	
}
