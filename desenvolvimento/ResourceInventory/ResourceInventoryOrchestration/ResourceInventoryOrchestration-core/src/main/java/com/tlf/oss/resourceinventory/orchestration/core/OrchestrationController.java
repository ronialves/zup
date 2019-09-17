package com.tlf.oss.resourceinventory.orchestration.core;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.tlf.oss.common.client.RestClient;
import com.tlf.oss.common.client.RestClient.Method;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.exception.OSSException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.properties.WeblogicConfiguration;
import com.tlf.oss.resourceinventory.orchestration.core.entity.Action;
import com.tlf.oss.resourceinventory.orchestration.core.entity.Execution;
import com.tlf.oss.resourceinventory.orchestration.core.entity.ResourceDoUndo;
import com.tlf.oss.resourceinventory.orchestration.core.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.orchestration.core.rules.ExecutionRules;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@RequestScoped
@Logged
public class OrchestrationController {
	
	private static final WeblogicConfiguration WCFG = WeblogicConfiguration.getInstance();

	@Inject
	private OSSLogger logger;
	
	@Inject
	private Header header;
	
	@Inject
	private ExecutionRules executionRules;
	
	@SuppressWarnings("unchecked")
	public <T> T execute(String version, String action, Object entity) throws Exception {
		
		Action resourceAction = executionRules.getAction(version, action, entity);
		
		Class<?> expectedReturnType = Class.forName(resourceAction.getClassName());

		if (!expectedReturnType.equals(entity.getClass())) {
			throw new OSSBusinessException(ExceptionInfoEnum.RIO_004.getDescription(),ExceptionInfoEnum.RIO_004.getCode(), "O objeto de entrada [" 
					+ entity.getClass().getName() + "] é incompativel com a classe definida nas regras [" + resourceAction.getClassName() + "]");
		}
		
		Queue<Execution> doExecution = new LinkedList<>();
		
		for (Execution execution : resourceAction.getExecution()) {
			doExecution.offer(execution);
		}
		
		return (T) execute(doExecution, entity, expectedReturnType);
	}
	
	private Object execute(Queue<Execution> doExecution, Object entity, Class<?> expectedReturnType) throws Exception {
		logger.log(OSSLogger.INFO, "Executando orquestração");
		
		/** The undo execution. */
		Stack<Execution> undoExecution = new Stack<>();

		Exception error = null;
		
		for (Execution execution : doExecution) {
			try {
				Response response = callService(execution.getApplication(), execution.getVersion(), execution.getDoExecution(), entity);
				
				//Valida se é uma parada na execução da orquestração
				if (response.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
					return expectedReturnType.newInstance();
				}
				
				if (!RIConstants.DELETE.equals(execution.getDoExecution().getHttp_verb())) {
					entity = response.readEntity(expectedReturnType);
					
					if (entity == null) {
						error = new OSSBusinessException(ExceptionInfoEnum.RIO_004.getDescription(),ExceptionInfoEnum.RIO_004.getCode(), 
								"Não foi encontrado o objeto do tipo " + expectedReturnType.getName() + " no retorno da API.");
						throw error;
					}
				}
				
				undoExecution.push(execution);
			} catch (Exception e) {
				logger.error("Erro ao realizar orquestração", e);
				rollback(undoExecution, entity);
				
				if (error != null) {
					throw error;
				}
				if (OSSException.class.isInstance(e) || OSSBusinessException.class.isInstance(e)) {	
						
					throw e;
				}
				
				throw new OSSException("Erro na orquestração", e.getMessage());
			}
		}

		return entity;
	}

	private void rollback(Stack<Execution> undoExecution, Object entity) {
		logger.log(OSSLogger.INFO, "Executando rollback da orquestração");

		for (Execution execution : undoExecution) {
			try {
				if (execution.getUndoExecution() == null) {
					logger.log(OSSLogger.INFO, "Sem definição de rollback para a execution " + execution);
					continue;
				}
				
				callService(execution.getApplication(), execution.getVersion(), execution.getUndoExecution(), entity);
			} catch (Exception e) {
				logger.error("Erro ao realizar rollback da orquestração", e);
			}
		}
	}
	
	private Response callService(String application, String version, ResourceDoUndo resourceDoUndo, Object entity) throws OSSBusinessException {
		String url = new PathBuilder()
							.setProtocol("http://")
							//.setNode(WCFG.getCurrentNodeName())
							.setNode("localhost")
							.setPort(WCFG.getCurrentPort())
							.setApplication(application)
							.setVersion(version)
							.setPath(resourceDoUndo.getPath())
							.toString();
		
		RestClient.Builder builder = RestClient.Builder.newBuilder(logger, header).target(url);
		
		if (RIConstants.POST.equals(resourceDoUndo.getHttp_verb())) {
			builder = builder.method(Method.Post);
		} else if (RIConstants.PUT.equals(resourceDoUndo.getHttp_verb())) {
			builder = builder.method(Method.Put);
		} else if (RIConstants.DELETE.equals(resourceDoUndo.getHttp_verb())) {
			builder = builder.method(Method.Delete);
		} else if (RIConstants.GET.equals(resourceDoUndo.getHttp_verb())) {
			builder = builder.method(Method.Get);
		}
		
		return builder.entity(entity).build().callService(Response.class);
	}
}