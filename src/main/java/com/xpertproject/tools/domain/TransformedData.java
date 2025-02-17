package com.xpertproject.tools.domain;

import java.util.Date;


public class TransformedData {

	String firstName;
	String lastName;
	String address; 
	String city; 
	String phoneNumber;
	String phoneNumber2;
	String course;
	Date inscriptionDate;
	Integer duration;
	Date endDate;
	Double amount;
	Double account1;
	Double solde1;
	Double account2; 
	Double solde2;
	Double account3;
	Double solde3;
	String soldItems;
	String email;
	
	public TransformedData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransformedData(String firstName, String lastName, String address, String city, String phoneNumber,
			String phoneNumber2, String course, Date inscriptionDate, Integer duration, Date endDate, Double amount,
			Double account1, Double solde1, Double account2, Double solde2, Double account3, Double solde3,
			String soldItems, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.phoneNumber2 = phoneNumber2;
		this.course = course;
		this.inscriptionDate = inscriptionDate;
		this.duration = duration;
		this.endDate = endDate;
		this.amount = amount;
		this.account1 = account1;
		this.solde1 = solde1;
		this.account2 = account2;
		this.solde2 = solde2;
		this.account3 = account3;
		this.solde3 = solde3;
		this.soldItems = soldItems;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAccount1() {
		return account1;
	}

	public void setAccount1(Double account1) {
		this.account1 = account1;
	}

	public Double getSolde1() {
		return solde1;
	}

	public void setSolde1(Double solde1) {
		this.solde1 = solde1;
	}

	public Double getAccount2() {
		return account2;
	}

	public void setAccount2(Double account2) {
		this.account2 = account2;
	}

	public Double getSolde2() {
		return solde2;
	}

	public void setSolde2(Double solde2) {
		this.solde2 = solde2;
	}

	public Double getAccount3() {
		return account3;
	}

	public void setAccount3(Double account3) {
		this.account3 = account3;
	}

	public Double getSolde3() {
		return solde3;
	}

	public void setSolde3(Double solde3) {
		this.solde3 = solde3;
	}

	public String getSoldItems() {
		return soldItems;
	}

	public void setSoldItems(String soldItems) {
		this.soldItems = soldItems;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
