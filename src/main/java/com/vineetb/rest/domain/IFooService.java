package com.vineetb.rest.domain;

import java.util.List;

public interface IFooService {
	
	public List<Foo> getAll();
	
	public Foo create(Foo foo);
	
	public Foo getById(Long id);

	public boolean deleteById(Long id);

}
