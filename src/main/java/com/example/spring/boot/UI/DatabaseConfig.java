package com.example.spring.boot.UI;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//This is completely optional if you didn't change the name of the properties file to 
//any other than application.properties
@PropertySource(value = { "classpath:application.properties" })
public class DatabaseConfig {

	@Autowired
	private Environment env;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public DataSource dataSource() {		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	}

	/**
	 * Declare the JPA entity manager factory.
	 */
	@Bean
	public SessionFactory sessionFactory() {
		// LocalContainerEntityManagerFactoryBean entityManagerFactory = new
		// LocalContainerEntityManagerFactoryBean();
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

		// sessionFactory.setDataSource(dataSource);

		// Classpath scanning of @Component, @Service, etc annotated class
		// entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));

		// Vendor adapter
		// HibernateJpaVendorAdapter vendorAdapter = new
		// HibernateJpaVendorAdapter();
		// entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

		// Hibernate properties
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		additionalProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
			
		sessionBuilder.addProperties(additionalProperties);
		

		//sessionFactory.setDataSource(dataSource);
		//sessionBuilder.setPackagesToScan(new String[] { "com.example.spring.boot.UI" });
		sessionBuilder.scanPackages(new String[] { "com.example.spring.boot.model" });
		//sessionFactory.setHibernateProperties(additionalProperties);

		SessionFactory sessionFactory= sessionBuilder.buildSessionFactory();
	
		return sessionFactory;
	}
	
	
	/**
	 * Declare the transaction manager.
	 */	
//	@Bean	
//	public HibernateTransactionManager transactionManager(){
//		HibernateTransactionManager txManager = new HibernateTransactionManager();
//		txManager.setSessionFactory(sessionFactory);
//		return txManager;
//		
//	}
	
	

	/**
	 * PersistenceExceptionTranslationPostProcessor is a bean post processor
	 * which adds an advisor to any bean annotated with Repository so that any
	 * platform-specific exceptions are caught and then rethrown as one Spring's
	 * unchecked data access exceptions (i.e. a subclass of
	 * DataAccessException).
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
