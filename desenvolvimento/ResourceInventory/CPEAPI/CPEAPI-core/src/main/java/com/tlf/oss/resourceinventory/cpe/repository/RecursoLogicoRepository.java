package com.tlf.oss.resourceinventory.cpe.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.repository.factory.GenericRepository;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class RecursoLogicoRepository extends GenericRepository {

	@Inject
	private OSSLogger logger;

	public <T> void create(RecursoLogico entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Criando registro na tabela RecursoLogico: " + entity);
		super.create(entity);
	}

	public <T> void update(RecursoLogico entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Atualizando o registro na tabela RecursoLogico: " + entity);
		super.update(entity);
	}

	public <T> void delete(RecursoLogico entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Excluindo o registro na tabela RecursoLogico: " + entity);
		super.delete(entity);
	}

	public RecursoLogico findById(Integer id) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Buscando o registro na tabela RecursoLogico com id: " + id);
		return super.findById(RecursoLogico.class, id);
	}

	@SuppressWarnings("unchecked")
	public RecursoLogico findByServicoAssinanteId(Integer id) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Buscando o serviceAssinanteId " + id + " na tabela RecursoLogico...");

		Query query = factory.createQuery(
				"SELECT rl FROM RecursoLogico rl WHERE rl.servicoAssinanteId = ?1 AND rl.dispositivoFisicoId IS NOT NULL");
		query.setParameter(1, id);

		List<RecursoLogico> recursoLogico = query.getResultList();

		return recursoLogico.isEmpty() ? null : recursoLogico.get(0);
	}

	@SuppressWarnings("unchecked")
	public RecursoLogico findByDispositivoFisicoId(Integer id) throws OSSBusinessException {
		Query query = factory.createQuery("SELECT rl FROM RecursoLogico rl WHERE rl.dispositivoFisicoId = ?1");
		query.setParameter(1, id);
		List<RecursoLogico> recursoLogico = query.getResultList();
		return recursoLogico.isEmpty() ? null : recursoLogico.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<RecursoLogico> listByServiceId(String serviceId) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Buscando o recurso lógico por serviceId " + serviceId);

		Query query = factory.createQuery(
				"SELECT rl FROM ServicoAssinante sa INNER JOIN RecursoLogico rl ON (sa.id = rl.servicoAssinanteId) WHERE UPPER(sa.serviceId) = ?1");
		query.setParameter(1, serviceId);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RecursoLogico> listByAccessId(ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Extraindo o accessId da entidade...");

		String accessId = EntityExtractor.extractAccessId(entity);

		List<RecursoLogico> result;

		logger.log(OSSLogger.INFO, "Buscando registro na tabela RecursoLogico por AccessId " + entity);

		try {

			Query query = factory.createQuery(
					"SELECT rl FROM ServicoAssinante sa INNER JOIN RecursoLogico rl ON (sa.id = rl.servicoAssinanteId) WHERE UPPER(sa.accessId) = ?1 ORDER BY sa.id");
			query.setParameter(1, accessId);

			result = query.getResultList();

			logger.log(OSSLogger.INFO, logOut(result));

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());

			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(),
					String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					FalloutCode.RICPE_999.getMessage());
		}

		return result;
	}

}
