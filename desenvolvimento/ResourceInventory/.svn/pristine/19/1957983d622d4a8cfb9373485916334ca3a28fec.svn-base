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
	@NamedStoredProcedureQuery(name = IdentifyNetworkEntity.IDENTIFY_NETWORK, resultClasses = IdentifyNetworkEntity.class, procedureName = "PKG_RESERVE.PRC_IDENTIFY_NETWORK",
	parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_networkownerid", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nrc", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_designador", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codmessage", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codmessagenext", type = String.class)
	})
})
public class IdentifyNetworkEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String IDENTIFY_NETWORK = "identifyNetwork";

	@Id
	@Basic
	@Column(name = "P_CODMESSAGE")
	private String codMessage;
	
	@Basic
	@Column(name = "P_CODMESSAGENEXT")
	private String codMessageNext;

	public String getCodMessage() {
		return codMessage;
	}

	public void setCodMessage(String codMessage) {
		this.codMessage = codMessage;
	}

	public String getCodMessageNext() {
		return codMessageNext;
	}

	public void setCodMessageNext(String codMessageNext) {
		this.codMessageNext = codMessageNext;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codMessage == null) ? 0 : codMessage.hashCode());
		result = prime * result + ((codMessageNext == null) ? 0 : codMessageNext.hashCode());
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
		IdentifyNetworkEntity other = (IdentifyNetworkEntity) obj;
		if (codMessage == null) {
			if (other.codMessage != null)
				return false;
		} else if (!codMessage.equals(other.codMessage))
			return false;
		if (codMessageNext == null) {
			if (other.codMessageNext != null)
				return false;
		} else if (!codMessageNext.equals(other.codMessageNext))
			return false;
		return true;
	}
}