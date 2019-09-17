package com.tlf.oss.resourceinventory.osp.factory;

import java.text.Normalizer;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.utils.Constants;

public class OssBusinessExceptionFactory {

	private static final String REGEX_LAST_POINT = "[\\.]$";

	private static final String REGEX_ASCII = "[^\\p{ASCII}]";

	private static final String NULL_STRING_CONTENT = "null";

	private static final String POINTS_SEPARATOR = "::";

	private static final String DIRECTION_SEPARATOR = "->";

	private static final String SEPARATOR = "; ";

	private static final String DEFAULT_ERROR_CODE = "1";

	private static final OSSFalloutConfiguration falloutConfig;

	static {
	    falloutConfig = new OSSFalloutConfiguration(Code.RIOSP_003.getValue(), "", Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	}
	
	public static OSSBusinessException getFalloutOSSBusinessException(String errorCode, final String errorMessage, final String service) {
		
		falloutConfig.setOriginAPIDescription(String.format(Code.RIOSP_003.getDescription(), service));
		
		if(errorCode == null || errorCode.trim().isEmpty() || errorCode.trim().equalsIgnoreCase(NULL_STRING_CONTENT)) {
			errorCode = DEFAULT_ERROR_CODE;
		}

	    falloutConfig.setErrorCode(errorCode);
	    falloutConfig.setErrorMessage(normalizer(errorMessage));
	    falloutConfig.setDetailMessage(errorCode.concat(SEPARATOR).concat(errorMessage));
	    return OSSExceptionFactory.getOSSBusinessException(falloutConfig);
	}

	public static OSSBusinessException getOSSBusinessException(Exception exception, final String service) {
		try {
			if (exception instanceof OSSBusinessException) {
				return buildOssBusinessExceptions(exception, service);
			}

			if (exception instanceof SOAPFaultException) {
				return getFalloutOSSBusinessException(DEFAULT_ERROR_CODE, ((SOAPFaultException) exception).getFault().getFaultString(), service);
			}

			if (exception instanceof TimeoutException || exception instanceof WebServiceException
					|| exception instanceof com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException
					|| exception instanceof com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.FacilitiesException
					|| exception instanceof com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.FacilitiesException) {
				return new OSSBusinessException(Code.RIOSP_002.getDescription(), Code.RIOSP_002.getValue(), String.format(Code.RIOSP_002.getMessage(), "Erro ao chamar a operação " + service + " no OSP", exception.getMessage()));
			}

			return new OSSBusinessException(Code.RIOSP_999.getDescription(), Code.RIOSP_999.getValue(), exception.getMessage());
		} catch (Exception e) {
			return new OSSBusinessException(Code.RIOSP_999.getDescription(), Code.RIOSP_999.getValue(), exception.getMessage());
		}
	}

	private static OSSBusinessException buildOssBusinessExceptions(Exception exception, final String service) {
		final OSSBusinessException businessException = (OSSBusinessException) exception;  
		if (businessException.getDetail() != null 
				&& businessException.getDetail().contains(DIRECTION_SEPARATOR)
				&& businessException.getDetail().contains(POINTS_SEPARATOR)) {

			final String[] splitedErrorDetail = businessException.getDetail().split(DIRECTION_SEPARATOR);
			final String code = splitedErrorDetail[1];
			final String message = splitedErrorDetail[0].split(POINTS_SEPARATOR)[1];
			return OssBusinessExceptionFactory.getFalloutOSSBusinessException(code, message, service);
		}
		
		return businessException;
	}

	public static OSSBusinessException getFalloutOSSBusinessException(String errorCode, final String errorMessage, final OSPWSName service) {
		return getFalloutOSSBusinessException(errorCode, errorMessage, service.getName());
	}
	
	public static OSSBusinessException getOSSBusinessException(Exception e, final OSPWSName service) {
		return getOSSBusinessException(e, service.getName());
	}
	
	private static String normalizer(final String errorMessage) {
		return Normalizer.normalize(errorMessage, Normalizer.Form.NFD)
				.replaceAll(REGEX_ASCII, "") // Remove todos os acentos
				.replaceAll(REGEX_LAST_POINT, "") // Remove o ultimo ponto no final da String
				.toUpperCase(); 
	}
	
}