package com.admiral.employee.onboarding.interceptor.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.admiral.employee.onboarding.interceptor.MyInterceptor;

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private MyInterceptor myInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(myInterceptor);
	}
	
	
}
