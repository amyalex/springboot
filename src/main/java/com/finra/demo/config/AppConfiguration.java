package com.finra.demo.config;


import com.finra.demo.dao.FileUploadDaoImpl;
import com.finra.demo.dao.IFileUploadDao;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
*
* @author wolde
*/

@Configuration
@ComponentScan({ "com.finra.demo.*" })
@EnableTransactionManagement
public class AppConfiguration {
	
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	    return hemf.getSessionFactory();
	}

	/*@Autowired
	@Bean(name = "fileUploadDao")
	public IFileUploadDao getUserDao(SessionFactory sessionFactory) {
	    return new FileUploadDaoImpl(sessionFactory);
	}*/

}
