package com.niit.project.backend;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project.backend.config.HibernateConfiguartion;
import com.niit.project.backend.dao.CustomerDao;
import com.niit.project.backend.model.Customer;

public class CustomerTest {
	
	
  private CustomerDao customerDao;
  private Customer customer;
  private AnnotationConfigApplicationContext annotationConfigApplicationContext;
  
     @Before
     public void init()
     {
    	 annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
    	 annotationConfigApplicationContext.scan("com.niit.project");
    	 annotationConfigApplicationContext.refresh();
    	 customerDao=(CustomerDao)annotationConfigApplicationContext.getBean("customerDao");
    	 customer=new Customer();
    	 
     }
     
     
     @Test
     public void testAddCustomer()
     {
    	 customer.setFirstName("ebinezer");
    	 customer.setLastName("perumala");
    	 assertEquals("test case of adding customer",true,customerDao.addCustomer(customer));
    	 
    	 
     }

}
