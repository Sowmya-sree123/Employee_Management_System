package com.employee.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.employee")
@EnableJpaRepositories("com.employee.Repository")
public class EmployeeConfiguration 
{
	@Bean //it is used to convert the object to the bean
	public InternalResourceViewResolver viewResolverBean() //viewResolverBean is the interface 
	{
		System.out.println("Sending Request for path of the page");
		InternalResourceViewResolver internalResouceViewResolver=new InternalResourceViewResolver(); //InternalResouceViewResolver is the class
		internalResouceViewResolver.setPrefix("/");
		internalResouceViewResolver.setSuffix(".jsp");
		return internalResouceViewResolver;
	}
	@Bean(name="entityManagerFactory")
	public LocalEntityManagerFactoryBean localEntityManagerFactoryBean()
	{
		LocalEntityManagerFactoryBean localEntityManagerFactoryBean=new LocalEntityManagerFactoryBean();
		localEntityManagerFactoryBean.setPersistenceUnitName("Employee_Management_System_By_Using_Spring_WEB_MVC");
		return localEntityManagerFactoryBean;
	}
	@Bean(name="transactionManager")
    public JpaTransactionManager JpaTransactionManagerBean(EntityManagerFactory emf)
    {
    	JpaTransactionManager jpaTransactionManager=new JpaTransactionManager();
    	jpaTransactionManager.setEntityManagerFactory(emf);
    	return jpaTransactionManager;	
    }	
}
