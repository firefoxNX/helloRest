package com.vineetb.rest.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class FooService implements IFooService {

	private ArrayList<Foo> foos = new ArrayList<Foo>();

	public FooService() {
		for (int i = 0; i < 10; i++) {
			Foo foo = new Foo();
			foo.setId(100L + i);
			foo.setBar("100" + i);
			foos.add(foo);
		}

	}

	@Override
	public List<Foo> getAll() {
		return foos;
	}

	@Override
	public Foo create(Foo inFoo) {
		Foo cfoo = new Foo();
		Random random = new Random();
		int rand = random.nextInt(200);
		cfoo.setId(new Long(rand));
		cfoo.setBar(inFoo.getBar());
		foos.add(cfoo);
		return cfoo;
	}

	@Override
	public Foo getById(Long id) {
		for (Foo foo : foos) {
			if (foo.getId().equals(id)) {
				return foo;
			}
		}
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		Foo dfoo = getById(id);
		if (dfoo != null) {
			foos.remove(dfoo);
			return true;
		}
		return false;
	}

}
