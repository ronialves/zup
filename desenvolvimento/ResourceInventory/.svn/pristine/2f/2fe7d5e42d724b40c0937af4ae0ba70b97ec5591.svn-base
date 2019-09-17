package com.tlf.oss.resourceinventory.osp.core.service;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.ReportResourceProvisioning_Service;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;
import com.tlf.oss.resourceinventory.osp.core.enums.CircuitTypeEnum;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.utils.HeaderHandlerResolver;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
public class FacilityResourceService {

	@Inject
	private OSSLogger logger;
	
	
	public ReportResourceProvisioningResponse distributeResourceProvisioningReports(
			ReportResourceProvisioningRequest request, WsContext wsContext) throws FacilitiesException {
		
		logger.log(OSSLogger.INFO, "Started call web service (distributeResourceProvisioningReports)");
		
		ReportResourceProvisioning_Service service = new ReportResourceProvisioning_Service();
		
		service.setHandlerResolver(new HeaderHandlerResolver());
		
		logger.log(OSSLogger.INFO, "Called service (distributeResourceProvisioningReports) - request " + XMLUtil.getXMLValue(request));
		
		ReportResourceProvisioningResponse response = service.getReportResourceProvisioningPort().distributeResourceProvisioningReports(request, wsContext);
		
		logger.log(OSSLogger.INFO, "Called service (distributeResourceProvisioningReports) - response " + XMLUtil.getXMLValue(response));
		
		logger.log(OSSLogger.INFO, "Finished call web service (distributeResourceProvisioningReports)");
		
		return response;
	}

	public WsContext createHeaderFromCnlAt(ResourceInventoryEntity entity) {

		WsContext context = new WsContext();
		String cnl = entity.getAddress().getCnl();
		String at = entity.getAddress().getTelephonicArea();

		logger.log(OSSLogger.INFO, "Populando contexto com o  CNL: " + cnl + " e AT: " + at);

		context.setRegionCode(cnl);
		context.setCentralOffice(at);

		return context;
	}

	public ReportResourceProvisioningRequest createRequest(ResourceInventoryEntity entity, CircuitTypeEnum circuit) throws OSSBusinessException {
		ReportResourceProvisioningRequest request = new ReportResourceProvisioningRequest();

		if (null != entity.getResourceFacingService()) {
			request.setCircuitId(entity.getResourceFacingService().getServiceId());
			request.setCircuitType(CircuitTypeEnum.parse(circuit.getValue()));
		} else {
			throw new OSSBusinessException("Erro ao preencher o objeto ReportResourceProvisioningRequest", Code.RIOSP_001.getValue(), "O campo entity.resourceFacingService está nulo");
		}

		return request;
	}

	public ReportResourceProvisioningResponse gponDistributeResourceProvisioningReports(ResourceInventoryEntity entity) {
		WsContext context = createHeaderFromCnlAt(entity);
		ReportResourceProvisioningRequest request;


		try {
			request = createRequest(entity, CircuitTypeEnum.GPON);

			return distributeResourceProvisioningReports(request, context);
		} catch (OSSBusinessException obee) {
			logger.log(OSSLogger.ERROR, "Error: " + obee.getDescription());
		} catch (FacilitiesException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
		}

		return null;
	}
}