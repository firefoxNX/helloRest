package com.vineetb.rest;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.vineetb.rest.config.AppConfig;
import com.vineetb.rest.config.PersistenceConfig;
import com.vineetb.rest.domain.Foo;
import com.vineetb.rest.domain.IFooService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = {AppConfig.class, PersistenceConfig.class}, loader = AnnotationConfigContextLoader.class )
public class FooServiceTest {
	
	@Autowired
	private IFooService fooService;

	@Test
	public void testGetAll() {
		for (Foo foo : fooService.getAll()) {
			System.out.println(foo);
		}
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

}
