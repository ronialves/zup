package com.tlf.oss.resourceinventory.repository.core;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.resourceinventory.schemas.api.CustomerAuditEntity;

@Logged
public class CustomerAuditController {
	
	@PersistenceContext(name = "ri_repository_unit")
	private EntityManager em;
	
	public void create(CustomerAuditEntity entity) {		
		em.persist(entity);				
	}
		
}
