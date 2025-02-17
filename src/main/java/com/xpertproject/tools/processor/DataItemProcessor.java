package com.xpertproject.tools.processor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;

import com.xpertproject.tools.domain.Data;
import com.xpertproject.tools.domain.TransformedData;

public class DataItemProcessor implements ItemProcessor<Data,TransformedData>{

	@Override
	public TransformedData process(Data data) throws Exception {
		
		System.out.println("Trnsforming customer : " + data.getFirstName() + " " + data.getLastName());
		// TODO Auto-generated method stub
		if(data.getFirstName().isEmpty() && data.getLastName().isEmpty())return null;
		String ph1 = data.getPhoneNumber();
		String ph2 = data.getPhoneNumber2();
		
		
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
		
		TransformedData transformedData = new TransformedData();
		
		Date inscriptionDate = null;
		
		try {
			sdf.parse(data.getInscriptionDate());
		}catch (Exception e) {
			System.out.println("Impossible to parse inscriptionDate : " + e.getMessage());
		}
		
		Integer duration = 0;
		
		try {
			duration=Integer.parseInt(data.getDuration());
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
			amount=Double.parseDouble(data.getAmount());
		}catch (Exception e) {
			System.out.println("Impossible to parse amount : " + e.getMessage());
		}
		
		try {
			account1=Double.parseDouble(data.getAccount1());
		}catch (Exception e) {
			System.out.println("Impossible to parse account1 : " + e.getMessage());
		}
		
		try {
			solde1=Double.parseDouble(data.getSolde1());
		}catch (Exception e) {
			System.out.println("Impossible to parse solde1 : " + e.getMessage());
		}
		
		try {
			account2=Double.parseDouble(data.getAccount2());
		}catch (Exception e) {
			System.out.println("Impossible to parse account2 : " + e.getMessage());
		}
		
		try {
			solde2=Double.parseDouble(data.getSolde2());
		}catch (Exception e) {
			System.out.println("Impossible to parse solde2 : " + e.getMessage());
		}
		
		try {
			account3=Double.parseDouble(data.getAccount3());
		}catch (Exception e) {
			System.out.println("Impossible to parse account3 : " + e.getMessage());
		}
		
		try {
			solde3=Double.parseDouble(data.getSolde3());
		}catch (Exception e) {
			System.out.println("Impossible to parse solde3 : " + e.getMessage());
		}
		
		transformedData.setFirstName(data.getFirstName());
		transformedData.setLastName(data.getLastName());
		transformedData.setAddress(data.getAddress());
		transformedData.setCity(data.getCity());
		transformedData.setPhoneNumber(ph1);;
		transformedData.setPhoneNumber2(ph2);
		transformedData.setCourse(data.getCourse());
		transformedData.setInscriptionDate(inscriptionDate);
		transformedData.setDuration(duration);
		transformedData.setEndDate(null);
		transformedData.setAmount(amount);
		transformedData.setAccount1(account1);
		transformedData.setSolde1(solde1);
		transformedData.setAccount2(account2);
		transformedData.setSolde2(solde2);
		transformedData.setAccount3(account3);
		transformedData.setSolde3(solde3);
		transformedData.setSoldItems("");
		transformedData.setEmail(data.getEmail());
		
		return transformedData;
	}

}
