package com.djamware.springangularauth.client.rest;

import java.util.HashMap;

import org.springframework.web.client.RestTemplate;

import com.djamware.springangularauth.models.User;

public class ProcessPaymentInfoUser {
	
	public void processPaymentInfoUser(User user,String paymentInformation)
	{
	    final String uri = "http://apiforpaymentinformation:8080/springrestexample/paymentprocess/{status}";
	     
	    HashMap<String,String> params = new HashMap<String, String>();
	    params.put("status", paymentInformation);
	     
	    RestTemplate restTemplate = new RestTemplate();
	    User result = restTemplate.getForObject(uri, User.class, params);
	     
	    System.out.println(result);
	}
}
