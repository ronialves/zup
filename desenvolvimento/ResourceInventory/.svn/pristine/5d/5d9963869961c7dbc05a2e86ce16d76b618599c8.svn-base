package com.tlf.oss.resourceinventory.osp.core;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPCode;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.validation.FacilityRetrieval;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@Named
@RequestScoped
public class FacilityResourceController extends ValidatorEntity {

	@Inject
	private FacilityResourceMetallicController facilityResourceMetallicController;

	@Inject
	private FacilityResourceGponController facilityResourceGponController;

	@Inject
	protected OSSLogger logger;

	public ResourceInventoryEntity doExecution(@FacilityRetrieval ResourceInventoryEntity entity) throws OSSBusinessException {

		validateRequest(entity);

		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "FacilityResourceGponController - GPON");
			FacilityGPON(entity);
		} else {
			logger.log(OSSLogger.INFO, "FacilityResourceMetallicController - METALLIC");
			FacilityMetallic(entity);
		}
		return entity;
	}

	private void FacilityGPON(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			facilityResourceGponController.resourceFacility(entity);
		} catch (Exception ossBusinessException) {
			throw OssBusinessExceptionFactory.getOSSBusinessException(ossBusinessException, OSPWSName.ReportResourceProvisioning);
		}
	}

	private void FacilityMetallic(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			facilityResourceMetallicController.resourceFacility(entity);
		} catch (OSSBusinessException ossBusinessException) {
			if (!OSPCode.RESOURCE_FACILITY.getValue().equals(ossBusinessException.getDetail())) {
				throw ossBusinessException;
			}
		}
	}

	private void validateRequest(ResourceInventoryEntity entity) throws OSSBusinessException {

		Optional<BrazilianUrbanPropertyAddress> brazilianUrbanPropertyAddress = Optional.ofNullable(entity.getAddress());

		if (brazilianUrbanPropertyAddress.isPresent()) {
			if (!brazilianUrbanPropertyAddress.map(BrazilianUrbanPropertyAddress::getCnl).filter(d -> !d.isEmpty())
					.isPresent()) {
				throw new OSSBusinessException(Code.RIOSP_001.getDescription(), Code.RIOSP_001.getValue(),
						String.format(Code.RIOSP_001.getMessage(), "cnl"));
			}
			if (!brazilianUrbanPropertyAddress.map(BrazilianUrbanPropertyAddress::getTelephonicArea)
					.filter(d -> !d.isEmpty()).isPresent()) {
				throw new OSSBusinessException(Code.RIOSP_001.getDescription(), Code.RIOSP_001.getValue(),
						String.format(Code.RIOSP_001.getMessage(), "telephonicArea"));
			}
		} else {
			throw new OSSBusinessException(Code.RIOSP_001.getDescription(), Code.RIOSP_001.getValue(),
					String.format(Code.RIOSP_001.getMessage(), "brazilianUrbanPropertyAddress"));
		}
	}
}