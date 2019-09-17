package com.tlf.oss.resourceinventory.cpe.repository;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.repository.factory.GenericRepository;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DispositivoFisicoRepository extends GenericRepository {

	@Inject
	private OSSLogger logger;

	public <T> void create(DispositivoFisico entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Criando registro na tabela DispositivoFisico: " + entity);

		super.create(entity);
	}

	public <T> void update(DispositivoFisico entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Atualizando o registro na tabela DispositivoFisico: " + entity);

		super.update(entity);
	}

	public <T> void delete(DispositivoFisico entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Excluindo o registro na tabela DispositivoFisico: " + entity);

		if (!hasChildren(entity)) {

			super.delete(entity);

		} else {

			logger.log(OSSLogger.INFO, "Contem registros filhos");

		}

	}

	@SuppressWarnings("unchecked")
	public List<DispositivoFisico> listByServiceId(String serviceId) throws OSSBusinessException {

		List<DispositivoFisico> result;

		try {

			logger.log(OSSLogger.INFO,
					"Buscando registros na tabela DispositivoFisico para o serviceId = " + serviceId);

			Query query = factory.createQuery(
					"SELECT df FROM ServicoAssinante sa INNER JOIN RecursoLogico rl ON (sa.id = rl.servicoAssinanteId) INNER JOIN DispositivoFisico df ON (df.id = rl.dispositivoFisicoId) WHERE UPPER(sa.serviceId) = ?1");

			query.setParameter(1, serviceId.toUpperCase());

			result = query.getResultList();

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

	public DispositivoFisico findById(Integer id) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Buscando o registro na tabela DispositivoFisico com id: " + id);

		return super.findById(DispositivoFisico.class, id);
	}

	@SuppressWarnings(value = "unchecked")
	public DispositivoFisico findByServiceId(String serviceId) throws OSSBusinessException {

		List<DispositivoFisico> servicoAssinante;

		try {

			logger.log(OSSLogger.INFO, "Buscando registro na tabela DispositivoFisico para o serviceId = " + serviceId);

			Query query = factory.createQuery(
					"SELECT df FROM ServicoAssinante sa INNER JOIN RecursoLogico rl ON (sa.id = rl.servicoAssinanteId) INNER JOIN DispositivoFisico df ON (df.id = rl.dispositivoFisicoId) WHERE UPPER(sa.serviceId) = ?1");

			query.setParameter(1, serviceId);

			servicoAssinante = query.getResultList();

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());

			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(),
					String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					FalloutCode.RICPE_999.getMessage());
		}

		return servicoAssinante.isEmpty() ? null : servicoAssinante.get(0);
	}

	@SuppressWarnings("unchecked")
	public DispositivoFisico findByAccessId(String accessId, EstadoRecursoLogico estadoRecursoLogico)
			throws OSSBusinessException {

		List<DispositivoFisico> servicoAssinante;

		try {

			logger.log(OSSLogger.INFO, "Buscando registro na tabela DispositivoFisico para o accessId = " + accessId
					+ " e EstadoRecurso = " + estadoRecursoLogico.getEstadoRecurso());

			Query query = factory.createQuery(
					"SELECT df FROM ServicoAssinante sa INNER JOIN RecursoLogico rl ON (sa.id = rl.servicoAssinanteId) INNER JOIN DispositivoFisico df ON (df.id = rl.dispositivoFisicoId) WHERE UPPER(sa.accessId) = ?1 and UPPER(rl.estadoRecursoLogicoId) = ?2");
			query.setParameter(1, accessId);
			query.setParameter(2, estadoRecursoLogico.getId().toString());
			servicoAssinante = query.getResultList();

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());

			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(),
					String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					FalloutCode.RICPE_999.getMessage());
		}

		return servicoAssinante.isEmpty() ? null : servicoAssinante.get(0);
	}

	@SuppressWarnings("unchecked")
	public boolean hasChildren(DispositivoFisico dispositivoFisico) throws OSSBusinessException {

		boolean result = false;

		if (null != dispositivoFisico) {

			List<RecursoLogico> recursosLogicos;

			try {

				logger.log(OSSLogger.INFO, "Buscando registro na tabela RecursoLogico para o DispositivoFisico ID = "
						+ dispositivoFisico.getId());

				Query query = factory.createQuery("SELECT rl from RecursoLogico rl WHERE rl.dispositivoFisicoId = ?1");

				query.setParameter(1, dispositivoFisico.getId());

				recursosLogicos = query.getResultList();

			} catch (PersistenceException e) {
				logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());

				throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(),
						String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));
			} catch (Exception e) {
				logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
				throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
						FalloutCode.RICPE_999.getMessage());
			}

			return (!recursosLogicos.isEmpty() && null != recursosLogicos);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Optional<DispositivoFisico> findByMacaddress(String macaddress) throws OSSBusinessException {

		List<DispositivoFisico> list;

		try {

			logger.log(OSSLogger.INFO,
					"Buscando registro na tabela DispositivoFisico para o macAddress = " + macaddress);

			Query query = factory.createQuery("SELECT df from DispositivoFisico df WHERE df.macAddress = ?1");

			query.setParameter(1, macaddress);

			list = query.getResultList();

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());

			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(),
					String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					FalloutCode.RICPE_999.getMessage());
		}

		return list.stream().findFirst();
	}

	@SuppressWarnings("unchecked")
	public Optional<DispositivoFisico> findBySerialNumber(String serialNumber) throws OSSBusinessException {

		List<DispositivoFisico> list;

		try {

			logger.log(OSSLogger.INFO,
					"Buscando registro na tabela DispositivoFisico para o numeroSerial = " + serialNumber);

			Query query = factory.createQuery("SELECT df from DispositivoFisico df WHERE df.numeroSerial = ?1");

			query.setParameter(1, serialNumber);

			list = query.getResultList();

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());

			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(),
					String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					FalloutCode.RICPE_999.getMessage());
		}

		return list.stream().findFirst();
	}

	@SuppressWarnings("unchecked")
	public Optional<DispositivoFisico> findByCatalogo(CatalogoDispositivo catalogo) throws OSSBusinessException {

		try {

			logger.log(OSSLogger.INFO, "Buscando registro na tabela DispositivoFisico para o catalogo = " + catalogo);

			Integer catalogoId = catalogo.getId();
			if (null != catalogoId) {
				Query query = factory
						.createQuery("SELECT df from DispositivoFisico df WHERE df.catalagoDispositivoId = ?1");
				query.setParameter(1, catalogoId);

				List<DispositivoFisico> dispositivoFisicos = query.getResultList();
				if (null != dispositivoFisicos) {
					return dispositivoFisicos.stream().findFirst();
				}
			}

		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());

			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(), FalloutCode.RICPE_002.getValue(),
					String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					FalloutCode.RICPE_999.getMessage());
		}
		return Optional.ofNullable(null);
	}

	@SuppressWarnings("unchecked")
	public List<DispositivoFisico> listByAccessId(ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Extraindo o accessId da entidade...");

		String accessId = EntityExtractor.extractAccessId(entity);

		List<DispositivoFisico> result;

		logger.log(OSSLogger.INFO, "Buscando registro na tabela DispositivoFisico para o accessId: " + accessId);

		try {

			Query query = factory.createQuery(
					"SELECT df from DispositivoFisico df INNER JOIN RecursoLogico rl ON (df.id = rl.dispositivoFisicoId) INNER JOIN ServicoAssinante sa ON (rl.servicoAssinanteId = sa.id) WHERE sa.accessId = ?1");

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
