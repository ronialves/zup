package com.tlf.oss.resourceinventory.tbs.entity;

import java.io.Serializable;

/**
 * @param <P> Tipo do ID
 */
public abstract class EntityCommon<P extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract P getId();

	public abstract void setId(P id);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityCommon other = (EntityCommon) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (getId().equals(other.getId())){
			return true;
		} 
		
		return false;
	}

}
