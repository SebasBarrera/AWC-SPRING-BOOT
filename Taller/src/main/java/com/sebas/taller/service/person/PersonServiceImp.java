package com.sebas.taller.service.person;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.taller.dao.interfaces.EmployeeDao;
import com.sebas.taller.dao.interfaces.PersonDao;
import com.sebas.taller.model.hr.Employee;
import com.sebas.taller.model.person.Person;

@Service
@Transactional
public class PersonServiceImp implements PersonService{

	
	private PersonDao personDao;
	private EmployeeDao employeeDao;
	
	@Autowired
	public PersonServiceImp(PersonDao personDao, EmployeeDao employeeDao) {
		this.personDao = personDao;
		this.employeeDao = employeeDao;
	}
	
	@Override
	public Person save(Person p) {
		Employee e = new Employee();
		personDao.save(p);
		employeeDao.save(e);
		return personDao.findById(p.getBusinessentityid());
	}

	@Override
	public Person update(Person p) {
		return personDao.update(p);
	}

	@Override
	public void delete(Person p) {
		personDao.delete(p);
		employeeDao.delete(employeeDao.findById(p.getBusinessentityid()));
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
