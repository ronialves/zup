package com.tlf.oss.resourceinventory.osp.core.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.enterprise.inject.spi.CDI;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.commons.codec.binary.Base64;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.properties.Configuration;

public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {
	
	private OSSLogger logger = CDI.current().select(OSSLogger.class).get();

	private static final Configuration configuration = Configuration.getInstance("tokenOSP", "tokenOSP.properties");

	public boolean handleMessage(SOAPMessageContext smc) {

		Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		String userNameOSP = configuration.get("userName");
		String passwordOSP = configuration.get("password");

		if (outboundProperty.booleanValue()) {

			SOAPMessage message = smc.getMessage();

			try {

				SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();

				String time = UsernameTokenUtils.getTime();
				String strNonce = UsernameTokenUtils.getNonce();

				SOAPElement security = header.addChildElement("Security", "wsse",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

				SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");

				SOAPElement username = usernameToken.addChildElement("Username", "wsse");
				username.addTextNode(userNameOSP);

				SOAPElement password = usernameToken.addChildElement("Password", "wsse");
				password.setAttribute("Type",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest");
				password.addTextNode(UsernameTokenUtils.encrypt(strNonce + time + passwordOSP));

				SOAPElement nonce = usernameToken.addChildElement("Nonce", "wsse");
				nonce.setAttribute("EncodingType",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");

				String onceBase64 = Base64.encodeBase64String(strNonce.getBytes());

				nonce.addTextNode(onceBase64);

				SOAPElement created = usernameToken.addChildElement("Created", "wsu",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
				created.addTextNode(time);

				logSOAPMessage(message, "Request");

			} catch (Exception e) {
				logger.error("Error to config OSP request", e);
			}

		} else {
			try {
				SOAPMessage message = smc.getMessage();
				logSOAPMessage(message, "Response");

			} catch (Exception ex) {
				logger.error("Error to config OSP response", ex);
			}
		}

		return outboundProperty;

	}

	public Set getHeaders() {
		return null;
	}

	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	public void close(MessageContext context) {
	}
	
	private void logSOAPMessage(SOAPMessage message, String operation) throws SOAPException, IOException {
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
	    message.writeTo(byteArrayOutputStream);  
	    StringBuilder msgBuilder = new StringBuilder(operation)
	    			.append(" OSP = ")
	    			.append(new String(byteArrayOutputStream.toByteArray()));
	    logger.log(OSSLogger.INFO, msgBuilder.toString());
	}

}
