package com.sebas.taller.web.interfaces;

import com.sebas.taller.model.person.Person;

public interface PersonRestController {
	
	public Iterable<Person> findAll();
	public Person findById(Integer id);
	public void save(Person p);
	public void update(Person p, Integer id);
	public void delete(Integer id);
}
