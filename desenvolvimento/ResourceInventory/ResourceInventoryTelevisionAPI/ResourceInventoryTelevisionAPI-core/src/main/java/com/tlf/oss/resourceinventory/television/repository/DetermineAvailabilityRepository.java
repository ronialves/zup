package com.tlf.oss.resourceinventory.television.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.CacheStoreMode;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.television.entity.CidadeCobertura;
import com.tlf.oss.resourceinventory.television.entity.CidadeUf;
import com.tlf.oss.resourceinventory.television.entity.Cobertura;
import com.tlf.oss.resourceinventory.television.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.television.repository.factory.GenericRepository;

public class DetermineAvailabilityRepository extends GenericRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	OSSLogger logger;

	public Map<CidadeUf, List<Cobertura>> getCobertura() {
		List<CidadeCobertura> cobertura = null;
		Map<CidadeUf, List<Cobertura>> coberturaMap = null;
		try {

			TypedQuery<CidadeCobertura> query = getFactory().createNamedQuery(CidadeCobertura.QUERY_COVERAGE,
					CidadeCobertura.class).setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
			getlogIn(CidadeCobertura.QUERY_COVERAGE, query);

			cobertura = query.getResultList();

			coberturaMap = getCoberturaMap(cobertura);

		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, String.format(ExceptionInfoEnum.RITELEVISION_003.getDescription(), 
					CidadeCobertura.QUERY_COVERAGE));
		}

		return coberturaMap;
	}

	private Map<CidadeUf, List<Cobertura>> getCoberturaMap(List<CidadeCobertura> cobertura) {
		Map<CidadeUf, List<Cobertura>> coberturaMap = new HashMap<CidadeUf, List<Cobertura>>();

		for (CidadeCobertura c : cobertura) {
			CidadeUf cidadeUf = new CidadeUf(c.getCidade(), c.getUf());
			
			Cobertura cob = new Cobertura(c.getTechnology(), c.getCas(), c.getSatellite(), c.getNetworkOwner(), c.getTvPlatform());

			if (!coberturaMap.containsKey(cidadeUf)) {
				List<Cobertura> coberturaLista = new ArrayList<Cobertura>();
				coberturaLista.add(cob);
				coberturaMap.put(cidadeUf, coberturaLista);
			} else {
				coberturaMap.get(cidadeUf).add(cob);
			}
		}
		
		return coberturaMap;
	}
}
