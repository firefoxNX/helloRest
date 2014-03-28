package com.vineetb.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vineetb.rest.domain.Foo;
import com.vineetb.rest.domain.IFooService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/foo")
public class FooController {

	private static final Logger logger = LoggerFactory.getLogger(FooController.class);

	@Autowired
	private IFooService fooService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Foo> getAll() {
		return fooService.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Foo> getById(@PathVariable Long id) {
		Foo foo = fooService.getById(id);
		if (foo == null) {
			return new ResponseEntity<Foo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Foo>(foo, HttpStatus.FOUND);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Foo> create(@RequestBody Foo foo) {
		Foo outFoo = fooService.create(foo);
		return new ResponseEntity<Foo>(outFoo, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Foo> delete(@PathVariable Long id) {
		if (fooService.deleteById(id)) {
			return new ResponseEntity<Foo>(HttpStatus.OK);
		}
		return new ResponseEntity<Foo>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Foo> update(@PathVariable Long id, @RequestBody Foo foo){
		Foo outfoo = fooService.update(foo);
		if (outfoo!=null) {
			return new ResponseEntity<Foo>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Foo>(HttpStatus.OK);
	}

}
