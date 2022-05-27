package com.sebas.taller.web.interfaces;

import com.sebas.taller.model.hr.Employee;

public interface EmployeeRestController {

	public Iterable<Employee> findAll();
	public Employee findById(Integer id);
	public void save(Employee e);
	public void update(Employee e, Integer i);
	public void delete(Integer id);
}
