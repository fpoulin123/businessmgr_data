package com.xpertproject.tools.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

public class DataDto {
	
	Long id;
	
	String firstName;
	
	String lastName;
	
	String address;
	
	String city;
	
	String phoneNumber;
	
	String email;
	
	String picture;
	
	Integer duration;
	
	String course;
	
	String inscriptionDate;
	
	Double amount;
	
	Double account1;
	
	
	public DataDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataDto(Long id, String firstName, String lastName, String address, String city, String phoneNumber,
			String email, String picture, Integer duration, String course, String inscriptionDate, Double amount,
			Double account1, Double solde1, Double account2, Double solde2, Double account3, Double solde3,
			String soleItems) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.picture = picture;
		this.duration = duration;
		this.course = course;
		this.inscriptionDate = inscriptionDate;
		this.amount = amount;
		this.account1 = account1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(String inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
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

	
	public String toString() {
		return this.id.toString() + ", " + this.firstName  + ", " +  this.lastName  + ", " +  (this.inscriptionDate!=null?this.inscriptionDate.toString():"");
	}
	
}
