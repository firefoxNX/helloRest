package com.vineetb.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.test.context.web.WebAppConfiguration;

import com.vineetb.rest.domain.FooService;
import com.vineetb.rest.domain.IFooService;

@WebAppConfiguration
public class AppConfig {
	
//	public static PropertySourcesPlaceholderConfigurer properties() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
	
	@Bean
	public IFooService createService() {
		return new FooService();
	}

}
