package com.xpertproject.tools.processor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.hibernate.grammars.hql.HqlParser.SubstringFunctionContext;
import org.springframework.batch.item.ItemProcessor;

import com.xpertproject.tools.domain.Data;
import com.xpertproject.tools.domain.TransformedData;

public class DataItemProcessor implements ItemProcessor<Data,TransformedData>{

	@Override
	public TransformedData process(Data data) throws Exception {
		
		System.out.println("Transforming customer : " + data.getFirstName() + " " + data.getLastName());
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
			inscriptionDate = sdf.parse(data.getInscriptionDate());
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
			amount=Double.parseDouble(data.getAmount().replace(" ", "").replace("$",""));
		}catch (Exception e) {
			System.out.println("Impossible to parse amount : " + e.getMessage());
		}
		
		try {
			account1=Double.parseDouble(data.getAccount1().replace(" ", "").replace("$",""));
		}catch (Exception e) {
			System.out.println("Impossible to parse account1 : " + e.getMessage());
		}
		
		try {
			solde1=Double.parseDouble(data.getSolde1().replace(" ", "").replace("$",""));
		}catch (Exception e) {
			System.out.println("Impossible to parse solde1 : " + e.getMessage());
		}
		
		try {
			account2=Double.parseDouble(data.getAccount2().replace(" ", "").replace("$",""));
		}catch (Exception e) {
			System.out.println("Impossible to parse account2 : " + e.getMessage());
		}
		
		try {
			solde2=Double.parseDouble(data.getSolde2().replace(" ", "").replace("$",""));
		}catch (Exception e) {
			System.out.println("Impossible to parse solde2 : " + e.getMessage());
		}
		
		try {
			account3=Double.parseDouble(data.getAccount3().replace(" ", "").replace("$",""));
		}catch (Exception e) {
			System.out.println("Impossible to parse account3 : " + e.getMessage());
		}
		
		try {
			solde3=Double.parseDouble(data.getSolde3().replace(" ", "").replace("$",""));
		}catch (Exception e) {
			System.out.println("Impossible to parse solde3 : " + e.getMessage());
		}
		
		transformedData.setFirstName(formatFirstName(data.getFirstName()));
		transformedData.setLastName(data.getLastName().toUpperCase());
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
	
	public String formatFirstName(String firstName) {
		if(firstName!=null&&!firstName.isEmpty()&&!firstName.isBlank()) {
			 String majPart = firstName.substring(0,1);
			 String minPart = firstName.substring(1, firstName.length()-1);
			
			 return majPart.toUpperCase() + minPart.toLowerCase();
		}else {
			return "";
		}
		
	}

}
