package com.tlf.oss.resourceinventory.osp.core;

import java.math.BigInteger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityResponse;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.resourceserviceinfotypes.ResourceService;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.supplementaryinformationmanageprovtypes.SupplementaryInformationIn;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.service.CancelReservedService;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class CancelReservedGponController extends ValidatorEntity{

	private static final String CANCELAMENTO = "2";

	@Inject
	protected OSSLogger logger;

	@Inject
	protected CancelReservedService cancelReservedService;
	
	public ResourceInventoryEntity cancelReserved(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {

			WsContext context = new WsContext();
			context.setRegionCode(entity.getAddress().getCnl());
			context.setCentralOffice(entity.getAddress().getTelephonicArea());

			ManageResourceProvisioningActivityResponse response = cancelReservedService.manageResourceProvisioningActivity(createRequest(entity), context);

			validateResult(response);
			
		} catch (Exception e) {
			throw OssBusinessExceptionFactory.getOSSBusinessException(e, OSPWSName.TrackManageResourceProvisioning);
		}
		return entity;
	}
	
	private ManageResourceProvisioningActivityRequest createRequest(ResourceInventoryEntity entity) throws OSSBusinessException{

		ManageResourceProvisioningActivityRequest mrpar = new ManageResourceProvisioningActivityRequest();

		SupplementaryInformationIn si = new SupplementaryInformationIn();
		ResourceService rs = new ResourceService();

		rs.setRegionCode(Integer.valueOf(entity.getAddress().getCnl()));
		rs.setSiteCode(entity.getAddress().getTelephonicArea());

		si.setResourceService(rs);
		mrpar.setCircuitId(entity.getResourceFacingService().getServiceId());
		mrpar.setSupplementaryInformation(si);
		mrpar.setOperation(new BigInteger(CANCELAMENTO));

		return mrpar;
	}

	private void validateResult(ManageResourceProvisioningActivityResponse response) throws OSSBusinessException {
        if (response.getResult() != null && response.getResult().getCode() != 0) {
        	throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(String.valueOf(response.getResult().getErrorCode()), response.getResult().getDescription(), OSPWSName.TrackManageResourceProvisioning);
        }
    }
	
}
