package com.djamware.springangularauth.client.rest;

import java.util.HashMap;

import org.springframework.web.client.RestTemplate;

import com.djamware.springangularauth.models.PaymantInfo;
import com.djamware.springangularauth.models.User;

public class ProcessPaymentClient {
	
	public void processPaymentForApi(User user,PaymantInfo paymantInfo)
	{
	    final String uri = "http://apiforprocesspayment:8080/springrestexample/paymentprocess/{id}";
	     
	    HashMap<String,String> params = new HashMap<String, String>();
	    params.put("id", user.getId());
	     
	    RestTemplate restTemplate = new RestTemplate();
	    PaymantInfo result = restTemplate.getForObject(uri, PaymantInfo.class, params);
	     
	    System.out.println(result);
	}
}
