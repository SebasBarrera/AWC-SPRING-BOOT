package com.sebas.taller.dao.interfaces;

import java.util.List;

import com.sebas.taller.model.hr.Employee;

public interface EmployeeDao {
	public Employee save(Employee e);
	public Employee update(Employee e);
	public void delete (Employee e);
	public List<Employee> findAll();
	public Employee findById(Integer id);
	public boolean existsById(Integer id);
}
