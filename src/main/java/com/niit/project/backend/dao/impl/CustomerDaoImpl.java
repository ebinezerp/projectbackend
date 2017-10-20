package com.niit.project.backend.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project.backend.dao.CustomerDao;
import com.niit.project.backend.model.Customer;
@Repository("customerDao")
@Transactional
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().save(customer);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

}
