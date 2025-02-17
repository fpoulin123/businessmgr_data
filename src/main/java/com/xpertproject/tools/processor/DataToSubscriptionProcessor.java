package com.xpertproject.tools.processor;

import org.springframework.batch.item.ItemProcessor;

import com.xpertproject.tools.domain.Subscription;
import com.xpertproject.tools.model.DataDto;

public class DataToSubscriptionProcessor implements ItemProcessor<DataDto, Subscription>{

	@Override
	public Subscription process(DataDto data) throws Exception {
		// TODO Auto-generated method stub
		
		Subscription subscription = new Subscription();
		subscription.setCustomerId(data.getId());
		subscription.setInscriptionDate(data.getInscriptionDate());
		subscription.setAmount(data.getAmount());
		if("TAEKWONDO".equals(data.getCourse().replace(" ", ""))) {
			subscription.setTaekwondo(true);
		}else if("KICKBOXING".equals(data.getCourse().replace(" ", ""))) {
			subscription.setKickboxing(true);
		}else if("TAEKIBODO".equals(data.getCourse().replace(" ", ""))) {
			subscription.setTaekibodo(true);
		}
		subscription.setDuration(data.getDuration());
		return subscription;
	}

}
