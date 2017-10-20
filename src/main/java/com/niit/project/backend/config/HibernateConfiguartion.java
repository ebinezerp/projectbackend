package com.niit.project.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit.project")
public class HibernateConfiguartion {
	// datasource bean is created
		@Bean
	    public DataSource getDataSource()
	    {
	    	BasicDataSource dataSource=new BasicDataSource();
	    	dataSource.setDriverClassName("org.h2.Driver");
	    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecommerce");
	    	dataSource.setUsername("project");
	    	dataSource.setPassword("project");
	    	
	    	return dataSource;
	    }
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource)
		{
			LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
			builder.scanPackages("com.niit.project");
			builder.addProperties(getProperties());
			return builder.buildSessionFactory();
		}
	    
		
		
		Properties getProperties()
		{
			Properties properties=new Properties();
			properties.put("hibernate.dialect","org.h2.dialect.H2Dialect");
			properties.put("hibernate.format_sql", "true");
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.hbm2ddl.auto", "update");
			
			return properties;
			
		}
		
		@Bean
		public HibernateTransactionManager getHibernateTrasactionManager()
		{
			return new HibernateTransactionManager(getSessionFactory(getDataSource()));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
