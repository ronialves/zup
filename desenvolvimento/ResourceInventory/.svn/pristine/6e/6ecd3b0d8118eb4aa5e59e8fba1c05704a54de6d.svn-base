package com.tlf.oss.resourceinventory.cpe.rules;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.command.CommandFactory;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RequestScoped
@Logged
public class ExecutionRules {

	@Inject
	private OSSLogger logger;

	private static final String QUERY_CATEGORIA = "defineNomeCategoria";

	public String defineNomeCategoria(final ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Disparando regras para definição da categoria do equipamento CPE...");

		final KieServices ks = KieServices.Factory.get();
		final KieContainer kContainer = ks.getKieClasspathContainer();
		final StatelessKieSession kSession = kContainer.newStatelessKieSession("ExecutionKS");

		final TipoRfs tipoRfs = TipoRfs.fromRoiName(EntityExtractor.extractResourceOrderItemName(entity));

		final List<Command<?>> commands = new ArrayList<>();
		commands.add(CommandFactory.newInsert(logger));
		commands.add(CommandFactory.newInsert(entity));

		commands.add(CommandFactory.newInsert(tipoRfs.getTipoRfs()));
		commands.add(CommandFactory.newInsert(new Categoria()));

		commands.add(CommandFactory.newFireAllRules());
		commands.add(CommandFactory.newQuery(QUERY_CATEGORIA, QUERY_CATEGORIA));
		
		Categoria categoria = null;
		ExecutionResults result = kSession.execute(CommandFactory.newBatchExecution(commands));
		QueryResults queryResult = QueryResults.class.cast(result.getValue(QUERY_CATEGORIA));

		for (QueryResultsRow row : queryResult) {
			if (null != row.get("tipoRfs")) {
				categoria = (Categoria) row.get("tipoRfs");

				logger.log(OSSLogger.INFO, "Categoria definida: " + categoria.getResult());
			}
		}

		if (categoria == null || categoria.getResult() == null || categoria.getResult().isEmpty()) {
			if (TipoRfs.ACCESS.equals(tipoRfs) ||
				TipoRfs.VOIP.equals(tipoRfs)) {
				categoria = new Categoria();
				categoria.setResult(CpeConstants.HGU);
			} else {
    			throw new OSSBusinessException(FalloutCode.RICPE_007.getDescription(),
    										   FalloutCode.RICPE_007.getValue(),
    		            					   "Não foi encontrada nenhuma categoria de dispositivo.");
			}
		}

		return categoria.getResult();
	}
}
