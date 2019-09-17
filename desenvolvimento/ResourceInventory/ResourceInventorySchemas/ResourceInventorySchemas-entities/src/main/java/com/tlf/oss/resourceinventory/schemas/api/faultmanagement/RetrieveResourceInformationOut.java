package com.tlf.oss.resourceinventory.schemas.api.faultmanagement;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.Equipment;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveResourceInformationOut", propOrder = { "equipment", "codeReturn", "messageReturn" })
public class RetrieveResourceInformationOut {

	protected List<Equipment> equipment;
	protected Integer codeReturn;
	protected String messageReturn;

	/**
	 * @return the equipment
	 */
	public List<Equipment> getEquipment() {
		return equipment;
	}

	/**
	 * @param equipment
	 *            the equipment to set
	 */
	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	/**
	 * @return the codeReturn
	 */
	public Integer getCodeReturn() {
		return codeReturn;
	}

	/**
	 * @param codeReturn
	 *            the codeReturn to set
	 */
	public void setCodeReturn(Integer codeReturn) {
		this.codeReturn = codeReturn;
	}

	/**
	 * @return the messageReturn
	 */
	public String getMessageReturn() {
		return messageReturn;
	}

	/**
	 * @param messageReturn
	 *            the messageReturn to set
	 */
	public void setMessageReturn(String messageReturn) {
		this.messageReturn = messageReturn;
	}

}