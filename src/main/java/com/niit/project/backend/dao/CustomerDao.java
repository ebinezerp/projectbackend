package com.niit.project.backend.dao;

import org.springframework.stereotype.Component;

import com.niit.project.backend.model.Customer;
@Component
public interface CustomerDao {
	
	boolean  addCustomer(Customer customer);

}
