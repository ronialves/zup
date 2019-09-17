package com.tlf.oss.resourceinventory.cpe.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.CacheStoreMode;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoInfo;
import com.tlf.oss.resourceinventory.cpe.entity.ClientInformation;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.repository.factory.GenericRepository;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class RetrieveRepository extends GenericRepository {

	@Inject
	private OSSLogger logger;

	@Inject
	private ServicoAssinanteRepository assinanteRepository;

	@Inject
	private CaracteristicaDispositivoRepository caracteristicaDispositivoRepository;

	public static final String QUERY_BY_ESTADO_SERVICO = " ";

	public List<CatalogoInfo> retrieveCatalog() throws OSSBusinessException{

		List<CatalogoInfo> result = null;

		try {
			final TypedQuery<CatalogoInfo> query = getEntityManager().createNamedQuery(CatalogoInfo.QUERY_RETRIEVE_CATALOG, CatalogoInfo.class)
					.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);

			result = query.getResultList();

			logger.log(OSSLogger.INFO, logOut(result));

			if(null == result || result.isEmpty()){
				throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(),
											   FalloutCode.RICPE_999.getValue(),
											   "Não há nenhum registro no inventário CPE");
			}
		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());

			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(),
										   FalloutCode.RICPE_002.getValue(),
										   String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));		
		} catch (OSSBusinessException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());

			throw e;
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(),
										   FalloutCode.RICPE_999.getValue(),
										   FalloutCode.RICPE_999.getMessage());
		}

		return result;
	}

	public List<ClientInformation> retrieveClientInformation(ResourceInventoryEntity entity, EstadoServico estadoServico) throws OSSBusinessException {

		String accessId;
		String estado;
		List<ClientInformation> result = null;

		try {

			if(null == estadoServico) {
				estado = EstadoServico.EM_APROVISIONAMENTO.getValue();
			} else {
				estado = estadoServico.getValue();
			 }

			ServicoAssinante servicoAssinante = assinanteRepository.findByServiceId(entity);

			if (null == servicoAssinante) {
				accessId = EntityExtractor.extractAccessId(entity);
			} else {
				accessId = servicoAssinante.getAccessId();
			}

			final TypedQuery<ClientInformation> query = getEntityManager().createNamedQuery(ClientInformation.QUERY_RETRIEVE_CLIENT_INFORMATION, ClientInformation.class)
					.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);

			query.setParameter(1, accessId);
			query.setParameter(2, estado);

			logger.log(OSSLogger.INFO, logIn(ClientInformation.QUERY_RETRIEVE_CLIENT_INFORMATION, query));

			result = query.getResultList();

			for (ClientInformation product : result) {
				if (null != product.getCatalogoDispositivoId()) {
					product.setCaracteristicas(caracteristicaDispositivoRepository.findByCatalogoDispositivoId(product.getCatalogoDispositivoId()));
				}
			}

			logger.log(OSSLogger.INFO, logOut(result));
			
		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());

			throw new OSSBusinessException(FalloutCode.RICPE_002.getDescription(),
										   FalloutCode.RICPE_002.getValue(),
										   String.format(FalloutCode.RICPE_002.getMessage(), "Erro de conexão", e.getMessage()));		
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(),
										   FalloutCode.RICPE_999.getValue(),
										   FalloutCode.RICPE_999.getMessage());
		}

		return result;
	}
}
