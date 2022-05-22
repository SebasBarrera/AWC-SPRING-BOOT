package com.sebas.taller.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.taller.dao.interfaces.PersonDao;
import com.sebas.taller.model.person.Person;

@Service
public class PersonServiceImp implements PersonService{

	private PersonDao personDao;
	
	@Autowired
	public PersonServiceImp(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	@Override
	public Person save(Person p) {
		return personDao.save(p);
	}

	@Override
	public Person update(Person p) {
		return personDao.update(p);
	}

	@Override
	public void delete(Person p) {
		personDao.delete(p);
	}

	@Override
	public Iterable<Person> findAll() {
		return personDao.findAll();
	}

	@Override
	public Person findById(Integer id) {
		return personDao.findById(id);
	}



}
