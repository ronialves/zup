package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.AllocateResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class AllocateResourceDao extends GenericDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final String P_USER = "RESOURCE_INVENTORY";
	private static final String FALSE = "FALSE";
	
	@Inject
	protected OSSLogger logger;
	
	public AllocateResourceEntity allocateResource(AllocateResourceEntity entity){
		AllocateResourceEntity result = new AllocateResourceEntity();
		
		try {	
			TypedQuery<AllocateResourceEntity> query;
			query = getEntityManager().createNamedQuery(AllocateResourceEntity.ALLOCATE_RESOURCE, AllocateResourceEntity.class);

			query.setParameter("p_cnl", entity.getCnl());
			query.setParameter("p_sigla_at", entity.getSiglaAt());
			query.setParameter("p_rack", entity.getRack());

			query.setParameter("p_circ_path_inst_id", entity.getCircPathInstId());
			query.setParameter("p_speed", entity.getSpeed());
			query.setParameter("p_unit", entity.getUnit());
			query.setParameter("p_protocol", entity.getProtocol());
			//NRC
			query.setParameter("p_customer", entity.getCustomer());
			//Category
			query.setParameter("p_product", entity.getProduct());
			
			query.setParameter("p_user", P_USER);
			query.setParameter("p_access_type", null);
			query.setParameter("p_service_type", null);
			query.setParameter("p_readonly", FALSE);
			
			logIn(query);

			result =  query.getSingleResult();
			
			logOut(result);
		} catch (Exception e) {
			result.setCode(10);
			result.setDescription(e.getMessage());
		}
		
		return result;
	}
	
	private void logIn(Query query) {
		String log = getlogIn("PKG_ALLOCATE.PRC_CONFIGURE_PATH", query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(AllocateResourceEntity result) {
		String log = new StringBuilder("Param OUT: ")
				.append("p_ret_code = ").append(result.getCode())
				.append("p_ret_msg = ").append(result.getDescription())
				.toString();
		logger.log(OSSLogger.INFO, log);
	}

}
