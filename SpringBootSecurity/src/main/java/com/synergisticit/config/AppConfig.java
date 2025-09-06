/*
package com.synergisticit.config;

import java.util.Properties;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class AppConfig {
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/securitydb?useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;

		
	}
	
	 public Properties properties() {
		 Properties properties = new Properties();
		 properties.setProperty("hibernate.hbm2ddl.auto", "update");
		 properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		 return properties;
	 }
	
	 @Bean
	 @Primary
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

	         LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	         entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	         entityManagerFactoryBean.setDataSource(dataSource());
	         entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	         entityManagerFactoryBean.setPackagesToScan("com.synergisticit");             
	         entityManagerFactoryBean.setJpaProperties(properties());

	         return entityManagerFactoryBean;
	     }

}
 */