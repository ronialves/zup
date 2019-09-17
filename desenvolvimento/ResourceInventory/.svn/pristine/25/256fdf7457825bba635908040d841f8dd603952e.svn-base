package com.tlf.oss.resourceinventory.granite.core;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveUdaEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveConfigUDADao;
@Startup
@DependsOn("RetrieveConfigUDADao")
public class LoadConfigMemoryController {

	@Inject
	RetrieveConfigUDADao rdao;

	public List<RetrieveUdaEntity> mapResult = new ArrayList<RetrieveUdaEntity>();

	@PostConstruct
	public void getRetrieveListUDA() {
		//Validação para saber se é MSAN
		mapResult = rdao.getRetrieveUDAConfig();

	}

	public List<RetrieveUdaEntity> getMapResult() {
		return mapResult;
	}

	public void setMapResult(List<RetrieveUdaEntity> mapResult) {
		this.mapResult = mapResult;
	}



}
