package com.sebas.taller.service.person;


import com.sebas.taller.model.person.Person;

public interface PersonService {

	public Person save(Person p);
	public Person update(Person p);
	public void delete (Person p);
	public Iterable<Person> findAll();
	public Person findById(Integer id);
}
