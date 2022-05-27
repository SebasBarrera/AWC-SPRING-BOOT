package com.sebas.taller.service.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.taller.dao.interfaces.EmployeeDao;
import com.sebas.taller.model.hr.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	
	
	public EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImp(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public Employee save(Employee e) {
		return employeeDao.save(e);
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
