package com.xpertproject.tools.processor;

import org.springframework.batch.item.ItemProcessor;

import com.xpertproject.tools.domain.Customer;
import com.xpertproject.tools.domain.TransformedData;
import com.xpertproject.tools.model.DataDto;

public class DataToCustomerItemProcessor implements ItemProcessor<DataDto, Customer> {

	@Override
	public Customer process(DataDto data) throws Exception {
		
		Customer customer = new Customer();
		
		customer.setId(data.getId());
		customer.setFirstname(data.getFirstName());
		customer.setLastname(data.getLastName());
		customer.setAddress(data.getAddress());
		customer.setCity(data.getCity());
		customer.setPhonenumber(data.getPhoneNumber());
		customer.setEmail(data.getEmail());
		
		
		return customer;
	}

}
