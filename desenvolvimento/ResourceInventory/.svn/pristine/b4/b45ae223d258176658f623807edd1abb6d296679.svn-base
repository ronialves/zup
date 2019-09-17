package com.tlf.oss.resourceinventory.repository.core;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.api.CustomerEntity;

@Logged
public class CustomerController {
	
	@Inject
	private OSSLogger logger;
	
	@PersistenceContext(name = "ri_repository_unit")
	private EntityManager em;
	
	public void create(CustomerEntity entity) throws OSSBusinessException {		
		String accessDesignator = entity.getAccessDesignator();	
		
		CustomerEntity customer;
		try {
			customer = findCustomer(accessDesignator);
			if (customer != null) {
				logger.log(OSSLogger.INFO, "ResourceFacingServiceEntity ja existente na base de dados - ServiceId:" + accessDesignator);
				return;
			}
			
		} catch (OSSBusinessException e) {
			logger.error("Failed to retrieve resourceFacingServiceEntity", e);
			throw e;
		}
			
		em.persist(entity);
		em.flush();
	}
	
	public void update(CustomerEntity entity) throws OSSBusinessException {		
		
		CustomerEntity customer = findCustomer(entity.getAccessDesignator());
		customer.setStatus(entity.getStatus());
		
		em.merge(customer);
		em.flush();
	}
	
	public CustomerEntity retrieve(String accessDesignator) throws OSSBusinessException {
		CustomerEntity customer = findCustomer(accessDesignator);		
		return customer;
	}
	
	public void delete(String accessDesignator) throws OSSBusinessException {
		CustomerEntity customer = findCustomer(accessDesignator);
		
		em.remove(customer);
		em.flush();
		
		if(em.contains(customer)) {
			logger.log(OSSLogger.ERROR, "Failed to delete Customer");
			return;
		}
		
		logger.log(OSSLogger.INFO, "Success to delete Custoemr");
		
			}	

	
	private CustomerEntity findCustomer(String acessDesignator) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Retrieve Customer by AccessDesignator: " + acessDesignator);

		try {
			CustomerEntity customer = em.createNamedQuery("CustomerEntity.byAccessDesignator", CustomerEntity.class)
					.setParameter("accessDesignator", acessDesignator).getSingleResult();
	
			logger.log(OSSLogger.INFO, "Retrieve Customer: " + customer.toString());

			return customer;

		}catch (NoResultException ex) {
			logger.log(OSSLogger.INFO, "AccessDesignator not found.");
			return null;
		} catch (NonUniqueResultException e) {
			logger.log(OSSLogger.ERROR, "AccessDesignator not found - "+ e.getMessage());
			throw new OSSBusinessException("AccessDesignator not found - "+ acessDesignator, "RIREPOSITORY-002", e.getMessage());
		}
	}
}
