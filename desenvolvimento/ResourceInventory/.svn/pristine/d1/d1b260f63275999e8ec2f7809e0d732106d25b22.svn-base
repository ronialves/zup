package com.tlf.oss.resourceinventory.cpe.factory;

import java.util.concurrent.TimeoutException;

import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.cpe.enums.CpeWsName;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;

public class OssBusinessExceptionFactory {

	private static final String NULL_STRING_CONTENT = "null";

	private static final String POINTS_SEPARATOR = "::";

	private static final String DIRECTION_SEPARATOR = "->";

	private static final String SEPARATOR = "; ";

	public static final String DEFAULT_ERROR_CODE = "-1";

	private static final OSSFalloutConfiguration falloutConfig;

	static {
	    falloutConfig = new OSSFalloutConfiguration(FalloutCode.RICPE_003.getValue(), "", CpeConstants.FALLOUT_EXCEPTIONS_FILENAME, CpeConstants.FALLOUT_DESCRIPTION_FILENAME);
	}
	
	public static OSSBusinessException getFalloutOSSBusinessException(String errorCode, final String errorMessage, final String service) {
		
		falloutConfig.setOriginAPIDescription(String.format(FalloutCode.RICPE_003.getDescription(), service));
		
		if(errorCode == null || errorCode.trim().isEmpty() || errorCode.trim().equalsIgnoreCase(NULL_STRING_CONTENT)) {
			errorCode = DEFAULT_ERROR_CODE;
		}

	    falloutConfig.setErrorCode(errorCode);
	    falloutConfig.setErrorMessage(errorMessage);
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

			if (exception instanceof TimeoutException || exception instanceof WebServiceException) {
				return new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(), String.format(FalloutCode.RICPE_002.getMessage(), "Erro ao chamar a operação " + service + " no CPE", exception.getMessage()));
			}

			return new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(), exception.getMessage());
		} catch (Exception e) {
			return new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(), exception.getMessage());
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

	public static OSSBusinessException getFalloutOSSBusinessException(String errorCode, final String errorMessage, final CpeWsName service) {
		return getFalloutOSSBusinessException(errorCode, errorMessage, service.getName());
	}
	
	public static OSSBusinessException getOSSBusinessException(Exception e, final CpeWsName service) {
		return getOSSBusinessException(e, service.getName());
	}
	
	public static OSSBusinessException getOSSBusinessException(Exception e) {
		return getOSSBusinessException(e, CpeWsName.ALLOCATE);
	}
}