package com.xpertproject.tools.domain;

import java.util.Date;

public class Subscription {

	Long id;
	Long customerId;
	Integer duration;
	Boolean taekwondo;
	Boolean kickboxing;
	Boolean taekibodo;
	Double amount;
	Date subscriptionDate;
	
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subscription(Long id, Long customerId, Integer duration, Boolean taekwondo, Boolean kickboxing,
			Boolean taekibodo, Double amount, Date subscriptionDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.duration = duration;
		this.taekwondo = taekwondo;
		this.kickboxing = kickboxing;
		this.taekibodo = taekibodo;
		this.amount = amount;
		this.subscriptionDate = subscriptionDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Boolean getTaekwondo() {
		return taekwondo;
	}

	public void setTaekwondo(Boolean taekwondo) {
		this.taekwondo = taekwondo;
	}

	public Boolean getKickboxing() {
		return kickboxing;
	}

	public void setKickboxing(Boolean kickboxing) {
		this.kickboxing = kickboxing;
	}

	public Boolean getTaekibodo() {
		return taekibodo;
	}

	public void setTaekibodo(Boolean taekibodo) {
		this.taekibodo = taekibodo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	
	
}
