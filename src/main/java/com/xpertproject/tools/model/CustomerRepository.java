package com.xpertproject.tools.model;

import java.util.List;

import org.springframework.data.repository.Repository;


public interface CustomerRepository extends Repository<Customer, Long> {

	Customer save(Customer customer);

	Customer findById(Long id);
	
	List<Customer> findAll();
	
}
