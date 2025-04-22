package com.xpertproject.tools.domain;

import java.util.Date;

public class Payment {
	
	public Long id;
	
	public Long subscriptionId;
	
	public Double amount;
	
	public Date paymentDate;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Long id, Long subscriptionId, Double amount, Date paymentDate) {
		super();
		this.id = id;
		this.subscriptionId = subscriptionId;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	

}
