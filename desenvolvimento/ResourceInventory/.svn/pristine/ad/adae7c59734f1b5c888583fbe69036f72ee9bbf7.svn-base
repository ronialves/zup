package com.tlf.oss.resourceinventory.radius.repository.factory;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * REC3635-1110 | REC3635-2042
 * 
 * @project Fusion
 * @author 80629552
 * @since 20190325
 */
public class GenericRepository implements Serializable{

	private static final long serialVersionUID = 7631646285861246788L;
	
	public static final String RADIUS_SCHEMA = "RADIUS_OWNER";

	@PersistenceContext(name="RadiusDS")
	private EntityManager factory;
	
	public EntityManager getFactory() {
		return factory;
	}
	
}
