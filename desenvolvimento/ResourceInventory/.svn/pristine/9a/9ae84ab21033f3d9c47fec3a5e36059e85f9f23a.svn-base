package com.tlf.oss.resourceinventory.orchestration.core.interceptor;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Response;

import com.tlf.oss.common.client.RestClient;
import com.tlf.oss.common.client.RestClient.Method;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.json.JSONUtil;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.properties.Configuration;
import com.tlf.oss.common.properties.WeblogicConfiguration;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.schemas.api.OrchestrationAuditEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Interceptor
@Audit
@Priority(Interceptor.Priority.APPLICATION)
public class AuditInterceptor {

	private static final Configuration CFG = Configuration.getInstance(Constants.SERVER_PROPERTY, Constants.LOCAL_FILE);
	private static final WeblogicConfiguration WCFG = WeblogicConfiguration.getInstance();
	private static final String URL_AUDIT_SAVE = CFG.get(Constants.URL_REPOSITORY_ORCHESTRATION_AUDIT_SAVE);
	
	@Inject
	private OSSLogger logger;
	
	@Inject
	private Header header;
	
	private String[] extractExternalId(Object request) {
		String type = "UNKNOW";
		String externalId = "UNKNOW";

		if (ResourceInventoryEntity.class.isInstance(request)) {
			ResourceInventoryEntity entity = ResourceInventoryEntity.class.cast(request);
			
			if (entity.getCustomerOrder() != null) {
				type = "CustomerOrder";
				externalId = entity.getCustomerOrder().getPurchaseOrderNumber();
			}
		}
		
		return new String[] { type, externalId};
	}
	
	private boolean checkCreateAudit(InvocationContext ctx) {
	
		String action = String.valueOf(ctx.getParameters()[1]);
		if (action.equalsIgnoreCase("RETRIEVE") || action.equalsIgnoreCase("DETERMINE")) {
			return false;
		}
		
		return true;
	}
	
	private void createAudit(InvocationContext ctx, Object response, Throwable error, Date startDate) {
		try {
			Object request = ctx.getParameters()[2]; 
			String interfaceName = ctx.getTarget().getClass().getSuperclass().getName();
			String operation = ctx.getMethod().getName();
			String version = String.valueOf(ctx.getParameters()[0]);
			String action = String.valueOf(ctx.getParameters()[1]);
			String[] externalId = extractExternalId(request);
			
			if (response != null && Response.class.isInstance(response)) {
				Response rsResponse = Response.class.cast(response);
				
				if (rsResponse.getStatus() == 200) {
					if (!rsResponse.bufferEntity() && rsResponse.hasEntity()) {
						response = rsResponse.getEntity();
					} else {
						response = null;
					}
					
					error = null;
				} else if (rsResponse.getStatus() == 500 || rsResponse.getStatus() == 400) {
					error = (Throwable) rsResponse.getEntity();
					response = null;
				}
			}
			
			OrchestrationAuditEntity orc = new OrchestrationAuditEntity();		
	
			orc.setCorrelationId(String.class.cast(ctx.getContextData().get("orchestrationID")));
			
			orc.setType(externalId[0]);
			orc.setExternalId(externalId[1]);
			orc.setStartDate(startDate);
			orc.setEndDate(new Date());
			orc.setStatus(error != null ? "Error" : "Completed");
			orc.setStatusReason(error != null ? error.getMessage() : null);
			orc.setClientId(header.getClientId());
			orc.setMessageId(header.getMessageId());
			orc.setServiceName(logger.getCurrentServiceName());
			orc.setInterfaceName(interfaceName);
			orc.setOperation(operation);
			orc.setVersion(version);
			orc.setAction(action);
			orc.setRequest(JSONUtil.getValue(request));
			orc.setResponse(JSONUtil.getValue(response));	
			
			orc.setErrorClass(error != null ? error.getClass().getName() : null);
			orc.setError(XMLUtil.getXMLValue(error));

		
			RestClient.Builder
				.newBuilder(logger, header)
				.target(String.format(URL_AUDIT_SAVE, WCFG.getCurrentNodeName(), WCFG.getCurrentPort()))
				.pathParam("version", "1.0")
				.pathParam("entity", "orchestrationAudit")
				.method(Method.Post)
				.entity(orc)
				.serviceName("ri_orchestration_audit")
				.build()
				.callService();
			
			ctx.getContextData().put("orchestrationID", 0L);
		} catch (Exception e) {
			logger.error("ERROR", e);
		}
	}
	
	
	
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		Throwable error = null;
		Object response = null;
		Date startDate = new Date();
		boolean checkValidateAudit = checkCreateAudit(ctx);
		
		try {
			if (checkValidateAudit) {
				ctx.getContextData().put("orchestrationID", UUID.randomUUID().toString());
			}
			
			response = ctx.proceed();
			return response;
		} catch (Exception e) {
			Throwable currentError = e;
			
			while (currentError.getCause() != null) {
				currentError = currentError.getCause();
			}
			
			error = currentError;
			
			throw e;
		} finally {
			if (checkValidateAudit) {
				createAudit(ctx, response, error, startDate);
			}
		}
	}
}
