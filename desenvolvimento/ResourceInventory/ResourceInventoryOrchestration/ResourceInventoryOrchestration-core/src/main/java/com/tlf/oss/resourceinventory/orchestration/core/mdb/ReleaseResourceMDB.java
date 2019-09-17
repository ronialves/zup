package com.tlf.oss.resourceinventory.orchestration.core.mdb;

import java.io.StringReader;
import java.util.UUID;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.orchestration.core.OrchestrationController;
import com.tlf.oss.resourceinventory.orchestration.core.interceptor.Audit;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * Message-Driven Bean implementation class for: ReleaseResourceMDB
 */
@MessageDriven(name = "com.tlf.oss.resourceinventory.orchestration.core.mdb.ReleaseResourceMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "cf.ConnectionFactoryReleaseResourceQueue"),
		@ActivationConfigProperty(propertyName = "destinationJndiName", propertyValue = "jms.ReleaseResourceQueue") })
@Audit
public class ReleaseResourceMDB implements MessageListener {

	@Inject
	private OSSLogger logger;

	@Inject
	private Header header;

	@Inject
	OrchestrationController controller;

	private void init(Message message) {
		try {
			header.setClientId(message.getStringProperty(Header.Constant.HEADER_CLIENT_ID));
		} catch (JMSException e) {
			header.setClientId(getClass().getName());
		}

		try {
			header.setMessageId(message.getStringProperty(Header.Constant.HEADER_MESSAGE_ID));
		} catch (JMSException e) {
			header.setMessageId(UUID.randomUUID().toString());
		}

		try {
			logger.setServiceName(message.getStringProperty("ossloggerServiceName"));
		} catch (JMSException e) {
		}

		logger.setBase("[MDB] - [" + getClass().getName() + " - onMessage]");
	}

	public void onMessage(Message message) {

		init(message);
		
		try {

			TextMessage msg = null;
			if (message instanceof TextMessage) {
				msg = (TextMessage) message;
				logger.log(OSSLogger.INFO, "Mensagem Recebida: " + msg.getText());
				ResourceInventoryEntity entity = UMarshalEntity(msg.getText());
				executeRelease(entity);
			} else {
				logger.log(OSSLogger.INFO, "Formato invalido");
			}

		} catch (Exception e) {
			logger.error("Erro ao processar mensagem", e);
		}
	}

	public ResourceInventoryEntity executeRelease(ResourceInventoryEntity entity) {

		try {
			logger.log(OSSLogger.INFO, "Chamando OrchestrationController");
			controller.execute("1.0", "RELEASE", entity);

		} catch (Exception e) {
			logger.error("Erro ao realizar OrchestrationController", e);
		}
		return entity;
	}

	private ResourceInventoryEntity UMarshalEntity(String nd) throws JAXBException, JMSException {

		StringReader reader = new StringReader(nd);
		Unmarshaller unmarshaller = JAXBContext.newInstance(ResourceInventoryEntity.class).createUnmarshaller();
		ResourceInventoryEntity entity = (ResourceInventoryEntity) unmarshaller.unmarshal(reader);

		return entity;
	}
}
