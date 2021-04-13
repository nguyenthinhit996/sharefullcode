package com.blogpost.sharefullcode;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring Database Configuration.
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.blogpost.sharefullcode.*")
public class PersistenceConfigJDBC {

	@Autowired
	PropertesConfig propertesConfig;

	
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(checkNotNull(propertesConfig.getProperty("jdbc.driverClassName")));
		dataSource.setUrl(checkNotNull(propertesConfig.getProperty("jdbc.url")));
		dataSource.setUsername(checkNotNull(propertesConfig.getProperty("jdbc.username")));
		dataSource.setPassword(checkNotNull(propertesConfig.getProperty("jdbc.password")));
		dataSource.setSchema("persitentdb");
		return dataSource;
	}

	private String checkNotNull(Object par) {
		if (par == null) {
			throw new NullPointerException("Parameter cannot be null");
		}
		return (String) par;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.blogpost.sharefullcode.model" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	     em.setJpaVendorAdapter(vendorAdapter);
//	      em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
