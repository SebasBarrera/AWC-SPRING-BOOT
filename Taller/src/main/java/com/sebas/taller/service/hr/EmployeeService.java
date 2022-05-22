package com.sebas.taller.service.hr;


import com.sebas.taller.model.hr.Employee;

public interface EmployeeService {
	public Employee save(Employee e);
	public Employee update(Employee e);
	public void delete (Employee e);
	public Iterable<Employee> findAll();
	public Employee findById(Integer id);
}
