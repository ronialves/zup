package com.tlf.oss.resourceinventory.sagre.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.sagre.core.validation.Allocate;
import com.tlf.oss.resourceinventory.sagre.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.sagre.entity.AllocateExternalResourceEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.repository.AllocateRepository;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * BEATRIXTWO-25 | DEMOSS-2164
 * 
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201709
 */
public class AllocateController extends ValidatorEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	AllocateRepository allocateRepository;
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RISAGRE_003.getCode(),
			String.format(ExceptionInfoEnum.RISAGRE_003.getDescription(), "GVT_SP_SOA_DS_CTRL"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	private static final int RESULTADO_ESPERADO = 0;

	public static final String RPON = "RPON";
	public static final String P_IN_ORIGEM = "RI";
	public static final String P_IN_TIPO_DOCUMENTO = "DEFAULT";
	public static final String P_IN_CLASSE_SERVICO = "DEFAULT";
	public static final String P_IN_TIPO_ORDEM = "DEFAULT";

	/**
	 * Retorna atraves do AllocateExternalResourceEntity (preenchido com ResourceInventoryEntity), o ResourceInventoryEntity enriquecido
	 * 
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity allocate(@Allocate ResourceInventoryEntity entity) throws OSSBusinessException {

		AllocateExternalResourceEntity allocateExternal = new AllocateExternalResourceEntity();
		allocateExternal.setCnl(Integer.valueOf(entity.getAddress().getCnl()));
		allocateExternal.setTargetAccessTechnology(
				entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		allocateExternal.setTargetVoiceTechnology(
				entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		allocateExternal.setTargetAccessId(entity.getResourceFacingService().getServiceId());
		allocateExternal.setIdentEquip1(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getName());
		allocateExternal.setIdentEquip2(
				entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getTerminalBox().getName());
		allocateExternal.setStreetCode(entity.getAddress().getStreetCode());
		allocateExternal.setLote(entity.getAddress().getStreetNrFirst());
		allocateExternal.setPon(entity.getCustomerOrder().getPurchaseOrderNumber());

		if (entity.getCustomerFacingService() != null && !entity.getCustomerFacingService().isEmpty()) {
			for (CustomerFacingService customer : entity.getCustomerFacingService()) {
				if (customer.getServiceDescribedBy() != null && !customer.getServiceDescribedBy().isEmpty()) {
					for (ServiceDescribedBy service : customer.getServiceDescribedBy()) {
						if (RPON.equalsIgnoreCase(service.getName()) && service.getServiceSpecCharDescribes() != null) {
							for (ServiceSpecCharDescribes serviceSpec : service.getServiceSpecCharDescribes()) {
								allocateExternal.setRpon(serviceSpec.getValue());
							}
						}
					}
				}
			}
		}
		
		allocateExternal.setOriginSystem(P_IN_ORIGEM);
		allocateExternal.setDocumentType(P_IN_TIPO_DOCUMENTO);
		allocateExternal.setServiceClass(P_IN_CLASSE_SERVICO);
		allocateExternal.setOrderType(P_IN_TIPO_ORDEM);

		return getResourceInventoryEntity(allocateRepository.allocate(allocateExternal), entity);
	}
	
	/**
	 * Enriquece ResourceInventoryEntity atraves da execucao do AllocateDAO.allocate
	 * 
	 * @param allocateExternal
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceInventoryEntity(AllocateExternalResourceEntity allocateExternal, ResourceInventoryEntity entity)
			throws OSSBusinessException {
		
		entity.setPhysicalResourceSummary(allocateExternal.getNote());

		if (RESULTADO_ESPERADO != allocateExternal.getResultCode()) {
		    String errorCode = String.valueOf(allocateExternal.getResultCode());
		    String errorMessage = allocateExternal.getMessage();
		    String detailMessage = errorCode + "; " + errorMessage;

		    falloutConfig.setErrorCode(errorCode);
		    falloutConfig.setErrorMessage(errorMessage);
			falloutConfig.setDetailMessage(detailMessage);
		    throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}

		return entity;
	}
}
