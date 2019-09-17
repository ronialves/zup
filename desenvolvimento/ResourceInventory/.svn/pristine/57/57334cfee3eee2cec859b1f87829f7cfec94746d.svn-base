package com.tlf.oss.resourceinventorySCQLA.bo.test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.tlf.oss.resourceinventory.commons.parse.JsonBase;
import com.tlf.oss.resourceinventory.commons.to.BrazilianUrbanPropertyAddressTo;
import com.tlf.oss.resourceinventory.scqla.bo.impl.ResourceInventoryRetrievalBoImpl;
import com.tlf.oss.resourceinventory.scqla.to.PhysicalResourceAvailabilityOutTo;

public class ResourceInventoryRetrievalBoTest extends JsonBase {

	@Category(IntegrationTest.class)
	
	
	
	@Test
	public void physicalResourceAvailabilityTest() throws Exception {

		BrazilianUrbanPropertyAddressTo resourceAddressTo = new BrazilianUrbanPropertyAddressTo();
		
		FileReader fr = new FileReader("src/test/resources/JsonFile/resourceInventoryRetrievalBoTestJson.json");

		BufferedReader br = new BufferedReader(fr);
		String jsonString = null;

		while (br.ready()) {
			if (jsonString == null) {
				jsonString = br.readLine();
			} else {
				jsonString = jsonString + br.readLine();
			}
		}
		br.close();

		if (jsonString != null && jsonString.trim() != "") {

			resourceAddressTo = (BrazilianUrbanPropertyAddressTo) parserJSon2Objetc(
					BrazilianUrbanPropertyAddressTo.class, jsonString);
		}

		ResourceInventoryRetrievalBoImpl resourceInventoryRetrievalBoImpl = new ResourceInventoryRetrievalBoImpl();

		PhysicalResourceAvailabilityOutTo result = new PhysicalResourceAvailabilityOutTo();
		result = resourceInventoryRetrievalBoImpl.physicalResourceAvailability(resourceAddressTo);
		assertTrue(result.getCodeError() == 0);
	}
}
