package com.sebas.taller.service.hr;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.taller.dao.interfaces.EmployeeDao;
import com.sebas.taller.dao.interfaces.PersonDao;
import com.sebas.taller.model.hr.Employee;
import com.sebas.taller.model.person.Person;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

	
	public EmployeeDao employeeDao;
	public PersonDao personDao;
	
	@Autowired
	public EmployeeServiceImp(EmployeeDao employeeDao, PersonDao personDao) {
		this.employeeDao = employeeDao;
		this.personDao = personDao;
	}
	
	@Override
	public Employee save(Employee e) {
		Person p = new Person();
		employeeDao.save(e);
		personDao.save(p);
		return employeeDao.findById(e.getBusinessentityid());
	}

	@Override
	public Employee update(Employee e) {
		return employeeDao.update(e);
	}

	@Override
	public void delete(Employee e) {
		employeeDao.delete(e);
	}

	@Override
	public Iterable<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		return employeeDao.findById(id);
	}


}
