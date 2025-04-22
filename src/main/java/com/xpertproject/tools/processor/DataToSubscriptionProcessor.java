package com.xpertproject.tools.processor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;

import com.xpertproject.tools.domain.Subscription;
import com.xpertproject.tools.model.DataDto;

public class DataToSubscriptionProcessor implements ItemProcessor<DataDto, Subscription>{

	@Override
	public Subscription process(DataDto data) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(data.toString());
		
		Subscription subscription = new Subscription();
		
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yy");
		if(data.getInscriptionDate()!=null&&!data.getInscriptionDate().isEmpty()&&!data.getInscriptionDate().isBlank()) {
			Date inscriptionDate = inputFormat.parse(data.getInscriptionDate());
			subscription.setSubscriptionDate(inscriptionDate);
		}else {
			subscription.setSubscriptionDate(null);
		}
		
		
		subscription.setCustomerId(data.getId());
		
		subscription.setAmount(data.getAmount());
		if("TAEKWONDO".equals(data.getCourse().replace(" ", ""))) {
			subscription.setTaekwondo(true);
		}else {
			subscription.setTaekwondo(false);
		}
			
			
		if("KICKBOXING".equals(data.getCourse().replace(" ", ""))) {
			subscription.setKickboxing(true);
		}else {
			subscription.setKickboxing(false);
		}
			
		if("TAEKIBODO".equals(data.getCourse().replace(" ", ""))) {
			subscription.setTaekibodo(true);
		}else {
			subscription.setTaekibodo(false);
		}
		
		subscription.setDuration(data.getDuration());
		return subscription;
	}

}
