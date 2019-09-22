package com.djamware.springangularauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djamware.springangularauth.client.rest.ProcessPaymentClient;
import com.djamware.springangularauth.client.rest.ProcessPaymentInfoUser;
import com.djamware.springangularauth.models.PaymantInfo;
import com.djamware.springangularauth.models.User;

@Service
public class UserPaymentService {    
     
	@Autowired
	private ProcessPaymentClient processPaymentClient; 
	
	@Autowired
	private ProcessPaymentInfoUser processPaymentInfoUser; 
	
    public void processPayment(User user,PaymantInfo paymantInfo) {
    	
    	//Verify amount with the amount for the creditcard
    	if(paymantInfo.getAmount().compareTo(user.getCreditCard().get(0).getCardLimit().doubleValue())>0) {
    		//User amount is less than creditcard value   		
    		//Proceed with the request to user with the no autorizathion 
    		processPaymentInfoUser.processPaymentInfoUser(user, "NOK");
    		
    	}else if(paymantInfo.getAmount().compareTo(user.getCreditCard().get(0).getCardLimit().doubleValue())<=0) {
    		//User have the amount to process the payment
    		//Proceed with the payment process sending data to the api 
    		processPaymentClient.processPaymentForApi(user,paymantInfo);
    		
    		//Procees with the information to the user 
    		processPaymentInfoUser.processPaymentInfoUser(user, "OK");
    		
    	}    	
    	
     }

 
}