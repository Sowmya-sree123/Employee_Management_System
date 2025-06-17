package com.employee.config;

import org.eclipse.jdt.internal.compiler.AbstractAnnotationProcessorManager;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class EmployeeFrontEndController extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class springconfigurationclass[]= {EmployeeConfiguration.class};
		return springconfigurationclass;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		String mapping []= {"/teca34/*"};
		return mapping;
	}
}
