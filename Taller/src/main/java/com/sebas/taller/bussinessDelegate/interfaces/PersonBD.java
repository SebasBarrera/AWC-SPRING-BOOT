package com.sebas.taller.bussinessDelegate.interfaces;

import java.util.List;

import com.sebas.taller.model.person.Person;

public interface PersonBD {
	
	public List<Person> findAllPerson();
	public Person findPersonById(Integer id);
	public Person addPerson(Person p);
	public Person updatePerson(Person p);
	public void deletePerson(Integer id);

}
