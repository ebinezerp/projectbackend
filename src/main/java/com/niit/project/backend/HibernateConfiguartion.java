package com.niit.project.backend;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
public class HibernateConfiguartion {

		@Bean
	    public DataSource getDataSource()
	    {
	    	BasicDataSource dataSource=new BasicDataSource();
	    	dataSource.setDriverClassName("org.h2.Driver");
	    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecomproject");
	    	dataSource.setUsername("niit");
	    	dataSource.setPassword("niit");
	    	
	    	return dataSource;
	    }
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource)
		{
			LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
			builder.scanPackages("com.niit.project.backend");
			builder.setProperties(getProperties());
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
}
