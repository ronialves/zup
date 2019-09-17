package com.tlf.oss.resourceinventory.osp.core;

import java.math.BigInteger;
import java.util.concurrent.TimeoutException;

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
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.Operation;
import com.tlf.oss.resourceinventory.osp.core.service.CancelReservedService;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class CancelReservedMetallicController extends ValidatorEntity {

	@Inject
	protected OSSLogger logger;

	@Inject
	protected CancelReservedService cancelReservedService;

	private ManageResourceProvisioningActivityRequest createRequest(ResourceInventoryEntity entity)
			throws OSSBusinessException {

		ManageResourceProvisioningActivityRequest mrpar = new ManageResourceProvisioningActivityRequest();

		SupplementaryInformationIn si = new SupplementaryInformationIn();
		ResourceService rs = new ResourceService();

		rs.setRegionCode(Integer.valueOf(entity.getAddress().getCnl()));
		rs.setSiteCode(entity.getAddress().getTelephonicArea());
		mrpar.setReserveOrder(getNRC(entity));

		si.setResourceService(rs);
		mrpar.setSupplementaryInformation(si);
		mrpar.setOperation(new BigInteger(Operation.CANCELAMENTO.getValue()));

		return mrpar;
	}

	private String getNRC(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsNrc = getResourceFacingService(entity, "NRC");
		return rfsNrc.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}

	public ResourceInventoryEntity cancelReserved(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {

			WsContext context = new WsContext();
			context.setRegionCode(entity.getAddress().getCnl());
			context.setCentralOffice(entity.getAddress().getTelephonicArea());

			ManageResourceProvisioningActivityResponse response = null;

			response = cancelReservedService.manageResourceProvisioningActivity(createRequest(entity), context);
			validateResponse(response);

			return entity;

		} catch (OSSBusinessException e) {
			throw new OSSBusinessException(e.getDescription(), e.getStatusCode(), e.getDetail());
		} catch (Exception e) {

			if (e instanceof TimeoutException) {
				throw new OSSBusinessException("Erro ao cancelar reserva", Code.RIOSP_002.getValue(),
						Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue());
			}
			throw new OSSBusinessException("Erro ao cancelar reserva", Code.RIOSP_002.getValue(), e.getMessage());
		}
	}

	private void validateResponse(ManageResourceProvisioningActivityResponse response) throws OSSBusinessException {
		if (response.getResult() != null && response.getResult().getCode() != 0) {
			throw new OSSBusinessException(String.valueOf(response.getResult().getDescription()),
					String.valueOf(response.getResult().getCode()),
					String.valueOf(response.getResult().getErrorCode()));
		}
	}
}