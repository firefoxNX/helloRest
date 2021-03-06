package com.vineetb.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.vineetb.rest.config.AppConfig;
import com.vineetb.rest.config.PersistenceConfig;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = {AppConfig.class, PersistenceConfig.class}, loader = AnnotationConfigContextLoader.class )
public class SpringTest {

	@Test
	public void whenSpringContextIsInstantiated_thenNoExceptions() {
		
	}

}
