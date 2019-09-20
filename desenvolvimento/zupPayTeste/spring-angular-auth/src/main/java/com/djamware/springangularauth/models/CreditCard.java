package com.djamware.springangularauth.models;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "creditcard")
public class CreditCard {

	@Id
    private String id;
    //@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String cardNumber;
    
    private BigDecimal cardLimit; 
    
    private Integer cardAuthorizationCode;
    
    private Date cardExpirationDate;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public BigDecimal getCardLimit() {
		return cardLimit;
	}
	public void setCardLimit(BigDecimal cardLimit) {
		this.cardLimit = cardLimit;
	}
	public Integer getCardAuthorizationCode() {
		return cardAuthorizationCode;
	}
	public void setCardAuthorizationCode(Integer cardAuthorizationCode) {
		this.cardAuthorizationCode = cardAuthorizationCode;
	}
	public Date getCardExpirationDate() {
		return cardExpirationDate;
	}
	public void setCardExpirationDate(Date cardExpirationDate) {
		this.cardExpirationDate = cardExpirationDate;
	}
	    
}