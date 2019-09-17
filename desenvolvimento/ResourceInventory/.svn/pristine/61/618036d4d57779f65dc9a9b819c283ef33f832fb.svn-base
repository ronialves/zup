package com.tlf.oss.resourceinventory.test;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.Test;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.orchestration.core.entity.Action;
import com.tlf.oss.resourceinventory.orchestration.core.rules.ExecutionRules;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public abstract class AbstractExecutionRules {
	
	@Documented
	@Retention(RUNTIME)
	@Target(TYPE)
	public @interface ExecutionTest {
		String action();
		String version();
		String result();
	}

	@Test
	public void run() throws Exception {
		ExecutionRules execRules = new ExecutionRules();
		OSSLogger logger = new OSSLogger();
		execRules.setLogger(logger);
		
		ExecutionTest test = getClass().getAnnotation(ExecutionTest.class);
		
		if (test == null) {
			fail("Não foi encontrado a anotação @ExecutionTest na classe " + getClass().getName()); 
		}
		
		try {
			Action action = execRules.getAction(test.version(), test.action(), getEntity());
			assertNotNull("Não gerou nenhuma ação", action);
			assertTrue("Nome inválido da ação. Esperado " + test.result() + ", Retornou: " + action.getName(), action.getName().equals(test.result()));
			assertNotNull("Ação gerada (" + action.getName() + ") sem execução mapeada", action.getExecution());
			//assertTrue(action.getExecution().size() == 1);
		} catch (OSSBusinessException e) {
			fail(e.getMessage());
		}
	}
	
	protected abstract ResourceInventoryEntity getEntity();
}
