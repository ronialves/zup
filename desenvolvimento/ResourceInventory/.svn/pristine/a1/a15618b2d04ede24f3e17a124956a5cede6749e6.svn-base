package com.tlf.oss.resourceinventory.orchestration.core.rules;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.exception.OSSException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.orchestration.core.entity.Action;
import com.tlf.oss.resourceinventory.orchestration.core.entity.Operation;
import com.tlf.oss.resourceinventory.orchestration.core.entity.ResourceJson;
import com.tlf.oss.resourceinventory.orchestration.core.entity.Version;
import com.tlf.oss.resourceinventory.orchestration.core.enums.ExceptionInfoEnum;

@RequestScoped
@Logged
public class ExecutionRules {

	@Inject
	private OSSLogger logger;

	public Action getAction(String version, String action, Object entity) throws OSSBusinessException {
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kContainer = kieServices.getKieClasspathContainer( KieContainer.class.getClassLoader() );
		StatelessKieSession kSession = kContainer.newStatelessKieSession("ExecutionKS");
		
		List<Command<?>> commands = new ArrayList<>();
		commands.add(CommandFactory.newInsert(logger));
		commands.add(CommandFactory.newInsert(new Operation(action.toUpperCase())));
		commands.add(CommandFactory.newInsert(new Version(version)));
		commands.add(CommandFactory.newInsert(entity));
		commands.add(CommandFactory.newInsertElements(getResources()));
		commands.add(CommandFactory.newFireAllRules());
		commands.add(CommandFactory.newQuery("getAction", "getAction"));

		ExecutionResults result = kSession.execute(CommandFactory.newBatchExecution(commands));
		QueryResults queryResult = QueryResults.class.cast(result.getValue("getAction"));

		Action resourceAction = null;
		for (QueryResultsRow row : queryResult) {
			resourceAction = (Action) row.get("action");
		}

		if (resourceAction == null) {
			throw new OSSBusinessException(ExceptionInfoEnum.RIO_006.getDescription(),ExceptionInfoEnum.RIO_006.getCode(), 
					"Não foi encontrado nenhuma action a ser executada");

		}

		return resourceAction;
	}

	private List<ResourceJson> getResources() {
		try {
			InputStream inputStream = ExecutionRules.class.getClassLoader().getResourceAsStream("resources.json");
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

			Gson gson = new Gson();
			TypeToken<List<ResourceJson>> token = new TypeToken<List<ResourceJson>>() {
			};
			return gson.fromJson(br, token.getType());
		} catch (Exception e) {
			throw new OSSException("Erro ao ler arquivo Resources.Json", e.getLocalizedMessage());
		}

	}

	public void setLogger(OSSLogger logger) {
		this.logger = logger;
	}
}
