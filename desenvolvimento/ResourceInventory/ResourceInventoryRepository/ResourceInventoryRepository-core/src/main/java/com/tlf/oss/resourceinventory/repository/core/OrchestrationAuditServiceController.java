package com.tlf.oss.resourceinventory.repository.core;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.resourceinventory.schemas.api.OrchestrationAuditEntity;

@Logged
public class OrchestrationAuditServiceController {
	
	@PersistenceContext(name = "ri_repository_unit")
	private EntityManager em;
	
	public void create(OrchestrationAuditEntity entity) {		
		em.persist(entity);
		em.flush();
	}	

}
