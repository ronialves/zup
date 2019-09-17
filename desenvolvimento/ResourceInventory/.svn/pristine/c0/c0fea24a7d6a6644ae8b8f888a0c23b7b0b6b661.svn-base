package com.tlf.oss.resourceinventory.sagre.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXB;

import org.junit.Assert;

/**
 * @author 80522126
 * 
 */
public class BaseTest {

	/**
	 * Realiza leitura de um arquivo para o objeto esperado
	 * 
	 * @param path
	 * @param type
	 * @return T
	 */
	protected <T> T loaderInput(String path, Class<T> type) {
		T retorno = JAXB.unmarshal(getClass().getResourceAsStream("/mocks/" + path), type);
		return retorno;
	}

	/**
	 * Realiza a leitura do Map que representa o output
	 * @param path
	 * @return
	 */
	protected Map<String, Object> loaderMapOutput(String path) {
		Properties properties = new Properties();
		InputStream in = getClass().getResourceAsStream("/mocks/" + path);
		try {
			properties.loadFromXML(in);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Map<String, Object> retorno = new HashMap<String, Object>();
		String r;
		for (final String name : properties.stringPropertyNames()) {
			r = properties.getProperty(name);
			if (r.isEmpty()) {
				retorno.put(name, null);
			} else {
				retorno.put(name, properties.getProperty(name));
			}
		}

		return retorno;
	}
}
