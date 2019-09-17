package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = PortDetailEntity.PORTS_DETAIL, resultClasses = PortDetailEntity.class, procedureName = "PKG_RESERVE.PRC_RETRIEVE_PORTS_DETAIL",
	parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_type", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_id", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_cursor", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
	})
})
public class PortDetailEntity implements Serializable{

	private static final long serialVersionUID = 4461044373462743764L;

	public static final String PORTS_DETAIL = "portsDetail";
	
	@Basic
	@Column(name = "CARD_INST_ID")
	private String cardInstId;
	
	@Basic
	@Column(name = "SLOT")
	private String slot;
	
	@Basic
	@Column(name = "NAME")
	private String name;
	
	@Id
	@Basic
	@Column(name = "PORT_HUM_ID")
	private String portHumId;

	public String getCardInstId() {
		return cardInstId;
	}

	public void setCardInstId(String cardInstId) {
		this.cardInstId = cardInstId;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPortHumId() {
		return portHumId;
	}

	public void setPortHumId(String portHumId) {
		this.portHumId = portHumId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardInstId == null) ? 0 : cardInstId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((portHumId == null) ? 0 : portHumId.hashCode());
		result = prime * result + ((slot == null) ? 0 : slot.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortDetailEntity other = (PortDetailEntity) obj;
		if (cardInstId == null) {
			if (other.cardInstId != null)
				return false;
		} else if (!cardInstId.equals(other.cardInstId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (portHumId == null) {
			if (other.portHumId != null)
				return false;
		} else if (!portHumId.equals(other.portHumId))
			return false;
		if (slot == null) {
			if (other.slot != null)
				return false;
		} else if (!slot.equals(other.slot))
			return false;
		return true;
	}
}