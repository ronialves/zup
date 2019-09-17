package com.tlf.oss.resourceinventory.terus.core.util;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.inject.Inject;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import com.tlf.oss.common.log.OSSLogger;

public class CalendarUtil {
	
	@Inject
	protected static OSSLogger logger;
	
	public static XMLGregorianCalendar getCurrentTime() {
		XMLGregorianCalendar xMLGregorianCalendar = null;
		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(new Date());
			xMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (Exception e) {
			logger.log(OSSLogger.DEBUG, "CalendarUtil:getCurrentTime - " + e.getMessage());
		}
		return xMLGregorianCalendar;
	}

}
