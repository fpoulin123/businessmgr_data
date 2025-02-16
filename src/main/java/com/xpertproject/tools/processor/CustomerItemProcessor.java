package com.xpertproject.tools.processor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;

import com.xpertproject.tools.domain.Customer;
import com.xpertproject.tools.domain.TransformedCustomer;

public class CustomerItemProcessor implements ItemProcessor<Customer,TransformedCustomer>{

	@Override
	public TransformedCustomer process(Customer customer) throws Exception {
		
		System.out.println("Trnsforming customer : " + customer.getFirstName() + " " + customer.getLastName());
		// TODO Auto-generated method stub
		if(customer.getFirstName().isEmpty() && customer.getLastName().isEmpty())return null;
		String ph1 = customer.getPhoneNumber();
		String ph2 = customer.getPhoneNumber2();
		
		
		if(ph2.isEmpty()||ph2.isBlank()) {
			ph1 = "514-" + ph1;
		}else {
			ph1 = ph1.replace("-", "");
			if(ph1.length()==3) {
				ph1 += "-" +ph2;
			} else {
				ph1 = ph1 + " /  " + ph2;
			}
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		TransformedCustomer transformedCustomer = new TransformedCustomer();
		
		Date inscriptionDate = null;
		
		try {
			sdf.parse(customer.getInscriptionDate());
		}catch (Exception e) {
			System.out.println("Impossible to parse inscriptionDate : " + e.getMessage());
		}
		
		Integer duration = 0;
		
		try {
			duration=Integer.parseInt(customer.getDuration());
		}catch (Exception e) {
			System.out.println("Impossible to parse duration : " + e.getMessage());
		}
		
		Double amount = 0.0;
		Double account1 = 0.0;
		Double solde1 = 0.0;
		Double account2 = 0.0;
		Double solde2 = 0.0;
		Double account3 = 0.0;
		Double solde3 = 0.0;
		
		try {
			amount=Double.parseDouble(customer.getAmount());
		}catch (Exception e) {
			System.out.println("Impossible to parse amount : " + e.getMessage());
		}
		
		try {
			account1=Double.parseDouble(customer.getAccount1());
		}catch (Exception e) {
			System.out.println("Impossible to parse account1 : " + e.getMessage());
		}
		
		try {
			solde1=Double.parseDouble(customer.getSolde1());
		}catch (Exception e) {
			System.out.println("Impossible to parse solde1 : " + e.getMessage());
		}
		
		try {
			account2=Double.parseDouble(customer.getAccount2());
		}catch (Exception e) {
			System.out.println("Impossible to parse account2 : " + e.getMessage());
		}
		
		try {
			solde2=Double.parseDouble(customer.getSolde2());
		}catch (Exception e) {
			System.out.println("Impossible to parse solde2 : " + e.getMessage());
		}
		
		try {
			account3=Double.parseDouble(customer.getAccount3());
		}catch (Exception e) {
			System.out.println("Impossible to parse account3 : " + e.getMessage());
		}
		
		try {
			solde3=Double.parseDouble(customer.getSolde3());
		}catch (Exception e) {
			System.out.println("Impossible to parse solde3 : " + e.getMessage());
		}
		
		transformedCustomer.setFirstName(customer.getFirstName());
		transformedCustomer.setLastName(customer.getLastName());
		transformedCustomer.setAddress(customer.getAddress());
		transformedCustomer.setCity(customer.getCity());
		transformedCustomer.setPhoneNumber(ph1);;
		transformedCustomer.setPhoneNumber2(ph2);
		transformedCustomer.setCourse(customer.getCourse());
		transformedCustomer.setInscriptionDate(inscriptionDate);
		transformedCustomer.setDuration(duration);
		transformedCustomer.setEndDate(null);
		transformedCustomer.setAmount(amount);
		transformedCustomer.setAccount1(account1);
		transformedCustomer.setSolde1(solde1);
		transformedCustomer.setAccount2(account2);
		transformedCustomer.setSolde2(solde2);
		transformedCustomer.setAccount3(account3);
		transformedCustomer.setSolde3(solde3);
		transformedCustomer.setSoldItems("");
		transformedCustomer.setEmail(customer.getEmail());
		
		return transformedCustomer;
	}

}
