package com.sebas.taller.dao.interfaces;

import java.util.List;

import com.sebas.taller.model.person.Person;

public interface PersonDao {
	public Person save(Person p);
	public Person update(Person p);
	public void delete (Person p);
	public List<Person> findAll();
	public Person findById(Integer id);
	public boolean existsById(Integer id);
}
