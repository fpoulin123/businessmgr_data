package com.xpertproject.tools.processor;

import java.text.SimpleDateFormat;

import org.springframework.batch.item.ItemProcessor;

import com.xpertproject.tools.domain.Payment;
import com.xpertproject.tools.domain.Subscription;
import com.xpertproject.tools.model.DataDto;

public class DataToPaymentAccount1Processor implements ItemProcessor<DataDto, Payment>{

	@Override
	public Payment process(DataDto data) throws Exception {
		
		if(data.getAccount1()!=null) {
			
			System.out.println("Payment: " + data.getFirstName() + " " + data.getLastName() + "; " + data.getId());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
			Payment payment = new Payment();
			payment.setSubscriptionId(data.getId());
			payment.setPaymentDate(sdf.parse(data.getInscriptionDate()));
			payment.setAmount(data.getAccount1());
			return payment;
		}
		
		return null;
	}

}
